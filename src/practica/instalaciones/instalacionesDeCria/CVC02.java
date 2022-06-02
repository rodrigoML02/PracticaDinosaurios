/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.instalaciones.instalacionesDeCria;

import practica.dinosaurios.Dinosaurio;
import practica.dinosaurios.Pteranodon;
import practica.enums.Alimentacion;
import practica.enums.Medio;
import practica.enums.TipoRecinto;

/**
 *
 * @author rodri
 */
public class CVC02 extends InstalacionesDeCria {

    public CVC02() {
        //super(int coste, Medio medio, Alimentacion alimentacion, int comida, int hectareas, TipoRecinto tipoRecinto, int capacidad)
        super(5000, Medio.VOLADOR, Alimentacion.CARNIVORO, 500, 100, TipoRecinto.ELECTRIFICADO, 2);

    }

    @Override
    public String toString() {
        return "INSTALACION DE CRIA CVC02    " + this.coste + "$";
    }

    @Override
    public Dinosaurio CrearDinosaurio(String mote) {
        Pteranodon dinosaurio = new Pteranodon(mote);
        return dinosaurio;
    }

}
