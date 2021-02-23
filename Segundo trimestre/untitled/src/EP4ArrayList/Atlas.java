package EP4ArrayList;

import java.util.ArrayList;

public class Atlas {

    ArrayList <String> paises = new ArrayList <String>();
    ArrayList <String> capitales = new ArrayList <String>();

    public void añadEnt(String p, String c){

        paises.add(p);
        capitales.add(c);
    }

    public void muestEnt(){

        for(int i = 0; i< paises.size(); i++){

            System.out.println("País: " + paises.get(i) + "\tCapital: " + capitales.get(i));

        }
        System.out.println("Hay " + paises.size() + " elementos en el Atlas");
    }

    public int buscEnt(String p){

        int ret = -1;
        for(int i = 0; i< paises.size(); i++) {

            if (paises.get(i).equals(p)) {

                ret = i;
                break;

            }
        }
            if(ret == -1){

                System.out.println("No se ha encontrado el país");
            }


        return ret;
    }

    public void devEnt(int i){

        if(i == -1){

        }
        else {
            System.out.println("Capital: " + capitales.get(i));
        }
    }

    public void modEnt(int i, String cn){
        if(i == -1){

        }
        else {
            capitales.set(i, cn);
        }
    }

    public void quitEnt(int i){

        if(i == -1){

        }
        else {

            System.out.println(paises.get(i) + " eliminada del Atlas");
            paises.remove(i);
            capitales.remove(i);
        }
    }

    public void borAtl(){

        paises.clear();
        capitales.clear();
        System.out.println("Eliminado el Atlas por completo");
    }
}
