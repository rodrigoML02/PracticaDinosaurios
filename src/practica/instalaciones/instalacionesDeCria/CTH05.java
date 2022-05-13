package practica.instalaciones.instalacionesDeCria;

import practica.dinosaurios.Dinosaurio;
import practica.dinosaurios.tiposDeDinosaurios.Branchiosaurus;
import practica.enums.*;

/**
 *
 *
 */
public class CTH05 extends InstalacionesDeCria {

    public CTH05() {

        super(1000, Medio.TERRESTRE, Alimentacion.HERVIBORO, 200, 10, TipoRecinto.MADERA, 5);

    }

    @Override
    public String toString() {
        return "INSTALACION DE CRIA CTH05";
    }

    @Override
    public Dinosaurio CrearDinosaurio(String mote) {
        Branchiosaurus dinosaurio = new Branchiosaurus("mote");
        return dinosaurio;
    }

}
