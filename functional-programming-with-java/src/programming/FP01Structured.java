package programming;

import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printAllNumber(List.of(12,9,13,5,7,8,15,12));
		 

	}
//Traditional Approach-Structured Approach
	private static void printAllNumber(List<Integer> numbers) {
		// TODO Auto-generated method stub
		//How to loop the numbers?
		for(int num:numbers) {
			System.out.println(num);
		}
		
	}
	

}
