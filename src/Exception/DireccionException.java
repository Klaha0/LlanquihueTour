package Exception;

/**
 * Excepción personalizada para errores relacionados con la creación y validación de direcciones.
 * Se lanza cuando se intenta crear una dirección con datos inválidos.
 */
public class DireccionException extends Exception{
    public DireccionException(String mensaje) {
        super(mensaje);
    }   
}
