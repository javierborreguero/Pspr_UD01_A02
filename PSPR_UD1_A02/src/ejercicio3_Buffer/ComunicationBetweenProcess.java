package ejercicio3_Buffer;

// Hecho por Nicolás Niebles
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
public class ComunicationBetweenProcess {
    public static void main(String args[]) throws IOException {

        try { // tratamiento de excepciones
            Process process = new ProcessBuilder(args).start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "cp850"); // incluir el parámetro UTF-8
            BufferedReader br = new BufferedReader(isr);
            String line;
            System.out.println("Salida del proceso " + Arrays.toString(args) + ":");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            is.close(); // cierra el descriptor de salida
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}

/* A] Al ejecutar el programa indicando como argumento "cmd.exe", la información del hijo es enviada al padre siendo esta escrita
por pantalla. Por lo tanto en consola aparece " Salida del proceso [cmd.exe]. "

   B] Antes de incluir el parámetro dentro del método, "Versión" aparecía con un caracter extraño al no entender que contenía una tilde.
Al añadir UTF-8 la salida por consola cambia a " ? " en la letra acentuada.

>> Si se pasa por parámetro cp850 en vez de UTF-8 sí que entendería que la o tiene una tilde <<

   C] Una vez añadido el try catch del tratamiento de excepciones y cerrado el hijo, el programa se inicia abriendo el cmd pero cerrándose al instante.
   */

