package Pasta;

public class Espagueti extends Noodle{

    public Espagueti(int longitud, int anchura) {
        super(longitud, anchura);
        forma = "Cueza los spaghettis de 8 a 10 minutos y añada la salsa al gusto, queso o aceite y ajo.";
        harina = "sémola";
    }
    public String getForma(){

        return forma;
    }
    public String getHarina(){

        return harina;
    }
}
