package Model;
import Util.UtilDireccion;
import Exception.DireccionException;
/**
 * Clase para modelar una dirección
 * 
 */
public class Direccion {
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
    public Direccion(String calle, int numero, String comuna, String ciudad) throws DireccionException 
    {
        UtilDireccion util = new UtilDireccion();
        if(util.ValidarCalle(calle))
            this.calle = calle;
        
        if(util.ValidarNumeracion(numero))    
            this.numero = numero;
                        
        if(util.ValidarComuna(comuna))
            this.comuna = comuna;

        if(util.ValidarCiudad(ciudad))
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
 * @throws DireccionException si no es válida
 */
    public void setCalle(String calle) throws DireccionException{
        UtilDireccion util = new UtilDireccion();
        if(util.ValidarCalle(calle))
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
 * @throws DireccionException si no es válida
 */
    public void setNumero(int numero) throws DireccionException{
        UtilDireccion util = new UtilDireccion();
        if(util.ValidarNumeracion(numero))
        this.numero = numero;
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
 * @throws DireccionException si no es válida
 */
    public void setComuna(String comuna) throws DireccionException{
        UtilDireccion util = new UtilDireccion();
        if(util.ValidarComuna(comuna))
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
 * @throws DireccionException si no es válida
 */
    public void setCiudad(String ciudad) throws DireccionException{ 
        UtilDireccion util = new UtilDireccion();
        if(util.ValidarCiudad(ciudad))
            this.ciudad = ciudad;        
    }
    
    /**
     * sobreescribe el método toString con formato personalizado
     * @return el texto descriptivo de la dirección formateada.
     */
    @Override
    public String toString()
    {
            return "Dirección: " + this.calle + " " + this.numero +", " + this.comuna + ", " + this.ciudad;
    }
}

