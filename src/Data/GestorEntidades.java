package Data;

import Model.Registrable;
import java.util.ArrayList;

public class GestorEntidades {
    private final ArrayList<Registrable> entidades;

    public GestorEntidades() {
        this.entidades = new ArrayList();
    }
    
    public void agregar(Registrable entidad) {
    this.entidades.add(entidad);
    }
}
