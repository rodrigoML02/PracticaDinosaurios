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
public class IslaMatanceros extends Exposicion {

    public IslaMatanceros() {
        super(10000, 25000, 3000, NivelAdquisitivo.MEDIO);

    }

    @Override
    public String toString() {
        return "ISLA MATANCEROS DE EXPOSICION";
    }
}
