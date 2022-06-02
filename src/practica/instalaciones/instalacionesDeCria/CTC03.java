/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.instalaciones.instalacionesDeCria;

import practica.dinosaurios.Dinosaurio;
import practica.dinosaurios.TyrannosaurusRex;
import practica.dinosaurios.Velocirraptor;
import practica.enums.Alimentacion;
import practica.enums.Medio;
import practica.enums.TipoRecinto;

/**
 *
 * @author rodri
 */
public class CTC03 extends InstalacionesDeCria {

    public CTC03() {

        super(2500, Medio.TERRESTRE, Alimentacion.CARNIVORO, 300, 50, TipoRecinto.ELECTRIFICADO, 3);

    }

    @Override
    public String toString() {
        return "INSTALACION DE CRIA CTC03    " + this.coste + "$";
    }

    @Override
    public Dinosaurio CrearDinosaurio(String mote) {
        Dinosaurio dinosaurio;
        int dados = (int) Math.floor(Math.random() * 10);
        if (dados >= 0 & dados <= 5) {
            dinosaurio = new TyrannosaurusRex(mote);
        } else {
            dinosaurio = new Velocirraptor(mote);
        }

        return dinosaurio;
    }

}
