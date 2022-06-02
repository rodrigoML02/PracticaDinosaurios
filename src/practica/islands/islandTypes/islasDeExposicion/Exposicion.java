/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica.islands.islandTypes.islasDeExposicion;

import practica.enums.*;
import practica.instalaciones.Instalacion;
import practica.instalaciones.instalacionesDeExposicion.InstalacionesDeExposicion;
import practica.islands.Isla;
import practica.system.exceptions.NoHayEspacioException;

/**
 *
 * @author rodri
 */
public abstract class Exposicion extends Isla {

    protected int visitantes;
    protected NivelAdquisitivo nivelAdquisitivo;

    public Exposicion(int hectareas, int comida, int visitantes, NivelAdquisitivo nivelAdquisitivo) {
        super(hectareas, comida, TipoIsla.EXHIBICION);
        this.visitantes = visitantes;
        this.nivelAdquisitivo = nivelAdquisitivo;
    }

    //getters
    public int getVisitantes() {
        return this.visitantes;
    }

    public NivelAdquisitivo getNivelAdquisitivo() {
        return this.nivelAdquisitivo;
    }

    //setter
    public void setVisitas(int visitas) {
        this.visitantes = visitas;
    }

    public InstalacionesDeExposicion getInstalacion(int num) {
        InstalacionesDeExposicion instalacionDeExposicion = null;
        if (this.instalaciones.get(num).getTipo() == this.tipo) {
            instalacionDeExposicion = (InstalacionesDeExposicion) this.instalaciones.get(num);
        }
        return instalacionDeExposicion;
    }

    public void construirInstalaciones(InstalacionesDeExposicion instalacionNueva) throws Exception {
        if (this.hectareas >= instalacionNueva.getHectareas()) {
            this.instalaciones.add(instalacionNueva);
            this.hectareas = this.hectareas - instalacionNueva.getHectareas();
        } else {
            throw new NoHayEspacioException();
        }
    }

    @Override
    public abstract String toString();

    public void llegadaDeVisitantes() {
        //llegada
        int visitante;
        int hectareasT = 0;
        int saludT = 0;
        int saludM;
        int contador = 0;
        for (Instalacion instalacion : this.instalaciones) {
            hectareasT = hectareasT + instalacion.getHectareas();
            saludT = saludT + instalacion.getSaludMedia();
            contador++;
        }
        if (contador == 0) {
            saludM = 0;
        } else {
            saludM = saludT / contador;
        }

        visitante = ((this.visitantes * hectareasT) / this.hectareas) * saludM / 100;
        this.visitantes = this.visitantes + visitante;
    }

    public void abandonoDeVisitantes() {
        int visitas;
        int hectareasT = 0;
        int saludT = 0;
        int saludM;
        int contador = 0;
        for (Instalacion instalacion : this.instalaciones) {
            hectareasT = hectareasT + instalacion.getHectareas();
            saludT = saludT + instalacion.getSaludMedia();
            contador++;
        }
        if (contador == 0) {
            saludM = 0;
        } else {
            saludM = saludT / contador;
        }
        visitas = this.visitantes - ((this.visitantes * hectareasT) / this.hectareas) * saludM / 100;
        if (this.visitantes - visitas < 0) {
            this.visitantes = 0;
        } else {
            this.visitantes = this.visitantes - visitas;
        }
    }

    public int gananciasIsla() {
        int donacion = 0;
        int lambda = 0;
        switch (this.nivelAdquisitivo) {
            case ALTO:
                lambda = 30;
                break;
            case BAJO:
                lambda = 1;
                break;
            case MEDIO:
                lambda = 15;
                break;
        }
        for (int j = 0; j <= this.visitantes; j++) {
            for (Instalacion instalacion : this.instalaciones) {
                for (int i = 0; i <= instalacion.getArraySize() - 1; i++) {
                    int pasta = 10 * instalacion.getDinosaurios(i).getEdad() * (instalacion.getDinosaurios(i).getSalud() / 100) * lambda;
                    instalacion.getDinosaurios(i).setFavs(pasta);
                    donacion = donacion + pasta;
                }
            }
        }
        return donacion;
    }

}
