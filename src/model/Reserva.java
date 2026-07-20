package model;

import data.GestorDatos;
import exception.ReservaException;
import static java.util.Objects.isNull;
import util.UtilReserva;

/**
 * Entidad que representa una reserva, asociando un Cliente con un ServicioTuristico.
 * Cada reserva tiene un código de reserva propio (generado con GeneradorCodigos) y
 * una cantidad de integrantes que descuenta cupos de la capacidad del servicio.
 */
public class Reserva implements Persistible{
    private UtilReserva util = new UtilReserva();
    private GestorDatos gestor = new GestorDatos();
    private String codigoReserva;
    private Cliente cliente;
    private ServicioTuristico servicio;
    private int cantidadIntegrantes;

    /**
     * Crea una reserva validando sus datos antes de asignarlos.
     * @param codigoReserva: código propio de la reserva (8 caracteres).
     * @param cliente: cliente que realiza la reserva.
     * @param servicio: servicio turístico reservado.
     * @param cantidadIntegrantes: cantidad de personas que lleva la reserva (1 a 40).
     */
    public Reserva(String codigoReserva, Cliente cliente, ServicioTuristico servicio, String cantidadIntegrantes) {
        if(isNull(cliente)){
            throw new ReservaException("La reserva debe tener un cliente asociado");
        }
        if(isNull(servicio)){
            throw new ReservaException("La reserva debe tener un servicio asociado");
        }
        if(!util.validarCodigo(codigoReserva)){
            throw new ReservaException("El código de reserva no es válido");
        }
        if(!util.esEntero(cantidadIntegrantes) || !util.validarCantidadIntegrantes(cantidadIntegrantes)){
            throw new ReservaException("La cantidad de integrantes no es válida");
        }
        this.codigoReserva = codigoReserva;
        this.cliente = cliente;
        this.servicio = servicio;
        this.cantidadIntegrantes = Integer.parseInt(cantidadIntegrantes);
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        if(util.validarCodigo(codigoReserva))
            this.codigoReserva = codigoReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if(!isNull(cliente))
            this.cliente = cliente;
    }

    public ServicioTuristico getServicio() {
        return servicio;
    }

    public void setServicio(ServicioTuristico servicio) {
        if(!isNull(servicio))
            this.servicio = servicio;
    }

    public int getCantidadIntegrantes() {
        return cantidadIntegrantes;
    }

    public void setCantidadIntegrantes(String cantidadIntegrantes) {
        if(util.esEntero(cantidadIntegrantes) && util.validarCantidadIntegrantes(cantidadIntegrantes))
            this.cantidadIntegrantes = Integer.parseInt(cantidadIntegrantes);
    }

    @Override
    public String toString() {
        return "Cód. Reserva\t: " + this.codigoReserva + "\n" +
               "Cliente\t\t: " + this.cliente.getNombre() + " (" + this.cliente.getRut().toString() + ")\n" +
               "Servicio\t\t: " + this.servicio.getNombre() + "\n" +
               "Integrantes\t: " + this.cantidadIntegrantes + "\n";
    }

    @Override
    public void persistir() {
        String persistirReserva =
                "Reserva;" +
                this.codigoReserva + ";" +
                this.cliente.getRut().toString() + ";" +
                this.servicio.getNombre() + ";" +
                this.cantidadIntegrantes;
        gestor.persistirEntidad(persistirReserva);
    }
}
