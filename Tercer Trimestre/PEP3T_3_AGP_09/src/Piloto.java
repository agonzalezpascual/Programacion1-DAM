
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
    public class Piloto {
        public static void main(String[] args) {

            Metodos M = new Metodos();

            M.mostrarFich();
            M.añadeNodo();
            M.mostrarFich();
            M.modNodo();
            M.mostrarFich();
            M.eliminaNodo();
            M.mostrarFich();

        }
    }





