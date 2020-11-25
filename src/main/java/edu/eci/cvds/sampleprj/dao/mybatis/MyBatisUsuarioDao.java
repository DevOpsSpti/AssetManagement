package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;

import edu.eci.cvds.sample.entities.User;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.UsersDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.UsuarioMapper;

import java.util.List;

public class MyBatisUsuarioDao implements UsersDAO{
    
    @Inject
    private UsuarioMapper usuarioMapper;

    @Override
    public User consultarUsuario(String correo) throws PersistenceException {
        try 
        {
            return usuarioMapper.consultarUsuario(correo);
        }catch(Exception e){
        throw new UnsupportedOperationException("Error al consultar el usuario:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<User> consultarUsuarios() throws PersistenceException {
        try 
        {
            return usuarioMapper.consultarUsuarios();
        }catch(Exception e){
        throw new UnsupportedOperationException("Error al consultar  usuarios:"+e.getLocalizedMessage(), e); 
        }
    }
}