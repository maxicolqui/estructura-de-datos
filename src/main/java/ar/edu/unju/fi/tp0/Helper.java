/**
 * 
 */
package ar.edu.unju.fi.tp0;

import java.util.Random;
import java.util.Scanner;

/**
 * @author
 *
 */
public class Helper {

	public static Scanner scanner = new Scanner(System.in);
	public static Random random = new Random();

	public static Integer getInt(String inputMessage, String errorMessage) {
		while (true) {
			try {
				System.out.println(inputMessage);
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);
			}
		}
	}

	/**
	 * 
	 * @param inputMessage
	 * @return Integer number
	 */
	public static Integer getInt(String inputMessage) {
		return getInt(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO ENTERO");
	}

	public static Integer getPositiveInt(String inputMessage, String errorMessage) {
		while (true) {
			int num = getInt(inputMessage);
			if (num > 0) {
				return num;
			}
			System.out.println("\n" + errorMessage);
		}
	}

	public static Integer getPositiveInt(String inputMessage) {
		return getPositiveInt(inputMessage, "\nERROR: EL NUMERO INGRESADO NO ES POSITIVO");
	}

	public static Double getDouble(String inputMessage, String errorMessage) {
		while (true) {
			try {
				System.out.println(inputMessage);
				return Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);
			}
		}
	}

	/**
	 * 
	 * @param inputMessage
	 * @return Double number
	 */
	public static Double getDouble(String inputMessage) {
		return getDouble(inputMessage, "\nERROR: EL VALOR INGRESADO NO CORRESPONDE A UN NUMERO");
	}

	public static Character getChar(String inputMessage, String errorMessage) {

		while (true) {
			try {
				System.out.println("\n" + inputMessage);
				char caracter = scanner.nextLine().toUpperCase().charAt(0);
				int valorASCII = (int) caracter;
				if (valorASCII == 165 || (valorASCII >= 65 && valorASCII <= 90)
						|| (valorASCII >= 97 && valorASCII <= 122) || valorASCII == 164) {
					return caracter;
				} else {
					throw new Exception(errorMessage);
				}
			} catch (Exception e) {
				System.out.println("\n" + e.getMessage());
				scanner.nextLine();
			}
		}
	}

	/**
	 * 
	 * @param inputMessage
	 * @return Character from ASCII
	 */
	public static Character getChar(String inputMessage) {
		return getChar(inputMessage, "\nERROR: INGRESE UN CARATER VALIDO");
	}

	/**
	 * 
	 * @param bound
	 * @return Random number 
	 */
	public static double randomDouble(int bound) {
		double num;
		num = random.nextInt(bound) + random.nextDouble();
		return (double) Math.round(num * 100d) / 100;
	}

	/**
	 * 
	 * @param question Y/N
	 * @return char resp 'Y' or 'N'
	 */
	public static char yesOrNo(String question) {
		char resp;
		do {
			System.out.println("\n" + question + "\nPRESION S -SI\nPRESIONE 'N' -NO");
			resp = Character.toUpperCase(scanner.nextLine().charAt(0));
			if (resp == 'N' || resp == 'S') {
				return resp;
			}
			System.out.println("\nERROR: LA OPCION INGRESADA NO ES CORRECTA INTENTELO DE NUEVO");
		} while (true);
	}

}
