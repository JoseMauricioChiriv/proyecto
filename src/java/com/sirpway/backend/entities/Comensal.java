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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "comensales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comensal.findAll", query = "SELECT c FROM Comensal c"),
    @NamedQuery(name = "Comensal.findByIdComensal", query = "SELECT c FROM Comensal c WHERE c.idComensal = :idComensal")})
public class Comensal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idComensal")
    private Integer idComensal;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacionesComensal")
    private String observacionesComensal;
    @Lob
    @Size(max = 65535)
    @Column(name = "quejaReclamoComensal")
    private String quejaReclamoComensal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comensalesidComensal", fetch = FetchType.LAZY)
    private List<Reserva> reservaList;
    @JoinColumn(name = "personas_documentoIdentidad", referencedColumnName = "documentoIdentidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona personasdocumentoIdentidad;

    public Comensal() {
    }

    public Comensal(Integer idComensal) {
        this.idComensal = idComensal;
    }

    public Integer getIdComensal() {
        return idComensal;
    }

    public void setIdComensal(Integer idComensal) {
        this.idComensal = idComensal;
    }

    public String getObservacionesComensal() {
        return observacionesComensal;
    }

    public void setObservacionesComensal(String observacionesComensal) {
        this.observacionesComensal = observacionesComensal;
    }

    public String getQuejaReclamoComensal() {
        return quejaReclamoComensal;
    }

    public void setQuejaReclamoComensal(String quejaReclamoComensal) {
        this.quejaReclamoComensal = quejaReclamoComensal;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
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
        hash += (idComensal != null ? idComensal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comensal)) {
            return false;
        }
        Comensal other = (Comensal) object;
        if ((this.idComensal == null && other.idComensal != null) || (this.idComensal != null && !this.idComensal.equals(other.idComensal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sirpway.backend.entities.Comensal[ idComensal=" + idComensal + " ]";
    }
    
}
