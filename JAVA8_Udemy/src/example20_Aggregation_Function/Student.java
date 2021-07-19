package example20_Aggregation_Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {
	
	private String studentName;
	private String designation;
	private List<String> activities;
	private int numberOfNoteBooks;

	public Student(String studentName, String designation, List<String> activities,int numberOfNoteBooks) {
		this.studentName = studentName;
		this.designation = designation;
		this.activities = activities;
		this.numberOfNoteBooks=numberOfNoteBooks;
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
	
	

	public int getNumberOfNoteBooks() {
		return numberOfNoteBooks;
	}

	public static List<Student> getListOfStudents() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Akash", "SSE", Arrays.asList(new String[] { "Football", "Baseball", "Badminton" }),23));
		list.add(new Student("Swati", "ETL", Arrays.asList(new String[] { "Football", "Hockey" }),12));
		list.add(new Student("Richi", "L3 Support", Arrays.asList(new String[] { "Comedy", "Fencing" }),35));
		list.add(new Student("Rony", "BA", Arrays.asList(new String[] { "Football", "Cricket", "Boxing", "Moto GP" }),51));
		list.add(new Student("Akriti", "SSE", Arrays.asList(new String[] { "Volleyball", "Baseball" }),57));
		return list;
	}

}
