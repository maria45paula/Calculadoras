package views;

import javax.swing.*;
import java.awt.*;

public class TeacherCalculator extends JDialog {
    private JPanel contentPane;
    private JButton buttonCalculate;
    private JButton buttonCancel;
    private JLabel lblTitleCalc;
    private JTextField txtGrades;
    private JLabel lblResult;
    private Window parent;

    public TeacherCalculator(Window parent) {
        this.parent = parent;
        setContentPane(contentPane);
        setModal(true);
        setLocationRelativeTo(null);
        buttonCalculate();
        buttonCancel();
        pack();


    }

    public void buttonCancel() {
        buttonCancel.addActionListener(e -> {
            this.dispose();
            if (parent != null) {
                parent.requestFocus();
                parent.revalidate();
                parent.repaint();
            }
        });
    }

    public double calculateAverage(JTextField txtGrades) {
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
                double average = calculateAverage(txtGrades);
                lblResult.setText(" RESULT: " + average);

            } catch (NumberFormatException error) {
                lblResult.setText("Error: Ingresa solo números");
            }
        });
    }


}







