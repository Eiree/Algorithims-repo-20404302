# Algorithims-repo-20404302
COMP20290-Algorithms code repository
Ronan O'Brien 20404302


**Practical 3: (practical3_sorting)**


	Bogosort(list/array)
		-Time Complexity; 
			-Best: O(n)
			-Average: O((n+1)!)
			-Worst: Unbounded
		-Space Complexity: O(1)
Bogosort randomly generates permutations of the input and checks to see if the list is sorted. 

		
	-Bubblesort(list/array)
		-Time Complexity; 
			-Best: O(n)
			-Average: O(n^2)
			-Worst: O(n^2)
		-Space Complexity: O(1)
Bubble sort is a simple sorting algorithm that repeatedly steps through an array/list to be sorted.
    
	-selectionSort(list/array)
		-Time Complexity; 
			-Best:O(n*2)
			-Average:  O(n^2)
			-Worst: O(n^2)
		-Space Complexity: O(1)
Selection sort is an in-place comparison sort. Selection sort divides the input list into two parts.. the main list and the sublist. These lists are iterated and swapped until the element is in the correct place.
    
	-mergeSort(list/array)
		-Time Complexity; 
			-Best: O(n)
			-Average: O(n log(n))
			-Worst: O(n log(n))
		-Space Complexity: O(1)
Merge sort is efficient comparison-based sorting algorithm. It uses a divide and conquer approach. It divides the list into sublists that contain 1 element until there is 1 sublist left.


    
	-quickSort(list/array)
		-Time Complexity; 
			-Best: O(n log(n))
			-Average: O(n log(n))
			-Worst: O(n^2)
		-Space Complexity: O(1)
Quicksort uses a systematic method of placing elements into an array in order. It is a comparison sort, thus it can sort items of any type with a "less-than" relationship.

    
**Practical 4: (practical4_binarysearch)**


	-binarySearch(array)
		-Time Complexity;
			-Best: O(1)
			-Average: O(log N)
			-Worst: O(log N)
		-Space Complexity: O(1)
    
	-binarySearch(recursive)
		-Time Complexity;
			-Best: O(1)
			-Average: O(n2)
			-Worst: O(n2)
		-Space Complexity: O(log N)
    
	-binarySearch(list)
		-Time Complexity; 
			-Best: O(log n)
			-Average: O(n log n)
			-Worst: O(n log n)
		-Space Complexity: O(1)

    
**Practical 5: (practical5_stringsearch)**


	-stringSearch(Brute-Force)
		-Time Complexity; 
			-Best: O(M) //M being total number of comparisons
			-Average: O(n*M)
			-Worst: O(n*M)
		-Space Complexity: O(n)
    
	-stringSearch(Knuth-Morris-Prath)
		-Time Complexity; 
			-Best: O(k) //k is the length of the search term
			-Average: O(n)
			-Worst: O(n)
		-Space Complexity: O(m+n) or O(m) if there is pre-processing involved.


