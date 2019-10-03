package ejercicio2_RunTime;

import java.io.IOException;

// Hecho por Nicolás Niebles

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
            System.err.println("Excepción de E/S!!");
            System.exit(-1);
        }
    }
}

// A] Indicamos "notepad.exe" como argumento y se ejecuta el programa, sin embargo no ocurre nada más

// B] Si comentamos la línea de process.destroy() y volvemos a intentarlo,
// al no matar al proceso durante la ejecución se abre el Notepad esta vez.