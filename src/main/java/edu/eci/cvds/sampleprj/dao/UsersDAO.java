package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.sample.entities.User;
import java.util.List;

public interface UsersDAO {

    public User consultarUsuario(String correo ) throws PersistenceException;

    public List<User> consultarUsuarios() throws PersistenceException;
}