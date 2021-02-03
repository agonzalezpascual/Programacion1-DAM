package Componentes;

public class Teclado extends Perifericos{
    int numDeTecl;

    public Teclado(String tipoDeConexion, String velocConex, String ListaSoConDrivers,int numDeTecl) {
        super(tipoDeConexion, velocConex, ListaSoConDrivers);
        this.numDeTecl = numDeTecl;
    }

    @Override
    public String toString() {
        return "Este teclado tiene " + numDeTecl + " teclas";
    }
}

