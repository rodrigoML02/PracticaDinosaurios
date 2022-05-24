/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.islands.islandTypes.islasDeCrianza;

import practica.enums.TipoIsla;
import practica.instalaciones.instalacionesDeCria.InstalacionesDeCria;
import practica.islands.Isla;
import practica.system.exceptions.NoHayEspacioException;

/**
 *
 * @author rodri
 */
public abstract class Cria extends Isla {

    public Cria(int hectareas, int comida) {
        super(hectareas, comida, TipoIsla.CRIA);
    }

    public InstalacionesDeCria getInstalacion(int num) {
        InstalacionesDeCria instalacionDeCria = null;
        if (this.instalaciones.get(num).getTipo() == this.tipo) {
            instalacionDeCria = (InstalacionesDeCria) this.instalaciones.get(num);
        }
        return instalacionDeCria;
    }

    public void construirInstalaciones(InstalacionesDeCria instalacionNueva) throws Exception {
        if (this.hectareas >= instalacionNueva.getHectareas()) {
            this.instalaciones.add(instalacionNueva);
            this.hectareas = this.hectareas - instalacionNueva.getHectareas();
        } else {
            throw new NoHayEspacioException();
        }
    }

    @Override
    public abstract String toString();

}
