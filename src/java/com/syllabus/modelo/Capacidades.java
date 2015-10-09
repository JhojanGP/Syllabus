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
@Table(name = "capacidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capacidades.findAll", query = "SELECT c FROM Capacidades c"),
    @NamedQuery(name = "Capacidades.findByCapacidadesId", query = "SELECT c FROM Capacidades c WHERE c.capacidadesId = :capacidadesId"),
    @NamedQuery(name = "Capacidades.findByCompetenciasId", query = "SELECT c FROM Capacidades c WHERE c.competenciasId = :competenciasId"),
    @NamedQuery(name = "Capacidades.findByDescripcion", query = "SELECT c FROM Capacidades c WHERE c.descripcion = :descripcion")})
public class Capacidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "capacidades_id")
    private String capacidadesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "competencias_id")
    private String competenciasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;

    public Capacidades() {
    }

    public Capacidades(String capacidadesId) {
        this.capacidadesId = capacidadesId;
    }

    public Capacidades(String capacidadesId, String competenciasId, String descripcion) {
        this.capacidadesId = capacidadesId;
        this.competenciasId = competenciasId;
        this.descripcion = descripcion;
    }

    public String getCapacidadesId() {
        return capacidadesId;
    }

    public void setCapacidadesId(String capacidadesId) {
        this.capacidadesId = capacidadesId;
    }

    public String getCompetenciasId() {
        return competenciasId;
    }

    public void setCompetenciasId(String competenciasId) {
        this.competenciasId = competenciasId;
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
        hash += (capacidadesId != null ? capacidadesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capacidades)) {
            return false;
        }
        Capacidades other = (Capacidades) object;
        if ((this.capacidadesId == null && other.capacidadesId != null) || (this.capacidadesId != null && !this.capacidadesId.equals(other.capacidadesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.syllabus.modelo.Capacidades[ capacidadesId=" + capacidadesId + " ]";
    }
    
}
