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
import model.Reserva;
import model.Rut;
import model.RutaGastronomica;
import model.ServicioTuristico;


public class GestorDatos {
    private final String DATOS_LLANQUIHUE = "resources/DatosLlanquihueTours.txt";
    
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
                       if(entidad.length != 5)
                       {
                           JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE);
                           break;
                       }
                       String nombre = entidad[1];
                       String duracion = entidad[2];
                       String capacidad = entidad[3];
                       String lugarHistorico = entidad[4];
                       try
                       {
                           ExcursionCultural excursion = new ExcursionCultural(nombre, duracion, capacidad, lugarHistorico);
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
                        if(entidad.length != 5)
                       {
                           JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE);
                           break;
                       }
                       String nombre = entidad[1];
                       String duracion = entidad[2];
                       String capacidad = entidad[3];
                       String embarcacion = entidad[4];
                       try
                       {
                           PaseoLacustre paseo = new PaseoLacustre(nombre, duracion, capacidad, embarcacion);
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
                       if(entidad.length != 5)
                       {
                           JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE);
                           break;
                       }
                       String nombre = entidad[1];
                       String duracion = entidad[2];
                       String capacidad = entidad[3];
                       String paradas = entidad[4];
                       try
                       {
                           RutaGastronomica rutaGastronomica = new RutaGastronomica(nombre, duracion, capacidad, paradas);
                           entidades.add(rutaGastronomica);
                       }
                       catch(ServicioTuristicoException e)
                       {
                           JOptionPane.showMessageDialog(null, "Error al leer el archivo, registro incompleto.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE);                            
                           break;
                       }
                   }
                   break;

                   case "Reserva":
                   {
                       //Las reservas se cargan en una segunda pasada (LeerReservas),
                       //una vez que ya existen los clientes y servicios que referencian.
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
            
    /**
     * Segunda pasada de lectura: reconstruye las reservas resolviendo su cliente
     * (por RUT) y su servicio (por nombre) desde las entidades ya cargadas.
     * @param entidades: colección de entidades cargadas previamente (clientes y servicios).
     * @return la colección de reservas leídas desde el archivo.
     */
    public ArrayList<Reserva> LeerReservas(ArrayList<Persistible> entidades)
    {
        File archivo = new File(DATOS_LLANQUIHUE);
        var reservas = new ArrayList<Reserva>();

        if(!archivo.exists())
            return reservas;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo)))
        {
            String linea;
            while ((linea = br.readLine()) != null)
            {
                String[] entidad = linea.split(";");
                if(!entidad[0].equals("Reserva"))
                    continue;

                if(entidad.length != 5)
                {
                    JOptionPane.showMessageDialog(null, "Error al leer el archivo, reserva incompleta.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                String codigoReserva = entidad[1];
                String rutCliente = entidad[2];
                String nombreServicio = entidad[3];
                String cantidadIntegrantes = entidad[4];

                Cliente cliente = buscarClientePorRut(entidades, rutCliente);
                ServicioTuristico servicio = buscarServicioPorNombre(entidades, nombreServicio);

                if(cliente == null || servicio == null)
                {
                    JOptionPane.showMessageDialog(null, "Error al leer una reserva: no se encontró el cliente o servicio asociado.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                try
                {
                    Reserva reserva = new Reserva(codigoReserva, cliente, servicio, cantidadIntegrantes);
                    reservas.add(reserva);
                }
                catch(RuntimeException e)
                {
                    JOptionPane.showMessageDialog(null, "Error al leer una reserva.\n Se ignora línea y se continúa con la siguiente","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error inesperado al leer las reservas","Error",JOptionPane.ERROR_MESSAGE);
        }
        return reservas;
    }

    /**
     * Busca un cliente por su RUT dentro de una colección de entidades.
     * @param entidades: colección donde buscar.
     * @param rut: RUT del cliente (en el mismo formato que muestra el sistema).
     * @return el Cliente encontrado, o null si no existe.
     */
    private Cliente buscarClientePorRut(ArrayList<Persistible> entidades, String rut)
    {
        for(Persistible entidad : entidades)
        {
            if(entidad instanceof Cliente)
            {
                Cliente cliente = (Cliente) entidad;
                if(cliente.getRut().toString().equals(rut))
                    return cliente;
            }
        }
        return null;
    }

    /**
     * Busca un servicio turístico por su nombre dentro de una colección de entidades.
     * @param entidades: colección donde buscar.
     * @param nombre: nombre exacto del servicio.
     * @return el ServicioTuristico encontrado, o null si no existe.
     */
    private ServicioTuristico buscarServicioPorNombre(ArrayList<Persistible> entidades, String nombre)
    {
        for(Persistible entidad : entidades)
        {
            if(entidad instanceof ServicioTuristico)
            {
                ServicioTuristico servicio = (ServicioTuristico) entidad;
                if(servicio.getNombre().equals(nombre))
                    return servicio;
            }
        }
        return null;
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

    /**
     * Reescribe por completo el archivo a partir de la colección en memoria.
     * Primero vacía el archivo abriéndolo en modo sobrescritura (append = false)
     * y luego vuelve a persistir cada entidad, de modo que las actualizaciones y
     * eliminaciones queden reflejadas sin dejar líneas duplicadas u obsoletas.
     * @param entidades: colección actual de entidades a volcar al archivo.
     */
    public void reescribirArchivo(ArrayList<Persistible> entidades, ArrayList<Reserva> reservas)
    {
        File archivo = new File(DATOS_LLANQUIHUE);

        //Se abre en modo append = false para dejar el archivo vacío
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false)))
        {
            bw.write("");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al guardar datos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //Se vuelve a persistir cada entidad (persistirEntidad usa append = true)
        for(Persistible entidad : entidades)
        {
            entidad.persistir();
        }

        //Las reservas se escriben al final, tras clientes y servicios que referencian
        for(Reserva reserva : reservas)
        {
            reserva.persistir();
        }
    }

}
