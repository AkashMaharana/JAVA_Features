package collector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Collector2 {

	private static int[] scoreTable = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4,
			10 };

	public static void main(String[] args) throws IOException {
		String filePath1 = "c://Users//Administrator//OneDrive//Desktop//JAVA_LLD_Refactor_Codebase//"
				+ "JAVA8_Pluralsight_Part1//src//stream//Word1.txt";

		String filePath2 = "c://Users//Administrator//OneDrive//Desktop//JAVA_LLD_Refactor_Codebase//"
				+ "JAVA8_Pluralsight_Part1//src//stream//Word2.txt";

		Set<String> outputStream2 = Files.lines(Paths.get(filePath2)).map(word -> word.toLowerCase())
				.collect(Collectors.toSet());

		Map<Integer, List<String>> groupWordsByScore = Files.lines(Paths.get(filePath1)).collect(Collectors
				.groupingBy(word -> word.toLowerCase().chars().map(letter -> scoreTable[letter - 'a']).sum()));

		groupWordsByScore.entrySet().stream().sorted(Comparator.comparing(entry -> -entry.getKey())).limit(5)
				.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

		System.out.println();

		Map<Integer, List<String>> groupValidWordsByScore = Files.lines(Paths.get(filePath1))
				.filter(outputStream2::contains).collect(Collectors
						.groupingBy(word -> word.toLowerCase().chars().map(letter -> scoreTable[letter - 'a']).sum()));

		/*Map<Integer, List<String>> groupValidWordsByScore = Files.lines(Paths.get(filePath1)).filter(
				Files.lines(Paths.get(filePath2)).map(word -> word.toLowerCase()).collect(Collectors.toSet())::contains)
				.collect(Collectors
						.groupingBy(word -> word.toLowerCase().chars().map(letter -> scoreTable[letter - 'a']).sum()));*/

		groupValidWordsByScore.entrySet().stream().sorted(Comparator.comparing(entry -> -entry.getKey())).limit(5)
				.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

	}

}
