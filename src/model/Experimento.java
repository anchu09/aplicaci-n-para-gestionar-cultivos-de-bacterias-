/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import comida.ComidaException;
import comida.CNormal;
import comida.Comida;
import java.util.Date;
import java.util.*;

/**
 *
 * @author Dani
 */
public class Experimento {

    public List<Poblacion> listadepoblaciones;

    /**
     *
     */
    public Experimento() {
        listadepoblaciones = new LinkedList<>();
    }

    /**
     * It adds a population in the experiment
     *
     * @param p1 popoulation to add
     * @throws NullPointerException
     * @throws IndexOutOfBoundsException
     */
    public void addPopulation(model.Poblacion p1) throws NullPointerException, IndexOutOfBoundsException {

        if (p1 == null) {
            throw new NullPointerException();
        } else {
            this.listadepoblaciones.add(p1);
        }

    }

    /**
     * It generates an array with the names of all the populations
     *
     * @return a string array with all the population names
     */
    public String[] getnombrePoblaciones() {
        int i = 0;
        String[] arraydenombres = new String[this.listadepoblaciones.size()];

        for (i = 0; i < this.listadepoblaciones.size(); i++) {

            arraydenombres[i] = this.listadepoblaciones.get(i).getNombreExp();
        }
        return arraydenombres;
    }

    /**
     * Deletes the population in the given index
     *
     * @param i is the index in which the population is going to be deleted
     * @throws IndexOutOfBoundsException
     * @throws FullExperimentException
     */
    public void borrarpoblacion(int i) throws IndexOutOfBoundsException, FullExperimentException {

        if (i >= 0) {
            this.listadepoblaciones.remove(i);
        } else {
            throw new FullExperimentException(i, FullExperimentException.ErroType.POSICION_ARRAY_NEGATIVO);
        }
    }

    /**
     * Shows all the info of the population in the given index
     *
     * @param i
     * @return all the info of the population
     * @throws IndexOutOfBoundsException
     * @throws FullExperimentException
     */
    public Poblacion getPoblacion(int i) throws IndexOutOfBoundsException, FullExperimentException {

        // si i esta entre 0 y contadorPoblaciones, return return this.arraydePoblaciones()[i];
        if (i >= 0 && i < this.listadepoblaciones.size()) {

            return this.listadepoblaciones.get(i);

        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    public static void main(String[] args) {
        Date d1 = new Date(12, 11, 2020);
        Date d2 = new Date(13, 11, 2020);

        try {
            Experimento ex = new Experimento();
            Comida c1 = new CNormal(29, 10, 10, 20, 30);

            Poblacion p1 = new Poblacion("pepe", d1, 29, d2, 6, 90, Luminosidad.Luminos.alta, 1, c1);
            Poblacion p2 = new Poblacion("pepe1", d1, 29, d2, 6, 90, Luminosidad.Luminos.alta, 1, c1);
            Poblacion p3 = new Poblacion("pepe2", d1, 29, d2, 6, 90, Luminosidad.Luminos.alta, 1, c1);
            Poblacion p4 = new Poblacion("pepe3", d1, 29, d2, 6, 90, Luminosidad.Luminos.alta, 1, c1);
            Poblacion p5 = new Poblacion("pepe4", d1, 29, d2, 6, 90, Luminosidad.Luminos.alta, 1, c1);

            for (int j = 0; j <= 12; j++) {
                try {
                    ex.addPopulation(p1);

                } catch (NullPointerException exc) {
                    System.out.println("error1");
                } catch (IndexOutOfBoundsException exc) {
                    System.out.println("error 2");
                }
            }
            try {
                for (int i = 0; i <= 12; i++) {
                    System.out.println(ex.getPoblacion(i));
                    for (int j = 1; j <= ex.getPoblacion(i).getDuracion(); j++) {

                        System.out.println(ex.getPoblacion(i).getComida().getComidaDiaN(j));

                    }
                }

            } catch (IndexOutOfBoundsException ex1) {
                System.out.println("fuera de limites");

            } catch (FullExperimentException ex1) {
                System.out.println("lleno");
            }
        } catch (PoblacionException ex) {
            System.out.println(ex.getError());
        } catch (ComidaException ex) {
            System.out.println("comida no creada");
        }

        try {
            Experimento ex = new Experimento();
            Comida c1 = new CNormal(29, 10, 10, 20, 30);

            Poblacion p1 = new Poblacion("pepe", d1, 29, d2, 6, 90, Luminosidad.Luminos.alta, 1, c1);
            Poblacion p2 = new Poblacion("pepe1", d1, 29, d2, 6, 90, Luminosidad.Luminos.alta, 1, c1);
            Poblacion p3 = new Poblacion("pepe2", d1, 29, d2, 6, 90, Luminosidad.Luminos.alta, 1, c1);
            Poblacion p4 = new Poblacion("pepe3", d1, 29, d2, 6, 90, Luminosidad.Luminos.alta, 1, c1);
            Poblacion p5 = new Poblacion("pepe4", d1, 29, d2, 6, 90, Luminosidad.Luminos.alta, 1, c1);
            ex.addPopulation(p1);
            ex.addPopulation(p2);
            ex.addPopulation(p3);
            ex.addPopulation(p4);
            ex.borrarpoblacion(2);
            ex.addPopulation(p5);

            Poblacion p = ex.getPoblacion(3);
            System.out.println(p);

        } catch (ComidaException ex) {
            System.out.println(ex.getError());
        } catch (PoblacionException ex) {
            System.out.println(ex.getError());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("fuera de limites");
        } catch (FullExperimentException ex) {
            System.out.println(ex.getError());
        }

    }

}
