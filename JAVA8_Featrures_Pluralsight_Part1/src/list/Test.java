package list;

import java.util.ArrayList;
import java.util.List;

import comparator.Person;

public class Test {
	
	public static void main(String[] args) {
		List<Person> personList=new ArrayList<>();
		personList.add(new Person(1,"Akash",20));
		personList.add(new Person(1,"Prakash",95));
		personList.add(new Person(1,"Sikha",16));
		personList.removeIf(person->person.getAge()>90);
		personList.stream().forEach(person->System.out.println(person.getName()+" : "+person.getAge()));
		
		System.out.println();
		
		List<String> list=new ArrayList<>();
		list.add("Akash");
		list.add("Bikash");
		list.add("Prakash");
		list.replaceAll(String::toUpperCase);
		list.stream().forEach(System.out::println);
		
		//replaceall
	}

}
