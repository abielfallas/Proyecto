/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Conexion;
import Clases.Usuarios;
import Frames.frmRegistroUsuarios;

/**
 *
 * @author Abiel Fallas
 */
public class CtrlUsuarios {
    private frmRegistroUsuarios frm;
    private Usuarios us;

    public CtrlUsuarios(frmRegistroUsuarios frm) {
        this.frm = frm;
        this.us = us;
    }

  

    
public void registrar(){
        this.us=new Usuarios(frm.getTxtusuario().getText(),frm.getTxtcontrasena().getText(),frm.getTipo(),Integer.parseInt(frm.getTxtcedula().getText()),frm.getTxtnombre().getText(),frm.getFecha(),Integer.parseInt(frm.getTxttelefono().getText()),frm.getTxtcorreo().getText());
        
        Conexion con = new Conexion("Insert into usuarios values(?,?,?,?,?,?,?,?)");
        
        con.ejecutar(new Object[]{us.getCedula(),us.getNombre(),us.getFechaNto(),us.getTelefono(),us.getCorreo(),us.getUsuario(),us.getContrasena()
        ,us.getTipo()});
    }
    
public void actualizar(){
        this.us=new Usuarios(frm.getTxtusuario().getText(),frm.getTxtcontrasena().getText(),frm.getTipo(),Integer.parseInt(frm.getTxtcedula().getText()),frm.getTxtnombre().getText(),frm.getFecha(),Integer.parseInt(frm.getTxttelefono().getText()),frm.getTxtcorreo().getText());
        
        Conexion con = new Conexion("UPDATE usuarios SET nombre=?, fecha=?, telefono=?, correo=?, usuario=?, contrasena=?,tipo=? WHERE cedula='"+frm.getTxtcedula().getText()+"'");
        
        con.ejecutar(new Object[]{us.getCedula(),us.getNombre(),us.getFechaNto(),us.getTelefono(),us.getCorreo(),us.getUsuario(),us.getContrasena()
        ,us.getTipo()});
    }

}
