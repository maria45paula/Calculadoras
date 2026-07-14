package views;

import javax.swing.*;

public class CalculadoraEstudiante {
    private JTextField visualizarOperaciones;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btnBorrar;
    private JButton btn0;
    private JButton btnIgual;
    private JButton regresarButton;
    private JButton btnSuma;
    private JButton btnMenos;
    private JButton btnMultiplicacion;
    private JButton btnDivision;
    private JButton btnDecimal;
    public JPanel home;
    private double valorAnterior = 0;
    private String operadorActual = "";
    private boolean nuevoNumero = true;

    public CalculadoraEstudiante() {
        // Botones de numeros
        btn0.addActionListener(e -> agregarDigito("0"));
        btn1.addActionListener(e -> agregarDigito("1"));
        btn2.addActionListener(e -> agregarDigito("2"));
        btn3.addActionListener(e -> agregarDigito("3"));
        btn4.addActionListener(e -> agregarDigito("4"));
        btn5.addActionListener(e -> agregarDigito("5"));
        btn6.addActionListener(e -> agregarDigito("6"));
        btn7.addActionListener(e -> agregarDigito("7"));
        btn8.addActionListener(e -> agregarDigito("8"));
        btn9.addActionListener(e -> agregarDigito("9"));

        btnDecimal.addActionListener(e -> agregarDigito("."));

        btnSuma.addActionListener(e -> setOperador("+"));
        btnMenos.addActionListener(e -> setOperador("-"));
        btnMultiplicacion.addActionListener(e -> setOperador("*"));
        btnDivision.addActionListener(e -> setOperador("/"));

        // Igual
        btnIgual.addActionListener(e -> calcularResultado());

        // Borrar
        btnBorrar.addActionListener(e -> {
            visualizarOperaciones.setText("");
            valorAnterior = 0;
            operadorActual = "";
            nuevoNumero = true;
        });
    }

    private void agregarDigito(String digito) {
        if (nuevoNumero) {
            visualizarOperaciones.setText(digito);
            nuevoNumero = false;
        } else {
            visualizarOperaciones.setText(visualizarOperaciones.getText() + digito);
        }
    }

    private void setOperador(String operador) {
        valorAnterior = Double.parseDouble(visualizarOperaciones.getText());
        operadorActual = operador;
        nuevoNumero = true;
    }

    private void calcularResultado() {
        double valorActual = Double.parseDouble(visualizarOperaciones.getText());
        double resultado = 0;

        switch (operadorActual) {
            case "+":
                resultado = valorAnterior + valorActual;
                break;
            case "-":
                resultado = valorAnterior - valorActual;
                break;
            case "*":
                resultado = valorAnterior * valorActual;
                break;
            case "/":
                if (valorActual != 0) {
                    resultado = valorAnterior / valorActual;
                } else {
                    visualizarOperaciones.setText("Error");
                    return;
                }
                break;
            default:
                return; // no hay operador seleccionado
        }

        visualizarOperaciones.setText(String.valueOf(resultado));
        valorAnterior = resultado;
        nuevoNumero = true;
    }
}
