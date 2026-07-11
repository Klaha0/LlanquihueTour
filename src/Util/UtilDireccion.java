package Util;

import Model.Direccion;
import static java.util.Objects.isNull;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase para validar campos de Dirección
 * Validaciones de todos los campos 
 * Retornos boolean
 */
public class UtilDireccion extends JFrame{
    
    /**
     * Método ValidarCalle
     * @param calle: nombre de la calle de la dirección
     * @return true si el campo es válido
     */           
    public boolean ValidarCalle(String calle) 
    {
        if(isNull(calle))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar una calle válida","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(calle.trim().isBlank())
        {
            JOptionPane.showMessageDialog(this, "El campo calle no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    /**
     * Método ValidarComuna
     * @param comuna
     * @return 
     */
    public boolean ValidarComuna(String comuna) 
    {
        if(isNull(comuna))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar una comuna válida","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(comuna.trim().isBlank())
        {
            JOptionPane.showMessageDialog(this, "El campo comuna no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
   /**     
    * Método ValidarCiudad
    * @param ciudad
    * @return 
    */
    public boolean ValidarCiudad(String ciudad) 
    {
        if(isNull(ciudad))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar una ciudad válida","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(ciudad.trim().isBlank())
        {
            JOptionPane.showMessageDialog(this, "El campo ciudad no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;           
        }
        return true;
    }
    
    /**
     * Método ValidarNumeracion
     * @param numero
     * @return 
     */
    public boolean ValidarNumeracion(String numero) 
    {                  
        var numeracion = ParseNumeracionDireccion(numero);
        if (numeracion < 0)
        {
            JOptionPane.showMessageDialog(this, "La numeración debe ser mayor o igual que 0","Error",JOptionPane.ERROR_MESSAGE);                
            return false;
        }            
        return true;
    }
    
    /**
     * 
     * @param numeroString
     * @return 
     */
    private int ParseNumeracionDireccion (String numeroString)
    {
        int numero = 0;
        try
        {
            numero = Integer.parseInt(numeroString);  
            return numero;
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un número válido","Error",JOptionPane.ERROR_MESSAGE);            
        }      
        return numero;
    }
    
    public boolean EsEntero(String valor)
    {
        try
        {            
            var numero = Integer.parseInt(valor);            
        }        
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Debe ingresar una numeración mayor o igual que 0","Error",JOptionPane.ERROR_MESSAGE);                
            return false;
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

