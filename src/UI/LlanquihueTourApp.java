package UI;

import Data.GestorDatos;
import ExceptionTour.TourException;
import Model.Tour;
import Util.UtilTour;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LlanquihueTourApp {
    static final String REGISTRO_TOURS = "resources/tours.txt";
    static GestorDatos datos = new GestorDatos();
    static ArrayList<Tour> tours;
    static UtilTour util = new Util.UtilTour();
    static final File archivo = new File(REGISTRO_TOURS);

    static {
        try {
            tours = datos.CargarTours(archivo);
        } catch (TourException e) {
            tours = new ArrayList<>();
            System.out.println("Error al cargar tours");
        }
    }

    
    
   
    /**
     * Punto de entrada: agrega tours, muestra la colección, filtra por tipo y guarda.
     * @param args: argumentos de línea de comandos (no se utilizan).
     * @throws IOException si ocurre un error al guardar el archivo.
     * @throws TourException si ocurre un error al filtrar los tours.
     */
    public static void main(String[] args) throws IOException, TourException {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        
        agregarTour("Trekking","Panguipulli",12, 60.5);
        agregarTour("Gastronómico","Puerto Varas",8, 45.2);
        agregarTour("Gastronómico","Frutillar",15, 25.1);
        agregarTour("Escalada","Osorno",10, 50.9);
        agregarTour("Trekking","Llanquihue",20, 10.9);
        
        var filtro = "Trekking";
        var filtroTours = util.filtrarPorTipoTour(filtro, tours);
        System.out.println(datos.MostrarTours(tours));
        System.out.println("***Tours filtrados por tipo: " + filtro + "***");
        System.out.println(datos.MostrarTours(filtroTours));
        
        datos.GuardarArchivo(archivo, tours);
    }

    /**
     * Crea y agrega un tour a la lista solo si no existe y sus datos son válidos.
     * @param tipoTour: tipo de experiencia que ofrece el tour.
     * @param lugarTour: lugar donde se hace el tour.
     * @param capacidad: cantidad máxima de personas del tour.
     * @param distancia: distancia del recorrido en kilómetros.
     */
    private static void agregarTour(String tipoTour, String lugarTour, int capacidad, double distancia){
        try {
            Tour tour = new Tour(tipoTour, lugarTour, capacidad, distancia, tours);
            tours.add(tour);
        } catch (TourException e) {
            System.out.println("No se agregó el tour: " + tipoTour + " - " + lugarTour + ": " + e.getMessage());
        }
    }

}
