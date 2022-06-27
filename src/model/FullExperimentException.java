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
public class FullExperimentException extends Exception {

    enum ErroType {

        POSICION_ARRAY_NEGATIVO;
    };
    private final int i;
    private final ErroType error;

    FullExperimentException(int i, ErroType error) {
        this.i = i;
        this.error = error;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        switch (getError()) {
            case POSICION_ARRAY_NEGATIVO:
                return "No se puede acceder a la posición " + getI() + "del array";
            default:
                return "Se produjo algún error";
        }
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    /**
     * @return the error
     */
    public ErroType getError() {
        return error;
    }

}
