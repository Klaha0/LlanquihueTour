package Util;

import Model.GuiaTuristico;
import static java.util.Objects.isNull;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Clase para validar campos de GuiaTuristico
 * Validaciones de todos los campos
 * Retornos boolean
 */
public class UtilGuiaTuristico extends JFrame{

    /**
     * Método ValidarNombre
     * @param nombre
     * @return 
     */
    public boolean ValidarNombre(String nombre)
    {
        if(isNull(nombre))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre válido","Error",JOptionPane.ERROR_MESSAGE);
            return false;          
        }
        if(nombre.trim().isBlank())
        {
            JOptionPane.showMessageDialog(this, "El campo nombre no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;        
        }
        return true;
    }
    
    /**
     * Método ValidarYParseEdad
     * @param edadString
     * @return int edad
     */ 
    private int ParseEdad(String edadString)
    {
        int edad = 0;
        try
        {
            edad = Integer.parseInt(edadString);  
            return edad;
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar una edad válida","Error",JOptionPane.ERROR_MESSAGE);            
        }      
        return edad;
    }
    
    /**
     * 
     * @param edad
     * @return 
     */
    public boolean ValidarEdad(String edadString)
    {
        var edad =ParseEdad(edadString);
        if(edad < 0)
            {
                JOptionPane.showMessageDialog(this, "Debe ingresar una edad mayor que 0","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            else if(edad < 18)
            {
                JOptionPane.showMessageDialog(this, "Debe ser mayor de edad para trabajar \n +18","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        return true;
    }
    
    public boolean EsEntero(String valor)
    {
        try
        {            
            var numero = Integer.parseInt(valor);            
        }        
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Debe ingresar una edad mayor que 0","Error",JOptionPane.ERROR_MESSAGE);                
            return false;
        }
        return true;
    }
   
    /**
     * Validamos que el GuiaTuristico no sea nulo
     * @param GuiaTuristico: un objeto de la clase GuiaTuristico
     * @return False si es nulo el GuiaTuristico
     */
    public boolean esValidoGuiaTuristico(GuiaTuristico guia){        
            return isNull(guia) ? false : true;                
    }
}
