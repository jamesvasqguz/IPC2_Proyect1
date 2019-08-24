package Class;

/**
 *
 * @author jara
 */
public class Paquete {

    int idPaquete, tiempoRuta;
    String destino, nitCliente, localizacion, estadoPaquete;
    boolean prioridad;

    public Paquete(int idPaquete, int tiempoRuta, String destino, String nitCliente, String localizacion, String estadoPaquete, boolean prioridad) {
        this.idPaquete = idPaquete;
        this.tiempoRuta = tiempoRuta;
        this.destino = destino;
        this.nitCliente = nitCliente;
        this.localizacion = localizacion;
        this.estadoPaquete = estadoPaquete;
        this.prioridad = prioridad;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getTiempoRuta() {
        return tiempoRuta;
    }

    public void setTiempoRuta(int tiempoRuta) {
        this.tiempoRuta = tiempoRuta;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getNitCliente() {
        return nitCliente;
    }

    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getEstadoPaquete() {
        return estadoPaquete;
    }

    public void setEstadoPaquete(String estadoPaquete) {
        this.estadoPaquete = estadoPaquete;
    }

    public boolean isPrioridad() {
        return prioridad;
    }

    public void setPrioridad(boolean prioridad) {
        this.prioridad = prioridad;
    }

}
