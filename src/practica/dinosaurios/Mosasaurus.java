/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.dinosaurios;

import practica.enums.Alimentacion;
import practica.enums.Medio;

/**
 *
 * @author rodri
 */
public class Mosasaurus extends Dinosaurio {

    public Mosasaurus(String nombre) {

        super(nombre, Medio.ACUATICO, Alimentacion.CARNIVORO, 42, 10);
        cantidadAIngerir();

    }

    @Override
    public String toString() {
        return "Soy " + this.mote + " el Mososaurio";
    }
}
