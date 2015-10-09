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
@Table(name = "areas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a"),
    @NamedQuery(name = "Areas.findByAreasId", query = "SELECT a FROM Areas a WHERE a.areasId = :areasId"),
    @NamedQuery(name = "Areas.findByPeriodoId", query = "SELECT a FROM Areas a WHERE a.periodoId = :periodoId"),
    @NamedQuery(name = "Areas.findByAreaNombre", query = "SELECT a FROM Areas a WHERE a.areaNombre = :areaNombre")})
public class Areas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "areas_id")
    private String areasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "periodo_id")
    private String periodoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "area_nombre")
    private String areaNombre;

    public Areas() {
    }

    public Areas(String areasId) {
        this.areasId = areasId;
    }

    public Areas(String areasId, String periodoId, String areaNombre) {
        this.areasId = areasId;
        this.periodoId = periodoId;
        this.areaNombre = areaNombre;
    }

    public String getAreasId() {
        return areasId;
    }

    public void setAreasId(String areasId) {
        this.areasId = areasId;
    }

    public String getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(String periodoId) {
        this.periodoId = periodoId;
    }

    public String getAreaNombre() {
        return areaNombre;
    }

    public void setAreaNombre(String areaNombre) {
        this.areaNombre = areaNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areasId != null ? areasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.areasId == null && other.areasId != null) || (this.areasId != null && !this.areasId.equals(other.areasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.syllabus.modelo.Areas[ areasId=" + areasId + " ]";
    }
    
}
