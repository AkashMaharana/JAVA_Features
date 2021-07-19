package optional;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import spliterator.Person;

public class Optional1 {
	
	public static void main(String[] args) {
		Person person1 = new Person("Arati Maharana", 4, "Mumbai");
		Person person2 = new Person("Akash", 1, "Bengaluru");
		Person person3 = new Person("Minati Maharana", 5, "Rourkela");
		Person person4 = new Person("swati Maharana", 2, "Mumbai");
		Person person5 = new Person("Pranati Maharana", 3, "Kansbahal");
		List<Person> peopleList = Arrays.asList(person1, person2, person3, person4, person5);
		
		int maximum=peopleList.stream().map(Person::getAge).reduce(0,Integer::max);
		
		OptionalDouble avaerage=peopleList.stream().mapToInt(Person::getAge).average();
		
		System.out.println("Maximum : "+maximum);
		System.out.println("Average : "+avaerage.getAsDouble());
	}

}
	