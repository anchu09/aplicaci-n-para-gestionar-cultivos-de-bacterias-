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
public class CNormal extends Comida {

    private final int diaIntermedio;
    private final int comidaInicial;
    private final int comidaDiaIntermedio;
    private final int comidaFinal;

    /**
     *
     * @param duracion
     * @param comidaInicial
     * @param diaIntermedio
     * @param comidaDiaIntermedio
     * @param comidaFinal
     * @throws ComidaException
     */
    public CNormal(int duracion, int comidaInicial, int diaIntermedio, int comidaDiaIntermedio, int comidaFinal) throws ComidaException {
        super(duracion);
        if (diaIntermedio > this.diaInicial && diaIntermedio < this.diaFinal) {
            this.diaIntermedio = diaIntermedio;
        } else {
            throw new ComidaException(diaIntermedio, comidaInicial, comidaDiaIntermedio, comidaFinal, 0, ComidaException.ErroType.DIAINTERMEDIO_NO_VALIDO);
        }
        if (comidaInicial >= 0 && comidaInicial <= 300000) {
            this.comidaInicial = comidaInicial;
        } else {
            throw new ComidaException(diaIntermedio, comidaInicial, comidaDiaIntermedio, comidaFinal, 0, ComidaException.ErroType.COMIDAINICIAL_NO_VALIDA);
        }
        if (comidaDiaIntermedio >= 0 && comidaDiaIntermedio <= 300000) {
            this.comidaDiaIntermedio = comidaDiaIntermedio;
        } else {
            throw new ComidaException(diaIntermedio, comidaInicial, comidaDiaIntermedio, comidaFinal, 0, ComidaException.ErroType.COMIDADIAINTERMEDIO_NO_VALIDA);
        }
        if (comidaFinal >= 0 && comidaFinal <= 300000) {
            this.comidaFinal = comidaFinal;
        } else {
            throw new ComidaException(diaIntermedio, comidaInicial, comidaDiaIntermedio, comidaFinal, 0, ComidaException.ErroType.COMIDAFINAL_NO_VALIDA);
        }

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return " Día intermedio: " + diaIntermedio + '\n' + " Comida incial: " + comidaInicial + '\n' + " Comida final: " + comidaFinal + '\n' + "Comida del día intermedio: " + comidaDiaIntermedio;
    }

    private float pendientenegativa() {
        int com30 = this.getComidaFinal();
        int diaMax = this.getDiaIntermedio();
        int comDiaMax = this.getComidaDiaIntermedio();
        int diafinal = this.getDiaFinal();

        float numerador = (comDiaMax - com30);

        float denominador = (diaMax - diafinal);

        float pendientenegativ = (numerador / denominador);//calculo de la pendiente de la parte negativa de la funcion de la comida

        return pendientenegativ;
    }

    private float pendientepositiva() {
        int com1 = this.getComidaInicial();
        int diaMax = this.getDiaIntermedio();
        int comDiaMax = this.getComidaDiaIntermedio();

        float numerador = (comDiaMax - com1);
        float denominador = (diaMax - 1);
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

    private float terminoindependientenegativo() {
        int com30 = this.getComidaFinal();
        int diafinal = this.getDiaFinal();
        float pendientenegativ = this.pendientenegativa();
        float terminoindependientenegativo = com30 - pendientenegativ * diafinal; //calculo del termino independiente de la parte negativa de la funcion de la comida
        return terminoindependientenegativo;
    }

    public float getComidaDiaN(int diaN) throws ComidaException {
        // lance una excepcion si diaN no esta entre diaInicial y dia Final
        float comida = 0;

        if (diaN >= 1 && diaN <= this.duracion) {
            int diaMax = this.getDiaIntermedio();
            float pendientepositiva = this.pendientepositiva();

            float terminoindependientepositivo = this.terminoindependientepositivo();
            float pendientenegativa = this.pendientenegativa();
            float terminoindependientenegativo = this.terminoindependientenegativo();

            if (diaN <= diaMax) {
                comida = diaN * pendientepositiva + terminoindependientepositivo;

            } else {
                comida = diaN * pendientenegativa + terminoindependientenegativo;

            }

        } else {

            throw new ComidaException(getDiaIntermedio(), getComidaInicial(), getComidaDiaIntermedio(), getComidaFinal(), diaN, ComidaException.ErroType.DIAINCREMENTO_NO_VALIDO);
        }

        return comida;
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
    public int getComidaInicial() {
        return comidaInicial;
    }

    /**
     * @return the comidaDiaIntermedio
     */
    public int getComidaDiaIntermedio() {
        return comidaDiaIntermedio;
    }

    /**
     * @return the comidaFinal
     */
    public int getComidaFinal() {
        return comidaFinal;
    }

    public static void main(String[] args) {
        int duracion = 45;
        int comidaInicial = 200;
        int diaComidaMax = 34;
        int cantidadMax = 3444;
        int cantidadFinal = 220;
        try {
            CNormal cn1 = new CNormal(duracion, comidaInicial, diaComidaMax, cantidadMax, cantidadFinal);
            System.out.println("TEST PASADO. ");
        } catch (ComidaException ex) {
            System.out.println("TEST NO PASADO. Revisar constructor");
        }
    }
}
