package Exception;


/**
 * Excepción personalizada para errores relacionados con la creación y validación de guías turísticos.
 * Se lanza cuando se intenta crear un guía turístico con datos inválidos.
 */
public class GuiaTuristicoException extends Exception{
    public GuiaTuristicoException(String mensaje) {
        super(mensaje);
    }   
}
