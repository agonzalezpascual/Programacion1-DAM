package Controlador;

import Modelo.IOArchivo;
import Modelo.ManejaFich;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Proyectos {

    public ManejaFich IO = new ManejaFich();
    public IOArchivo IODA = new IOArchivo();
    public IOBaseDatos IOBD = new IOBaseDatos();

    public void creaGUI(String s) {
        JFrame marco = new JFrame(s);
        //JScrollPane preparativos;
        //JScrollPane gestion;
        marco.setBounds(100, 100, 700, 400);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.getContentPane().setLayout(null);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(0, 11, 695, 380);
        marco.getContentPane().add(tabbedPane);

        JPanel panelP = new JPanel();
        panelP.setName("");
        tabbedPane.addTab("Preparativos", null, panelP, "");


        JPanel panelG = new JPanel();
        panelG.setName("");

        panelG.setLayout(null);


        //Panel Principal


        panelP.setLayout(new GridLayout(3, 1));
            //Titulo
        JPanel panelt = new JPanel();
        //panelt.setLayout(new GroupLayout.Alignment.CENTER);
        JLabel labelt = new JLabel("");
        labelt.setFont(new Font("Verdana", Font.BOLD, 30));
        panelt.add(labelt);
        panelP.add(panelt);
            //Botones
        JPanel panelb = new JPanel();
        JButton botcreadat = new JButton(new ImageIcon("imagenes/botxmladat.png"));
        botcreadat.setBorder(new BevelBorder(2));
        JButton botllenatab = new JButton(new ImageIcon("imagenes/botdatatabledis.png"));
        botllenatab.setBorder(new BevelBorder(2));
        JButton botpicatxt = new JButton(new ImageIcon("imagenes/bottecladoatxtdis.png"));
        botpicatxt.setBorder(new BevelBorder(2));
        panelb.add(botcreadat);
        panelb.add(botllenatab);
        panelb.add(botpicatxt);
        panelP.add(panelb);
            //Label Confirmación
        JPanel panelc = new JPanel();
        JLabel conf = new JLabel("");
        conf.setFont(new Font("Verdana", Font.BOLD, 15));
        panelc.add(conf);
        panelP.add(panelc);


        //Panel Secundario
        panelG.setLayout(new GridLayout(3, 1));
            //Titulo
        JPanel paneltG = new JPanel();
        JLabel labeltG = new JLabel("");
        labeltG.setFont(new Font("Verdana", Font.BOLD, 15));
        panelG.add(paneltG);
        paneltG.add(labeltG);
            //Tabla
        JTable tblProy = new JTable();
        JScrollPane paneltab = new JScrollPane(tblProy);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tblProy.setDefaultRenderer(Object.class, centerRenderer);
        tblProy.setDefaultRenderer(Float.class, centerRenderer);
        tblProy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tblProy.setFillsViewportHeight(true);
        tblProy.getTableHeader().setReorderingAllowed(false);
        tblProy.getTableHeader().setResizingAllowed(false);
        tblProy.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        tblProy.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                },
                new String[]{
                        "<html><b>Trim</b></html>", "<html><b>Proyecto</b></html>", "<html><b>Lenguaje</b></html>", "<html><b>Nota</b></html>"
                }
        ) {
            Class[] columnTypes = new Class[]{
                    String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        /*tblProy.getColumnModel().getColumn(0).setMinWidth(75);
        tblProy.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblProy.getColumnModel().getColumn(1).setMinWidth(100);
        tblProy.getColumnModel().getColumn(2).setPreferredWidth(115);
        tblProy.getColumnModel().getColumn(2).setMinWidth(115);
        tblProy.getColumnModel().getColumn(3).setMinWidth(75);
        tblProy.getColumnModel().getColumn(3).setPreferredWidth(115);
        tblProy.getColumnModel().getColumn(4).setMinWidth(115);
        tblProy.getColumnModel().getColumn(4).setPreferredWidth(107);
        tblProy.getColumnModel().getColumn(5).setPreferredWidth(107);
        tblProy.getColumnModel().getColumn(5).setPreferredWidth(107);
        tblProy.getColumnModel().getColumn(6).setPreferredWidth(107);
        tblProy.getColumnModel().getColumn(6).setPreferredWidth(107);
        tblProy.getColumnModel().getColumn(7).setPreferredWidth(107);
        tblProy.getColumnModel().getColumn(7).setPreferredWidth(107);
        tblProy.getColumnModel().getColumn(8).setPreferredWidth(107);
        tblProy.getColumnModel().getColumn(8).setPreferredWidth(107);
        tblProy.getColumnModel().getColumn(9).setPreferredWidth(107);
*/
        tblProy.setBounds(32, 311, 400, 200);
        panelG.add(paneltab);

            //Boton
        JPanel panelmod = new JPanel();

        JLabel labelproy = new JLabel("");
        JLabel labelnot = new JLabel("");
        JTextField txtproy = new JTextField(15);
        JTextField txtnot = new JTextField(5);
        JButton botmod = new JButton("Modificar Nota");
        panelG.add(panelmod);
        panelmod.add(labelproy);
        panelmod.add(txtproy);
        panelmod.add(labelnot);
        panelmod.add(txtnot);
        panelmod.add(botmod);


        //Funcionalidad Botones
        botllenatab.setEnabled(false);
        botpicatxt.setEnabled(false);

        ActionListener botones = new ActionListener(){
            public void actionPerformed(ActionEvent e){

                if (e.getSource() == botcreadat){


                    IO.mostrarFich();
                    botllenatab.setIcon(new ImageIcon("imagenes/botdatatable.png"));
                    botllenatab.setEnabled(true);
                    botcreadat.setEnabled(false);
                    }

                if (e.getSource() == botllenatab){

                    try (BufferedReader lectura_buffer = new BufferedReader(new FileReader("proyectos.dat"))) {


                            String line;


                            while ((line = lectura_buffer.readLine()) != null) {

                                System.out.println(line);
                                IOBD.actualizaRegistros("INSERT INTO NOTAS (id, Trim, Proyecto, Lenguaje, Nota) VALUES (" + line+")");

                                for (int i = 1; i<=6; i++){
                                IOBD.leerDatosDB(i, tblProy);}
                            }
                        botllenatab.setIcon(new ImageIcon("imagenes/botdatatabledis.png"));
                        botllenatab.setEnabled(false);
                        botpicatxt.setIcon(new ImageIcon("imagenes/bottecladoatxt.png"));
                        botpicatxt.setEnabled(true);

                } catch (IOException | SQLException ex) {
                        ex.printStackTrace();
                    }
                    IOBD.eliminaFich();
                }

                if(e.getSource()==botpicatxt){


                    IOBD.escfich();
                    labelt.setText(IOBD.leefich().get(0));
                    conf.setText(IOBD.leefich().get(1));
                    labelproy.setText(IOBD.leefich().get(3));
                    labelnot.setText(IOBD.leefich().get(4));
                    labeltG.setText(IOBD.leefich().get(2));
                    botpicatxt.setIcon(new ImageIcon("imagenes/bottecladoatxtdis.png"));
                    botpicatxt.setEnabled(false);
                    tabbedPane.addTab("Gestión", null, panelG, "");

                }

                if (e.getSource() == botmod){

                    try {
                        IOBD.actualizaRegistros("UPDATE NOTAS set nota = '"+ txtnot.getText()+"' where proyecto = '"+txtproy.getText() +"'");

                        for (int i = 1; i<=6; i++){
                            IOBD.leerDatosDB(i, tblProy);}

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }


            }};

        //Acciones
        botcreadat.addActionListener(botones);
        botllenatab.addActionListener(botones);
        botpicatxt.addActionListener(botones);
        botmod.addActionListener(botones);

        //Poner Visible
        marco.setVisible(true);
        tabbedPane.setVisible(true);
        panelP.setVisible(true);
        panelG.setVisible(true);
        panelt.setVisible(true);
        labelt.setVisible(true);
        panelb.setVisible(true);
        botcreadat.setVisible(true);
        botpicatxt.setVisible(true);
        botllenatab.setVisible(true);
        panelc.setVisible(true);
        conf.setVisible(true);
        paneltG.setVisible(true);
        labeltG.setVisible(true);
        tblProy.setVisible(true);
        paneltab.setVisible(true);
        botmod.setVisible(true);
    }
}




class IOBaseDatos {

    public void actualizaRegistros(String actualiza) throws SQLException{
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String urlCon = "jdbc:mariadb://localhost:3306/PRUEBA3T";
            Connection conexBd = DriverManager.getConnection(urlCon, "root", "");
            Statement encapsulaCons = conexBd.createStatement();

            int filActualizadas = encapsulaCons.executeUpdate(actualiza);
            //System.out.print("Hola");
            //if(filActualizadas > 0){System.out.print("Hola");}

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
            String urlCon = "jdbc:mariadb://localhost:3306/PRUEBA3T";
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

    public void leerDatosDB(int id, JTable tabla) {
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Cargamos el driver en el programa
            String urlCon = "jdbc:mariadb://localhost:3306/PRUEBA3T"; // Creamos la cadena de conexión
            Connection conexBd = DriverManager.getConnection(urlCon, "root", ""); // La cadena se pasa como parámetro al método para generar la conexión
            Statement encapsulaCons = conexBd.createStatement(); // Creamos el flujo de consultas (queries) hacia la BD

            ResultSet resulCons = encapsulaCons.executeQuery("SELECT * FROM NOTAS WHERE ID = " + id);

            while (resulCons.next()) {
                tabla.setValueAt(resulCons.getInt(2), id-1, 0);
                tabla.setValueAt(resulCons.getString(3), id-1, 1);
                tabla.setValueAt(resulCons.getString(4), id-1, 2);
                tabla.setValueAt(resulCons.getString(5), id-1, 3);
            }
            encapsulaCons.close();
            conexBd.close();
        } catch (ClassNotFoundException | SQLException cnfe) {
            System.out.println(cnfe.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void escfich(){

        //ESCRIBIR EN FICHERO

        Scanner teclado = new Scanner(System.in);
        String ent;


        try (PrintWriter fw = new PrintWriter("letreros.txt")){

            System.out.println("Introduzca el texto:");
            for (int i = 0;i<6;i++){

                ent = teclado.nextLine();

                    if(ent.equalsIgnoreCase("FIN")){break;}
                    fw.write(ent+"\n");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> leefich(){

        // LEER FICHERO
        FileReader fr = null;
        ArrayList<String> a = new ArrayList<>();
        try {
            fr = new FileReader("letreros.txt");
            BufferedReader entrada = new BufferedReader(fr);

            String cadena = entrada.readLine();

            while (cadena != null) {
                a.add(cadena);

                cadena = entrada.readLine();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }

        return a;
    }

    public void eliminaFich() {
        System.out.println("Eliminar fichero");
        System.out.println();

        File fichero = new File("proyectos.dat");

        fichero.delete();

        System.out.println("Fichero eliminado");
        System.out.println();

    }

}

