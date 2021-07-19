package example16_FlatMap_Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {

	private String studentName;
	private String designation;
	private List<String> activities;

	public Student(String studentName, String designation, List<String> activities) {
		this.studentName = studentName;
		this.designation = designation;
		this.activities = activities;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getDesignation() {
		return designation;
	}

	public List<String> getActivities() {
		return activities;
	}
	
	public static List<Student> getListOfStudents(){
		List<Student> list=new ArrayList<>();
		list.add(new Student("Akash","SSE",Arrays.asList(new String[] {"Football","Baseball"})));
		list.add(new Student("Swati","ETL",Arrays.asList(new String[] {"Football","Hockey"})));
		list.add(new Student("Richi","L3 Support",Arrays.asList(new String[] {"Comedy","Fencing"})));
		list.add(new Student("Rony","BA",Arrays.asList(new String[] {"Football","Cricket"})));
		return list;
	}

}
