/**
 * 
 */
package ar.edu.unju.fi;

import ar.edu.unju.fi.tp0.Helper;

/**
 * @author
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int numero = Helper.getInt("Ingrese un número entero: ");

		System.out.println("El número ingresado es: " + numero);
		
		int numeroAleatorio = (int) Helper.randomDouble(100);
		
		System.out.println("El número aleatorio es: " + numeroAleatorio);

	}

}
