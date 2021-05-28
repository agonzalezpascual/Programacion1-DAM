package Modelo;

import java.io.*;

public class IOArchivo {

    public String LeeFich(String f) {

        String texto = null;

        try {
            FileInputStream fichero_lectura = new FileInputStream(f);
            ObjectInputStream leer = new ObjectInputStream(fichero_lectura);
            String leido = leer.readUTF();

            leer.close();
            texto = leido;


        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero. Si procede creará uno nuevo.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return texto;
    }

    public void EscribeFich(String s, String f) {

        try {
            FileOutputStream fichero_escritura = new FileOutputStream(f);
            ObjectOutputStream escribir = new ObjectOutputStream(fichero_escritura);

            escribir.writeUTF(s);
            escribir.flush();
            escribir.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
