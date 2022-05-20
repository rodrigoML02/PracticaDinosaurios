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
public class Branchiosaurus extends Dinosaurio {

    public Branchiosaurus(String nombre) {

        super(nombre, Medio.TERRESTRE, Alimentacion.HERVIBORO, 12);

    }

    @Override
    public String toString() {
        return "Soy " + this.mote + " el Branchiosaurus";
    }
}
