/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.instalaciones;

import java.util.ArrayList;
import java.util.Collections;
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
    public Dinosaurio getDinosaurios(int num) {

        return this.dinosaurios.get(num);
    }

    public int getinstalacionID() {
        return this.id;
    }

    public Alimentacion getAlimentacion() {
        return this.alimentacion;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public int getHectareas() {
        return this.hectarias;
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

    public int getSaludMedia() {
        int saludT = 0;
        int saludM;
        int contador = 0;
        for (Dinosaurio dinosaurio : this.dinosaurios) {
            saludT = saludT + dinosaurio.getHambre();
            contador++;

        }
        saludM = saludT / contador;
        return saludM;
    }

    public TipoIsla getTipo() {
        return this.tipo;
    }

    public TipoRecinto getRecinto() {
        return this.tipoRecinto;
    }

    //setters
    public void setComida(int comida) {
        this.comida = this.comida + comida;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String infoRecintos() {

        return "MEDIO{" + this.medio + "} ALIMENTACION {" + this.alimentacion + "} HECTARIAS{" + this.hectarias + "} TIPO DE RECINTO{" + this.tipoRecinto + "} CAPACIDAD {" + this.capacidad + "}"
                + "DINOSAURIOS{" + dinosaurios + "}" + "id= " + this.id;
    }

    public void alimentarDinosaurios() {
        reOrdenarLista();
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

    public void reOrdenarLista() {
        Collections.sort(this.dinosaurios);
    }

    @Override
    public abstract String toString();

}
