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

    public Usuarios(String usuario, String contrasena, String tipo, int cedula, String nombre, String fechaNto, int telefono, String correo) {
        super(cedula, nombre, fechaNto, telefono, correo);
        this.usuario = usuario;
        this.setContrasena(contrasena);
        this.tipo = tipo;
    }

    public Usuarios(int cedula) {
        super(cedula);
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public String getContrasena() {
       return contrasena;
    }

    public void setContrasena(String contra) {
            this.contrasena = contra;
        }
            

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
