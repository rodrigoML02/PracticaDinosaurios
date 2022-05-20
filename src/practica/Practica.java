package practica;

import java.util.ArrayList;

/**
 *
 * @author rodri
 */
public class Practica {

    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList();
        lista.add("a");
        lista.add("e");
        lista.add("i");
        lista.add("o");
        lista.add("u");
        System.out.println(lista);
        lista.remove(4);
        System.out.println(lista);
    }
}
