package spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreatingSpliterator {
	
	public static void main(String[] args) {
		String fileName = "c://Users//Administrator//OneDrive//Desktop//JAVA_LLD_Refactor_Codebase//"
				+ "JAVA8_Pluralsight_Part1//src//stream//Demo.txt";
		try (Stream<String> outputStream = Files.lines(Paths.get(fileName))){
			Spliterator<String> lineSpliterator=outputStream.spliterator();
			Spliterator<Person> peopleSpliterator=new PersonSpliterator(lineSpliterator);
			
			Stream<Person> people=StreamSupport.stream(peopleSpliterator, false);
			people.forEach(System.out::println);
		}catch (IOException e) {
			e.getMessage();
		}
	}

}
