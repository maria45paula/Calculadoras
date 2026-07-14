package views;

import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {
    private JLabel Titulo;
    private JButton calculadoraEstudianteButton;
    private JButton calculadoraProfesorButton;
    private JLabel descripcion;
    public JPanel home;

    Window currentWindow = SwingUtilities.getWindowAncestor(home);

    public void setTitulo(JLabel titulo) {
        Titulo = titulo;
    }

    public void setCalculadoraEstudianteButton(JButton calculadoraEstudianteButton) {
        this.calculadoraEstudianteButton = calculadoraEstudianteButton;
    }

    public void setCalculadoraProfesorButton(JButton calculadoraProfesorButton) {
        this.calculadoraProfesorButton = calculadoraProfesorButton;
    }

    public void setDescripcion(JLabel descripcion) {
        this.descripcion = descripcion;
    }


    public void calculadoraEstudianteButton() {
        calculadoraEstudianteButton.addActionListener(e -> {
            CalculadoraEstudiante calculadoraEstudiante = new CalculadoraEstudiante(currentWindow);
            Window currentWindow = SwingUtilities.getWindowAncestor(home);
            currentWindow.setVisible(false);
            calculadoraEstudiante.setVisible(true);
        });
    }

    public void calculadoraProfesorButton() {
        calculadoraProfesorButton.addActionListener(e -> {
            TeacherCalculator teacherCalculator = new TeacherCalculator(currentWindow);
            teacherCalculator.setVisible(true);
        });
    }


}
