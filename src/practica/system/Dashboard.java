package practica.system;

import java.io.Serializable;
import java.util.ArrayList;
import practica.Utilidades;
import practica.dinosaurios.Dinosaurio;
import practica.instalaciones.Instalacion;
import practica.instalaciones.instalacionesDeCria.*;
import practica.instalaciones.instalacionesDeExposicion.*;
import practica.islands.islandTypes.islasDeCrianza.Cria;
import practica.islands.islandTypes.islasDeExposicion.Exposicion;

/**
 *
 * @author rodri
 */
public class Dashboard implements Serializable {

    protected Partida partida;
    ArrayList<String> ordenes;

    public Dashboard(Partida partida) {
        this.partida = partida;
        ordenes = new ArrayList();
    }

    public Partida getPartida() {
        return this.partida;
    }

    public void menuDelJuego() {
        String pregunta = "1: Tienda"
                + "\n2: Mesa De Control"
                + "\n3: Pasar mes"
                + "\n4 Ver Histotial"
                + "\n5: Guardar Partida"
                + "\n6: Salir del juego";

        boolean running = true;
        String orden;
        while (running) {
            int eleccion;
            do {
                eleccion = Utilidades.leeEntero(pregunta);
            } while (eleccion < 0 | eleccion > 5);

            switch (eleccion) {
                case 1:
                    tienda();
                    break;
                case 2:
                    mesaDeCOntrol();
                    break;
                case 3:
                    System.out.println("**********PASANDO MES***********");
                    this.partida.pasarMes();
                    orden = "NUEVO MES";
                    this.ordenes.add(orden);
                    break;
                case 4:
                    for (String frases : this.ordenes) {
                        System.out.println(frases);
                    }
                    break;
                case 5:
                    DataStoreIO dataStoreIO = new DataStoreIO();
                    dataStoreIO.savePartida(this.partida);
                    System.out.println("Partida guardada con exito");
                    orden = "Partida guardada con exito";
                    this.ordenes.add(orden);
                    break;
                case 6:
                    String seguridad = "Se perderan todos los datos esta seguro de que quiere salir?(Y/N)";
                    boolean respuesta = Utilidades.yesOrNo(seguridad);
                    if (respuesta) {
                        System.out.println("MUCHAS GRACIAS POR JUGAR");
                        running = false;
                    }
                    break;
            }
        }
    }

    public void tienda() {
        String pregunta = "1: Construir instalaciones"
                + "\n2: Crear Dinosaurios"
                + "\n3: Rellenar comida islas"
                + "\n4: Mover DInosaurios"
                + "\n5: Matar Dinosaurios"
                + "\n6: EXIT";
        int opcion;

        boolean running = true;
        while (running) {
            do {
                opcion = Utilidades.leeEntero(pregunta);
            } while (opcion < 0 | opcion > 6);

            try {
                if (opcion == 1) {
                    construirInstalacion();
                } else if (opcion == 2) {
                    crearDinosaurios();
                } else if (opcion == 3) {
                    rellenarComidaIslas();
                } else if (opcion == 4) {
                    moverDinosaurio();
                } else if (opcion == 5) {
                    matarDinosaurio();
                } else if (opcion == 6) {
                    System.out.println("SALIENDO AL MENU");
                    running = false;
                }

            } catch (Exception e) {

                Utilidades.detectorDeExceptions(e);

            }
        }

    }

    public void mesaDeCOntrol() {
        String pregunta = ("QUE QUIERES VER:"
                + "         1: Islas"
                + "         2: Instalaciones"
                + "         3: Dinosaurios"
                + "         4: Informacion Partida"
                + "         5: Informacion Player"
                + "         6: Exit");
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

                    break;

                case 2:
                    imprimirInstalaciones();

                    break;

                case 3:
                    imprimirDinosaurios();
                    break;
                case 4:
                    System.out.println(this.partida);
                    break;
                case 5:
                    System.out.println("Coins: " + this.partida.player.getCoins());
                    System.out.println("Nombre: " + this.partida.player.getNombre());
                    break;
                case 6:
                    System.out.println("SALIENDO DEL MENU");
                    running = false;
                    break;
            }

        }
    }

    public void imprimirInstalaciones() {
        System.out.println("Instalaciones de cría");
        Cria isla = (Cria) partida.player.getIsla(0);
        int count = 0;
        for (int i = 0; i <= isla.getSizeArrray() - 1; i++) {
            System.out.println(count + " " + isla.getInstalacion(i));
            count++;
        }
        System.out.println(" ");
        System.out.println("Instalaciones de Exposicion");
        Exposicion isla2 = (Exposicion) partida.player.getIsla(1);
        for (int i = 0; i <= isla2.getSizeArrray() - 1; i++) {
            System.out.println(count + " " + isla2.getInstalacion(i));
            count++;
        }
    }

    public void imprimirInstalacionesDeCria() {
        System.out.println("Instalaciones de cría");
        Cria isla = (Cria) partida.player.getIsla(0);
        int count = 0;
        for (int i = 0; i <= isla.getSizeArrray() - 1; i++) {
            System.out.println(count + " " + isla.getInstalacion(i));
            count++;
        }
    }

    public void imprimirDinosaurios() {
        System.out.println("Instalaciones de cría");
        Cria isla = (Cria) partida.player.getIsla(0);
        int count = 0;
        for (int i = 0; i <= isla.getSizeArrray() - 1; i++) {
            System.out.println(isla.getInstalacion(i));
            for (int j = 0; j <= isla.getInstalacion(i).getArraySize() - 1; j++) {
                System.out.println(count + "" + isla.getInstalacion(i).getDinosaurios(j));
                System.out.println(isla.getInstalacion(i).getDinosaurios(j).moreInfo());

                count++;
            }
        }
        System.out.println(" ");
        System.out.println("Instalaciones de Exposicion");
        Exposicion isla2 = (Exposicion) partida.player.getIsla(1);
        for (int i = 0; i <= isla2.getSizeArrray() - 1; i++) {
            System.out.println(isla2.getInstalacion(i));
            for (int j = 0; j <= isla2.getInstalacion(i).getArraySize() - 1; j++) {
                System.out.println(count + " " + isla2.getInstalacion(i).getDinosaurios(j));
                count++;
            }
        }
    }

    public int preguntarInstalacionDeCria() {
        String pregunta = "Elige una instalacion: ";
        System.out.println("introduce 100 para salir");
        imprimirInstalacionesDeCria();
        int eleccion;
        do {
            eleccion = Utilidades.leeEntero(pregunta);
        } while (eleccion < 0 | (eleccion > (this.partida.player.getIsla(0).getSizeArrray()) & eleccion != 100));
        return eleccion;
    }

    public Instalacion preguntarInstalacion() {
        String pregunta = "Elige una instalacion:";
        imprimirInstalaciones();
        System.out.println("introduce 100 para salir");
        int eleccion;
        do {
            eleccion = Utilidades.leeEntero(pregunta);
        } while (eleccion < 0 | (eleccion > (this.partida.player.getIsla(0).getSizeArrray() + this.partida.player.getIsla(1).getSizeArrray() - 1) & eleccion != 100));
        Instalacion instalacion;
        if (eleccion == 100) {
            instalacion = null;
        } else if (eleccion < this.partida.player.getIsla(0).getSizeArrray()) {
            instalacion = this.partida.player.getIsla(0).getInstalacion(eleccion);
        } else {
            instalacion = this.partida.player.getIsla(1).getInstalacion(eleccion - this.partida.player.getIsla(0).getSizeArrray());
        }
        return instalacion;
    }

    public Dinosaurio preguntarDinosaurio(Instalacion instalacion) {
        for (int i = 0; i < instalacion.getArraySize(); i++) {
            System.out.println(i + ":" + instalacion.getDinosaurios(i));
        }
        int eleccion;
        String pregunta = "Escoge un dinosaurio";
        do {
            eleccion = Utilidades.leeEntero(pregunta);
        } while (eleccion >= instalacion.getCapacidad() | eleccion < 0);
        Dinosaurio dinosaurio;
        dinosaurio = instalacion.getDinosaurios(eleccion);
        return dinosaurio;
    }

    public void matarDinosaurio() throws Exception {
        String pregunta = "¿De QUE INSTALACION QUIERES MATAR AL DINOSAURIO DINOSAURIO ?";
        System.out.println(pregunta);
        Instalacion instalacion;
        instalacion = preguntarInstalacion();
        Dinosaurio dinosaurio;
        boolean running = true;
        while (running) {
            if (instalacion.getArraySize() != 0) {
                pregunta = "¿Que dinosaurio quieres ASESINAR?";
                System.out.println(pregunta);
                dinosaurio = preguntarDinosaurio(instalacion);
                this.partida.player.matarDinosaurios(dinosaurio, instalacion);
                String orden = dinosaurio + " ASESINADO";
                this.ordenes.add(orden);
            } else {
                System.out.println("");
                System.out.println("");
                System.out.println("no hay dinosaurios en esta instalacion");
                System.out.println("");
                System.out.println("");
                instalacion = preguntarInstalacion();
            }
        }
    }

    public void moverDinosaurio() throws Exception {
        String pregunta = "¿De QUE INSTALACION QUIERES MOVER AL DINOSAURIO DINOSAURIO ?";
        System.out.println(pregunta);
        Instalacion instalacion;
        instalacion = preguntarInstalacion();
        Dinosaurio dinosaurio;
        boolean running = true;
        while (running) {
            if (instalacion.getArraySize() != 0) {
                pregunta = "¿Que dinosaurio quieres mover?";
                System.out.println(pregunta);
                dinosaurio = preguntarDinosaurio(instalacion);
                Instalacion instalaciondest;
                System.out.println("");
                System.out.println("");
                pregunta = "¿A donde lo quieres mover?";
                System.out.println("");
                System.out.println("");
                System.out.println(pregunta);
                instalaciondest = preguntarInstalacion();
                this.partida.player.moverDinosaurios(dinosaurio, instalacion, instalaciondest);
                String orden = dinosaurio + " Movido con exito a " + instalaciondest;
                this.ordenes.add(orden);
                running = false;
            } else {
                System.out.println("");
                System.out.println("");
                System.out.println("no hay dinosaurios en esta instalacion");
                System.out.println("");
                System.out.println("");
                instalacion = preguntarInstalacion();
            }
        }

    }

    public void crearDinosaurios() throws Exception {
        String pregunta = "En que instalacion quieres crearlo?";
        System.out.println(pregunta);
        int instalacion = preguntarInstalacionDeCria();
        if (instalacion == 100) {
            System.out.println("SALIENDO AL MENU");
        } else {
            pregunta = "¿COMO QUIERES LLAMARLO?";
            String nombre = Utilidades.LeerFrase(pregunta);
            Dinosaurio dino = this.partida.player.crearDinosaurio(instalacion, nombre);
            if (dino == null) {
                System.out.println("NO ha nacido");
            } else {
                System.out.println("Dinosaurio creado con exito");
                String orden = "DINOSAURIO CREADO" + " (" + dino + ")";
                this.ordenes.add(orden);
            }
        }
    }

    public void construirInstalacion() throws Exception {
        Instalacion instalacion1 = new CAC4();
        Instalacion instalacion2 = new CTC03();
        Instalacion instalacion3 = new CTH05();
        Instalacion instalacion4 = new CVC02();
        Instalacion instalacion5 = new EAC03();
        Instalacion instalacion6 = new ETC02();
        Instalacion instalacion7 = new ETH02();
        Instalacion instalacion8 = new EVC02();

        String pregunta = "1: " + instalacion1 + " "
                + "\n2: " + instalacion2 + " "
                + "\n3: " + instalacion3 + " "
                + "\n4: " + instalacion4 + " "
                + "\n5: " + instalacion5 + ""
                + "\n6: " + instalacion6 + ""
                + "\n7: " + instalacion7 + ""
                + "\n8: " + instalacion8 + ""
                + "\n9: EXIT";
        int opcion;

        boolean running = true;
        while (running == true) {
            String orden = "";
            do {
                opcion = Utilidades.leeEntero(pregunta);
            } while (opcion <= 0 | opcion > 9);
            switch (opcion) {
                case 1:
                    this.partida.player.construirInstalacion(0, instalacion1);
                    orden = "Instalacion construida" + " (" + instalacion1 + ")";
                    this.ordenes.add(orden);
                    break;
                case 2:
                    this.partida.player.construirInstalacion(0, instalacion2);
                    orden = "Instalacion construida" + " (" + instalacion2 + ")";
                    this.ordenes.add(orden);
                    break;
                case 3:
                    this.partida.player.construirInstalacion(0, instalacion3);
                    orden = "Instalacion construida" + " (" + instalacion3 + ")";
                    this.ordenes.add(orden);
                    break;
                case 4:
                    this.partida.player.construirInstalacion(0, instalacion4);
                    orden = "Instalacion construida" + " (" + instalacion4 + ")";
                    this.ordenes.add(orden);
                    break;
                case 5:
                    this.partida.player.construirInstalacion(1, instalacion5);
                    orden = "Instalacion construida" + " (" + instalacion5 + ")";
                    this.ordenes.add(orden);
                    break;
                case 6:
                    this.partida.player.construirInstalacion(1, instalacion6);
                    orden = "Instalacion construida" + " (" + instalacion6 + ")";
                    this.ordenes.add(orden);
                    break;
                case 7:
                    this.partida.player.construirInstalacion(1, instalacion7);
                    orden = "Instalacion construida" + " (" + instalacion7 + ")";
                    this.ordenes.add(orden);
                    break;
                case 8:
                    this.partida.player.construirInstalacion(1, instalacion8);
                    orden = "Instalacion construida" + " (" + instalacion8 + ")";
                    this.ordenes.add(orden);
                    break;
                case 9:
                    running = false;
                    System.out.println("Saliendo al menu");
                    break;
            }
        }
    }

    public void rellenarComidaIslas() throws Exception {
        String pregunta = "¿QUE ISLA QUIERES RELLENAR?"
                + "\n0: Isla De Cria"
                + "\n1: Isla De Exhibicion"
                + "\n2: EXIT";

        int isla;
        String orden;
        do {
            isla = Utilidades.leeEntero(pregunta);
        } while (isla > 2 | isla < 0);
        if (isla < 2) {
            pregunta = "Quieres rellenarla por completo?(Y/N)";
            boolean eleccion = Utilidades.yesOrNo(pregunta);
            if (eleccion) {
                this.partida.player.rellenarComidaIslas(isla);
                this.partida.player.rellenarInstalaciones(isla);
                orden = "COMIDA " + isla + " RELLENADA";
                this.ordenes.add(orden);
            } else {
                pregunta = "¿Cuanto quieres rellenar?";
                int cantidad;
                cantidad = Utilidades.leeEntero(pregunta);
                this.partida.player.rellenarComidaIslas(isla, cantidad);
                this.partida.player.rellenarInstalaciones(isla);
                orden = "COMIDA " + isla + " RELLENADA";
                this.ordenes.add(orden);
            }
        } else {
            System.out.println("Saliendo al menu");
        }
    }

}
