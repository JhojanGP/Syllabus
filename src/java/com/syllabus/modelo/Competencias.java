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
@Table(name = "competencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Competencias.findAll", query = "SELECT c FROM Competencias c"),
    @NamedQuery(name = "Competencias.findByCompetenciasId", query = "SELECT c FROM Competencias c WHERE c.competenciasId = :competenciasId"),
    @NamedQuery(name = "Competencias.findByAreasId", query = "SELECT c FROM Competencias c WHERE c.areasId = :areasId"),
    @NamedQuery(name = "Competencias.findByDescripcion", query = "SELECT c FROM Competencias c WHERE c.descripcion = :descripcion")})
public class Competencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "competencias_id")
    private String competenciasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "areas_id")
    private String areasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;

    public Competencias() {
    }

    public Competencias(String competenciasId) {
        this.competenciasId = competenciasId;
    }

    public Competencias(String competenciasId, String areasId, String descripcion) {
        this.competenciasId = competenciasId;
        this.areasId = areasId;
        this.descripcion = descripcion;
    }

    public String getCompetenciasId() {
        return competenciasId;
    }

    public void setCompetenciasId(String competenciasId) {
        this.competenciasId = competenciasId;
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
        hash += (competenciasId != null ? competenciasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Competencias)) {
            return false;
        }
        Competencias other = (Competencias) object;
        if ((this.competenciasId == null && other.competenciasId != null) || (this.competenciasId != null && !this.competenciasId.equals(other.competenciasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.syllabus.modelo.Competencias[ competenciasId=" + competenciasId + " ]";
    }
    
}
