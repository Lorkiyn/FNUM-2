package algorithmen;

import java.util.Scanner;

public class GAUSS01 {
	private static Scanner sc = new Scanner(System.in);
	private static double[][] data = new double[3][3];
	private static double[] result = new double[3];
	private static double[] x = null;

	public static void main(String[] args) {
		//		data[0][0] = 1;
		//		data[0][1] = 1;
		//		data[0][2] = 1;
		//		result[0] = 6;
		//
		//		data[1][0] = 2;
		//		data[1][1] = 2;
		//		data[1][2] = -4;
		//		result[1] = -6;
		//
		//		data[2][0] = 3;
		//		data[2][1] = 1;
		//		data[2][2] = -1;
		//		result[2] = 2;

		init();
		menu();

	}

	private static void menu() {
		System.out.println("\n-------------------------------");
		System.out.println("[1] Neue Matrix");
		System.out.println("[2] Verändern");
		System.out.println("[3] Ausgeben");
		System.out.println("[4] Berechnen");
		System.out.println("[5] Beenden\n");

		System.out.print("Auswahl: ");
		int i = sc.nextInt();

		System.out.println("-------------------------------\n");	

		switch(i) {
		case 1:
			init();
			menu();
			break;

		case 2:
			change();
			menu();
			break;

		case 3:
			print();
			menu();
			break;

		case 4:
			calc();
			menu();
			break;	

		case 5:
			System.exit(0);

		default:
			System.out.println("\nKeine korrekte Eingabe Wert ziwschen 1 und 3 eingeben.\n");
			menu();
			break;

		}

	}

	private static void calc() {
		nulln();
		if(checkForSub()) {
			rücksubstitution();
			
		}
	}

	/**
	 * @return boolean 
	 * */
	private static boolean checkForSub() {
		double value = 0;
		for(int i = 0; i < data.length; i++) {
			value += data[data.length-1][i];
		}
		
		if(value == 0 && (result[result.length-1] > 0 || result[result.length-1] < 0)) {
			System.out.println("BRUDAH MAN WAS FÜR SHICE MATRIX HAST DU GEMACHT DIE HAT VOLL KAK KEINE LÖSUNG!");
			return false;
		}
		
		if(value == 0 && result[result.length-1] == 0) {
			System.out.println("BRUDAH MAN WAS DAS WIDA FÜR SHICE MAN DAS HAT VOLL UNENDLICH LÖSUNG MAAN");
			return false;
		}

		return true;
	}

	private static void nulln() {
		for(int i = 0; i < data.length-1; i++) {

			for(int j = i + 1; j < data.length; j++) {
				double q = 0;
				double[] temp = null;
				double tempRes = 0;

				if(data[i][i] == 0) {
					temp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = temp;

					tempRes = result[i];
					result[i] = result[i + 1];
					result[i + 1] = tempRes;
				}

				if(data[i][i] != 0) {
					q = -data[j][i] / data[i][i];

					for(int k = i; k < data.length; k++) {
						data[j][k] = data[j][k] + data[i][k] * q;

					}

				}

				result[j] = result[j] + result[i] * q;

			}

		}

	}

	private static void rücksubstitution() {
		x = new double[result.length];

		for(int i = data.length-1; i >= 0; i--) {
			double add = 0;			

			for(int j = i + 1; j < data[i].length; j++) {
				add += data[i][j] * x[j];

			}

			x[i] = result[i];
			x[i] -= add;
			x[i] /= data[i][i];

		}

		for(int i = 0; i < x.length; i++) {
			System.out.println("x" +(i+1) +": " +x[i]);
		}

	}

	/* Verändern von Werten */
	private static void change() {
		boolean repeat = true;

		do {
			System.out.println("Welchen Wert möchten sie verändern?");
			System.out.print("Zeile: ");
			int column = sc.nextInt();
			System.out.print("Spalte: ");
			int row = sc.nextInt();
			try {
				if(column > data[0].length) {
					System.out.println("Alter Wert: " + result[row-1]);
					System.out.print("Neuer Wert: ");
					result[row-1] = sc.nextDouble();

				} else {
					System.out.println("Alter Wert: " + data[row - 1][column - 1]);
					System.out.print("Neuer Wert: ");
					data[row-1][column-1] = sc.nextDouble();

				}

				System.out.print("Weitern Wert verändern [true, false]: ");
				repeat = sc.nextBoolean();
				System.out.println("");

			} catch (Exception e) {
				e.printStackTrace();
				//				System.out.println("Wert nicht gefunden. Spalte MAX(" + (data.length + 1) + ") Zeile MAX(" +(data[0].length + 1) + ")");
				//				repeat = true;
			}

		} while (repeat);

		print();
	}

	/* Erstellung des Arrays */
	private static void init() {
		System.out.print("Wie viele Gleichungen sollen eingelesen werden: ");
		int length = sc.nextInt();
		data = new double[length][length];
		result = new double[length];

		read();

	}

	/* Einlesen der Daten */
	private static void read() {
		for(int i = 0; i < data.length; i++) {
			System.out.println("Gleichung " +(i+1));
			for(int j = 0; j < data[i].length; j++) {
				System.out.print("Wert " +(j+1) +": ");
				data[i][j] = sc.nextDouble();

			}
			System.out.print("Ergebnis: ");
			result[i] = sc.nextDouble();

			System.out.println("");

		}

	}

	/* Ausgeben der Daten */
	private static void print() {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] +"\t");

			}
			System.out.println("| " +result[i]);

		}

	}

}
