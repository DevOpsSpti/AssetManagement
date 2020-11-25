package edu.eci.cvds.sample.entities;

import java.io.Serializable;

public class Equipo implements Serializable{

    private String idEquipo;
    private String nombre;
    private boolean disponible;
    private String labAsociado;
    private boolean activo;

    public Equipo(String idEquipo, String nombre, boolean disponible, String labAsociado, boolean activo){
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.disponible = disponible;
        this.labAsociado = labAsociado;
        this.disponible = disponible;
        this.activo = activo;
    }

    public Equipo() { }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getLabAsociado() {
        return labAsociado;
    }

    public void setLabAsociado(String labAsociado) {
        this.labAsociado = labAsociado;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}