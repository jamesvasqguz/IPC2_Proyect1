package Class;

/**
 *
 * @author jara
 */
public class Paquete {

//Atributos que declaramos globales  
    int idPaquete, tiempoRuta;
    String destino, nitCliente, localizacion, estadoPaquete;
    boolean prioridad;

    /**
     * Constructor de la clase Paquete Le enviamos los siquiente parametros
     *
     * @param idPaquete
     * @param tiempoRuta
     * @param destino
     * @param nitCliente
     * @param localizacion
     * @param estadoPaquete
     * @param prioridad
     */
    public Paquete(int idPaquete, int tiempoRuta, String destino, String nitCliente, String localizacion, String estadoPaquete, boolean prioridad) {
        this.idPaquete = idPaquete;
        this.tiempoRuta = tiempoRuta;
        this.destino = destino;
        this.nitCliente = nitCliente;
        this.localizacion = localizacion;
        this.estadoPaquete = estadoPaquete;
        this.prioridad = prioridad;
    }

    /**
     * Seteamos todos lo parametros
     */

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public void setTiempoRuta(int tiempoRuta) {
        this.tiempoRuta = tiempoRuta;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public void setEstadoPaquete(String estadoPaquete) {
        this.estadoPaquete = estadoPaquete;
    }

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Retornamos todos los parametros
     *
     * @return
     */
    public int getIdPaquete() {
        return idPaquete;
    }

    public int getTiempoRuta() {
        return tiempoRuta;
    }

    public String getDestino() {
        return destino;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public String getEstadoPaquete() {
        return estadoPaquete;
    }

    public boolean isPrioridad() {
        return prioridad;
    }
}
