package EDDPractica4;

public class Segmento extends Punto3D {

    Punto3D p;
    Punto3D q;
    Segmento s;
    public Segmento(Punto3D p, Punto3D q){
        super(p,q);
        this.p = p;
        this.q = q;
    }

    public double DistanciaExtremos(Segmento S){

       return distanciaPunto3D(S.p, S.q);

    }

    @Override
    public String toString() {
        return "[ " +
                  p.toString() +
                ", " + q.toString() +
                " ]";
    }

    public Punto3D getP() {
        return p;
    }

    public void setP(Punto3D p) {
        this.p = p;
    }

    public Punto3D getQ() {
        return q;
    }

    public void setQ(Punto3D q) {
        this.q = q;
    }
}
