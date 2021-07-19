package example15_Stream_Map;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String studentName;
	private String designation;

	public Student(String studentName, String designation) {
		this.studentName = studentName;
		this.designation = designation;
	}

	public static List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Akash", "SSE"));
		list.add(new Student("Swati", "ETL"));
		list.add(new Student("Kirtan", "Carpenter"));
		return list;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getDesignation() {
		return designation;
	}

}
