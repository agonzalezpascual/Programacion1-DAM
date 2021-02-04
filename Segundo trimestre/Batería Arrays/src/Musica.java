import java.util.*;
class Instrumento{
    public void tocar() {System.out.println("Instrumento.tocar()");}
    public String tipo() {return "Instrumento";}
    public void afinar() {}
}
class Guitarra extends Instrumento { // Sobreescribimos los métodos
    public void tocar() {System.out.println("Guitarra.tocar()");}
    public String tipo() {return "Guitarra";}
    public void afinar() {}
}
class Piano extends Instrumento { // Sobreescribimos los métodos
    public void tocar() {System.out.println("Piano.tocar()");}
    public String tipo() {return "Piano";}
    public void afinar() {}
}
class Saxofon extends Instrumento { // Sobreescribimos los métodos
    public void tocar() {System.out.println("Saxofon.tocar()");}
    public String tipo() { return "Saxofon"; }
    public void afinar() {}
}
class Guzla extends Guitarra { // Sobreescribimos los métodos
    public void tocar() {System.out.println("Guzla.tocar()");}
    public void afinar() {System.out.println("Guzla.afinar()");}
}
class Ukelele extends Guitarra { // Sobreescribimos los métodos
    public void tocar() {System.out.println("Ukelele.tocar()");}
    public String tipo() {return "Ukelele";}
}


public class Musica {
    /*
     *No hay sobreescritura de este metodo porque en afinarTodo()
     * estamos pasando como PARÁMETRO los instrumentos en lugar de realizar i.afinar()
     */
    static void afinar(Instrumento i) {
        i.tocar();
    }
    static void afinarTodo(Instrumento[] e) {
        for(int i = 0; i < e.length; i++)
            afinar(e[i]);
    }
    public static void main(String[] args) {
        System.out.println("Comienza la afinación de la orquesta...");
        Instrumento[] orquesta = new Instrumento[5];
        int i = 0;
        orquesta[i++] = new Guitarra();
        orquesta[i++] = new Piano();
        orquesta[i++] = new Saxofon();
        orquesta[i++] = new Guzla();
        orquesta[i] = new Ukelele();
        afinarTodo(orquesta);
    }
}
