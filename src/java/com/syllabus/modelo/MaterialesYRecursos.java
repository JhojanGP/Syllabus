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
@Table(name = "materiales_y_recursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaterialesYRecursos.findAll", query = "SELECT m FROM MaterialesYRecursos m"),
    @NamedQuery(name = "MaterialesYRecursos.findByMaterialesYRecursosId", query = "SELECT m FROM MaterialesYRecursos m WHERE m.materialesYRecursosId = :materialesYRecursosId"),
    @NamedQuery(name = "MaterialesYRecursos.findByAreasId", query = "SELECT m FROM MaterialesYRecursos m WHERE m.areasId = :areasId"),
    @NamedQuery(name = "MaterialesYRecursos.findByDescripcion", query = "SELECT m FROM MaterialesYRecursos m WHERE m.descripcion = :descripcion")})
public class MaterialesYRecursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "materiales_y_recursos_id")
    private String materialesYRecursosId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "areas_id")
    private String areasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descripcion")
    private String descripcion;

    public MaterialesYRecursos() {
    }

    public MaterialesYRecursos(String materialesYRecursosId) {
        this.materialesYRecursosId = materialesYRecursosId;
    }

    public MaterialesYRecursos(String materialesYRecursosId, String areasId, String descripcion) {
        this.materialesYRecursosId = materialesYRecursosId;
        this.areasId = areasId;
        this.descripcion = descripcion;
    }

    public String getMaterialesYRecursosId() {
        return materialesYRecursosId;
    }

    public void setMaterialesYRecursosId(String materialesYRecursosId) {
        this.materialesYRecursosId = materialesYRecursosId;
    }

    public String getAreasId() {
        return areasId;
    }

    public void setAreasId(String areasId) {
        this.areasId = areasId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (materialesYRecursosId != null ? materialesYRecursosId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialesYRecursos)) {
            return false;
        }
        MaterialesYRecursos other = (MaterialesYRecursos) object;
        if ((this.materialesYRecursosId == null && other.materialesYRecursosId != null) || (this.materialesYRecursosId != null && !this.materialesYRecursosId.equals(other.materialesYRecursosId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.syllabus.modelo.MaterialesYRecursos[ materialesYRecursosId=" + materialesYRecursosId + " ]";
    }
    
}
