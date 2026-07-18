package model;

import exception.RutInvalidoException;
import util.UtilRut;



public class Rut {
    private String rut;

    /**
     * Contructor de la clase
     * @param rut: Rut de la persona
     */
    public Rut(String rut)
    {
        UtilRut util = new UtilRut();

        if(!util.validarRut(rut))
            throw new RutInvalidoException("El Rut ingresado no es válido");
        this.rut = rut;
    }

    public String getRut() {
        return rut;
    }
/**setter de rut
 * @param rut: rut de la persona
 */
    public void setRut(String rut){
        UtilRut util = new UtilRut();
        
        if(util.validarRut(rut))
            this.rut = rut;
    }    
    
    @Override
    public String toString(){
        var rutString = this.rut.replace(".", "").replace("-", "");
        rutString = this.rut.substring(0,(rutString.length())-1) + "-" + this.rut.substring((rutString.length())-1);
        return rutString;
    }               
    
}