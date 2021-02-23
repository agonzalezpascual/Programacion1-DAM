package ExamenEDD2T.poblacion.Poblacion;

    /*
     *  Importamos Festivo para poder trabajar con objetos de tipo Festivo
     */

import ExamenEDD2T.poblacion.Festivo.Festivo;

public class ImpPoblacion implements Poblacion {

    /*
     *  Declaramos los atributos
     */

    private String nombre;
    private int numHabit, perTra, perEmp;
    private double superf, denPob, porDesmp;
    private Festivo festiv;

    /*
     *  Declaramos el contructor
     */

    public ImpPoblacion (String nombre, int numHabit, int perTra,
                         int perEmp, double superf, Festivo festiv){

        this.nombre = nombre;
        this.numHabit = numHabit;
        this.perTra = perTra;
        this.perEmp = perEmp;
        this.superf = superf;
        this.festiv = festiv;

    }

    /*
     *  Declaramos los métodos getter
     */

    public String getNombre() {
        return nombre;
    }

    public int getNumHabit() {
        return numHabit;
    }

    public int getPerTra() {
        return perTra;
    }

    public int getPerEmp() {
        return perEmp;
    }

    public double getSuperf() {
        return superf;
    }

    public Festivo getFestiv() {
        return festiv;
    }


    /*
     *  Declaramos los métodos setter
     */

    public void setNumHabit(int numHabit) {
        this.numHabit = numHabit;
    }

    public void setPerTra(int perTra) {
        this.perTra = perTra;
    }

    public void setPerEmp(int perEmp) {
        this.perEmp = perEmp;
    }

    public void setFestiv(Festivo festiv) {
        this.festiv = festiv;
    }


    /*
     *  Declaramos el método getPerDesemp para hallar
     *  el porcentaje de desempleados en Sevilla a
     *  partir de su población y la cantidad de
     *  personas activas laboralmente hablando
     */


    public double getPerDesemp(int numHabit, int perEmp){

        porDesmp = perEmp/numHabit;
        return porDesmp;

    }

    /*
     *  Declaramos el método getDenPob para hallar
     *  la densidad de población en Sevilla a
     *  partir de su población y la extensión de
     *  la ciudad en km2
     */

    public double getDenPob(int numHabit, double superf){

        denPob = numHabit/superf;
        return denPob;
    }

    /*
     *  Declaramos el método toString()
     */

    public String toString(){

        return nombre + " posee una densidad de población de " + Math.floor(getDenPob(numHabit, superf)*100)/100 + " hab/km2." +
                " Una de sus fiestas más famosas es " + festiv.toString()+".";
    }
}
