package Clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author sugei
 */
public class Persona {

    private int cedula;
    private String nombre;
    private String fechaNto;
    private int telefono;
    private String correo;

    public Persona(int cedula, String nombre, String fechaNto, int telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNto = fechaNto;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Persona(int cedula) {
        this.cedula = cedula;
    }

    public Persona() {
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {

        int cont = Integer.toString(cedula).length();

        if (cont == 9) {
            this.cedula = cedula;
        } else {
            this.cedula = this.cedula;
            JOptionPane.showMessageDialog(null, "*No se permiten números negativos \n *La cédula debe constar de 9 caracteres");
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        int cont = nombre.length();

        if (cont >= 1 & cont <= 10) {
            this.nombre = nombre;
        } else {
            this.nombre = this.nombre;
        }
        JOptionPane.showMessageDialog(null, "El nombre debe constar de al menos un caracter y un máximo de 60");

    }

    public String getFechaNto() {
        return fechaNto;
    }

    public void setFechaNto(String fechaNto) {
        this.fechaNto = fechaNto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        int cont = Integer.toString(telefono).length();

        if (cont == 8) {
            this.telefono = telefono;
        } else {
            this.telefono = this.telefono;
            JOptionPane.showMessageDialog(null, "*No se permiten números negativos \n *El teléfono debe constar de 8 carecteres");
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {


        if (correo.contains("@hotmail.com") || correo.contains("@gmail.com")) {
            this.correo = correo;

        }else{
            this.correo = this.correo;
            JOptionPane.showMessageDialog(null, "*Correo inválido \n *Solo se permiten correos 'gmail' o 'hotmail'");
        }

    }
}
