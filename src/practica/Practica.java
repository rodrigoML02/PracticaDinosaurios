package practica;

import java.util.ArrayList;
import java.util.Collections;
import practica.dinosaurios.*;

/**
 *
 * @author rodri
 */
public class Practica {

    public static void main(String[] args) {

        ArrayList<Dinosaurio> desordenada = new ArrayList();

        Dinosaurio dino1 = new Velocirraptor("Juanjo");

        Dinosaurio dino2 = new Velocirraptor("paco");

        Dinosaurio dino3 = new Velocirraptor("pepe");

        Dinosaurio dino4 = new Velocirraptor("juan");

        Dinosaurio dino5 = new Velocirraptor("lola");

        desordenada.add(dino1);
        desordenada.add(dino2);
        desordenada.add(dino3);
        desordenada.add(dino4);
        desordenada.add(dino5);

        System.out.println(desordenada);

        Collections.sort(desordenada);

        System.out.println(desordenada);

    }
}
