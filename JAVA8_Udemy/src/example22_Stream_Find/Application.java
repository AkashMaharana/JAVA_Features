package example22_Stream_Find;

import java.util.Optional;

public class Application {
	
	public static void main(String[] args) {
		Optional<String> findFirst=Student.getListOfStudents().stream().map(Student::getStudentName).filter(name->name.startsWith("A")).findFirst();
		Optional<String> findAny=Student.getListOfStudents().stream().map(Student::getStudentName).filter(name->name.startsWith("A")).findAny();
		System.out.println(findFirst.get());
		System.out.println(findAny.get());
	}

}
