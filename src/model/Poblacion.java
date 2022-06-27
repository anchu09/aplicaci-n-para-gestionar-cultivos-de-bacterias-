/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import comida.ComidaException;
import comida.CNormal;
import comida.Comida;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Poblacion {

    private final String nombreExp;

    private Date fechaComienzo = new Date();

    private Date fechaFin = new Date();

    private final int numeroInicialBacterias;
    private final int duracion;
    private final float temperatura;

    private final int Tipocom;
    private final Luminosidad.Luminos lumin;

    private final Comida comida;

    /**
     *
     * @param nombreExp
     * @param fechaComienzo
     * @param duracion
     * @param fechaFin
     * @param numeroInicialBacterias
     * @param temperatura
     * @param luminosidad
     * @param Tipocom
     * @param comida
     * @throws PoblacionException
     */
    public Poblacion(String nombreExp, Date fechaComienzo, int duracion, Date fechaFin, int numeroInicialBacterias, float temperatura, Luminosidad.Luminos luminosidad, int Tipocom, Comida comida) throws PoblacionException {
        this.nombreExp = nombreExp;
        this.duracion = duracion;
        this.fechaFin = sumarRestarDiasFecha(fechaComienzo, this.duracion);
        if (fechaComienzo.compareTo(this.fechaFin) < 0) {
            this.fechaComienzo = fechaComienzo;

        } else {
            throw new PoblacionException(nombreExp, fechaComienzo, fechaFin, numeroInicialBacterias, temperatura, luminosidad, Tipocom, comida, PoblacionException.ErroType.FECHA_NO_VALIDA);
        }

        if (numeroInicialBacterias > 0) {
            this.numeroInicialBacterias = numeroInicialBacterias;
        } else {
            throw new PoblacionException(nombreExp, fechaComienzo, fechaFin, numeroInicialBacterias, temperatura, luminosidad, Tipocom, comida, PoblacionException.ErroType.NUMERONEGATIVO_NO_VALIDO);
        }
        if (Tipocom > 0 && Tipocom < 5) {
            this.Tipocom = Tipocom;
        } else {
            throw new PoblacionException(nombreExp, fechaComienzo, fechaFin, numeroInicialBacterias, temperatura, luminosidad, Tipocom, comida, PoblacionException.ErroType.TIPO_DE_COMIDANOVALIDO);
        }

        if (luminosidad == luminosidad.alta || luminosidad == luminosidad.media || luminosidad == luminosidad.baja) {
            this.lumin = luminosidad;
        } else {
            throw new PoblacionException(nombreExp, fechaComienzo, fechaFin, numeroInicialBacterias, temperatura, luminosidad, Tipocom, comida, PoblacionException.ErroType.LUMINOSIDAD_NO_VALIDA);
        }
        this.temperatura = temperatura;

        this.comida = comida;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nombre: " + nombreExp + '\n' + " Fecha comienzo: " + fechaComienzo.getDay() + "/" + fechaComienzo.getMonth() + "/" + fechaComienzo.getYear() + '\n' + "Duracion: " + getDuracion() + '\n' + " Fecha fin: " + fechaFin.getDay() + "/" + fechaFin.getMonth() + "/" + fechaFin.getYear() + '\n' + " Numero inicial de bacterias: " + numeroInicialBacterias + '\n' + " Temperatura: " + temperatura + '\n' + " Luminosidad: " + lumin + '\n' + "Tipo de comida: " + Tipocom + '\n' + comida;
    }

    private Date sumarRestarDiasFecha(Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(fecha);

        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0

        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos	
    }

    private List<Bacteria> listadebacteriasinicial(Poblacion p) throws ComidaException { //TIENE QUE VENIR DE FUERA
        List<Bacteria> listadebacterias = new ArrayList<>(); //arraylist porque la vamos a tener que recorrer para no perder eficiencia
        Posicion pos1 = new Posicion(9, 9);
        Posicion pos2 = new Posicion(9, 10);
        Posicion pos3 = new Posicion(9, 11);
        Posicion pos4 = new Posicion(9, 12);
        Posicion pos5 = new Posicion(10, 9);
        Posicion pos6 = new Posicion(10, 10);
        Posicion pos7 = new Posicion(10, 11);
        Posicion pos8 = new Posicion(10, 12);
        Posicion pos9 = new Posicion(11, 9);
        Posicion pos10 = new Posicion(11, 10);
        Posicion pos11 = new Posicion(11, 11);
        Posicion pos12 = new Posicion(11, 12);
        Posicion pos13 = new Posicion(12, 9);
        Posicion pos14 = new Posicion(12, 10);
        Posicion pos15 = new Posicion(12, 11);
        Posicion pos16 = new Posicion(12, 12);

        for (int i = 0; i < (p.getNumeroInicialBacterias() / 16); i++) {
            listadebacterias.add(new Bacteria(pos1));
            listadebacterias.add(new Bacteria(pos2));
            listadebacterias.add(new Bacteria(pos3));
            listadebacterias.add(new Bacteria(pos4));
            listadebacterias.add(new Bacteria(pos5));
            listadebacterias.add(new Bacteria(pos6));
            listadebacterias.add(new Bacteria(pos7));
            listadebacterias.add(new Bacteria(pos8));
            listadebacterias.add(new Bacteria(pos9));
            listadebacterias.add(new Bacteria(pos10));
            listadebacterias.add(new Bacteria(pos11));
            listadebacterias.add(new Bacteria(pos12));
            listadebacterias.add(new Bacteria(pos13));
            listadebacterias.add(new Bacteria(pos14));
            listadebacterias.add(new Bacteria(pos15));
            listadebacterias.add(new Bacteria(pos16));
        }
        return listadebacterias;
    }

    /**
     * Makes a simulation of Montecarlo of a given poblation
     *
     * @param p
     * @return a matrix with the results of the simulation
     * @throws ComidaException
     */
    public int[][] ejecutarsimulacion(Poblacion p) throws ComidaException {

        List<Bacteria> listadebacteriasinicial = new ArrayList(listadebacteriasinicial(p));
        Simulacion simu = new Simulacion(p, listadebacteriasinicial);
        int diaactual = 1;
        for (diaactual = 1; diaactual <= p.getDuracion(); diaactual++) {
            simu.repartircomidaenelplato(diaactual);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < simu.getListadebacterias().size(); j++) {
                    simu.bacteriaencuentracomida(simu.getListadebacterias().get(j));
                    simu.bacteriacome(simu.getListadebacterias().get(j), j);
                }
            }//acaba el dia

            simu.actualizarceldas();

            simu.recogerinfodeldia(diaactual);
            simu.checkbacteriashijas();
        }
        int[][] Matriz = simu.mostrarresultados(diaactual);

        return Matriz;
    }

    public static void main(String[] args) {
        Date d1 = new Date(23, 1, 2020);
        Date d2 = new Date(22, 1, 2020);
        try {
            Comida c1 = new CNormal(7, 10000, 4, 90000, 60000);

            Poblacion p1 = new Poblacion("pepe", d1, 7, d2, 2000, 90, Luminosidad.Luminos.alta, 1, c1);
            p1.ejecutarsimulacion(p1);
            Comida c2 = new CNormal(30, 10000, 7, 90000, 60000);

            Poblacion p2 = new Poblacion("dfdf", d1, 30, d2, 200, 90, Luminosidad.Luminos.alta, 1, c1);
            //p2.ejecutarsimulacion(p2);

            //System.out.println(p1);
        } catch (PoblacionException ex) {
            System.out.println(ex.getError());
        } catch (ComidaException ex) {
            System.out.println(ex.getError());
        }

    }

    /**
     * @return the nombreExp
     */
    public String getNombreExp() {
        return nombreExp;
    }

    /**
     * @return the fechaComienzo
     */
    public Date getFechaComienzo() {
        return fechaComienzo;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @return the numeroInicialBacterias
     */
    public int getNumeroInicialBacterias() {
        return numeroInicialBacterias;
    }

    /**
     * @return the temperatura
     */
    public float getTemperatura() {
        return temperatura;
    }

    /**
     * @return the comida
     */
    public Comida getComida() {
        return comida;
    }

    /**
     * @return the lumin
     */
    public Luminosidad.Luminos getLumin() {
        return lumin;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @return the tipocom
     */
}
