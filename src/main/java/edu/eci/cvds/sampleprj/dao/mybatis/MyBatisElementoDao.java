package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;

import edu.eci.cvds.sample.entities.Elemento;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ElementoMapper;

import java.util.List;

public class MyBatisElementoDao implements ElementoDAO{

    @Inject
    private ElementoMapper elementoMapper;

    @Override
    public Elemento consultarElemento(int numeroSerial) throws PersistenceException {
        try
        {
            return elementoMapper.consultarElemento(numeroSerial);
        }catch(Exception e){
            throw new UnsupportedOperationException("Error al consultar el elemento:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Elemento> consultarElementos() throws PersistenceException {
        try
        {
            return elementoMapper.consultarElementos();
        }catch(Exception e){
            throw new UnsupportedOperationException("Error al consultar los elementos:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Elemento> consultarElementosEquipo(int equipo) throws PersistenceException {
        try
        {
            return elementoMapper.consultarElementosEquipo(equipo);
        }catch(Exception e){
            throw new UnsupportedOperationException("Error al consultar los elementos:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void agregarElemento(String tipo, String marca, String referencia) throws PersistenceException {
        try
        {
            elementoMapper.agregarElemento(tipo,marca,referencia);
        }catch(Exception e){
            throw new UnsupportedOperationException("Error al insertar el elemento: "+e.getLocalizedMessage(), e);
        }
    }
}