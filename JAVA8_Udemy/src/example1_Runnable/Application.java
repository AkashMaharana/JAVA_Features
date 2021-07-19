package example1_Runnable;

public class Application {
	
	public static void main(String[] args) {
		/*Approach1*/
		Thread t1=new Thread(new Runnable() {
			public void run() {
				System.out.println("Using JAVA 1.7 approach");
			}
		});
		t1.start();
		
		/*Approach2*/
		Runnable r=new Runnable() {
			public void run() {
				System.out.println("Using JAVA 1.7 in the thread constructor");
			}
		};
		Thread t2=new Thread(r);
		t2.start();
		
		/*Approach3*/
		Runnable r1=()->{
			System.out.println("Using Lambda");
		};
		Thread t3=new Thread(r1);
		t3.start();
		
		/*Approach4*/
		Thread t4=new Thread(()->{System.out.println("Using Labda JAVA 1.8");});
		t4.start();
	}

}
