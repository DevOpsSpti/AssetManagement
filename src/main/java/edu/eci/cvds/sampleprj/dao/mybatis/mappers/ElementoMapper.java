package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.sample.entities.Elemento;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.guice.transactional.Transactional;

public interface ElementoMapper {

    public Elemento consultarElemento(@Param("numser")int numeroSerial );

    public List<Elemento> consultarElementos();

    public List<Elemento> consultarElementosEquipo(@Param("equipo")int equipo);

    @Transactional
    public void agregarElemento(@Param("tip")String tipo,@Param("marc")String marca,@Param("ref")String referencia);
}