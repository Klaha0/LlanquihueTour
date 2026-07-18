package util;

import exception.ReservaException;
import static java.util.Objects.isNull;
import javax.swing.JOptionPane;


public class UtilCliente extends UtilPersona{
    public boolean validarCodigo(String codigoReserva)
    {
        try
        {
            if(isNull(codigoReserva) || codigoReserva.trim().isBlank() || codigoReserva.length() != 8)
            {
                throw new ReservaException("Debe ingresar una codigoReserva válida");
            }            
        }
        catch(ReservaException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
