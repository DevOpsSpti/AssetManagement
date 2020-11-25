package edu.eci.cvds.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.apache.shiro.SecurityUtils;

import org.apache.shiro.subject.Subject;
import java.io.IOException;
import java.io.Serializable;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;

@ManagedBean(name="loginBean")
@ViewScoped
public class LoginBean implements Serializable{

    private String userName;
    private String userPassword;
    private boolean rememberMe;
    private Subject currentUser;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public void loginUser() {
        try {

            currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName,userPassword,true);
            currentUser.login(token);
            currentUser.getSession().setAttribute("Correo",userName);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/inicio.xhtml");

        } catch (UnknownAccountException e) {

            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "El correo electronico que has introducido no coincide con ninguna cuenta.", "Credenciales incorrectas."));

        } catch (IncorrectCredentialsException e) {

            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Clave de acceso incorrecta.", "Credenciales incorrectas."));

        } catch (IOException e) {

            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Ha ocurrido algo.", "F"));

        }
    }

    public void logOut()
    {
        SecurityUtils.getSubject().logout();
        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/Index.xhtml");
        }catch (IOException ex) {
        }
    }

    public void isLogged(){
        if (SecurityUtils.getSubject().getSession().getAttribute("Correo") != null){
            try{
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/elemento.xhtml");
            }catch (IOException e){
                FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al redireccionar","Ocurrio un error en el servidor"));
            }
        }

    }
    public static String getUser(){
        return (String) SecurityUtils.getSubject().getSession().getAttribute("Correo");
    }
}