import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CFS1D_2T_P2_AGP {

    public void creaGUI(){

        JFrame marco = new JFrame("Verificador de tarjetas");
        JLabel etiqueta1 = new JLabel("Introduzca el nº de la tarjeta");
        JLabel foto = new JLabel();
        JButton botonCalc = new JButton("Calcular Dígito");
        JButton botonBorr = new JButton("Borrar Datos");
        JTextField campotexto1 = new JTextField(16);
        JTextField campotexto2 = new JTextField(2);
        ImageIcon img = new ImageIcon("reset.jpg");





        JPanel paneln = new JPanel();
        JPanel panelc = new JPanel();
        JPanel panels = new JPanel();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(300, 140);
        marco.setLocation(500, 350);


        FlowLayout espaciadon = new FlowLayout(FlowLayout.CENTER);
        FlowLayout espaciadoc = new FlowLayout(FlowLayout.CENTER);
        FlowLayout espaciados = new FlowLayout(FlowLayout.CENTER);

        //Panel Norte
        paneln.setLayout(espaciadon);
        paneln.add(etiqueta1);


        //Panel Centro
        panelc.setLayout(espaciadoc);
        panelc.add(campotexto1);
        panelc.add(campotexto2);
        foto.setIcon(new ImageIcon(""));
        panelc.add(foto);


        //Panel Sur
        panels.setLayout(espaciados);
        panels.add(botonCalc);
        panels.add(botonBorr);


        //Marco
        marco.setLayout(new BorderLayout(10,2));
        marco.add(paneln, BorderLayout.NORTH);
        marco.add(panelc, BorderLayout.CENTER);
        marco.add(panels, BorderLayout.SOUTH);

        //Acciones

        ActionListener botones = new ActionListener(){
            boolean compruebaboton = false;
            public void actionPerformed(ActionEvent e){

                if (e.getSource() == botonCalc){

                    foto.setIcon(new ImageIcon("iconvale.png"));
                    campotexto2.setText(String.valueOf(calcNum(campotexto1.getText())));

                    compruebaboton = true;
                    }
                if (e.getSource() == botonBorr){

                    foto.setIcon(new ImageIcon());
                    campotexto1.setText("");
                    compruebaboton = false;

                    campotexto2.setVisible(false);

                    JOptionPane.showMessageDialog(null, "Los campos han sido reinicializados", "Cálculo dígito tarjeta", JOptionPane.INFORMATION_MESSAGE, img);
                }




                if (compruebaboton) {

                    campotexto2.setVisible(true);

                }
                else {

                    campotexto2.setVisible(false);

                }}};



        botonCalc.addActionListener(botones);
        botonBorr.addActionListener(botones);
        marco.setVisible(true);
        paneln.setVisible(true);
        etiqueta1.setVisible(true);
        panelc.setVisible(true);
        campotexto1.setVisible(true);
        campotexto2.setVisible(false);



}

    public int calcNum(String numBan){
        String numBa = numBan;
        String numBaFi;
        int numPa = 0;
        int numTot = 0;

        for(int i = 0; i < numBa.length(); i++) {

            if(i%2==0){
            numPa = Integer.parseInt(String.valueOf(numBa.charAt((i))))*2;
            if(numPa>9){numPa = numPa-9;}
            numTot = numTot + numPa;}
            if(i%2==1){numPa = Integer.parseInt(String.valueOf(numBa.charAt((i))));
                numTot = numTot + numPa;}
        }
        numBaFi = String.valueOf(numTot*9);

        return Integer.parseInt(String.valueOf(numBaFi.charAt((numBaFi.length()-1))));

    }

    static class PilotoGuiExam {
        public static void main(String[] args) {

            CFS1D_2T_P2_AGP ventana = new CFS1D_2T_P2_AGP();

            ventana.creaGUI();

        }


    }

}
