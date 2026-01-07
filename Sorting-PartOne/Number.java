import java.util.function.Function;
import java.util.Random;

/** A class made for testing sorting. **/

public class Number {

	private Integer value;
	
	public static Random rand = new Random();
	
	/** 
	Function to extract the value to use as sorting key.
	This class replicates Integer, but it demonstrates the required elements
	of a class used with these sorting algorithms.
	*/
	public static Function<Number,Integer> extract_value = (x)->x.value();
	
	/** Constructor */
	public Number(Integer v) {
		value = v;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	/** Create an array of random integers for testing.
	@param size: Size of array AND the maximum score
	*/
	public static Number[] makeRandomArray(int size) {

		// Each number has a random value in range of size
		Number[] numbers = new Number[size];
		for (int i=0; i<size; i++) {
			numbers[i] = new Number(rand.nextInt(size));
		}
		return numbers;
	} // end makeRandomArray
	
	// Only need the getters
	public Integer value() { return value; }
}