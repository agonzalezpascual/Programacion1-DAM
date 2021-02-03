package Pasta;

public class Pho extends Noodle {
    public Pho(int longitud, int anchura) {
        super(longitud, anchura);
        this.forma = "Hidrate los pho durante 1 hora, para luego cocerlos 1 minuto en caldo. Finalmente sazónelos con cilantro y jalapeños.";
        this.harina = "arroz";
    }
    public String getForma(){

        return forma;
    }
    public String getHarina(){

        return harina;
    }
}
