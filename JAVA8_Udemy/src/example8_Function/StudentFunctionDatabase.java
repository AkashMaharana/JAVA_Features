package example8_Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentFunctionDatabase {
	
	public static List<StudentFunction> getstudentListBiPredicate(){
		List<StudentFunction> list=new ArrayList<>();
		list.add(new StudentFunction("Akash",1,"SSE",Arrays.asList("Athletic","Volleyball")));
		list.add(new StudentFunction("Swati",2,"ETL",Arrays.asList("Cricket","Baseball")));
		list.add(new StudentFunction("Pranati",3,"ETL",Arrays.asList("Mountain Biking","Rock Climbing")));
		list.add(new StudentFunction("Arati",4,"BA",Arrays.asList("Zumba","Need For Speed")));
		list.add(new StudentFunction("Minati",5,"SE",Arrays.asList("Piloxing")));
		return list;
	}

}
