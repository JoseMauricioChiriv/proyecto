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
@Table(name = "meseros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesero.findAll", query = "SELECT m FROM Mesero m"),
    @NamedQuery(name = "Mesero.findByIdMesero", query = "SELECT m FROM Mesero m WHERE m.idMesero = :idMesero"),
    @NamedQuery(name = "Mesero.findByEpsMesero", query = "SELECT m FROM Mesero m WHERE m.epsMesero = :epsMesero"),
    @NamedQuery(name = "Mesero.findBySueldoMesero", query = "SELECT m FROM Mesero m WHERE m.sueldoMesero = :sueldoMesero")})
public class Mesero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMesero")
    private Integer idMesero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "epsMesero")
    private String epsMesero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldoMesero")
    private double sueldoMesero;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meserosidMesero", fetch = FetchType.LAZY)
    private List<Venta> ventaList;
    @JoinColumn(name = "personas_documentoIdentidad", referencedColumnName = "documentoIdentidad")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona personasdocumentoIdentidad;

    public Mesero() {
    }

    public Mesero(Integer idMesero) {
        this.idMesero = idMesero;
    }

    public Mesero(Integer idMesero, String epsMesero, double sueldoMesero) {
        this.idMesero = idMesero;
        this.epsMesero = epsMesero;
        this.sueldoMesero = sueldoMesero;
    }

    public Integer getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(Integer idMesero) {
        this.idMesero = idMesero;
    }

    public String getEpsMesero() {
        return epsMesero;
    }

    public void setEpsMesero(String epsMesero) {
        this.epsMesero = epsMesero;
    }

    public double getSueldoMesero() {
        return sueldoMesero;
    }

    public void setSueldoMesero(double sueldoMesero) {
        this.sueldoMesero = sueldoMesero;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
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
        hash += (idMesero != null ? idMesero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesero)) {
            return false;
        }
        Mesero other = (Mesero) object;
        if ((this.idMesero == null && other.idMesero != null) || (this.idMesero != null && !this.idMesero.equals(other.idMesero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sirpway.backend.entities.Mesero[ idMesero=" + idMesero + " ]";
    }
    
}
