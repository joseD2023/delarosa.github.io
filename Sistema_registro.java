/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete_interfaz;

/**
 *
 * @author Admin
 */
import Paquete_interfaz.Usuario;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;

public class Sistema_registro {
    static List<Usuario> Listas_usuarios = new ArrayList<>();//Lista para almacenar a los nuevos usuarios
    //CONSTRUCTOR 
    public Sistema_registro(){
        //VACIOS EL CONSTRUCTOR
    }
    
    public void registro_usuario(String cui, String nombre, String apellido, javax.swing.JFrame inter){
        
        for(Usuario i: Listas_usuarios){
            if(i.getCui().equals(cui)){
                 // Si el CUI ya existe, mostrar un mensaje de error en la interfaz
                JOptionPane.showMessageDialog(inter, "¡Error! El CUI ya está registrado.", 
                                              "CUI Duplicado", JOptionPane.ERROR_MESSAGE);
                return; // Salir si ya existe un usuario con el mismo CUI
            }
        }
        Usuario nuevo_usuario = new Usuario(cui, nombre, apellido);
        Listas_usuarios.add(nuevo_usuario); //agregamos cuentas al sistema 
        // Mostrar un mensaje de éxito
        JOptionPane.showMessageDialog(inter, "Usuario registrado con éxito: " + nombre);
        
        
    }
    
    public void registrar_cuenta_usuario(String cui, javax.swing.JFrame inter){
       Usuario usuario = buscarusuariocui(cui);
       if(usuario != null){
           Random random = new Random();
           String numero_cuenta = "ACC" + (100000 + random.nextInt(900000)); // Generar número de cuenta
           usuario.agregar_cuenta(numero_cuenta);
           JOptionPane.showMessageDialog(inter, "Cuenta agregada exitosamente"); 
       } else{
           JOptionPane.showMessageDialog(inter, "Usuarion NO encontrado"); 
           
       }
        
    }
    
    //VAMOS A MOSTRAR LOS DATOS GUARDADOS O CUENTAS GUARDADAS 
   public void mostrar_cuentas_agregadas(String cui, javax.swing.JFrame mensaje){
    boolean usuario_encontrado = false;
    for(Usuario i: this.Listas_usuarios){
        if(i.getCui().equals(cui)){
            usuario_encontrado = true;
            if(i.getCuentas().isEmpty()){
                JOptionPane.showMessageDialog(mensaje, "Usuario no tiene cuentas agregadas"); 
            } else {
                StringBuilder cuentas = new StringBuilder("Cuentas del usuario:\n");
                for(String cuentas_ver : i.getCuentas()){
                    cuentas.append("- ").append(cuentas_ver).append("\n");
                }
                JOptionPane.showMessageDialog(mensaje, cuentas.toString());
            }
            return;
        }
    }
    
    if(!usuario_encontrado){ // ✅ Se verifica después del ciclo
        JOptionPane.showMessageDialog(mensaje, "¡Error! Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    //BUSCAR USUARIO POR CUI 
   private Usuario buscarusuariocui(String cui) {
    for (Usuario x : Listas_usuarios) {
        if (x.getCui().equals(cui)) {
            return x; // Devuelve el usuario si se encuentra
        }
    }
    return null; // Devuelve null si el usuario no existe
}

    
    
    
}
