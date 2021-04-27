import java.io.*;
import java.util.Scanner;

public class ManejaArchivo {

    Scanner teclado = new Scanner(System.in);
    IOArchivo IO = new IOArchivo();

    String NumAbonado, nombre, ValorFact;



    public void altaFac(String s) {
        try{System.out.println("Alta de factura");
        System.out.println();

        System.out.print("Número del abonado: ");
        NumAbonado = teclado.nextLine();

        if (devuelveFact(NumAbonado) == ""){

            System.out.print("Nombre: ");
            nombre = teclado.nextLine();

            System.out.print("Valor de la factura: ");
            ValorFact = teclado.nextLine();

            IO.EscribeFich(s + "\nNúmero del abonado: " + NumAbonado + "\nNombre: " + nombre + "\nValor de la factura: " + ValorFact.replace(",", ".") + "\n---------------------------");

            System.out.println("\nDatos incorparados al fichero.");

        }else{
            System.out.println("\nEste abonado ya se encuentra registrado.");
        }}catch (Exception e){}
    }

    public void modifFact() {

        System.out.println("Modificación del valor de factura");
        System.out.println();

        System.out.print("Número del abonado: ");
        NumAbonado = teclado.nextLine();

        if (devuelveFact(NumAbonado) != ""){
            System.out.println("Valor de la factura: " + devuelveFact(NumAbonado).replace(".", ",") + "€");
            System.out.println();

            System.out.print("Nuevo Valor factura: ");
            ValorFact = teclado.nextLine();

            IO.EscribeFich(IO.LeeFich().replace(devuelveFact(NumAbonado), ValorFact));

            System.out.println();
            System.out.println("Datos modificado en el fichero.");
            System.out.println();
        }else{
            System.out.println();
            System.out.println("Abonado no encontrado.");
            System.out.println();
        }
    }

    public void consultAbonado() {
        System.out.println("Consulta facturación abonado");
        System.out.println();

        System.out.print("Número del abonado: ");
        NumAbonado = teclado.nextLine();

        if (devuelveFact(NumAbonado) == "") {
            System.out.println();
            System.out.println("Abonado no encontrado.");
            System.out.println();
        } else {
            System.out.println("Valor de la factura: " + devuelveFact(NumAbonado).replace(".", ",") + "€");
            System.out.println();
        }
    }

    public void factTotal() {
        System.out.println("Consulta facturación total");
        System.out.println();


            try {
                System.out.println("Facturación total: " + String.format("%.2f", Double.parseDouble(devuelveFact("Total"))) + " €");
            }catch (Exception e){}
            System.out.println();
    }

    public void eliminaFich() {
        System.out.println("Eliminar fichero");
        System.out.println();

        File fichero = new File("tel.dat");

        fichero.delete();

        System.out.println("Fichero eliminado");
        System.out.println();

    }

    public static String devuelveFact(String Num) {

        String devolver = "";
        String NumAbonado = Num;

        try (BufferedReader lectura_buffer = new BufferedReader(new FileReader("tel.dat"))) {

            if (Num == "Total") {

                String line, dinero;
                Double suma = 0.0;

                while ((line = lectura_buffer.readLine()) != null) {

                    if (line.contains("Valor de la factura: ")) {
                        dinero = line.substring(21);
                        suma += Double.parseDouble(dinero.replace(",","."));
                    }
                }

                devolver = String.valueOf(suma);

            } else {

                String line;

                while ((line = lectura_buffer.readLine()) != null) {

                    if (line.equals("Número del abonado: " + NumAbonado)) {
                        lectura_buffer.readLine();
                        devolver = lectura_buffer.readLine().substring(21);
                        break;
                    }
                }
            }
        }catch (FileNotFoundException f){
            System.out.println("No existe el fichero");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return devolver;
    }

    }
