//
//package Data;
//
//import Exception.DireccionException;
//import Exception.GuiaTuristicoException;
//import Exception.TourException;
//import Model.Tour;
//import Model.GuiaTuristico;
//import Model.Direccion;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//
//
//
///**
// * Clase encargada de la persistencia de los tours.
// * Permite cargar los tours desde un archivo, guardarlos y mostrar su contenido.
// */
//public class GestorDatos {
//    private ArrayList<Tour> tours = new ArrayList<Tour>();
//    /**
//     * Lee el archivo línea por línea, crea los tours y los carga en el ArrayList.
//     * @param leerDatos: archivo de texto con los datos de los tours.
//     * @return la lista de tours cargados desde el archivo.
//     * @throws TourException si ocurre un error al crear algún tour.
//     */
//    public ArrayList<Tour> CargarTours(File leerDatos)
//    {
//        
//        try {
//            //Si el archivo no existe, se crea uno nuevo y se retorna la lista vacía (sin datos para mostrar)
//            if (!leerDatos.exists()) 
//            {
//                leerDatos.createNewFile();
//                System.out.println("Sin datos para mostrar");
//                return tours; //SI SE CREÓ RECIÉN EL ARCHIVO ESTÁ EN BLANCO
//            }
//            //Se utiliza try-with-resources para asegurar el cierre del BufferedReader
//            try (BufferedReader br = new BufferedReader(new FileReader(leerDatos))) {
//                String linea;
//                int numeroLinea = 1;//Variable para informar al usuario en qué línea hay error (si lo hay)
//
//                while ((linea = br.readLine()) != null) {                
//                    //Iniciamos las variables necesarias para conversión
//                    int capacidadInt;
//                    int edadInt;
//                    int numeracionInt;
//                    double  distancia;
//                    //Creamos el arreglo datos que contiene todos los datos de 1 tour
//                    String[] datos = linea.split(";");
//                    if (datos.length != 11){
//                        //Si el largo de la línea no es 11 saltamos a la siguiente e informamos al usuario
//                        System.out.println("Error en la data línea: "+numeroLinea);
//                        numeroLinea++;
//                        continue;
//                    }
//                    String tipoTour = datos[1];
//                    String lugarTour = datos[2];
//                    String capacidadPersonas = datos[3];
//                    String distanciaEnKm = datos[4];
//                    //Datos Guia
//                    String nombre = datos[5];
//                    String edad = datos[6];
//                    //Datos Direccion
//                    String calle = datos[7];
//                    String numeracion = datos[8];
//                    String comuna = datos[9];
//                    String ciudad = datos[10];
//
//                        //Hacemos operaciones con posible excepcion en bloque try-catch para capturar excepciones
//                        try{
//                            capacidadInt = Integer.parseInt(capacidadPersonas);
//                            edadInt = Integer.parseInt(edad);
//                            numeracionInt = Integer.parseInt(numeracion);
//                            distancia = Double.parseDouble(distanciaEnKm);   
//                            //Primero construimos la direccion
//                            Direccion direccion = new Direccion(calle, numeracionInt, comuna, ciudad);
//                            //Luego construimos el GuiaTuristico
//                            GuiaTuristico guia = new GuiaTuristico(nombre, edadInt, direccion);
//                            //Finalmente construimos el tour
//                            Tour tour = new Tour(tipoTour, lugarTour, capacidadInt, distancia, guia, tours);
//                            tours.add(tour);
//                        }            
//                        //Si caemos en algún catch la información no es válida y seguimos con la próxima línea
//                        catch(NumberFormatException e){
//                            System.out.println("El formato del número no es válido");                        
//                            continue;
//                        }
//                        catch(DireccionException e){
//                            System.out.println("La información para dirección no es válida");
//                            continue;
//                        }
//                        catch(GuiaTuristicoException e){
//                            System.out.println("La información para el guia turístico no es válida ");
//                            continue;
//                        }
//                        catch (TourException e) {
//                            System.out.println("Se omitió un registro porque ya existía o tenía datos inválidos: "); 
//                            continue;
//                        }                
//
//                        numeroLinea++;
//                    }
//                br.close();
//            }
//        } 
//        catch (IOException e) 
//        {
//            System.out.println("Se ha producido un error al leer el archivo");
//        }
//        return tours;
//    }
//    
//    /**
//     * Guarda todos los tours de la lista en el archivo, sobrescribiendo su contenido.
//     * @param guardarDatos: archivo de texto donde se escriben los tours.
//     * @param tours: lista de tours que se desea guardar.
//     * @throws IOException si ocurre un error al escribir el archivo.
//     */
//    public void GuardarArchivo(File guardarDatos, ArrayList<Tour> tours) throws IOException
//    {
//        //Ponemos append = false porque partimos cargando todo el documento al array, y luego lo guardamos completo al finalizar
//        try (BufferedWriter bw = new BufferedWriter(new FileWriter(guardarDatos, false)))
//        {
//            
//            for (Tour tour : tours)
//            {
//                String linea = tour.getIdTour() + ";"
//                             + tour.getTipoTour() + ";" 
//                             + tour.getLugarTour() + ";" 
//                             + tour.getCapacidadDePersonas() + ";" 
//                             + tour.getDistanciaEnKm() + ";"
//                             + tour.getGuiaTuristico().getNombre() + ";"
//                             + tour.getGuiaTuristico().getEdad() + ";"
//                             + tour.getGuiaTuristico().getDireccion().getCalle() + ";"
//                             + tour.getGuiaTuristico().getDireccion().getNumero() + ";"
//                             + tour.getGuiaTuristico().getDireccion().getComuna() + ";"
//                             + tour.getGuiaTuristico().getDireccion().getCiudad() + ";";                             
//                bw.write(linea);
//                bw.newLine();
//            }
//
//        }
//        catch (IOException e)
//        {
//            throw new IOException ("Error al guardar el archivo");
//        }
//
//    }
//    
//    /**
//     * Recorre la lista de tours y arma un String con la información de todos los tours.
//     * @param tours: lista de tours que se desea mostrar.
//     * @return un String con todos los tours o notifica si está vacía la lista.
//     */
//    public String MostrarTours(ArrayList<Tour> tours)
//    {
//        if (tours.isEmpty())
//            return "No hay tours.";
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("\t===== TOURS REGISTRADOS =====\n\n");
//        for (Tour tour : tours)
//        {
//            sb.append("Identificador: ").append(tour.getIdTour()).append("\n");
//            sb.append("Tipo de tour : ").append(tour.getTipoTour()).append("\n");
//            sb.append("Lugar        : ").append(tour.getLugarTour()).append("\n");
//            sb.append("Capacidad    : ").append(tour.getCapacidadDePersonas()).append(" personas").append("\n");
//            sb.append("Distancia(Km): ").append(String.format("%.2fKm", tour.getDistanciaEnKm())).append("\n");
//            sb.append("Guía         : ").append(tour.getGuiaTuristico().getNombre()).append("\n");
//            sb.append("---------------------------------------------------------------------------\n");
//        }
//
//        return sb.toString();
//    }      
//}
