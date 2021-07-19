package collector;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import spliterator.Person;

public class Collector1 {

	public static void main(String[] args) {
		Person person1 = new Person("Arati Maharana", 42, "Mumbai");
		Person person2 = new Person("Akash Maharana", 35, "Bengaluru");
		Person person3 = new Person("Minati Maharana", 35, "Rourkela");
		Person person4 = new Person("Swati Maharana", 27, "Mumbai");
		Person person5 = new Person("Pranati Maharana", 63, "Kansbahal");
		List<Person> peopleList = Arrays.asList(person1, person2, person3, person4, person5);

		Optional<Person> maxAgePerson = peopleList.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Person::getAge)));
		System.out.println(maxAgePerson.get());

		double averageAge = peopleList.stream().collect(Collectors.averagingDouble(Person::getAge));
		System.out.println("Average age : " + averageAge);

		String names = peopleList.stream().map(Person::getName).collect(Collectors.joining(","));
		System.out.println("Names : " + names);

		Set<String> nameSet = peopleList.stream().map(Person::getName).collect(Collectors.toSet());
		System.out.println("Name Set : " + nameSet);

		TreeSet<String> nameTreeSet = peopleList.stream().map(Person::getName)
				.collect(Collectors.toCollection(() -> new TreeSet<String>()));
		System.out.println("Name Tree Set : " + nameTreeSet);

		Map<Boolean, List<Person>> peopleByAge = peopleList.stream()
				.collect(Collectors.partitioningBy(person -> person.getAge() > 30));
		System.out.println("People by Age : " + peopleByAge);

		Map<Integer, List<Person>> peopleByAgeGrouping = peopleList.stream()
				.collect(Collectors.groupingBy(Person::getAge));
		System.out.println("Peoplee by Age Grouping : " + peopleByAgeGrouping);

		Map<Integer, Long> peopleCountByAgeGrouping = peopleList.stream()
				.collect(Collectors.groupingBy(Person::getAge,Collectors.counting()));
		System.out.println(peopleCountByAgeGrouping);
		
		Map<Integer, String> peopleCountByAgeGroupingLong = peopleList.stream()
				.collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(Person::getName,Collectors.joining(","))));
		System.out.println(peopleCountByAgeGroupingLong);
		
		Map<Integer, TreeSet<String>> peopleCountByAgeGroupingTree = peopleList.stream()
				.collect(Collectors.groupingBy(person->person.getAge()
						,Collectors.mapping(person->person.getName(),Collectors.toCollection(()->new TreeSet<String>()))));
		System.out.println(peopleCountByAgeGroupingTree);
	}

}
