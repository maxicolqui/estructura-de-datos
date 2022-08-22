/**
 * @author Gonzalo
 * Dadas las longitudes de los tres lados de un triángulo, determinar qué
 * clasificación le corresponde (Equilátero, Isósceles o Escaleno).
 * 
 * Para ello,* en primer lugar, se debe determinar si las medidas de los tres
 * lados forman un triángulo usando el teorema de la desigualdad del triángulo.
 * 
 * Teorema de la desigualdad del triángulo: La suma de las longitudes de
 * cualquiera de los dos lados de un triángulo es mayor que la longitud del
 * tercer lado.
 * 
 * Indicaciones:
 * Este ejercicio necesita del objeto scanner para ingresar datos por la consola
 * o teclado, se espera que el código controle los problemas que normalmente
 * ocurren al operar con la consola o teclado.
 * Se espera una correcta modularización entre el código que realiza el ingreso
 * y validación de los datos respecto del código que hace lo que se solicita en
 * el ejercicio.
 * También necesita del objeto random para generar valores de manera aleatoria.
 * El ejercicio debe implementar un mecanismo para seleccionar el ingreso de
 * valores por consola o generados aleatoriamente.
 **/

/* Directorio padre */ 
package ar.edu.unju.fi.tp0;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

/* Importar validaciones (extraido de la clase del viernes 19/08),
 * no me gusta el Helper de la catedra :( así que uso los mios.
 */
// import ar.edu.unju.fi.tp0.Helper;

// Clase Ejercicio6
public class Ejercicio6 {
    
    /* PRINCIPAL */
    /**
     * @param args
     **/
    public static void main(String[] args)
    {
        // Scanner entrada = new Scanner(System.in);
        char opcion_seleccionada = ' ';
        int ladoA = 0;
        int ladoB = 0;
        int ladoC = 0;
        int rangoInicial = 0;
        int rangoFinal = 0;

        do {
            limpiarPantalla();
            opcion_seleccionada = menuOpciones();
            switch ( opcion_seleccionada ) {
                case 'a':
                    ladoA = validarNumero("Lado a");
                    ladoB = validarNumero("Lado b");
                    ladoC = validarNumero("Lado c");
                    mostrarLados(ladoA, ladoB, ladoC);
                    determinarClasificacion(ladoA, ladoB, ladoC);
                    break;
                case 'b':
                    rangoInicial = ingresarRango("Rango inicial");
                    rangoFinal = ingresarRango("Rango final");
                    ladoA = ingresarNumeroAleatorio(rangoInicial, rangoFinal);
                    ladoB = ingresarNumeroAleatorio(rangoInicial, rangoFinal);
                    ladoC = ingresarNumeroAleatorio(rangoInicial, rangoFinal);
                    mostrarLados(ladoA, ladoB, ladoC);
                    determinarClasificacion(ladoA, ladoB, ladoC);
                    break;
                case 'c':
                    System.out.printf("\t\t---- FIN DEL PROGRAMA ----%n");
                    break;
                default:
                    System.out.printf(
                        "\tERROR: %c no es válida.", opcion_seleccionada
                    );
                    break;
            } // Fin switch () {}
        } while ( opcion_seleccionada != 'c' ); // Fin do {} while ()
    } // Fin main()

    /* METODOS */

    /**
     * Menú de opciones.
     * @return Devulve la opción seleccionada.
     */
    public static char menuOpciones()
    {
        Scanner entrada = new Scanner(System.in);
        System.out.printf("\t\t**** ENTRADA ****%n");
        System.out.printf("\ta) Ingresar valores manualmente%n");
        System.out.printf("\tb) Ingresar valores aleatoriamente%n");
        System.out.printf("\tc) Salir%n");
        System.out.printf("\t$: ");
        char opcion = entrada.nextLine().charAt(0);
        return opcion;
    }

    /**
     * Clasificación de un triángulo según la longitud de sus lados.
     * https://es.wikipedia.org/wiki/Tri%C3%A1ngulo#Clasificaci%C3%B3n_de_los_tri%C3%A1ngulos
     * @param ladoA lado de un triángulo.
     * @param ladoB lado de un triángulo.
     * @param ladoC lado de un triángulo.
     */
    public static void determinarClasificacion(int ladoA, int ladoB, int ladoC)
    {
        /* Si los lados corresponden con un triángulo */
        if ( esTriangulo(ladoA, ladoB, ladoC) ) {
            if ( (ladoA != ladoB) && (ladoB != ladoC) && (ladoA != ladoC) ) {
                mensajeTipoTriangulo("Escaleno", false);
            } else if ( (ladoA == ladoB) && (ladoB == ladoC) ) {
                mensajeTipoTriangulo("Equilátero", false);
            } else {
                mensajeTipoTriangulo("Isóseceles", false);
            }
        } else {
            mensajeTipoTriangulo("No es un triángulo", true);;
        }
        esperar(3);
    }
        
    /**
     * Determina si los valores dados representan un triángulo.
     * Teorema de la desiguldad del triángulo.
     * https://es.wikipedia.org/wiki/Desigualdad_triangular
     * @param ladoA Lado de un triángulo.
     * @param ladoB Lado de un triángulo.
     * @param ladoC Lado de un triángulo.
     */ 
    public static boolean esTriangulo(int ladoA, int ladoB, int ladoC)
    {
        return (ladoA + ladoB > ladoC
                && (ladoB + ladoC) > ladoA
                && (ladoC + ladoA) > ladoB);
    }

    /**
     * Varios mensajes.
     * @param texto Mensaje a mostrar.
     * @param error Mensaje a mostrar en caso de error.
     */
    public static void mensajeTipoTriangulo(String texto, boolean error)
    {
        if ( !error ) {
            System.out.printf("\tRespuesta: Es un triángulo %s.%n", texto);
        } else {
            System.out.printf("\tRespuesta: %s.%n", texto);
        }
    }

    /**
     * @param lado Mensaje para distinguir los lados ingresados.
     * @return Devuelve un número entero.
     */
    public static int ingresarNumeroEntero(String texto)
    {
        /* Crea una instancia del Objeto Scanner(). */
        Scanner entrada = new Scanner(System.in);
        /* Declaración e inicialización. */
        int numero = 0;
        while ( true ) {
            try {
                System.out.printf("\t%s: ", texto);
                numero = entrada.nextInt();
                return numero;
            } catch ( InputMismatchException error ) {
                System.out.printf("\tERROR: entrada no es válida.%n");
                /* Consume la excepción o entras a un bucle infinito. */
                entrada.nextLine();
            }
        }
    }

    /**
     * @param texto
     * @return Devuelve un número entero positivo distinto a 0.
     */
    public static int validarNumero(String texto)
    {
        int numero = 0;
        do {
            numero = ingresarNumeroEntero(texto);
            if (numero <= 0) {
                System.out.printf("\tERROR: no es un número positivo.%n");
            }
        } while (numero <= 0);
        return numero;
    }

    /**
     * El rango es inclusivo [a, b].
     * @param minimo Rango inicial.
     * @param maximo Rango final.
     * @return Devuelve un número entero aleatorio.
     */
    public static int ingresarNumeroAleatorio(int minimo, int maximo)
    {
        Random entradaAleatoria = new Random();
        /* El rango de nextInt() es [a, b). Por eso agregamos 1.*/
        int numeroAleatorio = entradaAleatoria.nextInt(
            (maximo - minimo) + 1
        ) + minimo;
        return numeroAleatorio;
    }

    /**
     * Valor usado para generar un número aleatorio.
     * @param texto Mensaje a mostrar.
     * @return Devuelve un número entero positivo mayor a 0:
     */
    public static int ingresarRango(String texto)
    {
        int numero = validarNumero(texto);
        return numero;
    }

    /**
     * Muestra los valores ingresados para los lados del triángulo.
     * @param ladoA Lado de un triángulo.
     * @param ladoB Lado de un triángulo.
     * @param ladoC Lado de un triángulo.
     */
    public static void mostrarLados(int ladoA, int ladoB, int ladoC)
    {   
        System.out.printf(
            "\tIngresaste los valores: %d, %d, %d.%n", ladoA, ladoB, ladoC
        );
    }

    /**
     * Limpiar la pantalla usando escapes ANSI.
     * https://stackoverflow.com/questions/2979383/how-to-clear-the-console
     */
    public static void limpiarPantalla()
    {
        System.out.print("\033\143");
    }

    /**
     * Agrega un tiempo de espera en segundos (convertido).
     * @param segundo Entrada es en milisegundos.
     */
    public static void esperar(int segundo)
    {
        try {
            Thread.sleep(segundo * 1000);
        } catch ( InterruptedException error ) {
            System.err.printf("\tERROR: %d%n.", error);
        }
    }
}