/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comida;

import java.util.Date;
import model.Luminosidad;
import model.Poblacion;
import model.PoblacionException;

/**
 *
 * @author Dani
 */
public abstract class Comida {

    final protected int diaInicial;
    final protected int duracion;
    final protected int diaFinal;

    public static int MAX_COMIDA = 300000;

    /**
     *
     * @param duracion
     * @throws ComidaException
     */
    public Comida(int duracion) throws ComidaException {

        this.diaInicial = 0;
        this.duracion = duracion;

        this.diaFinal = this.diaInicial + this.duracion;

    }

    public int getDiaInicial() {
        return diaInicial;
    }

    public int getDiaFinal() {
        return diaFinal;
    }

    /**
     *
     * @param diaN
     * @return how many comida in diaN
     * @throws ComidaException
     */
    public float getComidaDiaN(int diaN) throws ComidaException {
        float comida = this.getComidaDiaN(diaN);

        return comida;
    }

    /**
     *
     * @return
     */
    @Override
    public abstract String toString();

    public static void main(String[] args) {

        try {
            // Tests // pasarle valores
            Date d1 = new Date(23, 1, 2020);
            Date d2 = new Date(22, 1, 2020);

            Comida c1 = new CNormal(30, 10, 10, 30, 20);
            Comida c2 = new CIntermitente(30, 10);
            Comida c3 = new CIncrementa(30, 10, 40);
            Comida c4 = new CConstante(30, 10);

            int diaN = 1;
            float comidahoy = 0;
            Poblacion p1 = new Poblacion("pepe", d1, 27, d2, 6, 90, Luminosidad.Luminos.alta, 1, c1);
            System.out.println("comida normal");
            for (diaN = 1; diaN <= c1.diaFinal; diaN++) {
                comidahoy = c1.getComidaDiaN(diaN);
                // System.out.println(diaN);
                System.out.println(comidahoy);
            }
            System.out.println("comida intermitente");
            for (diaN = 1; diaN <= c2.diaFinal; diaN++) {
                comidahoy = c2.getComidaDiaN(diaN);
                //  System.out.println(diaN);
                System.out.println(comidahoy);
            }
            System.out.println("comidaincrementa");
            for (diaN = 1; diaN <= c3.diaFinal; diaN++) {
                comidahoy = c3.getComidaDiaN(diaN);
                //System.out.println(diaN);
                System.out.println(comidahoy);
            }
            System.out.println("comidaconstante");
            for (diaN = 1; diaN <= c4.diaFinal; diaN++) {
                comidahoy = c4.getComidaDiaN(diaN);
                //System.out.println(diaN);
                System.out.println(comidahoy);
            }
            System.out.println("comidanomral" + c1);
            System.out.println("intermitente" + c2);
            System.out.println("incrementea" + c3);
            System.out.println("constante" + c4);
        } catch (ComidaException ex) {
            System.out.println(ex.getError());
        } catch (PoblacionException ex) {
            System.out.println(ex.getError());
        }
    }
}
