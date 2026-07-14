package views;

import javax.swing.*;
import java.awt.*;

public class CalculadoraProfesor extends JDialog {
    private JPanel contentPane;
    private JButton buttonCalculate;
    private JButton buttonRegresar;
    private JLabel lblTitleCalc;
    private JTextField txtGrades;
    private JLabel lblResult;
    private Window parent;

    public CalculadoraProfesor(Window parent) {
        this.parent = parent;
        setContentPane(contentPane);
        setModal(true);
        setLocationRelativeTo(null);
        buttonCalculate();
        buttonRegresar();
        pack();


    }

    public void buttonRegresar() {
        buttonRegresar.addActionListener(e -> {
            this.dispose();
            if (parent != null) {
                parent.requestFocus();
                parent.revalidate();
                parent.repaint();
                parent.setVisible(true);

            }
        });
    }

    public double calcularPromedio(JTextField txtGrades) {
        String allGrades = txtGrades.getText();

        String[] elements = allGrades.split("[, ]+");
        double sumOfAll = 0;

        for (String element : elements) {
            double decimalNumber = Double.parseDouble(element);
            sumOfAll += decimalNumber;
        }

        double promedio = sumOfAll / elements.length;
        return promedio;

    }

    public void buttonCalculate() {
        buttonCalculate.addActionListener(e -> {
            try {
                double average = calcularPromedio(txtGrades);
                lblResult.setText(" Resultado: " + average);

            } catch (NumberFormatException error) {
                lblResult.setText("Error: Ingresa solo números");
            }
        });
    }


}







