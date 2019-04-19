/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Conexion;
import Clases.Persona;
import Clases.Usuarios;
import Frames.frmRegistro;
import javax.swing.JOptionPane;

/**
 *
 * @author Abiel Fallas
 */
public class CtrlUsuarios {

    private frmRegistro frm;
    private Usuarios us;

    public CtrlUsuarios(frmRegistro frm) {
        this.frm = frm;
        this.us = us;
        
    }

    public void registrar() {
        this.us = new Usuarios(frm.getTxtusuario().getText(), frm.getTxtcontrasena().getText(), frm.getTipo(), Integer.parseInt(frm.getTxtcedula().getText()), frm.getTxtnombre().getText(), frm.getFecha(), Integer.parseInt(frm.getTxttelefono().getText()), frm.getTxtcorreo().getText());

        Conexion con = new Conexion("Insert into usuarios values(?,?,?,?,?,?,?,?)");

        con.ejecutarS(new Object[]{us.getCedula(), us.getNombre(), us.getFechaNto(), us.getTelefono(), us.getCorreo(), us.getUsuario(), us.getContrasena(),
             us.getTipo()});
    }

    public void actualizar() {
        this.us = new Usuarios(frm.getTxtusuario().getText(), frm.getTxtcontrasena().getText(), frm.getTipo(), Integer.parseInt(frm.getTxtcedula().getText()), frm.getTxtnombre().getText(), frm.getFecha(), Integer.parseInt(frm.getTxttelefono().getText()), frm.getTxtcorreo().getText());

        Conexion con = new Conexion("UPDATE usuarios SET nombre=?, fecha=?, telefono=?, correo=?, usuario=?, contrasena=?,tipo=? WHERE cedula='" + frm.getTxtcedula().getText() + "'");

        con.ejecutarDUI(new Object[]{us.getNombre(), us.getFechaNto(), us.getTelefono(), us.getCorreo(), us.getUsuario(), us.getContrasena(),
             us.getTipo()});
    }

    public void eliminar() {
        this.us = new Usuarios(Integer.parseInt(frm.getTxtcedula().getText()));
        Conexion con = new Conexion("DELETE FROM usuarios WHERE cedula='" + us.getCedula() + "'");

        con.ejecutarUpdate();
    }

    public void validar(){
        if (frm.txtcedula.getText().equals("") || frm.txtcorreo.getText().equals("")||
                frm.txtnombre.getText().equals("")||frm.txttelefono.getText().equals("")||frm.txtusuario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "No se puede dejar espacios en blanco");
        }
        
    }
}
