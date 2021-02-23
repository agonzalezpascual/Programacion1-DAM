package ExamenEDD2T.poblacion.Poblacion;

/*
 *  Importamos Festivo e ImpFestivo para poder trabajar con objetos de tipo Festivo
 */

import ExamenEDD2T.poblacion.Festivo.Festivo;
import ExamenEDD2T.poblacion.Festivo.ImpFestivo;

public class Testpoblacion {

    public static void main(String[] args){

        /*
         * Declaramos un objeto de tipo Festivo
         */

        Festivo feria = new ImpFestivo("La Feria de Sevilla","Abril");


        /*
         * Declaramos un objeto de tipo Población
         */

        Poblacion sevilla = new ImpPoblacion("Sevilla", 1942389, 1576249, 1598249, 14036, feria);

        /*
         * Imprimimos el contenido del objeto gracias al método toString()
         */

       System.out.println(sevilla.toString());
    }
}
