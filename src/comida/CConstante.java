/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comida;

/**
 *
 * @author Dani
 */
public class CConstante extends Comida {

    private final int comidaInicial;

    /**
     *
     * @param duracion
     * @param comidaInicial
     * @throws ComidaException
     */
    public CConstante(int duracion, int comidaInicial) throws ComidaException {
        super(duracion);
        this.comidaInicial = comidaInicial;
    }

    /**
     *
     * @param diaN the day that we want to know the comida
     * @return how many comida
     * @throws ComidaException
     */
    @Override
    public float getComidaDiaN(int diaN) throws ComidaException {
        float comida;
        comida = getComidaInicial();
        return comida;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Comida: " + comidaInicial;
    }

    /**
     * @return the comidaInicial
     */
    public int getComidaInicial() {
        return comidaInicial;
    }
}
