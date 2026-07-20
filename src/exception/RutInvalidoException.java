package exception;

/**Clase de excepción base para clase Rut
 * 
 */
public class RutInvalidoException extends PersonaException {

    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }    
}
