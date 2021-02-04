public class PilotaCaja {
    public static void main(String[] args) {
        Caja miCaja = new Caja(1, 2, 3);
        Caja clonCaja = new Caja(miCaja);
        System.out.println( miCaja.toString());
        System.out.println( clonCaja.toString());
    }
}
