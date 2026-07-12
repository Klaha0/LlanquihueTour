package model;
import exception.TourException;
import util.UtilGuiaTuristico;
import util.UtilTour;
import java.util.ArrayList;

/**
 * Clase que representa un tour con sus propiedades y validaciones.
 * Cada tour tiene un identificador único, tipo, lugar, capacidad y distancia.
 */
public class Tour {
    static int idContador = 0; //Contador estático para obtener id desde aquí
    private int idTour; //Propiedad id sin acceso externo se incrementa cuando se crea un objeto
    private String tipoTour;
    private String lugarTour;
    private int capacidadDePersonas;
    private double distanciaEnKm;
    private GuiaTuristico guiaTuristico;

    /**
     * Crea un tour validando sus datos y verificando que no exista previamente.
     * @param tipoTour: tipo de experiencia que ofrece el tour.
     * @param lugarTour: lugar donde se hace el tour.
     * @param capacidadDePersonas: cantidad máxima de personas del tour.
     * @param distanciaEnKm: distancia del recorrido en kilómetros.
     * @param guia: guía turístico asignado al tour.
     * @param existentes: lista de tours ya cargados para evitar duplicados.
     * @throws TourException si los datos son inválidos o el tour ya existe.
     */
    public Tour(String tipoTour, String lugarTour, int capacidadDePersonas, double distanciaEnKm, GuiaTuristico guia,
            ArrayList<Tour> existentes)
            throws TourException
    {
        UtilTour util = new UtilTour();
        UtilGuiaTuristico utilGuiaTuristico = new UtilGuiaTuristico();

        if(util.validarTipoTour(tipoTour)){
            this.tipoTour = tipoTour;
        }
        if(util.validarLugarTour(lugarTour)){
            this.lugarTour = lugarTour;
        }
        if(util.validarCapacidad(capacidadDePersonas)){
            this.capacidadDePersonas = capacidadDePersonas;
        }
        if(util.validarDistancia(distanciaEnKm)){
            this.distanciaEnKm = distanciaEnKm;
        }
        if(utilGuiaTuristico.esValidoGuiaTuristico(guia)){
            this.guiaTuristico = guia;
        }
        //Validamos contra la lista ya cargada: si el tour ya existe, no lo creamos.        
        if(util.existeTour(this, existentes)){
            throw new TourException("El tour ya existe en los registros");
        }        
        
        //Asignamos el id único
        this.idTour = Tour.idContador;

        Tour.idContador++;
    }

    /**
     * getter del identificador único del tour.
     * @return el id del tour.
     */
    public int getIdTour() {
        return idTour;
    }


    /**
     * Getter del tipo de tour.
     * @return el tipo de tour.
     */
    public String getTipoTour() {

        return tipoTour;
    }

    /**
     * Setter del tipo de tour, primero se valida.
     * @param tipoTour: tipo de experiencia que ofrece el tour.
     * @throws TourException si el tipo de tour es inválido.
     */
    public void setTipoTour(String tipoTour) throws TourException{
        UtilTour util = new UtilTour();
        if(util.validarTipoTour(tipoTour)){
            this.tipoTour = tipoTour;
        }
    }

    /**
     * Getter de lugar del tour.
     * @return el lugar del tour.
     */
    public String getLugarTour() {
        return lugarTour;
    }

    /**
     * Setter del lugar del tour, primero se valida.
     * @param lugarTour: lugar donde se hace el tour.
     * @throws TourException si el lugar del tour es inválido.
     */
    public void setLugarTour(String lugarTour) throws TourException{
        UtilTour util = new UtilTour();
        if(util.validarLugarTour(lugarTour)){
            this.lugarTour = lugarTour;
        }
    }

    /**
     * Getter de la capacidad de personas del tour.
     * @return la capacidad de personas del tour.
     */
    public int getCapacidadDePersonas() {
        return capacidadDePersonas;
    }

    /**
     * Setter de la capacidad de personas del tour, primero se valida.
     * @param capacidadDePersonas: cantidad máxima de personas del tour.
     * @throws TourException si la capacidad es inválida.
     */
    public void setCapacidadDePersonas(int capacidadDePersonas) throws TourException{
        UtilTour util = new UtilTour();
        if(util.validarCapacidad(capacidadDePersonas)){
            this.capacidadDePersonas = capacidadDePersonas;
        }
    }

    /**
     * Getter de la distancia del tour en kilómetros.
     * @return la distancia del tour en kilómetros.
     */
    public double getDistanciaEnKm() {
        return distanciaEnKm;
    }

    /**
     * Setter de la distancia del tour, primero se valida.
     * @param distanciaEnKm: distancia del recorrido en kilómetros.
     * @throws TourException si la distancia es inválida.
     */
    public void setDistanciaEnKm(double distanciaEnKm) throws TourException{
        UtilTour util = new UtilTour();
        if(util.validarDistancia(distanciaEnKm)){
            this.distanciaEnKm = distanciaEnKm;
        }
    }

    /**
     * Getter del guía turístico asignado al tour.
     * @return el guía turístico del tour.
     */
    public GuiaTuristico getGuiaTuristico() {
        return guiaTuristico;
    }

    /**
     * Setter del guía turístico asignado al tour.
     * @param guiaTuristico: guía turístico que se asigna al tour.
     */
    public void setGuiaTuristico(GuiaTuristico guiaTuristico) {
            this.guiaTuristico = guiaTuristico;
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
              "\nDistancia     : " + String.format("%.2f Km",this.distanciaEnKm)+"\n"+
                guiaTuristico.toString();
    }
}
