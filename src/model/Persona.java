package model;

import exception.DireccionException;
import exception.PersonaException;
import exception.RutInvalidoException;
import util.UtilDireccion;
import util.UtilPersona;
import util.UtilRut;

/**
 * Clase que representa un guía turístico con sus datos personales y dirección.
 * Cada guía tiene un nombre, una edad y una dirección asociada.
 */
public class Persona implements Persistible{
    private UtilPersona util = new UtilPersona();
    private UtilDireccion utilDireccion = new UtilDireccion();
    private UtilRut utilRut = new UtilRut();
    private String nombre;
    private int edad;
    private Direccion direccion;
    private Rut rut;

    /**
     * Crea un guía turístico validando sus datos antes de asignarlos.
     * @param nombre: nombre del guía turístico.
     * @param edadString: edad del guía turístico.
     * @param direccion: dirección del guía turístico.
     * @param rut: rut de la persona
     */
    public Persona(String nombre, String edadString, Direccion direccion, Rut rut)
    {
        if(!util.esEntero(edadString) || !util.validarEdad(edadString)){
            throw new PersonaException("La edad ingresada no es válida");
        }
        int edadInt = Integer.parseInt(edadString);
        this.edad = edadInt;

        if(!util.validarNombre(nombre)){
            throw new PersonaException("El nombre ingresado no es válido");
        }
        this.nombre = nombre;

        if(!utilDireccion.esValidaDireccion(direccion)){
            throw new DireccionException("Debe ingresar una dirección válida");
        }
        if(!util.esValidaPersona(this) || !utilRut.validarRut(rut))
        {
            throw new RutInvalidoException("El Rut ingresado no es válido");
        }
        this.rut = rut;
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

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        if(utilRut.validarRut(rut))
            this.rut = rut;
    }

    /**
     * sobreescribe el método toString con formato personalizado
     * @return el texto descriptivo del guía turístico.
     */
    @Override
    public String toString() {
        return 
               "Nombre    : " + nombre + "\n"+
               "Edad        : " + this.edad + "\n"+ 
                direccion.toString();
    }

    @Override
    public void persistir() {
        //Método que deberán implementar las sub-clases para guardar 
        //en archivo
    }

}
