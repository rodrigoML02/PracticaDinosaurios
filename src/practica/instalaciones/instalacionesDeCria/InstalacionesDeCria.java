/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.instalaciones.instalacionesDeCria;

import practica.dinosaurios.Dinosaurio;
import practica.enums.Alimentacion;
import practica.enums.Medio;
import practica.enums.TipoIsla;
import practica.enums.TipoRecinto;
import practica.instalaciones.Instalacion;

/**
 *
 * @author rodri
 */
public abstract class InstalacionesDeCria extends Instalacion {

    public InstalacionesDeCria(int coste, Medio medio, Alimentacion alimentacion, int comida, int hectareas, TipoRecinto tipoRecinto, int capacidad) {
        super(TipoIsla.CRIA, coste, medio, alimentacion, comida, hectareas, tipoRecinto, capacidad);
    }

    public Dinosaurio CreadordeDinos(String mote) {
        Dinosaurio dinosaurio = null;
        if (this.capacidad > 0) {
            int dados = (int) Math.floor(Math.random() * 100);
            if (dados <= 20) {
                dinosaurio = CrearDinosaurio(mote);
                this.dinosaurios.add(dinosaurio);
            }
        }
        return dinosaurio;
    }

    public abstract Dinosaurio CrearDinosaurio(String mote);

    @Override
    public abstract String toString();

}
