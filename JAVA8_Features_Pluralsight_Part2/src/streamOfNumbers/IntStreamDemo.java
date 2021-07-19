package streamOfNumbers;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import spliterator.Person;

public class IntStreamDemo {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Arati Maharana", 4, "Mumbai"));
		personList.add(new Person("Akash", 1, "Bengaluru"));
		personList.add(new Person("Minati Maharana", 5, "Rourkela"));
		personList.add(new Person("swati Maharana", 2, "Mumbai"));
		personList.add(new Person("Pranati Maharana", 3, "Kansbahal"));
		
		OptionalDouble average=personList.stream().mapToInt(Person::getAge).filter(age->age>30).average();
		int sum=personList.stream().mapToInt(Person::getAge).filter(age->age>30).sum();
		OptionalInt max=personList.stream().mapToInt(Person::getAge).filter(age->age>30).max();
		OptionalInt min=personList.stream().mapToInt(Person::getAge).filter(age->age>30).min();
		IntSummaryStatistics Statistics=personList.stream().mapToInt(Person::getAge).filter(age->age>30).summaryStatistics();
		
		System.out.println("Sum : "+sum);
		System.out.println("Min : "+min);
		System.out.println("Max : "+max);
		System.out.println("Statistics : "+Statistics);
		System.out.println(average.isPresent());
	}

}
