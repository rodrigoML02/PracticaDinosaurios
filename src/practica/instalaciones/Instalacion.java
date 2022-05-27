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
import practica.system.exceptions.MuyJovenException;
import practica.system.exceptions.NoHayEspacioException;
import practica.system.exceptions.NoHayExistenciasException;

/**
 *
 * @author rodri
 */
public abstract class Instalacion extends Entity implements Comparable<Instalacion> {

    protected TipoIsla tipo;
    protected int id;
    protected int coste;
    protected Medio medio;
    protected Alimentacion alimentacion;
    protected int comida;
    protected int hectarias;
    protected TipoRecinto tipoRecinto;
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
            saludT = saludT + dinosaurio.getSalud();
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

    public void añadirDinosaurio(Dinosaurio dinosaurio) throws Exception {
        if (this.capacidad > 0) {
            if (dinosaurio.comprobadorVejez()) {
                this.dinosaurios.add(dinosaurio);
                this.capacidad = this.capacidad - 1;
            } else {
                throw new MuyJovenException();
            }
        } else {
            throw new NoHayEspacioException();
        }

    }

    public void eliminarDinosaurio(Dinosaurio dinosaurio) {
        this.dinosaurios.remove(dinosaurio);
        this.capacidad = this.capacidad + 1;
    }

    public void setCapacidad() {
        this.capacidad = this.capacidad - 1;
    }

    public String infoRecintos() {

        return "MEDIO{" + this.medio + "} ALIMENTACION {" + this.alimentacion + "} HECTARIAS{" + this.hectarias + "} TIPO DE RECINTO{" + this.tipoRecinto + "} CAPACIDAD {" + this.capacidad + "}"
                + "DINOSAURIOS{" + dinosaurios + "}" + "id= " + this.id;
    }

    public void alimentarDinosaurios() throws Exception {
        reOrdenarLista();
        for (Dinosaurio dinosaurio : this.dinosaurios) {
            if (this.comida > 0) {
                if (dinosaurio.getNivelHambre() < dinosaurio.getHambre()) {
                    int comidas = dinosaurio.getHambre() - dinosaurio.getNivelHambre();
                    dinosaurio.Alimentar(comidas);
                    this.comida = this.comida - comidas;
                    dinosaurio.recuperarSalud();
                }
            } else {
                throw new NoHayExistenciasException();
            }
        }
    }

    public void comprobaciónDinosaurios() {
        for (Dinosaurio dinosaurio : this.dinosaurios) {
            dinosaurio.pasarHambre();
            dinosaurio.crecer();
            dinosaurio.enfermar();
        }
    }

    public void reOrdenarLista() {
        Collections.sort(this.dinosaurios);
    }

    public boolean dinosaurioEn(Dinosaurio dinosaurio) {
        boolean estado = false;
        if (this.dinosaurios.contains(dinosaurio)) {
            estado = true;
        }
        return estado;
    }

    @Override
    public int compareTo(Instalacion o) {

        return this.getComida() - o.getComida();
    }

    @Override
    public abstract String toString();

}
