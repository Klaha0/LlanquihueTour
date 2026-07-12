package model;

import util.UtilDireccion;
import util.UtilGuiaTuristico;

/**
 * Clase que representa un guía turístico con sus datos personales y dirección.
 * Cada guía tiene un nombre, una edad y una dirección asociada.
 */
public class GuiaTuristico implements Registrable{
    private UtilGuiaTuristico util = new UtilGuiaTuristico();
    private UtilDireccion utilDireccion = new UtilDireccion();
    private String nombre;
    private int edad;
    private Direccion direccion;

    /**
     * Crea un guía turístico validando sus datos antes de asignarlos.
     * @param nombre: nombre del guía turístico.
     * @param edadString: edad del guía turístico.
     * @param direccion: dirección del guía turístico.
     */
    public GuiaTuristico(String nombre, String edadString, Direccion direccion)
    {
        if(!util.esEntero(edadString) || !util.validarEdad(edadString)){
            return;
        }        
        int edadInt = Integer.parseInt(edadString);
        this.edad = edadInt;
        
        if(!util.validarNombre(nombre)){
            return;        
        }
        this.nombre = nombre;
                      
        if(!utilDireccion.esValidaDireccion(direccion) || !util.esValidoGuiaTuristico(this))
        {
            return;
        }        
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
        return edad;
    }

    /**
     * Setter de la edad del guía turístico.
     * @param edadString: edad del guía turístico.
     */
    public void setEdad(String edadString) {
        if(!util.esEntero(edadString) || !util.validarEdad(edadString)){
            return;
        }
        int edadInt = Integer.parseInt(edadString);
        this.edad = edadInt;
    }

    /**
     * sobreescribe el método mostrarResumen con formato personalizado
     * @return el texto descriptivo del guía turístico.
     */
    @Override
    public String mostrarResumen() {
        return 
               "Nombre    : " + nombre + "\n"+
               "Edad        : " + this.edad + "\n"+ 
                direccion.mostrarResumen();
    }

}
