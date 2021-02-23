package ExamenEDD2T.poblacion.Festivo;

public class ImpFestivo implements Festivo{

    /*
     *  Declaramos los atributos
     */

    private String nomFiesta, mes;

    /*
     *  Declaramos el contructor
     */

    public ImpFestivo(String nomFiesta, String mes){

        this.nomFiesta = nomFiesta;
        this.mes = mes;

    }

    /*
     *  Declaramos los métodos getter
     */

    public String getNomFiesta() {
        return nomFiesta;
    }

    public String getMes() {
        return mes;
    }

    /*
     *  Declaramos el método setter
     */

    public void setMes(String mes) {
        this.mes = mes;
    }

    /*
     *  Declaramos el método toString()
     */

    public String toString(){

        return getNomFiesta() + ", en " + getMes();

    }
}
