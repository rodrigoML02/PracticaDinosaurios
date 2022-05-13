package practica;

import practica.dinosaurios.tiposDeDinosaurios.Branchiosaurus;
import practica.instalaciones.instalacionesDeCria.CAC4;

/**
 *
 * @author rodri
 */
public class Practica {

    public static void main(String[] args) {

        Branchiosaurus dinosaurio1 = new Branchiosaurus("paco");
        Branchiosaurus dinosaurio2 = new Branchiosaurus("antonio");

        CAC4 instalacion = new CAC4();
        instalacion.dinosaurios.add(dinosaurio1);
        instalacion.dinosaurios.add(dinosaurio2);
        instalacion.alimentarDinosaurios();

        System.out.println(instalacion.dinosaurios.get(0).hambre);
        System.out.println(instalacion.dinosaurios.get(1).hambre);
    }

}
