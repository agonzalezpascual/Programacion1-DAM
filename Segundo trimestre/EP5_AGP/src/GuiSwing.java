import javax.swing.*; //Importando el paquete de los controles Swing
import java.awt.*;
class GuiSwing {
    public static void main(String[] args) {
        int intentos =0;
        int acertados =0;
        int fallados =0;

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
        JButton boton1 = new JButton("Generar");
        JButton boton2 = new JButton("Verificar");
        JButton boton3 = new JButton("Salir");
        JTextField campotexto1 = new JTextField(5);
        JTextField campotexto2 = new JTextField(5);
        JTextField campotexto3 = new JTextField(5);
        campotexto1.setLayout(new FlowLayout(FlowLayout.RIGHT,5,5));

        JPanel paneln = new JPanel();
        JPanel panelc = new JPanel();
        JPanel panels = new JPanel();

        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(550, 150);
        marco.setLocation(100, 50);


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


        panelc.add(boton1);
        panelc.add(boton2);
        panelc.add(boton3);
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

        panels.setVisible(true);
        panelc.setVisible(true);
        paneln.setVisible(true);
        marco.setVisible(true);



    }
}