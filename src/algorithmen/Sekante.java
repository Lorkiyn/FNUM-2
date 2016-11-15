package algorithmen;

import java.util.Scanner;

public class Sekante {

	private static double x0 = 0;
	private static double x1 = 0;
	private static int count = 0;

	private static double[] values = null;
	
	private static double xStar = 0;

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		insert();
	}

	private static void insert() {
//		System.out.print("Gib ma x1 ein: ");
//		x0 = sc.nextDouble();
//		System.out.print("Gib ma x2 ein: ");
//		x1 = sc.nextDouble();
		
		
		calculate();
		sc.close();
	}

	private static void calculate() {	
		do {
			xStar = x0 - f(x0) * ( (x0 - x1) / (f(x0) - f(x1) ));
			
			x1 = xStar;
			count++;
			
		} while(Math.abs(f(xStar)) > 0.0001);

		System.out.println("\nNullstelle bei x = " + xStar);
		System.out.println("Anzahl: " + count);
	}

	public static double f(double x) {
		double temp = (Math.pow(x, 3) - 2 * x - 5);
//		double newTemp = Math.pow(a, b)
		return temp;
	}
}
