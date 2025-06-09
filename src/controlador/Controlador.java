package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelo.Modelo;
import vista.Vista;

public class Controlador implements ActionListener, KeyListener {

    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnGenerarTexto.setEnabled(false);
        this.vista.campoTexto.addKeyListener(this);
        this.vista.campoVeces.addKeyListener(this);
        this.vista.btnGenerarTexto.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.btnGenerarTexto) {
            System.out.println("Botón de generar texto presionado");
            try {
                if (this.campoNumericoTieneNumeros()) {
                    String strCampoTexto = this.vista.campoTexto.getText();
                    int strCampoVeces = Integer.parseInt(this.vista.campoVeces.getText());
                    String strTextoRepetido = "";
                    this.modelo.setTexto(strCampoTexto);
                    this.modelo.setVeces(strCampoVeces);
                    strTextoRepetido = this.modelo.generarTextoRepetido();
                    this.vista.etiquetaTextoRepetido.setText("Texto repetido: " + strTextoRepetido);
                } else {
                    throw new Exception("Error: El campo numérico debe tener números");
                }
            } catch (Exception ex) {
                System.err.print(ex);

            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == this.vista.campoTexto) {
            String strCampoTexto = this.vista.campoTexto.getText();
        } else if (e.getSource() == this.vista.campoVeces) {
            String strCampoVeces = this.vista.campoVeces.getText();
        }
        this.habilitarDeshabilitarBotonGenerarTexto();
    }

    public void habilitarDeshabilitarBotonGenerarTexto() {
        String strCampoTexto = this.vista.campoTexto.getText();
        String strCampoVeces = this.vista.campoVeces.getText();
        System.out.println("strCampoTexto: " + strCampoTexto + ", strCampoVeces: " + strCampoVeces);
        this.vista.btnGenerarTexto.setEnabled(strCampoTexto.isEmpty() || strCampoVeces.isEmpty() ? false : true);
        System.out.println("Campo numerico tiene numeros: " + this.campoNumericoTieneNumeros());

    }

    public boolean alMenosUnCampoVacio() {
        String strCampoTexto = this.vista.campoTexto.getText();
        String strCampoVeces = this.vista.campoVeces.getText();
        return (strCampoTexto.isEmpty() || strCampoVeces.isEmpty());
    }

    public boolean campoNumericoTieneNumeros() {
        String strCampoVeces = this.vista.campoVeces.getText();
        return (strCampoVeces.chars().allMatch(Character::isDigit));
    }

}
