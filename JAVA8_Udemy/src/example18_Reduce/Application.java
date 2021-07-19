package example18_Reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Application {

	public static void main(String[] args) {
		List<Integer> list=Arrays.asList(1,3,4,5,6);
		Integer result1=list.stream().reduce(1,(a,b)->a*b);
		System.out.println("Multiplication : "+result1);
		Integer result2=list.stream().reduce(0,(a,b)->a+b);
		System.out.println("Sum : "+result2);
		
		Optional<String> studentName=Student.getListOfStudents().stream().reduce((s1,s2)->s1.getActivities().size()>
		s2.getActivities().size()?s1:s2).map(Student::getStudentName);
		if(studentName.isPresent()) {
			System.out.println(studentName.get());
		}
	}

}
