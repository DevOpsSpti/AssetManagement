package edu.eci.cvds.sample.entities;

import java.io.Serializable;

public class Elemento implements Serializable{

    private String numeroSerial;
    private String tipo;
    private String marca;
    private String referencia;
    private boolean disponible;
    private String equipoAsociado;


    public Elemento (String numeroSerial, String tipo, String marca, String referencia, boolean disponible, String equipoAsociado) {
        this.numeroSerial = numeroSerial;
        this.tipo = tipo;
        this.marca = marca;
        this.referencia = referencia;
        this.disponible = disponible;
        this.equipoAsociado = equipoAsociado;
    }

    public Elemento() {

    }

    public String getNumeroSerial() {
        return numeroSerial;
    }

    public void setNumeroSerial(String numeroSerial) {
        this.numeroSerial = numeroSerial;
    }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getEquipoAsociado() {
        return equipoAsociado;
    }

    public void setEquipoAsociado(String equipoAsociado) {
        this.equipoAsociado = equipoAsociado;
    }

    @Override
    public String toString() {
        return "Elemento{ " + "numero serial= " + numeroSerial + ", tipo= " + tipo + ", marca= " +
                marca + ", referencia= " + referencia + ", disponible= " + disponible + ", equipo asociado= " + equipoAsociado + '}';
    }
}