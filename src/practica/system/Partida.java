/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.system;

import practica.enums.Escenarios;

/**
 *
 * @author rodri
 */
public class Partida extends Entity {

    protected Player player;
    protected int mes;
    protected int id;

    public Partida(Escenarios escenario, String alias) {
        super();
        this.id = getID();
        this.mes = 0;
        this.player = new Player(escenario, alias);

    }

    public void pasarMes() {
        this.mes = this.mes + 1;
        this.player.pasarMes();
    }

    public int mesActual() {
        return this.mes;
    }
}
