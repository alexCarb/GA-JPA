/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juangu
 */
@Entity
@Table(name = "PROF_ASIG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfAsig.findAll", query = "SELECT p FROM ProfAsig p")
    , @NamedQuery(name = "ProfAsig.findByAsignatura", query = "SELECT p FROM ProfAsig p WHERE p.profAsigPK.asignatura = :asignatura")
    , @NamedQuery(name = "ProfAsig.findByProfesor", query = "SELECT p FROM ProfAsig p WHERE p.profAsigPK.profesor = :profesor")
    , @NamedQuery(name = "ProfAsig.findByHorasSemanales", query = "SELECT p FROM ProfAsig p WHERE p.horasSemanales = :horasSemanales")})
public class ProfAsig implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProfAsigPK profAsigPK;
    @Column(name = "HORAS_SEMANALES")
    private Integer horasSemanales;
    @JoinColumn(name = "PROFESOR", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Profesor profesor1;
    @JoinColumn(name = "ASIGNATURA", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Asignatura asignatura1;

    public ProfAsig() {
    }

    public ProfAsig(ProfAsigPK profAsigPK) {
        this.profAsigPK = profAsigPK;
    }

    public ProfAsig(int asignatura, int profesor) {
        this.profAsigPK = new ProfAsigPK(asignatura, profesor);
    }

    public ProfAsigPK getProfAsigPK() {
        return profAsigPK;
    }

    public void setProfAsigPK(ProfAsigPK profAsigPK) {
        this.profAsigPK = profAsigPK;
    }

    public Integer getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public Profesor getProfesor1() {
        return profesor1;
    }

    public void setProfesor1(Profesor profesor1) {
        this.profesor1 = profesor1;
    }

    public Asignatura getAsignatura1() {
        return asignatura1;
    }

    public void setAsignatura1(Asignatura asignatura1) {
        this.asignatura1 = asignatura1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profAsigPK != null ? profAsigPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfAsig)) {
            return false;
        }
        ProfAsig other = (ProfAsig) object;
        if ((this.profAsigPK == null && other.profAsigPK != null) || (this.profAsigPK != null && !this.profAsigPK.equals(other.profAsigPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iesvdc.acceso.entidades.ProfAsig[ profAsigPK=" + profAsigPK + " ]";
    }
    
}
