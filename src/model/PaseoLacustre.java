package model;

import data.GestorDatos;
import util.UtilServicioTuristico;

/**
 * Subclase de {@link ServicioTuristico} que representa un paseo en el lago.
 * Agrega el tipo de embarcación utilizada durante el paseo.
 */
public class PaseoLacustre extends ServicioTuristico{
    private GestorDatos gestor = new GestorDatos();
    private String tipoEmbarcacion;
    private UtilServicioTuristico util = new UtilServicioTuristico();
    /**
     * Crea un paseo lacustre.
     * @param nombre: nombre del servicio turístico a prestar.
     * @param duracionHoras: duración en horas del servicio.
     * @param tipoEmbarcacion: tipo de embarcación utilizada en el paseo.
     */
    public PaseoLacustre(String nombre, String duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;        
    }

    public String getTipoEmbarcacion() {
        return this.tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
     * Muestra la información del paseo lacustre, incluyendo el tipo de embarcación.
     * @return el String con el detalle del paseo lacustre formateado.
     */
    @Override
    public String toString() {
        return "Paseo Lacustre\t: " + this.getNombre() + "\n"+
               "Duración\t\t: " + String.format("%.2f Hrs.",this.getDuracionHoras()) + "\n"+
               "Tipo de Embarcación\t: " + this.tipoEmbarcacion + "\n";
    }
    @Override
        public void persistir() {
            String persistirPaseoLacustre = 
                    "PaseoLacustre;" +
                    this.getNombre() + ";" + 
                    this.getDuracionHoras() + ";"+
                    this.tipoEmbarcacion;
            gestor.persistirEntidad(persistirPaseoLacustre);
        }
}
