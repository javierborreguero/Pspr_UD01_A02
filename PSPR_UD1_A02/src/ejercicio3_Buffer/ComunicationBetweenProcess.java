package ejercicio3_Buffer;

// Hecho por Nicol�s Niebles
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
            InputStreamReader isr = new InputStreamReader(is, "UTF-8"); // incluir el par�metro UTF-8
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

/* A] Al ejecutar el programa indicando como argumento "cmd.exe", la informaci�n del hijo es enviada al padre siendo esta escrita
por pantalla. Por lo tanto en consola aparece " Salida del proceso [cmd.exe] "

   B] Antes de incluir el par�metro dentro del m�todo, "Versi�n" aparec�a con un caracter extra�o al no entender que conten�a una tilde.
Al a�adir UTF-8 la salida por consola cambia a " ? " en la letra acentuada.

   C] */

