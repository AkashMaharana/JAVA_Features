package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class GroupingByDemo {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Akash", "Production",
				Arrays.asList(new String[] { "Cricket", "Football", "Boxing" }), 30));

		studentList.add(new Student("Swati", "Mechanical",
				Arrays.asList(new String[] { "Badminton", "Football", "Table Tennis" }), 52));

		studentList.add(
				new Student("Prakash", "Industrial", Arrays.asList(new String[] { "Cricket", "Hockey", "Rugby" }), 43));

		studentList.add(new Student("Saswati", "Mechanical",
				Arrays.asList(new String[] { "Chess", "Volly Ball", "Fencing" }), 52));

		studentList.add(new Student("Krishna", "Mechanical",
				Arrays.asList(new String[] { "Badminton", "Volly Ball", "Fencing" }), 25));

		studentList.add(
				new Student("Kastrui", "Production", Arrays.asList(new String[] { "Chess", "Rugbuy", "Fencing" }), 25));

		System.out.println("---------------------Group By 1-------------------------");
		Map<String, List<Student>> groupBy1 = studentList.stream().collect(Collectors.groupingBy(Student::getCourse));

		groupBy1.forEach((key, value) -> {
			System.out.print(key + " : ");
			for (Student s : value) {
				System.out.print(s.getName() + " ");
			}
			System.out.println();
		});

		System.out.println("---------------------Group By 2-------------------------");
		Map<String, Map<String, List<Student>>> groupBy2 = studentList.stream().collect(Collectors.groupingBy(
				Student::getCourse,
				Collectors.groupingBy(student1 -> student1.getNumberOfNoteBooks() > 30 ? "Excellent" : "Good")));

		groupBy2.forEach((key, value) -> {
			System.out.print(key + " : {");
			value.forEach((key1, value1) -> {
				System.out.print(key1 + " : ");
				for (Student s : value1) {
					System.out.print(s.getName() + " ");
				}
			});
			System.out.print(" }");
			System.out.println();
		});

		System.out.println("---------------------Group By 3-------------------------");
		Map<String, Map<Integer, List<Student>>> groupBy3 = studentList.stream().collect(
				Collectors.groupingBy(Student::getCourse, Collectors.groupingBy(Student::getNumberOfNoteBooks)));

		groupBy3.forEach((key, value) -> {
			System.out.print(key + " : {");
			value.forEach((key1, value1) -> {
				System.out.print(key1 + " : ");
				for (Student s : value1) {
					System.out.print(s.getName() + " ");
				}
			});
			System.out.print(" }");
			System.out.println();
		});

		System.out.println("---------------------Group By 4-------------------------");
		Map<String, Integer> groupBy4 = studentList.stream().collect(
				Collectors.groupingBy(Student::getCourse, Collectors.summingInt(Student::getNumberOfNoteBooks)));
		groupBy4.forEach((key, value) -> System.out.println(key + " : " + value));

		System.out.println("---------------------Group By 5-------------------------");
		Map<String, Set<Student>> groupBy5 = studentList.stream()
				.collect(Collectors.groupingBy(Student::getCourse, LinkedHashMap::new, Collectors.toSet()));
		groupBy5.forEach((key, value) -> {
			System.out.print(key + " : ");
			value.stream().forEach(value1 -> System.out.print(value1.getName() + " "));
			System.out.println();
		});

		System.out.println("---------------------Group By 6-------------------------");
		Map<String, Optional<Student>> groupBy6 = studentList.stream().collect(Collectors.groupingBy(Student::getCourse,
				Collectors.minBy(Comparator.comparing(Student::getNumberOfNoteBooks))));
		groupBy6.forEach((key,value)->{
			System.out.println(key+" : "+value.get().getName());
		});
		
		System.out.println("---------------------Group By 7-------------------------");
		//studentList.stream().collect(Collectors.groupingBy(Student::getCourse,Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::getNumberOfNoteBooks)))));
	}

}
