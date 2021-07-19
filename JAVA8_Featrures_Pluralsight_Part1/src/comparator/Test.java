package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// Comparator<Person> ageComparator=(p1,p2)->p1.getAge().compareTo(p2.getAge());

		// Function<Person,String> nameFunction=Person::getName;
		// Function<Person,Integer> ageFunction=Person::getAge;

		List<Person> personList = new ArrayList<>();
		personList.add(new Person(1, "Akash", 20));
		personList.add(new Person(1, "Prakash", 30));
		personList.add(new Person(1, "Bikash", 13));
		personList.add(new Person(1, "Rakesh", 26));
		personList.add(new Person(1, "Anupama", 39));
		personList.add(new Person(1, "Mahesweta", 9));
		personList.add(new Person(1, "Birbal", 9));

		// Collections.sort(personList,Comparator.comparing(ageFunction));

		// Collections.sort(personList,Comparator.comparing(ageFunction).thenComparing(Comparator.comparing(nameFunction)));

		// New style of writing comparator

		Collections.sort(personList,
				Comparator.comparing(Person::getAge).thenComparing(Comparator.comparing(Person::getName)));

		personList.stream().forEach(p -> System.out.println(p.getName()));

		System.out.println();
		
		Collections.sort(personList,
				Comparator.comparing(Person::getAge).thenComparing(Comparator.comparing(Person::getName)).reversed());
		;
		
		personList.stream().forEach(p -> System.out.println(p.getName()));

	}

}
