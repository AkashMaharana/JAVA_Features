package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {

	public static void main(String[] args) {
		Stream.empty();
		Stream.of("One");
		Stream.of("One", "Two", "Three");
		Stream.generate(() -> "One");
		Stream.iterate("+", value -> value + "+");
		
		IntStream streamOfIntegers = ThreadLocalRandom.current().ints();
		streamOfIntegers.limit(5).forEach(System.out::println);
		
		System.out.println();

		// A stream on the letters of a string (ASCII code will be there in the stram)
		IntStream stream = "hello".chars();
		stream.forEach(System.out::println); // (104,101,108,108,111)

		System.out.println();

		// A stream on a regular expression
		Stream<String> words = Pattern.compile(",").splitAsStream("Welcome,to,geeks,for,geeks");
		words.forEach(System.out::println);

		System.out.println();

		// A stream on the lines of a text file
		String fileName = "c://Users//Administrator//OneDrive//Desktop//JAVA_LLD_Refactor_Codebase//"
				+ "JAVA8_Pluralsight_Part1//src//stream//Demo.txt";
		try (Stream<String> outputStream = Files.lines(Paths.get(fileName))) {
			outputStream.forEach(System.out::println);
		} catch (IOException e) {
			e.getMessage();
		}

		System.out.println();

		Stream.Builder<String> builder = Stream.builder();
		builder.add("One").add("Two").add("Three").add("Four");
		// No more parameters we can add as accept won't return anything
		builder.accept("Five");
		Stream<String> builderStream = builder.build();
		// No more parameters can be added to the builder once it is builded.
		// builder.accept("Knapsack"); : Illegal
		builderStream.forEach(System.out::println);
		
		
	}

}
