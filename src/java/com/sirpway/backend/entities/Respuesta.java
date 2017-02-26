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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "respuestas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByIdRespuesta", query = "SELECT r FROM Respuesta r WHERE r.idRespuesta = :idRespuesta"),
    @NamedQuery(name = "Respuesta.findByFechaRespuesta", query = "SELECT r FROM Respuesta r WHERE r.fechaRespuesta = :fechaRespuesta")})
public class Respuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRespuesta")
    private Integer idRespuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRespuesta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRespuesta;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observacionesRespuesta")
    private String observacionesRespuesta;
    @JoinColumn(name = "administradores_idAdministrador", referencedColumnName = "idAdministrador")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Administrador administradoresidAdministrador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respuestasidRespuesta", fetch = FetchType.LAZY)
    private List<Solicitud> solicitudList;

    public Respuesta() {
    }

    public Respuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Respuesta(Integer idRespuesta, Date fechaRespuesta, String observacionesRespuesta) {
        this.idRespuesta = idRespuesta;
        this.fechaRespuesta = fechaRespuesta;
        this.observacionesRespuesta = observacionesRespuesta;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }

    public String getObservacionesRespuesta() {
        return observacionesRespuesta;
    }

    public void setObservacionesRespuesta(String observacionesRespuesta) {
        this.observacionesRespuesta = observacionesRespuesta;
    }

    public Administrador getAdministradoresidAdministrador() {
        return administradoresidAdministrador;
    }

    public void setAdministradoresidAdministrador(Administrador administradoresidAdministrador) {
        this.administradoresidAdministrador = administradoresidAdministrador;
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
        hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sirpway.backend.entities.Respuesta[ idRespuesta=" + idRespuesta + " ]";
    }
    
}
