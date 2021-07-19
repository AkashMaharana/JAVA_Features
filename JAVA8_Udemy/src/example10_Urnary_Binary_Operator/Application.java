package example10_Urnary_Binary_Operator;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Application {
	
	public static void main(String[] args) {
		
		//Input and Output types are same
		UnaryOperator<String> unary=s->s.toUpperCase();
		System.out.println(unary.apply("akash"));
		
		//Input and output types are same
		BinaryOperator<Integer> binary=(a,b)->a*b;
		System.out.println(binary.apply(3, 4));
	}

}
