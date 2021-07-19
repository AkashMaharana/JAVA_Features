package example21_Stream_Match;

public class Application {
	
	public static void main(String[] args) {
		//Match
		boolean anyMatch=Student.getListOfStudents().stream().map(Student::getStudentName).anyMatch(name->name.startsWith("A"));
		boolean noneMatch=Student.getListOfStudents().stream().map(Student::getStudentName).noneMatch(name->name.startsWith("K"));
		boolean allMatch=Student.getListOfStudents().stream().map(Student::getStudentName).allMatch(name->name.startsWith("A"));
		System.out.println("AnyMatch : "+anyMatch);
		System.out.println("AllMatch : "+allMatch);
		System.out.println("NoneMatch : "+noneMatch);
	}

}
