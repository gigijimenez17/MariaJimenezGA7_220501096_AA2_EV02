package com.mindmeet.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Clase que representa un Usuario en el sistema MindMeet
 * @author Equipo MindMeet
 * @version 1.0
 */
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String rol; // ADMIN, USER, VIEWER
    private Date fechaRegistro;
    private boolean activo;
    
    // Constructor vacío
    public Usuario() {
        this.fechaRegistro = new Date();
        this.activo = true;
    }
    
    // Constructor con parámetros
    public Usuario(String nombre, String apellido, String email, String password, String rol) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRol() {
        return rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", rol='" + rol + '\'' +
                ", activo=" + activo +
                '}';
    }
}