package Util;
import Exception.GuiaTuristicoException;
import Model.GuiaTuristico;
import static java.util.Objects.isNull;

/**
 * Clase para validar campos de GuiaTuristico
 * Validaciones de todos los campos
 * Retornos boolean
 */
public class UtilGuiaTuristico{

    /**
     * Método ValidarNombre
     * @param nombre: nombre de la persona
     * @return true si el campo es válido
     * @throws GuiaTuristicoException si el campo no es válido
     */
    public boolean ValidarNombre(String nombre) throws GuiaTuristicoException{
        if(isNull(nombre))
        {
            throw new GuiaTuristicoException("El campo nombre no debe ser nulo");            
        }
        if(nombre.trim().isBlank())
        {
            throw new GuiaTuristicoException("El campo nombre no estar en blanco");            
        }
        return true;
    }
    
    /**
     * Método ValidarEdad
     * @param edad: Edad de la persona.
     * @return true si el campo es válido
     * @throws GuiaTuristicoException si el campo no es válido.
     */
    public boolean ValidarEdad(int edad) throws GuiaTuristicoException{        
        if(edad < 0)
        {
            throw new GuiaTuristicoException("La edad debe ser mayor o igual a 0");
        }
        else if(edad < 18){
            throw new GuiaTuristicoException("Para trabajar debe ser mayor de 18");
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
