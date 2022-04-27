import java.util.*;
import java.lang.*;

/**
 * Ronan O'Brien
 * 27/02/22 22:18
 * 20404302
 * Practical 3
 */
@SuppressWarnings({"unused", "unchecked", "LoopConditionNotUpdatedInsideLoop"})
public class practical3_sorting {

    public static <T extends Comparable<T>> boolean isSortedArray(T[] array){ //Checks array is sorted
        for (int i = 1; i < array.length; i++){
            if (array[i].compareTo(array[i-1]) > 0){ //check this after
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> boolean isSortedList(List<T> list){ //Checks list is sorted
        for (int i = 1; i < list.size(); i++){
            if (list.get(i).compareTo(list.get(i+1)) > 0){
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Sort: Bogosort
     * Worst Case: Unbounded
     * Average Case: O((n+1)!)
     * Best Case: Ω(n)
     *
     * Bogosort otherwise known as permutation sort, stupid sort, slow sort, shotgun sort or monkey sort.
     * This sort randomly generates permutations of the input and checks to see if the list is sorted.
     * This sort is purely sorted through chance. Overall the sort is very inefficient.
     * The best case being O(n) where the list is already in a sorted state and has an average performance of O((n+1)!).
     *
     * @param list/array Input list/array of type Comparable
     * @param comparator Comparator variable
     */

    public static <T extends Comparable<T>> void bogoSort(final List<T> list, final Comparator<T> comparator) {
        boolean sorted = false;
        Random gen = new Random();
        while(!isSortedList(list)) {
            for (int i = 0; i < list.size(); i++){
                int randPos = gen.nextInt(list.size());
                Collections.swap(list, i, randPos);
            }
        }
    }

    public static <T extends Comparable<T>> void bogoSort(final T[] array, final Comparator<T> comparator) {
        boolean sorted = false;
        Random gen = new Random();
        while(!isSortedArray(array)){
            for (int i = 0; i < array.length; i++){
                int randPos = gen.nextInt(array.length);
                swap(array, i, randPos);
            }
        }
    }

    /**
     * Sort: Bubble Sort
     * Worst Case: O(n^2)
     * Average Case:O(n^2)
     * Best Case: Ω(n)
     *
     * Bubble sort is a simple sorting algorithm that repeatedly steps through an array/list to be sorted.
     * It compares each adjacent elements and swaps them if their order is wrong.
     * Although this sorting algorithm is more efficient than others, it is actually very slow and impractical for most cases.
     * Bubble sort can be practical if the input is mostly sorted order.
     *
     * @param list/array Input list/array of type Comparable.
     * @param comparator Comparator variable.
     */
    public static <T extends Comparable<T>> void bubbleSort(final List<T> list, final Comparator<T> comparator) {
        for (int i = 0; i < list.size(); i++){ //loop for list size
            for (int j = 0; j < list.size() - 1; j++){ //nested loop
                if (list.get(j).compareTo(list.get(j+1)) > 0){ //compare list element to j+1
                    Collections.swap(list, j, j+1); //swap using collections lib
                }
            }
        }
    }

    public static <T extends Comparable<T>> void bubbleSort(final T[] array, final Comparator<T> comparator) {
        int length = array.length;
        T temp;
        for (int i = 0; i < length-1; i++){ //loop for length -1
            for (int j = 0; j < length-i-1; j++){
                if ( array[j].compareTo(array[j+1]) > 0){ //swap J+1 with J
                    swap(array, j, j+1);
                }
            }
        }
    }

    /**
     * Sort: Selection sort
     * Worst Case: O(n^2)
     * Average Case: O(n^2)
     * Best Case: Ω(n2)
     *
     * Selection sort is an in-place comparison sort. Its time complexity of O(n^2) making it inefficient for large scale data.
     * Selection sort divides the input list into two parts, the main list and the sublist.
     * The sublist is empty whilst the list is the entire input data. The algorithm process by finding the smallest/largest element in the unsorted list and swaps it with the leftmost unsorted element, which puts it in its correct place.
     * The sublist boundaries proceeds one element to the right.
     *
     * @param list/array Input list/array of type Comparable.
     * @param comparator Comparator variable.
     */

    public static <T extends Comparable<T>> void selectionSort(final List<T> list, final Comparator<T> comparator) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++){
            int mIndex = i;
            for (int j = i + 1; j < n; j++){
                if (list.get(j).compareTo(list.get(mIndex)) < 0){ //check
                    mIndex = j;
                }
            }
            Collections.swap(list, mIndex, i);
        }
    }

    public static <T extends Comparable<T>> void selectionSort(final T[] array, final Comparator<T> comparator) {
        int pos;
        T temp;
        for (int i = 0; i < array.length; i++){
            pos = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j].compareTo(array[pos]) < 0){ //< array[pos]
                    pos = j;
                }
            }
            swap(array, i, pos);
        }
    }

    /**
     * Sort: Merge sort
     * Worst Case: O(n log(n))
     * Average Case: O(n log(n))
     * Best Case: Ω(n log(n))
     *
     * Merge sort is efficient comparison-based sorting algorithm.
     * It uses a divide and conquer approach;
     * -Firstly it divides the unsorted list/array into sub-lists/arrays which each contain 1 element. (considered to be sorted)
     * -Then the sub-lists/arrays repeatedly merge to produce new sorted sub-lists/arrays until there is only 1 sublist left. This is the output of the merge sorting algorithm.
     *
     *
     * @param array/list Input list/array of type Comparable.
     * @param comparator Comparator variable.
     * @method mergeHelperArray This method creates the arrays to assist within the main method.
     * @param l Lower bounds for merge sort.
     * @param u Upper bounds for merge sort.
     * @param left Comparison element boundary to left.
     * @param right Comparison element boundary to right.
     * @method merge Helper function for merge sorting lists. Divides and initilises lists for use within main method.
     *
     */

    public static <T extends Comparable<T>> void mergeHelperArray(T[] array, T[] l, T[] u, int left, int right, Comparator<T> comparator){
        int i = 0, j = 0, x = 0;
        while(i < left && j < right){
            if (comparator.compare(l[i], u[j]) <= 0){ //compare results in 1 or 0
                array[x++] = l[i++];
            } else {
                array[x++] = u[j++];
            }
        }
        while(i<left){
            array[x++] = l[i++];
        }
        while(i<right){
            array[x++] = u[j++];
        }
    }

    public static <T extends Comparable<T>> void merge(List<T> array, List<T> l, List<T> u, int left, int right, Comparator<T> comparator){
        int i = 0, j = 0, y = 0;
        while (i < left && j < right){
            if (l.get(i).compareTo(u.get(i)) > 0){
                array.set(y++, l.get(i++));
            } else {
                array.set(y++, u.get(i));
            }
        }
        while(j < right){
            array.set(y++, u.get(j++));
        }
        while (i < left){
            array.set(y++, l.get(i++));
        }
    }

    public static <T extends Comparable<T>> void mergeSort(final List<T> list, final Comparator<T> comparator) {
        int n = list.size();
        if (n < 2){
            return;
        }
        int middle = (n / 2);
        List<T> l = new ArrayList<>();
        List<T> u = new ArrayList<>();
        for(int i = 0; i < middle; i++){
            l.add(list.get(i));
        }
        for (int i = middle; i < n; i++){
            u.add(list.get(i));
        }
        mergeSort(l, comparator);
        mergeSort(u, comparator);
        merge(list, l, u, middle, (n-middle), comparator);
    }

    public static <T extends Comparable<T>> void mergeSort(final T[] array, final Comparator<T> comparator) {
        if (array.length < 2){
            return;
        }
        int middle = (array.length / 2);
        T[] l = (T[]) new Comparable[middle];
        T[] r = (T[]) new Comparable[array.length - middle];
        for (int i = 0; i < middle; i++){
            l[i] = array[i];
        }
        for (int i = middle; i < array.length; i++){
            r[i-middle] = array[i];
        }
        mergeSort(l, comparator);
        mergeSort(r, comparator);
        mergeHelperArray(array, l, r, middle, (array.length-middle), comparator);
    }

    /**
     * Sort: Quick sort
     * Worst Case: O(n^2)
     * Average Case: O(n log(n))
     * Best Case: Ω(n log(n))
     *
     * Quicksort, often referred to as partition-exchange sort is an efficient sorting algorithm.
     * It uses a systematic method of placing elements into an array in order.
     * It is a comparison sort, thus it can sort items of any type with a "less-than" relationship.
     * The relative order of equal sort items is not preserved during the process.
     * It can operate in-place on an array which requires small amounts of memory to perform.
     *
     * @param list/array Input list/array of type Comparable
     * @param comparator Comparator variable
     * @method quickHelperList Main comparison helper method to pass towards the main method.
     * @param prev Previous comparison arg (input)
     * @param next Next comparison arg (input)
     * @method pi Partition method, which uses lower and upper bounds to swap elements and return sorted sub-lists/arrays.
     * @method quickHelper Helper method to return the sorted array/list and declare partitions correctly.
     */

    public static <T extends Comparable<T>> void quickHelperList(final List<T> list, int prev, int next, final Comparator<T> comparator){
        if (prev < next){
            int left = prev + 1;
            int right = next;
            int piv = prev;
            T pValue = list.get(piv);

            while (left <= right){
                while (left <= next && pValue.compareTo(list.get(left)) >= 0){
                    left++;
                }
                while (right <= next && pValue.compareTo(list.get(right)) >= 0){
                    right--;
                }
                if (left < right){
                    Collections.swap(list, left, right);
                }
            }
            Collections.swap(list, piv, left - 1);
            quickHelperList(list, prev, right - 1, comparator);
            quickHelperList(list, right + 1, next, comparator);
        }
    }

    public static <T extends Comparable<T>> void quickSort(final List<T> list, final Comparator<T> comparator) {
        quickHelperList(list, 0, list.size(), comparator);
    }

    public static <T extends Comparable<T>> int pi(T[] array, int lower, int upper, Comparator<T> comparator){
       T piv = array[upper];
       int i = (lower-1);
       for (int j = lower; j <= upper; j++){
           if (array[j].compareTo(piv) > 0){
               i++;
               swap(array, i, j);
           }
       }
       swap(array, i+1, upper);
       return i+1;
    }

    public static <T extends Comparable<T>> void quickHelper(T[] array, int lower, int upper, Comparator<T> comparator){
        if (lower < upper){
            int pi = pi(array, lower, upper, comparator); //recursive calls for helper
            quickHelper(array, lower, pi-1, comparator);
            quickHelper(array, pi + 1, upper, comparator);
        }
    }

    public static <T extends Comparable<T>> void quickSort(final T[] array, final Comparator<T> comparator) {
        quickHelper(array, 0, array.length, comparator);
    }

    public static void main(String[] aargs){
        //testing
    }
}
