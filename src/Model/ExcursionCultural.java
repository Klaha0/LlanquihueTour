package Model;

/**
 * @Clase ExcursionCultural
 * hereda de clase @ServicioTuristico
 * @lugarHistorico: Representa el lugar histórico visitado durante la excursión.
 */
public class ExcursionCultural extends ServicioTuristico {
    private String lugarHistorico;

    public ExcursionCultural(String nombre, double duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    /**Método mostrarInformacion
     * Muestra la información del servicio turístico ExcursionCultural.
     * @return String de servicio ExcursionCultural formateado
     */
    @Override
    public String mostrarInformacion() {        
        return "Excursion Cultural: " + getNombre() + 
               ", Duración: " + getDuracionHoras() + 
               " horas, Lugar Histórico: " + lugarHistorico;
    }
    
    
}
