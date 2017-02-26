/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.backend.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "solicitudes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByIdSolicitud", query = "SELECT s FROM Solicitud s WHERE s.idSolicitud = :idSolicitud"),
    @NamedQuery(name = "Solicitud.findByFechaSolicitud", query = "SELECT s FROM Solicitud s WHERE s.fechaSolicitud = :fechaSolicitud")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitud")
    private Integer idSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaSolicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "tipoSolicitudes_idTipoSolicitud", referencedColumnName = "idTipoSolicitud")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tiposolicitud tipoSolicitudesidTipoSolicitud;
    @JoinColumn(name = "respuestas_idRespuesta", referencedColumnName = "idRespuesta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Respuesta respuestasidRespuesta;
    @JoinColumn(name = "personas_documentoIdentidad", referencedColumnName = "documentoIdentidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona personasdocumentoIdentidad;

    public Solicitud() {
    }

    public Solicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Solicitud(Integer idSolicitud, Date fechaSolicitud, String observaciones) {
        this.idSolicitud = idSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.observaciones = observaciones;
    }

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Tiposolicitud getTipoSolicitudesidTipoSolicitud() {
        return tipoSolicitudesidTipoSolicitud;
    }

    public void setTipoSolicitudesidTipoSolicitud(Tiposolicitud tipoSolicitudesidTipoSolicitud) {
        this.tipoSolicitudesidTipoSolicitud = tipoSolicitudesidTipoSolicitud;
    }

    public Respuesta getRespuestasidRespuesta() {
        return respuestasidRespuesta;
    }

    public void setRespuestasidRespuesta(Respuesta respuestasidRespuesta) {
        this.respuestasidRespuesta = respuestasidRespuesta;
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
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sirpway.backend.entities.Solicitud[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
