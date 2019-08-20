/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author jara
 */
public class User {
    int codigoUsuario;
    int tipoUsuario;
    String  nombre;
    boolean estadoUsario;
    
    public User(int codigoUsuario, int tipoUsuario, String nombre, boolean estadoUsuario) {
    this.codigoUsuario= codigoUsuario;
    this.tipoUsuario= tipoUsuario;
    this.nombre= nombre;
    this.estadoUsario= estadoUsuario;
    }
    
    
    
}
