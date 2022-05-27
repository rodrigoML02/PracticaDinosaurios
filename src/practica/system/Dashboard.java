/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.system;

import practica.Utilidades;
import practica.enums.Escenarios;
import practica.islands.islandTypes.islasDeCrianza.Cria;
import practica.islands.islandTypes.islasDeExposicion.Exposicion;

/**
 *
 * @author rodri
 */
public class Dashboard {

    protected Partida partida;

    public Dashboard(Escenarios escenario, String mote) {
        partida = new Partida(escenario, mote);
    }

    public void mesaDeCOntrol() {
        String pregunta = ("QUE QUIERES VER:"
                + "         1: Islas"
                + "         2: Instalaciones"
                + "         3: Dinosaurios"
                + "         4: Informacion Partida"
                + "         5: Informacion Player"
                + "          6: Exist");
        int opc;
        String despedida = "SALIENDO DEL MENU";
        boolean running = true;
        while (running) {
            opc = Utilidades.leeEntero(pregunta);
            switch (opc) {
                case 1:
                    System.out.println("1 :" + partida.player.getIsla(0));
                    System.out.println("2 :" + partida.player.getIsla(0));
                    String cuestion = ("¿Quieres Ver instalaciones? Y/N");
                    boolean respuesta = Utilidades.yesOrNo(pregunta);
                    if (respuesta) {
                        opc = 2;
                    }
                    break;

                case 2:
                    imprimirInstalaciones();
                    cuestion = ("¿Quieres Ver los dinosaurios? Y/N");
                    respuesta = Utilidades.yesOrNo(pregunta);
                    if (respuesta) {
                        opc = 3;
                    }
                    break;

            }

        }
    }

    public void imprimirInstalaciones() {
        System.out.println("Instalaciones de cría");
        Cria isla = (Cria) partida.player.getIsla(0);
        for (int i = 0; i <= isla.getSizeArrray() - 1; i++) {
            System.out.println(isla.getInstalacion(i));
        }
        System.out.println(" ");
        System.out.println("Instalaciones de Exposicion");
        Exposicion isla2 = (Exposicion) partida.player.getIsla(1);
        for (int i = 0; i <= isla2.getSizeArrray() - 1; i++) {
            System.out.println(isla2.getInstalacion(i));
        }
    }
}
