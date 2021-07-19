package example7_BiPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRegistration {
	
	public static List<StudentBiPredicate> getstudentListBiPredicate(){
		List<StudentBiPredicate> list=new ArrayList<>();
		list.add(new StudentBiPredicate("Akash",1,"SSE",Arrays.asList("Athletic","Volleyball")));
		list.add(new StudentBiPredicate("Swati",2,"ETL",Arrays.asList("Cricket","Baseball")));
		list.add(new StudentBiPredicate("Pranati",3,"ETL",Arrays.asList("Mountain Biking","Rock Climbing")));
		list.add(new StudentBiPredicate("Arati",4,"BA",Arrays.asList("Zumba","Need For Speed")));
		list.add(new StudentBiPredicate("Minati",5,"SE",Arrays.asList("Piloxing")));
		return list;
	}

}
