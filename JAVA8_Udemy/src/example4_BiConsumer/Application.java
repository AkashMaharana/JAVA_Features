package example4_BiConsumer;

import java.util.List;
import java.util.function.BiConsumer;

public class Application {

	public static void main(String[] args) {
		BiConsumer<String, List<String>> biConsumer = (name, activities) -> System.out
				.println(name + " : " + activities);
		List<StudentBiConsumer> studentList = StudentRegistration.getstudentListBiConsumer();
		studentList.forEach(studentBi -> biConsumer.accept(studentBi.getStudentName(), studentBi.getActivities()));
	}

}
