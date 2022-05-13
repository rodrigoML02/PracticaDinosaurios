/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.instalaciones;

import java.util.ArrayList;
import practica.dinosaurios.Dinosaurio;
import practica.enums.*;
import practica.system.Entity;

/**
 *
 * @author rodri
 */
public abstract class Instalacion extends Entity {

    public TipoIsla tipo;
    int id;
    public int coste;
    public Medio medio;
    public Alimentacion alimentacion;
    public int comida;
    public int hectarias;
    public TipoRecinto tipoRecinto;
    //indica como de probable es que haya caos un dinosaurio(0-100)
    public int caos;
    public int capacidad;
    public ArrayList<Dinosaurio> dinosaurios = new ArrayList<>();

    public Instalacion(TipoIsla tipo, int coste, Medio medio, Alimentacion alimentacion, int comida, int hectareas, TipoRecinto tipoRecinto, int capacidad) {
        super();
        id = getID();
        caos = 0;
        this.alimentacion = alimentacion;
        this.capacidad = capacidad;
        this.comida = capacidad;
        this.coste = coste;
        this.medio = medio;
        this.hectarias = hectareas;
        this.tipo = tipo;
        this.tipoRecinto = tipoRecinto;
    }

    public int instalacionID() {
        return this.id;
    }

    public void caosCalculator() {
        for (Dinosaurio dinos : dinosaurios) {
            //si los dinosaurios estan hambrientos aumenta
            if (dinos.salud < 25) {
                this.caos = this.caos + (int) Math.floor(Math.random() * 10) + 5;
            }
            //si el medio es distinto aumenta mucho mas
            if (dinos.medio != this.medio) {
                this.caos = this.caos + (int) Math.floor(Math.random() * 10) + 10;
            }
            if (dinos.alimentacion != this.alimentacion) {
                this.caos = this.caos + (int) Math.floor(Math.random() * 10) + 5;
            }
        }

        switch (this.tipoRecinto) {
            case VIDREO:
                this.caos = this.caos + 3;
                break;
            case MADERA:
                this.caos = this.caos + 5;
                break;
            case ELECTRIFICADO:
                this.caos = this.caos + 1;
                break;
        }
        this.caos = this.caos + ((int) Math.floor(Math.random() * 10));
    }

    public String infoRecintos() {

        return "MEDIO{" + this.medio + "} ALIMENTACION {" + this.alimentacion + "} HECTARIAS{" + this.hectarias + "} TIPO DE RECINTO{" + this.tipoRecinto + "} CAPACIDAD {" + this.capacidad + "}"
                + "DINOSAURIOS{" + dinosaurios + "}" + "id= " + this.id;
    }

    public void alimentarDinosaurios() {
        for (Dinosaurio dinosaurio : this.dinosaurios) {
            if (this.comida > 0) {
                if (dinosaurio.getHambre() > 0) {
                    dinosaurio.Alimentar(100 - dinosaurio.getHambre());
                    this.comida = this.comida - (100 - dinosaurio.getHambre());
                }
            } else {
                System.out.println("La instalacion no tiene comida");
            }
        }
    }

    @Override
    public abstract String toString();

}
