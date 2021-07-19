package example9_BiFunction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Application {

	public static void main(String[] args) {
		Map<Integer, String> temp = new HashMap<>();
		BiFunction<List<StudentBiFunction>, Predicate<StudentBiFunction>, Map<Integer, String>> studentBiFunction = 
				(studentList, studentPredicate) -> {
					studentList.forEach(student -> {
						if (studentPredicate.test(student)) {
							temp.put(student.getStudentId(), student.getStudentName());
						}
					});
			return temp;
		};
		
		Predicate<StudentBiFunction> p1=student->student.getStudentName().startsWith("A");
		studentBiFunction.apply(StudentBiFunctionDatabase.getstudentListBiPredicate(),p1);
		System.out.println(temp);
	}

}
