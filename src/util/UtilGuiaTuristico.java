package util;

import model.GuiaTuristico;
import static java.util.Objects.isNull;
import javax.swing.JOptionPane;

/**
 * Clase para validar campos de GuiaTuristico.
 * Todas las validaciones retornan boolean y muestran un mensaje de error al usuario
 * mediante JOptionPane cuando el dato ingresado no es válido.
 */
public class UtilGuiaTuristico {

    /**
     * Valida que el nombre no sea nulo ni esté en blanco.
     * @param nombre: nombre del guía turístico.
     * @return true si el campo es válido.
     */
    public boolean validarNombre(String nombre)
    {
        if(isNull(nombre))
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre válido","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(nombre.trim().isBlank())
        {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Convierte la edad a entero.
     * @param edadString: edad del guía turístico, como String.
     * @return la edad convertida a entero.
     */
    private int parseEdad(String edadString)
    {
        int edad = 0;
        try
        {
            edad = Integer.parseInt(edadString);
            return edad;
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar una edad válida","Error",JOptionPane.ERROR_MESSAGE);
        }
        return edad;
    }

    /**
     * Valida que la edad sea mayor o igual que 0 y que el guía sea mayor de edad (18+).
     * @param edadString: edad del guía turístico, como String.
     * @return true si la edad es válida.
     */
    public boolean validarEdad(String edadString)
    {
        var edad =parseEdad(edadString);
        if(edad < 0)
            {
                JOptionPane.showMessageDialog(null, "Debe ingresar una edad mayor que 0","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
            else if(edad < 18)
            {
                JOptionPane.showMessageDialog(null, "Debe ser mayor de edad para trabajar \n +18","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        return true;
    }

    /**
     * Valida que el valor ingresado corresponda a un número entero.
     * @param valor: valor a validar.
     * @return true si el valor es un número entero válido.
     */
    public boolean esEntero(String valor)
    {
        try
        {
            Integer.parseInt(valor);
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debe ingresar una edad mayor que 0","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Validamos que el guía turístico no sea nulo.
     * @param guia: un objeto de la clase GuiaTuristico.
     * @return false si es nulo el guía turístico.
     */
    public boolean esValidoGuiaTuristico(GuiaTuristico guia){
            return !isNull(guia);
    }
}
