package Componentes;

public class Perifericos {
        String tipoDeConexion;
        String velocConex;
        String ListaSoConDrivers;
    public Perifericos(String tipoDeConexion, String velocConex, String ListaSoConDrivers){
        this.tipoDeConexion = tipoDeConexion;
        this.velocConex = velocConex;
        this.ListaSoConDrivers = ListaSoConDrivers;
    }


    @Override
    public String toString() {
        return "Perifericos{" +
                "Tiene un conexion de tipo'" + tipoDeConexion + '\'' +
                ", con una velocidad de" + velocConex + '\'' +
                ", Necesita los drivers" + ListaSoConDrivers + '\'' +
                '}';
    }
}
