package ejercicio1_ProcessBuilder;

/*
 * 
 * HECHO POR JAVIER BORREGUERO
 * 
 * 
 */

import java.io.IOException;
import java.util.Arrays;

public class RunProcess {
	public static void main(String[] args) throws IOException {
		if (args.length <= 0) {
			System.err.println("Se necesita un programa para ejecutar");
			System.exit(-1);
		}
		ProcessBuilder pb = new ProcessBuilder(args);
		for (int i = 0; i <= args.length; i++) {
			try {
				Process process = pb.start();
				int retorno = process.waitFor();
				System.out.println("La ejecucuión de " + Arrays.toString(args) + "devuelve " + retorno);
			} catch (IOException ex) {
				System.err.println("Excepción de E/S!!");
				System.exit(-1);
			} catch (InterruptedException ex) {
				System.err.println("El proceso hijo finaliza de forma correcta");
				System.exit(-1);
			}

		}

	}

}

/*
 * 
 * a) Para poder ejecutar el programa con el argumento "calc.exe", lo que
 * tenemos que hacer, es necesario añadirlo a nuestra clase para que al ejecutar
 * el programa se pueda cargar dicho argumento. Para ello tenemos que acceder al
 * run configurations y desde ahí incluir el argumento.
 */

/*
 * b) Si ejecutamos el programa sin incluir un argumento, en la consola se
 * muestra el mensaje de error "Se necesita un programa para ejecutar". Esto es
 * debido a que al no incluir ningun argumento, no se encunetra ningún programa
 * a ejecutar.
 */

/*
 * c) Si se incluyen dos argumentos, como por ejemplo "calc.exe" y "cmd.exe",
 * comprobamos que solo se ejecuta el argumento indicado en primer lugar.
 */

/*
 * d) Para que el programa ejecute una calculadora detrás de otra (se jecutan
 * dos calculadoras). Se crea el bucle "for (int i = 0; i <= args.length; i++)"
 * de forma que cuando finaliza un programa, se ejecuta otro.
 * 
 *
 */