package edu.eci.cvds.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.PrimeFaces;

import edu.eci.cvds.sample.services.ExcepcionServiceHistorialEquipos;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.entities.User;
import edu.eci.cvds.sample.factory.ServiceFactory;

import java.util.List;

@ManagedBean(name = "Usuario")
@ApplicationScoped

public class UsuarioBean {

    private final ServiceHistorialEquipos serviceHE;
    public List<User> usuarios;

    public List<User> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<User> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioBean(){
        serviceHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
        try{
            usuarios = serviceHE.consultarUsuarios();
        }catch(ExcepcionServiceHistorialEquipos e){
        }
    }

    public void start(){ }

    public void showMessage(String confirmacion) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", confirmacion);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }
}