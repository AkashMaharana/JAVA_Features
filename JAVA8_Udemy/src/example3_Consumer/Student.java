package example3_Consumer;

import java.util.List;

public class Student {

	private String studentName;
	private Integer studentId;
	private String role;
	private List<String> activities;

	public Student(String studentName, Integer studentId, String role, List<String> activities) {
		this.studentName = studentName;
		this.studentId = studentId;
		this.role = role;
		this.activities = activities;
	}

	public String getStudentName() {
		return studentName;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public String getRole() {
		return role;
	}

	public List<String> getActivities() {
		return activities;
	}

}
