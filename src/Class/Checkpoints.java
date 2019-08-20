/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author jara
 */
public class Checkpoints {
    int estacion;
    float tarifa;
    Customers operario;
    ArrayList<Package> colaDePackage= new ArrayList<Package>();

    public Checkpoints(int estacion, float tarifa, Customers operario) {
        this.estacion = estacion;
        this.tarifa = tarifa;
        this.operario = operario;
    }

    public int getEstacion() {
        return estacion;
    }

    public void setEstacion(int estacion) {
        this.estacion = estacion;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }

    public Customers getOperario() {
        return operario;
    }

    public void setOperario(Customers operario) {
        this.operario = operario;
    }

    public ArrayList<Package> getColaDePackage() {
        return colaDePackage;
    }

    public void setColaDePackage(ArrayList<Package> colaDePackage) {
        this.colaDePackage = colaDePackage;
    }
    
    
}
