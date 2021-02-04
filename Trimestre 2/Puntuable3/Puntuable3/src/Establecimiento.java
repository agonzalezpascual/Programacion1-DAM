import java.text.DecimalFormat;

public class Establecimiento {
    String nombre;
    String fecha;
    String ubicacion;
    double extension;
    double facturacion;


    public Establecimiento(String nombre, String fecha, String ubicacion, double extension, double facturacion){
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.extension = extension;
        this.facturacion = facturacion;

    }

    public String formadate(){

        return fecha.replaceAll("-","/");
    }


    public String denomina(String frase){
        return "Este "+ getClass().getName()+" "+ frase+" " + formadate();
    }

    public String facturacion(){
        DecimalFormat formateador = new DecimalFormat("###,###,###.00¤");

        return getClass().getName() + " ha tenido una facturación de "+  formateador.format(facturacion);
    }



    public static void main(String[] args) {
        double facturacionTotal =0.0;
        Establecimiento[] Tabla= new Establecimiento[3];
        Tabla[0]= new Hiper("San Pablo", "2015-2-14" , "Céntrico", 230.20, 2654650.55);
        System.out.println(Tabla[0].toString());
        Tabla[1]= new Super("Macarena", "2015-2-14", "Céntrico", 500.50, 10.5);
        System.out.println(Tabla[1].toString());
        Tabla[2]= new Cash("Nervión", "2015-2-14", "Céntrico", 320.20, 5.5);
        System.out.println(Tabla[2].toString());
        for(int i=0; i<Tabla.length; i++){
            facturacionTotal+= Tabla[i].facturacion;
        }
        System.out.println(facturacionTotal);
    }
}
