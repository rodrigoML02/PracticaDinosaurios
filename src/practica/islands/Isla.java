/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.islands;

import java.util.ArrayList;
import java.util.Collections;
import practica.enums.TipoIsla;
import practica.instalaciones.Instalacion;
import practica.system.Entity;

public abstract class Isla extends Entity {

    protected int hectareas;
    protected int comida;
    protected TipoIsla tipo;
    protected int id;
    protected ArrayList<Instalacion> instalaciones = new ArrayList<Instalacion>();

    public Isla(int hectareas, int comidaCapacidad, TipoIsla tipo) {
        super();
        this.id = getID();
        this.comida = comidaCapacidad;
        this.hectareas = hectareas;
        this.tipo = tipo;
    }

    //gETTER
    public int getIslaID() {
        return this.id;
    }

    public int getHectareas() {
        return this.hectareas;
    }

    public int getSizeArrray() {
        return this.instalaciones.size();
    }

    public int getComida() {
        return this.comida;
    }

    public TipoIsla getTipoisla() {
        return this.tipo;
    }

    //setters
    public void setComida(int comida) {

        this.comida = this.comida + comida;
    }

    public void setHectareas(int hectareas) {
        this.hectareas = this.hectareas - hectareas;
    }

    public void destruirInstalaciones(Instalacion instalacion) {
        this.instalaciones.remove(instalacion);
        setHectareas(-instalacion.getHectareas());
    }

    public void rellenarInstalaciones() {
        reOrdenarLista();
        for (Instalacion instalacion : this.instalaciones) {
            int max = instalacion.getCoste() - instalacion.getComida();
            if (max >= 0 & this.comida > 0) {
                instalacion.setComida(max);
                this.comida = this.comida - max;
            }
        }
    }

    public void reOrdenarLista() {
        Collections.sort(this.instalaciones);
    }

    public void comprobaciónDinosaurios() {
        for (Instalacion instalacion : this.instalaciones) {
            instalacion.comprobaciónDinosaurios();
        }
    }

    @Override
    public abstract String toString();

}
