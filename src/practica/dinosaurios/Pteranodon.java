/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.dinosaurios;

import practica.dinosaurios.Dinosaurio;
import practica.enums.Alimentacion;
import practica.enums.Medio;

/**
 *
 * @author rodri
 */
public class Pteranodon extends Dinosaurio {

    public Pteranodon(String nombre) {
        super(nombre, Medio.VOLADOR, Alimentacion.CARNIVORO, 16);
    }

    @Override
    public String toString() {
        return "Soy " + this.mote + " el Pteranodon";
    }
}
