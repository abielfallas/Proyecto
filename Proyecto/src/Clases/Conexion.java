/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abiel Fallas
 */
public class Conexion {
    private static Connection conexion;
    private ResultSet datos;
    private PreparedStatement sentencia;
    private String ip;
    private String nombre;
    private String usuario;
    private String contrasena;
    
        public Conexion() {
        this.conectar();
    }
    
      public Conexion(String sql) {
        this.conectar();
        this.setSentencia(sql);
    }
    
    public boolean conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexion=DriverManager.getConnection("jdbc:mysql://"+this.getIp()+"/"+this.getNombre()+"?useServerPrepStmts=true", this.getUsuario(), this.getContrasena());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        }
    
        public boolean setSentencia(String sql) {
        try {
            this.sentencia = this.conexion.prepareStatement(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean setParametro(Object[] param) {
        for (int i = 0; i < param.length; i++) {
            if (param[i] instanceof String) {
                try {
                    String dato = (String) param[i];
                    this.sentencia.setString(i + 1, dato);
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            } else {
                if (param[i] instanceof Integer) {
                    try {
                        this.sentencia.setInt(i + 1, Integer.parseInt(param[i].toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean ejecutar() {
        try {
            if (this.sentencia.execute()) {
                this.datos=this.sentencia.getResultSet();
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "El número de cedula o nombre de usuario ya existen");
        }
        return false;
    }
    
    public boolean ejecutarUpdate(){
        try {
            if (this.sentencia.executeUpdate()>1) {
                this.datos=this.sentencia.getResultSet();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean ejecutarS(Object[] param) {
        this.setParametro(param);
        return this.ejecutar();
    }
    
    public boolean ejecutarDUI(Object[] param){
        this.setParametro(param);
        return this.ejecutarUpdate();
    }
    
        public boolean ejecutarU(Object[] param) {
        this.setParametro(param);
        try {
            this.sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
        

}
