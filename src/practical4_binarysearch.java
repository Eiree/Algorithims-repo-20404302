import java.util.*;
import java.lang.*;

/**
 * Ronan O'Brien
 * 20404302
 * Practical 4
 */

@SuppressWarnings({"unused", "LoopConditionNotUpdatedInsideLoop"})
public class practical4_binarysearch{

    /**
     * Binary search is an efficient algorithm for finding an item within a sorted list of items.
     * It repeatedly divides a portion of the list in half which could potentially contain the item.
     * It narrows down to the last possible location if the item is not found.
     */

    /**
     * Sort: BinarySearch(array)
     * @param array Input array of type comparable.
     * @param elem key for binary search of type T.
     * @param comparator comparator variable for test.
     */

    public static <T extends Comparable<T>> int binarySearch(final T[] array, final T elem, final Comparator<T> comparator){
        if (comparator == null){ //nullcheck
            return binarySearch(array, elem, comparator);
        }
        //to and from index variables
        int low = 0;
        int high = array.length - 1;

        while (low <= high){
            int middle = (low+high) >>> 1; //right bit shift 1
            T middleValue = array[middle];
            int compare = comparator.compare(middleValue, elem); //compare middle of array to middle value
            if (compare < 0){
                low = middle + 1;
            } else if (compare > 0) {
                high = middle - 1;
            } else {
                return middle; //key
            }
        }
        return -(low + 1); //unable to find key
    }

    /**
     * Sort: BinarySearch(recursive)
     * @param array Input array of type comparable.
     * @param elem key for binary search of type T.
     * @param comparator comparator variable for testing.
     * @param low low index
     * @param high high index
     */

    public static <T extends Comparable<T>> int binarySearchRecursive(final T[] array, final T elem, int low, int high, final Comparator<T> comparator){
        if (low > high){
            return -1;
        }
        int middle = low+((high-low) / 2);
        if (array[middle].compareTo(elem) < 0){
            return binarySearchRecursive(array, elem, middle + 1, high, comparator); //recursive call if compare < 0
        } else if (array[middle].compareTo(elem) > 0){
            return binarySearchRecursive(array, elem, low, middle-1, comparator); // > 0
        } else {
            return middle; //index
        }
    }

    /**
     * Sort: BinarySearch(list)
     * @param list sorted input list of type comparable.
     * @param elem key for binary search of type T.
     * @param comparator comparator variable for testing.
     */

    public static <T extends Comparable<T>> int binarySearch(final List<T> list, final T elem, final Comparator<T> comparator){
        if (comparator == null){ //nullcheck
            return binarySearch(list, elem, comparator);
        }
        //to and from index variables
        int low = 0;
        int high = list.size()-1;

        while (low <= high){
            int middle = (low + high) >>> 1; //right shift bit 1
            T middleValue = list.get(middle);
            int compare = comparator.compare(middleValue, elem); //returns 0 or 1
            if (compare < 0){
                low = middle + 1;
            } else if (compare > 0){
                high = middle - 1;
            } else {
                return middle; //key
            }
        }
        return -(low + 1); //unable to find key
    }

    public static void main(String[] aargs){
        /*int SIZE = 8;
        Comparable[] x = new Integer[SIZE];
        for (int i = 0; i < SIZE; i++){
            x[i] = new Integer(i*2);
        }

        for (int i = 0; i < SIZE * 2; i++){
            System.out.println("Found " + i + " at " + binarySearchRecursive(x,1, 0, SIZE-1, 0));
        }*/


    }
}