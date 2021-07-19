package example16_FlatMap_Comparator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {

		// When to use Flat Map
		List<List<String>> activityList = Student.getListOfStudents().stream().map(Student::getActivities)
				.collect(Collectors.toList());
		System.out.println(activityList);

		// Flat Map Demo
		List<String> activityList1 = Student.getListOfStudents().stream().map(Student::getActivities)
				.flatMap(List::stream).collect(Collectors.toList());
		System.out.println(activityList1);

		// Distinct element form stream
		List<String> distictActivityList = Student.getListOfStudents().stream().map(Student::getActivities)
				.flatMap(List::stream).distinct().collect(Collectors.toList());
		System.out.println(distictActivityList);

		// Count number of elements after manipulation
		long activityCount = Student.getListOfStudents().stream().map(Student::getActivities).flatMap(List::stream)
				.distinct().count();
		System.out.println("Activity Count : " + activityCount);

		// Comparator Traditional
		List<String> studentNameList = Student.getListOfStudents().stream().map(Student::getStudentName)
				.sorted((i1, i2) -> i1.compareTo(i2)).collect(Collectors.toList());
		System.out.println(studentNameList);

		// Comparator Using Stream
		List<String> studentNamecomparator = Student.getListOfStudents().stream()
				.sorted(Comparator.comparing(Student::getStudentName)).map(Student::getStudentName)
				.collect(Collectors.toList());
		System.out.println(studentNamecomparator);

		// Comparator Using Stream
		List<String> studentNamecomparatorReverseOrder = Student.getListOfStudents().stream()
				.sorted(Comparator.comparing(Student::getStudentName).reversed()).map(Student::getStudentName)
				.collect(Collectors.toList());
		System.out.println(studentNamecomparatorReverseOrder);

	}

}
