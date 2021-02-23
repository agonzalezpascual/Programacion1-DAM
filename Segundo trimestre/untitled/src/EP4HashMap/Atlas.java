package EP4HashMap;

import java.util.HashMap;

public class Atlas {

    HashMap<String, String> paises = new HashMap<String, String>();

    public void añadEnt(String p, String c){

        paises.put(p,c);
    }

    public void muestEnt(){

        for (String i : paises.keySet()) {
            System.out.println("País: " + i + "\tCapital: " + paises.get(i));
        }
        System.out.println("Hay " + paises.size() + " elementos en el Atlas");
    }

    public void devEnt(String p){

        if(paises.containsKey(p)){

            System.out.println("Capital: " + paises.get(p));
        }
        else{

            System.out.println("No se ha encontrado el país");
        }

    }

    public void modEnt(String p, String cn){
        if(paises.containsKey(p)){

            paises.replace(p,cn);
        }
        else{

            System.out.println("No se ha encontrado el país");
        }
    }

    public void quitEnt(String p){

        if(paises.containsKey(p)){

            System.out.println(p + " eliminada del Atlas");
            paises.remove(p);
        }
        else{

            System.out.println("No se ha encontrado el país");
        }
    }

    public void borAtl(){

        paises.clear();
        System.out.println("Eliminado el Atlas por completo");
    }
}
