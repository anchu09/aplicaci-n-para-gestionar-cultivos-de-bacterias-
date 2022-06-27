/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dani
 */
public class Bacteria {

    private int comidaacumulada;
    private final Posicion pos;
    Simulacion simulacion;

    public Bacteria(Posicion pos) {
        this.comidaacumulada = 0;
        this.pos = pos;
    }

    /**
     * @return the comidaacumulada
     */
    public int getComidaacumulada() {
        return comidaacumulada;
    }

    /**
     * @return the pos
     */
    public Posicion getPos() {
        return pos;
    }

    /**
     * @param comidaacumulada the comidaacumulada to set
     */
    public void setComidaacumulada(int comidaacumulada) {
        this.comidaacumulada = comidaacumulada;
    }

}
