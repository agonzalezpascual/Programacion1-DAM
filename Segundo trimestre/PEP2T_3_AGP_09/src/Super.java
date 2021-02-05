
public class Super extends Establecimiento {

    /*
     * Constructor del objeto Super, le pasa los datos al constructor de Establecimiento
     */
    public Super(String nombre, String fecha, String ubicacion, double extension, double facturacion) {
        super(nombre, fecha, ubicacion, extension, facturacion);
    }

    /*
     * Con este toString sacamos por pantalla el resultado de facturacion() y denomina()
     * sobreescribiendo el toString() de Establecimiento
     */
    public String toString() {

        return facturacion() + "\n" + denomina("se inauguró el");
    }
}
