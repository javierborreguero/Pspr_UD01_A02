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
			// La variale process se iguala a la ejecución de la dirección IP
			process = runTime.exec("ping " + args[0]);
			// La variable BUfferedReader in a la que se le pasa el parámetro
			// InputStreamReader sirve para leer el proceso hijo
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			for (int i = 0; i < 10; i++)
				// Se lee el contenido que se obtiene al ejecutar la dirección IP
				System.out.println("Saludo " + in.readLine());
		} catch (IOException e) {
			// Se recoge error de ejecución mostrandose el mensaje de error
			System.out.println("No pudimos correr el ping");
			// Cuando la ejecución falla, el programa devuelve el valor -1
			System.exit(-1);
		}
		if (process != null)
			// Destruimos el proceso si este no eiste
			process.destroy();
		try {
			// El proceso "padre" espera a que el proceso "hijo" finalice la ejecución
			process.waitFor();
		} catch (InterruptedException e) {
			// Se recoge el error de que se ha superado el tiempo de espera
			System.out.println("No pudimos esperar por témino");
			System.exit(-1);
		}
		System.out.println("Estatus de témino: " + process.exitValue());
		// Cuando la ejecución se ejecuta correctamente, el programa devuelve el valor
		// 0
		System.exit(0);

	}
}

/*
 * a) AL EJECUTAR EL CÓDIGO INTRODUCIENDO DIFERENTES DIRECCIONES IP, OBSERVAMOS
 * QUE HAY ALGUNAS VÁLIDAS Y OTRAS NO VALIDAS.
 * 
 *
 * LAS DIRECCIONES IP VALIDAS SON: localhost y 127.0.0.1; EN ESTOS DOS CASOS
 * COMPROBAMOS QUE EN LA CONSOLA SE ESCRIBE TODA LA LLAMADA A LA DIRECCIÓN IP
 * QUE AL FINAL DEL PROGRAMA LEEMOS "Estatus de término: 0" Y
 * "Paquetes: enviados = 4, recibidos = 4, perdidos = 0 (0% perdidos)" INDICANDO
 * QUE EL PROGRAMA SE HA EJECUTADO CORRECTAMENTE.
 * 
 * 
 * LAS DIRECCIONES IP NO VALIDAS SON: 240.0.1.20 y 240.1.1.0; EN ESTOS DOS
 * ULTIMOS CASOS COMPROBAMOS QUE EN LA CONSOLA NO SE ESCRIBE LA LLAMADA A LA IP,
 * DEBIDO A QUE SE PRODUCE UN ERROR EN LA TRANSMISIÓN. AL FINAL DEL PROGRAMA EN
 * LA CONSOLA SE ESCRIBE "Estatus de término: 1" Y
 * "Paquetes: enviados = 4, recibidos = 0, perdidos = 4 (100% perdidos)",
 * INDICANDO QUE NO SE HA EJECUTADO CORRECTAMENTE.
 * 
 */

/*
 * b) PARA VER LOS COMENTARIOS MIRA EL CÓDIGO
 */
