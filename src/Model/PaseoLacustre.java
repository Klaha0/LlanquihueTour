package Model;

/**
 * @Clase PaseoLacustre
 * hereda de clase @ServicioTuristico
 * @tipoEmbarcacion: Representa el tipo de embarcación utilizada en el paseo.
 */
public class PaseoLacustre extends ServicioTuristico implements Registrable{
    private String tipoEmbarcacion; 
    
    public PaseoLacustre(String nombre, double duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**Método mostrarInformacion
     * Muestra la información del servicio turístico PaseoLacustre.
     * @return String de servicio PaseoLacustre formateado
     */
    @Override
    public String mostrarInformacion() {        
        return "Paseo Lacustre: " + getNombre() + 
               ", Duración: " + getDuracionHoras() + 
               " horas, Tipo de Embarcación: " + tipoEmbarcacion;
    }
    
    @Override
    public String mostrarResumen() {
        return this.mostrarInformacion();
    }
}
