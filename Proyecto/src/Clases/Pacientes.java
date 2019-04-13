package Clases;

//import java.sql.Date;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Abiel Fallas
 */
public class Pacientes extends Persona {

    public Pacientes(int cedula) {
        super(cedula);
    }

    public Pacientes(int cedula, String nombre, String fechaNto, int telefono, String correo) {
        super(cedula, nombre, fechaNto, telefono, correo);
    }

    public Pacientes() {
    }

    public void calcularEdad(String Fnacimiento) {
        String fechaNacimiento = Fnacimiento;
        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechaActual = df.format(date);
        String[] fNacimiento = fechaNacimiento.split("/");
        String[] fActual = fechaActual.split("/");
        int anios = Integer.parseInt(fActual[2]) - Integer.parseInt(fNacimiento[2]);
        int mes = Integer.parseInt(fActual[1]) - Integer.parseInt(fNacimiento[1]);
        if (mes < 0) {
            anios = anios - 1;
        } else if (mes == 0) {
            int dia = Integer.parseInt(fActual[0]) - Integer.parseInt(fNacimiento[0]);
            if (dia > 0) {
                anios = anios - 1;
            }
        }
        
        //System.out.println("La edad del pasiente es: " + anios + " años");
        JOptionPane.showMessageDialog(null, "La edad del paciente es: " + anios + " años");
    }

    
    
    
    
    
    
    
    
    
    
    
    
}
