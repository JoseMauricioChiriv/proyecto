/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.backend.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "personas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByDocumentoIdentidad", query = "SELECT p FROM Persona p WHERE p.documentoIdentidad = :documentoIdentidad"),
    @NamedQuery(name = "Persona.findByNombrePersona", query = "SELECT p FROM Persona p WHERE p.nombrePersona = :nombrePersona"),
    @NamedQuery(name = "Persona.findByApellidoPersona", query = "SELECT p FROM Persona p WHERE p.apellidoPersona = :apellidoPersona"),
    @NamedQuery(name = "Persona.findByFechaNacimientoPersona", query = "SELECT p FROM Persona p WHERE p.fechaNacimientoPersona = :fechaNacimientoPersona"),
    @NamedQuery(name = "Persona.findByGeneroPersona", query = "SELECT p FROM Persona p WHERE p.generoPersona = :generoPersona"),
    @NamedQuery(name = "Persona.findByTelefonoPersona", query = "SELECT p FROM Persona p WHERE p.telefonoPersona = :telefonoPersona"),
    @NamedQuery(name = "Persona.findByDireccionPersona", query = "SELECT p FROM Persona p WHERE p.direccionPersona = :direccionPersona"),
    @NamedQuery(name = "Persona.findByCorreoElectronicoPersona", query = "SELECT p FROM Persona p WHERE p.correoElectronicoPersona = :correoElectronicoPersona"),
    @NamedQuery(name = "Persona.findByContrase\u00f1aPersona", query = "SELECT p FROM Persona p WHERE p.contrase\u00f1aPersona = :contrase\u00f1aPersona")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoIdentidad")
    private Long documentoIdentidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NombrePersona")
    private String nombrePersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ApellidoPersona")
    private String apellidoPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacimientoPersona")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimientoPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "generoPersona")
    private String generoPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefonoPersona")
    private long telefonoPersona;
    @Size(max = 75)
    @Column(name = "direccionPersona")
    private String direccionPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 95)
    @Column(name = "correoElectronicoPersona")
    private String correoElectronicoPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "contrase\u00f1aPersona")
    private String contraseñaPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personasdocumentoIdentidad", fetch = FetchType.LAZY)
    private List<Comensal> comensalList;
    @JoinColumn(name = "roles_idRol", referencedColumnName = "idRol")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rol rolesidRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personasdocumentoIdentidad", fetch = FetchType.LAZY)
    private List<Mesero> meseroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personasdocumentoIdentidad", fetch = FetchType.LAZY)
    private List<Administrador> administradorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personasdocumentoIdentidad", fetch = FetchType.LAZY)
    private List<Solicitud> solicitudList;

    public Persona() {
    }

    public Persona(Long documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public Persona(Long documentoIdentidad, String nombrePersona, String apellidoPersona, Date fechaNacimientoPersona, String generoPersona, long telefonoPersona, String correoElectronicoPersona, String contraseñaPersona) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.fechaNacimientoPersona = fechaNacimientoPersona;
        this.generoPersona = generoPersona;
        this.telefonoPersona = telefonoPersona;
        this.correoElectronicoPersona = correoElectronicoPersona;
        this.contraseñaPersona = contraseñaPersona;
    }

    public Long getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(Long documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public Date getFechaNacimientoPersona() {
        return fechaNacimientoPersona;
    }

    public void setFechaNacimientoPersona(Date fechaNacimientoPersona) {
        this.fechaNacimientoPersona = fechaNacimientoPersona;
    }

    public String getGeneroPersona() {
        return generoPersona;
    }

    public void setGeneroPersona(String generoPersona) {
        this.generoPersona = generoPersona;
    }

    public long getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(long telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public String getCorreoElectronicoPersona() {
        return correoElectronicoPersona;
    }

    public void setCorreoElectronicoPersona(String correoElectronicoPersona) {
        this.correoElectronicoPersona = correoElectronicoPersona;
    }

    public String getContraseñaPersona() {
        return contraseñaPersona;
    }

    public void setContraseñaPersona(String contraseñaPersona) {
        this.contraseñaPersona = contraseñaPersona;
    }

    @XmlTransient
    public List<Comensal> getComensalList() {
        return comensalList;
    }

    public void setComensalList(List<Comensal> comensalList) {
        this.comensalList = comensalList;
    }

    public Rol getRolesidRol() {
        return rolesidRol;
    }

    public void setRolesidRol(Rol rolesidRol) {
        this.rolesidRol = rolesidRol;
    }

    @XmlTransient
    public List<Mesero> getMeseroList() {
        return meseroList;
    }

    public void setMeseroList(List<Mesero> meseroList) {
        this.meseroList = meseroList;
    }

    @XmlTransient
    public List<Administrador> getAdministradorList() {
        return administradorList;
    }

    public void setAdministradorList(List<Administrador> administradorList) {
        this.administradorList = administradorList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentoIdentidad != null ? documentoIdentidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.documentoIdentidad == null && other.documentoIdentidad != null) || (this.documentoIdentidad != null && !this.documentoIdentidad.equals(other.documentoIdentidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sirpway.backend.entities.Persona[ documentoIdentidad=" + documentoIdentidad + " ]";
    }
    
}
