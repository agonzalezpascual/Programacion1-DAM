package EDDPractica4;

public class Piloto {

    public static void main(String[] args){
        Punto3D P = new Punto3D(1,2,3);
        Punto3D Q = new Punto3D(4,5,6);
        Segmento S = new Segmento(P,Q);
        System.out.println(S.toString());
        System.out.println(S.DistanciaExtremos(S));
    }
}
