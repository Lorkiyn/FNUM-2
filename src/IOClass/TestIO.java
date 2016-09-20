package IOClass;

import java.io.IOException;

public class TestIO {

	public static void main(String[] args) throws IOException {
		boolean input2 = false;
		int inputI = 0;
		int min = 0;
		do {
			String input;
			//do {
				System.out.print("Eingabe: String, int, double, double2, boolean: ");
				input = IO.readString();
			//} while (input.equalsIgnoreCase("string") || input.equalsIgnoreCase("int") || input.equalsIgnoreCase("double") || input.equalsIgnoreCase("double2") || input.equalsIgnoreCase("boolean"));

			if (input.equalsIgnoreCase("String")) {
				System.out.print("Bitte String eingeben: ");
				String inputS = IO.readString();
				System.out.println(inputS);

			} else if (input.equalsIgnoreCase("int")) {
				System.out.print("Bitte int Zahl eingeben: ");
				inputI = IO.readInt(inputI);
				System.out.println(inputI);

			} else if (input.equalsIgnoreCase("double")) {
				System.out.print("Bitte double Zahl eingeben: ");
				double inputD = IO.readDouble();
				System.out.println(inputD);

			} else if (input.equalsIgnoreCase("boolean")) {
				System.out.print("Bitte boolean Zahl eingeben: ");
				boolean inputB = IO.readBoolean();
				System.out.println(inputB);
				
			} else if (input.equalsIgnoreCase("double2")) {
				System.out.print("Bitte minimalsten Wert eingeben: ");
				min = IO.readInt(min);
				System.out.print("Bitte Zahl eingeben: ");
				double number = IO.readDouble(min);
				System.out.print(number);
				
			} System.out.print("\nWeitere Eingabe Tätigen: ");
			input2 = IO.readBoolean();
		} while (input2 == true);

	}

}