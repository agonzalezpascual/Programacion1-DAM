package ExamenEDD2T.poblacion.Festivo;

public class TestFestivo {
    public static void main (String[] args){

        /*
         * Declaramos un objeto de tipo Festivo
         */

        Festivo feria = new ImpFestivo("La Feria de Sevilla","Abril");

        /*
         * Imprimimos el contenido del objeto gracias al método toString()
         */

        System.out.println(feria.toString());

    }
}
