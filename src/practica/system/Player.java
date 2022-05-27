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
    private ArrayList<Isla> islas = new ArrayList<>();
    protected Dashboard dashboard;

    public Player(Escenarios escenario, String alias) {
        super();
        this.id = getID();
        this.alias = alias;
        Sorna islaDeCrianza = new Sorna();
        switch (escenario) {
            case JURASSIC_PARK:
                this.coins = 100000;
                IslaNublar islaDeExposicion = new IslaNublar();
                this.islas.add(islaDeCrianza);
                this.islas.add(islaDeExposicion);
                break;
            case SAN_DIEGO:
                this.coins = 50000;
                IslaSanDiego islaDeExposicion2 = new IslaSanDiego();
                this.islas.add(islaDeCrianza);
                this.islas.add(islaDeExposicion2);
                break;
            case JURASSIC_EVOLUTION:
                this.coins = 150000;
                IslaMatanceros islaDeExposicion3 = new IslaMatanceros();
                this.islas.add(islaDeCrianza);
                this.islas.add(islaDeExposicion3);
                break;
        }
    }

    public int getCoins() {
        return this.coins;
    }

    public Isla getIsla(int i) {
        return this.islas.get(i);
    }

    @Override
    public String toString() {
        return "Player{" + "alias=" + alias + ", coins=" + coins + ", Islas=" + islas + '}';
    }

    public void rellenarComidaIslas(int numIsla) throws Exception {
        int comidaMax = this.islas.get(numIsla).getHectareas() * 3 - this.islas.get(numIsla).getComida();
        if (this.coins < 5 * comidaMax) {
            throw new PobrezaException();
        } else {
            this.coins = this.coins - comidaMax * 5;
            this.islas.get(numIsla).setComida(comidaMax);
            rellenarInstalaciones(numIsla);
        }

    }

    public void rellenarComidaIslas(int numIsla, int comida) throws Exception {
        int comidaMax = this.islas.get(numIsla).getHectareas() * 3 - (this.islas.get(numIsla).getComida() + comida);
        if (comidaMax < 0) {
            throw new NoHayEspacioException();
        } else {
            if (this.coins < 5 * comidaMax) {
                throw new PobrezaException();
            } else {
                this.coins = this.coins - comidaMax * 5;
                this.islas.get(numIsla).setComida(comidaMax);
                rellenarInstalaciones(id);
            }

        }
    }

    public void rellenarInstalaciones(int index) {
        this.islas.get(index).rellenarInstalaciones();
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
        if (this.coins >= instalacionNueva.getCoste()) {
            switch (index) {
                case 0:
                    if (instalacionNueva instanceof InstalacionesDeCria) {
                        Cria isla = (Cria) this.islas.get(index);
                        isla.construirInstalaciones((InstalacionesDeCria) instalacionNueva);
                        this.coins = this.coins - instalacionNueva.getCoste();
                    } else {
                        throw new TiposIncompatiblesException();
                    }

                    break;
                case 1:
                    if (instalacionNueva instanceof InstalacionesDeCria) {
                        Exposicion isla = (Exposicion) this.islas.get(index);
                        isla.construirInstalaciones((InstalacionesDeExposicion) instalacionNueva);
                        this.coins = this.coins - instalacionNueva.getCoste();
                    } else {
                        throw new TiposIncompatiblesException();
                    }
                    break;

            }

        } else {
            throw new PobrezaException();
        }

    }

    public void crearDinosaurio(int numInstalacion, String mote) throws Exception {
        if (this.coins >= 200) {
            Cria isla = (Cria) getIsla(0);
            isla.getInstalacion(numInstalacion).CreadordeDinos(mote);
        } else {
            throw new PobrezaException();
        }
    }

    public void pasarMes() {
        for (Isla isla : this.islas) {
            isla.comprobaciónDinosaurios();
            if (isla instanceof Exposicion) {
                Exposicion islaE = (Exposicion) isla;
                islaE.abandonoDeVisitantes();
                islaE.llegadaDeVisitantes();
                this.coins = this.coins + islaE.gananciasIsla();
            }
        }
    }

}
