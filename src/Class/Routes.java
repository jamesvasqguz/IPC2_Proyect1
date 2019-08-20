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
public class Routes {
    boolean estadoDeLaRuta;
    Checkpoints checkpoints;

    public Routes(boolean estadoDeLaRuta, Checkpoints checkpoints) {
        this.estadoDeLaRuta = estadoDeLaRuta;
        this.checkpoints = checkpoints;
    }

    public boolean isEstadoDeLaRuta() {
        return estadoDeLaRuta;
    }

    public void setEstadoDeLaRuta(boolean estadoDeLaRuta) {
        this.estadoDeLaRuta = estadoDeLaRuta;
    }

    public Checkpoints getCheckpoints() {
        return checkpoints;
    }

    public void setCheckpoints(Checkpoints checkpoints) {
        this.checkpoints = checkpoints;
    }
    
}
