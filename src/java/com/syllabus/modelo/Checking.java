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
@Table(name = "checking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Checking.findAll", query = "SELECT c FROM Checking c"),
    @NamedQuery(name = "Checking.findByCheckingId", query = "SELECT c FROM Checking c WHERE c.checkingId = :checkingId"),
    @NamedQuery(name = "Checking.findByIndicadoresId", query = "SELECT c FROM Checking c WHERE c.indicadoresId = :indicadoresId"),
    @NamedQuery(name = "Checking.findByUnidadesId", query = "SELECT c FROM Checking c WHERE c.unidadesId = :unidadesId")})
public class Checking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "checking_id")
    private String checkingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "indicadores_id")
    private String indicadoresId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "unidades_id")
    private String unidadesId;

    public Checking() {
    }

    public Checking(String checkingId) {
        this.checkingId = checkingId;
    }

    public Checking(String checkingId, String indicadoresId, String unidadesId) {
        this.checkingId = checkingId;
        this.indicadoresId = indicadoresId;
        this.unidadesId = unidadesId;
    }

    public String getCheckingId() {
        return checkingId;
    }

    public void setCheckingId(String checkingId) {
        this.checkingId = checkingId;
    }

    public String getIndicadoresId() {
        return indicadoresId;
    }

    public void setIndicadoresId(String indicadoresId) {
        this.indicadoresId = indicadoresId;
    }

    public String getUnidadesId() {
        return unidadesId;
    }

    public void setUnidadesId(String unidadesId) {
        this.unidadesId = unidadesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (checkingId != null ? checkingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Checking)) {
            return false;
        }
        Checking other = (Checking) object;
        if ((this.checkingId == null && other.checkingId != null) || (this.checkingId != null && !this.checkingId.equals(other.checkingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.syllabus.modelo.Checking[ checkingId=" + checkingId + " ]";
    }
    
}
