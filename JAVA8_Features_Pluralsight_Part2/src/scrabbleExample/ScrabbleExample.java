package scrabbleExample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class ScrabbleExample {

	private static int[] scoreTable = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4,
			10 };

	public static void main(String[] args) throws IOException {
		String filePath1 = "c://Users//Administrator//OneDrive//Desktop//JAVA_LLD_Refactor_Codebase//"
				+ "JAVA8_Pluralsight_Part1//src//stream//Word1.txt";
		Set<String> outputStream1 = Files.lines(Paths.get(filePath1)).map(word -> word.toLowerCase())
				.collect(Collectors.toSet());

		String filePath2 = "c://Users//Administrator//OneDrive//Desktop//JAVA_LLD_Refactor_Codebase//"
				+ "JAVA8_Pluralsight_Part1//src//stream//Word2.txt";
		Set<String> outputStream2 = Files.lines(Paths.get(filePath2)).map(word -> word.toLowerCase())
				.collect(Collectors.toSet());

		Function<String, Integer> score = word -> word.chars().map(letter -> scoreTable[letter - 'a']).sum();

		ToIntFunction<String> intScore=word->word.chars().map(letter->scoreTable[letter-'a']).sum();

		String word = outputStream1.stream().filter(word1 -> outputStream2.contains(word1))
				.max(Comparator.comparing(score)).get();

		String word1 = outputStream1.stream().filter(outputStream2::contains).min(Comparator.comparing(score)).get();
		
		IntSummaryStatistics word2=outputStream1.stream().filter(outputStream2::contains)
				.mapToInt(intScore).summaryStatistics();

		System.out.println(word);
		System.out.println(word1);
		System.out.println(word2);
	}

}
