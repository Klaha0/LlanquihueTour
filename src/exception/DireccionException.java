package exception;

/**
 * Excepción personalizada para errores relacionados con la creación y validación de direcciones.
 * Se lanza cuando se intenta crear una dirección con datos inválidos.
 */
public class DireccionException extends RuntimeException{
    public DireccionException(String mensaje) {
        super(mensaje);
    }   
}
