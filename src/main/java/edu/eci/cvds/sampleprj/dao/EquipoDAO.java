package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.sample.entities.Equipo;

import java.util.List;

public interface EquipoDAO {
    public Equipo consultarEquipo(int id) throws PersistenceException;
    public List<Equipo> consultarEquipos() throws PersistenceException;
}
