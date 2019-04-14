/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Abiel Fallas
 */
public class Medicos extends Persona {

    private String codigo;
    private String especialidad;
    private double salario;

    public Medicos(String codigo, String especialidad, double salario, int cedula, String nombre, String fechaNto, int telefono, String correo) {
        super(cedula, nombre, fechaNto, telefono, correo);
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.salario = salario;
    }
        public Medicos(int cedula) {
        super(cedula);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double deducEnfermedad() {
        return this.salario * 0.055;
    }

    public double deducInvalidez() {
        return this.salario * 0.0384;
    }

    public double deducAporteTra() {
        return this.salario * 0.01;
    }

    public double deducAsocSolidarita() {
        return this.salario * 0.033;
    }

    public double deducImpuVenta() {
        if (this.salario > 817001 && this.salario < 1226000) {
            double num = this.salario - 817001;
            return num * 0.1;
        } else {
            if (this.salario > 1226001) {
                double num = this.salario - 1226001;
                return num * 0.15;
            }
        }
        return 0;
    }

    public void calcularNeto() {
        double num = this.deducAporteTra() + this.deducAsocSolidarita() + this.deducEnfermedad()
                + this.deducImpuVenta() + this.deducInvalidez();
        System.out.println(this.salario - num);
    }
}
