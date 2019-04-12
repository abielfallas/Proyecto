
package Clases;

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

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
      
}
