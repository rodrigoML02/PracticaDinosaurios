/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.system;

import java.io.Serializable;
import practica.islands.islandTypes.islasDeExposicion.Exposicion;

/**
 *
 * @author rodri
 */
public class Partida extends Entity implements Serializable {

    protected Player player;
    protected int mes;
    protected int id;

    public Partida(Player player) {
        super();
        this.id = getID();
        this.mes = 0;
        this.player = player;

    }

    public void pasarMes() {
        this.mes = this.mes + 1;
        this.player.pasarMes();
    }

    public int mesActual() {
        return this.mes;
    }

    @Override
    public String toString() {
        Exposicion isla = (Exposicion) player.getIsla(1);
        return "mes=" + mes + " Escenario: " + player.getEscenario() + "v isitantes: " + isla.getVisitantes();
    }

}
