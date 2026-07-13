package data;

import model.Direccion;
import model.GuiaTuristico;
import model.Registrable;
import java.util.ArrayList;

/**
 * Clase encargada de crear instancias de guías turísticos de ejemplo
 * y cargarlas en una colección.
 */
public class GestorGuias {

    /**
     * Crea un guía turístico de ejemplo.
     * @return el GuiaTuristico creado.
     */
    public GuiaTuristico crearGuiaTuristico1(){
        String nombre = "Yuliana Palma Guzmán";
        String edad = "18";
        String calle = "Los almendros";
        String numero = "8759";
        String comuna = "Ensenada";
        String ciudad = "Puerto Varas";
        Direccion direccion = new Direccion(calle, numero, comuna, ciudad);
        GuiaTuristico guia = new GuiaTuristico(nombre, edad, direccion);
       return guia;
    }

    /**
     * Crea un guía turístico de ejemplo.
     * @return el GuiaTuristico creado.
     */
    public GuiaTuristico crearGuiaTuristico2(){
        String nombre = "Daniela Guzmán López";
        String edad = "35";
        String calle = "Las palmas";
        String numero = "9178";
        String comuna = "Ensenada";
        String ciudad = "Puerto Varas";
        Direccion direccion = new Direccion(calle, numero, comuna, ciudad);
        GuiaTuristico guia = new GuiaTuristico(nombre, edad, direccion);
       return guia;
    }

    /**
     * Crea un guía turístico de ejemplo.
     * @return el GuiaTuristico creado.
     */
    public GuiaTuristico crearGuiaTuristico3(){
        String nombre = "Carlos Palma Garrido";
        String edad = "41";
        String calle = "Los robles";
        String numero = "8248";
        String comuna = "El Carmen";
        String ciudad = "Chillán";

        Direccion direccion = new Direccion(calle, numero, comuna, ciudad);
        GuiaTuristico guia = new GuiaTuristico(nombre, edad, direccion);
       return guia;
    }

    /**
     * Crea las 3 instancias de guías turísticos de ejemplo y las agrega a la colección recibida.
     * @param entidades: colección de entidades donde se agregan los guías creados.
     * @return la misma colección recibida, con los guías turísticos agregados.
     */
    public ArrayList<Registrable> cargarGuiasTuristicos(ArrayList<Registrable> entidades) {

        entidades.add(crearGuiaTuristico1());
        entidades.add(crearGuiaTuristico2());
        entidades.add(crearGuiaTuristico3());
        return entidades;
    }
}
