import java.util.Date;

public class Hiper extends Establecimiento{
    public Hiper(String nombre, String fecha, String ubicacion, double extension, double facturacion){
        super(nombre, fecha, ubicacion, extension, facturacion);

    }

    public String toString() {
        return facturacion() +"\n"+denomina("se abrió el") ;
    }
}
