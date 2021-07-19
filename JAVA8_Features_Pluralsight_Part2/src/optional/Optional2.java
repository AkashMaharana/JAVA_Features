package optional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Optional2 {
	
	public static void main(String[] args) {
		//Method-1
		List<Double> result=new ArrayList<>();
		ThreadLocalRandom.current().doubles(10000).boxed()
			.forEach(input->NewMath.inv(input)
					.ifPresent(inverse->NewMath.sqrt(inverse)
							.ifPresent(sqrt->result.add(sqrt))));
		System.out.println(result.size());
		
		
		//Method-2
		Function<Double,Stream<Double>> flatMapper =
				input->NewMath.inv(input)
				.flatMap(inverse->NewMath.sqrt(inverse))
				.map(sqrt->Stream.of(sqrt))
				.orElseGet(()->Stream.empty());

		List<Double> result1=ThreadLocalRandom.current()
			.doubles(10000)
			.boxed()
			.flatMap(flatMapper)
			.collect(Collectors.toList());
		System.out.println(result1.size());
	}

}
