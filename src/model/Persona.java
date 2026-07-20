package model;

import exception.DireccionException;
import exception.PersonaException;
import exception.RutInvalidoException;
import util.UtilDireccion;
import util.UtilPersona;
import util.UtilRut;

/**
 * Clase base que representa una persona del sistema con sus datos personales.
 * Cada persona tiene un nombre, una edad, un RUT y una dirección asociada, y
 * sirve de superclase para Cliente y GuiaTuristico.
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
     * Crea una persona validando sus datos antes de asignarlos.
     * @param nombre: nombre de la persona.
     * @param edadString: edad de la persona.
     * @param direccion: dirección de la persona.
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
     * Getter del nombre de la persona.
     * @return el nombre de la persona.
     */
    public String getNombre() {

        return nombre;
    }

    /**
     * Setter del nombre de la persona.
     * @param nombre: nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter de la dirección de la persona.
     * @return la dirección de la persona.
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * Setter de la dirección de la persona.
     * @param direccion: dirección de la persona.
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Getter de la edad de la persona.
     * @return la edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Setter de la edad de la persona.
     * @param edadString: edad de la persona.
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
     * @return el texto descriptivo de la persona.
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
