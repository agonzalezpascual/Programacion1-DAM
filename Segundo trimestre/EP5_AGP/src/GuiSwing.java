import javax.swing.*; //Importando el paquete de los controles Swing
import java.awt.*;
class GuiSwing {
    public static void main(String[] args) {
        JFrame marco = new JFrame("El marco");
        JLabel etiqueta1 = new JLabel("Número 1: ");
        JLabel etiqueta2 = new JLabel("Número 2: ");
        JLabel etiqueta3 = new JLabel("Resultado: ");
        JButton boton1 = new JButton("Generar");
        JButton boton2 = new JButton("Verificar");
        JButton boton3 = new JButton("Salir");
        JTextField campotexto1 = new JTextField(3);
        JTextField campotexto2 = new JTextField(3);
        JTextField campotexto3 = new JTextField(3);
        JPanel paneln = new JPanel();
        JPanel panelc = new JPanel();
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setSize(550, 200);
        marco.setLocation(100, 100);
        marco.setLayout(new FlowLayout());
        marco.add(etiqueta1, BorderLayout.NORTH);
        marco.add(campotexto1, BorderLayout.NORTH);
        marco.add(etiqueta2, BorderLayout.NORTH);
        marco.add(campotexto2, BorderLayout.NORTH);
        marco.add(etiqueta3, BorderLayout.NORTH);
        marco.add(campotexto3, BorderLayout.NORTH);
        marco.add(boton1, BorderLayout.CENTER);
        marco.add(boton2, BorderLayout.CENTER);
        marco.add(boton3, BorderLayout.CENTER);


        marco.setVisible(true);



    }
}