package ExamenEDD2T.debug;

public class ClasePrincipal {
    public static void main(String[] args){

        /*
         *  Para debuguear este código vamos a entrar en la pantalla Debugger de IntellijIdea,
         *  para realizar esto primero le damos al símbolo del bicho arriba a la derecha (
         *  previamente habiendo colocado algún punto de rotura clicando al lado del número
         *  que aparece a la izquierda del código), tras esto vamos a pulsar F7 (step into), de esta forma
         *  seguiremos el flujo de la ejecución del programa (por ejemplo, si hubiera condicionales entraríamos
         *  en la condición seleccionada), en contraposición de pulsar F8 (step over), el cual sigue
         *  la escritura del código y no su flujo. Hay que tener cuidado al usar F7 ya que podemos
         *  entrar en métodos de otras clases y esto no siempre nos interesa, por ejemplo,
         *  al entrar en el método toString() nos llevará al método de la clase Object, ya que aquí
         *  está contenido el "padre" de todos los objetos y este será el método toString() que sobreescriban
         *  todos los objetos "hijos". Para evitar esto pulsamos Mayus + F8 (step out) y saldremos de esta clase,
         *  aunque es más eficiente usar F8 directamente en estos casos para no entrar en otras clases.
         */


        /*
         *  Primero inicializamos la cadena con el valor "a", podemos poner
         *  el primer punto de rotura en la línea 27 y pulsamos F7 para comprobarlo.
         */

        String cadena = "a";
        System.out.println(cadena);

        /*
         *  Ahora entra en el bucle do while, el cual realizará 4 iteraciones del mismo,
         *  hasta que la cadena tenga longitud 5 con la forma "aeeee".
         *  Podemos poner en la línea 36 el segundo punto de rotura para comprobarlo.
         */

        do{
            cadena = cadena + "e";
        }while(cadena.length()<5);
        System.out.println(cadena);

        /*
         *  En este caso a primera vista parecería que no se va a ejecutar el bucle,
         *  ya que no se cumple la condición, pero esto no es así ya que el bucle
         *  do while hace siempre por lo menos una iteración del mismo, por lo
         *  que finalmente la variable cadena contendrá "aeeeei".
         *  Podemos comprobarlo fácilmente poniendo un punto de rotura en la línea 49.
         */

        do{
            cadena = cadena + "i";
        }while(cadena.length()<3);
        System.out.println(cadena);
    }
}
