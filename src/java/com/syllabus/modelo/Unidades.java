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
@Table(name = "unidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidades.findAll", query = "SELECT u FROM Unidades u"),
    @NamedQuery(name = "Unidades.findByUnidadesId", query = "SELECT u FROM Unidades u WHERE u.unidadesId = :unidadesId"),
    @NamedQuery(name = "Unidades.findByAreasId", query = "SELECT u FROM Unidades u WHERE u.areasId = :areasId"),
    @NamedQuery(name = "Unidades.findByUnidadNombre", query = "SELECT u FROM Unidades u WHERE u.unidadNombre = :unidadNombre")})
public class Unidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "unidades_id")
    private String unidadesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "areas_id")
    private String areasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "unidad_nombre")
    private String unidadNombre;

    public Unidades() {
    }

    public Unidades(String unidadesId) {
        this.unidadesId = unidadesId;
    }

    public Unidades(String unidadesId, String areasId, String unidadNombre) {
        this.unidadesId = unidadesId;
        this.areasId = areasId;
        this.unidadNombre = unidadNombre;
    }

    public String getUnidadesId() {
        return unidadesId;
    }

    public void setUnidadesId(String unidadesId) {
        this.unidadesId = unidadesId;
    }

    public String getAreasId() {
        return areasId;
    }

    public void setAreasId(String areasId) {
        this.areasId = areasId;
    }

    public String getUnidadNombre() {
        return unidadNombre;
    }

    public void setUnidadNombre(String unidadNombre) {
        this.unidadNombre = unidadNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unidadesId != null ? unidadesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidades)) {
            return false;
        }
        Unidades other = (Unidades) object;
        if ((this.unidadesId == null && other.unidadesId != null) || (this.unidadesId != null && !this.unidadesId.equals(other.unidadesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.syllabus.modelo.Unidades[ unidadesId=" + unidadesId + " ]";
    }
    
}
