/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sirpway.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByIdPermiso", query = "SELECT p FROM Permiso p WHERE p.idPermiso = :idPermiso"),
    @NamedQuery(name = "Permiso.findByNombrePermiso", query = "SELECT p FROM Permiso p WHERE p.nombrePermiso = :nombrePermiso"),
    @NamedQuery(name = "Permiso.findByCodigoSubMenu", query = "SELECT p FROM Permiso p WHERE p.codigoSubMenu = :codigoSubMenu"),
    @NamedQuery(name = "Permiso.findByUrlPermiso", query = "SELECT p FROM Permiso p WHERE p.urlPermiso = :urlPermiso"),
    @NamedQuery(name = "Permiso.findByEstadoPermiso", query = "SELECT p FROM Permiso p WHERE p.estadoPermiso = :estadoPermiso")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPermiso")
    private Integer idPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombrePermiso")
    private String nombrePermiso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoSubMenu")
    private int codigoSubMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "urlPermiso")
    private String urlPermiso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoPermiso")
    private boolean estadoPermiso;
    @JoinTable(name = "roles_has_permisos", joinColumns = {
        @JoinColumn(name = "permisos_idPermiso", referencedColumnName = "idPermiso")}, inverseJoinColumns = {
        @JoinColumn(name = "roles_idRol", referencedColumnName = "idRol")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Rol> rolList;
    @OneToMany(mappedBy = "permisosidPermiso", fetch = FetchType.LAZY)
    private List<Permiso> permisoList;
    @JoinColumn(name = "permisos_idPermiso", referencedColumnName = "idPermiso")
    @ManyToOne(fetch = FetchType.LAZY)
    private Permiso permisosidPermiso;

    public Permiso() {
    }

    public Permiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Permiso(Integer idPermiso, String nombrePermiso, int codigoSubMenu, String urlPermiso, boolean estadoPermiso) {
        this.idPermiso = idPermiso;
        this.nombrePermiso = nombrePermiso;
        this.codigoSubMenu = codigoSubMenu;
        this.urlPermiso = urlPermiso;
        this.estadoPermiso = estadoPermiso;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public int getCodigoSubMenu() {
        return codigoSubMenu;
    }

    public void setCodigoSubMenu(int codigoSubMenu) {
        this.codigoSubMenu = codigoSubMenu;
    }

    public String getUrlPermiso() {
        return urlPermiso;
    }

    public void setUrlPermiso(String urlPermiso) {
        this.urlPermiso = urlPermiso;
    }

    public boolean getEstadoPermiso() {
        return estadoPermiso;
    }

    public void setEstadoPermiso(boolean estadoPermiso) {
        this.estadoPermiso = estadoPermiso;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    public Permiso getPermisosidPermiso() {
        return permisosidPermiso;
    }

    public void setPermisosidPermiso(Permiso permisosidPermiso) {
        this.permisosidPermiso = permisosidPermiso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sirpway.backend.entities.Permiso[ idPermiso=" + idPermiso + " ]";
    }
    
}
