/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Conexion;
import Clases.Medicos;
import Clases.Usuarios;
import Frames.frmMedicos;
import Frames.frmRegistroUsuarios;

/**
 *
 * @author Victoria Arias
 */
public class CtrlMedicos {
     private  frmMedicos frm;
    private Medicos medico;

    public CtrlMedicos(frmMedicos  frm) {
        this.frm = frm;
        this.medico = null;
    }

    public void registrar(){
       this.medico=new Medicos(frm.getTxtCodigo().getText(),frm.getTxtEspecialidad().getText(),Double.parseDouble(frm.getTxtSalario().getText()),Integer.parseInt(frm.getTxtCedula().getText()),frm.getTxtNombre().getText(),frm.getFecha(),Integer.parseInt(frm.getTxtCel().getText()),frm.getTxtCorreo().getText());
        
        Conexion con = new Conexion("Insert into medicos values(?,?,?,?,?,?,?,?)");
        
        con.ejecutarS(new Object[]{medico.getCedula(),medico.getNombre(),medico.getFechaNto(),medico.getTelefono(),medico.getCorreo(),medico.getCodigo(),medico.getEspecialidad()
        ,medico.getSalario()});
    }
    
public void actualizar(){
        this.medico=new Medicos(frm.getTxtCodigo().getText(),frm.getTxtEspecialidad().getText(),Double.parseDouble(frm.getTxtSalario().getText()),Integer.parseInt(frm.getTxtCedula().getText()),frm.getTxtNombre().getText(),frm.getFecha(),Integer.parseInt(frm.getTxtCel().getText()),frm.getTxtCorreo().getText());
         
        Conexion con = new Conexion("UPDATE medicos SET nombre=?, fecha=?, telefono=?, correo=?, codigo=?, especialidad=?,salario=? WHERE cedula='"+frm.getTxtCedula().getText()+"'");
        
        con.ejecutarDUI(new Object[]{medico.getNombre(),medico.getFechaNto(),medico.getTelefono(),medico.getCorreo(),medico.getCodigo(),medico.getEspecialidad()
        ,medico.getSalario()});
    }

public void eliminar(){
     this.medico=new Medicos(Integer.parseInt(frm.getTxtCedula().getText()));
            Conexion con = new Conexion("DELETE FROM medicos WHERE cedula='"+medico.getCedula()+"'");
        
        con.ejecutarUpdate();
}
}
