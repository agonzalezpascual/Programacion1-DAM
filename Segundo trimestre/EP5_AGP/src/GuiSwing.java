import javax.swing.*; //Importando el paquete de los controles Swing
import java.awt.*;
import java.awt.event.*;
import java.math.*;
class GuiSwing{

    int intentos =0;
    int acertados =0;
    int fallados =0;
    String val="";
    int resul = 0;

    public void creaGUI(){



        JFrame marco = new JFrame("Adivina el resultado de la suma");
        JLabel etiqueta1 = new JLabel("Número 1: ");
        JLabel etiqueta2 = new JLabel("Número 2: ");
        JLabel etiqueta3 = new JLabel("Resultado: ");
        JLabel etiqueta4 = new JLabel("Intentos: ",10);
        JLabel etiqueta5 = new JLabel("Acertados: ",10);
        JLabel etiqueta6 = new JLabel("Fallados: ",10);
        JLabel etiqueta7 = new JLabel(String.valueOf(intentos),10);
        JLabel etiqueta8 = new JLabel(String.valueOf(acertados),10);
        JLabel etiqueta9 = new JLabel(String.valueOf(fallados),10);
        JButton botonGene = new JButton("Generar");
        JButton botonVerif = new JButton("Verificar");
        JButton botonSal = new JButton("Salir");
        JTextField campotexto1 = new JTextField("0",5);
        JTextField campotexto2 = new JTextField("0",5);
        JTextField campotexto3 = new JTextField(5);
       // campotexto1.setLayout(new FlowLayout(FlowLayout.RIGHT,5,5));

        JPanel paneln = new JPanel();
        JPanel panelc = new JPanel();
        JPanel panels = new JPanel();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(550, 150);
        marco.setLocation(500, 350);


        FlowLayout espaciado = new FlowLayout(FlowLayout.CENTER,10,5);
        paneln.add(etiqueta1);
        paneln.add(campotexto1);
        paneln.add(etiqueta2);
        paneln.add(campotexto2);
        paneln.add(etiqueta3);
        paneln.add(campotexto3);
        paneln.setLayout(espaciado);
        marco.setLayout(new BorderLayout(10,10));
        marco.add(paneln, BorderLayout.NORTH);


        panelc.add(botonGene);
        panelc.add(botonVerif);
        panelc.add(botonSal);
        panelc.setLayout(espaciado);
        marco.add(panelc, BorderLayout.CENTER);
        panels.add(etiqueta4);
        panels.add(etiqueta7);

        panels.add(etiqueta5);
        panels.add(etiqueta8);

        panels.add(etiqueta6);
        panels.add(etiqueta9);
        panels.setLayout(espaciado);
        marco.add(panels, BorderLayout.SOUTH);




        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == botonGene) {
                    campotexto1.setText(generaNum());
                    campotexto2.setText(generaNum());
                }
                if (e.getSource() == botonVerif) {
                    resul = Integer.parseInt(JOptionPane.showInputDialog(marco,"Teclee su resultado",JOptionPane.QUESTION_MESSAGE));

                    if (resul == (Integer.parseInt(campotexto2.getText()) + Integer.parseInt(campotexto1.getText()))){

                        etiqueta7.setText(String.valueOf(Integer.parseInt(etiqueta7.getText()) + 1));
                        etiqueta8.setText(String.valueOf(Integer.parseInt(etiqueta8.getText()) + 1));
                        campotexto3.setText(String.valueOf(resul));

                    }
                    else{
                        etiqueta7.setText(String.valueOf(Integer.parseInt(etiqueta7.getText()) + 1));
                        etiqueta9.setText(String.valueOf(Integer.parseInt(etiqueta9.getText()) + 1));
                        campotexto3.setText(String.valueOf(Integer.parseInt(campotexto2.getText()) + Integer.parseInt(campotexto1.getText())));
                    }

            }
                if (e.getSource() == botonSal) {

                    System.exit(0);


                }
            }
        };
        panels.setVisible(true);
        panelc.setVisible(true);
        paneln.setVisible(true);
        marco.setVisible(true);
        botonGene.addActionListener(actionListener);
        botonVerif.addActionListener(actionListener);
    }

    public String generaNum(){

        return String.valueOf(Math.toIntExact(Math.round(Math.random() * 999)));


    }

    public void generaInput(){
        JFrame marco2 = new JFrame("Input");
        marco2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco2.setSize(550, 150);
        marco2.setLocation(100, 50);

    }
}