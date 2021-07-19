package test;

import java.util.List;

public class Student {

	private String name;
	private String course;
	private List<String> activityList;
	private int numberOfNoteBooks;

	public Student(String name, String course, List<String> activityList, int numberOfNoteBooks) {
		this.name = name;
		this.course = course;
		this.activityList = activityList;
		this.numberOfNoteBooks = numberOfNoteBooks;
	}

	public String getName() {
		return name;
	}

	public String getCourse() {
		return course;
	}

	public List<String> getActivityList() {
		return activityList;
	}

	public int getNumberOfNoteBooks() {
		return numberOfNoteBooks;
	}

}
