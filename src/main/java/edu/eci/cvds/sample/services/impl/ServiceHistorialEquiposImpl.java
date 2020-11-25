package edu.eci.cvds.sample.services.impl;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.sample.entities.User;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sampleprj.dao.UsersDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;

public class ServiceHistorialEquiposImpl implements ServiceHistorialEquipos {

    @Inject
    private UsersDAO UserDAO;

    @Override
    public User consultarUsuario(String correo) throws ExcepcionServiceHistorialEquipos {
        try {
            return UserDAO.consultarUsuario(correo);
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("No se pudo consultar el usuario " + correo, ex);
        }
    }

    @Override
    public List<User> consultarUsuarios() throws ExcepcionServiceHistorialEquipos {
        try {
            return UserDAO.consultarUsuarios();
        } catch (PersistenceException ex) {
            throw new UnsupportedOperationException("No se pudo consultar los usuarios ", ex);
        }
    }
}