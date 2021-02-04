package Pasta;

public class Ramen extends Noodle {
    public Ramen(int longitud, int anchura) {
        super(longitud, anchura);
        forma = "Cueza el ramen 5 minutos en caldo, añada la carne, los champiñones, el huevo y las verduras.";
        harina = "trigo";
    }
    public String getForma(){

        return forma;
    }
    public String getHarina(){

        return harina;
    }
}
