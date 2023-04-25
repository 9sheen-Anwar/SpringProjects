package com.debug.debugapp;

public class Test {
	
	public static void main(String[] args) {
		System.out.println("Testing Debugging");
		int[] myarr= {2,5,7,3};
		int sum=getSum(myarr);
		System.out.println("sum="+sum);
	}
	public static int getSum(int arr[])
	{
		int s=0;
		for(int i=0;i<arr.length;i++)
		{
			s=s+arr[i];
		}
		s=s+3;
		return s;
			
	}
}
