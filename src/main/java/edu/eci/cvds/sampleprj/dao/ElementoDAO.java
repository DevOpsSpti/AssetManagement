package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.sample.entities.Elemento;
import org.mybatis.guice.transactional.Transactional;
import java.util.List;

public interface ElementoDAO {

    public Elemento consultarElemento(int numeroSerial ) throws PersistenceException;

    public List<Elemento> consultarElementos() throws PersistenceException;

    public List<Elemento> consultarElementosEquipo(int equipo) throws PersistenceException;

    @Transactional
    public void agregarElemento(String tipo, String marca, String referencia) throws PersistenceException;
}