/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import comida.ComidaException;

/**
 *
 * @author Dani
 */
public class Posicion {

    private int posicioninicialX;
    private int posicioninicialY;
    private int comidaenposicion;

    public Posicion(int posicioninicial1, int posicioninicial2) throws ComidaException {
        this.posicioninicialX = posicioninicial1;
        this.posicioninicialY = posicioninicial2;
    }

    /**
     * @return the posicioninicialX
     */
    public int getPosicioninicialX() {
        return posicioninicialX;
    }

    /**
     * @param posicioninicialX the posicioninicialX to set
     */
    public void setPosicioninicialX(int posicioninicialX) {
        this.posicioninicialX = posicioninicialX;
    }

    /**
     * @return the posicioninicialY
     */
    public int getPosicioninicialY() {
        return posicioninicialY;
    }

    /**
     * @param posicioninicialY the posicioninicialY to set
     */
    public void setPosicioninicialY(int posicioninicialY) {
        this.posicioninicialY = posicioninicialY;
    }

    /**
     * @return the comidaenposicion
     */
    public int getComidaenposicion() {
        return comidaenposicion;
    }

    /**
     * @param comidaenposicion the comidaenposicion to set
     */
    public void setComidaenposicion(int comidaenposicion) {
        this.comidaenposicion = comidaenposicion;
    }

}
