package Model;

/**
 * @Clase PaseoLacustre
 * hereda de clase @ServicioTuristico
 * @tipoEmbarcacion: Representa el tipo de embarcación utilizada en el paseo.
 */
public class PaseoLacustre extends ServicioTuristico{
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

    /**
     * @toString (sobrescritura)
     * @return String de servicio PaseoLacustre formateado
     */
    @Override
    public String toString() {        
        return "Paseo Lacustre: " + getNombre() + 
               ", Duración: " + getDuracionHoras() + 
               " horas, Tipo de Embarcación: " + tipoEmbarcacion;
    }
    
    
}
