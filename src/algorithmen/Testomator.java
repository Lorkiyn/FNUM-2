package algorithmen;

import java.util.Scanner;

public class Testomator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("X: ");
			double x = sc.nextDouble(); 
			double f = Math.pow(x, 3) + 2 * Math.pow(x, 2) - x -7;
			System.out.println(f);
			System.out.println("x1: " + x);
			System.out.print("x2: ");
			double x2 = sc.nextDouble();
			System.out.println((x+x2)/2);
		}	
	}
}
