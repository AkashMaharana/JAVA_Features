package example3_Consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRegistration {
	
	public static List<Student> getstudentList(){
		List<Student> list=new ArrayList<>();
		list.add(new Student("Akash",1,"SSE",Arrays.asList("Athletic","Volleyball")));
		list.add(new Student("Swati",2,"ETL",Arrays.asList("Cricket","Baseball")));
		list.add(new Student("Pranati",3,"ETL",Arrays.asList("Mountain Biking","Rock Climbing")));
		list.add(new Student("Arati",4,"BA",Arrays.asList("Zumba","Need For Speed")));
		list.add(new Student("Minati",5,"SE",Arrays.asList("Piloxing","HIT")));
		return list;
	}

}
