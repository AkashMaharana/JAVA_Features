package example14_Constructor_Reference;

public class Student {

	private String studentName;
	private String designation;

	public Student() {

	}

	public Student(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentName() {
		return studentName;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", designation=" + designation + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
