package model;

/**
 * Superclase que representa un servicio turístico genérico ofrecido por la agencia.
 * Sirve de base para las distintas variantes de servicio (rutas, paseos, excursiones).
 */
public class ServicioTuristico implements Registrable{
    private String nombre;
    private double duracionHoras;

    /**
     * Crea un servicio turístico con su nombre y duración.
     * @param nombre: nombre del servicio turístico a prestar.
     * @param duracionHoras: duración en horas del servicio.
     */
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
     * Muestra la información del servicio turístico.
     * @return el String con el detalle del servicio formateado.
     */
    public String mostrarResumen() {
        return nombre + "\n" +
               " tiene una duración de: " + String.format("%.2f", this.getDuracionHoras()) + " hrs." + "\n";
    }

}
