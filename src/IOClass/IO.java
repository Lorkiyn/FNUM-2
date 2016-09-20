package IOClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IO {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Scanner sc = new Scanner(System.in);
	static double[] doubleArray = null, array = null;
	static double min = 0, max = 0, varianz = 0, arith = 0, stdAbw = 0;
	static int[] intArray = null;
	static int defLength;
	static boolean debug = false;


	//-----------------------------------------------------------------
	//Eingaben
	//-----------------------------------------------------------------
	public static String readString() throws IOException {
		return br.readLine();
	}

	public static int readInt(int defaultValue) throws IOException {
		if(debug) {
			return defaultValue;

		} else {
			while(true) {
				try {
					String i = br.readLine();
					return Integer.parseInt(i.trim().replace(',','.'));

				} catch (NumberFormatException e) {
					System.out.print("Keine Ganzzahl! Bitte erneut versuchen: ");
				}

			}

		}

	}

	public static double readDouble() throws IOException {
		while(true) {
			try {
				String i = br.readLine();
				return Double.parseDouble(i.trim().replace(',','.'));
				
			} catch (NumberFormatException e) {
				System.out.print("Falsche Eingabe! Bitte erneut versuchen: ");
			}

		}

	}

	public static double readDouble(double min) throws IOException {
		double number = readDouble();
		if(number <= min) {
			System.out.print("Zahl ist zu klein! Bitte geben sie eine Zahl ein die größer ist als ");
			return min;

		} else {
			return number;
		}
		
	}

	public static boolean readBoolean() throws IOException {
		while(true) {
			String tmpEingabe = br.readLine();
			if(tmpEingabe != null
					&& tmpEingabe.equalsIgnoreCase("ja") 
					|| tmpEingabe.equalsIgnoreCase("j")
					|| tmpEingabe.equalsIgnoreCase("yes")
					|| tmpEingabe.equalsIgnoreCase("y")) {
				return true;
				
			} else if(tmpEingabe != null
					&& tmpEingabe.equalsIgnoreCase("nein") 
					|| tmpEingabe.equalsIgnoreCase("n")
					|| tmpEingabe.equalsIgnoreCase("no")) {
				return false;
				
			} else {
				System.out.print("False Eingabe! Bitte erneut versuchen: ");
			}

		}

	}


	//-----------------------------------------------------------------
	//Arrays
	//-----------------------------------------------------------------
	public static double[] doubleArrayEinlesen(int defLength) {
		if(defLength == 0) {
			System.out.print("Wie lang soll der Array sein: ");
			defLength = sc.nextInt();
		}
		doubleArray = new double[defLength];
		for(int i = 0; i < doubleArray.length; i++){
			i++;
			System.out.print("Zahl " +i +": ");
			int zahl = sc.nextInt();
			i--;
			doubleArray[i] = zahl;
			
		}
		return doubleArray;
	}

	public static int[] intArrayEinlesen(int defLength) {
		if(defLength == 0) {
			System.out.print("Wie lang soll der Array sein: ");
			defLength = sc.nextInt();
			
		}
		intArray = new int[defLength];
		for(int i = 0; i < intArray.length; i++){
			i++;
			System.out.print("Zahl " +i +": ");
			int zahl = sc.nextInt();
			i--;
			intArray[i] = zahl;

		}
		return intArray;
	}

}