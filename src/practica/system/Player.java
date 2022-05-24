package practica.system;

import java.util.ArrayList;
import practica.dinosaurios.Dinosaurio;
import practica.enums.*;
import practica.instalaciones.Instalacion;
import practica.instalaciones.instalacionesDeCria.InstalacionesDeCria;
import practica.instalaciones.instalacionesDeExposicion.InstalacionesDeExposicion;
import practica.islands.Isla;
import practica.islands.islandTypes.islasDeCrianza.Cria;
import practica.islands.islandTypes.islasDeCrianza.Sorna;
import practica.islands.islandTypes.islasDeExposicion.Exposicion;
import practica.islands.islandTypes.islasDeExposicion.IslaMatanceros;
import practica.islands.islandTypes.islasDeExposicion.IslaNublar;
import practica.islands.islandTypes.islasDeExposicion.IslaSanDiego;
import practica.system.exceptions.*;

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

    public void moverDinosaurios(Dinosaurio dinosaurio, Instalacion instalacionObj, Instalacion instalacionDest) throws Exception {
        int lambda = 0;
        switch (instalacionObj.getMedio()) {
            case TERRESTRE:
                lambda = 5;
                break;
            case ACUATICO:
                lambda = 15;
                break;
            case VOLADOR:
                lambda = 30;
                break;
        }

        if (this.coins >= 100 * (3 * (dinosaurio.getEdad() - dinosaurio.getEdaProblematica())) * lambda) {
            if (instalacionObj.dinosaurioEn(dinosaurio)) {
                instalacionDest.añadirDinosaurio(dinosaurio);
                instalacionObj.eliminarDinosaurio(dinosaurio);
                this.coins = this.coins - (100 * (3 * (dinosaurio.getEdad() - dinosaurio.getEdaProblematica())) * lambda);
            } else {
                throw new NotFoundException();
            }
        } else {
            throw new PobrezaException();
        }
    }

    public void matarDinosaurios(Dinosaurio dinosaurio, Instalacion instalacionObj) throws Exception {
        if (this.coins >= 2000) {
            if (instalacionObj.dinosaurioEn(dinosaurio)) {
                instalacionObj.eliminarDinosaurio(dinosaurio);
            } else {
                throw new NotFoundException();
            }
        } else {
            throw new PobrezaException();
        }
    }

    public void construirInstalacion(int index, Instalacion instalacionNueva) throws Exception {
        boolean running = true;
        if (this.coins >= instalacionNueva.getCoste()) {
            while (running) {
                switch (index) {
                    case 0:

                        if (instalacionNueva instanceof InstalacionesDeCria) {
                            Cria isla = (Cria) this.Islas.get(index);
                            isla.construirInstalaciones((InstalacionesDeCria) instalacionNueva);
                            this.coins = this.coins - instalacionNueva.getCoste();
                        } else {
                            throw new TiposIncompatiblesException();
                        }
                        running = false;
                        break;
                    case 1:
                        if (instalacionNueva instanceof InstalacionesDeCria) {
                            Exposicion isla = (Exposicion) this.Islas.get(index);
                            isla.construirInstalaciones((InstalacionesDeExposicion) instalacionNueva);
                            this.coins = this.coins - instalacionNueva.getCoste();
                        } else {
                            throw new TiposIncompatiblesException();
                        }
                        running = false;
                        break;

                }
            }
        } else {
            throw new PobrezaException();
        }

    }
}
