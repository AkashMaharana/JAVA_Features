package spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.regex.Pattern;

public class SpliteratorWithMultipuleStream {
	
	public static void main(String[] args) throws IOException{
		String filePath1 = "c://Users//Administrator//OneDrive//Desktop//JAVA_LLD_Refactor_Codebase//"
				+ "JAVA8_Pluralsight_Part1//src//stream//Demo1.txt";
		Stream<String> outputStream1 = Files.lines(Paths.get(filePath1));
		
		String filePath2 = "c://Users//Administrator//OneDrive//Desktop//JAVA_LLD_Refactor_Codebase//"
				+ "JAVA8_Pluralsight_Part1//src//stream//Demo2.txt";
		Stream<String> outputStream2 = Files.lines(Paths.get(filePath2));
		
		String filePath3 = "c://Users//Administrator//OneDrive//Desktop//JAVA_LLD_Refactor_Codebase//"
				+ "JAVA8_Pluralsight_Part1//src//stream//Demo3.txt";
		Stream<String> outputStream3 = Files.lines(Paths.get(filePath3));
		
		Stream<Stream<String>> streamOfStreams = Stream.of(outputStream1,outputStream2,outputStream3);
		
		//Stream<String> streamOfLines=streamOfStreams.flatMap(stream->stream);
		Stream<String> streamOfLines=streamOfStreams.flatMap(Function.identity());
		
		Function<String,Stream<String>> lineSplitter=line->Pattern.compile(" ").splitAsStream(line);
		
		Stream<String> streamOfWords=streamOfLines.flatMap(lineSplitter).
				filter(word->word.length()==4).
				map(word->word.toLowerCase()).distinct();
		
		System.out.println(streamOfWords.count());
	}

}
