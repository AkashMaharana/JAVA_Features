package example12_Method_Reference_Function;

import java.util.function.Function;

public class Application {
	
	public static void main(String[] args) {
		Function<String,String> methodReference=String::toUpperCase;
		System.out.println(methodReference.apply("akash"));
	}

}
