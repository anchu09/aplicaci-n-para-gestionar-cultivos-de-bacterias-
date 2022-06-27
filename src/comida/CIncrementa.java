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
public class CIncrementa extends Comida {

    private final int comidaInicial;
    private final int comidaFinal;

    /**
     *
     * @param duracion
     * @param comidaInicial
     * @param comidaFinal
     * @throws ComidaException
     */
    public CIncrementa(int duracion, int comidaInicial, int comidaFinal) throws ComidaException {
        super(duracion);
        if (comidaInicial >= 0 && comidaInicial <= 300000) {
            this.comidaInicial = comidaInicial;
        } else {
            throw new ComidaException(0, comidaInicial, 0, comidaFinal, 0, ComidaException.ErroType.COMIDAINICIAL_NO_VALIDA);
        }
        if (comidaFinal >= 0 && comidaFinal <= 300000) {
            this.comidaFinal = comidaFinal;
        } else {
            throw new ComidaException(0, comidaInicial, 0, comidaFinal, 0, ComidaException.ErroType.COMIDAFINAL_NO_VALIDA);
        }
    }

    private float pendientepositiva() {

        int com1 = this.getComidaInicial();
        int diafinal = this.getDiaFinal();
        int com30 = this.getComidaFinal();

        float numerador = (com30 - com1);
        float denominador = (diafinal - 1);
        float pendientepositiva;
        pendientepositiva = numerador / denominador;//calculo de la pendiente de la parte positiva de la funcion de la comida
        return pendientepositiva;
    }

    private float terminoindependientepositivo() {
        float pendientepositiv = this.pendientepositiva();
        int com1 = this.getComidaInicial();

        float terminoindependientepositivo = com1 - pendientepositiv; //calculo del termino independiente de la parte positiva de la funcion de la comida
        return terminoindependientepositivo;
    }

    /**
     *
     * @param diaN the day that we want to know the comida
     * @return how many comida in diaN
     * @throws ComidaException
     */
    @Override
    public float getComidaDiaN(int diaN) throws ComidaException {
        int diaMax = this.getDiaFinal();
        float pendientepositiva = this.pendientepositiva();

        float terminoindependientepositivo = this.terminoindependientepositivo();

        float comida = diaN * pendientepositiva + terminoindependientepositivo;
        return comida;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Comida incial: " + comidaInicial + '\n' + " Comida final: " + comidaFinal;
    }

    /**
     * @return the comidaInicial
     */
    public int getComidaInicial() {
        return comidaInicial;
    }

    /**
     * @return the comidaFinal
     */
    public int getComidaFinal() {
        return comidaFinal;
    }
}
