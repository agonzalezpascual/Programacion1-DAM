import java.io.*;
import java.io.PrintWriter;
import java.util.Scanner;

public class CambiaVocales {

    public static void main(String[] args) {
        System.out.println("\t\t\t\t\tPROGRAMA CAMBIAVOCALES");
        System.out.println("\t\t\t\t\t----------------------\n");

        Archivo a = new Archivo();

        a.escfich();
        System.out.println("\t\t\t\t\too00 Las líneas se han grabado en el fichero 00oo\n");
        a.leefich();
    }


}
class Archivo{

    public void escfich(){

        //ESCRIBIR EN FICHERO

        Scanner teclado = new Scanner(System.in);
        String ent;


        try (PrintWriter fw = new PrintWriter("PEP3T_1.txt")){

            System.out.println("Introduzca el texto:");
            for (int i = 0;i<6;i++){



                ent = teclado.nextLine();
                if(ent.length() < 80){
                if(ent.equalsIgnoreCase("FIN")){break;}
                fw.write(ent+"\n");}
                else{System.out.println("Ha excedido el número de caractéres");i--;}

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void leefich(){

        // LEER FICHERO
        FileReader fr = null;
        try {
            fr = new FileReader("PEP3T_1.txt");
            BufferedReader entrada = new BufferedReader(fr);

            String cadena = entrada.readLine();

            while (cadena != null) {

                System.out.println("En el fichero -> "+cadena+" y en pantalla -> "+ cadena.replace("a", "i").replace("e", "o"));


                cadena = entrada.readLine();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }


    }

}
