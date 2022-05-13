/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.instalaciones.instalacionesDeCria;

import practica.dinosaurios.Dinosaurio;
import practica.dinosaurios.tiposDeDinosaurios.Mosasaurus;
import practica.enums.Alimentacion;
import practica.enums.Medio;
import practica.enums.TipoRecinto;

/**
 *
 * @author rodri
 */
public class CAC4 extends InstalacionesDeCria {

    public CAC4() {

        super(3500, Medio.ACUATICO, Alimentacion.CARNIVORO, 100, 25, TipoRecinto.VIDREO, 4);
    }

    @Override
    public String toString() {
        return "INSTALACION DE CRIA CAC4";
    }

    @Override
    public Dinosaurio CrearDinosaurio(String mote) {
        Mosasaurus dinosaurio = new Mosasaurus("mote");
        return dinosaurio;
    }
}
