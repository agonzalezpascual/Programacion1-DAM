import java.util.Arrays;

public class NoticiasSindicadas {
    public NoticiasSindicadas() {
    }
    public String[] getSecciones() {
 String[] secciones = {"Opinión","Tecnología","Ciencia","Salud"};
        return secciones;
    }
    public static void main(String[] args) {
        NoticiasSindicadas sindicRecop = new NoticiasSindicadas();
        String[] secciones = sindicRecop.getSecciones();
        System.out.println(secciones); // Si lo hacemos así sacamos el Hash del objeto
        System.out.println(Arrays.toString(secciones)); // ASí imprimimos el contenido de la Array
        System.out.println(secciones[0]);
    }
}
