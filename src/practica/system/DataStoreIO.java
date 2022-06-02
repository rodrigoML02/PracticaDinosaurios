/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author rodri
 */
public class DataStoreIO {

    public static final String FICHERO = "Dinosaurios-obj.dat";

    public Partida loadPartida() {
        File file = new File(FICHERO);

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        Partida DatastoreLeido = null;
        try {

            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);

            DatastoreLeido = (Partida) objectInputStream.readObject();

        } catch (Exception e) {
            System.out.println("Error al grabar");

        } finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar.");
            }
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar.");

            }
        }
        return DatastoreLeido;
    }

    public void savePartida(Partida partida) {
        File file = new File(FICHERO);

        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {

            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(partida);

        } catch (Exception e) {
            System.out.println("Error al grabar");
            e.printStackTrace();

        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar.");

            }
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar.");
            }
        }
    }
}
