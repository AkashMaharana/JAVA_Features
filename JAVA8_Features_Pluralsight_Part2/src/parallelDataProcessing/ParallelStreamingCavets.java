package parallelDataProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamingCavets {

	public static void main(String[] args) {
		// Explanation
		Stream.iterate("+", input -> input + "+").limit(10).forEach(System.out::println);
		System.out.println();
		Stream.iterate("+", input -> input + "+").parallel().limit(10).forEach(System.out::println);
		
		//Explanation
		System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");
		Stream.iterate("+", input -> input + "+").parallel().limit(10)
				.peek(input -> System.out.println(Thread.currentThread().getName())).forEach(System.out::println);

		//Explanation
		List<String> listOfString=new ArrayList<>(); //Use of copyOnWriteArrayList
		Stream.iterate("+", input -> input + "+").parallel().limit(1000).forEach(input->listOfString.add(input));
		System.out.println("Size of list of strings : "+listOfString.size());
		
		//Explanation
		List<String> streamOfStrings = Stream.iterate("+", input -> input + "+").parallel().limit(1000)
				.collect(Collectors.toList());
		System.out.println(streamOfStrings.size());
	}

}
