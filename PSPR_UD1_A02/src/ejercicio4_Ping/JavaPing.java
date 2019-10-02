package ejercicio4_Ping;

/*
 * 
 * HECHO POR JAVIER BORREGUERO
 * 
 * 
 */

import java.io.*;

public class JavaPing {
	public static void main(String[] args) {
		// Esta variable sirve para saber el periodo durante el cual se ejecuta un
		// programa
		Runtime runTime = Runtime.getRuntime();
		// Variable de tipo process inicializada a null
		Process process = null;
		try {
			// La variale process se iguala a la ejecuci�n de la direcci�n IP
			process = runTime.exec("ping " + args[0]);
			// La variable BUfferedReader in a la que se le pasa el par�metro
			// InputStreamReader sirve para leer el proceso hijo
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			for (int i = 0; i < 10; i++)
				// Se lee el contenido que se obtiene al ejecutar la direcci�n IP
				System.out.println("Saludo " + in.readLine());
		} catch (IOException e) {
			// Se recoge error de ejecuci�n mostrandose el mensaje de error
			System.out.println("No pudimos correr el ping");
			// Cuando la ejecuci�n falla, el programa devuelve el valor -1
			System.exit(-1);
		}
		if (process != null)
			// Destruimos el proceso si este no eiste
			process.destroy();
		try {
			// El proceso "padre" espera a que el proceso "hijo" finalice la ejecuci�n
			process.waitFor();
		} catch (InterruptedException e) {
			// Se recoge el error de que se ha superado el tiempo de espera
			System.out.println("No pudimos esperar por t�mino");
			System.exit(-1);
		}
		System.out.println("Estatus de t�mino: " + process.exitValue());
		// Cuando la ejecuci�n se ejecuta correctamente, el programa devuelve el valor
		// 0
		System.exit(0);

	}
}

/*
 * a) AL EJECUTAR EL C�DIGO INTRODUCIENDO DIFERENTES DIRECCIONES IP, OBSERVAMOS
 * QUE HAY ALGUNAS V�LIDAS Y OTRAS NO VALIDAS.
 * 
 *
 * LAS DIRECCIONES IP VALIDAS SON: localhost y 127.0.0.1; EN ESTOS DOS CASOS
 * COMPROBAMOS QUE EN LA CONSOLA SE ESCRIBE TODA LA LLAMADA A LA DIRECCI�N IP
 * QUE AL FINAL DEL PROGRAMA LEEMOS "Estatus de t�rmino: 0" Y
 * "Paquetes: enviados = 4, recibidos = 4, perdidos = 0 (0% perdidos)" INDICANDO
 * QUE EL PROGRAMA SE HA EJECUTADO CORRECTAMENTE.
 * 
 * 
 * LAS DIRECCIONES IP NO VALIDAS SON: 240.0.1.20 y 240.1.1.0; EN ESTOS DOS
 * ULTIMOS CASOS COMPROBAMOS QUE EN LA CONSOLA NO SE ESCRIBE LA LLAMADA A LA IP,
 * DEBIDO A QUE SE PRODUCE UN ERROR EN LA TRANSMISI�N. AL FINAL DEL PROGRAMA EN
 * LA CONSOLA SE ESCRIBE "Estatus de t�rmino: 1" Y
 * "Paquetes: enviados = 4, recibidos = 0, perdidos = 4 (100% perdidos)",
 * INDICANDO QUE NO SE HA EJECUTADO CORRECTAMENTE.
 * 
 */

/*
 * b) PARA VER LOS COMENTARIOS MIRA EL C�DIGO
 */
