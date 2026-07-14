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
        setModal(true);
        setLocationRelativeTo(null);
        pack();
        buttonCancel();


    }

    public void buttonCancel() {
        buttonCancel.addActionListener(e -> {
            this.dispose();
            if (parent != null) {
                parent.setVisible(true);
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
            double average = calculateAverage(txtGrades);
            lblResult.setText(" RESULT: " + average);
        });
    }


}







