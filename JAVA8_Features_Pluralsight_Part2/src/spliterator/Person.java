package spliterator;

public class Person {

	private String name;
	private int age;
	private String currentCity;

	public Person(String name, int age, String currentCity) {
		this.name = name;
		this.age = age;
		this.currentCity = currentCity;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	@Override
	public String toString() {
		return this.name+" : "+this.age+" : "+this.currentCity;
	}

}
