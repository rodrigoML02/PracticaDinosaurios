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
public abstract class Dinosaurio extends Entity implements Comparable<Dinosaurio> {

    protected Medio medio;
    protected Alimentacion alimentacion;
    protected int edad;
    protected int edadProblematica;
    protected int salud;
    protected int favs;
    protected String mote;
    protected int hambre;
    protected int iD;
    protected int apetito;
    protected int nivelDeHambre;

    public Dinosaurio(String nombre, Medio medio, Alimentacion alimentacion, int edadProblematica, int apetito) {
        super();
        this.mote = nombre;
        this.iD = this.getID();
        this.medio = medio;
        this.alimentacion = alimentacion;
        this.edad = 0;
        this.edadProblematica = edadProblematica;
        this.salud = 100;
        this.favs = 0;
        this.apetito = apetito;
    }

    @Override
    public abstract String toString();

    //GETTERS
    public String getMote() {
        return this.mote;
    }

    public Medio getMedio() {
        return this.medio;
    }

    public int getDinoID() {
        return this.iD;
    }

    public int getHambre() {
        return this.hambre;
    }

    public int getNivelHambre() {
        return this.nivelDeHambre;
    }

    public int getEdad() {
        return this.edad;
    }

    public int getEdaProblematica() {
        return this.getEdaProblematica();
    }

    public int getSalud() {
        return this.salud;
    }

    public int getFavs() {
        return this.favs;
    }

    //setters
    public void Alimentar(int comida) {
        this.nivelDeHambre = nivelDeHambre + comida;

    }

    public void cantidadAIngerir() {
        if (comprobadorVejez()) {
            if (this.edad >= 2 * this.edadProblematica) {
                this.hambre = this.apetito * 2 ^ (this.edad - this.edadProblematica);
            } else {
                this.hambre = this.apetito * 2 ^ (2 * this.edadProblematica);
            }
        } else {
            this.hambre = this.apetito * this.edad;
        }
    }

    public void crecer() {
        this.edad++;
    }

    public void cambiarNombre(String newMote) {
        this.mote = newMote;
    }

    public void setFavs(int favs) {
        this.favs = favs;
    }

    public void enfermar() {
        if (this.nivelDeHambre < 0.25 * this.hambre) {
            this.salud = this.salud - 30;
        } else if (this.nivelDeHambre < 0.75 * this.hambre) {
            this.salud = this.salud - 30;
        } else if (this.nivelDeHambre < this.hambre) {
            this.salud = this.salud - 5;
        }

    }

    public void recuperarSalud() {
        this.salud = this.salud + 5;
    }

    public boolean comprobadorVejez() {
        boolean viejo = false;
        if (this.edad >= this.edadProblematica) {
            viejo = true;
        }
        return viejo;
    }

    public String moreInfo() {
        return "iD=" + this.iD + ", medio=" + medio + ", alimentacion=" + alimentacion + ", edad=" + edad + ", edadProblematica=" + edadProblematica + ", salud=" + salud + ", favs=" + favs + ", hambre=" + hambre + '}';
    }

    @Override
    public int compareTo(Dinosaurio o) {

        return o.getSalud() - this.salud;
    }

}
