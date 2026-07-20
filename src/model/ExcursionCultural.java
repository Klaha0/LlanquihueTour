package model;

import data.GestorDatos;

/**
 * Subclase de ServicioTuristico que representa una excursión cultural.
 * Agrega el lugar histórico visitado durante la excursión.
 */
public class ExcursionCultural extends ServicioTuristico{
    private GestorDatos gestor = new GestorDatos();
    private String lugarHistorico;
    /**
     * Crea una excursión cultural.
     * @param nombre: nombre de la excursión cultural.
     * @param duracionHoras: duración en horas del servicio.
     * @param capacidad: cantidad de personas que pueden inscribirse (1 a 40).
     * @param lugarHistorico: lugar histórico visitado durante la excursión.
     */
    public ExcursionCultural(String nombre, String duracionHoras, String capacidad, String lugarHistorico) {
        super(nombre, duracionHoras, capacidad);
        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    /**
     * Muestra la información de la excursión cultural, incluyendo el lugar histórico.
     * @return el String con el detalle de la excursión cultural formateado.
     */
    @Override
    public String toString() {
        return "Excursion Cultural\t: " + this.getNombre() + "\n"+
               "Duración\t\t: " + String.format("%.2f Hrs.",this.getDuracionHoras()) +  "\n"+
               "Capacidad\t\t: " + this.getCapacidad() + " personas\n"+
               "Lugar Histórico\t\t: " + this.lugarHistorico + "\n";
    }

    @Override
    public void persistir() {
        String persistirExcursionCultural =
                "ExcursionCultural;" +
                this.getNombre() + ";" +
                this.getDuracionHoras() + ";"+
                this.getCapacidad() + ";"+
                this.lugarHistorico;
        gestor.persistirEntidad(persistirExcursionCultural);
    }
    
}
