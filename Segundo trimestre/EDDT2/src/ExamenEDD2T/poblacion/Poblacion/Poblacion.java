package ExamenEDD2T.poblacion.Poblacion;

/*
 *  Importamos Festivo para poder trabajar con objetos de tipo Festivo
 */

import ExamenEDD2T.poblacion.Festivo.Festivo;

public interface Poblacion {

    /*
     *  Declaramos los métodos a implementar
     */

    public String getNombre();
    public int getNumHabit();
    public int getPerTra();
    public int getPerEmp();
    public double getSuperf();
    public Festivo getFestiv();
    public void setNumHabit(int numHabit);
    public void setPerTra(int perTra);
    public void setPerEmp(int perEmp);
    public void setFestiv(Festivo festiv);
    public double getPerDesemp(int numHabit, int perEmp);
    public double getDenPob(int numHabit, double superf);

}
