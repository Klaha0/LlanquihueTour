package Model;

/**@ServicioTuristico
 * Super Clase que servirá para crear distintos 
 * servicios turísticos.
 * @nombre: Nombre del servicio turístico a prestar.
 * @duracionHoras: Duración en horas del servicio.
 */
public class ServicioTuristico {
    private String nombre;
    private double duracionHoras;

    public ServicioTuristico(String nombre, double duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(double duracionHoras) {
        this.duracionHoras = duracionHoras;
    }
    /**
     *@toString (sobrescritura)
     * @return String de servicio formateado
     */
    @Override
    public String toString() {
        return "Servicio Turístico: " + nombre + 
               " tiene una duración de: " + duracionHoras + 
               "hrs.";
    }
    
    
}
