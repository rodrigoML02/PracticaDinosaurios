package practica.system;

import java.util.ArrayList;
import practica.enums.*;
import practica.islands.Isla;
import practica.islands.islandTypes.islasDeCrianza.Sorna;
import practica.islands.islandTypes.islasDeExposicion.IslaMatanceros;
import practica.islands.islandTypes.islasDeExposicion.IslaNublar;
import practica.islands.islandTypes.islasDeExposicion.IslaSanDiego;
import practica.system.exceptions.NoHayEspacioException;
import practica.system.exceptions.PobrezaException;

/**
 *
 * @author rodri
 */
public class Player extends Entity {

    private int id;
    private String alias;
    private int coins;
    private ArrayList<Isla> Islas = new ArrayList<>();

    public Player(Escenarios escenario, String alias) {
        super();
        this.id = getID();
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

    public int getCoins() {
        return this.coins;
    }

    public void Setcoins(int coins) {
        this.coins = coins;
    }

    public Isla getIsla(int i) {
        return this.Islas.get(i);
    }

    @Override
    public String toString() {
        return "Player{" + "alias=" + alias + ", coins=" + coins + ", Islas=" + Islas + '}';
    }

    public void rellenarComidaIslas(int numIsla) throws Exception {
        int comidaMax = this.Islas.get(numIsla).getHectareas() * 3 - this.Islas.get(numIsla).getComida();
        if (this.coins < comidaMax) {
            throw new PobrezaException();
        }
        this.coins = this.coins - comidaMax * 5;
        this.Islas.get(numIsla).setComida(comidaMax);
    }

    public void rellenarComidaIslas(int numIsla, int comida) throws Exception {
        int comidaMax = this.Islas.get(numIsla).getHectareas() * 3 - (this.Islas.get(numIsla).getComida() + comida);
        if (comidaMax < 0) {
            throw new NoHayEspacioException();
        }
        if (this.coins < comidaMax) {
            throw new PobrezaException();
        }
        this.coins = this.coins - comidaMax * 5;
        this.Islas.get(numIsla).setComida(comidaMax);
    }

    public void rellenarInstalaciones(int index) {
        this.Islas.get(index).rellenarInstalaciones();
    }
}
