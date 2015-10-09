/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syllabus.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Keima
 */
@Entity
@Table(name = "trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t"),
    @NamedQuery(name = "Trabajador.findByTrabajadorId", query = "SELECT t FROM Trabajador t WHERE t.trabajadorId = :trabajadorId"),
    @NamedQuery(name = "Trabajador.findByPersonaId", query = "SELECT t FROM Trabajador t WHERE t.personaId = :personaId"),
    @NamedQuery(name = "Trabajador.findByAreasId", query = "SELECT t FROM Trabajador t WHERE t.areasId = :areasId"),
    @NamedQuery(name = "Trabajador.findByUsuario", query = "SELECT t FROM Trabajador t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "Trabajador.findByPassword", query = "SELECT t FROM Trabajador t WHERE t.password = :password"),
    @NamedQuery(name = "Trabajador.findByCargo", query = "SELECT t FROM Trabajador t WHERE t.cargo = :cargo"),
    @NamedQuery(name = "Trabajador.findByFechaAcceso", query = "SELECT t FROM Trabajador t WHERE t.fechaAcceso = :fechaAcceso")})
public class Trabajador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "trabajador_id")
    private String trabajadorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "persona_id")
    private String personaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "areas_id")
    private String areasId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_acceso")
    @Temporal(TemporalType.DATE)
    private Date fechaAcceso;

    public Trabajador() {
    }

    public Trabajador(String trabajadorId) {
        this.trabajadorId = trabajadorId;
    }

    public Trabajador(String trabajadorId, String personaId, String areasId, String usuario, String password, String cargo, Date fechaAcceso) {
        this.trabajadorId = trabajadorId;
        this.personaId = personaId;
        this.areasId = areasId;
        this.usuario = usuario;
        this.password = password;
        this.cargo = cargo;
        this.fechaAcceso = fechaAcceso;
    }

    public String getTrabajadorId() {
        return trabajadorId;
    }

    public void setTrabajadorId(String trabajadorId) {
        this.trabajadorId = trabajadorId;
    }

    public String getPersonaId() {
        return personaId;
    }

    public void setPersonaId(String personaId) {
        this.personaId = personaId;
    }

    public String getAreasId() {
        return areasId;
    }

    public void setAreasId(String areasId) {
        this.areasId = areasId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(Date fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trabajadorId != null ? trabajadorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.trabajadorId == null && other.trabajadorId != null) || (this.trabajadorId != null && !this.trabajadorId.equals(other.trabajadorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.syllabus.modelo.Trabajador[ trabajadorId=" + trabajadorId + " ]";
    }
    
}
