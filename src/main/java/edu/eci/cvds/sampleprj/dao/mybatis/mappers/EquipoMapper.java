package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import edu.eci.cvds.sample.entities.Equipo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipoMapper {

    public Equipo consultarEquipo(@Param("id")int idElemento);

    public List<Equipo> consultarEquipos();
}