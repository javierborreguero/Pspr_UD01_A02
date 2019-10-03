package ejercicio2_RunTime;

import java.io.IOException;

// Hecho por Nicol�s Niebles

public class RuntimeProcess {
    public static void main(String[] args) {
        if (args.length <= 0) {
            System.err.println("Se necesita un programa a ejecutar");
            System.exit(-1);
        }
        Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(args);
           // process.destroy();
        } catch (IOException ex) {
            System.err.println("Excepci�n de E/S!!");
            System.exit(-1);
        }
    }
}

// A] Indicamos "notepad.exe" como argumento y se ejecuta el programa, sin embargo no ocurre nada m�s

// B] Si comentamos la l�nea de process.destroy() y volvemos a intentarlo,
// al no matar al proceso durante la ejecuci�n se abre el Notepad esta vez.