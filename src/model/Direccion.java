package model;

import exception.DireccionException;
import util.UtilDireccion;

/**
 * Clase para modelar una dirección
 * 
 */
public class Direccion{
private String calle;
private int numero;
private String comuna;
private String ciudad;

/**
 * Constructor con todos los parámetros
 * hace validación de datos antes de crear objeto
 * @param calle: nombre de la calle
 * @param numero: Numeración de la casa
 * @param comuna: Comuna a la que pertenece la casa
 * @param ciudad : Ciudad a la que pertenece la casa
 */
    public Direccion(String calle, String numero, String comuna, String ciudad)
    {
        UtilDireccion util = new UtilDireccion();
        if(!util.esEntero(numero) || !util.validarNumeracion(numero)){
            throw new DireccionException("La numeración ingresada no es válida");
        }
        int numeracion = Integer.parseInt(numero);
        this.numero = numeracion;

        if(!util.validarCalle(calle)){
            throw new DireccionException("La calle ingresada no es válida");
        }
            this.calle = calle;

        if(!util.validarComuna(comuna)){
            throw new DireccionException("La comuna ingresada no es válida");
        }
            this.comuna = comuna;

        if(!util.validarCiudad(ciudad)){
            throw new DireccionException("La ciudad ingresada no es válida");
        }
            this.ciudad = ciudad;
    }
    
/**
 * Getter de calle
 * @return el nombre de la calle de la dirección
 */
    public String getCalle() {
        return calle;
    }
/**
 * Setter de calle
 * se verifican que los datos sean correctos
 * @param calle nombre de la calle
 */
    public void setCalle(String calle){
        UtilDireccion util = new UtilDireccion();
        if(!util.validarCalle(calle)){
            return;
        }
        this.calle = calle;
    }

/**
 * Getter de numero
 * @return la numeración de la dirección
 */
    public int getNumero() {
        return numero;
    }
/**
 * Setter de numero
 * se verifican que los datos sean correctos
 * @param numero: numeración de la dirección
 */
    public void setNumero(String numero) {
        UtilDireccion util = new UtilDireccion();
        if(!util.esEntero(numero) || !util.validarNumeracion(numero)){
            return;
        }                
        int numeracion = Integer.parseInt(numero);
        this.numero = numeracion;
    }

/**
 * Getter de comuna
 * @return el nombre de la comuna de la dirección
 */
    public String getComuna() {
        return comuna;
    }
/**
 * Setter de comuna
 * se verifican que los datos sean correctos
 * @param comuna: nombre de la comuna
 */
    public void setComuna(String comuna) {
        UtilDireccion util = new UtilDireccion();
        if(!util.validarComuna(comuna)){
            return;
        }
        this.comuna = comuna;        
    }

/**
 * Getter de ciudad
 * @return el nombre de la ciudad de la dirección
 */
    public String getCiudad() {
        return ciudad;
    }
/**
 * Setter de ciudad
 * se verifican que los datos sean correctos
 * @param ciudad: nombre de la ciudad
 */
    public void setCiudad(String ciudad) { 
        UtilDireccion util = new UtilDireccion();
        if(!util.validarCiudad(ciudad)){
            return;
        }
            this.ciudad = ciudad;        
    }

    
    /**
     * sobreescribe el método toString con formato personalizado
     * @return el texto descriptivo de la dirección formateada.
     */
    @Override
    public String toString()
    {
            return "Dirección\t: " + this.calle + " " + this.numero + ", " + this.comuna + ", " + this.ciudad;
    }
    
    public String persistir(){
        String persistirDireccion = this.calle + ";" + this.numero + ";"+ this.comuna + ";" + this.ciudad;
        return persistirDireccion;
    }

}

