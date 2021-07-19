package parallelDataProcessing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import spliterator.Person;

public class ParallelReduction {
	
	public static void main(String[] args) {
		Person person1 = new Person("Arati Maharana", 4, "Mumbai");
		Person person2 = new Person("Akash", 1, "Bengaluru");
		Person person3 = new Person("Minati Maharana", 5, "Rourkela");
		Person person4 = new Person("swati Maharana", 2, "Mumbai");
		Person person5 = new Person("Pranati Maharana", 3, "Kansbahal");
		List<Person> peopleList = Arrays.asList(person1, person2, person3, person4, person5);
		
		//With copyOnWriteArrayList
		List<Integer> ageList=new ArrayList<>();
		
		
		//Explanation
		peopleList.stream().parallel().forEach(person->ageList.add(person.getAge()));
		
		ageList.stream().forEach(System.out::println);
		
		ageList.stream().parallel().limit(1000).collect(Collectors.toList());
	}

}
