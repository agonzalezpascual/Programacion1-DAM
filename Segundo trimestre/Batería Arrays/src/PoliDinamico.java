class MedioTransporte {
    public void cogeInfo() {
        System.out.println("MedioTransporte");
    }
}
class Aereo extends MedioTransporte {
    int numMotores;
    public void cogeInfo() {
        System.out.println("Aereo");
    }
}
class Avion extends Aereo {
    public Avion(int numMotores) {
        this.numMotores = numMotores;
    }
    public void cogeInfo() {
        System.out.println("Avión");
    }
    public void cogeNumMotores() {
        System.out.println("Tiene "+numMotores +" motores");
    }
}
class Helicoptero extends Aereo {
    public Helicoptero(int numMotores) {
        this.numMotores = numMotores;
    }
    public void cogeInfo() {
        System.out.println("Helicoptero");
    }
    public void cogeNumMotores() {
        System.out.println("Tiene "+numMotores +" motores");
    }
}
public class PoliDinamico{
    public static void main(String []args){
        MedioTransporte elMedio = new Avion(4);
        Helicoptero heli = new Helicoptero(2);
        System.out.println("Encontramos que la "+elMedio.getClass()); // No es necesario el toString() en ninguno de los dos
        ((Avion) elMedio).cogeNumMotores();
        System.out.println("Encontramos que la "+heli.getClass().toString());
        heli.cogeNumMotores();
    }
}
