import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControlaGUI {

    public void creaGUI(){

        IOBaseDatos IO = new IOBaseDatos();

        JFrame marco = new JFrame("Ejercicio PEP3T4 Java");
        JLabel etiqueta5 = new JLabel("GESTIÓN DE LA TABLA NOTAS");
        JLabel etiqueta1 = new JLabel("Código Matrícula");
        JLabel etiqueta2 = new JLabel("Nombre Asignatura");
        JLabel etiqueta3 = new JLabel("Nota 1");
        JLabel etiqueta4 = new JLabel("Nota 2");
        JLabel etiqueta6 = new JLabel("");

        JButton botonCon = new JButton("Consultar");
        JButton botonBorr = new JButton("Borrar");
        JButton botonIns = new JButton("Insertar");
        JButton botonmod = new JButton("Modificar");
        JTextField campotexto1 = new JTextField(3);
        JTextField campotexto2 = new JTextField(16);
        JTextField campotexto3 = new JTextField(5);
        JTextField campotexto4 = new JTextField(5);





        JPanel paneln = new JPanel();
        JPanel panelt = new JPanel();
        JPanel panelm = new JPanel();
        JPanel panela = new JPanel();
        JPanel panelb = new JPanel();
        JPanel panelc = new JPanel();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(400, 400);
        marco.setLocation(500, 350);

        panelt.add(etiqueta5);

        panelm.add(etiqueta1);
        panelm.add(campotexto1);

        panela.add(etiqueta2);
        panela.add(campotexto2);

        paneln.add(etiqueta3);
        paneln.add(campotexto3);
        paneln.add(etiqueta4);
        paneln.add(campotexto4);

        panelb.add(botonIns);
        panelb.add(botonCon);
        panelb.add(botonBorr);
        panelb.add(botonmod);

        panelc.add(etiqueta6);




        //Marco
        marco.setLayout(new GridLayout(6,1));
        marco.add(panelt);
        marco.add(panelm);
        marco.add(panela);
        marco.add(paneln);
        marco.add(panelb);
        marco.add(panelc);


        //Acciones

        ActionListener botones = new ActionListener(){
            public void actionPerformed(ActionEvent e){

                if (e.getSource() == botonCon){

                    ResultSet r = IO.introduceRegistros("Select * from NOTAS where MAT =" + campotexto1.getText());
                    try{
                    while(r.next()){
                        campotexto2.setText(r.getString("Asignatura"));
                        campotexto3.setText(r.getString("Nota1"));
                        campotexto4.setText(r.getString("Nota2"));
                        etiqueta6.setText("Registro Encontrado");



                    }}catch (SQLException ex) {
                        ex.printStackTrace();
                        etiqueta6.setText("Ha habido un error");
                    }


                }
                if (e.getSource() == botonBorr){

                    try {
                        IO.actualizaRegistros("DELETE FROM NOTAS where MAT ='"+campotexto1.getText()+"'");
                        etiqueta6.setText("Registro Borrado");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        etiqueta6.setText("Ha habido un error");
                    }


                    }
                if (e.getSource() == botonIns){

                    try {
                        IO.actualizaRegistros("INSERT INTO NOTAS (MAT, Asignatura, Nota1, Nota2) VALUES ('"+campotexto1.getText()+"', '"+campotexto2.getText()+"', '"+campotexto3.getText()+"', '"+campotexto4.getText()+"')");
                        etiqueta6.setText("Registro Insertado");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        etiqueta6.setText("Ha habido un error");
                    }

                }
                if (e.getSource() == botonmod){

                    try {
                        IO.actualizaRegistros("UPDATE NOTAS SET Asignatura = '"+campotexto2.getText()+"', Nota1 = '"+campotexto3.getText()+"', Nota2 = '"+campotexto4.getText()+"' where MAT ='"+campotexto1.getText()+"'");
                        etiqueta6.setText("Registro Modificado");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        etiqueta6.setText("Ha habido un error");
                    }


                }
                }};



        botonCon.addActionListener(botones);
        botonBorr.addActionListener(botones);
        botonIns.addActionListener(botones);
        botonmod.addActionListener(botones);
        marco.setVisible(true);
        paneln.setVisible(true);
        etiqueta5.setVisible(true);
        panelb.setVisible(true);
        etiqueta1.setVisible(true);
        etiqueta2.setVisible(true);
        etiqueta3.setVisible(true);
        etiqueta4.setVisible(true);
        campotexto1.setVisible(true);
        campotexto2.setVisible(true);
        campotexto3.setVisible(true);
        campotexto4.setVisible(true);
        botonBorr.setVisible(true);
        botonCon.setVisible(true);
        botonIns.setVisible(true);
        botonIns.setVisible(true);



    }


    static class PilotoGui {
        public static void main(String[] args) {

            ControlaGUI ventana = new ControlaGUI();

            ventana.creaGUI();

        }


    }


}
