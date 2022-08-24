/**
 * 
 */
package ar.edu.unju.fi.tp0;


/**
 * @author Enzo
 *
 */
public class Ejercicio5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Encontrar el máximo común divisor de dos números enteros positivos
		 * (validados). Definición: El máximo común divisor de dos o más números enteros
		 * es el mayor número entero que los divide exactamente a todos, esto es sin
		 * dejar resto en cada división.
		 * 
		 * Solución: El algoritmo de Euclides transforma un par de enteros positivos en
		 * otro par, dividiendo repetidamente el entero mayor por el menor y
		 * reemplazando el mayor por el menor y el menor por el resto. Cuando el resto
		 * es 0, el número más pequeño distinto de cero de la pareja resultante será el
		 * máximo común divisor de la pareja original.
		 * 
		 * Modifique el programa escrito de manera que cuente con una función,
		 * procedimiento o método que realice lo solicitado mediante el uso de la
		 * consola y otra modalidad que haga exactamente lo mismo, pero reemplazando el
		 * ingreso de valores por consola por un generador de valores aleatorio.
		 * 
		 * Indicaciones: Este ejercicio necesita del objeto scanner para ingresar datos
		 * por la consola o teclado, se espera que el código controle los problemas que
		 * normalmente ocurren al operar con la consola o teclado. Se espera una
		 * correcta modularización entre el código que realiza el ingreso y validación
		 * de los datos respecto del código que hace lo que se solicita en el ejercicio.
		 * También necesita del objeto random para generar valores de manera aleatoria.
		 */

		int numero1 = (int) Helper.randomDouble(100);
		int numero2 = (int) Helper.randomDouble(100);

		char opcion = Helper.yesOrNo("Ingresar dos números de forma manual S/N: ");

		if (opcion == 'S') {
			numero1 = Helper.getPositiveInt("Ingrese un número entero positivo: ");
			numero2 = Helper.getPositiveInt("Ingrese otro número entero positivo: ");
		}

		imprimirMensaje(
				"El MCD entre " + numero1 + " y " + numero2 + " es:" + obtenerMCDrecursivamente(numero1, numero2));

	}

	/**
	 * 
	 * @param numero1
	 * @param numero2
	 * @return MCD between numero1 and numero2
	 */
	public static int obtenerMCD(int numero1, int numero2) {
		while (numero1 != numero2) {
			if (numero1 > numero2) {
				numero1 += -numero2;
			} else {
				numero2 += -numero1;
			}
		}
		return numero1;
	}

	/**
	 * 
	 * @param numero1
	 * @param numero2
	 * @return MCD between numero1 and numero2 recursively
	 */
	public static int obtenerMCDrecursivamente(int numero1, int numero2) {
		if (numero1 == numero2) {
			return numero1;
		} else {
			if (numero1 > numero2) {
				return obtenerMCDrecursivamente(numero1 - numero2, numero2);
			} else {
				return obtenerMCDrecursivamente(numero1, numero2 - numero1);
			}
		}
	}

	/**
	 * 
	 * @param message
	 */
	public static void imprimirMensaje(String message) {
		System.out.println(message);
	}

}
