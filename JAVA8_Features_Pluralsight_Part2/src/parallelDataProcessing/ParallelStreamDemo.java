package parallelDataProcessing;

import java.util.ArrayList;
import java.util.List;

import spliterator.Person;

public class ParallelStreamDemo {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Arati Maharana", 4, "Mumbai"));
		personList.add(new Person("Akash", 1, "Bengaluru"));
		personList.add(new Person("Minati Maharana", 5, "Rourkela"));
		personList.add(new Person("swati Maharana", 2, "Mumbai"));
		personList.add(new Person("Pranati Maharana", 3, "Kansbahal"));

		/*
		 * IN parallel stream processing we can't preserve the order as it will be
		 * processed by multiple threads
		*/
		personList.parallelStream().forEach(System.out::println);
		System.out.println();	

		personList.stream().parallel().forEach(System.out::println);
		System.out.println();

		/*
		 * IN parallel stream processing if we want to preserve the same order then 
		 * sorted should be called with a comparator or the objects should be of comparable type
		*/
		personList.stream().parallel()
				.sorted((o1, o2) -> Integer.valueOf(o1.getAge()).compareTo(Integer.valueOf(o2.getAge())))
				.forEach(System.out::println);
		System.out.println();

		/*
		 * In normal processing we can preserve the order as it will be handled by a single thread
		*/
		personList.forEach(System.out::println);
		
		//Stateless Operation : No need to track the processing of elements
		personList.stream().forEach(System.out::println);
		
		/*
		 * Stateful Operation : We have to track the processing of 
		 * elements in order to get the number of 
		 * elements processed in this case
		*/ 
		personList.stream().skip(2).limit(3).forEach(System.out::println);

	}

}
