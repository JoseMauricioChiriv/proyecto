/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.frontend.beans;

import com.sirpway.backend.entities.Rol;
import com.sirpway.backend.facade.RolFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mauricio
 */
@Named(value = "rolController")
@RequestScoped
public class rolController {

    /**
     * Creates a new instance of rolController
     */
    @EJB(mappedName="RemoteService")
    private Rol rol;
    private RolFacadeLocal rolL;

    public rolController() {
    }

    @PostConstruct
    public void init() {
        rol = new Rol();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void crearRol() {
        try {
            rolL.create(rol);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso","Registro exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Registro fallido"));
        }
    }

    public List<Rol> listarRol() {
        try {
            return rolL.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Listado fallido"));
        }
        return null;
    }
    
    public String redireccion(Rol rr){
        rol = rr;
        return "actualizarRol";
    }
    
    public void actualizarRol(Rol ra){
        rolL.edit(ra);
    }
    
    public void eliminarRol(Rol re){
        try {
            rolL.remove(re);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso","Eliminar exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso","Eliminar Fallido"));
        }
    }
}
