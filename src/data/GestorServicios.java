package data;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.Registrable;
import model.RutaGastronomica;
import model.ServicioTuristico;
import java.util.ArrayList;

/**
 * Clase encargada de crear instancias de servicios turísticos de ejemplo
(PaseoLacustre, RutaGastronomica, ExcursionCultural) y cargarlas en una colección.
 */
public class GestorServicios {

    /**
     * Crea un paseo lacustre de ejemplo.
     * @return el PaseoLacustre creado.
     */
    public ServicioTuristico crearPaseoLacustre1(){
       return new PaseoLacustre("Conoce el lago calafquén", 2.5, "lancha");
    }

    /**
     * Crea un paseo lacustre de ejemplo.
     * @return el PaseoLacustre creado.
     */
    public ServicioTuristico crearPaseoLacustre2(){
        return new PaseoLacustre("Crucero romántico al atardecer", 3.0, "Yate de lujo");
    }

    /**
     * Crea una ruta gastronómica de ejemplo.
     * @return la RutaGastronomica creada.
     */
    public ServicioTuristico crearRutaGastronomica1(){
        return new RutaGastronomica("Ruta del curánto", 4.0, 4);
    }

    /**
     * Crea una ruta gastronómica de ejemplo.
     * @return la RutaGastronomica creada.
     */
    public ServicioTuristico crearRutaGastronomica2(){
        return new RutaGastronomica("Ruta de Vinos", 3.5, 3);
    }

    /**
     * Crea una excursión cultural de ejemplo.
     * @return la ExcursionCultural creada.
     */
    public ServicioTuristico crearExcursionCultural1(){
        return new ExcursionCultural("Tour histórico ciudad nocturna", 2.5, "Centro de Valdivia");
    }

    /**
     * Crea una excursión cultural de ejemplo.
     * @return la ExcursionCultural creada.
     */
    public ServicioTuristico crearExcursionCultural2(){
        return new ExcursionCultural("El arte desde otra perspectiva", 2.0, "Museo Nacional de bellas artes");
    }

    /**
     * Crea las 6 instancias de servicios turísticos de ejemplo (dos de cada subclase)
     * y las agrega a la colección recibida.
     * @param entidades: colección de entidades donde se agregan los servicios creados.
     * @return la misma colección recibida, con los servicios turísticos agregados.
     */
    public ArrayList<Registrable> cargarServiciosTuristicos(ArrayList<Registrable> entidades) {

        entidades.add(crearPaseoLacustre1());
        entidades.add(crearPaseoLacustre2());
        entidades.add(crearRutaGastronomica1());
        entidades.add(crearRutaGastronomica2());
        entidades.add(crearExcursionCultural1());
        entidades.add(crearExcursionCultural2());
        return entidades;
    }
}
