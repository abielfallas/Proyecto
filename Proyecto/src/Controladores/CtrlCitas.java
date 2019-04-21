package Controladores;

import Clases.Conexion;
import Clases.Pacientes;
import Frames.FrmListaPacientes;

/**
 *
 * @author Karina
 */
public class CtrlCitas {

    private FrmListaPacientes frm;

    public void seleccionar(FrmListaPacientes frm) {
     
        Conexion con = new Conexion("Select from citas 'fecha','hora','paciente'");
        con.ejecutarUpdate();

    }

    public CtrlCitas(FrmListaPacientes frm) {
        this.frm = frm;
    }
    
    

}
