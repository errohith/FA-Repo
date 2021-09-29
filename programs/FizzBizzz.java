package programs;

import java.util.Scanner;

public class FizzBizzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("resource")
		Scanner myInput = new Scanner( System.in );
		System.out.println("Enter first number");
		int a= myInput.nextInt();
		System.out.println("Enter second number");
		int b= myInput.nextInt();
		for (int i=a;i<=b;i++) {
			if(i%3==0) {
				System.out.println(i+ "Fuzz");
				if(i%5==0) {
					System.out.println(i+ "Fuzz buzz");
				}
			}else if(i%5==0) {
				System.out.println(i+ "buzz");
			}else {
				System.out.println(i);
			}
		}
	}

}