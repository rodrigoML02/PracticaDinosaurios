/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.islands.islandTypes.islasDeExposicion;

import practica.enums.NivelAdquisitivo;

/**
 *
 * @author rodri
 */
public class IslaNublar extends Exposicion {

    public IslaNublar() {
        super(7700, 10000, 1000, NivelAdquisitivo.ALTO);
    }

    @Override
    public String toString() {
        return "ISLA NUBLAR DE EXPOSICION";
    }

}
