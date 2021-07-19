package example7_BiPredicate;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class Application {
	
	public static void main(String[] args) {
		List<StudentBiPredicate> studentList=StudentRegistration.getstudentListBiPredicate();
		
		BiPredicate<String,String> biPredicate=(role,name)->role.equals("ETL") && name.startsWith("S");
		BiConsumer<String,List<String>> biConsumer=(name,activities)->System.out.println(name+":"+activities);
		
		Consumer<StudentBiPredicate> consumer= (student->{
			if(biPredicate.test(student.getRole(), student.getStudentName())) {
				biConsumer.accept(student.getStudentName(), student.getActivities());
			}
		});
		
		studentList.forEach(consumer);
	}

}
