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

    protected TipoIsla tipo;
    protected int id;
    protected int coste;
    protected Medio medio;
    protected Alimentacion alimentacion;
    protected int comida;
    protected int hectarias;
    protected TipoRecinto tipoRecinto;
    //indica como de probable es que haya caos un dinosaurio(0-100)
    protected int caos;
    protected int capacidad;
    protected ArrayList<Dinosaurio> dinosaurios = new ArrayList<>();

    public Instalacion(TipoIsla tipo, int coste, Medio medio, Alimentacion alimentacion, int comida, int hectareas, TipoRecinto tipoRecinto, int capacidad) {
        super();
        id = getID();
        this.alimentacion = alimentacion;
        this.capacidad = capacidad;
        this.comida = capacidad;
        this.coste = coste;
        this.medio = medio;
        this.hectarias = hectareas;
        this.tipo = tipo;
        this.tipoRecinto = tipoRecinto;
    }

    //getters
    public int getinstalacionID() {
        return this.id;
    }

    public Alimentacion getAlimentacion() {
        return this.alimentacion;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public int getCoste() {
        return this.coste;
    }

    public Medio getMedio() {
        return this.medio;
    }

    public int getComida() {
        return this.comida;
    }

    public TipoIsla getTipo() {
        return this.tipo;
    }

    public TipoRecinto getRecinto() {
        return this.tipoRecinto;
    }

    //setters
    public void setComida(int comida) {
        this.comida = comida;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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
