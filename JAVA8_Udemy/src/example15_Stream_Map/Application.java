package example15_Stream_Map;

import java.util.List;
import java.util.stream.Collectors;

public class Application {
	
	public static void main(String[] args) {
		List<Student> list=Student.getAllStudents();
		List<String> temp=list.stream().map(Student::getStudentName).collect(Collectors.toList());
		System.out.println(temp);
	}

}
