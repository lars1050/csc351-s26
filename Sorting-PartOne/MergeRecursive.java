import java.util.*;
import java.lang.reflect.Array;
import java.util.function.Function;

/** Classic implementation of Merge Sort */
class MergeRecursive {
	
	/** Sorts the array based on the key extracted with keyGetter.
	@param array Array of any type to be sorted.
	@param keyGetter Function to extract sorting key from each array element.
	@return None. The passed array will be sorted upon completion.
	*/
	public static <T,K extends Comparable<K>> void sort(T[] array, Function<T,K> keyGetter) {
		// call to recursive function to sort entire array
		mergeSort(array,0,array.length-1,keyGetter);
	} // end sort()
	
	/** Divide-and-Conquer recursive function to sort subarray.
	@param array Array to be sorted based on key
	@param start Leftmost index of subarray to be sorted
	@param end Rightmost index of subarray to be sorted
	@param keyGetter Function to extract key from array element
	*/
	public static <T,K extends Comparable<K>> void mergeSort(T[] array, int start, int end, Function<T,K> keyGetter) {
		// if not at the bottom of our recursion, keep dividing in half
		if (start < end) {
			int middle = (start+end)/2;
			mergeSort(array,start,middle,keyGetter);
			mergeSort(array,middle+1,end,keyGetter);
			merge(array,start,middle,end,keyGetter);	
		}
	} // end mergeSort
	
	/** Merge two sorted subarrays into one sorted subarray (in original array).
	@param array Array to be sorted by key 
	@param start Leftmost index of left subarray
	@param middle Last index of left subarray
	@param end Last index of right subarray
	@param keyGetter Function to extract key
	*/
	public static <T,K extends Comparable<K>> void merge(T[] array, int start, int middle, int end, Function<T,K> keyGetter) {
		
		/* 
		1) create two new arrays to hold sorted subarrays that will be merged
		*/
		
		int size_left = middle - start + 1;
		int size_right = end - middle;
		
		// claude recommendation (you cannot directly declare a T[] array)
    	@SuppressWarnings("unchecked")
    	T[] left = (T[]) Array.newInstance(
        	array.getClass().getComponentType(), size_left);
        	
        @SuppressWarnings("unchecked")
    	T[] right = (T[]) Array.newInstance(
        	array.getClass().getComponentType(), size_right);
		
		// copy array elements into temp left and right arrays
		int left_idx = 0;
		for (int i=start; i<=middle; i++) {
			left[left_idx] = array[i];
			left_idx++;
		}
		int right_idx = 0;
		for (int i=middle+1; i<=end; i++) {
			right[right_idx] = array[i];
			right_idx++;
		}
		
		/*
		2) Repeatedly check next element in each subarray to place back into
		original array in sorted order.
		*/
		
		// set pointers into first element in left and right
		left_idx = 0;
		right_idx = 0;
		
		// place elements of left and right back into original array [start:end]
		for (int i=start; i<=end; i++) {
			
			// are either index off the end? no need to compare
			if (right_idx >= size_right) {
				array[i] = left[left_idx];
				left_idx++;
			} else if (left_idx >= size_left) {
				array[i] = right[right_idx];
				right_idx++;
				
			} else {
				// whichever is less, place in array and move to next
				K left_value = keyGetter.apply(left[left_idx]);
				K right_value = keyGetter.apply(right[right_idx]);
				if ( left_value.compareTo(right_value) <= 0) {
					// left is less
					array[i] = left[left_idx];
					left_idx++;
				} else {
					// right is less
					array[i] = right[right_idx];
					right_idx++;
				}
			} // end else find minimum of the values
		} // end for int i
	} // end merge
} // end class MergeRecursive