/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputoutput;

import comida.ComidaException;
import comida.CIntermitente;
import comida.CIncrementa;
import comida.CNormal;
import comida.Comida;
import comida.CConstante;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import model.Luminosidad;
import model.Poblacion;
import model.PoblacionException;

/**
 *
 * @author Dani
 */
public class InputOutput {

    private static boolean checksolonumeros(String stringLeido) {
        boolean bucle = false;

        for (int i = 0; i < stringLeido.length(); i++) {
            char car = stringLeido.charAt(i);
            if ((car < '0' || car > '9')) {
                bucle = false;

            } else {
                bucle = true;
            }
        }
        if (bucle == true) {
            return true;
        } else {
            return false;
        }

    }

    private static boolean checksololetras(String stringLeido) {
        boolean bucle = false;

        for (int i = 0; i < stringLeido.length(); i++) {
            char car = stringLeido.charAt(i);
            if (!(car < '0' || car > '9')) {
                bucle = false;

            } else {
                bucle = true;
            }
        }
        if (bucle == true) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * read a number from user
     *
     * @param pregunta
     * @return el numero leido. Integer.MIN_VALUE in case of error
     */
    public static int leernumero(String pregunta) {
        int numeroLeido;
        String stringLeido;
        Boolean solonumeros = false;
        try {
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println(pregunta);
                stringLeido = consola.readLine();
                solonumeros = checksolonumeros(stringLeido);
            } while (solonumeros == false);
            numeroLeido = Integer.parseInt(stringLeido);
            return numeroLeido;
        } catch (IOException ex) {
            System.out.println("no se ha podido leer el numero: " + ex);
            return Integer.MIN_VALUE;
        }

    }

    /**
     * Read a string from user
     *
     * @param pregunta1
     * @return the read string
     * @return an empty string if an error ocurred
     */
    public static String leercadena(String pregunta1) {

        String stringLeido;
        Boolean sololetra = false;
        try {
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println(pregunta1);
                stringLeido = consola.readLine();
                sololetra = checksololetras(stringLeido);
            } while (sololetra == false);
            String stringfinal = stringLeido;
            return stringLeido;
        } catch (IOException ex) {
            System.out.println("no se ha podido leer la cadena: " + ex);
            return "";
        }
    }

    /**
     * Read a real number from the user. Return -21212121 if an error has
     * ocurred
     *
     * @param pregunta2
     * @return the read real number. Return float.MIN_VALUE in case of error
     */
    public static float leerfloat(String pregunta2) {
        float numeroLeido;
        String stringLeido;
        Boolean solonumeros = false;
        try {
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            do {
                System.out.println(pregunta2);
                stringLeido = consola.readLine();
                solonumeros = checksolonumeros(stringLeido);
            } while (solonumeros == false);
            numeroLeido = Float.parseFloat(stringLeido);
            return numeroLeido;
        } catch (IOException ex) {
            System.out.println("no se ha podido leer el numero: " + ex);
            return Float.MIN_VALUE;
        }
    }

    /**
     *
     * @return The poblation read from user
     */
    public static Poblacion inputPoblacion() {

        String nombreEx;
        int tipoC = 0;
        Date fechaFi = new Date(0, 0, 0);
        int numeroInicialBacteria;
        float temperatur;
        String luminosidadleida = "";
        Luminosidad.Luminos luminosida;
        Comida cnew = null;
        int dia = 0;
        int duracion = 0;
        int mes = 0;
        int ano = 0;
        int com1 = 0;
        int diaMax = 0;
        int comDiaMax = 0;
        int com30 = 0;
        String pregunta1 = "introduce el nombre del experimento";
        nombreEx = InputOutput.leercadena(pregunta1);
        System.out.println("introduce la fecha de comienzo del experimento");

        do {
            pregunta1 = "dia inicio: ";
            dia = InputOutput.leernumero(pregunta1);
        } while (dia > 30 || dia < 1);
        do {
            pregunta1 = "mes inicio: ";
            mes = InputOutput.leernumero(pregunta1);
        } while (mes < 1 || mes > 12);
        do {
            pregunta1 = "ano inicio: ";
            ano = InputOutput.leernumero(pregunta1);
        } while (ano < 0);
        Date fechaComienz = new Date(ano, mes, dia);
        do {
            pregunta1 = "introduce la duracion del experimento";
            duracion = InputOutput.leernumero(pregunta1);
        } while (duracion <= 0);

        fechaFi.setDate(fechaComienz.getDate() + duracion);
        do {
            pregunta1 = "introduce el numero inicial de bacterias del experimento";
            numeroInicialBacteria = InputOutput.leernumero(pregunta1);
        } while (numeroInicialBacteria <= 0);
        pregunta1 = "introduce la temperatura";
        temperatur = InputOutput.leerfloat(pregunta1);
        pregunta1 = "introduce la luminosidad: ";
        do {
            luminosidadleida = InputOutput.leercadena(pregunta1);
        } while (!(luminosidadleida.equals("alta") || luminosidadleida.equals("media") || luminosidadleida.equals("baja")));
        luminosida = Luminosidad.Luminos.valueOf(luminosidadleida);

        pregunta1 = "introduce eltipo de comida: (1-normal, 2-incrementa, 3-constante, 4-constanteIntermitente) ";
        do {
            tipoC = InputOutput.leernumero(pregunta1);
        } while (tipoC > 4 || tipoC < 1);
        switch (tipoC) {
            case 1:
                do {
                    pregunta1 = "introduce la cantidad de comida del primer dia : ";
                    com1 = InputOutput.leernumero(pregunta1);
                } while (com1 > Comida.MAX_COMIDA || com1 < 0);
                do {
                    pregunta1 = "introduce el dia de comida maxima: ";
                    diaMax = InputOutput.leernumero(pregunta1);
                } while (diaMax > duracion || diaMax < 0);
                do {
                    pregunta1 = "introduce la cantidad de comida del dia maximo : ";
                    comDiaMax = InputOutput.leernumero(pregunta1);
                } while (comDiaMax > Comida.MAX_COMIDA || comDiaMax < 0);
                do {
                    pregunta1 = "introduce la cantidad de comida del ultimo dia : ";

                    com30 = InputOutput.leernumero(pregunta1);
                } while (com30 > Comida.MAX_COMIDA || com30 < 0);
                try {
                    cnew = new CNormal(duracion, com1, diaMax, comDiaMax, com30);
                } catch (ComidaException ex) {
                    System.out.println(ex.getError());
                }
                break;
            case 2:
                //en el get comida dia n solo voy a enseñar la parte positiva de lo normal
                do {
                    pregunta1 = "introduce la cantidad de comida del primer dia : ";
                    com1 = InputOutput.leernumero(pregunta1);
                } while (com1 > Comida.MAX_COMIDA || com1 < 0);
                do {
                    pregunta1 = "introduce la cantidad de comida del dia maximo (ultimodia) : ";
                    comDiaMax = InputOutput.leernumero(pregunta1);
                } while (comDiaMax > Comida.MAX_COMIDA || comDiaMax < 0);
                try {
                    cnew = new CIncrementa(duracion, com1, comDiaMax);
                } catch (ComidaException ex) {
                    System.out.println(ex.getError());
                }
                break;
            case 3:
                do {
                    pregunta1 = "introduce la cantidad de comida constante: ";
                    com1 = InputOutput.leernumero(pregunta1);
                } while (com1 > Comida.MAX_COMIDA || com1 < 0);
                try {
                    cnew = new CConstante(duracion, com1);
                } catch (ComidaException ex) {
                    System.out.println(ex.getError());
                }
                break;
            case 4:
                do {
                    pregunta1 = "introduce la cantidad de comida intermitente: ";
                    com1 = InputOutput.leernumero(pregunta1);
                } while (com1 > Comida.MAX_COMIDA || com1 < 0);
                try {
                    cnew = new CIntermitente(duracion, com1);
                } catch (ComidaException ex) {
                    System.out.println(ex.getError());
                }
                break;
            default:
                break;
        }
        Poblacion p1 = null;
        try {
            p1 = new Poblacion(nombreEx, fechaComienz, duracion, fechaFi, numeroInicialBacteria, temperatur, luminosida, tipoC, cnew);
        } catch (PoblacionException ex) {
            System.out.println(ex.getError());
        }
        return p1;
    }

    public static void main(String[] args) {
        String pregunta = "mete int";
        int numer = leernumero(pregunta);
        System.out.println(numer);
        pregunta = "mete float";
        float num = leerfloat(pregunta);
        System.out.println(num);
        pregunta = "mete cadena";
        String leido = leercadena(pregunta);
        System.out.println(leido);
    }
}
