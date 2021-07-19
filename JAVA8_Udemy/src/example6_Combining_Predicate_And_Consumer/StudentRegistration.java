package example6_Combining_Predicate_And_Consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRegistration {
	
	public static List<StudentCombine> getstudentListCombine(){
		List<StudentCombine> list=new ArrayList<>();
		list.add(new StudentCombine("Akash",1,"SSE",Arrays.asList("Athletic","Volleyball")));
		list.add(new StudentCombine("Swati",2,"ETL",Arrays.asList("Cricket","Baseball")));
		list.add(new StudentCombine("Pranati",3,"ETL",Arrays.asList("Mountain Biking","Rock Climbing")));
		list.add(new StudentCombine("Arati",4,"BA",Arrays.asList("Zumba","Need For Speed")));
		list.add(new StudentCombine("Minati",5,"SE",Arrays.asList("Piloxing")));
		return list;
	}

}
