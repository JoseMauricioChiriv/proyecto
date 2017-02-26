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
@Table(name = "reservas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdReserva", query = "SELECT r FROM Reserva r WHERE r.idReserva = :idReserva"),
    @NamedQuery(name = "Reserva.findByTipoEvento", query = "SELECT r FROM Reserva r WHERE r.tipoEvento = :tipoEvento"),
    @NamedQuery(name = "Reserva.findByFechaReserva", query = "SELECT r FROM Reserva r WHERE r.fechaReserva = :fechaReserva"),
    @NamedQuery(name = "Reserva.findByNumeroPersonaReserva", query = "SELECT r FROM Reserva r WHERE r.numeroPersonaReserva = :numeroPersonaReserva"),
    @NamedQuery(name = "Reserva.findByEstadoReserva", query = "SELECT r FROM Reserva r WHERE r.estadoReserva = :estadoReserva")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReserva")
    private Integer idReserva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "tipoEvento")
    private String tipoEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaReserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaReserva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "numeroPersonaReserva")
    private String numeroPersonaReserva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "estadoReserva")
    private String estadoReserva;
    @JoinColumn(name = "mesas_idMesa", referencedColumnName = "idMesa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mesa mesasidMesa;
    @JoinColumn(name = "comensales_idComensal", referencedColumnName = "idComensal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Comensal comensalesidComensal;

    public Reserva() {
    }

    public Reserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva(Integer idReserva, String tipoEvento, Date fechaReserva, String numeroPersonaReserva, String estadoReserva) {
        this.idReserva = idReserva;
        this.tipoEvento = tipoEvento;
        this.fechaReserva = fechaReserva;
        this.numeroPersonaReserva = numeroPersonaReserva;
        this.estadoReserva = estadoReserva;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getNumeroPersonaReserva() {
        return numeroPersonaReserva;
    }

    public void setNumeroPersonaReserva(String numeroPersonaReserva) {
        this.numeroPersonaReserva = numeroPersonaReserva;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Mesa getMesasidMesa() {
        return mesasidMesa;
    }

    public void setMesasidMesa(Mesa mesasidMesa) {
        this.mesasidMesa = mesasidMesa;
    }

    public Comensal getComensalesidComensal() {
        return comensalesidComensal;
    }

    public void setComensalesidComensal(Comensal comensalesidComensal) {
        this.comensalesidComensal = comensalesidComensal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReserva != null ? idReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idReserva == null && other.idReserva != null) || (this.idReserva != null && !this.idReserva.equals(other.idReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sirpway.backend.entities.Reserva[ idReserva=" + idReserva + " ]";
    }
    
}
