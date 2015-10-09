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
@Table(name = "privilegio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilegio.findAll", query = "SELECT p FROM Privilegio p"),
    @NamedQuery(name = "Privilegio.findByPrivilegioId", query = "SELECT p FROM Privilegio p WHERE p.privilegioId = :privilegioId"),
    @NamedQuery(name = "Privilegio.findByTrabajadorId", query = "SELECT p FROM Privilegio p WHERE p.trabajadorId = :trabajadorId"),
    @NamedQuery(name = "Privilegio.findByNivel", query = "SELECT p FROM Privilegio p WHERE p.nivel = :nivel")})
public class Privilegio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "privilegio_id")
    private String privilegioId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "trabajador_id")
    private String trabajadorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nivel")
    private int nivel;

    public Privilegio() {
    }

    public Privilegio(String privilegioId) {
        this.privilegioId = privilegioId;
    }

    public Privilegio(String privilegioId, String trabajadorId, int nivel) {
        this.privilegioId = privilegioId;
        this.trabajadorId = trabajadorId;
        this.nivel = nivel;
    }

    public String getPrivilegioId() {
        return privilegioId;
    }

    public void setPrivilegioId(String privilegioId) {
        this.privilegioId = privilegioId;
    }

    public String getTrabajadorId() {
        return trabajadorId;
    }

    public void setTrabajadorId(String trabajadorId) {
        this.trabajadorId = trabajadorId;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (privilegioId != null ? privilegioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilegio)) {
            return false;
        }
        Privilegio other = (Privilegio) object;
        if ((this.privilegioId == null && other.privilegioId != null) || (this.privilegioId != null && !this.privilegioId.equals(other.privilegioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.syllabus.modelo.Privilegio[ privilegioId=" + privilegioId + " ]";
    }
    
}
