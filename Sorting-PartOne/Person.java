import java.util.function.Function;
import java.util.Random;

/** A class made for testing sorting. **/

public class Person {
	/** First Name **/
	private String first;
	/** Last Name **/
	private String last;
	/** Some number value **/
	private Integer score;
	
	public static Random rand = new Random();
	
	/** 
	Functions that extract one element to use as sorting key.
	Any extracted type must implement Comparable (i.e. has compareTo defined).
	This approach was selected over passing the comparator, which is typical
	for Java sorting algorithms, because Counting sort does not compare items.
	**/
	
	public static Function<Person,String> extract_first = (x)->x.first();
	public static Function<Person,String> extract_last = (x)->x.last();
	public static Function<Person,Integer> extract_score = (x)->x.score();
	
	/** Constructor */
	public Person(String f, String l, Integer s) {
		first = f;
		last = l;
		score = s;
	}
	
	@Override
	public String toString() {
		return String.format("(%4d) %s %s",score,first,last);
	}
	
	/** Create an array of random persons for testing.
	@param size: Size of array AND the maximum score
	*/
	public static Person[] makeRandomArray(int size) {

		// Each person has a random string of 3 letters for first and last
		// And a random score in range of the size

		Person[] persons = new Person[size];
		for (int i=0; i<size; i++) {
			String first = "";
			first += (char) (rand.nextInt(26) + 'a');
			first += (char) (rand.nextInt(26) + 'a');
			first += (char) (rand.nextInt(26) + 'a');
		
			String last = "";
			last += (char) (rand.nextInt(26) + 'a');
			last += (char) (rand.nextInt(26) + 'a');
			last += (char) (rand.nextInt(26) + 'a');
		
			persons[i] = new Person(first, last, rand.nextInt(size));
		}
		return persons;
	} // end makeRandomArray
	
	// Only need the getters
	public String first() { return first; }
	public String last() { return last; }
	public Integer score() { return score; }
}