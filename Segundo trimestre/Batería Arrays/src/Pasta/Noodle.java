package Pasta;

public class Noodle {
    int longitud, anchura;
    String forma, harina;

    public Noodle (int longitud, int anchura){
        this.longitud = longitud;
        this.anchura = anchura;
        public void preparacion(String forma){
            this.forma = forma;
            System.out.println(forma);
        }
        public void harina_base(String harina){
            this.harina = harina;
            System.out.println("Básicamente está hecho de harina de " + harina);
        }
    }


    public static void main(String[] args){
        Noodle [] pasta = new Noodle[3];
        pasta[0] = new Espagueti(10,2);
        pasta[0] = new Pho(10,2);
        pasta[0] = new Ramen(10,2);
        for(Noodle i: pasta){
            i.preparacion(i.getForma);

        }
    }
}
