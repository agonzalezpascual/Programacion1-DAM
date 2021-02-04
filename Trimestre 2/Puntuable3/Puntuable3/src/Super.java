import java.util.Date;

public class Super extends Establecimiento {
    public Super(String nombre, String fecha, String ubicacion, double extension, double facturacion){
        super(nombre, fecha, ubicacion, extension, facturacion);

    }

    public String toString() {
        return facturacion() +"\n"+denomina("se inauguró el") ;
    }
}

