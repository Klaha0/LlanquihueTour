package Util;

import Model.ExcursionCultural;
import Model.PaseoLacustre;
import Model.RutaGastronomica;
import Model.ServicioTuristico;
import static java.util.Objects.isNull;
import javax.swing.JOptionPane;



public class UtilServicioTuristico extends javax.swing.JFrame 
{
    
    public boolean ValidarServicio(ServicioTuristico servicio){
        if(servicio instanceof PaseoLacustre){
            return ValidarPaseoLacustre((PaseoLacustre)servicio);
        }
        else if(servicio instanceof ExcursionCultural){
            return ValidarExcursionCultural((ExcursionCultural)servicio);
        }
        else{
            return ValidarRutaGastronomica((RutaGastronomica)servicio);            
        }
    }
    
    private boolean ValidarPaseoLacustre(PaseoLacustre paseoLacustre)
    {
        if(isNull(paseoLacustre.getNombre()))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre válido","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(paseoLacustre.getNombre().trim().isBlank())
        {
            JOptionPane.showMessageDialog(this, "El campo nombre no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;           
        }       
        if (paseoLacustre.getDuracionHoras() < 0)
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un tiempo mayor que 0","Error",JOptionPane.ERROR_MESSAGE);                
            return false;
        }      
         if(isNull(paseoLacustre.getTipoEmbarcacion()))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un tipo de embarcación válido","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(paseoLacustre.getTipoEmbarcacion().trim().isBlank())
        {
            JOptionPane.showMessageDialog(this, "El tipo de embarcación no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;           
        }
        return true;
    }
    
    
    
    private boolean ValidarExcursionCultural(ExcursionCultural excursionCultural)
    {
        if(isNull(excursionCultural.getNombre()))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre válido","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(excursionCultural.getNombre().trim().isBlank())
        {
            JOptionPane.showMessageDialog(this, "El campo nombre no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;           
        }       
        if (excursionCultural.getDuracionHoras() < 0)
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un tiempo mayor que 0","Error",JOptionPane.ERROR_MESSAGE);                
            return false;
        }
        if(isNull(excursionCultural.getLugarHistorico()))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un lugar válido","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(excursionCultural.getLugarHistorico().trim().isBlank())
        {
            JOptionPane.showMessageDialog(this, "El campo lugar no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;           
        } 
        return true;
    }
    
    private boolean ValidarRutaGastronomica(RutaGastronomica rutaGastronomica)
    {
        if(isNull(rutaGastronomica.getNombre()))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre válido","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(rutaGastronomica.getNombre().trim().isBlank())
        {
            JOptionPane.showMessageDialog(this, "El campo nombre no puede estar en blanco","Error",JOptionPane.ERROR_MESSAGE);
            return false;           
        }       
        if (rutaGastronomica.getDuracionHoras() < 0)
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un tiempo mayor que 0","Error",JOptionPane.ERROR_MESSAGE);                
            return false;
        }
        if (rutaGastronomica.getNumeroDeParadas()< 0)
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un número de paradas mayor que 0","Error",JOptionPane.ERROR_MESSAGE);                
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
            JOptionPane.showMessageDialog(this, "Debe ingresar un número entero mayor que 0","Error",JOptionPane.ERROR_MESSAGE);                
            return false;
        }
        return true;
    }
    
    public boolean EsDouble(String valor)
    {
        try
        {            
            var numero = Double.parseDouble(valor);            
        }        
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "La duración debe ser número decimal y mayor que 0","Error",JOptionPane.ERROR_MESSAGE);                
            return false;
        }
        return true;
    }
}
