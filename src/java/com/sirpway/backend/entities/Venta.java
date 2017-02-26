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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mauricio
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByIdVenta", query = "SELECT v FROM Venta v WHERE v.idVenta = :idVenta"),
    @NamedQuery(name = "Venta.findByFechaVenta", query = "SELECT v FROM Venta v WHERE v.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "Venta.findByIvaVenta", query = "SELECT v FROM Venta v WHERE v.ivaVenta = :ivaVenta")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVenta")
    private Integer idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaVenta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ivaVenta")
    private int ivaVenta;
    @ManyToMany(mappedBy = "ventaList", fetch = FetchType.LAZY)
    private List<Producto> productoList;
    @JoinColumn(name = "sucursales_idSucursal", referencedColumnName = "idSucursal")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sucursal sucursalesidSucursal;
    @JoinColumn(name = "meseros_idMesero", referencedColumnName = "idMesero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mesero meserosidMesero;

    public Venta() {
    }

    public Venta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(Integer idVenta, Date fechaVenta, int ivaVenta) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.ivaVenta = ivaVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIvaVenta() {
        return ivaVenta;
    }

    public void setIvaVenta(int ivaVenta) {
        this.ivaVenta = ivaVenta;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public Sucursal getSucursalesidSucursal() {
        return sucursalesidSucursal;
    }

    public void setSucursalesidSucursal(Sucursal sucursalesidSucursal) {
        this.sucursalesidSucursal = sucursalesidSucursal;
    }

    public Mesero getMeserosidMesero() {
        return meserosidMesero;
    }

    public void setMeserosidMesero(Mesero meserosidMesero) {
        this.meserosidMesero = meserosidMesero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sirpway.backend.entities.Venta[ idVenta=" + idVenta + " ]";
    }
    
}
