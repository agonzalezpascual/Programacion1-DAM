import java.util.Arrays;
public class NoticiasSindicadas2 {
    String[] secciones = {"Opinión", "Tecnología", "Ciencia", "Salud"};
    int[] vecesAccedidos = {0, 0, 0, 0};
    String[] articulosFavoritos = new String[10];

    public NoticiasSindicadas2() {
        //Inicializa aquí la tabla con tus articulosFavoritos:
    }
    public void setarticuloFavorito (int favoriteIndex, String nuevoArticulo) {
        // Añade nuevoArticulo to articulosFavoritos:
        articulosFavoritos[favoriteIndex] = nuevoArticulo;
    }
    public static void main(String[] args) {
        NoticiasSindicadas2 tableroPublic = new NoticiasSindicadas2();
        tableroPublic.setarticuloFavorito (2, "Cambio Climático: ¿y ahora qué?");
        tableroPublic.setarticuloFavorito (3, "Los Robots: amenaza u oportunidad");
        tableroPublic.setarticuloFavorito (0, "El Petróleo se o nos agota");
        System.out.println(Arrays.toString(tableroPublic.articulosFavoritos));
    }
}
