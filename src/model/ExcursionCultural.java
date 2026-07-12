package model;

/**
 * Subclase de ServicioTuristico que representa una excursión cultural.
 * Agrega el lugar histórico visitado durante la excursión.
 */
public class ExcursionCultural extends ServicioTuristico{
    private String lugarHistorico;

    /**
     * Crea una excursión cultural.
     * @param nombre: nombre de la excursión cultural.
     * @param duracionHoras: duración en horas del servicio.
     * @param lugarHistorico: lugar histórico visitado durante la excursión.
     */
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

    /**
     * Muestra la información de la excursión cultural, incluyendo el lugar histórico.
     * @return el String con el detalle de la excursión cultural formateado.
     */
    @Override
    public String mostrarResumen() {
        return "Excursion Cultural     : " + this.getNombre() + "\n"+
               "Duración                    : " + String.format("%.2f Hrs.",this.getDuracionHoras()) +  "\n"+
               "Lugar Histórico          : " + this.lugarHistorico + "\n";
    }
    
}
