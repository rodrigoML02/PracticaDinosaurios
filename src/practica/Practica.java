package practica;

import practica.enums.Escenarios;
import practica.system.Dashboard;
import practica.system.DataStoreIO;
import practica.system.Partida;
import practica.system.Player;

/**
 *
 * @author rodri
 */
public class Practica {

    public static void main(String[] args) {
        String pregunta = "1: Cargar Partida"
                + "\n2: Nueva Partida"
                + "\n3: Cerrar el juego";

        int answer = 0;
        boolean playing = true;
        Partida partida;
        Player player;
        Dashboard dashboard = null;
        DataStoreIO datastore = new DataStoreIO();
        String question;

        do {
            answer = Utilidades.leeEntero(pregunta);
        } while (answer > 3 | answer < 1);

        switch (answer) {
            case 1:

                partida = datastore.loadPartida();
                if (partida == null) {
                    question = "¿Como te llamas?";
                    String nombre = Utilidades.LeerFrase(question);
                    System.out.println("¿EN QUE ESCENARIO QUIERES JUGAR?");
                    question = " JURASSIC PARK"
                            + "\n SAN DIEGO"
                            + "\n JURASSIC EVOLUTION";
                    Escenarios mapa = Utilidades.leeEscenario(question);
                    player = new Player(mapa, nombre);
                    partida = new Partida(player);
                    dashboard = new Dashboard(partida);
                } else {
                    dashboard = new Dashboard(partida);

                }
                break;

            case 2:
                question = "¿Como te llamas?";
                String nombre = Utilidades.LeerFrase(question);
                System.out.println("¿EN QUE ESCENARIO QUIERES JUGAR?");
                question = " JURASSIC PARK"
                        + "\n SAN DIEGO"
                        + "\n JURASSIC REVOLUTION";
                Escenarios mapa = Utilidades.leeEscenario(question);
                player = new Player(mapa, nombre);
                partida = new Partida(player);
                dashboard = new Dashboard(partida);
                break;

            case 3:
                playing = false;
                break;

        }

        if (playing == true) {
            dashboard.menuDelJuego();
        }
    }
}
