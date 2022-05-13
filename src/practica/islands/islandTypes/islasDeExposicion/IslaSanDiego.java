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
public class IslaSanDiego extends Exposicion {

    public IslaSanDiego() {
        super(100, 5000, 2000, NivelAdquisitivo.BAJO);

    }

    @Override
    public String toString() {
        return "ISLA SAN DIEGO DE EXPOSICION";
    }
}
