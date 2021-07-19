package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import comparator.Person;

public class Stream3 {
	
	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(4, "Arati Maharana", 34));
		personList.add(new Person(1, "Akash", 26));
		personList.add(new Person(5, "Minati Maharana", 42));
		personList.add(new Person(2, "swati Maharana", 28));
		personList.add(new Person(3, "Pranati Maharana", 32));
		
		// Short Circuiting terminal operation
		boolean anyMatch=personList.stream().anyMatch(person->person.getAge()>30);
		boolean allMatch=personList.stream().allMatch(person->person.getAge()>20);
		boolean noneMatch=personList.stream().noneMatch(person->person.getAge()>20);
		
		System.out.println("Any Match : "+anyMatch);
		System.out.println("All Match : "+allMatch);
		System.out.println("None Match : "+noneMatch);
		
		Optional<Person> filteredPerson1=personList.stream().filter(person->person.getAge()>20).findFirst();
		Optional<Person> filteredPerson2=personList.stream().filter(person->person.getAge()>20).findAny();
		
		System.out.println();
		System.out.println(filteredPerson1.get());
		System.out.println(filteredPerson2.get());
		
		
		
	}

}
