package programs;

import java.util.Scanner;

public class FizzBizzz {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner MyInput = new Scanner( System.in );
		System.out.println("Enter first number");
		int a= MyInput.nextInt();
		System.out.println("Enter second number");
		int b= MyInput.nextInt();
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