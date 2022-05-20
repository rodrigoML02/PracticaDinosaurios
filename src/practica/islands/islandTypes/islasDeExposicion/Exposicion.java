/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.islands.islandTypes.islasDeExposicion;

import practica.enums.*;
import practica.instalaciones.instalacionesDeExposicion.InstalacionesDeExposicion;
import practica.islands.Isla;

/**
 *
 * @author rodri
 */
public abstract class Exposicion extends Isla {

    public int visitantes;
    public NivelAdquisitivo nivelAdquisitivo;

    public Exposicion(int hectareas, int comida, int visitantes, NivelAdquisitivo nivelAdquisitivo) {
        super(hectareas, comida, TipoIsla.EXHIBICION);
        this.visitantes = visitantes;
        this.nivelAdquisitivo = nivelAdquisitivo;
    }

    //getters
    public int getVisitantes() {
        return this.visitantes;
    }

    public NivelAdquisitivo getNivelAdquisitivo() {
        return this.nivelAdquisitivo;
    }

    //setter
    public void setVisitas(int visitas) {
        this.visitantes = visitas;
    }

    public InstalacionesDeExposicion getInstalacion(int num) {
        InstalacionesDeExposicion instalacionDeExposicion = null;
        if (this.instalaciones.get(num).getTipo() == this.tipo) {
            instalacionDeExposicion = (InstalacionesDeExposicion) this.instalaciones.get(num);
        }
        return instalacionDeExposicion;
    }

    public void construirInstalaciones(InstalacionesDeExposicion instalacionNueva) {
        if (this.hectareas >= instalacionNueva.getHectareas()) {
            this.instalaciones.add(instalacionNueva);
        } else {
            System.out.println("No hay Espacio en la isla");
        }
    }

    @Override
    public abstract String toString();

}
