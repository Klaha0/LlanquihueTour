package model;

import data.GestorDatos;
import exception.PersonaException;
import util.UtilGuiaTuristico;

public class GuiaTuristico extends Persona{
    private UtilGuiaTuristico util = new UtilGuiaTuristico();
    private GestorDatos gestor = new GestorDatos();
    private String especialidad;

    public GuiaTuristico(String nombre, String edadString, Direccion direccion, Rut rut, String especialidad) {
        super(nombre, edadString, direccion, rut);

        if(!util.validarEspecialidad(especialidad))
            throw new PersonaException("La especialidad ingresada no es válida");
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if(util.validarEspecialidad(especialidad))
            this.especialidad = especialidad;
    }
    
    @Override
    public String toString(){
        String guia = "Nombre\t: " + this.getNombre() + "\n" +
                      "Edad\t: " + this.getEdad() + "\n" +
                      "Rut\t: " + this.getRut().toString() + "\n" +
                      this.getDireccion().toString() + "\n" +
                      "Especialidad\t: " + this.especialidad + "\n";
        return guia;
    }
    
    @Override
    public void persistir(){
        String persistirGuiaTuristico = 
                "GuiaTuristico;" + 
                this.getNombre() + ";" + 
                this.getEdad() + ";"+
                this.getDireccion().persistir()+";" + 
                this.getRut().toString()+ ";" +
                this.especialidad;
        gestor.persistirEntidad(persistirGuiaTuristico);
    }
}
