package UI;

import Data.GestorDatos;
import Exception.DireccionException;
import Exception.GuiaTuristicoException;
import Exception.TourException;
import Model.Direccion;
import Model.GuiaTuristico;
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
    /**
      * Bloque estático para cargar los tours desde el archivo al iniciar la aplicación.
      * Si el archivo no existe, se crea uno nuevo y se inicializa la lista vacía.
     */
    static {
            tours = datos.CargarTours(archivo);
    }

    
    
   
    /**
     * Método main agrega tours, muestra la colección, filtra por tipo y guarda.
     * @param args: argumentos de línea de comandos (no se utilizan).
     * @throws IOException si ocurre un error al guardar el archivo.
     * @throws TourException si ocurre un error al filtrar por Tipotour.
     * @throws GuiaTuristicoException si ocurre un error al filtrar por guía.
     */
    public static void main(String[] args) 
            throws IOException, TourException, GuiaTuristicoException
    {
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        try{
            Direccion direccion1 = new Direccion("Las golondrinas",10589, "Coñaripe","Villarrica");
            GuiaTuristico guia1 = new GuiaTuristico("Daniel Opazo",32, direccion1);    

            Direccion direccion2 = new Direccion("Caupolicán",1145, "Pucón","Villarrica");
            GuiaTuristico guia2 = new GuiaTuristico("Jaime Falpe",28, direccion2); 

            Direccion direccion3 = new Direccion("Los Tulipanes",7847, "Lican ray","Villarrica");
            GuiaTuristico guia3 = new GuiaTuristico("Ariel Quinteros",28, direccion3); 

            util.agregarTour("Trekking","Panguipulli",12, 60.5, guia1, tours);
            util.agregarTour("Gastronómico","Puerto Varas",8, 45.2, guia1, tours);
            util.agregarTour("Gastronómico","Frutillar",15, 25.1, guia2, tours);
            util.agregarTour("Escalada","Osorno",10, 50.9, guia3, tours);
            util.agregarTour("Trekking","Llanquihue",20, 10.9, guia3, tours);
        }
        catch(GuiaTuristicoException e){
            System.out.println("Error con GuiaTuristico: " + e.getMessage());
        }
        catch(DireccionException e){
            System.out.println("Error con Direccion: " + e.getMessage());
        }
        
        var filtroTipoTour = "Trekking";
        var filtroTours = util.filtrarPorTipoTour(filtroTipoTour, tours);
        System.out.println(datos.MostrarTours(tours));
        System.out.println("***Tours filtrados por tipo: " + filtroTipoTour + "***");
        System.out.println(datos.MostrarTours(filtroTours));
        
        var filtroPorGuia = "Ariel Quinteros";
        filtroTours = util.filtrarPorGuia(filtroPorGuia, tours);
        System.out.println("***Tours impartidos por Guia: " + filtroPorGuia + "***");
        System.out.println(datos.MostrarTours(filtroTours));
        datos.GuardarArchivo(archivo, tours);
    }    

}
