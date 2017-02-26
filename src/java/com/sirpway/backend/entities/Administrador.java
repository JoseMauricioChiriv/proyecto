/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "administradores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.findByIdAdministrador", query = "SELECT a FROM Administrador a WHERE a.idAdministrador = :idAdministrador"),
    @NamedQuery(name = "Administrador.findByTituloAdministrador", query = "SELECT a FROM Administrador a WHERE a.tituloAdministrador = :tituloAdministrador"),
    @NamedQuery(name = "Administrador.findBySuedoAdministrador", query = "SELECT a FROM Administrador a WHERE a.suedoAdministrador = :suedoAdministrador"),
    @NamedQuery(name = "Administrador.findByEpsAdministrador", query = "SELECT a FROM Administrador a WHERE a.epsAdministrador = :epsAdministrador")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAdministrador")
    private Integer idAdministrador;
    @Size(max = 65)
    @Column(name = "tituloAdministrador")
    private String tituloAdministrador;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "suedoAdministrador")
    private Double suedoAdministrador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "epsAdministrador")
    private String epsAdministrador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "administradoresidAdministrador", fetch = FetchType.LAZY)
    private List<Respuesta> respuestaList;
    @JoinColumn(name = "personas_documentoIdentidad", referencedColumnName = "documentoIdentidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona personasdocumentoIdentidad;

    public Administrador() {
    }

    public Administrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public Administrador(Integer idAdministrador, String epsAdministrador) {
        this.idAdministrador = idAdministrador;
        this.epsAdministrador = epsAdministrador;
    }

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getTituloAdministrador() {
        return tituloAdministrador;
    }

    public void setTituloAdministrador(String tituloAdministrador) {
        this.tituloAdministrador = tituloAdministrador;
    }

    public Double getSuedoAdministrador() {
        return suedoAdministrador;
    }

    public void setSuedoAdministrador(Double suedoAdministrador) {
        this.suedoAdministrador = suedoAdministrador;
    }

    public String getEpsAdministrador() {
        return epsAdministrador;
    }

    public void setEpsAdministrador(String epsAdministrador) {
        this.epsAdministrador = epsAdministrador;
    }

    @XmlTransient
    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    public Persona getPersonasdocumentoIdentidad() {
        return personasdocumentoIdentidad;
    }

    public void setPersonasdocumentoIdentidad(Persona personasdocumentoIdentidad) {
        this.personasdocumentoIdentidad = personasdocumentoIdentidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAdministrador != null ? idAdministrador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.idAdministrador == null && other.idAdministrador != null) || (this.idAdministrador != null && !this.idAdministrador.equals(other.idAdministrador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sirpway.backend.entities.Administrador[ idAdministrador=" + idAdministrador + " ]";
    }
    
}
