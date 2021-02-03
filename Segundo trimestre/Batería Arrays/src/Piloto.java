
import java.util.Arrays;

class MiClaseA {
    private String nombre;
    public MiClaseA(String nombre) {
        this.nombre = nombre;
    }
    public String darInfo() {
        return this.nombre;
    }
}
class MiClaseB extends MiClaseA {
    private String color;
    public MiClaseB(String nombre, String color) {
        super(nombre);
        this.color = color;
    }
    public String darInfo() {
        return super.darInfo() + " (" + this.color + ")";
    }
}



public class Piloto {
    public static void main(String args[]) {
        MiClaseA [] guardoClases = new MiClaseA[4];
        guardoClases[0] = new MiClaseA("Olivia");
        guardoClases[1] = new MiClaseB("Iván", "Verde");
        guardoClases[2] = new MiClaseA("Alberto");
        guardoClases[3] = new MiClaseB("Virginia", "Azul");
        for(MiClaseA cadauno: guardoClases) {
            System.out.println(cadauno.darInfo());
        }
    }
}
