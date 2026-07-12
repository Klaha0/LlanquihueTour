package data;

import model.ExcursionCultural;
import model.GuiaTuristico;
import model.PaseoLacustre;
import model.Registrable;
import model.RutaGastronomica;
import java.util.ArrayList;

/**
 * Clase encargada de administrar la colección polimórfica de entidades del sistema
 * (guías turísticos y servicios turísticos), permitiendo agregarlas y mostrarlas
 * diferenciando su tipo real mediante instanceof.
 */
public class GestorEntidades {
    private final ArrayList<Registrable> entidades;
    GestorServicios gestorServicios = new GestorServicios();
    GestorGuias gestorGuias = new GestorGuias();

    public GestorEntidades() {
        this.entidades = new ArrayList<>();
    }

    /**
     * Agrega una entidad a la colección.
     * @param entidad: entidad que implementa Registrable a agregar.
     */
    public void agregar(Registrable entidad) {
        this.entidades.add(entidad);
    }

    /**
     * Recorre la colección de Registrable para armar un String con la ayuda de StringBuilder
     * identificando los guías apoyado por instanceof
     * @return el String con el listado de guías turísticos registrados.
     */
    public String mostrarGuias()
    {
        var resumen = new StringBuilder();
        resumen.append("\t     --== Listado de Guías ==--\n\n");
        for(var entidad : entidades)
        {
            if(entidad instanceof GuiaTuristico)
            {
                resumen.append(entidad.mostrarResumen());
                resumen.append("────────────────────────────────────────\n");
            }
        }
        resumen.append("\n");
        return resumen.toString();
    }

    /**
     * Recorre la colección e identifica, mediante instanceof, los distintos
tipos de servicio turístico (PaseoLacustre, ExcursionCultural, RutaGastronomica).
     * @return el String con el listado de servicios turísticos registrados.
     */
    public String mostrarServicios(){
        var resumen = new StringBuilder();
        resumen.append("\t     --== Listado de Servicios ==--\n\n");
        for(var entidad : entidades)
        {
            if(entidad instanceof PaseoLacustre){
                resumen.append(entidad.mostrarResumen());
                resumen.append("────────────────────────────────────────\n");
            }
            else if(entidad instanceof ExcursionCultural){
                resumen.append(entidad.mostrarResumen());
                resumen.append("────────────────────────────────────────\n");
            }
            else if(entidad instanceof RutaGastronomica){
                resumen.append(entidad.mostrarResumen());
                resumen.append("────────────────────────────────────────\n");
            }
        }
        return resumen.toString();
    }

    /**
     * Muestra el listado completo de guías y servicios registrados.
     * @return el String con el listado completo de entidades registradas.
     */
    public String mostrarTodo(){
        var resumen = new StringBuilder();
        resumen.append("\t     ┌────────────────────────────────────┐\n");
        resumen.append("\t     │ == Bienvenido a Llanquihue Tours ==  │\n");
        resumen.append("\t     └────────────────────────────────────┘\n\n");
        resumen.append(mostrarGuias());
        resumen.append(mostrarServicios());
        return resumen.toString();
    }

    /**
     * Carga en la colección los servicios turísticos de ejemplo.
     */
    public void agregarServicios(){
        gestorServicios.cargarServiciosTuristicos(this.entidades);
    }

    /**
     * Carga en la colección los guías turísticos de ejemplo.
     */
    public void agregarGuias(){
        gestorGuias.cargarGuiasTuristicos(this.entidades);
    }

}
