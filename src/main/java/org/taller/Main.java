package org.taller;

import views.Principal;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame home = new JFrame("Calculadora Estudiante");
        Principal principal = new Principal();
        principal.calculadoraEstudianteButton();
        principal.calculadoraProfesorButton();
        home.setContentPane(principal.home);
        home.pack();
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.setLocationRelativeTo(null);
        home.setSize(600, 600);
        home.setVisible(true);


    }
}