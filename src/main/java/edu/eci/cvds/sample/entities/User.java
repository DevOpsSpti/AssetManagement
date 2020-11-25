package edu.eci.cvds.sample.entities;

import java.io.Serializable;

public class User implements Serializable{

    private String correo;
    private String nombreUsuario;
    private String clave;
    private String nombre;
    private String apellido;
    private String estado;
   
    
    public User (String correo, String nombreUsuario, String clave, String nombre, String apellido, String estado) {
        this.correo = correo;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
    }

    public User() {
    
    }

    public String getCorreo() {
         return correo;
    }

    public void setCorreo(String correo) {
         this.correo = correo;
    }

    public String getNombreUsuario() {
         return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
         this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
         return nombre;
    }

    public void setNombre(String nombre) {
         this.nombre = nombre;
    }

    public String getApellido() {
         return apellido;
    }

    public void setApellido(String apellido) {
         this.apellido = apellido;
    }

    public String getEstado() {
         return estado;
    }

    public void setEstado(String estado) {
         this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Usuario{ " + "correo= " + correo + ", nombre Usuario= " + nombreUsuario + ", nombre Usuario= " + nombreUsuario + ", nombre= " + nombre + ", apellido= " + apellido + ", estado= " + estado + '}';
    }
}