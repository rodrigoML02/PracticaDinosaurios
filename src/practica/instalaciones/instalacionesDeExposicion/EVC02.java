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
public class EVC02 extends InstalacionesDeExposicion {

    public EVC02() {

        super(15000, Medio.VOLADOR, Alimentacion.CARNIVORO, 200, TipoRecinto.ELECTRIFICADO, 2);

    }

    @Override
    public String toString() {
        return "INSTALACION DE EXHIBICION EVC02";
    }
}
