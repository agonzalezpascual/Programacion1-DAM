import java.util.Arrays;

public class Tabla1 {
    public static void main(String[] args) {
        String[] telef = {"987987987", "976976976", "965965965", "954954954"};
        for (int i = 0; i < telef.length; i++){
            if (args[0].equals(telef[i])) { // USAMOS equals YA QUE ESTAMOS COMPARANDO OJBETOS, SI USAMOS == ESTAREMOS COMPARADO SU HASH NO SU CONTENIDO
            System.out.println("El número ya se encuentra en la base de datos en la posición " + i);
        }
    }

    }
}
