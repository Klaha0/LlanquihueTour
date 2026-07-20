package util;

import exception.ReservaException;
import static java.util.Objects.isNull;
import javax.swing.JOptionPane;

/**
 * Clase para validar los campos de una Reserva (código de reserva y cantidad de
 * integrantes). Sigue el mismo estilo del resto de validadores: retornan boolean
 * y muestran un mensaje de error al usuario mediante JOptionPane cuando el dato
 * ingresado no es válido.
 */
public class UtilReserva {

    /**
     * Valida el código de reserva: no nulo, no en blanco y de largo 8.
     * @param codigoReserva: código de reserva a validar.
     * @return true si el código es válido.
     */
    public boolean validarCodigo(String codigoReserva)
    {
        try
        {
            if(isNull(codigoReserva) || codigoReserva.trim().isBlank() || codigoReserva.length() != 8)
            {
                throw new ReservaException("Debe ingresar un código de reserva válido");
            }
        }
        catch(ReservaException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "La cantidad de integrantes debe ser un número entero","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Valida que la cantidad de integrantes sea un entero entre 1 y 40.
     * @param cantidadIntegrantes: cantidad de integrantes a validar.
     * @return true si la cantidad está en el rango permitido.
     */
    public boolean validarCantidadIntegrantes(String cantidadIntegrantes)
    {
        try
        {
            int cantidad = Integer.parseInt(cantidadIntegrantes);
            if(cantidad < 1 || cantidad > 40)
            {
                throw new ReservaException("La cantidad de integrantes debe estar entre 1 y 40");
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad de integrantes válida","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        catch(ReservaException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
