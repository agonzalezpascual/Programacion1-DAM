import java.io.*;
import java.io.IOException;
import java.util.Scanner;


public class Piloto {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {

        ManejaArchivo G = new ManejaArchivo();
        IOArchivo crea = new IOArchivo();

        crea.EscribeFich("\nNúmero del abonado: 12345\nNombre: Pepe\nValor de la factura: 534,56\n---------------------------\nNúmero del abonado: 123456\nNombre: Juan\nValor de la factura: 43,68\n---------------------------\nNúmero del abonado: 1234567\nNombre: Ivan\nValor de la factura: 35,12\n---------------------------");

        while (true) {


            System.out.println();
            System.out.println("Menú de Opciones");
            System.out.println("================");
            System.out.println();
            System.out.println("1) Alta de nuevas facturas");
            System.out.println("2) Modificación del valor de factura");
            System.out.println("3) Consulta del dato de facturación de un abonado");
            System.out.println("4) Consulta del dato de facturación total de la compañía");
            System.out.println("5) Eliminar el fichero");
            System.out.println("6) Salir");
            System.out.println();

            System.out.print("Opción: ");
            int opcion = teclado.nextInt();
            System.out.println();


            switch (opcion) {
                case 1: {
                    G.altaFac(crea.LeeFich());
                    break;

                }
                case 2 : {
                    G.modifFact();
                    break;

                }
                case 3 : {
                    G.consultAbonado();
                    break;

                }
                case 4 : {
                    G.factTotal();
                    break;

                }
                case 5 : {
                    G.eliminaFich();
                    break;

                }
                case 6 : {
                    System.out.println("Hasta la próxima");
                    System.exit(0);
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + opcion);
            }
        }



    }



}





