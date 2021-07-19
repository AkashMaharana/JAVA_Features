package example13_Method_Reference_Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Application {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "Akash"));
		list.add(new Student(2, "Swati"));
		list.add(new Student(3, "Pranati"));
		list.add(new Student(4, "Richi"));

		Consumer<Student> consumerReference = System.out::println;
		list.forEach(consumerReference);
	}

}

class Student {
	int id;
	String name;

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}