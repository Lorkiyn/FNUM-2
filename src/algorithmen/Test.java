package algorithmen;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	//	x^3-2*x-5
	private static ArrayList<String> fAdd = new ArrayList<String>();
	private static double result = 0;
	private static double last = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Funktion eingeben: ");
		String f = sc.nextLine();

		System.out.print("X Wert eingeben: ");
		double x = sc.nextDouble();

		String[] fArr = f.split("");
		for(int i = 0; i < fArr.length; i++) {
			if(fArr[i].equals("x")) {
				fArr[i] = String.valueOf(x);
			}
		}

		for(int i = 0; i < f.length(); i++) {
			if(fArr[i].equals("^")) {
				double pow = Math.pow(Double.parseDouble(fArr[i-1]), Double.parseDouble(fArr[i+1]));
				fAdd.add(String.valueOf(pow));
				i = i+1;
			} else if(checkOps(fArr[i])) {
				fAdd.add(fArr[i] + fArr[i+1]);	
			}
		}

		for(String s:fAdd) {
			System.out.println(s);
		}
		
		for(int i = 0; i < fAdd.size(); i++) {
			String op = fAdd.get(i).substring(0, 1);
			try {
				if(op.equals("*")) {
					double calc = last * Double.parseDouble(fAdd.get(i).substring(1));
					result -= last;
					result += calc;
				} else if(op.equals("/")) {
					result /= Double.parseDouble(fAdd.get(i).substring(1));
				} else {
					result += Double.parseDouble(fAdd.get(i));	
					last = Double.parseDouble(fAdd.get(i));
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		System.out.println("\n" + result);
	}

	private static boolean checkOps(String str) {
		String[] operators = {"+", "-", "/", "*"};
		for(int j = 0; j < operators.length; j++) {
			if(str.equals(operators[j])) {
				return true;
			}
		}
		return false;
	}

}
