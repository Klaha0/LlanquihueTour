package model;

/**
 * Contrato común para toda entidad gestionable del sistema (servicios, guías, etc.),
 * permitiendo tratarlas de forma polimórfica en una misma colección.
 */
public interface Registrable {

    /**
     * Muestra un resumen con la información relevante de la entidad.
     * @return el String con el resumen de la entidad.
     */
    public String mostrarResumen();
}
