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
@Table(name = "sucursales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByIdSucursal", query = "SELECT s FROM Sucursal s WHERE s.idSucursal = :idSucursal"),
    @NamedQuery(name = "Sucursal.findByNombreSucursal", query = "SELECT s FROM Sucursal s WHERE s.nombreSucursal = :nombreSucursal"),
    @NamedQuery(name = "Sucursal.findByUbicacionSucursal", query = "SELECT s FROM Sucursal s WHERE s.ubicacionSucursal = :ubicacionSucursal"),
    @NamedQuery(name = "Sucursal.findByTelefonoSucursal", query = "SELECT s FROM Sucursal s WHERE s.telefonoSucursal = :telefonoSucursal"),
    @NamedQuery(name = "Sucursal.findByCorreoElectronicoSucursal", query = "SELECT s FROM Sucursal s WHERE s.correoElectronicoSucursal = :correoElectronicoSucursal")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSucursal")
    private Integer idSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "nombreSucursal")
    private String nombreSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 95)
    @Column(name = "ubicacionSucursal")
    private String ubicacionSucursal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefonoSucursal")
    private long telefonoSucursal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 95)
    @Column(name = "correoElectronicoSucursal")
    private String correoElectronicoSucursal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalesidSucursal", fetch = FetchType.LAZY)
    private List<Venta> ventaList;

    public Sucursal() {
    }

    public Sucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public Sucursal(Integer idSucursal, String nombreSucursal, String ubicacionSucursal, long telefonoSucursal, String correoElectronicoSucursal) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.ubicacionSucursal = ubicacionSucursal;
        this.telefonoSucursal = telefonoSucursal;
        this.correoElectronicoSucursal = correoElectronicoSucursal;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getUbicacionSucursal() {
        return ubicacionSucursal;
    }

    public void setUbicacionSucursal(String ubicacionSucursal) {
        this.ubicacionSucursal = ubicacionSucursal;
    }

    public long getTelefonoSucursal() {
        return telefonoSucursal;
    }

    public void setTelefonoSucursal(long telefonoSucursal) {
        this.telefonoSucursal = telefonoSucursal;
    }

    public String getCorreoElectronicoSucursal() {
        return correoElectronicoSucursal;
    }

    public void setCorreoElectronicoSucursal(String correoElectronicoSucursal) {
        this.correoElectronicoSucursal = correoElectronicoSucursal;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSucursal != null ? idSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idSucursal == null && other.idSucursal != null) || (this.idSucursal != null && !this.idSucursal.equals(other.idSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sirpway.backend.entities.Sucursal[ idSucursal=" + idSucursal + " ]";
    }
    
}
