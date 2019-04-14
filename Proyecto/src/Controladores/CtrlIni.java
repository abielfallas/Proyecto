/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Clases.Conexion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abiel Fallas
 */
public class CtrlIni {
    
    public static boolean ConectarBD(){
        Properties p=new Properties();
        InputStream isArchivo;
        
        try {
            isArchivo= new FileInputStream("C:\\Users\\Abiel Fallas\\Desktop\\Abiel\\DD\\Proyecto\\Proyecto\\src\\Ini\\Archivo.properties");
            p.load(isArchivo);
            p.setProperty("IP", "127.0.0.1");
            p.setProperty("Nombre", "consultorio");
            p.setProperty("Usuario", "Java");
            p.setProperty("Contrasena", "123");
            p.store(new FileWriter("C:\\Users\\Abiel Fallas\\Desktop\\Abiel\\DD\\Proyecto\\Proyecto\\src\\Ini\\Archivo.properties"),"Se actulizo");
            Conexion c= new Conexion(p.getProperty("IP"), p.getProperty("Nombre"), p.getProperty("Usuario"), p.getProperty("Contrasena"));
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CtrlIni.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(CtrlIni.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
}
