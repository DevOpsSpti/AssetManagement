package edu.eci.cvds.sample.services;

import edu.eci.cvds.sample.entities.Equipo;

import java.util.List;

public interface ServiceEquipo {

    List<Equipo> consultarEquipos() throws ExcepcionServiceHistorialEquipos;

}