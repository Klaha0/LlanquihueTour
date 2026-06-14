package Model;
import ExceptionTour.TourException;
import Util.UtilTour;
import java.util.ArrayList;

public class Tour {
    static int idContador = 0; //Contador estático para obtener id desde aquí
    private int idTour; //Propiedad id sin acceso externo se incrementa cuando se crea un objeto
    private String tipoTour;
    private String lugarTour;
    private int capacidadDePersonas;
    private double distanciaEnKm;

    /**
     * Crea un tour validando sus datos y verificando que no exista previamente.
     * @param tipoTour: tipo de experiencia que ofrece el tour.
     * @param lugarTour: lugar donde se hace el tour.
     * @param capacidadDePersonas: cantidad máxima de personas del tour.
     * @param distanciaEnKm: distancia del recorrido en kilómetros.
     * @param existentes: lista de tours ya cargados para evitar duplicados.
     * @throws TourException si los datos son inválidos o el tour ya existe.
     */
    public Tour(String tipoTour, String lugarTour, int capacidadDePersonas, double distanciaEnKm,
            ArrayList<Tour> existentes)
            throws TourException
    {
        UtilTour util = new UtilTour();

        if(util.ValidarTipoTour(tipoTour)){
            this.tipoTour = tipoTour;
        }
        if(util.ValidarLugarTour(lugarTour)){
            this.lugarTour = lugarTour;
        }
        if(util.ValidarCapacidad(capacidadDePersonas)){
            this.capacidadDePersonas = capacidadDePersonas;
        }
        if(util.ValidarDistancia(distanciaEnKm)){
            this.distanciaEnKm = distanciaEnKm;
        }
        //Validamos contra la lista ya cargada: si el tour ya existe, no lo creamos.        
        if(util.ExisteTour(this, existentes)){
            throw new TourException("El tour ya existe en los registros");
        }
        //Asignamos el id único
        this.idTour = Tour.idContador;

        Tour.idContador++;
    }

    /**
     * Obtiene el identificador único del tour.
     * @return el id del tour.
     */
    public int getIdTour() {
        return idTour;
    }


    /**
     * Para obtener el tipo de tour.
     * @return el tipo de tour.
     */
    public String getTipoTour() {

        return tipoTour;
    }

    /**
     * Setea el tipo de tour, primero se valida.
     * @param tipoTour: tipo de experiencia que ofrece el tour.
     * @throws TourException si el tipo de tour es inválido.
     */
    public void setTipoTour(String tipoTour) throws TourException{
        UtilTour util = new UtilTour();
        if(util.ValidarTipoTour(tipoTour)){
            this.tipoTour = tipoTour;
        }
    }

    /**
     * Obtiene el lugar del tour.
     * @return el lugar del tour.
     */
    public String getLugarTour() {
        return lugarTour;
    }

    /**
     * Asigna el lugar del tour previa validación.
     * @param lugarTour: lugar donde se hace el tour.
     * @throws TourException si el lugar del tour es inválido.
     */
    public void setLugarTour(String lugarTour) throws TourException{
        UtilTour util = new UtilTour();
        if(util.ValidarLugarTour(lugarTour)){
            this.lugarTour = lugarTour;
        }
    }

    /**
     * Obtener la capacidad de personas del tour.
     * @return la capacidad de personas del tour.
     */
    public int getCapacidadDePersonas() {
        return capacidadDePersonas;
    }

    /**
     * Asigna la capacidad de personas previa validación.
     * @param capacidadDePersonas: cantidad máxima de personas del tour.
     * @throws TourException si la capacidad es inválida.
     */
    public void setCapacidadDePersonas(int capacidadDePersonas) throws TourException{
        UtilTour util = new UtilTour();
        if(util.ValidarCapacidad(capacidadDePersonas)){
            this.capacidadDePersonas = capacidadDePersonas;
        }
    }

    /**
     * Obtiene la distancia del tour en kilómetros.
     * @return la distancia del tour en kilómetros.
     */
    public double getDistanciaEnKm() {
        return distanciaEnKm;
    }

    /**
     * Setea la distancia del tour previa validación.
     * @param distanciaEnKm: distancia del recorrido en kilómetros.
     * @throws TourException si la distancia es inválida.
     */
    public void setDistanciaEnKm(double distanciaEnKm) throws TourException{
        UtilTour util = new UtilTour();
        if(util.ValidarDistancia(distanciaEnKm)){
            this.distanciaEnKm = distanciaEnKm;
        }
    }
        
    /**
     * sobreescribe el método toString con formato personalizado
     * @return el texto descriptivo del tour.
     */
    @Override
    public String toString(){
        return "\t***Información Tour***\n" + 
                "Identificador : " + this.idTour +
              "\nTipo de tour  : " + this.tipoTour +
              "\nLugar de tour : " + this.lugarTour + 
              "\nCapacidad     : " + this.capacidadDePersonas+
              "\nDistancia     : " + String.format("%.2f Km",this.distanciaEnKm);
    }
}
