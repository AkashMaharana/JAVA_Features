package example8_Function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Application {
	
	public static void main(String[] args) {
		Predicate<StudentFunction> p1=(student)->student.getStudentName().startsWith("A");
		
		Map<Integer,String> temp=new HashMap<>();
		Function<List<StudentFunction>, Map<Integer,String>> studentFunction=(students->{
			students.forEach(student->{
				if(p1.test(student)) {
					temp.put(student.getStudentId(), student.getStudentName());
				}	
			});
			return temp;
		});
		
		studentFunction.apply(StudentFunctionDatabase.getstudentListBiPredicate());
		System.out.println(temp);
	}

}
