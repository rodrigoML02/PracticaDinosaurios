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
public class ETC02 extends InstalacionesDeExposicion {

    public ETC02() {
        super(12500, Medio.TERRESTRE, Alimentacion.CARNIVORO, 300, TipoRecinto.ELECTRIFICADO, 3);
    }

    @Override
    public String toString() {
        return "INSTALACION DE EXHIBICION ETC02    " + this.coste + "$";
    }
}
