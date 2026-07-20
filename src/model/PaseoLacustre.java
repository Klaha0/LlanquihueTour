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
     * @param capacidad: cantidad de personas que pueden inscribirse (1 a 40).
     * @param tipoEmbarcacion: tipo de embarcación utilizada en el paseo.
     */
    public PaseoLacustre(String nombre, String duracionHoras, String capacidad, String tipoEmbarcacion) {
        super(nombre, duracionHoras, capacidad);
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
        return "Paseo Lacustre\t\t: " + this.getNombre() + "\n"+
               "Duración\t\t: " + String.format("%.1f Hrs.",this.getDuracionHoras()) + "\n"+
               "Capacidad\t\t: " + this.getCapacidad() + " personas\n"+
               "Tipo de Embarcación\t: " + this.tipoEmbarcacion + "\n";
    }
    @Override
    public void persistir() {
        String persistirPaseoLacustre =
                "PaseoLacustre;" +
                this.getNombre() + ";" +
                this.getDuracionHoras() + ";"+
                this.getCapacidad() + ";"+
                this.tipoEmbarcacion;
        gestor.persistirEntidad(persistirPaseoLacustre);
    }
}
