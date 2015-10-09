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
@Table(name = "indicadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicadores.findAll", query = "SELECT i FROM Indicadores i"),
    @NamedQuery(name = "Indicadores.findByIndicadoresId", query = "SELECT i FROM Indicadores i WHERE i.indicadoresId = :indicadoresId"),
    @NamedQuery(name = "Indicadores.findByCapacidadesId", query = "SELECT i FROM Indicadores i WHERE i.capacidadesId = :capacidadesId"),
    @NamedQuery(name = "Indicadores.findByDescripcion", query = "SELECT i FROM Indicadores i WHERE i.descripcion = :descripcion")})
public class Indicadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "indicadores_id")
    private String indicadoresId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "capacidades_id")
    private String capacidadesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Descripcion")
    private String descripcion;

    public Indicadores() {
    }

    public Indicadores(String indicadoresId) {
        this.indicadoresId = indicadoresId;
    }

    public Indicadores(String indicadoresId, String capacidadesId, String descripcion) {
        this.indicadoresId = indicadoresId;
        this.capacidadesId = capacidadesId;
        this.descripcion = descripcion;
    }

    public String getIndicadoresId() {
        return indicadoresId;
    }

    public void setIndicadoresId(String indicadoresId) {
        this.indicadoresId = indicadoresId;
    }

    public String getCapacidadesId() {
        return capacidadesId;
    }

    public void setCapacidadesId(String capacidadesId) {
        this.capacidadesId = capacidadesId;
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
        hash += (indicadoresId != null ? indicadoresId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicadores)) {
            return false;
        }
        Indicadores other = (Indicadores) object;
        if ((this.indicadoresId == null && other.indicadoresId != null) || (this.indicadoresId != null && !this.indicadoresId.equals(other.indicadoresId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.syllabus.modelo.Indicadores[ indicadoresId=" + indicadoresId + " ]";
    }
    
}
