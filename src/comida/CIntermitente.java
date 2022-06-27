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
public class CIntermitente extends Comida {

    /**
     *
     */
    private final int comidaInicial;

    /**
     *
     * @param duracion
     * @param comidaInicial
     * @throws ComidaException
     */
    public CIntermitente(int duracion, int comidaInicial) throws ComidaException {
        super(duracion);
        this.comidaInicial = comidaInicial;
    }

    /**
     *
     * @param diaN
     * @return the quantity of comida in diaN
     * @throws ComidaException
     */
    @Override
    public float getComidaDiaN(int diaN) throws ComidaException {
        //no hay que calcular nada, el getcomida n solo va a mostrar la comida inicial apra los numeros impares y 0 para los numeros pares
        float comida = 0;
        if (diaN % 2 == 0) {
            comida = 0;
        }
        if (diaN % 2 != 0) {
            comida = getComidaInicial();
        }
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
