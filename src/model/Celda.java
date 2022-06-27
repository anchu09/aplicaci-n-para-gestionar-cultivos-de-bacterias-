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
public class Celda {

    private int numerobacterias;
    private int cantidadcomida;

    public Celda(int cantidadcomida, int numerobacterias) {
        this.cantidadcomida = cantidadcomida;
        this.numerobacterias = numerobacterias;
    }

    /**
     * @return the numerobacterias
     */
    public int getNumerobacterias() {
        return numerobacterias;
    }

    /**
     * @param numerobacterias the numerobacterias to set
     */
    public void setNumerobacterias(int numerobacterias) {
        this.numerobacterias = numerobacterias;
    }

    /**
     * @return the cantidadcomida
     */
    public int getCantidadcomida() {
        return cantidadcomida;
    }

    /**
     * @param cantidadcomida the cantidadcomida to set
     */
    public void setCantidadcomida(int cantidadcomida) {
        this.cantidadcomida = cantidadcomida;
    }

}
