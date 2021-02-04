public class Caja {
    int ancho;
    int largo;
    int alto;
    public Caja (int ancho, int largo, int alto){
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
    }
    public Caja (Caja miCaja){
        this.alto = miCaja.alto;
        this.ancho = miCaja.ancho;
        this.largo = miCaja.largo;

    }
    public int volCaja (int ancho, int largo, int alto){
        return ancho*alto*largo;
    }

    @Override
    public String toString() {
        return "El volumen de la caja es de " + volCaja(ancho,alto,largo);
    }
}
