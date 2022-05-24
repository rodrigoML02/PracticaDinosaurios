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
    protected static int mes;
    protected int id;

    public Partida(Escenarios escenario, String alias) {
        super();
        id = getID();
        mes = 0;
        player = new Player(escenario, alias);

    }

    public void pasarMes() {
        Partida.mes = Partida.mes + 1;
    }

    public int mesActual() {
        return Partida.mes;
    }
}
