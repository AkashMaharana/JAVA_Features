package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparator.Person;

public class Map3 {

	public static void main(String[] args) {
		Map<String, List<Person>> map = new HashMap<>();
		List<Person> personList1 = new ArrayList<>();
		personList1.add(new Person(1, "Akash", 20));
		personList1.add(new Person(2, "Prakash", 24));
		List<Person> personList2 = new ArrayList<>();
		personList2.add(new Person(4, "Swati", 65));
		personList2.add(new Person(5, "Vasudha", 9));
		map.put("Wuhan", personList2);
		map.put("Bengaluru", personList2);

		Map<String, List<Person>> map1 = new HashMap<>();
		List<Person> personList3 = new ArrayList<>();
		personList3.add(new Person(3, "Janvi", 20));
		personList3.add(new Person(9, "Rony", 24));
		List<Person> personList4 = new ArrayList<>();
		personList4.add(new Person(7, "Pranati", 65));
		personList4.add(new Person(8, "Chandrama", 9));
		map1.put("Nadia", personList3);
		map1.put("Rourkela", personList4);

		map.forEach((city, personList) -> System.out.println(city + " : " + personList.size()));
		System.out.println();
		map1.forEach((city, personList) -> System.out.println(city + " : " + personList.size()));

		map1.forEach((key, value) -> map.merge(key, value, (v1, v2) -> {
			v1.addAll(v2);
			return v1;
		}));
		
		System.out.println();
		
		map.forEach((city, personList) -> System.out.println(city + " : " + personList.size()));

	}

}
