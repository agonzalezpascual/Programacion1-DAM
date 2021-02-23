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

    public boolean buscEnt(String p){

        boolean ret = false;

            if (paises.containsKey(p)) {

                ret = true;
            }

        else{

        System.out.println("No se ha encontrado el país");
    }
    return ret;
    }

    public void devEnt(boolean i, String p){

        if(i == true){

            System.out.println("Capital: " + paises.get(p));
        }


    }

    public void modEnt(boolean i, String p, String cn){
        if(i == true){

            paises.replace(p,cn);
        }

    }

    public void quitEnt(boolean i, String p){

        if(i == true){

            System.out.println(p + " eliminada del Atlas");
            paises.remove(p);
        }

    }

    public void borAtl(){

        paises.clear();
        System.out.println("Eliminado el Atlas por completo");
    }
}
