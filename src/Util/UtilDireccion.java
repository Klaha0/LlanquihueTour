package Util;

import Exception.DireccionException;
import Model.Direccion;
import static java.util.Objects.isNull;

/**
 * Clase para validar campos de Dirección
 * Validaciones de todos los campos 
 * Retornos boolean
 */
public class UtilDireccion {
    
    /**
     * Método ValidarCalle
     * @param calle: nombre de la calle de la dirección
     * @return true si el campo es válido
     * @throws DireccionException si el campo no es válido
     */           
    public boolean ValidarCalle(String calle) throws DireccionException{
        if(isNull(calle))
        {
            throw new DireccionException("El campo calle no debe ser nulo");            
        }
        if(calle.trim().isBlank())
        {
            throw new DireccionException("El campo calle no estar en blanco");            
        }
        return true;
    }
    
    /**
     * Método ValidarComuna
     * @param Comuna: nombre de la comuna de la dirección
     * @return true si el campo es válido
     * @throws DireccionException si el campo no es válido
     */ 
    public boolean ValidarComuna(String comuna) throws DireccionException{
        if(isNull(comuna))
        {
            throw new DireccionException("El campo comuna no debe ser nulo");            
        }
        if(comuna.trim().isBlank())
        {
            throw new DireccionException("El campo comuna no debe estar en blanco");            
        }
        return true;
    }
    
    /**
     * Método ValidarCiudad
     * @param Ciudad: nombre de la ciudad de la dirección
     * @return true si el campo es válido
     * @throws DireccionException si el campo no es válido
     */ 
    public boolean ValidarCiudad(String ciudad) throws DireccionException{
        if(isNull(ciudad))
        {
            throw new DireccionException("El campo ciudad no debe ser nulo");            
        }
        if(ciudad.trim().isBlank())
        {
            throw new DireccionException("El campo ciudad no debe estar en blanco");            
        }
        return true;
    }
    
    /**
     * Método ValidarNumeracion
     * @param Numeracion: numeración de la comuna de la dirección.
     * @return true si el campo es válido
     * @throws DireccionException si el campo no es válido.
     */ 
    public boolean ValidarNumeracion(int numeracion) throws DireccionException{
        if(numeracion < 0)
        {
            throw new DireccionException("La numeracion debe ser mayor o igual a 0");
        }
        return true;
    }
    /**
     * Validamos que la direccion no sea nula
     * @param Direccion: un objeto de la clase Direccion
     * @return False si es nula la direccion 
     */
    public boolean esValidaDireccion(Direccion direccion){        
            return isNull(direccion) ? false : true;                
    }
}

