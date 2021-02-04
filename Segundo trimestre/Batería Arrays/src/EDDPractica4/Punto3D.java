package EDDPractica4;

import static java.lang.StrictMath.sqrt;

public class Punto3D {
    double x, y, z, x2, y2, z2;
    Punto3D p;
    Punto3D q;

    public Punto3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Punto3D (Punto3D p, Punto3D q){
        new Punto3D(p.x, p.y, p.z);
        new Punto3D(q.x, q.y, q.z);
    }

    public double distanciaPunto3D(Punto3D p, Punto3D q){
        x = p.x;
        y = p.y;
        z = p.z;
        x2 = q.x;
        y2 = q.y;
        z2 = q.z;
        return Math.sqrt(Math.pow((x - x2),2) + Math.pow((y - y2),2) + Math.pow((z - z2),2));

    }

    @Override
    public String toString() {
        return "Las coordenadas del Punto3D son :" +
                "(" + x +
                "," + y +
                "," + z +
                ')';
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }
}

