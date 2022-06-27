/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import comida.Comida;
import java.util.Date;

/**
 *
 * @author Dani
 */
public class PoblacionException extends Exception {

    enum ErroType {

        FECHA_NO_VALIDA, NUMERONEGATIVO_NO_VALIDO, LUMINOSIDAD_NO_VALIDA, TIPO_DE_COMIDANOVALIDO;
    };
    private final String nombreExp;

    private Date fechaComienzo = new Date();

    private Date fechaFin = new Date();

    private final int numeroInicialBacterias;
    private final int Tipocom;

    private final float temperatura;

    private final Comida comida;

    private final ErroType error;

    public final Luminosidad.Luminos luminosidad;

    PoblacionException(String nombreExp, Date fechaComienzo, Date fechaFin, int numeroInicialBacterias, float temperatura, Luminosidad.Luminos luminosidad, int Tipocom, Comida comida, ErroType error) {
        this.nombreExp = nombreExp;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
        this.numeroInicialBacterias = numeroInicialBacterias;
        this.temperatura = temperatura;
        this.Tipocom = Tipocom;

        this.luminosidad = luminosidad;
        this.comida = comida;
        this.error = error;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        switch (getError()) {
            case FECHA_NO_VALIDA:
                return "La fecha de inicio y/o fin no es válida"
                        + "fecha comienzo: " + fechaComienzo + ""
                        + "fecha fin :" + fechaFin;
            case NUMERONEGATIVO_NO_VALIDO:
                return "la cantidad no puede ser negativa(" + numeroInicialBacterias + ")";
            case TIPO_DE_COMIDANOVALIDO:
                return "el tipo de comida no es valido(" + Tipocom + ")";
            case LUMINOSIDAD_NO_VALIDA:
                return "la luminosiddad no es válida" + getLuminosidad();

            default:
                return "Se produjo algún error";
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
     * @return the error
     */
    public ErroType getError() {
        return error;
    }

    /**
     * @return the luminosidad
     */
    public Luminosidad.Luminos getLuminosidad() {
        return luminosidad;
    }

    /**
     * @return the tipoC
     */
    /**
     * @return the luminosidad
     */
}
