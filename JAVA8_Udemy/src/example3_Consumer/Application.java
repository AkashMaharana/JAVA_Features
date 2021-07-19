package example3_Consumer;

import java.util.List;
import java.util.function.Consumer;

public class Application {
	
	public static void main(String[] args) {
		List<Student> studentList=StudentRegistration.getstudentList();
		
		Consumer<String> consumer=(s)->System.out.println(s.toUpperCase());
		consumer.accept("akash");
		System.out.println();
		
		Consumer<Student> consumer2=(student)->System.out.println(student.getStudentId()+":"+
				student.getStudentName()+":"+student.getRole());
		 
		studentList.forEach(consumer2);
		System.out.println();
		
		Consumer<Student> consumer3=(student)->System.out.print(student.getStudentName()+" ");
		Consumer<Student> consumer4=(student)->System.out.println(student.getActivities()+" ");
		studentList.forEach(consumer3.andThen(consumer4));
		System.out.println();
		
		studentList.forEach(student->{if(student.getStudentName().length()>5) 
					{consumer3.andThen(consumer4).accept(student);}});
		System.out.println();
	}

}
