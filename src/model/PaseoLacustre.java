package model;

/**
 * Subclase de {@link ServicioTuristico} que representa un paseo en el lago.
 * Agrega el tipo de embarcación utilizada durante el paseo.
 */
public class PaseoLacustre extends ServicioTuristico{
    private String tipoEmbarcacion;

    /**
     * Crea un paseo lacustre.
     * @param nombre: nombre del servicio turístico a prestar.
     * @param duracionHoras: duración en horas del servicio.
     * @param tipoEmbarcacion: tipo de embarcación utilizada en el paseo.
     */
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
     * Muestra la información del paseo lacustre, incluyendo el tipo de embarcación.
     * @return el String con el detalle del paseo lacustre formateado.
     */
    @Override
    public String mostrarResumen() {
        return "Paseo Lacustre          : " + this.getNombre() + "\n"+
               "Duración                     : " + String.format("%.2f Hrs.",this.getDuracionHoras()) + "\n"+
               "Tipo de Embarcación : " + this.tipoEmbarcacion + "\n";
    }

}
