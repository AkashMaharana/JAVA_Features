package example11_Supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Application {
	
	public static void main(String[] args) {
		Supplier<String> supplier=()->"Akash";
		System.out.println(supplier.get());
		
		Supplier<List<String>> supplier1=()->{
			return Arrays.asList("Akash","Swati","Richi","Rony");
		};
		System.out.println(supplier1.get());
	}

}
