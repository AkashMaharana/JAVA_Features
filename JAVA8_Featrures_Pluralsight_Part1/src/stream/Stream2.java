package stream;

import java.util.ArrayList;
import java.util.List;

import comparator.Person;

public class Stream2 {

	public static void main(String[] args) {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person(4, "Arati Maharana", 34));
		personList.add(new Person(1, "Akash", 26));
		personList.add(new Person(5, "Minati Maharana", 42));
		personList.add(new Person(2, "swati Maharana", 28));
		personList.add(new Person(3, "Pranati Maharana", 32));

		// peek is used to see the intermediate result while processing the data
		// forEach can't be used here as it is taking a consumer as input and won't
		// return anything
		personList.stream().map(Person::getAge).peek(System.out::println).filter(age -> age > 30)
				.forEach(System.out::println);

		// peek can't be used as a replacement to forEach. Because for Each is a
		// terminal operation but peek is an intermediate
		// operation. If we will execute the below code it will compile fine but won't
		// print anything in the console.
		personList.stream().map(Person::getAge).peek(System.out::println).filter(age -> age > 30)
				.forEach(System.out::println);

		System.out.println();

		personList.stream().skip(2).limit(2).filter(person -> person.getAge() > 20).forEach(System.out::println);

	}

}
