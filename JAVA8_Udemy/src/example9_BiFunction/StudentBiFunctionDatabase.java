package example9_BiFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentBiFunctionDatabase {
	
	public static List<StudentBiFunction> getstudentListBiPredicate(){
		List<StudentBiFunction> list=new ArrayList<>();
		list.add(new StudentBiFunction("Akash",1,"SSE",Arrays.asList("Athletic","Volleyball")));
		list.add(new StudentBiFunction("Swati",2,"ETL",Arrays.asList("Cricket","Baseball")));
		list.add(new StudentBiFunction("Pranati",3,"ETL",Arrays.asList("Mountain Biking","Rock Climbing")));
		list.add(new StudentBiFunction("Arati",4,"BA",Arrays.asList("Zumba","Need For Speed")));
		list.add(new StudentBiFunction("Minati",5,"SE",Arrays.asList("Piloxing")));
		return list;
	}

}
