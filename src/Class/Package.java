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
public class Package {
float costo;
float peso;
boolean priodidad;
Checkpoints localizacion;
Checkpoints destino;
boolean estadoPackage;
int horasEnCheckpoints;

    public Package(float costo, float peso, boolean priodidad, Checkpoints localizacion, Checkpoints destino, boolean estadoPackage, int horasEnCheckpoints) {
        this.costo = costo;
        this.peso = peso;
        this.priodidad = priodidad;
        this.localizacion = localizacion;
        this.destino = destino;
        this.estadoPackage = estadoPackage;
        this.horasEnCheckpoints = horasEnCheckpoints;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public boolean isPriodidad() {
        return priodidad;
    }

    public void setPriodidad(boolean priodidad) {
        this.priodidad = priodidad;
    }

    public Checkpoints getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Checkpoints localizacion) {
        this.localizacion = localizacion;
    }

    public Checkpoints getDestino() {
        return destino;
    }

    public void setDestino(Checkpoints destino) {
        this.destino = destino;
    }

    public boolean isEstadoPackage() {
        return estadoPackage;
    }

    public void setEstadoPackage(boolean estadoPackage) {
        this.estadoPackage = estadoPackage;
    }

    public int getHorasEnCheckpoints() {
        return horasEnCheckpoints;
    }

    public void setHorasEnCheckpoints(int horasEnCheckpoints) {
        this.horasEnCheckpoints = horasEnCheckpoints;
    }
    

}
