package customCollector;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomCollector1 {

	public static void main(String[] args) throws Exception {
		String filePath = "c://Users//Administrator//OneDrive//Desktop//JAVA_LLD_Refactor_Codebase//"
				+ "JAVA8_Pluralsight_Part1//src//stream//movies-mpaa.txt";

		Set<Movie> movies = new HashSet<>();

		Files.lines(Paths.get(filePath)).forEach((String line) -> {
			String[] elements = line.split("/");
			String title = elements[0].substring(0, elements[0].lastIndexOf("(")).trim();
			String releaseYear = elements[0].substring(elements[0].lastIndexOf("(") + 1, elements[0].lastIndexOf(")"));

			if (releaseYear.contains(",")) {
				return;
			}

			Movie movie = new Movie(title, Integer.valueOf(releaseYear));

			for (int i = 1; i < elements.length; i++) {
				String[] name = elements[i].split(", ");
				String lastName = name[0].trim();
				String firstName = "";
				if (name.length > 1) {
					firstName = name[1].trim();
				}

				Actor actor = new Actor(lastName, firstName); 
				movie.addActor(actor);
			}

			movies.add(movie);
		});

		// Number of actors
		long numberOfActors = movies.stream().flatMap(movie -> movie.getActors().stream()).distinct().count();
		System.out.println("Number of actors : " + numberOfActors);

		// Actor who played in highest number of movies
		Actor actor=movies.stream().flatMap(movie -> movie.getActors().stream())
				//.collect(Collectors.groupingBy(actor->actor, Collectors.counting()))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet()
				.stream()
				//.max(Comparator.comparing(entry->entry.getValue())).get().getKey();
				.max(Map.Entry.comparingByValue()).get().getKey();
		System.out.println("Actor who played in the highest number of movies : "+actor.getFirstName()+" "+actor.getLastName());
		
		/*// Actor who played in highest number of movies in a particular year
		movies.stream()
			.collect(
					Collectors.groupingBy(
							movie->movie.getReleaseYear(),
							Collector.of(
									()->new HashMap<Actor,AtomicLong>(),
									(map,movie)->{
										movie.getActors().forEach(
												actor->map.computeIfAbsent(actor, a->new AtomicLong()).incrementAndGet()
										);
							},
							(map1,map2)->{
								map2.entrySet().forEach(
									entry2->map1.merge(
											entry2.getKey(), entry2.getValue(), 
											(a1,a2)->{
												a1.addAndGet(a2.get());
												return a1;
											}
									)
							);
							return map1;
						},
						Collector.Characteristics.IDENTITY_FINISH
				)
				));*/
	}

}
