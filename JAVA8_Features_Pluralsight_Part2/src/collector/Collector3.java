package collector;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Collector3 {

	private static int[] scoreTable = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4,
			10 };
	private static int[] scrabbleEndDistribution = { 9, 2, 2, 1, 12, 2, 3, 2, 9, 1, 1, 4, 2, 6, 8, 2, 1, 6, 4, 6, 4, 2,
			2, 1, 2, 1 };

	public static void main(String[] args) throws Exception {
		String filePath1 = "c://Users//Administrator//OneDrive//Desktop//JAVA_LLD_Refactor_Codebase//"
				+ "JAVA8_Pluralsight_Part1//src//stream//Word1.txt";

		String filePath2 = "c://Users//Administrator//OneDrive//Desktop//JAVA_LLD_Refactor_Codebase//"
				+ "JAVA8_Pluralsight_Part1//src//stream//Word2.txt";

		Set<String> outputStream2 = Files.lines(Paths.get(filePath2)).map(word -> word.toLowerCase())
				.collect(Collectors.toSet());

		Function<String, Map<Integer, Long>> perWordCountMap = word -> word.chars().boxed()
				.collect(Collectors.groupingBy(letter -> letter, Collectors.counting()));

		Function<String, Long> noOfBlanks = word -> perWordCountMap.apply(word).entrySet().stream()
				.mapToLong(
						entry -> Long.max(entry.getValue() - (long) scrabbleEndDistribution[entry.getKey() - 'a'], 0L))
				.sum();
		System.out.println("No of blanks for whizzing : " + noOfBlanks.apply("whizzing"));

		Function<String, Integer> scoreWithBlank = word -> word.toLowerCase().chars()
				.map(letter -> scoreTable[letter - 'a']).sum();

		Function<String, Integer> scoreWithoutBlank = word -> perWordCountMap.apply(word).entrySet().stream()
				.mapToInt(entry -> scoreTable[entry.getKey() - 'a']
						* Integer.min(entry.getValue().intValue(), scrabbleEndDistribution[entry.getKey() - 'a']))
				.sum();
		
		System.out.println("Score with blank : "+scoreWithBlank.apply("whizzing"));
		System.out.println("Score without blank : "+scoreWithoutBlank.apply("whizzing"));
		
		System.out.println("Without blank");
		System.out.println("--------------------");
		
		Files.lines(Paths.get(filePath1))
				.filter(outputStream2::contains)
				.filter(word->noOfBlanks.apply(word)<=2)
				.collect(Collectors
						.groupingBy(scoreWithoutBlank)).entrySet().stream().sorted(Comparator.comparing(entry->-entry.getKey()))
				.limit(5)
				.forEach(entry->System.out.println(entry.getKey()+" : "+entry.getValue()));

	}

}
