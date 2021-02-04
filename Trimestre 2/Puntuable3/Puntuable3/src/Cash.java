import java.util.Date;

public class Cash extends Establecimiento {
    public Cash(String nombre, String fecha, String ubicacion, double extension, double facturacion){
        super(nombre, fecha, ubicacion, extension, facturacion);

    }

    public String toString() {
        return facturacion() +"\n"+denomina("se puso en servicio el") ;
    }
}
