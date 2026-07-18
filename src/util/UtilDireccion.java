package util;

import exception.DireccionException;
import static java.util.Objects.isNull;
import javax.swing.JOptionPane;
import model.Direccion;

/**
 * Clase para validar campos de Direccion.
 * Todas las validaciones retornan boolean y muestran un mensaje de error al usuario
 * mediante JOptionPane cuando el dato ingresado no es válido.
 */
public class UtilDireccion {

    /**
     * Valida que la calle no sea nula ni esté en blanco.
     * @param calle: nombre de la calle de la dirección.
     * @return true si el campo es válido.
     */
    public boolean validarCalle(String calle)
    {
        try
        {
            if(isNull(calle))
            {
                throw new DireccionException("Debe ingresar una calle válida");
            }
            if(calle.trim().isBlank())
            {
                throw new DireccionException("El campo calle no puede estar en blanco");
            }
        }
        catch(DireccionException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }        
        return true;
    }

    /**
     * Valida que la comuna no sea nula ni esté en blanco.
     * @param comuna: nombre de la comuna de la dirección.
     * @return true si el campo es válido.
     */
    public boolean validarComuna(String comuna)
    {
        try
        {
            if(isNull(comuna))
            {
                throw new DireccionException("Debe ingresar una comuna válida");
            }
            if(comuna.trim().isBlank())
            {
                throw new DireccionException("El campo comuna no puede estar en blanco");
            }
        }
        catch(DireccionException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }            

    /**
     * Valida que la ciudad no sea nula ni esté en blanco.
     * @param ciudad: nombre de la ciudad de la dirección.
     * @return true si el campo es válido.
     */
    public boolean validarCiudad(String ciudad)
    {
        try
        {
            if(isNull(ciudad))
            {
                throw new DireccionException("Debe ingresar una ciudad válida");
            }
            if(ciudad.trim().isBlank())
            {
                throw new DireccionException("El campo ciudad no puede estar en blanco");
            }
        }
        catch(DireccionException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }         
        return true;
    }

    /**
     * Valida que la numeración de la dirección sea mayor o igual que 0.
     * @param numero: numeración de la dirección, como String.
     * @return true si la numeración es válida.
     */
    public boolean validarNumeracion(String numero)
    {
        try
        {
            var numeracion = parseNumeracionDireccion(numero);
            if (numeracion < 0)
            {
                JOptionPane.showMessageDialog(null, "La numeración debe ser mayor o igual que 0","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar una numeración válida","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Convierte la numeración de la dirección a entero.
     * @param numeroString: numeración de la dirección, como String.
     * @return la numeración convertida a entero.
     */
    private int parseNumeracionDireccion (String numeroString)
    {
        int numero = 0;
        try
        {
            numero = Integer.parseInt(numeroString);
            return numero;
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido","Error",JOptionPane.ERROR_MESSAGE);
        }
        return numero;
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
            JOptionPane.showMessageDialog(null, "Debe ingresar una numeración mayor o igual que 0","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Validamos que la Direccion no sea nula.
     * @param direccion: un objeto de la clase Direccion.
     * @return false si es nula la Direccion.
     */
    public boolean esValidaDireccion(Direccion direccion){
            return !isNull(direccion);
    }
}
