package practica.system;

import java.util.ArrayList;
import practica.enums.*;
import practica.islands.Isla;
import practica.islands.islandTypes.islasDeCrianza.Sorna;
import practica.islands.islandTypes.islasDeExposicion.IslaMatanceros;
import practica.islands.islandTypes.islasDeExposicion.IslaNublar;
import practica.islands.islandTypes.islasDeExposicion.IslaSanDiego;

/**
 *
 * @author rodri
 */
public class Player {

    private String alias;
    public int coins;
    public ArrayList<Isla> Islas = new ArrayList<>();

    public Player(Escenarios escenario, String alias) {
        this.alias = alias;
        Sorna islaDeCrianza = new Sorna();
        switch (escenario) {
            case JURASSIC_PARK:
                this.coins = 100000;
                IslaNublar islaDeExposicion = new IslaNublar();
                this.Islas.add(islaDeCrianza);
                this.Islas.add(islaDeExposicion);
                break;
            case SAN_DIEGO:
                this.coins = 50000;
                IslaSanDiego islaDeExposicion2 = new IslaSanDiego();
                this.Islas.add(islaDeCrianza);
                this.Islas.add(islaDeExposicion2);
                break;
            case JURASSIC_EVOLUTION:
                this.coins = 150000;
                IslaMatanceros islaDeExposicion3 = new IslaMatanceros();
                this.Islas.add(islaDeCrianza);
                this.Islas.add(islaDeExposicion3);
                break;
        }
    }

    @Override
    public String toString() {
        return "Player{" + "alias=" + alias + ", coins=" + coins + ", Islas=" + Islas + '}';
    }

}
