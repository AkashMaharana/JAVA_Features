package example23_Stream_Factory_Method;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Application {
	
	public static void main(String[] args) {
		Stream<String> stringStream=Stream.of("Akash","Maharana");
		stringStream.forEach(System.out::println);
		
		Stream.iterate(1, x->x*2).limit(10).forEach(System.out::println);
		
		Supplier<Integer> integerSupplier=new Random()::nextInt;
		Stream.generate(integerSupplier).limit(10).forEach(System.out::println);
	}

}
