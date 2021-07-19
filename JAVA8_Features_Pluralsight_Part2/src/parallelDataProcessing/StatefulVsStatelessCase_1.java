package parallelDataProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatefulVsStatelessCase_1 {
	
	public static void main(String[] args) {
		
		/*
		 * Case - 1 (Approach-1) : Generate random numbers and add those numbers into a list
		 * It's a traditional approach
		*/
		List<Long> randomList=new ArrayList<>(1000);
		for(int i=0;i<1000;i++) {
			randomList.add(ThreadLocalRandom.current().nextLong());
		}
		System.out.println("RandomList : "+randomList.size());
		
		/*
		 * Case - 1 (Approach-2) : Generate random numbers and add those numbers into a list
		 * Using a parallel stream approach
		*/
		Stream<Long> stream=Stream.generate(()->ThreadLocalRandom.current().nextLong());
		List<Long> list=stream.parallel().limit(1000).collect(Collectors.toList());
		System.out.println("List parallel : "+list.size());
		
		/*
		 * Case - 1 (Approach-3) : Generate random numbers and add those numbers into a list
		 * Using a parallel stream approach
		*/
		Stream<Long> longStream=ThreadLocalRandom.current().longs(1000).mapToObj(Long::new);
		List<Long> longList=longStream.parallel().collect(Collectors.toList());
		System.out.println("Long list parallel : "+longList.size());
	}

}
