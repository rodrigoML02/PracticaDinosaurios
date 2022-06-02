/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.instalaciones.instalacionesDeExposicion;

import practica.enums.Alimentacion;
import practica.enums.Medio;
import practica.enums.TipoRecinto;

/**
 *
 * @author rodri
 */
public class ETH02 extends InstalacionesDeExposicion {

    public ETH02() {
        //int coste, Medio medio, Alimentacion alimentacion, int hectareas, TipoRecinto tipoRecinto, int capacidad

        super(2100, Medio.TERRESTRE, Alimentacion.CARNIVORO, 200, TipoRecinto.MADERA, 2);
    }

    @Override
    public String toString() {
        return "INSTALACION DE EXHIBICION ETH02    " + this.coste + "$";
    }

}
