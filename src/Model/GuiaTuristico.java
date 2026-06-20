package Model;
import Exception.GuiaTuristicoException;
import Util.UtilDireccion;
import Util.UtilGuiaTuristico;

/**
 * Clase que representa un guía turístico con sus datos personales y dirección.
 * Cada guía tiene un nombre, una edad y una dirección asociada.
 */
public class GuiaTuristico {
    private UtilGuiaTuristico util = new UtilGuiaTuristico();
    private UtilDireccion utilDireccion = new UtilDireccion();
    private String nombre;
    private int Edad;
    private Direccion direccion;

    /**
     * Crea un guía turístico validando sus datos antes de asignarlos.
     * @param nombre: nombre del guía turístico.
     * @param edad: edad del guía turístico.
     * @param direccion: dirección del guía turístico.
     * @throws GuiaTuristicoException si el nombre o la edad son inválidos.
     */
    public GuiaTuristico(String nombre, int edad, Direccion direccion) throws GuiaTuristicoException {

        if(util.ValidarNombre(nombre))
            this.nombre = nombre;

        if(util.ValidarEdad(edad))
            this.Edad = edad;

        if(utilDireccion.esValidaDireccion(direccion))
        this.direccion = direccion;
    }

    /**
     * Getter del nombre del guía turístico.
     * @return el nombre del guía turístico.
     */
    public String getNombre() {

        return nombre;
    }

    /**
     * Setter del nombre del guía turístico.
     * @param nombre: nombre del guía turístico.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la dirección del guía turístico.
     * @return la dirección del guía turístico.
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Setter de la dirección del guía turístico.
     * @param direccion: dirección del guía turístico.
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Getter de la edad del guía turístico.
     * @return la edad del guía turístico.
     */
    public int getEdad() {
        return Edad;
    }

    /**
     * Setter de la edad del guía turístico.
     * @param Edad: edad del guía turístico.
     */
    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    /**
     * sobreescribe el método toString con formato personalizado
     * @return el texto descriptivo del guía turístico.
     */
    @Override
    public String toString() {
        return "\t***Datos Guía Turístico***\n"+
               "Nombre: " + nombre + " Edad: " + Edad + "\n"+ 
                direccion.toString();
    }

}
