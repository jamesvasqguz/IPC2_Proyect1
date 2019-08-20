/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;

/**
 *
 * @author jara
 */
public class Warehouse {
ArrayList<Package> colaDeWarehouse= new ArrayList<Package>();

    public Warehouse() {
    }

    public ArrayList<Package> getColaDeWarehouse() {
        return colaDeWarehouse;
    }

    public void setColaDeWarehouse(ArrayList<Package> colaDeWarehouse) {
        this.colaDeWarehouse = colaDeWarehouse;
    }

    
}
