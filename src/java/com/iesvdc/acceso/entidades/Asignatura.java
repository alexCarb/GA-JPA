/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juangu
 */
@Entity
@Table(name = "ASIGNATURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a")
    , @NamedQuery(name = "Asignatura.findById", query = "SELECT a FROM Asignatura a WHERE a.id = :id")
    , @NamedQuery(name = "Asignatura.findByNombre", query = "SELECT a FROM Asignatura a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Asignatura.findByCurso", query = "SELECT a FROM Asignatura a WHERE a.curso = :curso")
    , @NamedQuery(name = "Asignatura.findByCiclo", query = "SELECT a FROM Asignatura a WHERE a.ciclo = :ciclo")})
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "curso")
    private Short curso;
    @Size(max = 50)
    @Column(name = "ciclo")
    private String ciclo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura1")
    private Collection<AlumAsig> alumAsigCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura1")
    private Collection<ProfAsig> profAsigCollection;

    public Asignatura() {
    }

    public Asignatura(Integer id) {
        this.id = id;
    }

    public Asignatura(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Short getCurso() {
        return curso;
    }

    public void setCurso(Short curso) {
        this.curso = curso;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    @XmlTransient
    public Collection<AlumAsig> getAlumAsigCollection() {
        return alumAsigCollection;
    }

    public void setAlumAsigCollection(Collection<AlumAsig> alumAsigCollection) {
        this.alumAsigCollection = alumAsigCollection;
    }

    @XmlTransient
    public Collection<ProfAsig> getProfAsigCollection() {
        return profAsigCollection;
    }

    public void setProfAsigCollection(Collection<ProfAsig> profAsigCollection) {
        this.profAsigCollection = profAsigCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iesvdc.acceso.entidades.Asignatura[ id=" + id + " ]";
    }
    
}
