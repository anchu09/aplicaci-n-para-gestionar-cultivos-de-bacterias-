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
public class ComidaException extends Exception {

    enum ErroType {

        COMIDAINICIAL_NO_VALIDA, COMIDAFINAL_NO_VALIDA, COMIDADIAINTERMEDIO_NO_VALIDA, DIAINTERMEDIO_NO_VALIDO, DIAINCREMENTO_NO_VALIDO
    };
    private final int diaIntermedio;
    private float comidaInicial;
    private final float comidaDiaIntermedio;
    private final float comidaFinal;
    private final int diaN;
    private final ErroType error;

    ComidaException(int diaIntermedio, float comidaInicial, float comidaDiaIntermedio, float comidaFinal, int diaN, ErroType error) {
        this.diaIntermedio = diaIntermedio;
        this.comidaDiaIntermedio = comidaDiaIntermedio;
        this.comidaFinal = comidaFinal;
        this.diaN = diaN;
        this.error = error;
    }

    /**
     *
     * @return the exception
     */
    @Override
    public String toString() {
        switch (getError()) {
            case COMIDAINICIAL_NO_VALIDA:
                return "La comida inicial no es válida ( " + comidaInicial + " )";
            case COMIDAFINAL_NO_VALIDA:
                return "La comida final no es válida ( " + comidaFinal + " )";
            case COMIDADIAINTERMEDIO_NO_VALIDA:
                return "La comida del dia intermedio no es válida ( " + comidaDiaIntermedio + " )";
            case DIAINTERMEDIO_NO_VALIDO:
                return "El dia intermedio no es válido ( " + diaIntermedio + " )";
            case DIAINCREMENTO_NO_VALIDO:
                return "el dia de incremento no es válido(" + diaN + ")";
            default:
                return "Se produjo algún error";
        }

    }

    /**
     * @return the diaIntermedio
     */
    public int getDiaIntermedio() {
        return diaIntermedio;
    }

    /**
     * @return the comidaInicial
     */
    public float getComidaInicial() {
        return comidaInicial;
    }

    /**
     * @return the comidaDiaIntermedio
     */
    public float getComidaDiaIntermedio() {
        return comidaDiaIntermedio;
    }

    /**
     * @return the comidaFinal
     */
    public float getComidaFinal() {
        return comidaFinal;
    }

    /**
     * @return the diaN
     */
    public int getDiaN() {
        return diaN;
    }

    /**
     * @return the error
     */
    public ErroType getError() {
        return error;
    }

}
