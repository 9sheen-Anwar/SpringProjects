package programming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAllNumberinFuncational(List.of(12,9,13,5,7,8,15,12));
		 

	}
	private static void print(int number) {
		System.out.println(number);
	}
//Functional Approach
	private static void printAllNumberinFuncational(List<Integer> numbers) {
		//what to do?
		//convert list of number into stream of number
		//sequence of number
		numbers.stream().forEach(FP01Functional::print);//Method Refrence
		
		
	}
	

}
