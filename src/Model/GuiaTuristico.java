package Model;

import Util.UtilDireccion;
import Util.UtilGuiaTuristico;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase que representa un guía turístico con sus datos personales y dirección.
 * Cada guía tiene un nombre, una edad y una dirección asociada.
 */
public class GuiaTuristico extends JFrame implements Registrable{
    private UtilGuiaTuristico util = new UtilGuiaTuristico();
    private UtilDireccion utilDireccion = new UtilDireccion();
    private String nombre;
    private int Edad;
    private Direccion direccion;

    /**
     * Crea un guía turístico validando sus datos antes de asignarlos.
     * @param nombre: nombre del guía turístico.
     * @param edadString: edad del guía turístico.
     * @param direccion: dirección del guía turístico.
     */
    public GuiaTuristico(String nombre, String edadString, Direccion direccion)
    {
        if(!util.EsEntero(edadString) || !util.ValidarEdad(edadString)){
            return;
        }        
        int edad = Integer.parseInt(edadString);
        this.Edad = edad;
        
        if(!util.ValidarNombre(nombre)){
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
        return Edad;
    }

    /**
     * Setter de la edad del guía turístico.
     * @param Edad: edad del guía turístico.
     */
    public void setEdad(String edadString) {
        if(!util.EsEntero(edadString) || !util.ValidarEdad(edadString)){
            return;
        }
        int edad = Integer.parseInt(edadString);
        this.Edad = Edad;
    }

    /**
     * sobreescribe el método toString con formato personalizado
     * @return el texto descriptivo del guía turístico.
     */
    @Override
    public String toString() {
        return //"\t***Datos Guía Turístico***\n"+  DEBERIA ELIMINAR ESTO
               "Nombre: " + nombre + " Edad: " + Edad + "\n"+ 
                direccion.mostrarResumen();
    }
    
    @Override
    public String mostrarResumen() {
        return this.toString();
    }
}
