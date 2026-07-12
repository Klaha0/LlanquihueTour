package model;

/**
 * Subclase de {@link ServicioTuristico} que representa una ruta gastronómica.
 * Agrega la cantidad de paradas de la ruta, cada una correspondiente a una visita distinta.
 */
public class RutaGastronomica extends ServicioTuristico{
    private int numeroDeParadas;

    /**
     * Crea una ruta gastronómica.
     * @param nombre: nombre del tour.
     * @param duracionHoras: duración en horas del servicio.
     * @param numeroDeParadas: cantidad de paradas de la ruta.
     */
    public RutaGastronomica(String nombre, double duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Muestra la información de la ruta gastronómica, incluyendo el número de paradas.
     * @return el String con el detalle de la ruta gastronómica formateado.
     */
    @Override
    public String mostrarResumen() {
        return "Ruta Gastronómica   : " + this.getNombre() + "\n"+
               "Duración                    : " + String.format("%.2f Hrs.",this.getDuracionHoras()) +  "\n"+
               "Número de Paradas  : " + this.numeroDeParadas+ "\n";
    }

}
