import java.util.function.Function;

class TestSorting {
	
	public static void main(String[] args) {
	
		/** 
		As you complete the code, uncomment the call to test your
		sorting algorithm. You will be completing Merge Sort (an iterative version) and Counting Sort.
		**/
	
		testInsertionSort();
		//testMergeSortRecursive();
		//testMergeSortIterative();
		//testCountingSort();
	}
	
	public static void testInsertionSort() {
	
		System.out.println("\n______Testing Insertion Sort______");
	
		// the basics
		Integer[] array1 = {9,8,7,6,5,4,3,2,1,0};
		Insertion.sort(array1,(x)->x);
		System.out.print("\nIntegers Sorted: ");
		printArray(array1,false);
		
		// with class Number
		Number[] array2 = Number.makeRandomArray(25);
		Insertion.sort(array2,Number.extract_value);
		System.out.print("Numbers Sorted: ");
		printArray(array2,false);
		
		// with class Person -- first name
		Person[] array3 = Person.makeRandomArray(8);
		Insertion.sort(array3,Person.extract_first);
		System.out.println("Persons Sorted by First Name");
		printArray(array3,true);
		
		// Testing sorting a subarray
		Integer[] array4 = {9,1,7,6,5,4,1,1,1,9};
		Insertion.sortSubarray(array4,2,5,(x)->x);
		System.out.print("Integer Subarray [2:5] Sorted: ");
		printArray(array4,false);
		System.out.println();
	}
	
	public static void testMergeSortRecursive() {
		System.out.println("\n______Testing Merge Sort Recursive______");
	
		// the basics
		Integer[] array1 = {9,8,7,6,5,4,3,2,1,0};
		MergeRecursive.sort(array1,(x)->x);
		System.out.print("\nIntegers Sorted: ");
		printArray(array1,false);
		
		// with class Number
		Number[] array2 = Number.makeRandomArray(25);
		MergeRecursive.sort(array2,Number.extract_value);
		System.out.print("Numbers Sorted: ");
		printArray(array2,false);
		
		// with class Person -- first name
		Person[] array3 = Person.makeRandomArray(8);
		MergeRecursive.sort(array3,Person.extract_first);
		System.out.println("Persons Sorted by First Name");
		printArray(array3,true);
	}
	
	public static void testMergeSortIterative() {
		System.out.println("\n______Testing Merge Sort Iterative");
	
		// the basics
		Integer[] array1 = {9,8,7,6,5,4,3,2,1,0};
		MergeIterative.sort(array1,(x)->x);
		System.out.print("\nIntegers Sorted: ");
		printArray(array1,false);
		
		// with class Number
		Number[] array2 = Number.makeRandomArray(25);
		MergeIterative.sort(array2,Number.extract_value);
		System.out.print("Numbers Sorted: ");
		printArray(array2,false);
		
		// with class Person -- first name
		Person[] array3 = Person.makeRandomArray(8);
		MergeIterative.sort(array3,Person.extract_first);
		System.out.println("Persons Sorted by First Name");
		printArray(array3,true);
	}
	
	public static void testCountingSort() {
		System.out.println("\n______Testing Counting Sort");
	
		// the basics
		Integer[] array1 = {9,8,7,6,5,4,3,2,1,0};
		Counting.sort(array1,9,(x)->x);
		System.out.print("\nIntegers Sorted: ");
		printArray(array1,false);
		
		// with class Number
		Number[] array2 = Number.makeRandomArray(25);
		Counting.sort(array2,25,Number.extract_value);
		System.out.print("Numbers Sorted: ");
		printArray(array2,false);
		
		// with class Person -- score
		Person[] array3 = Person.makeRandomArray(8);
		Counting.sort(array3,8,Person.extract_score);
		System.out.println("Persons Sorted by Score");
		printArray(array3,true);
	}
	
	public static void printArray(Object[] array, boolean linefeed) {
		
		for (Object obj : array) {
			if (linefeed) {
				System.out.println(obj);
			} else {
				System.out.print(obj+" ");
			}
		}
		System.out.println();
	}
}

