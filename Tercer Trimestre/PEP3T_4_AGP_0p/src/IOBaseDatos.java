/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dam1
 */
public class IOBaseDatos {
    
    public void actualizaRegistros(String actualiza) throws SQLException{
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String urlCon = "jdbc:mariadb://localhost:3306/PUNTU4";
            Connection conexBd = DriverManager.getConnection(urlCon, "root", "");
            Statement encapsulaCons = conexBd.createStatement();

            int filActualizadas = encapsulaCons.executeUpdate(actualiza);
            System.out.print("Hola");
            if(filActualizadas > 0){System.out.print("Hola");}

            encapsulaCons.close();
            conexBd.close();
        } catch (ClassNotFoundException | SQLException cnfe) {
            System.out.println(cnfe.getMessage());
        }
    
    
    }
    
    public ResultSet introduceRegistros(String consulta) {
        ResultSet resulCons = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String urlCon = "jdbc:mariadb://localhost:3306/PUNTU4";
            Connection conexBd = DriverManager.getConnection(urlCon, "root", "");
            Statement encapsulaCons = conexBd.createStatement();

            //"INSERT INTO DONANTES(DNI, Nombre, Direccion, CodPostal, Localidad, FechaNac, Correo, Telefono, GrupoSang, FactorRH) VALUES('" + dni + "', '" + nomDonante + "', '" + direccionDonante + "', '" + codPostal + "', '" + localidad + "', '" + fechaNac + "', '" + mail + "', '" + telefono + "', '" + grupoSang + "', '" + factorRH + "')
            resulCons = encapsulaCons.executeQuery(consulta);

            encapsulaCons.close();
            conexBd.close();
        } catch (ClassNotFoundException | SQLException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resulCons;
    }
    
    
    
    
}

/*import java.sql.PreparedStatement;
. . . . .
//Construye el encapsulador genérico
PreparedStatement encapsulaPsCons = conexBd.prepareStatement(
"UPDATE RESERVAS SET precio = ? WHERE viajero = ? ");
//Sustituye el primer interrogante con el valor requerido
encapsulaPsCons.setDouble(1, 120.00);
//Sustituye el segundo interrogante con el valor requerido
encapsulaPsCons.setString(2, "Isabel");
//En un PreparedStatement el método executeUpdate() no lleva argumento
int filActualizadas = encapsulaPsCons.executeUpdate();
System.out.println(filActualizadas+" registros actualizados");
. . . . .
commit(), rollback() y setAutoCommit()
catch(SQLException se) {
 if(conexBd != null){
 //En caso de que alguna vaya mal, deshace las que se hayan podido ejecutar y aborta operación
 try {
 //Poniendo este método es como darle a DESHACER
 conexBd.rollback();
 }

addBatch() y
executeBatch()*/
