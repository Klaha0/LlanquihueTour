package UI;

import Data.GestorServicios;
import Exception.GuiaTuristicoException;
import Exception.TourException;
import Service.ServicioTuristicoService;
import java.io.IOException;

public class Main {
// <editor-fold defaultstate="collapsed" desc="SEMANAS ANTERIORES">
    /*
    static final String REGISTRO_TOURS = "resources/tours.txt";
    static GestorDatos datos = new GestorDatos();
    static ArrayList<Tour> tours;
    static UtilTour util = new Util.UtilTour();
    static final File archivo = new File(REGISTRO_TOURS);
    */
    /**
      * Bloque estático para cargar los tours desde el archivo al iniciar la aplicación.
      * Si el archivo no existe, se crea uno nuevo y se inicializa la lista vacía.
     */
    /*static {
            tours = datos.CargarTours(archivo);
    }        */
   
    /**
     * //SEMANA 5
     * Método main agrega tours, muestra la colección, filtra por tipo y guarda.
     * @param args: argumentos de línea de comandos (no se utilizan).
     * @throws IOException si ocurre un error al guardar el archivo.
     * @throws TourException si ocurre un error al filtrar por Tipotour.
     * @throws GuiaTuristicoException si ocurre un error al filtrar por guía.
     * 
     * SEMANA 6     
     * Super clase - ServicioTuristico.
     *  Se crean distintas instancias predefinidas de:
     * @RutaGastronomica, @PaseoLacustre y @ExcursionCultural y se muestran en consola.     
     */
// </editor-fold>
    public static void main(String[] args) 
            throws IOException, TourException, GuiaTuristicoException
    {
        //Se agrega setOut para trabajar con UTF-8 y permitir tildes 
        System.setOut(new java.io.PrintStream(System.out, true, java.nio.charset.StandardCharsets.UTF_8));
        //Se crea instamcia de GestorServicios para crear objetos pre-definidos
        GestorServicios gestor = new GestorServicios();
        
// <editor-fold defaultstate="collapsed" desc="SEMANAS ANTERIORES">
        //Se deja comentado código de la SEMANA 5
        /*
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
        datos.GuardarArchivo(archivo, tours);*/
        
        /*
        //Comienza Código SEMANA 6
        
        //Se Crean 2 instancias de cada clase
        //apoyandose de GestorServicios
        var paseoLacustre1 = gestor.crearPaseoLacustre1();
        var paseoLacustre2 = gestor.crearPaseoLacustre2();
        var rutaGastronomica1 = gestor.crearRutaGastronomica1();
        var rutaGastronomica2 = gestor.crearRutaGastronomica2();
        var excursionCultural1 = gestor.crearExcursionCultural1();
        var excursionCultural2 = gestor.crearExcursionCultural2();

        //Se muestran en consola las instancias creadas
        //usando el método toString() de cada clase
        System.out.println(paseoLacustre1.toString());
        System.out.println(paseoLacustre2.toString());
        System.out.println(rutaGastronomica1.toString());
        System.out.println(rutaGastronomica2.toString());
        System.out.println(excursionCultural1.toString());
        System.out.println(excursionCultural2.toString());
        */
// </editor-fold>

        //Comienza Código SEMANA 7
        //Se crea lista de servicios turísticos ayudados del gestor
        var serviciosTuristicos = gestor.crearServiciosTuristicos();
        //Se crea una instancia del servicio que nos va a 
        //ayudar a mostrar los servicios turísticos
        var serviciosService = new ServicioTuristicoService();
        serviciosService.mostrarServicioTuristico(serviciosTuristicos);
                
        
        //También se puede utilizar este forEach que nos permite ahorrar mucho código
        //solo a modo de ejemplo (a este solo le pasamos la colección sin procesar)
        //serviciosTuristicos.forEach(servicio -> System.out.println(servicio.mostrarInformacion()));
    }    

}
