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
public class EAC03 extends InstalacionesDeExposicion {

    public EAC03() {

        super(25000, Medio.ACUATICO, Alimentacion.CARNIVORO, 400, TipoRecinto.VIDREO, 3);
    }

    @Override
    public String toString() {
        return "INSTALACION DE EXHIBICION EAC03";
    }
}
