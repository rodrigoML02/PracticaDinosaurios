/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.system;

/**
 *
 * @author rodri
 */
public class Entity {

    private static int id;

    public Entity() {
        id++;
    }

    public int getID() {
        return id;
    }
}
