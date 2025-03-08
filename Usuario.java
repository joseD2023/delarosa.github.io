/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete_interfaz;

/**
 *
 * @author Admin
 */

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    //DEFINIMOS ATRIBUTOS 
    private String cui; 
    private String nombre_usuario; 
    private String apellido_usuario; 
    private List<String> cuentas_del_usuario; //Listas para almacenar cuentas usuarios
    
    //NUESTRO CONSTRUCTOR ACEPTANDO DATOS DESDE EL PRINCIPIO
    public Usuario(String cui, String nombre_usuario, String apellido_usuario){
        //CREAMOS NUESTRO CONSTRUCTOR 
        this.cui = cui;
        this.nombre_usuario = nombre_usuario; 
        this.apellido_usuario = apellido_usuario;
        this.cuentas_del_usuario = new ArrayList(); //inicializamos la lista de cuentas vacias
        
    }
    
    //PARA MOSTRAR EL CUI VAMOS A USAG GET 
    public String getCui() {  // Método para obtener el CUI
        return cui;
    }
    //set cui 
    public void setcui(String cui){
        this.cui = cui;
        
    }
     // Método para obtener las cuentas del usuario
    public List<String> getCuentas() {
        return cuentas_del_usuario;
    }
    
    public void agregar_cuenta(String cuenta){ //agrega una cuenta mas al usuario es decir si tiene una cuenta le agrega otra 
        cuentas_del_usuario.add(cuenta);
        
    }
    // Métodos para obtener los valores
    public String getNombreUsuario() {
        return nombre_usuario;
    }
    
    // Método toString para mostrar la cuenta en el JList
    @Override
    public String toString() {
        return "Usuario: " + nombre_usuario + " | CUI: " + cui;
    }
    
}
