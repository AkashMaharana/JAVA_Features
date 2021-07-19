package example5_Predicate;

import java.util.List;
import java.util.function.Predicate;

public class Application {
	
	public static void main(String[] args) {
		Predicate<Integer> p1=(i)-> i%2==0;
		System.out.println(p1.test(8));
		System.out.println(p1.test(7));
		
		List<StudentPredicate> studentList=StudentRegistration.getstudentListPredicate();
		
		Predicate<StudentPredicate> p2=(student)->student.getStudentName().length()>5;
		Predicate<StudentPredicate> p3=(student)->student.getActivities().size()>=2;
		
		studentList.forEach(student->{if(p2.test(student)) {
			System.out.println(student.getStudentName());
		}});
		System.out.println();
		
		studentList.forEach(student->{if(p2.and(p3).test(student)) {
			System.out.println(student.getStudentName());
		}});
		System.out.println();
	}

}
