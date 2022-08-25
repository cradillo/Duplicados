/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template



    Cristian Andres Parra Radillo
    Cradillo    
    200126655
    Grupo 01 
    Contador de numeros duplicados
    22/08/2022
    El programa genera un archivo txt con numeros aleatorios segun la entrada n que se le de
    El proceso se repite  varias veces y se va multiplicando por una constante positiva (Proceso Opcional)

    Para el informe se genero un num base de 2, una constante de 2 y un iteracion de 19
    Asi el algortimo se ejecuta 19 veces con 2^(i) de i = 1 hasta 19 
    el n mayor es 2^(19)

    Para fines practicos se aconseja comentar el for que muestra los numeros contados para varias iteraciones --  line 155




 */
package numerosduplicados;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BestCase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        int num = 20; // numero de datos (N)
        int constante = 1; // multiplica al numero de datos anterior para hacer N mas grande
        int interaciones = 1; // La iteracciones totales que se desean hacer 
        long Star, End, comparaciones;
        double time;

        // El programa crea un archivo databest donde se guardan los datos que arroja el programa
        create("databest.txt");
        String filename = ("databest.txt");
        PrintWriter out = new PrintWriter(filename); // generamos un objetct PrintWriter para escribir en el archivo

        // El for es para que el programa entre varias veces y poder ir incrementando el N para poder obtener un archivo .txt
        // con varios datos.
        for (int i = 0; i < interaciones; i++) {
            create("data.txt");	// creates a file
            write(num);	// writes data to the file
            Star = System.nanoTime();
            read(num);		// reads data in the file
            End = System.nanoTime();
            time = (double) (End - Star) / 1000000000.0;
            System.out.println("Para n: " + num + " El Tiempo en segundos es: " + time);
            comparaciones = (num * 4) + 4;
            System.out.println("Numero de comparaciones es: " + comparaciones+"\n");
            String comp = Long.toString(comparaciones);
            String entradas = Integer.toString(num);
            String tiempo = Double.toString(time);
            out.println(entradas + "," + comp + "," + tiempo);
            num = num * constante;
        }
        out.close();

        
    }

    // implementations:
    private static void create(String a) // creates a file
    {
        try {
            // defines the filename
            String fname = (a);
            // creates a new File object
            File f = new File(fname);

            String msg = "creating file `" + fname + "' ... ";
            
            System.out.printf("%s", msg);
            // creates the new file
            f.createNewFile();
            System.out.println("done");

        } catch (IOException err) {
            // complains if there is an Input/Output Error
            err.printStackTrace();
        }

        return;
    }

    private static void write(int x) // writes data to a file
    {
        try {
            // defines the filename
            String filename = ("data.txt");
            // creates new PrintWriter object for writing file
            PrintWriter out = new PrintWriter(filename);

            int numel = x;
            String msg = "writing %d numbers ... ";
            System.out.printf(msg, numel);
            // writes the integers in the range [0, N)
            for (int i = 0; i != numel; ++i) {
                int Entero = (int) (Math.random() * numel + 1);
                //Se genera un numero aletorio de 1 a N
                out.printf("%d\n", Entero);
            }
            System.out.println("done");

            System.out.printf("closing file ... ");
            out.close();	// closes the output stream
            System.out.println("done");
        } catch (FileNotFoundException err) {
            // complains if file does not exist
            err.printStackTrace();
        }

        return;
    }

    private static void read(int size) // reads the file contents and prints them to the console
    {
        // defines the filename
        String filename = ("data.txt");
        // creates a File object
        File f = new File(filename);
        System.out.printf("Numero de caracteres " + size);
        System.out.printf("\nResultados: \n");

        try {
            // attempts to create a Scanner object
            Scanner in = new Scanner(f);                    // 1 iteracion  
            int x;                                          // 1 iteracion
            int count = 0;                                  // 1 iteracion
            int Numeros[] = new int[size + 1];              // 1 iteracion
            // reads integers in file until EOF
            while (in.hasNextInt()) {
                // cuando aparece un numero se toma como indice y en ese posicion
                // se le suma +1
                x = in.nextInt();                           // n iteraciones    
                Numeros[x]++;                               // n iteraciones   
                ++count;                                    // n iteraciones   
            }
            // Escribimos el vector, siendo el indice el número y el valor 
            // el numero de veces que aparece el numero
            for (int i = 1; i <= size; i++) {
              System.out.println("El numero " + i + " se repite = " + Numeros[i]);    // n iteraciones
            }
            in.close();

            //String msg = ("%d numbers have been read\n");

            /*System.out.printf(msg, count);
            System.out.println("Numero de veces que se repite cada numero ");
             */
            // closes the input stream
        } catch (FileNotFoundException err) {
            // complains if file does not exist
            err.printStackTrace();
        }

        return;
    }

    
}
