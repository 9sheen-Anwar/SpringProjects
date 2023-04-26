package programming;

import java.util.List;

public class FP02LambdaEven {
	
	public static void main(String [] args){
		List<Integer> num=List.of(12,9,13,4,6,2,8,37);
		printEven(num);
		printSquare(num);
		
	}

	private static void printEven(List<Integer> numbers) {
		// TODO Auto-generated method stub
		//System.out.println();
		System.out.println("Print even number:"); 
		numbers.stream()
			.filter(num->num%2==0)
			.forEach(System.out::println);
	}
		
	private static void printSquare(List<Integer> numbers) {
		System.out.println("Print Squares of a even number:"); 
		numbers.stream()
		.filter(num->num%2==0)
		.map(num->num*num)
		.forEach(System.out::println);
	}

}
