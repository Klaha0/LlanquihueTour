package Util;

import Exception.GuiaTuristicoException;
import Exception.TourException;
import Model.GuiaTuristico;
import Model.Tour;
import java.util.ArrayList;
import static java.util.Objects.isNull;


/**
 * Clase para validar y gestionar los datos de un Tour.
 * Incluye validaciones de campos, filtrado, creación y control de duplicados.
 */
public class UtilTour {


    /**
     * Verifica si un tour ya existe en la lista comparando por contenido.
     * @param nuevo: tour que se desea comprobar.
     * @param existentes: lista de tours ya cargados.
     * @return true si el tour ya existe en la lista.
     */
    public boolean ExisteTour(Tour nuevo, ArrayList<Tour> existentes){
        for(Tour tour : existentes){
            if(tour.getTipoTour().equals(nuevo.getTipoTour())
               && tour.getLugarTour().equals(nuevo.getLugarTour())
               && tour.getCapacidadDePersonas() == nuevo.getCapacidadDePersonas()
               && tour.getDistanciaEnKm() == nuevo.getDistanciaEnKm()){
                return true;
            }
        }
        return false;
    }

    /**
     * Valida que el tipo de tour no sea nulo ni vacío.
     * @param tipoTour: tipo de experiencia que ofrece el tour.
     * @return true si el tipo de tour es válido.
     * @throws TourException si el tipo de tour es nulo o vacío.
     */
    public boolean ValidarTipoTour(String tipoTour) throws TourException{
        if(isNull(tipoTour) || tipoTour.trim().isEmpty())
        {
            throw new TourException("Debe proporcionar un tipo de Tour válido");
        }
        return true;
               
    }
    
    /**
     * Valida que el lugar del tour no sea nulo ni vacío.
     * @param lugarTour: lugar donde se hace el tour.
     * @return true si el lugar del tour es válido.
     * @throws TourException si el lugar del tour es nulo o vacío.
     */
    public boolean ValidarLugarTour(String lugarTour) throws TourException{
        if(isNull(lugarTour) || lugarTour.trim().isEmpty())
        {
            throw new TourException("Debe proporcionar un lugar de Tour válido");
        }
        return true;               
    }
    
    /**
     * Valida que la capacidad del tour sea mayor que cero.
     * @param capacidadTour: cantidad máxima de personas del tour.
     * @return true si la capacidad es válida.
     * @throws TourException si la capacidad es menor o igual a cero.
     */
    public boolean ValidarCapacidad(int capacidadTour) throws TourException{
        if(capacidadTour <= 0)
        {
            throw new TourException("La capacidad del tour debe ser mayor que 0");
        }
        return true;                   
    }
    
    /**
     * Valida que la distancia del tour sea mayor que cero.
     * @param distanciaEnKm: distancia del recorrido en kilómetros.
     * @return true si la distancia es válida.
     * @throws TourException si la distancia es menor o igual a cero.
     */
    public boolean ValidarDistancia(double distanciaEnKm) throws TourException{
        if(distanciaEnKm <= 0)
        {
            throw new TourException("La distancia del tour debe ser mayor que 0");
        }
        return true;                   
    }
    
    /**
     * Filtra la lista y devuelve solo los tours que coinciden con el tipo indicado.
     * @param tipoTour: tipo de tour por el cual se desea filtrar.
     * @param tours: lista de tours sobre la que se aplica el filtro.
     * @return la lista de tours que coinciden con el tipo indicado.
     * @throws TourException si el tipo de tour para filtrar es nulo o vacío.
     */
    public ArrayList<Tour> filtrarPorTipoTour(String tipoTour, ArrayList<Tour> tours) throws TourException{
        if(isNull(tipoTour) || tipoTour.trim().isEmpty())
        {
            throw new TourException("Debe proporcionar un tipo de Tour válido para filtrar");
        }
        
        ArrayList<Tour> toursFiltrados = new ArrayList<>();
        String tipoLimpio = tipoTour.trim();
        
        for(Tour tour : tours){
            if(tour.getTipoTour().equalsIgnoreCase(tipoLimpio)){
                toursFiltrados.add(tour);
            }
        }
        
        return toursFiltrados;
    }
    
    /**
     * Filtra la lista y devuelve solo los tours que imparte el guía buscado.
     * @param nombreGuia: nombre del guía por el cual se desea filtrar.
     * @param tours: lista de tours sobre la que se aplica el filtro.
     * @return la lista de tours que coinciden con el guía indicado.
     * @throws GuiaTuristicoException si el nombre para filtrar es nulo o vacío.
     */
    public ArrayList<Tour> filtrarPorGuia(String nombreGuia, ArrayList<Tour> tours) throws GuiaTuristicoException{
        if(isNull(nombreGuia) || nombreGuia.trim().isEmpty())
        {
            throw new GuiaTuristicoException("Debe proporcionar un nombre válido");
        }
        
        ArrayList<Tour> toursFiltrados = new ArrayList<>();
        String guiaLimpio = nombreGuia.trim();
        
        for(Tour tour : tours){
            if(tour.getGuiaTuristico().getNombre().equalsIgnoreCase(guiaLimpio)){
                toursFiltrados.add(tour);
            }
        }
        if(toursFiltrados.size()==0){
            System.out.println("No existen guías con el nombre proporcionado");
        }
        return toursFiltrados;
    }
    
    /**
     * Crea y agrega un tour a la lista solo si no existe y sus datos son válidos.
     * @param tipoTour: tipo de experiencia que ofrece el tour.
     * @param lugarTour: lugar donde se hace el tour.
     * @param capacidad: cantidad máxima de personas del tour.
     * @param distancia: distancia del recorrido en kilómetros.
     * @param guia: guía turístico asignado al tour.
     * @param tours: Arraylist de tours existentes para comprobar si el que se está agregando ya existe.
     */
    public void agregarTour(String tipoTour, String lugarTour, int capacidad, double distancia, GuiaTuristico guia, ArrayList<Tour> tours){
        try {
            Tour tour = new Tour(tipoTour, lugarTour, capacidad, distancia, guia, tours);
            tours.add(tour);
        } 
        catch (TourException e) {
            System.out.println("No se agregó el tour: " + tipoTour + " - " + lugarTour + ": " + e.getMessage());
        }        
    }
    /**
     * Validamos que el tour no sea nulo
     * @param tour: un objeto de la clase Tour
     * @return False si es nulo el Tour
     */
    public boolean esValidoTour(Tour tour){        
            return isNull(tour) ? false : true;                
    }
}
