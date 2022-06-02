/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.system;

import java.io.Serializable;

/**
 *
 * @author rodri
 */
public abstract class Entity implements Serializable {

    private static int id;

    public Entity() {
        id++;
    }

    public int getID() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Entity other = (Entity) obj;
        return this.id == other.getID();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

}
