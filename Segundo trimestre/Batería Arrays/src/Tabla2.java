import java.util.Scanner;

public class Tabla2 {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        String[] estudiantes = {"Alumno1","Alumno2","Alumno3","Alumno4"};
        double[] programacion = new double[4]; // Inicializamos la tabla vacía
        for (int i = 0; i < estudiantes.length; i++){ // Con este bucle for introducimos en la Array las notas de los estudiantes
            System.out.println("Introduzca la nota número "+ i);
            int notas = teclado.nextInt();
            programacion[i] = notas;
        }
        System.out.println("Tras la revisión se han alterado las notas de los alumnos 1 y 3");
        programacion[0] = 9.75;
        programacion[3] = 7.5;
        System.out.println("Esta aula tiene: " + estudiantes.length + " alumnos");
    }
}
