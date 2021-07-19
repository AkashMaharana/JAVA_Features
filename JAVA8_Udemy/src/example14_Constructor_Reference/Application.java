package example14_Constructor_Reference;

import java.util.function.Function;
import java.util.function.Supplier;

public class Application {
	
	public static void main(String[] args) {
		Function<String,Student> studentFunction=Student::new;
		System.out.println(studentFunction.apply("Akash"));
		
		Supplier<Student> studentSupplier=Student::new;
		System.out.println(studentSupplier.get());
	}

}
