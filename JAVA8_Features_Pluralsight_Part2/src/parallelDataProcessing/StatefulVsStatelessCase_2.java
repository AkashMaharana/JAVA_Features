package parallelDataProcessing;

import java.util.Arrays;
import java.util.List;

import spliterator.Person;

public class StatefulVsStatelessCase_2 {

	public static void main(String[] args) {
		Person person1 = new Person("Arati Maharana", 4, "Mumbai");
		Person person2 = new Person("Akash", 1, "Bengaluru");
		Person person3 = new Person("Minati Maharana", 5, "Rourkela");
		Person person4 = new Person("swati Maharana", 2, "Mumbai");
		Person person5 = new Person("Pranati Maharana", 3, "Kansbahal");

		List<Person> peopleList = Arrays.asList(person1, person2, person3, person4, person5);

		/*
		 * Applying parallel stream on an immutable list of no use because anyway we have to preserve the order.
		 * It's a pitfall of using parallel stream on immutable list and it won't increase the performance as well.
		*/
		peopleList.stream().parallel().forEach(System.out::println);

		/*
		 * Applying parallel stream on an immutable list of no use because anyway we have to preserve the order.
		 * To make it parallel we should apply unordered on the immutable list in order to do a parallel processing.
		 * By doing unordered the ordered bit is reset to 0 and parallel processing can be done without preserving
		 * the order with a betters performance.
		*/
		peopleList.stream().parallel().unordered().forEach(System.out::println);
	}

}
