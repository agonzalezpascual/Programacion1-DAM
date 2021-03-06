package EP4ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PilotaAtlas {

    public static void main(String[] args) throws InputMismatchException {
        Scanner teclado = new Scanner(System.in);
        Atlas atlas = new Atlas();
        String pais = "";
        String capital = "";
        String input;
        int opc = 0;
        boolean menu = true;

        while (menu) {
            try {
                System.out.println();
                System.out.println(" 1.Añadir una entrada al atlas \t 2.Mostrar el contenido actual del atlas \n 3.Buscar una entrada del atlas \t 4.Modificar una entrada del atlas \n 5.Eliminar una entrada del atlas \t 6.Elimina el contenido completo del atlas \n 7.Salir\n\n"
                );
                System.out.print("Introduzca una opción: ");

                opc = teclado.nextInt();
                System.out.println();
                switch (opc) {

                    case 1:
                        System.out.print("Introduzca el país: ");
                        pais = teclado.nextLine();
                        System.out.print("Introduzca la capital: ");
                        capital = teclado.nextLine();
                        atlas.añadEnt(pais, capital);
                        System.out.println("Nueva entrada incorporada");
                        break;

                    case 2:
                        atlas.muestEnt();
                        break;

                    case 3:
                        System.out.print("Introduzca el país: ");
                        pais = teclado.nextLine();
                        atlas.devEnt(atlas.buscEnt(pais));
                        break;

                    case 4:
                        System.out.print("Introduzca el país: ");
                        pais = teclado.nextLine();
                        System.out.print("Introduzca la modificación de capital: ");
                        capital = teclado.nextLine();
                        if (atlas.buscEnt(pais) != -1) {
                            atlas.modEnt(atlas.buscEnt(pais), capital);
                        }
                        break;
                    case 5:
                        System.out.print("Introduzca el país: ");
                        pais = teclado.nextLine();
                        atlas.quitEnt(atlas.buscEnt(pais));
                        break;

                    case 6:
                        atlas.borAtl();
                        break;

                    case 7:
                        menu = false;
                        System.out.println("Hasta la próxima");
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Debes teclear un número entero entre 1 y 7");
                teclado.nextLine();
            }
        }
        teclado.close();
    }
}
