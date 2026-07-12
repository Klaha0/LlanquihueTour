package exception;

/**
 * Excepción personalizada para errores relacionados con la creación y manejo de tours.
 * Se lanza cuando se intentan crear tours con datos inválidos o duplicados.
 */
public class TourException extends Exception {

    public TourException(String message) {
        super(message);
    }
     
}
