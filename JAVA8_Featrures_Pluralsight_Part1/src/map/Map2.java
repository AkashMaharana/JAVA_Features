package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparator.Person;

public class Map2 {
	
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
		
		map.forEach((city,personList)->System.out.println(city+" : "+personList.size()));
		System.out.println();
		
		//Replace the value if the given key is there in the map else throw NullPointerException
		map.compute("Wuhan", (key,value)->value.size()>=2?new ArrayList<>():value);
		map.forEach((city,personList)->System.out.println(city+" : "+personList.size()));
		System.out.println();
		
		//Insert the new key value pair iff the key is not present in the map
		map.computeIfAbsent("India", value->new ArrayList<>());
		map.forEach((city,personList)->System.out.println(city+" : "+personList.size()));
		System.out.println();
		
		//Replace the value for the specified key but does not throw NullPointerException even if the key is not there
		map.computeIfPresent("Rourkela", (key,value)->value.size()>=2?new ArrayList<>():value);
		map.forEach((city,personList)->System.out.println(city+" : "+personList.size()));
		System.out.println();
		
		//It helps to add value to the speified collection as the method will return the replaced vale
		map.computeIfAbsent("Rourkela", key->new ArrayList<>()).add(new Person(10,"Richi",13));
		map.forEach((city,personList)->System.out.println(city+" : "+personList.size()));
	}

}
