package data;

import exception.ServicioTuristicoException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Direccion;
import model.ExcursionCultural;
import model.GuiaTuristico;
import model.PaseoLacustre;
import model.Persistible;
import model.Rut;
import model.RutaGastronomica;


public class GestorDatos {
    private final String DATOS_LLANQUIHUE = "DatosLlanquihueTours.txt";
    
    public ArrayList<Persistible> LeerArchivo()  
    {
        File archivo = new File(DATOS_LLANQUIHUE);
        var entidades = new ArrayList<Persistible>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo)))
        {
            //SI EL ARCHIVO NO EXISTE SE CREA
            if (!archivo.exists()) 
            {
                archivo.createNewFile();
                JOptionPane.showMessageDialog(null, "No se encontró el archivo, se ha creado uno nuevo","Información",JOptionPane.INFORMATION_MESSAGE); 
                return entidades;                
            }               
                
            String linea;
            while ((linea = br.readLine()) != null) 
            {
               String[] entidad = linea.split(";");

               switch(entidad[0])
               {
                   case "Cliente":
                   {
                       if(entidad.length != 9)
                       {
                           JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE); 
                           break;
                       }
                        String nombre = entidad[1];
                        String edad = entidad[2];
                        String calle = entidad[3];
                        String numeracion = entidad[4];
                        String comuna = entidad[5];
                        String ciudad = entidad[6];
                        String rutString = entidad[7];
                        String codigoReserva = entidad[8];
                        try
                        {
                            Direccion direccion = new Direccion(calle, numeracion, comuna, ciudad);
                            Rut rut = new Rut(rutString);
                            Cliente cliente = new Cliente(nombre, edad, direccion, rut, codigoReserva);
                            entidades.add(cliente);
                        }
                        catch(RuntimeException e)
                        {
                            JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE); 
                            break;
                        }
                    }
                   break;
                   
                   case "GuiaTuristico":
                   {
                        if(entidad.length != 9)
                       {
                           JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE); 
                           break;
                       }
                        String nombre = entidad[1];
                        String edad = entidad[2];
                        String calle = entidad[3];
                        String numeracion = entidad[4];
                        String comuna = entidad[5];
                        String ciudad = entidad[6];
                        String rutString = entidad[7];
                        String especialidad = entidad[8];
                        try
                        {
                            Direccion direccion = new Direccion(calle, numeracion, comuna, ciudad);
                            Rut rut = new Rut(rutString);
                            GuiaTuristico guia = new GuiaTuristico(nombre, edad, direccion, rut, especialidad);
                            entidades.add(guia);
                        }
                        catch(RuntimeException e)
                        {
                            JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE); 
                            break;
                        }
                   }
                   break;
                   
                   case "ExcursionCultural":
                   {
                       if(entidad.length != 4)
                       {
                           JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE); 
                           break;
                       }
                       String nombre = entidad[1];
                       String duracion = entidad[2];
                       String lugarHistorico = entidad[3];
                       try
                       {
                           ExcursionCultural excursion = new ExcursionCultural(nombre, duracion, lugarHistorico);
                           entidades.add(excursion);
                       }
                       catch(ServicioTuristicoException e)
                       {
                           JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE); 
                           break;
                       }
                   }
                   break;
                   
                   case "PaseoLacustre":
                   {
                        if(entidad.length != 4)
                       {
                           JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE); 
                           break;
                       }
                       String nombre = entidad[1];
                       String duracion = entidad[2];
                       String embarcacion = entidad[3];
                       try
                       {
                           PaseoLacustre paseo = new PaseoLacustre(nombre, duracion, embarcacion);
                           entidades.add(paseo);
                       }
                       catch(ServicioTuristicoException e)
                       {
                           JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE); 
                           break;
                       }
                   }
                   break;
               
                   case "RutaGastronomica":
                   {
                       if(entidad.length != 4)
                       {
                           JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE); 
                           break;
                       }
                       String nombre = entidad[1];
                       String duracion = entidad[2];
                       String paradas = entidad[3];
                       try
                       {
                           RutaGastronomica rutaGastronomica = new RutaGastronomica(nombre, duracion, paradas);
                           entidades.add(rutaGastronomica);
                       }
                       catch(ServicioTuristicoException e)
                       {
                           JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE);                            
                           break;
                       }
                   }
                   break;
                   
                   default:
                   {
                       JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE); 
                   }
               }            
            } 
            br.close();
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error inesperado al leer el archivo","Error",JOptionPane.ERROR_MESSAGE);                
        }           
        return entidades;
    }                    
            
    public void persistirEntidad(String entidad)
    {
        File archivo = new File(DATOS_LLANQUIHUE);
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true)))
        {                            
            bw.write(entidad);
            bw.newLine();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al guardar datos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }        
    }
        
}
