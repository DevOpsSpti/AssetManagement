package edu.eci.cvds.sample.services;

import edu.eci.cvds.sample.entities.User;
import edu.eci.cvds.sample.entities.Elemento;
import java.util.List;

public interface ServiceHistorialEquipos {

    User consultarUsuario(String correo) throws ExcepcionServiceHistorialEquipos;

    List<User> consultarUsuarios() throws ExcepcionServiceHistorialEquipos;

}