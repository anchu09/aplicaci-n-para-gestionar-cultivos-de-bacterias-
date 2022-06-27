/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import comida.ComidaException;
import java.util.*;

/**
 *
 * @author Dani
 */
public class Simulacion {

    private final Celda[][] arraydeceldas;
    private final int[][][][] datos;
    private int numerobacterias;
    private final Poblacion pasimular;
    private final List<Bacteria> listadebacterias;

    /**
     *
     * @param p
     * @param listadebacteriasinicial
     */
    public Simulacion(Poblacion p, List listadebacteriasinicial) {
        this.arraydeceldas = new Celda[20][20];
        this.pasimular = p;
        this.listadebacterias = listadebacteriasinicial;
        this.datos = new int[p.getDuracion() + 1][20][20][3];

    }

    /**
     * It sets in the comida of the Bacteria the same comida of the Celda
     *
     * @param bac the Bacteria
     */
    protected void bacteriaencuentracomida(Bacteria bac) {
        //saco la Posicion de la Bacteria
        //miro cuanta comida hay en esa Celda
        //seteo esa comida en la Bacteria con el setcomidaenposicion
        int x = bac.getPos().getPosicioninicialX();
        int y = bac.getPos().getPosicioninicialY();
        int comida = this.getArraydeceldas()[x][y].getCantidadcomida();
        bac.getPos().setComidaenposicion(comida);

    }

    /**
     * the Bacteria given makes all his activities of eating and moving
     *
     * @param bac
     * @param indice
     */
    public void bacteriacome(Bacteria bac, int indice) {
        int numeroaleatorio = 0;
        int comidaenposicion = bac.getPos().getComidaenposicion();
        if (bac.getPos().getComidaenposicion() >= 100) {
            bac.setComidaacumulada(bac.getComidaacumulada() + 20);
            int comidarestada = this.getArraydeceldas()[bac.getPos().getPosicioninicialX()][bac.getPos().getPosicioninicialY()].getCantidadcomida() - 20;
            this.getArraydeceldas()[bac.getPos().getPosicioninicialX()][bac.getPos().getPosicioninicialY()].setCantidadcomida(comidarestada);
            numeroaleatorio = (int) (Math.random() * 100);
            if (numeroaleatorio < 0) {
                numeroaleatorio = numeroaleatorio * (-1);
            }
            if (numeroaleatorio < 3) {
                //bacteriamuere

                this.getListadebacterias().remove(indice);

            } else if (numeroaleatorio >= 60) {
                this.semuevetabla1y3(numeroaleatorio, bac);
            }

        }
        if (bac.getPos().getComidaenposicion() < 100 && bac.getPos().getComidaenposicion() >= 10) {
            bac.setComidaacumulada(bac.getComidaacumulada() + 10);
            int comidarestada = this.getArraydeceldas()[bac.getPos().getPosicioninicialX()][bac.getPos().getPosicioninicialY()].getCantidadcomida() - 10;
            this.getArraydeceldas()[bac.getPos().getPosicioninicialX()][bac.getPos().getPosicioninicialY()].setCantidadcomida(comidarestada);
            numeroaleatorio = (int) (Math.random() * 100);
            if (numeroaleatorio < 0) {
                numeroaleatorio = numeroaleatorio * (-1);
            }
            if (numeroaleatorio < 6) {
                //bacteriamuere
                this.getListadebacterias().remove(indice);

            } else if (numeroaleatorio >= 6) {
                this.semuevetabla2(numeroaleatorio, bac);
            }
        }
        if (bac.getPos().getComidaenposicion() < 10) {
            numeroaleatorio = (int) (Math.random() * 100);
            if (numeroaleatorio < 0) {
                numeroaleatorio = numeroaleatorio * (-1);
            }
            if (numeroaleatorio < 20) {
                //bacteriamuere

                this.getListadebacterias().remove(indice);

            } else if (numeroaleatorio >= 20) {
                this.semuevetabla1y3(numeroaleatorio, bac);
            }
        }

    }

    private void semuevetabla1y3(int numeroaleatorio, Bacteria bac) {
        if (numeroaleatorio >= 60 && numeroaleatorio < 65 && bac.getPos().getPosicioninicialX() - 1 >= 0 && bac.getPos().getPosicioninicialY() + 1 < 20) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX() - 1);
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY() + 1);

        }
        if (numeroaleatorio >= 65 && numeroaleatorio < 69 && bac.getPos().getPosicioninicialY() - 1 >= 0) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX());
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY() - 1);

        }
        if (numeroaleatorio >= 70 && numeroaleatorio < 75 && bac.getPos().getPosicioninicialX() + 1 < 20 && bac.getPos().getPosicioninicialY() + 1 < 20) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX() + 1);
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY() + 1);

        }
        if (numeroaleatorio >= 75 && numeroaleatorio < 80 && bac.getPos().getPosicioninicialX() - 1 >= 0) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX() - 1);
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY());

        }
        if (numeroaleatorio >= 80 && numeroaleatorio < 85 && bac.getPos().getPosicioninicialX() + 1 < 20) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX() + 1);
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY());

        }
        if (numeroaleatorio >= 85 && numeroaleatorio < 90 && bac.getPos().getPosicioninicialX() - 1 >= 0 && bac.getPos().getPosicioninicialY() - 1 >= 0) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX() - 1);
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY() - 1);

        }
        if (numeroaleatorio >= 90 && numeroaleatorio < 95 && bac.getPos().getPosicioninicialY() - 1 >= 0) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX());
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY() - 1);

        }
        if (numeroaleatorio >= 95 && numeroaleatorio < 100 && bac.getPos().getPosicioninicialY() - 1 >= 0 && bac.getPos().getPosicioninicialX() + 1 < 20) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX() + 1);
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY() - 1);

        }
    }

    private void semuevetabla2(int numeroaleatorio, Bacteria bac) {
        if (numeroaleatorio >= 20 && numeroaleatorio < 30 && bac.getPos().getPosicioninicialX() - 1 >= 0 && bac.getPos().getPosicioninicialY() + 1 < 20) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX() - 1);
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY() + 1);

        }
        if (numeroaleatorio >= 30 && numeroaleatorio < 40 && bac.getPos().getPosicioninicialY() - 1 >= 0) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX());
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY() - 1);

        }
        if (numeroaleatorio >= 40 && numeroaleatorio < 50 && bac.getPos().getPosicioninicialX() + 1 < 20 && bac.getPos().getPosicioninicialY() + 1 < 20) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX() + 1);
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY() + 1);

        }
        if (numeroaleatorio >= 50 && numeroaleatorio < 60 && bac.getPos().getPosicioninicialX() - 1 >= 0) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX() - 1);
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY());

        }
        if (numeroaleatorio >= 60 && numeroaleatorio < 70 && bac.getPos().getPosicioninicialX() + 1 < 20) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX() + 1);
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY());

        }
        if (numeroaleatorio >= 70 && numeroaleatorio < 80 && bac.getPos().getPosicioninicialX() - 1 >= 0 && bac.getPos().getPosicioninicialY() - 1 >= 0) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX() - 1);
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY() - 1);

        }
        if (numeroaleatorio >= 80 && numeroaleatorio < 90 && bac.getPos().getPosicioninicialY() - 1 >= 0) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX());
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY() - 1);

        }
        if (numeroaleatorio >= 90 && numeroaleatorio < 100 && bac.getPos().getPosicioninicialY() - 1 >= 0 && bac.getPos().getPosicioninicialX() + 1 < 20) {
            bac.getPos().setPosicioninicialX(bac.getPos().getPosicioninicialX() + 1);
            bac.getPos().setPosicioninicialY(bac.getPos().getPosicioninicialY() - 1);

        }
    }

    /**
     * It gets the comida from diaN and distributes it between all the celdas
     *
     * @param diaN
     * @throws ComidaException
     */
    public void repartircomidaenelplato(int diaN) throws ComidaException {

        int comida = (int) (this.pasimular.getComida().getComidaDiaN(diaN));
        int comidaporcelda = comida / 400;
        int comidaacumulada = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (diaN - 1 == 0) {
                    comidaacumulada = 0;
                } else {
                    comidaacumulada = this.getDatos()[diaN - 1][i][j][2];

                }
                this.getArraydeceldas()[i][j] = new Celda(i, j);
                this.getArraydeceldas()[i][j].setCantidadcomida(comidaporcelda + comidaacumulada);
            }
        }
    }

    /**
     * synchronize the foodin each Celda as the food in the position of
     * bacteries
     */
    public void actualizarceldas() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                this.getArraydeceldas()[i][j].setNumerobacterias(0);
            }
        }
        for (Bacteria bac : this.getListadebacterias()) {
            int x = bac.getPos().getPosicioninicialX();
            int y = bac.getPos().getPosicioninicialY();

            this.getArraydeceldas()[x][y].setNumerobacterias(((this.getArraydeceldas()[x][y].getNumerobacterias()) + 1));
        }

    }

    /**
     * It saves in a multi-dimensional matriz all the info from a given day
     *
     * @param dia
     */
    public void recogerinfodeldia(int dia) {
        for (int columnas = 0; columnas < 20; columnas++) {//almacenamos bacterias vivas por Celda ultimoparametro 0
            for (int filas = 0; filas < 20; filas++) {
                int numerodebacteriasporcelda = this.getArraydeceldas()[columnas][filas].getNumerobacterias();
                this.getDatos()[dia][columnas][filas][1] = numerodebacteriasporcelda;

            }
        }

        for (int columnas = 0; columnas < 20; columnas++) {//almacenamos cantidad de comida por Celda ultimo parametro 1
            for (int filas = 0; filas < 20; filas++) {
                this.getDatos()[dia][columnas][filas][2] = this.getArraydeceldas()[columnas][filas].getCantidadcomida();
            }
        }

    }

    private void nuevabacteriahija(int x, int y, List bacteriashijas) throws ComidaException {

        bacteriashijas.add(new Bacteria(new Posicion(x, y)));
        this.getArraydeceldas()[x][y].setNumerobacterias((this.getArraydeceldas()[x][y].getNumerobacterias() + 1));
    }

    /**
     * It checks if there are bacteries that should reproduce
     *
     * @throws ComidaException
     */
    public void checkbacteriashijas() throws ComidaException {
        //paso la lista a array para evitar el ArrayList$Itr.next
        //creo una lista de bacterias hijas, se la paso a la funcion para que meta ahi todas las bacterias hijas, al final del check bacterias hijas meto todas las de la lista nueva en la vieja
        List<Bacteria> bacteriashijas = new ArrayList<>();
        Bacteria[] arraydebacterias = new Bacteria[this.getListadebacterias().size()];
        arraydebacterias = this.getListadebacterias().toArray(arraydebacterias);

        for (Bacteria arraydebacteria : arraydebacterias) {
            int comidaingeridadia = arraydebacteria.getComidaacumulada();
            int x = arraydebacteria.getPos().getPosicioninicialX();
            int y = arraydebacteria.getPos().getPosicioninicialY();
            if (comidaingeridadia >= 150) {

                this.nuevabacteriahija(x, y, bacteriashijas);
                this.nuevabacteriahija(x, y, bacteriashijas);
                this.nuevabacteriahija(x, y, bacteriashijas);

            }
            if (comidaingeridadia < 150 && comidaingeridadia >= 100) {
                this.nuevabacteriahija(x, y, bacteriashijas);
                this.nuevabacteriahija(x, y, bacteriashijas);

            }
            if (comidaingeridadia < 100 && comidaingeridadia >= 50) {

                this.nuevabacteriahija(x, y, bacteriashijas);

            }
            //volcamos la lista de hijas en la normal

        }
        this.getListadebacterias().addAll(bacteriashijas);
    }

    /**
     * It sends the final results of the simulation in a matrix 2-dimentional
     *
     * @param diafinal
     * @return
     */
    public int[][] mostrarresultados(int diafinal) {
        int filas = 0;
        int columnas = 0;
        diafinal = diafinal - 1;
        int[][] Matriz = new int[20][20];
        int numero = 0;

        for (columnas = 0; columnas < 20; columnas++) {

            for (filas = 0; filas < 20; filas++) {
                numero = this.getDatos()[diafinal][columnas][filas][1];

                Matriz[columnas][filas] = numero;

            }
        }
        return Matriz;
    }

    /**
     * @return the arraydeceldas
     */
    public Celda[][] getArraydeceldas() {
        return arraydeceldas;
    }
    //metodo actualizar numero de bacterias en celdas

    /**
     * @param numerobacterias the numerobacterias to set
     */
    public void setNumerobacterias(int numerobacterias) {
        this.numerobacterias = numerobacterias;
    }

    /**
     * @return the datos
     */
    public int[][][][] getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(int[][][][] datos) {
        this.setDatos(datos);
    }

    /**
     * @return the listadebacteriasinicial
     */
    public List<Bacteria> getListadebacterias() {
        return listadebacterias;
    }

    /**
     * @param datos the datos to set
     */
}
