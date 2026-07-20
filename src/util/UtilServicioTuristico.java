package util;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;
import static java.util.Objects.isNull;
import javax.swing.JOptionPane;

/**
 * Clase para validar campos de ServicioTuristico y sus subclases
 * (PaseoLacustre, ExcursionCultural, RutaGastronomica).
 * Todas las validaciones retornan boolean y muestran un mensaje de error al usuario
 * mediante JOptionPane cuando el dato ingresado no es válido.
 */
public class UtilServicioTuristico
{

    /**
     * Valida un servicio turístico delegando en la validación específica
según su tipo real (PaseoLacustre, ExcursionCultural o RutaGastronomica).
     * @param servicio: servicio turístico a validar.
     * @return true si el servicio es válido.
     */
    public boolean validarServicio(ServicioTuristico servicio){
        if(servicio instanceof PaseoLacustre){
            return validarPaseoLacustre((PaseoLacustre)servicio);
        }
        else if(servicio instanceof ExcursionCultural){
            return validarExcursionCultural((ExcursionCultural)servicio);
        }
        else{
            return validarRutaGastronomica((RutaGastronomica)servicio);
        }
    }

    /**
     * Valida los campos propios de un paseo lacustre.
     * @param paseoLacustre: paseo lacustre a validar.
     * @return true si el paseo lacustre es válido.
     */
    private boolean validarPaseoLacustre(PaseoLacustre paseoLacustre)
    {
        if(isNull(paseoLacustre.getNombre()))
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre válido","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(paseoLacustre.getNombre().trim().isBlank())
        {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (paseoLacustre.getDuracionHoras() < 0)
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un tiempo mayor que 0","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (paseoLacustre.getCapacidad() < 1 || paseoLacustre.getCapacidad() > 40)
        {
            JOptionPane.showMessageDialog(null, "La capacidad debe estar entre 1 y 40 personas","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
         if(isNull(paseoLacustre.getTipoEmbarcacion()))
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un tipo de embarcación válido","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(paseoLacustre.getTipoEmbarcacion().trim().isBlank())
        {
            JOptionPane.showMessageDialog(null, "El tipo de embarcación no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Valida los campos propios de una excursión cultural.
     * @param excursionCultural: excursión cultural a validar.
     * @return true si la excursión cultural es válida.
     */
    private boolean validarExcursionCultural(ExcursionCultural excursionCultural)
    {
        if(isNull(excursionCultural.getNombre()))
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre válido","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(excursionCultural.getNombre().trim().isBlank())
        {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (excursionCultural.getDuracionHoras() < 0)
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un tiempo mayor que 0","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (excursionCultural.getCapacidad() < 1 || excursionCultural.getCapacidad() > 40)
        {
            JOptionPane.showMessageDialog(null, "La capacidad debe estar entre 1 y 40 personas","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(isNull(excursionCultural.getLugarHistorico()))
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un lugar válido","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(excursionCultural.getLugarHistorico().trim().isBlank())
        {
            JOptionPane.showMessageDialog(null, "El campo lugar no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Valida los campos propios de una ruta gastronómica.
     * @param rutaGastronomica: ruta gastronómica a validar.
     * @return true si la ruta gastronómica es válida.
     */
    private boolean validarRutaGastronomica(RutaGastronomica rutaGastronomica)
    {
        if(isNull(rutaGastronomica.getNombre()))
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre válido","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(rutaGastronomica.getNombre().trim().isBlank())
        {
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (rutaGastronomica.getDuracionHoras() < 0)
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un tiempo mayor que 0","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (rutaGastronomica.getCapacidad() < 1 || rutaGastronomica.getCapacidad() > 40)
        {
            JOptionPane.showMessageDialog(null, "La capacidad debe estar entre 1 y 40 personas","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (rutaGastronomica.getNumeroDeParadas()< 0)
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número de paradas mayor que 0","Error",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Debe ingresar un número entero mayor que 0","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Valida que el valor ingresado corresponda a un número decimal.
     * @param valor: valor a validar.
     * @return true si el valor es un número decimal válido.
     */
    public boolean esDouble(String valor)
    {
        try
        {
            Double.parseDouble(valor);
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "La duración debe ser número decimal y mayor que 0","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * Valida que la capacidad ingresada sea un entero entre 1 y 40 personas.
     * @param capacidad: capacidad a validar.
     * @return true si la capacidad está en el rango permitido.
     */
    public boolean validarCapacidad(String capacidad)
    {
        try
        {
            int cap = Integer.parseInt(capacidad);
            if(cap < 1 || cap > 40)
            {
                JOptionPane.showMessageDialog(null, "La capacidad debe estar entre 1 y 40 personas","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Debe ingresar una capacidad válida (1 a 40)","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
