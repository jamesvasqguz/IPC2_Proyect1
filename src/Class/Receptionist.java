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
public class Receptionist extends User{
    
    public Receptionist(int codigoUsuario, int tipoUsuario, String nombre, boolean estadoUsuario) {
        super(codigoUsuario, tipoUsuario, nombre, estadoUsuario);
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstadoUsario() {
        return estadoUsario;
    }

    public void setEstadoUsario(boolean estadoUsario) {
        this.estadoUsario = estadoUsario;
    }
    
}
