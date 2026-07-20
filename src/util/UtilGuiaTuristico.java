package util;

import exception.PersonaException;
import static java.util.Objects.isNull;
import javax.swing.JOptionPane;


public class UtilGuiaTuristico extends UtilPersona{
    public boolean validarEspecialidad(String especialidad)
    {
        try{
            if(isNull(especialidad))
            {
                throw new PersonaException("Debe ingresar una especialidad válida");
            }
            if(especialidad.trim().isBlank())
            {
                throw new PersonaException("El campo especialidad no puede estar en blanco");
            }
        }
        catch(PersonaException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }        
        return true;
    }
}
