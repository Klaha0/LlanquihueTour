package Model;

/**
 * @Clase RutaGastronomica
 * hereda de clase @ServicioTuristico
 * @numeroDeParadas: Representa la cantidad de detenciones
 * de la ruta, cada parada, una visita distinta.
 */
public class RutaGastronomica extends ServicioTuristico{
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
    /**
     * @toString (sobrescritura)
     * @return String de servicio RutaGastronomica formateado
     */
    @Override
    public String toString() {
        return "Ruta Gastronómica: " + getNombre() + 
               ", Duración: " + getDuracionHoras() + 
               " horas, Número de Paradas: " + numeroDeParadas;
    }

    
}
