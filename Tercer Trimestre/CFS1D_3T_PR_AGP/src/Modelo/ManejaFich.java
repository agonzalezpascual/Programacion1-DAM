package Modelo;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ManejaFich {

    public IOArchivo IO = new IOArchivo();

    public void mostrarFich() {

        //Creamos una referencia (fichXML) de tipo File al cargar el fichero XML existente
        File fichXML = new File("datos.xml");
        try {
            //Parsea el fichero y lo convierte de fichero a documento XML recorrible
            DocumentBuilderFactory factoriaDoc = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructDoc = factoriaDoc.newDocumentBuilder();
            Document docDOM = constructDoc.parse(fichXML);
            //Elimina nodos vacíos y combina adyacentes en caso de que los hubiera
            docDOM.getDocumentElement().normalize();
            //Vuelca a una lista los nodos que cuelgan del nodo raíz
            NodeList pelic = docDOM.getElementsByTagName("datos");
            IO.EscribeFich(pelic.item(0).getTextContent(),"datos.dat");
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
