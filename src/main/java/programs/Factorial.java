package programs;

import java.util.Scanner;

public class Factorial {

	static int output=1;
	static int num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		Factorial obj = new Factorial();
		int factNum = obj.factorial(in);
		System.out.println(factNum);
		

	}
	
	public int factorial(int num1) {
		this.num=num1;
		while(num>1) {
			num=num * factorial(num-1);
			return num;
		}
		return num;
	}

}