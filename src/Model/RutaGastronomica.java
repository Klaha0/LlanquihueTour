package Model;

/**
 * @Clase RutaGastronomica
 * hereda de clase @ServicioTuristico
 * @numeroDeParadas: Representa la cantidad de detenciones
 * de la ruta, cada parada, una visita distinta.
 */
public class RutaGastronomica extends ServicioTuristico implements Registrable{
    private int numeroDeParadas;

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

    /**Método mostrarInformacion
     * Muestra la información del servicio turístico RutaGastronomica.
     * @return String de servicio RutaGastronomica formateado
     */
    @Override
    public String mostrarInformacion() {
        return "Ruta Gastronómica: " + getNombre() + 
               ", Duración: " + getDuracionHoras() + 
               " horas, Número de Paradas: " + numeroDeParadas;
    }    
    
    @Override
    public String mostrarResumen() {
        return this.mostrarInformacion();
    }
}
