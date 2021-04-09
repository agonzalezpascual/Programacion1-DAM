import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;


public class Piloto {

    public static void main(String[] args) {

        EscribeFich("Número del abonado: 12345\nNombre: Pepe\nValor de la factura: 534,56\n---------------------------\nNúmero del abonado: 123456\nNombre: Juan\nValor de la factura: 43,68\n---------------------------\nNúmero del abonado: 1234567\nNombre: Ivan\nValor de la factura: 35,12");
        System.out.println(LeeFich());
    }

    public static void EscribeFich(String s) {

        try {
            FileOutputStream Fos = new FileOutputStream("tel.dat");
            ObjectOutputStream Oos = new ObjectOutputStream(Fos);

            Oos.writeUTF(s);
            Oos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String LeeFich() {

        String s = "";
        try {
            FileInputStream Fis = new FileInputStream("tel.dat");
            ObjectInputStream Ois = new ObjectInputStream(Fis);
            s = Ois.readUTF();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }
}




