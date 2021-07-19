package example17_Stream_Filter;

import java.util.List;
import java.util.stream.Collectors;

public class Application {

	public static void main(String[] args) {
		List<String> name = Student.getListOfStudents().stream()
				.filter(student -> student.getStudentName().startsWith("A")).map(Student::getActivities)
				.flatMap(List::stream).collect(Collectors.toList());
		System.out.println(name);
	}

}
