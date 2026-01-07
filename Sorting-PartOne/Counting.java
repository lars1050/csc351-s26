import java.lang.reflect.Array;
import java.util.function.Function;
import java.util.*;

/** Classic implementation of the non-comparative Counting Sort algorithm */
public class Counting {
	
	/** Sorts the array based on the key extracted with keyGetter.
	@param array Array of any type to be sorted.
	@param max_value Maximum value of all keys in the array.
	@param keyGetter Function<T,Integer> to extract key from each array element.
	@return None. The passed array will be sorted upon completion.
	*/
    public static <T> void sort(T[] array, Integer max_value, Function<T,Integer> keyGetter) {

		/*
		Counting sort is not an in-place sorting algorithm.
		To work around this, first the contents of array are copied
		into another array called "unsorted", which is the "A" array.
		*/		
		// claude recommendation (you cannot directly declare a T[] array)
    	@SuppressWarnings("unchecked")
    	T[] unsorted = (T[]) Array.newInstance(
        	array.getClass().getComponentType(), array.length);
		
		for (int i=0; i<array.length; i++) {
			unsorted[i] = array[i];
		}
		
		// Remember, to get the key of element [j]: keyGetter.apply(unsorted[j])
		
		// Create a histogram to keep track of all values in A
		
		// Accumulate indicies in histogram.
		// This indicates where to "seat" that value in the newly ordered array
		// WARNING: except they are off by +1 because of 0-based indexing!!!
		
		// Place elements from unsorted into array in their sorted position


    } // end sort(T[])
} // end class Counting
