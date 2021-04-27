import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Metodos {

    public void mostrarFich() {

        //Creamos una referencia (fichXML) de tipo File al cargar el fichero XML existente
        File fichXML = new File("src/peliculas.xml");
        try {
            //Parsea el fichero y lo convierte de fichero a documento XML recorrible
            DocumentBuilderFactory factoriaDoc = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructDoc = factoriaDoc.newDocumentBuilder();
            Document docDOM = constructDoc.parse(fichXML);
            //Elimina nodos vacíos y combina adyacentes en caso de que los hubiera
            docDOM.getDocumentElement().normalize();
            //Localizamos e imprimimos cuál es el elemento raíz
            System.out.println("\n========================");
            Element raiz = docDOM.getDocumentElement();
            System.out.println("Elemento raíz: " + raiz.getNodeName());
            System.out.println("========================");
            //Vuelca a una lista los nodos que cuelgan del nodo raíz
            NodeList pelic = docDOM.getElementsByTagName("pelicula");
            for (int cont = 0; cont < pelic.getLength(); cont++) {
                //Se recorre la lista con nodos y se extrae en nodo el que indica cont
                Node nodo = pelic.item(cont);
                //Para saber qué nodo está procesando, imprime el nombre
                System.out.println("------------------------");
                System.out.println(nodo.getNodeName()+" --> Nodo: "+cont);
                //Comprueba si se encuentra ante un elemento
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    //Castea el nodo de tipo Node a uno de tipo Element
                    Element element = (Element) nodo;
                    System.out.println("Título: " + element.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Guionista: " + element.getElementsByTagName("guionista").item(0).getTextContent());
                    System.out.println("Productora: " + element.getElementsByTagName("productora").item(0).getTextContent());
                    System.out.println("Director: " + element.getElementsByTagName("director").item(0).getTextContent());
                    System.out.println("Actor: " + element.getElementsByTagName("actor").item(0).getTextContent());
                    System.out.println("Sinopsis: " + element.getElementsByTagName("sinopsis").item(0).getTextContent());
                }
            }
            System.out.println("------------------------");
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void añadeNodo(){

        File fichXML = new File("src/peliculas.xml");
        try {
            //Parsea el fichero y lo convierte de fichero a documento XML recorrible
            DocumentBuilderFactory factoriaDoc = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructDoc = factoriaDoc.newDocumentBuilder();
            Document docDOM = constructDoc.parse(fichXML);
            //Elimina nodos vacíos y combina adyacentes en caso de que los hubiera
            docDOM.getDocumentElement().normalize();
            Element raiz = docDOM.getDocumentElement();
            Element Pelicula = docDOM.createElement("pelicula");
            // Insertar último raiz.appendChild(Pelicula);
            // Insertar primero raiz.insertBefore(Pelicula, raiz.getFirstChild());
            // Insertar en medio
            NodeList listpelic = docDOM.getElementsByTagName("pelicula");
            Node p = listpelic.item(2);
            raiz.insertBefore(Pelicula, p);
            // Crea el elemento Titulo, le da valor y lo asigna como nodo al elemento Pelicula
            Element Titulo = docDOM.createElement("titulo");
            Titulo.appendChild(docDOM.createTextNode("Le Lion"));
            Pelicula.appendChild(Titulo);
            // Crea el elemento Nacionalidad, le da valor y lo asigna como nodo al elemento Pelicula
            Element Guionista = docDOM.createElement("guionista");
            Guionista.appendChild(docDOM.createTextNode("Pepito"));
            Pelicula.appendChild(Guionista);
            // Productora
            Element Productora = docDOM.createElement("productora");
            Productora.appendChild(docDOM.createTextNode("HolaHOa"));
            Pelicula.appendChild(Productora);
            // Crea el elemento Director, le da valor y lo asigna como nodo al elemento Pelicula
            Element Director = docDOM.createElement("director");
            Director.appendChild(docDOM.createTextNode("Ludovic Colbeau-Justin"));
            Pelicula.appendChild(Director);
            // Actor
            Element Actor = docDOM.createElement("actor");
            Actor.appendChild(docDOM.createTextNode("Yo"));
            Pelicula.appendChild(Actor);
            //Sinopsis
            Element Sinopsis = docDOM.createElement("sinopsis");
            Sinopsis.appendChild(docDOM.createTextNode("wewewe"));
            Pelicula.appendChild(Sinopsis);
            // Genera un objeto que permita transferir el contenido del árbol DOM hacia fichero
            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            // Prepara la instancia DOM para albergar el marcado XML generado hasta ahora
            DOMSource fuenteDom = new DOMSource(docDOM);
            // Crea el contenedor de un fichero de texto para contener la información en formato XML
            StreamResult resulFinal = new StreamResult(new File("src/peliculas.xml"));
 /* Si se quisiera mostrar por consola
 StreamResult result = new StreamResult(System.out); */
            // Coloca la información ahora en formato DOM en un fichero XML
            transformador.transform(fuenteDom, resulFinal);
            System.out.println("¡Fichero creado y guardado!");


    } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }

    public void modNodo(){

        File fichXML = new File("src/peliculas.xml");
        try{
        //Parsea el fichero y lo convierte de fichero a documento XML recorrible
        DocumentBuilderFactory factoriaDoc = DocumentBuilderFactory.newInstance();
        DocumentBuilder constructDoc = factoriaDoc.newDocumentBuilder();
        Document docDOM = constructDoc.parse(fichXML);
        //Elimina nodos vacíos y combina adyacentes en caso de que los hubiera
        docDOM.getDocumentElement().normalize();
        Element raiz = docDOM.getDocumentElement();
        NodeList listPelic = docDOM.getElementsByTagName("pelicula");
        NodeList DentroPelic = listPelic.item(2).getChildNodes();
        for (int cont2N = 0; cont2N < DentroPelic.getLength(); cont2N++) {
            //De la lista de alumnos, encajar uno a uno en forma de nodo
            Node nodoPelic = DentroPelic.item(cont2N);
            //Detecta el tipo de elemento
            if ("Le Lion".equals(nodoPelic.getTextContent())) {
                // Modifica todos los nodos denominacion del documento
                nodoPelic.setTextContent("wonwoneo");
            }}
            //Prepara el documento XML resultante para mostrarlo por pantalla y grabarlo
            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            //Muestra por pantalla el fichero XML tras la modificación
            System.out.println("---Documento XML resultante---");
            StreamResult consoleResult = new StreamResult(System.out);
            transformador.transform(source, consoleResult);
            //Indica el nombre del fichero sobre el que sobreescribirá tras la modificación
            StreamResult fileResult = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, fileResult);







            } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }

    public void eliminaNodo(){

        File fichXML = new File("src/peliculas.xml");
        try {
            //Parsea el fichero y lo convierte de fichero a documento XML recorrible
            DocumentBuilderFactory factoriaDoc = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructDoc = factoriaDoc.newDocumentBuilder();
            Document docDOM = constructDoc.parse(fichXML);
            //Elimina nodos vacíos y combina adyacentes en caso de que los hubiera
            docDOM.getDocumentElement().normalize();
            Element raiz = docDOM.getDocumentElement();
            NodeList listPelic = docDOM.getElementsByTagName("pelicula");
            NodeList DentroPelic = listPelic.item(2).getChildNodes();
            for (int cont2N = 0; cont2N < DentroPelic.getLength(); cont2N++) {
                //De la lista de alumnos, encajar uno a uno en forma de nodo
                Node nodoPelic = DentroPelic.item(cont2N);
                //Detecta el tipo de elemento
                if ("wonwoneo".equals(nodoPelic.getTextContent())) {
                    // Modifica todos los nodos denominacion del documento
                    nodoPelic.getParentNode().removeChild(nodoPelic);
                }
            }
            //Prepara el documento XML resultante para mostrarlo por pantalla y grabarlo
            TransformerFactory factoriaTransf = TransformerFactory.newInstance();
            Transformer transformador = factoriaTransf.newTransformer();
            DOMSource source = new DOMSource(docDOM);
            //Muestra por pantalla el fichero XML tras la modificación
            System.out.println("---Documento XML resultante---");
            StreamResult consoleResult = new StreamResult(System.out);
            transformador.transform(source, consoleResult);
            //Indica el nombre del fichero sobre el que sobreescribirá tras la modificación
            StreamResult fileResult = new StreamResult(new File("src/peliculas.xml"));
            transformador.transform(source, fileResult);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }

}
