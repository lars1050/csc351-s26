import java.util.*;
import java.lang.reflect.Array;
import java.util.function.Function;

/** NOT the classic implementation of Merge Sort -- this is iterative */
class MergeIterative {

	/** Sorts the array based on the key extracted with keyGetter.
	@param array Array of any type to be sorted.
	@param keyGetter Function to extract sorting key from each array element.
	@return None. The passed array will be sorted upon completion.
	*/
	public static <T,K extends Comparable<K>> void sort(T[] array, Function<T,K> keyGetter) {
	} // end MergeIterative()
	
} // end class MergeIterative
	
/*
Recursive Merge Sort divides the array in half, in half, in half, ...
until the subarray is of size 1, then it merges 2 elements.
Then it merges subarrays of size 2 (4 elements).
Then it merges subarrays of size 4 (8 elements).

In this iterative version, we follow the same pattern.
In your first pass through the array, 
order all pairs array[0][1],array[2][3],[4][5], ... [n-1]
Then order those pairs array[0]..[3], array[4]..[7], ... [n-1]
Keep making passes through the array increasing subarray size each pass,
until you have merged the two n/2 sized subarrays (if n=2^x).

You will need additional space to copy the left & right subarrays
to then place them back into original array. BE EFFICIENT with space.
Creating generic type arrays looks like this:
@SuppressWarnings("unchecked")
T[] arrayCopy = (T[]) Array.newInstance(
	array.getClass().getComponentType(), n);

Ordering array elements is based on the key. Like this: keyGetter.apply(left[left_idx])).compareTo( 			keyGetter.apply(right[right_idx])) <= 0)

The size of the subarrays to be merged are powers of 2, which are the step size for a pass through the array (except when n is not a power of 2).

BEWARE arrays that are not powers of 2. Think through an array of size 10 -- how will you handle those extra 2 elements at the end? I recommend first writing code for an array of size 8 (or some 2^x), then fix it to handle any size.

The number of times you have to pass through the array to merge subarrays is based on log2(n), like this: int passes = (int) (Math.log(n) / Math.log(2));

It is useful to be explicit about your indices. There are a lot of them in this code. It is probably best to name them (for example, start or left_idx, as opposed to p or i) and double check their value -- super easy to be off by 1.

There are elements in the iterative version that also appear in the recursive version (which has been completed for you). Feel free to copy those elements into this algorithm.

*/

