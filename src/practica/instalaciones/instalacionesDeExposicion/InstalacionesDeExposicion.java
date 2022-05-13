/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.instalaciones.instalacionesDeExposicion;

import practica.enums.Alimentacion;
import practica.enums.Medio;
import practica.enums.TipoIsla;
import practica.enums.TipoRecinto;
import practica.instalaciones.Instalacion;

/**
 *
 * @author rodri
 */
public abstract class InstalacionesDeExposicion extends Instalacion {

    public InstalacionesDeExposicion(int coste, Medio medio, Alimentacion alimentacion, int hectareas, TipoRecinto tipoRecinto, int capacidad) {
        super(TipoIsla.EXHIBICION, coste, medio, alimentacion, 0, hectareas, tipoRecinto, capacidad);
    }

    @Override
    public abstract String toString();

}
