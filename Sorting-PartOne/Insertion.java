import java.util.Comparator;
import java.util.function.Function;

/** Classic Implementation of Insertion Sort (an in-place sorting algorithm) */
public class Insertion {

    /** Sort array (in-place) based on key extracted from keyGetter.
    @param array Array of any type to be sorted based on key
    @param keyGetter Function to extract sorting key from array element
    */
    public static <T,K extends Comparable<K>> void sort(T[] array, Function<T,K> keyGetter) {
    	// sort using "subarray" of entire array
    	sortSubarray(array,0,array.length-1,keyGetter);
    } 
    
    
    /** Sort in-place subarray [start:end] of passed array.
    @param array Array of any type to be sorted from [start:end] using key
    @param start leftmost index of subarray to be sorted
	@param end rightmost index of subarray to be sorted (INCLUSIVE)
	@param keyGetter function to extract key from array element
	*/
    public static <T,K extends Comparable<K>> void sortSubarray(T[] array, int start, int end, Function<T,K> keyGetter) {

		for(int j = start+1; j <= end; j++){
			// store the value currently trying to place
			T toPlace = array[j];
			K key = keyGetter.apply(toPlace);
			
			// iterate towards 0, shifting as appropriate
			int i = j-1;
			
			//Find and make room for Key in its sorted position
			while((i >= start) && (key.compareTo(keyGetter.apply(array[i])) < 0)){
				// shift it right to make space
				array[i+1] = array[i];
				i--;
			}
			// found the place to put the current element
			array[i+1] = toPlace;
		} // end for

    } // end sortSubarray(T[])
} // end class Insertion
