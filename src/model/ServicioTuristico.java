package model;

import util.UtilServicioTuristico;

/**
 * Superclase que representa un servicio turístico genérico ofrecido por la agencia.
 * Sirve de base para las distintas variantes de servicio (rutas, paseos, excursiones).
 */
public class ServicioTuristico implements Persistible{
    private String nombre;
    private double duracionHoras;
    private int capacidad;
    private UtilServicioTuristico util = new UtilServicioTuristico();

    /**
     * Crea un servicio turístico con su nombre, duración y capacidad.
     * @param nombre: nombre del servicio turístico a prestar.
     * @param duracionHoras: duración en horas del servicio.
     * @param capacidad: cantidad de personas que pueden inscribirse (1 a 40).
     */
    public ServicioTuristico(String nombre, String duracionHoras, String capacidad) {
        this.nombre = nombre;
        if(util.esDouble(duracionHoras))
            this.duracionHoras = Double.parseDouble(duracionHoras);
        if(util.esEntero(capacidad) && util.validarCapacidad(capacidad))
            this.capacidad = Integer.parseInt(capacidad);
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

    public void setDuracionHoras(String duracionHoras) {
        if(util.esDouble(duracionHoras))
            this.duracionHoras = Double.parseDouble(duracionHoras);
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        if(util.esEntero(capacidad) && util.validarCapacidad(capacidad))
            this.capacidad = Integer.parseInt(capacidad);
    }

    /**
     * Muestra la información del servicio turístico.
     * @return el String con el detalle del servicio formateado.
     */
    public String toString() {
        return nombre + "\n" +
               " tiene una duración de: " + String.format("%.2f", this.getDuracionHoras()) + " hrs." + "\n" +
               " capacidad: " + this.capacidad + " personas." + "\n";
    }

    @Override
    public void persistir() {

        String persistirExcursionCultural =
                "ExcursionCultural;" +
                this.nombre + ";" +
                this.duracionHoras + ";" +
                this.capacidad;

    }
}
