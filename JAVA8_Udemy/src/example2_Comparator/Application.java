package example2_Comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		/*Approach1*/
		Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				return i1.compareTo(i2);
			}
		};
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(-1);
		list.add(2);
		list.sort(comparator);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();

		/*Approach2*/
		Comparator<Integer> comparator1 = (i1, i2) -> {
			return -i1.compareTo(i2);
		};
		list.sort(comparator1);
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();

	}

}
