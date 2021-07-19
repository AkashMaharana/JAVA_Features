package parallelDataProcessing;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.concurrent.ForkJoinPool;

import spliterator.Person;

public class TuningParallelism {

	public static void main(String[] args) {
		// System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "2");

		Person person1 = new Person("Arati Maharana", 4, "Mumbai");
		Person person2 = new Person("Akash", 1, "Bengaluru");
		Person person3 = new Person("Minati Maharana", 5, "Rourkela");
		Person person4 = new Person("swati Maharana", 2, "Mumbai");
		Person person5 = new Person("Pranati Maharana", 3, "Kansbahal");
		List<Person> peopleList = Arrays.asList(person1, person2, person3, person4, person5);

		ForkJoinPool forkJoinPool = new ForkJoinPool(2);
		try {
			OptionalDouble avaerageAge = forkJoinPool.submit(
					() -> peopleList.stream().parallel().mapToInt(Person::getAge).filter(age -> age > 3).average())
					.get();
			System.out.println(avaerageAge);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
