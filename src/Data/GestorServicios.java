package Data;

import Model.ExcursionCultural;
import Model.PaseoLacustre;
import Model.RutaGastronomica;
import Model.ServicioTuristico;
/**
 * @GestorServicios 
 * Clase para poder crear 2 instancias de: 
 * PaseoLacustre - RutaGastronomica - ExcursionCultural
 */
public class GestorServicios {

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

}
