package algorithmen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Intarwahl {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		double lowerX = 0;
		double upperX = 0;
		double xStar = 0;

		System.out.print("Bitte geben Sie die Untergrenze ein: ");
		lowerX = Double.parseDouble(br.readLine());
		System.out.print("Bitte geben Sie nun die Obergrenze ein: ");
		upperX = Double.parseDouble(br.readLine());

		do {
			xStar = (upperX + lowerX) / 2;

			if(f(xStar) * f(upperX) < 0) {
				lowerX = xStar;
			} else {
				upperX = xStar;
			}

		} while(Math.abs(f(xStar)) > 0.0001);

		System.out.println(xStar);
	}

	public static double f(double x) {

		double temp = (Math.pow(x, 3) - 2 * x - 5);

		return temp;
	}
}
