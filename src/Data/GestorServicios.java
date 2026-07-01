package Data;

import Model.ExcursionCultural;
import Model.PaseoLacustre;
import Model.RutaGastronomica;
import Model.ServicioTuristico;
import java.util.ArrayList;

/**SEMANA 6 y 7
 * @GestorServicios 
 * (Semana 6)
 * Clase para poder crear 2 instancias de: 
 * PaseoLacustre - RutaGastronomica - ExcursionCultural
 * 
 * (Semana 7)
 * o bien crear un ArrayList de servicios turísticos
 * con 6 instancias de los 3 tipos de servicios.
 */
public class GestorServicios {
    //Métodos SEMANA 6
    public ServicioTuristico crearPaseoLacustre1(){
       return new PaseoLacustre("Conoce el lago calafquén", 2.5, "lancha");        
    }
    public ServicioTuristico crearPaseoLacustre2(){
        return new PaseoLacustre("Crucero romántico al atardecer", 3.0, "Yate de lujo");               
    }
    public ServicioTuristico crearRutaGastronomica1(){
        return new RutaGastronomica("Ruta del curánto", 4.0, 4);
    }
    public ServicioTuristico crearRutaGastronomica2(){
        return new RutaGastronomica("Ruta de Vinos", 3.5, 3);
    }
    public ServicioTuristico crearExcursionCultural1(){
        return new ExcursionCultural("Tour histórico ciudad nocturna", 2.5, "Centro de Valdivia");
    }
    public ServicioTuristico crearExcursionCultural2(){
        return new ExcursionCultural("El arte desde otra perspectiva", 2.0, "Museo Nacional de bellas artes");
    }

    //Método SEMANA 7
    /**Método crearServiciosTuristicos
     * utiliza los métodos de creación de instancias de la semana 6 para 
     * generar una lista de servicios turísticos.
     * @return ArrayList<ServicioTuristico> con 6 instancias de servicios turísticos
     */
    public ArrayList<ServicioTuristico> crearServiciosTuristicos() {
        ArrayList<ServicioTuristico> servicios = new ArrayList<>();
        servicios.add(crearPaseoLacustre1());
        servicios.add(crearPaseoLacustre2());
        servicios.add(crearRutaGastronomica1());
        servicios.add(crearRutaGastronomica2());
        servicios.add(crearExcursionCultural1());
        servicios.add(crearExcursionCultural2());
        return servicios;
    }
}
