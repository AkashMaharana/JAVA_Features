package example5_Predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRegistration {
	
	public static List<StudentPredicate> getstudentListPredicate(){
		List<StudentPredicate> list=new ArrayList<>();
		list.add(new StudentPredicate("Akash",1,"SSE",Arrays.asList("Athletic","Volleyball")));
		list.add(new StudentPredicate("Swati",2,"ETL",Arrays.asList("Cricket","Baseball")));
		list.add(new StudentPredicate("Pranati",3,"ETL",Arrays.asList("Mountain Biking","Rock Climbing")));
		list.add(new StudentPredicate("Arati",4,"BA",Arrays.asList("Zumba","Need For Speed")));
		list.add(new StudentPredicate("Minati",5,"SE",Arrays.asList("Piloxing")));
		return list;
	}


}
