/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.frontend.beans;

import com.sirpway.backend.entities.Persona;
import com.sirpway.backend.facade.PersonaFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 *
 * @author Mauricio
 */
@Named(value = "personaBean")
@RequestScoped
public class personaBean implements Serializable{

    /**
     * Creates a new instance of personaBean
     */
    @EJB(mappedName="RemoteService")
    private Persona persona;
    private PersonaFacadeLocal personaL;
    
    public personaBean() {
    }
    
    @PostConstruct
    public void init(){
        persona = new Persona();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void registroPersona(){
        try {
            personaL.create(persona);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso","Registro exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Registro fallido"));
        }
    }
    
    public List<Persona> listarPersona(){
        try {
            return personaL.findAll();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Listado fallido"));
        }
        return null;
    }
    
    public String redireccion(Persona pr){
        persona = pr;
        return "actualizarPersona";
    }
    
    public void actualizarPersona(Persona pa){
        personaL.edit(pa);
    }
    
    public void eliminarPersona(Persona pe){
        try {
            personaL.remove(persona);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Eliminar exitoso"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Eliminar fallido"));
        }
    }
}
