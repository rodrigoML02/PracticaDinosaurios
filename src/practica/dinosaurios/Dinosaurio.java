/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.dinosaurios;

import practica.enums.*;
import practica.system.Entity;

/**
 *
 *
 */
public abstract class Dinosaurio extends Entity {

    public Medio medio;
    public Alimentacion alimentacion;
    public int edad;
    public int edadProblematica;
    public int salud;
    public int favs;
    public String mote;
    public int hambre;
    public int iD;

    public Dinosaurio(String nombre, Medio medio, Alimentacion alimentacion, int edadProblematica) {
        super();
        this.mote = nombre;
        this.iD = this.getID();
        this.medio = medio;
        this.alimentacion = alimentacion;
        this.edad = 0;
        this.edadProblematica = edadProblematica;
        this.salud = 100;
        this.favs = 0;
        this.hambre = 100;
    }

    @Override
    public abstract String toString();

    public int getDinoID() {
        return this.iD;
    }

    public int getHambre() {
        return this.hambre;
    }

    public int getEdad() {
        return this.edad;
    }

    public int getSalud() {
        return this.salud;
    }

    public void Alimentar(int comida) {
        this.hambre = this.hambre + comida;

    }

    public void crecer() {
        this.edad++;
    }

    public boolean comprobadorVejez() {
        boolean viejo = false;
        if (this.edad == this.edadProblematica) {
            viejo = true;
        }
        return viejo;
    }

    public String moreInfo() {
        return "iD=" + this.iD + ", medio=" + medio + ", alimentacion=" + alimentacion + ", edad=" + edad + ", edadProblematica=" + edadProblematica + ", salud=" + salud + ", favs=" + favs + ", hambre=" + hambre + '}';
    }

}
