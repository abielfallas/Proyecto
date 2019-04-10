/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author Abiel Fallas
 */
public class Usuarios extends Persona {
    private String usuario;
    private String contrasena;
    private String tipo;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contra) {
        if (contra.length()==8) {
            this.contrasena = contra;
        }else{
            JOptionPane.showMessageDialog(null, "La contraseña debe tener 8 caracteres");
        }
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
