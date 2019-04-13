
package Controladores;

import Clases.Conexion;
import Clases.Pacientes;
import Clases.Usuarios;
import Frames.frmRegistrarPaciente;

/**
 *
 * @author sugei
 */
public class CtrlPacientes {
    
    private frmRegistrarPaciente frm;
    private Pacientes pa;

    public CtrlPacientes(frmRegistrarPaciente frm) {
        this.frm = frm;
        this.pa = pa;
    }
    
    
    
    
   
    public void registrar(){
        this.pa=new Pacientes(Integer.parseInt(frm.getTxtCedula().getText()),frm.getTxtNombre().getText(),frm.getFecha(),Integer.parseInt(frm.getTxtTelefono().getText()),frm.getTxtCorreo().getText());
        
        Conexion con = new Conexion("Insert into usuarios values(?,?,?,?,?)");
        con.ejecutarS(new Object[]{pa.getCedula(),pa.getNombre(),pa.getFechaNto(),pa.getTelefono(),pa.getCorreo()});
    }
    
public void actualizar(){
        this.pa=new Pacientes(Integer.parseInt(frm.getTxtCedula().getText()),frm.getTxtNombre().getText(),frm.getFecha(),Integer.parseInt(frm.getTxtTelefono().getText()),frm.getTxtCorreo().getText());
        
        Conexion con = new Conexion("UPDATE usuarios SET nombre=?, fecha=?, telefono=?, correo=? WHERE cedula='"+frm.getTxtCedula().getText()+"'");
        con.ejecutarDUI(new Object[]{pa.getNombre(),pa.getFechaNto(),pa.getTelefono(),pa.getCorreo()});
    }

public void eliminar(){
    this.pa=new Pacientes(Integer.parseInt(frm.getTxtCedula().getText()));
        Conexion con = new Conexion("DELETE FROM usuarios WHERE cedula='"+pa.getCedula()+"'");
        con.ejecutarUpdate();
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
