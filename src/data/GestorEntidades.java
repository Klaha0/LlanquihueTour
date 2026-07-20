package data;

import java.util.ArrayList;
import model.Cliente;
import model.ExcursionCultural;
import model.GuiaTuristico;
import model.PaseoLacustre;
import model.Persistible;
import model.Persona;
import model.Reserva;
import model.RutaGastronomica;
import model.ServicioTuristico;

/**
 * Clase encargada de administrar la colección de entidades del sistema
 * (clientes, guías turísticos y servicios turísticos), permitiendo agregar,
 * mostrar, buscar, actualizar y eliminar las entidades, diferenciando el tipo
 * mediante instanceof.
 */
public class GestorEntidades {
    private GestorDatos gestorDatos = new GestorDatos();
    private final ArrayList<Persistible> entidades = gestorDatos.LeerArchivo();
    private final ArrayList<Reserva> reservas = gestorDatos.LeerReservas(entidades);


    public ArrayList<Persistible> CargarEntidades(){
        return entidades;
    }

    public ArrayList<Reserva> CargarReservas(){
        return reservas;
    }

    /**
     * Obtiene los clientes registrados en el sistema.
     * @return la lista de clientes.
     */
    public ArrayList<Cliente> obtenerClientes(){
        var clientes = new ArrayList<Cliente>();
        for(var entidad : entidades){
            if(entidad instanceof Cliente)
                clientes.add((Cliente) entidad);
        }
        return clientes;
    }

    /**
     * Obtiene los servicios turísticos registrados en el sistema.
     * @return la lista de servicios turísticos.
     */
    public ArrayList<ServicioTuristico> obtenerServicios(){
        var servicios = new ArrayList<ServicioTuristico>();
        for(var entidad : entidades){
            if(entidad instanceof ServicioTuristico)
                servicios.add((ServicioTuristico) entidad);
        }
        return servicios;
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
     * tipos de servicio turístico (PaseoLacustre, ExcursionCultural, RutaGastronomica).
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
     * @return el String con el listado completo de servicios y guías registrados.
     */
    public String mostrarTodo(){
        var resumen = new StringBuilder();
        resumen.append("\t     ┌────────────────────────────────────┐\n");
        resumen.append("\t     │ == Bienvenido a Llanquihue Tours ==  │\n");
        resumen.append("\t     └────────────────────────────────────┘\n\n");
        resumen.append(mostrarGuias());
        resumen.append(mostrarServicios());
        return resumen.toString();
    }    

    /**
     * Busca un cliente por su código de reserva.
     * @param codigoReserva: código de reserva a buscar.
     * @return el Cliente encontrado, o null si no existe ninguno con ese código.
     */
    public Persistible buscarXCodigoReserva(String codigoReserva) {
        for (var entidad : entidades) {
            if (entidad instanceof Cliente) {
                Cliente cliente = (Cliente) entidad;
                if (cliente.getCodigoReserva().equals(codigoReserva)) {
                    return cliente;
                }
            }
        }
        return null;
    }

    /**
     * Busca todas las entidades (personas o servicios turísticos) cuyo nombre
     * contenga el texto indicado, sin distinguir entre mayúsculas y minúsculas.
     * Permite búsquedas parciales (no es necesario el nombre completo).
     * @param nombre: texto a buscar dentro del nombre.
     * @return las entidades cuyo nombre contiene el texto (lista vacía si no hay coincidencias).
     */
    public ArrayList<Persistible> buscarTodosXNombre(String nombre) {
        String buscado = nombre.toLowerCase();
        var encontradas = new ArrayList<Persistible>();
        for (var entidad : entidades) {
            if (entidad instanceof Persona) {
                if (((Persona) entidad).getNombre().toLowerCase().contains(buscado)) {
                    encontradas.add(entidad);
                }
            }
            else if (entidad instanceof ServicioTuristico) {
                if (((ServicioTuristico) entidad).getNombre().toLowerCase().contains(buscado)) {
                    encontradas.add(entidad);
                }
            }
        }
        return encontradas;
    }

    /**
     * Busca una persona (cliente o guía) por su RUT, con coincidencia exacta.
     * @param rut: RUT a buscar, en el mismo formato que muestra el sistema.
     * @return la persona encontrada, o null si no existe ninguna con ese RUT.
     */
    public Persistible buscarXRut(String rut) {
        for (var entidad : entidades) {
            if (entidad instanceof Persona) {
                if (((Persona) entidad).getRut().toString().equals(rut)) {
                    return entidad;
                }
            }
        }
        return null;
    }

    /**
     * Obtiene la posición de una entidad dentro de la colección.
     * @param entidad: entidad a ubicar.
     * @return el índice de la entidad, o -1 si no se encuentra en la colección.
     */
    public int indiceDe(Persistible entidad) {
        return entidades.indexOf(entidad);
    }

    /**
     * Reemplaza la entidad ubicada en el índice indicado y reescribe el
     * archivo completo para reflejar el cambio sin dejar datos duplicados.
     * @param entidad: nueva entidad que reemplazará a la anterior.
     * @param indice: posición de la entidad a actualizar.
     */
    public void actualizar(Persistible entidad, int indice) {
        entidades.set(indice, entidad);
        gestorDatos.reescribirArchivo(entidades, reservas);
    }

    /**
     * Elimina la entidad ubicada en el índice indicado y reescribe el
     * archivo completo para reflejar el cambio.
     * @param indice: posición de la entidad a eliminar.
     */
    public void eliminar(int indice) {
        entidades.remove(indice);
        gestorDatos.reescribirArchivo(entidades, reservas);
    }

    // ==================== Gestión de Reservas ====================

    /**
     * Muestra el listado completo de reservas registradas.
     * @return el String con el listado de reservas.
     */
    public String mostrarReservas()
    {
        var resumen = new StringBuilder();
        resumen.append("\t     --== Listado de Reservas ==--\n\n");
        for(var reserva : reservas)
        {
            resumen.append(reserva.toString());
            resumen.append("────────────────────────────────────────\n");
        }
        resumen.append("\n");
        return resumen.toString();
    }

    /**
     * Agrega una reserva a la colección y la persiste en el archivo.
     * @param reserva: reserva a agregar.
     */
    public void agregarReserva(Reserva reserva)
    {
        this.reservas.add(reserva);
        reserva.persistir();
    }

    /**
     * Busca todas las reservas que tengan el código indicado. Como la reserva
     * usa el código del cliente, un mismo cliente puede tener varias reservas
     * con el mismo código, por lo que se devuelven todas.
     * @param codigoReserva: código a buscar.
     * @return las reservas coincidentes (lista vacía si no hay).
     */
    public ArrayList<Reserva> buscarReservasXCodigo(String codigoReserva)
    {
        var encontradas = new ArrayList<Reserva>();
        for(var reserva : reservas)
        {
            if(reserva.getCodigoReserva().equals(codigoReserva))
                encontradas.add(reserva);
        }
        return encontradas;
    }

    /**
     * Busca todas las reservas cuyo cliente tenga un nombre que contenga el texto indicado.
     * @param nombre: texto a buscar dentro del nombre del cliente.
     * @return las reservas coincidentes (lista vacía si no hay).
     */
    public ArrayList<Reserva> buscarReservasXNombreCliente(String nombre)
    {
        String buscado = nombre.toLowerCase();
        var encontradas = new ArrayList<Reserva>();
        for(var reserva : reservas)
        {
            if(reserva.getCliente().getNombre().toLowerCase().contains(buscado))
                encontradas.add(reserva);
        }
        return encontradas;
    }

    /**
     * Obtiene la posición de una reserva dentro de la colección.
     * @param reserva: reserva a ubicar.
     * @return el índice de la reserva, o -1 si no se encuentra.
     */
    public int indiceDeReserva(Reserva reserva)
    {
        return reservas.indexOf(reserva);
    }

    /**
     * Reemplaza la reserva ubicada en el índice indicado y reescribe el archivo completo.
     * @param reserva: nueva reserva que reemplazará a la anterior.
     * @param indice: posición de la reserva a actualizar.
     */
    public void actualizarReserva(Reserva reserva, int indice)
    {
        reservas.set(indice, reserva);
        gestorDatos.reescribirArchivo(entidades, reservas);
    }

    /**
     * Elimina la reserva ubicada en el índice indicado y reescribe el archivo completo.
     * @param indice: posición de la reserva a eliminar.
     */
    public void eliminarReserva(int indice)
    {
        reservas.remove(indice);
        gestorDatos.reescribirArchivo(entidades, reservas);
    }

    /**
     * Calcula la cantidad de integrantes ya reservados para un servicio.
     * @param servicio: servicio turístico a evaluar.
     * @param reservaExcluida: reserva a excluir del cálculo (por ejemplo al editar),
     *                         puede ser null para considerar todas.
     * @return la suma de integrantes de las reservas del servicio.
     */
    public int integrantesReservados(ServicioTuristico servicio, Reserva reservaExcluida)
    {
        int total = 0;
        for(var reserva : reservas)
        {
            if(reserva == reservaExcluida)
                continue;
            if(reserva.getServicio().getNombre().equals(servicio.getNombre()))
                total += reserva.getCantidadIntegrantes();
        }
        return total;
    }

    /**
     * Calcula los cupos disponibles de un servicio según su capacidad y las reservas existentes.
     * @param servicio: servicio turístico a evaluar.
     * @param reservaExcluida: reserva a excluir del cálculo (al editar), o null.
     * @return los cupos disponibles (capacidad menos integrantes ya reservados).
     */
    public int cuposDisponibles(ServicioTuristico servicio, Reserva reservaExcluida)
    {
        return servicio.getCapacidad() - integrantesReservados(servicio, reservaExcluida);
    }

    /**
     * Indica si se alcanzó el máximo de 40 números de reserva permitidos.
     * @return true si ya no se pueden agregar más reservas.
     */
    public boolean reservasLlenas()
    {
        return reservas.size() >= 40;
    }
}
