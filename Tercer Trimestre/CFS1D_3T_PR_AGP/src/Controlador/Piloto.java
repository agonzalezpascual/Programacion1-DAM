package Controlador;
import Modelo.IOArchivo;
import Modelo.ManejaFich;


public class Piloto {

    public static void main(String[] args) {

        Proyectos ventana = new Proyectos();
        ManejaFich IO = new ManejaFich();
        IOArchivo IOD = new IOArchivo();

        ventana.creaGUI(args[0]);
        IO.mostrarFich();
        System.out.println();
        System.out.println(IOD.LeeFich("datos.dat"));
        IOD.EscribeFich("\n1,1,'Estegano','Python','9.53'\n2,1,'CV Web','HTML','8.27'\n3,2,'Forfait Nieve','Java','7.15'\n4,2,'Sindicacion','XML','6.33'\n5,3,'Banco de Sangre', 'Java', '5.92'\n6,3,'Concesionario', 'Django/Python', '8.85'", "proyectos.dat");
        String txt = IOD.LeeFich("proyectos.dat");




    }

}
