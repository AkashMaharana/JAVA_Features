package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparator.Person;

public class Map1 {
	
	public static void main(String[] args) {
		Map<String,List<Person>> map=new HashMap<>();
		List<Person> personList1=new ArrayList<>();
		personList1.add(new Person(1,"Akash",20));
		personList1.add(new Person(2,"Prakash",24));
		List<Person> personList2=new ArrayList<>();
		personList2.add(new Person(4,"Swati",65));
		personList2.add(new Person(5,"Vasudha",9));
		map.put("Wuhan", personList2);
		map.put("Bengaluru", personList2);
		
		//For each syntax of map
		map.forEach((city,personList)->System.out.println(city+" : "+personList.size()));
		
		//If the key is not present it will return a default value
		System.out.println(map.getOrDefault("India", new ArrayList<>()));
		
		//It will insert the record iff the key is not present. It won't override existing one.
		map.putIfAbsent("Wuhan", new ArrayList<>());
		
		System.out.println(map.getOrDefault("Wuhan", new ArrayList<>()));
		
		map.putIfAbsent("India", new ArrayList<>());
		
		map.forEach((city,personList)->System.out.println(city+" : "+personList.size()));
		
		//Replace the value for a certain key
		map.replace("India", personList2);
		
		map.forEach((city,personList)->System.out.println(city+" : "+personList.size()));
		
		//Replace the value with the new one iff both key and value combination is there
		map.replace("India", personList2, personList1);
		
		//it will take one Bi-Function and replace all values with certain manipulation
		map.replaceAll((key,value)->new ArrayList<>());
		
		map.forEach((city,personList)->System.out.println(city+" : "+personList.size()));
		
		//It will remove a certain entry from map
		map.remove("India",new ArrayList<>());
		
		map.forEach((city,personList)->System.out.println(city+" : "+personList.size()));
	}

}
