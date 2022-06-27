package inputoutput;

import comida.ComidaException;
import comida.CIncrementa;
import comida.CNormal;
import comida.Comida;
import comida.CConstante;
import comida.CIntermitente;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import model.Experimento;
import model.FullExperimentException;
import model.Luminosidad;
import model.Poblacion;
import model.PoblacionException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Dani
 */
public class InputOutputFile {

    /**
     * It saves an experiment in a file
     *
     * @param pw PrintWritter
     * @param ruta of the file
     * @param ex experiment to save
     * @throws IndexOutOfBoundsException
     * @throws FullExperimentException
     * @throws ComidaException
     */
    public static void guardar(PrintWriter pw, String ruta, Experimento ex) throws IndexOutOfBoundsException, FullExperimentException, ComidaException {
        for (int i = 0; i < ex.listadepoblaciones.size(); i++) {

            pw.println(ex.getPoblacion(i));

        }

    }

    /**
     * It reads a file and adds all the poblations in the given experiment
     *
     * @param ruta of the file to read
     * @param ex experiment that the poblations read are going to be added in
     */
    public static void getPoblacionFile(String ruta, Experimento ex) {
        Poblacion p1 = null;
        String leido = "";
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);

            do {
                Comida c1 = null;
                leido = br.readLine();
                String nombre = leido.substring(8);
                leido = br.readLine();
                leido = leido.substring(17);
                Date fechacomienzo = ParseFecha(leido);

                leido = br.readLine();
                int duracion = Integer.parseInt(leido.substring(10));
                leido = br.readLine();

                leido = leido.substring(12);
                Date fechafino = ParseFecha(leido);
                leido = br.readLine();
                int numeroinicialbact = Integer.parseInt(leido.substring(30));
                leido = br.readLine();
                float temp = Float.parseFloat(leido.substring(14));
                leido = br.readLine();
                Luminosidad.Luminos luminosida = Luminosidad.Luminos.valueOf(leido.substring(14));
                leido = br.readLine();
                int tipoC = Integer.parseInt(leido.substring(16));
                //comida

                if (tipoC == 1) {
                    c1 = leercomidanormal(ruta, ex, br, duracion);

                } else if (tipoC == 2) {
                    c1 = leercomidaincrementa(ruta, ex, br, duracion);
                } else if (tipoC == 3) {
                    c1 = leercomidaconstante(ruta, ex, br, duracion);
                } else if (tipoC == 4) {
                    c1 = leercomidaintermitente(ruta, ex, br, duracion);
                }
                p1 = new Poblacion(nombre, fechacomienzo, duracion, fechafino, numeroinicialbact, temp, luminosida, tipoC, c1);

                ex.addPopulation(p1);
            } while (leido != null);

        } catch (FileNotFoundException ex1) {
            System.out.println("archivo no encontrado");
        } catch (IOException ex1) {
            System.out.println("error");
        } catch (NullPointerException ex1) {
            System.out.println("");
        } catch (PoblacionException ex1) {
            System.out.println(ex1.getError());
        }

    }

    private static Comida leercomidanormal(String ruta, Experimento ex, BufferedReader br, int duracion) {

        String leido;
        Comida c1 = null;
        try {

            leido = br.readLine();
            int diamax = Integer.parseInt(leido.substring(17));

            leido = br.readLine();
            int com1 = Integer.parseInt(leido.substring(16));
            leido = br.readLine();
            int com30 = Integer.parseInt(leido.substring(15));
            leido = br.readLine();
            int comdiamax = Integer.parseInt(leido.substring(27));

            c1 = new CNormal(duracion, com1, diamax, comdiamax, com30);
        } catch (IOException ex1) {
            System.out.println("error");
        } catch (ComidaException ex1) {
            System.out.println(ex1.getError());
        }
        return c1;

    }

    private static Comida leercomidaincrementa(String ruta, Experimento ex, BufferedReader br, int duracion) {

        String leido;
        Comida c1 = null;
        int com1 = 0;
        int com30 = 0;

        try {
            leido = br.readLine();
            com1 = Integer.parseInt(leido.substring(15));
            leido = br.readLine();
            com30 = Integer.parseInt(leido.substring(15));

        } catch (IOException ex1) {
            System.out.println("error leyendo");
        }
        try {
            c1 = new CIncrementa(duracion, com1, com30);
        } catch (ComidaException ex1) {
            System.out.println(ex1.getError());;
        }
        return c1;
    }

    private static Comida leercomidaconstante(String ruta, Experimento ex, BufferedReader br, int duracion) {

        String leido;
        Comida c1 = null;
        int com1 = 0;

        try {
            leido = br.readLine();
            com1 = Integer.parseInt(leido.substring(8));

        } catch (IOException ex1) {
            System.out.println("error leyendo");;
        }
        try {
            c1 = new CConstante(duracion, com1);
        } catch (ComidaException ex1) {
            System.out.println(ex1.getError());
        }
        return c1;
    }

    private static Comida leercomidaintermitente(String ruta, Experimento ex, BufferedReader br, int duracion) {

        String leido;
        Comida c1 = null;
        int com1 = 0;

        try {
            leido = br.readLine();
            com1 = Integer.parseInt(leido.substring(8));

        } catch (IOException ex1) {
            System.out.println("error leyendo");
        }
        try {
            c1 = new CIntermitente(duracion, com1);
        } catch (ComidaException ex1) {
            System.out.println(ex1.getError());
        }
        return c1;
    }

    /**
     * It receives a string containing a date in a simple format
     *
     * @param fecha
     * @return the date received converted to Date
     */
    private static Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("d/m/y");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }

    public static void main(String[] args) {

        Experimento ex = null;

        String ruta = "C:\\Users\\Dania\\Desktop\\mmmm.txt";
        ex = new Experimento();

        InputOutputFile.getPoblacionFile(ruta, ex);
        ruta = "C:\\Users\\Dania\\Desktop\\mmmuuum.txt";

        try {
            PrintWriter pw = new PrintWriter(ruta);

            InputOutputFile.guardar(pw, ruta, ex);
            pw.close();
        } catch (IndexOutOfBoundsException ex1) {
            System.out.println("fuera de limites");
        } catch (FullExperimentException ex1) {
            System.out.println(ex1.getError());
        } catch (ComidaException ex1) {
            System.out.println(ex1.getError());
        } catch (FileNotFoundException ex1) {
            System.out.println("archivo no encontrado");
        }
    }
}
