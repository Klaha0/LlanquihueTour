package model;

import data.GestorDatos;
import service.GeneradorCodigos;
import util.UtilCliente;

public class Cliente extends Persona{
    private GeneradorCodigos generador = new GeneradorCodigos();
    private UtilCliente util = new UtilCliente();
    private GestorDatos gestor = new GestorDatos();
    private String codigoReserva;
    /**
     * 
     * @param nombre
     * @param edadString
     * @param direccion
     * @param rut
     * @param codigoReserva 
     */
    public Cliente(String nombre, String edadString, Direccion direccion, Rut rut, String codigoReserva) {
        super(nombre, edadString, direccion, rut);

        if(util.validarCodigo(codigoReserva))
            this.codigoReserva = codigoReserva;
    }

    public String getCodigoReserva() {
        return this.codigoReserva;
    }

    public void setCodigoReserva(String codigo) {
        if(util.validarCodigo(codigo))
           this.codigoReserva = codigo;
    }

    @Override
    public String toString(){
        String cliente = "Nombre\t: " + this.getNombre() + "\n" +
                         "Edad\t: " + this.getEdad() + "\n" +
                         "Rut\t: " + this.getRut().toString() + "\n" +
                         this.getDireccion().toString() + "\n" +
                         "Cod. Reserva\t: " + this.codigoReserva + "\n";
        return cliente;
    }

    @Override
    public void persistir() {
        String persistirCliente = 
                "Cliente;" +
                this.getNombre() + ";" + 
                this.getEdad() + ";"+
                this.getDireccion().persistir()+";" + 
                this.getRut().toString() + ";" +
                this.codigoReserva;
        gestor.persistirEntidad(persistirCliente);
    }
}
