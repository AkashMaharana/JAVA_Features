package example4_BiConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRegistration {
	
	public static List<StudentBiConsumer> getstudentListBiConsumer(){
		List<StudentBiConsumer> list=new ArrayList<>();
		list.add(new StudentBiConsumer("Akash",1,"SSE",Arrays.asList("Athletic","Volleyball")));
		list.add(new StudentBiConsumer("Swati",2,"ETL",Arrays.asList("Cricket","Baseball")));
		list.add(new StudentBiConsumer("Pranati",3,"ETL",Arrays.asList("Mountain Biking","Rock Climbing")));
		list.add(new StudentBiConsumer("Arati",4,"BA",Arrays.asList("Zumba","Need For Speed")));
		list.add(new StudentBiConsumer("Minati",5,"SE",Arrays.asList("Piloxing","HIT")));
		return list;
	}

}
