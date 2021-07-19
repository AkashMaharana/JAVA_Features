package example24_Numeric_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application {
	
	public static void main(String[] args) {
		List<Integer> integerList=Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		System.out.println("Sum of all integers : "+integerList.stream().reduce(0,(a,b)->a+b));
		
		System.out.println("Sum using IntStream Range Closed: "+IntStream.rangeClosed(1, 6).sum());
		
		System.out.println("Sum using IntStream Range: "+IntStream.range(1, 6).sum());
		
		//Long Stream can be implemented in the same  way but Double can't
		
		System.out.println("Count : "+IntStream.range(1, 50).count());
		
		System.out.println("Count : "+IntStream.rangeClosed(1, 50).count());
		
		IntStream.range(0, 30).asDoubleStream().forEach(value->System.out.print(value+", "));
		
		OptionalInt optionalInt=IntStream.rangeClosed(1, 50).max();
		System.out.println(optionalInt.isPresent());
		System.out.println(optionalInt);
		
		System.out.println("Count : "+IntStream.rangeClosed(1, 50).average());
		
		System.out.println(integerList.stream().mapToDouble(Integer::doubleValue).sum());
	}

}
