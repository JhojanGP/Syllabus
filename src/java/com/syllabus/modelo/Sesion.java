/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Keima
 */
@Entity
@Table(name = "sesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sesion.findAll", query = "SELECT s FROM Sesion s"),
    @NamedQuery(name = "Sesion.findBySesionId", query = "SELECT s FROM Sesion s WHERE s.sesionId = :sesionId"),
    @NamedQuery(name = "Sesion.findByUnidadesId", query = "SELECT s FROM Sesion s WHERE s.unidadesId = :unidadesId"),
    @NamedQuery(name = "Sesion.findByNombreSesion", query = "SELECT s FROM Sesion s WHERE s.nombreSesion = :nombreSesion"),
    @NamedQuery(name = "Sesion.findByActividades", query = "SELECT s FROM Sesion s WHERE s.actividades = :actividades")})
public class Sesion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "sesion_id")
    private String sesionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "unidades_id")
    private String unidadesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre_sesion")
    private String nombreSesion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "actividades")
    private String actividades;

    public Sesion() {
    }

    public Sesion(String sesionId) {
        this.sesionId = sesionId;
    }

    public Sesion(String sesionId, String unidadesId, String nombreSesion, String actividades) {
        this.sesionId = sesionId;
        this.unidadesId = unidadesId;
        this.nombreSesion = nombreSesion;
        this.actividades = actividades;
    }

    public String getSesionId() {
        return sesionId;
    }

    public void setSesionId(String sesionId) {
        this.sesionId = sesionId;
    }

    public String getUnidadesId() {
        return unidadesId;
    }

    public void setUnidadesId(String unidadesId) {
        this.unidadesId = unidadesId;
    }

    public String getNombreSesion() {
        return nombreSesion;
    }

    public void setNombreSesion(String nombreSesion) {
        this.nombreSesion = nombreSesion;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sesionId != null ? sesionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sesion)) {
            return false;
        }
        Sesion other = (Sesion) object;
        if ((this.sesionId == null && other.sesionId != null) || (this.sesionId != null && !this.sesionId.equals(other.sesionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.syllabus.modelo.Sesion[ sesionId=" + sesionId + " ]";
    }
    
}
