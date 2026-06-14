package Data;
import ExceptionTour.TourException;
import Model.Tour;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class GestorDatos {
    private ArrayList<Tour> tours = new ArrayList<Tour>();
    /**
     * Lee el archivo línea por línea, crea los tours y los carga en un ArrayList.
     * @param leerDatos: archivo de texto con los datos de los tours.
     * @return la lista de tours cargados desde el archivo.
     * @throws TourException si ocurre un error al crear algún tour.
     */
    public ArrayList<Tour> CargarTours(File leerDatos) throws TourException
    {
        
        try {
                //Si el archivo no existe, se crea uno nuevo y se retorna la lista vacía (sin datos para mostrar)
                if (!leerDatos.exists()) 
                {
                    leerDatos.createNewFile();
                    System.out.println("Sin datos para mostrar");
                    return tours; //SI SE CREÓ RECIÉN EL ARCHIVO ESTÁ EN BLANCO
                }
                //Se utiliza try-with-resources para asegurar el cierre del BufferedReader
            try (BufferedReader br = new BufferedReader(new FileReader(leerDatos))) {
                String linea;

                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(";");
                    String tipoTour = datos[1];
                    String lugarTour = datos[2];
                    String capacidadPersonas = datos[3];
                    String distanciaEnKm = datos[4];
                    int capacidad = Integer.parseInt(capacidadPersonas);
                    double distancia = Double.parseDouble(distanciaEnKm);
                    //Pasamos la lista que se va construyendo: la línea actual aún no está
                    //en ella, así que se reconstruye bien. Si el archivo trae una línea
                    //duplicada, el constructor lanza TourException y la omitimos.
                    try {
                        Tour tour = new Tour(tipoTour, lugarTour, capacidad, distancia, tours);
                        tours.add(tour);
                        } catch (TourException e) {
                        System.out.println("Se omitió un registro porque ya existía o tenía datos inválidos: ");
                    }
                }
                br.close();
            }

        } 
        catch (IOException e) 
        {
            System.out.println("Se ha producido un error al leer el archivo");
        }
        return tours;
    }
    
    /**
     * Guarda todos los tours de la lista en el archivo, sobrescribiendo su contenido.
     * @param guardarDatos: archivo de texto donde se escriben los tours.
     * @param tours: lista de tours que se desea guardar.
     * @throws IOException si ocurre un error al escribir el archivo.
     */
    public void GuardarArchivo(File guardarDatos, ArrayList<Tour> tours) throws IOException
    {
        //PONEMOS APPEND = FALSE PORQUE PARTIMOS CARGANDO TODO EL DOCUMENTO AL ARRAY Y AL FINALIZAR LO GUARDAMOS TODO
        //CON APPEND = TRUE ESTABAMOS VOLVIENDO A AGREGAR MÁS REGISTROS INCLUSO CUANDO LOS ELIMINABAMOS
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(guardarDatos, false)))
        {
            
            for (Tour tour : tours)
            {
                String linea = tour.getIdTour() + ";"
                             + tour.getTipoTour() + ";" 
                             + tour.getLugarTour() + ";" 
                             + tour.getCapacidadDePersonas() + ";" 
                             + tour.getDistanciaEnKm();

                bw.write(linea);
                bw.newLine();
            }

        }
        catch (IOException e)
        {
            throw new IOException ("Error al guardar el archivo");
        }

    }
    
    /**
     * Recorre la lista y arma un texto con la información de todos los tours.
     * @param tours: lista de tours que se desea mostrar.
     * @return el texto con todos los tours o un aviso si está vacía.
     */
    public String MostrarTours(ArrayList<Tour> tours)
    {
        if (tours.isEmpty())
            return "No hay tours.";

        StringBuilder sb = new StringBuilder();
        sb.append("\t===== TOURS REGISTRADOS =====\n\n");
        for (Tour tour : tours)
        {
            sb.append("Identificador: ").append(tour.getIdTour()).append("\n");
            sb.append("Tipo de tour : ").append(tour.getTipoTour()).append("\n");
            sb.append("Lugar        : ").append(tour.getLugarTour()).append("\n");
            sb.append("Capacidad    : ").append(tour.getCapacidadDePersonas()).append(" personas").append("\n");
            sb.append("Distancia(Km): ").append(String.format("%.2fKm", tour.getDistanciaEnKm())).append("\n");
            sb.append("---------------------------------------------------------------------------\n");
        }

        return sb.toString();
    }
           
}
