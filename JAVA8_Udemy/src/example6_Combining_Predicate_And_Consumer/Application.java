package example6_Combining_Predicate_And_Consumer;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Application {
	
	public static void main(String[] args) {
		List<StudentCombine> studentList=StudentRegistration.getstudentListCombine();
		
		Predicate<StudentCombine> p1=(student)->student.getRole().equals("ETL");
		Predicate<StudentCombine> p2=(student)->student.getStudentName().startsWith("S");
		
		BiConsumer<String,List<String>> biConsumer=(name,activities)->System.out.println(name+":"+(activities));
		
		Consumer<StudentCombine> consumer=(student)->{if(p1.and(p2).test(student)) {
			biConsumer.accept(student.getStudentName(), student.getActivities());
		}};
		
		studentList.forEach(consumer);
	}

}
