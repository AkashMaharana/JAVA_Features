package example19_Filter_Map_Reduce;

public class Application {

	public static void main(String[] args) {
		int totalNumber = Student.getListOfStudents().stream().filter(student -> student.getStudentName().startsWith("A"))
				.map(Student::getNumberOfNoteBooks).reduce(0, (a, b) -> a + b);
		System.out.println(totalNumber);
	}

}
