package service;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;
import java.util.ArrayList;

/**
 * Clase de servicio encargada de recorrer y mostrar por consola una
 * colección de servicios turísticos.
 */
public class ServicioTuristicoService {

    /**
     * Recorre la colección con un bucle for-each y muestra por consola
     * la información de cada servicio turístico invocando su método
     * sobrescrito mostrarResumen().
     * @param servicios: ArrayList de servicios turísticos a mostrar.
     */
    public void mostrarServicioTuristico(ArrayList<ServicioTuristico> servicios) {
        
        System.out.println("--==** SERVICIOS TURÍSTICOS DISPONIBLES **==--");
        for (ServicioTuristico servicio : servicios) {

            if(servicio instanceof PaseoLacustre) 
            {
                System.out.println(((PaseoLacustre) servicio).mostrarResumen());
            } 
            else if(servicio instanceof RutaGastronomica) 
            {
                System.out.println(((RutaGastronomica) servicio).mostrarResumen());
            } 
            else if(servicio instanceof ExcursionCultural) 
            {
                System.out.println(((ExcursionCultural) servicio).mostrarResumen());
            }
        }
    }
}
