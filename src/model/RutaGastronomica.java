package model;

import data.GestorDatos;
import util.UtilServicioTuristico;

/**
 * Subclase de {@link ServicioTuristico} que representa una ruta gastronómica.
 * Agrega la cantidad de paradas de la ruta, cada una correspondiente a una visita distinta.
 */
public class RutaGastronomica extends ServicioTuristico{
    private int numeroDeParadas;
    private GestorDatos gestor = new GestorDatos();
    private UtilServicioTuristico util = new UtilServicioTuristico();

    /**
     * Crea una ruta gastronómica.
     * @param nombre: nombre del tour.
     * @param duracionHoras: duración en horas del servicio.
     * @param capacidad: cantidad de personas que pueden inscribirse (1 a 40).
     * @param numeroDeParadas: cantidad de paradas de la ruta.
     */
    public RutaGastronomica(String nombre, String duracionHoras, String capacidad, String numeroDeParadas) {
        super(nombre, duracionHoras, capacidad);
        if(util.esEntero(numeroDeParadas)){
            this.numeroDeParadas = Integer.parseInt(numeroDeParadas);
        }
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(String numeroDeParadas) {
        if(util.esEntero(numeroDeParadas))
            this.numeroDeParadas = Integer.parseInt(numeroDeParadas);        
    }

    /**
     * Muestra la información de la ruta gastronómica, incluyendo el número de paradas.
     * @return el String con el detalle de la ruta gastronómica formateado.
     */
    @Override
    public String toString() {
        return "Ruta Gastronómica\t: " + this.getNombre() + "\n"+
               "Duración\t\t: " + String.format("%.2f Hrs.",this.getDuracionHoras()) +  "\n"+
               "Capacidad\t\t: " + this.getCapacidad() + " personas\n"+
               "Número de Paradas\t: " + this.numeroDeParadas+ "\n";
    }

    @Override
    public void persistir() {
        String persistirRutaGastronomica =
                "RutaGastronomica;" +
                this.getNombre() + ";" +
                this.getDuracionHoras() + ";"+
                this.getCapacidad() + ";"+
                this.numeroDeParadas;
        gestor.persistirEntidad(persistirRutaGastronomica);
    }
}
