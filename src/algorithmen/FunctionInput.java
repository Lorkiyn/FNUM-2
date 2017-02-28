package algorithmen;

import java.util.Scanner;

public class FunctionInput {

	private static double[] funct = null;
	private static double[] functLine = null;
	private static double x0 = 0;
	private static double x1 = 0;
	private static int count = 0;
	private static double xStar = 0;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		init();
	}

	private static void init() {
		System.out.print("Maximale Potenz: ");
		funct = new double[sc.nextInt()+1];

		for(int i = funct.length-1; i >= 0; i--) {
			System.out.print("[^" + (i) + "] eingeben: ");
			funct[i] = sc.nextDouble();
		}
		
//		calculateSekante();
		calculateNewton();
	}

	private static void calculateSekante() {
			System.out.print("\n[SEKANTE] Gib ma x1 ein: ");
		x0 = sc.nextDouble();
		
		System.out.print("[SEKANTE] Gib ma x2 ein: ");
		x1 = sc.nextDouble();
		
		do {
			xStar = x0 - f(x0) * ( (x0 - x1) / (f(x0) - f(x1) ));

			x1 = xStar;
			count++;

		} while(Math.abs(f(xStar)) > 0.0001);
		System.out.println("[SEKANTE] Nullstelle bei x = " + xStar);
		System.out.println("[SEKANTE] Anzahl: " + count);
	}
	
	private static void calculateNewton() {
		functLine = new double[funct.length];
		for(int i = functLine.length-1; i >= 0; i--) {
			functLine[i] = funct[i] * i;
		}
		
		int count = 0 ;
		double xi = 0;
		double x = 0;
		
		System.out.print("\n[NEWTON] Bitte x0 eingeben: ");
		x = sc.nextDouble();

		do {
			count++;
			xi = x - (f(x)) / (fLine(x));
			x = xi;	
			System.out.println(xi);
		} while (Math.abs(0 - f(xi)) > 0.00001);
		System.out.println("[NEWTON] Nullstelle bei x = " + xi);
		System.out.println("[NEWTON] Anzahl: " + count);
	}
	
	public static double fLine(double x) {
		double temp = 0;
		for(int i = funct.length-1; i > 0; i--) {
			temp += functLine[i] * Math.pow(x, i);
		}
		return temp;
	}

	public static double f(double x) {
		double temp = 0;
		for(int i = funct.length-1; i >= 0; i--) {
			temp += funct[i] * Math.pow(x, i);
		}
		return temp;
	}

}
