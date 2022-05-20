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
public class TyrannosaurusRex extends Dinosaurio {

    public TyrannosaurusRex(String nombre) {
        //(String nombre, Medio medio, Alimentacion alimentacion, int edad, int edadProblematica
        super(nombre, Medio.TERRESTRE, Alimentacion.CARNIVORO, 24);
    }

    @Override
    public String toString() {
        return "Soy " + this.mote + " el TyranosaurusRex";
    }
}
