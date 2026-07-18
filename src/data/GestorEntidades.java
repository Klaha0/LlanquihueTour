package data;

import java.util.ArrayList;
import model.Cliente;
import model.ExcursionCultural;
import model.GuiaTuristico;
import model.PaseoLacustre;
import model.Persistible;
import model.RutaGastronomica;

/**
 * Clase encargada de administrar la colección polimórfica de entidades del sistema
 * (guías turísticos y servicios turísticos), permitiendo agregarlas y mostrarlas
 * diferenciando su tipo real mediante instanceof.
 */
public class GestorEntidades {
    private GestorDatos gestorDatos = new GestorDatos();
    private final ArrayList<Persistible> entidades = gestorDatos.LeerArchivo();


    public ArrayList<Persistible> CargarEntidades(){
        return entidades;
    }
    /**
     * Agrega una entidad a la colección.
     * @param entidad: entidad que implementa Registrable a agregar.
     */
    public void agregar(Persistible entidad) {
        this.entidades.add(entidad);
        entidad.persistir();
    }

    /**
     * Recorre la colección de Registrable para armar un String con la ayuda de StringBuilder
     * identificando los guías apoyado por instanceof
     * @return el String con el listado de guías turísticos registrados.
     */
    public String mostrarGuias()
    {
        var resumen = new StringBuilder();
        resumen.append("\t     --== Listado de Guías ==--\n\n");
        for(var entidad : entidades)
        {
            if(entidad instanceof GuiaTuristico)
            {
                resumen.append(entidad.toString());
                resumen.append("────────────────────────────────────────\n");
            }
        }
        resumen.append("\n");
        return resumen.toString();
    }

    
    public String mostrarClientes()
    {
        var resumen = new StringBuilder();
        resumen.append("\t     --== Listado de Clientes ==--\n\n");
        for(var entidad : entidades)
        {
            if(entidad instanceof Cliente)
            {
                resumen.append(entidad.toString());
                resumen.append("────────────────────────────────────────\n");
            }
        }
        resumen.append("\n");
        return resumen.toString();
    }
    /**
     * Recorre la colección e identifica, mediante instanceof, los distintos
tipos de servicio turístico (PaseoLacustre, ExcursionCultural, RutaGastronomica).
     * @return el String con el listado de servicios turísticos registrados.
     */
    public String mostrarServicios(){
        var resumen = new StringBuilder();
        resumen.append("\t     --== Listado de Servicios ==--\n\n");
        for(var entidad : entidades)
        {
            if(entidad instanceof PaseoLacustre){
                resumen.append(entidad.toString());
                resumen.append("────────────────────────────────────────\n");
            }
            else if(entidad instanceof ExcursionCultural){
                resumen.append(entidad.toString());
                resumen.append("────────────────────────────────────────\n");
            }
            else if(entidad instanceof RutaGastronomica){
                resumen.append(entidad.toString());
                resumen.append("────────────────────────────────────────\n");
            }
        }
        resumen.append("\n");
        return resumen.toString();
    }

    /**
     * Muestra el listado completo de guías y servicios registrados.
     * @return el String con el listado completo de entidades registradas.
     */
    public String mostrarTodo(){
        var resumen = new StringBuilder();
        resumen.append("\t     ┌────────────────────────────────────┐\n");
        resumen.append("\t     │ == Bienvenido a Llanquihue Tours ==  │\n");
        resumen.append("\t     └────────────────────────────────────┘\n\n");
        resumen.append(mostrarGuias());
        resumen.append(mostrarServicios());
        resumen.append(mostrarClientes());
        return resumen.toString();
    }    

    public String buscarXCodigoReserva(String codigoReserva) {
        for (var entidad : entidades) {
            if (entidad instanceof Cliente) {
                Cliente cliente = (Cliente) entidad;
                if (cliente.getCodigoReserva().equals(codigoReserva)) {
                    return cliente.toString();
                }
            }
        }
        return "No se encontró ningún cliente con el código de reserva proporcionado.";
    }

    public String buscarXNombre(String nombre) {
        for (var entidad : entidades) {
            if (entidad instanceof Cliente) {
                Cliente cliente = (Cliente) entidad;
                if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                    return "Cliente encontrado\n: " + cliente.toString();
                }
            }
        }
        return "No se encontró ningún cliente con el nombre proporcionado.";
    }

    public void actualizar(Persistible entidad, int indice) {
        entidades.set(indice, entidad);
        entidad.persistir();
    }
}
