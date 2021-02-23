import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class GuiSwingAct3 {
    public static void main(String[] args) {
        JFrame marco = new JFrame("Swing con Actividad");
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setLayout(new FlowLayout());
        JLabel etiqueta = new JLabel("Pulsa en cualquier botón");
        JButton btnPal = new JButton("Palante");
        JButton btnCancel = new JButton("Cancelar");
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                    etiqueta.setText("Botón Palante pulsado");

            }
        };
        ActionListener actionListener2 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    etiqueta.setText("Botón Cancelar pulsado");
            }
        };
        btnPal.addActionListener(actionListener);
        btnCancel.addActionListener(actionListener2);
        marco.add(etiqueta);
        marco.add(btnPal);
        marco.add(btnCancel);
        marco.pack();
        marco.setVisible(true);
    }
}
