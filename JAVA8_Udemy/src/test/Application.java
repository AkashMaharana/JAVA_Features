package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		studentList.add(
				new Student("Akash", "Production", Arrays.asList(new String[] { "Cricket", "Football", "Boxing" }),30));
		
		studentList.add(new Student("Swati", "Mechanical",
				Arrays.asList(new String[] { "Badminton", "Football", "Table Tennis" }),19));
		
		studentList.add(
				new Student("Prakash", "Production", Arrays.asList(new String[] { "Cricket", "Hockey", "Rugby" }),43));
		
		studentList.add(new Student("Saswati", "Mechanical",
				Arrays.asList(new String[] { "Chess", "Volly Ball", "Fencing" }),25));
		
		studentList.add(new Student("Krishna", "Mechanical",
				Arrays.asList(new String[] { "Badminton", "Volly Ball", "Fencing" }),25));
		
		studentList.add(new Student("Kastrui", "Mechanical",
				Arrays.asList(new String[] { "Chess", "Rugbuy", "Fencing" }),25));
		
		Map<String, String> studentMap = new HashMap<>();
		Predicate<String> studentPredicate = studentName -> studentName.startsWith("S");
		Function<List<Student>, Map<String, String>> studentFunction = listOfStudents -> {

			studentList.forEach(student -> {
				if (studentPredicate.test(student.getName())) {
					studentMap.put(student.getName(), student.getCourse());
				}
			});

			return studentMap;
		};
		studentFunction.apply(studentList);
		studentMap.forEach((key, value) -> System.out.println(key + " " + value));
		System.out.println("-------------------------------------------------");
		
		Optional<Student> student = studentList.stream().reduce((s1,s2)->s1.getName().length()>s2.getName().length()?s1:s2);
		if(student.isPresent()) {
			System.out.println(student.get().getName());
		}
		
		Optional<Student> student1 = studentList.stream().reduce((s1,s2)->s1.getName().compareTo(s2.getName())<0?s1:s2);
		if(student1.isPresent()) {
			System.out.println(student1.get().getName());
		}
		System.out.println("----------------------------------------------------");
		
		long count = studentList.stream().map(Student::getActivityList).flatMap(List::stream).distinct().count();
		System.out.println(count);
	}

}
