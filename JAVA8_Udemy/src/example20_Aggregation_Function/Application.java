package example20_Aggregation_Function;

import java.util.Optional;

public class Application {

	public static void main(String[] args) {
		// max
		int maxNoteBook = Student.getListOfStudents().stream().map(Student::getNumberOfNoteBooks).reduce(0,
				(a, b) -> a > b ? a : b);
		System.out.println("Maximum Note Book : " + maxNoteBook);

		// max
		Optional<Integer> maxNoteBookOptional = Student.getListOfStudents().stream().map(Student::getNumberOfNoteBooks)
				.reduce((a, b) -> a > b ? a : b);
		if (maxNoteBookOptional.isPresent()) {
			System.out.println("Maximum Note Book Optional : " + maxNoteBookOptional.get());
		} else {
			System.out.println("List is empty.");
		}

		// min
		int minNoteBook = Student.getListOfStudents().stream().map(Student::getNumberOfNoteBooks).reduce(0,
				(a, b) -> a < b ? a : b);
		System.out.println("Minimum Note Book : " + minNoteBook);
		// hence it's a good practice to always use Optional. Otherwise there is a
		// possibility to get a wrong value.

		// min
		Optional<Integer> minNoteBookOptional = Student.getListOfStudents().stream().map(Student::getNumberOfNoteBooks)
				.reduce((a, b) -> a < b ? a : b);
		if (maxNoteBookOptional.isPresent()) {
			System.out.println("Minimum Note Book Optional : " + minNoteBookOptional.get());
		} else {
			System.out.println("List is empty.");
		}

		// Limit
		Optional<Integer> minNoteBookLimit = Student.getListOfStudents().stream().limit(3)
				.map(Student::getNumberOfNoteBooks).reduce((a, b) -> a > b ? a : b);
		if (maxNoteBookOptional.isPresent()) {
			System.out.println("Limit 3 : " + minNoteBookLimit.get());
		} else {
			System.out.println("List is empty.");
		}

		// Skip
		Optional<Integer> minNoteBookSkip = Student.getListOfStudents().stream().skip(3)
				.map(Student::getNumberOfNoteBooks).reduce((a, b) -> a > b ? a : b);
		if (maxNoteBookOptional.isPresent()) {
			System.out.println("Skip 3 : " + minNoteBookSkip.get());
		} else {
			System.out.println("List is empty.");
		}
	}

}
