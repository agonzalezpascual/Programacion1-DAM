import java.io.File;
import java.io.IOException;
import java.util.Scanner;
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

    Scanner teclado = new Scanner(System.in);

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

    public void añadeNodo(String s){

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

            switch (s){
            // Insertar último
                case "3":{raiz.appendChild(Pelicula); break;}
            // Insertar primero
                case "1": {raiz.insertBefore(Pelicula, raiz.getFirstChild()); break;}
            // Insertar en medio
                case "2":{
                    System.out.println("Introduzca la posición del nodo");
                    int posicion =Integer.parseInt(teclado.nextLine());

            NodeList listpelic = docDOM.getElementsByTagName("pelicula");
            Node p = listpelic.item(posicion);
            raiz.insertBefore(Pelicula, p);break;}}
            // Crea el elemento Titulo, le da valor y lo asigna como nodo al elemento Pelicula
            Element Titulo = docDOM.createElement("titulo");
            System.out.println("Introduzca el título");
            Titulo.appendChild(docDOM.createTextNode(teclado.nextLine()));
            Pelicula.appendChild(Titulo);
            // Crea el elemento Nacionalidad, le da valor y lo asigna como nodo al elemento Pelicula
            Element Guionista = docDOM.createElement("guionista");
            System.out.println("Introduzca el guionista");
            Guionista.appendChild(docDOM.createTextNode(teclado.nextLine()));
            Pelicula.appendChild(Guionista);
            // Productora
            Element Productora = docDOM.createElement("productora");
            System.out.println("Introduzca la productora");
            Productora.appendChild(docDOM.createTextNode(teclado.nextLine()));
            Pelicula.appendChild(Productora);
            // Crea el elemento Director, le da valor y lo asigna como nodo al elemento Pelicula
            Element Director = docDOM.createElement("director");
            System.out.println("Introduzca el director");
            Director.appendChild(docDOM.createTextNode(teclado.nextLine()));
            Pelicula.appendChild(Director);
            // Actor
            Element Actor = docDOM.createElement("actor");
            System.out.println("Introduzca el actor");
            Actor.appendChild(docDOM.createTextNode(teclado.nextLine()));
            Pelicula.appendChild(Actor);
            //Sinopsis
            Element Sinopsis = docDOM.createElement("sinopsis");
            System.out.println("Introduzca la sinopsis");
            Sinopsis.appendChild(docDOM.createTextNode(teclado.nextLine()));
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

    public void modNodo(String opc){

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
            NodeList DentroPelic;

        switch (opc){
            case "1":{
        // Al principio
            DentroPelic = listPelic.item(0).getChildNodes();
            Node nodeSelP = DentroPelic.item(menuS()-1);
            System.out.println("Introduzca el nuevo contenido para el nodo");
            nodeSelP.setTextContent(teclado.nextLine());
            break;}
            case "2":{
        // En medio
            String tituloBusq = teclado.nextLine();
        for(int cont = 0; cont < listPelic.getLength(); cont++){
            DentroPelic = listPelic.item(cont).getChildNodes();
            if (tituloBusq.equals(DentroPelic.item(0).getTextContent())) {

               Node nodeSel = DentroPelic.item(menuS()-1);
                System.out.println("Introduzca el nuevo contenido para el nodo");
                nodeSel.setTextContent(teclado.nextLine());
            }}
            break;}
            case "3":{
        // Al final
            DentroPelic = listPelic.item(listPelic.getLength()-1).getChildNodes();
            Node nodeSelF = DentroPelic.item(menuS()-1);
            System.out.println("Introduzca el nuevo contenido para el nodo");
            nodeSelF.setTextContent(teclado.nextLine());
            break;}}
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

    public void eliminaNodo(String opc){

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
            NodeList DentroPelic;
            switch (opc){
                case "1":{
                    // Al principio
                    listPelic.item(0).getParentNode().removeChild(listPelic.item(0));
                    break;}
                case "2":{
                    // En medio
                    String tituloBusq = teclado.nextLine();
                    for(int cont = 0; cont < listPelic.getLength(); cont++){
                        DentroPelic = listPelic.item(cont).getChildNodes();
                        if (tituloBusq.equals(DentroPelic.item(0).getTextContent())) {

                            listPelic.item(cont).getParentNode().removeChild(listPelic.item(cont));
                        }}
                    break;}
                case "3":{
                    // Al final
                    DentroPelic = listPelic.item(listPelic.getLength()-1).getChildNodes();
                    listPelic.item(listPelic.getLength()-1).getParentNode().removeChild(listPelic.item(listPelic.getLength()-1));
                    Node nodeSelF = DentroPelic.item(menuS());
                    System.out.println("Introduzca el nuevo contenido para el nodo");
                    nodeSelF.setTextContent(teclado.nextLine());
                    break;}}

            /*for (int cont2N = 0; cont2N < DentroPelic.getLength(); cont2N++) {
                //De la lista de alumnos, encajar uno a uno en forma de nodo
                Node nodoPelic = DentroPelic.item(cont2N);
                //Detecta el tipo de elemento
                if ("wonwoneo".equals(nodoPelic.getTextContent())) {
                    // Modifica todos los nodos denominacion del documento
                    nodoPelic.getParentNode().removeChild(nodoPelic);
                }
            }*/
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

    public void menuP(){

        while(true){
        System.out.println("1) Presentar el documento XML completo\n" +
                "2) Añadir nuevo nodo al documento\n" +
                "3) Modificar datos de un nodo del documento\n" +
                "4) Eliminar un nodo concreto del documento\n" +
                "5) Salir\n");

        String opc = teclado.nextLine();

        switch (opc){

            case "1":{
                mostrarFich();
                break;
            }

            case "2":{
                menuA();
                break;
            }

            case "3":{
                menuM();
                break;
            }

            case "4":{
                menuE();
                break;
            }

            case "5":{
                System.exit(0);
            }
        }
        }
    }

    public void menuA(){

        while(true){
            System.out.println("1) Insertar nodo al principio del documento\n" +
                "2) Insertar nodo en posiciones intermedias del documento\n" +
                "3) Insertar nodo al final del documento\n" +
                "4) Volver al menú principal");

        String opc =teclado.nextLine();

        switch (opc){

            case "1":{
                añadeNodo(opc);
                break;
            }

            case "2":{
                añadeNodo(opc);
                break;

            }

            case "3":{
                añadeNodo(opc);
                break;

            }

            case "4":{
                menuP();
            }
        }}
    }
    public void menuM(){

        while(true){
            System.out.println("1) Modificar nodo al principio del documento\n" +
                    "2) Modificar nodo en posiciones intermedias del documento\n" +
                    "3) Modificar nodo al final del documento\n" +
                    "4) Volver al menú principal");

            String opc =teclado.nextLine();

            switch (opc){

                case "1":{
                    modNodo(opc);
                    break;
                }

                case "2":{
                    modNodo(opc);
                    break;
                }

                case "3":{
                    modNodo(opc);
                    break;
                }

                case "4":{
                    menuP();
                }
            }}
    }

    public int menuS(){

        System.out.println("1) Titulo 4) Director\n" +
                "2) Guionista 5) Actor\n" +
                "3) Productora 6) Sinopsis\n" +
                "7) Volver al menú anterior");

        int retorno = Integer.parseInt(teclado.nextLine());
        if(retorno == 7){

            menuM();

        }

        return retorno;
    }

    public void menuE(){
        while (true){
        System.out.println("1) Eliminar nodo al principio del documento\n" +
                "2) Eliminar nodo en posiciones intermedias del documento\n" +
                "3) Eliminar nodo al final del documento\n" +
                "4) Volver al menú principal");


        String opc =teclado.nextLine();

        switch (opc){

            case "1":{
                eliminaNodo((opc));
                break;
            }

            case "2":{
                eliminaNodo((opc));
                break;
            }

            case "3":{
                eliminaNodo((opc));
                break;
            }

            case "4":{
                menuP();
            }
        }}
    }


}
