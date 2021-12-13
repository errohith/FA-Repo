package programs;

import java.util.Scanner;

public class ArmstrongNumberPgm {

	static double amsNum=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num=sc.nextInt();
		int temp=num;
		while(num>0) {
			amsNum=amsNum+ (Math.pow((num%10),3));
			num=num/10;
		}
		if(amsNum==temp) {
			System.out.println("Given Numebr is Armstrong Number");
		} else {
			System.out.println("Given Numebr is not an Armstrong Number");
		}
	}

}