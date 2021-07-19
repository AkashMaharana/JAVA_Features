package example25_TerminalOperation;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {
		// collect
		System.out.println(
				Student.getListOfStudents().stream().map(Student::getStudentName).collect(Collectors.joining()));

		System.out.println(
				Student.getListOfStudents().stream().map(Student::getStudentName).collect(Collectors.joining("-")));

		System.out.println(Student.getListOfStudents().stream().map(Student::getStudentName)
				.collect(Collectors.joining("-", "(", ")")));

		long number = Student.getListOfStudents().stream().filter(student -> student.getNumberOfNoteBooks() > 50)
				.collect(Collectors.counting());
		System.out.println("Number of students having more than 50 notebook : " + number);

		// mapping
		Set<String> nameList = Student.getListOfStudents().stream()
				.collect(Collectors.mapping(Student::getStudentName, Collectors.toSet()));
		System.out.println("Name Set : " + nameList);

		List<List<String>> list = Student.getListOfStudents().stream()
				.collect(Collectors.mapping(Student::getActivities, Collectors.toList()));
		System.out.println(list);

		// minby & maxby
		Optional<Student> minStudent = Student.getListOfStudents().stream()
				.collect(Collectors.minBy(Comparator.comparing(Student::getNumberOfNoteBooks)));
		System.out.println("Student having minimum number of note book : " + minStudent.get().getStudentName());

		Optional<Student> maxStudent = Student.getListOfStudents().stream()
				.collect(Collectors.maxBy(Comparator.comparing(Student::getNumberOfNoteBooks)));
		System.out.println("Student having maximum number of note book : " + maxStudent.get().getStudentName());

		// summingInt && summingAverage
		int totalNoteBooks = Student.getListOfStudents().stream()
				.collect(Collectors.summingInt(Student::getNumberOfNoteBooks));
		System.out.println("Total number of note books : " + totalNoteBooks);

		double totalNoteBooksAverage = Student.getListOfStudents().stream()
				.collect(Collectors.averagingInt(Student::getNumberOfNoteBooks));
		System.out.println("Total number of note books on average : " + totalNoteBooksAverage);

		// grouping by
		Map<String, List<Student>> groupByMap = Student.getListOfStudents().stream()
				.collect(Collectors.groupingBy(Student::getDesignation));
		System.out.println(groupByMap);

		Map<String, List<Student>> studentGroupByMap = Student.getListOfStudents().stream().collect(Collectors
				.groupingBy(student -> student.getDesignation().equals("SSE") ? "Technical" : "Non Technical"));
		System.out.println(studentGroupByMap);
		System.out.println("-------------------");
		
		// two level grouping
		Map<String, Map<String, List<Student>>> groupByMapTwoLevel = Student.getListOfStudents().stream()
				.collect(Collectors.groupingBy(Student::getDesignation,
						Collectors.groupingBy(student -> student.getNumberOfNoteBooks() > 50 ? "Good" : "Average")));
		System.out.println(groupByMapTwoLevel);

		Map<String, Integer> groupByMapLevel = Student.getListOfStudents().stream().collect(
				Collectors.groupingBy(Student::getStudentName, Collectors.summingInt(Student::getNumberOfNoteBooks)));
		System.out.println(groupByMapLevel);

		// three level grouping
		LinkedHashMap<String, Set<Student>> studentSet = Student.getListOfStudents().stream()
				.collect(Collectors.groupingBy(Student::getDesignation, LinkedHashMap::new, Collectors.toSet()));
		System.out.println(studentSet);
		System.out.println("-------------------");
		
		
		// grouppingBy with minBy
		Map<String, Optional<Student>> groupByMinOptoinal = Student.getListOfStudents().stream()
				.collect(Collectors.groupingBy(Student::getDesignation,
						Collectors.minBy(Comparator.comparing(Student::getNumberOfNoteBooks))));
		System.out.println(groupByMinOptoinal);

		// grouping with minBy & collectingAndThen
		Map<String, Student> studentMapByOptional = Student.getListOfStudents().stream()
				.collect(Collectors.groupingBy(Student::getDesignation, Collectors.collectingAndThen(
						Collectors.minBy(Comparator.comparing(Student::getNumberOfNoteBooks)), Optional::get)));
		System.out.println(studentMapByOptional);

		// partition by
		Predicate<Student> noteBookPredicate = student -> student.getNumberOfNoteBooks() > 35;
		Map<Boolean, List<Student>> studentPartition = Student.getListOfStudents().stream()
				.collect(Collectors.partitioningBy(noteBookPredicate));
		System.out.println(studentPartition);
		
		Map<Boolean, Set<Student>> studentPartition1 = Student.getListOfStudents().stream()
				.collect(Collectors.partitioningBy(noteBookPredicate,Collectors.toSet()));
		System.out.println(studentPartition1);
	}

}
