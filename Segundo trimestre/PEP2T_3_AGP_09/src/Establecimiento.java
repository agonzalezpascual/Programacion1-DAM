
import java.text.DecimalFormat;

public class Establecimiento {
    String nombre;
    String fecha;
    String ubicacion;
    double extension;
    double facturacion;
    static DecimalFormat formateador = new DecimalFormat("###,###,###.00¤");

    /*
     * Este es el método constructor de la clase Establecimiento
     */

    public Establecimiento(String nombre, String fecha, String ubicacion, double extension, double facturacion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.extension = extension;
        this.facturacion = facturacion;
    }

    /*
     * Con esta función cogemos los carácteres del mes y los ponemos al principio de la cadena
     * ,los del día y los ponemos a la mitad, los dos últimos del año y los dejamos al final
     * y por último cambiamos los - por /
     */
    public String formadate() {

        return fecha.substring(3,6).concat(fecha.substring(0,3)).concat(fecha.substring(8,10)).replaceAll("-", "/");
    }

    /*
     * Este método nos devuelve la String: Este (nombre de la clase) (frase identificatoria) {fecha de apertura}.
     */
    public String denomina(String frase) {

        return "Este " + getClass().getName() + " " + frase + " " + formadate();
    }

    /*
     * Este método nos devuelve la String: {nombre} ha tenido una facturación de {facturación}
     */
    public String facturacion() {

        return getClass().getName() + " ha tenido una facturación de " + formateador.format(facturacion);
    }

    /*
     * Con este toString sacamos por pantalla el resultado de denomina()
     */
    public String toString() {

        return denomina("se fundó");
    }


    // Método main
    public static void main(String[] args) {

        // Definiciones
        double facturacionTotal = 0.0;
        Establecimiento[] Tabla = new Establecimiento[4];

        // Instanciamos los objetos dentro de una tabla
        Tabla[0] = new Establecimiento("Holding","01-03-2014", "Céntrico", 0,0);

        Tabla[1] = new Hiper("San Pablo", "02-14-2015", "Céntrico", 230.2, 2654650.55);

        Tabla[2] = new Super("Macarena", "02-14-2015", "Céntrico", 500.5, 10.5);

        Tabla[3] = new Cash("Nervión", "02-14-2015", "Céntrico", 320.2, 5.5);


        /*
         * Con este bucle for imprimimos los toString() y calculamos la facturación total
         */

        for(int i = 0; i < Tabla.length; ++i) {

            facturacionTotal += Tabla[i].facturacion;
            System.out.println(Tabla[i].toString());
            System.out.println();
        }

        // Imprimimos por pantalla la facturación total
        System.out.println("La facturación total de nuestros establecimientos fue: "+formateador.format(facturacionTotal));
    }
}
