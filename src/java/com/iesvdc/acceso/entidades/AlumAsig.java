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
@Table(name = "ALUM_ASIG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlumAsig.findAll", query = "SELECT a FROM AlumAsig a")
    , @NamedQuery(name = "AlumAsig.findByAsignatura", query = "SELECT a FROM AlumAsig a WHERE a.alumAsigPK.asignatura = :asignatura")
    , @NamedQuery(name = "AlumAsig.findByAlumno", query = "SELECT a FROM AlumAsig a WHERE a.alumAsigPK.alumno = :alumno")
    , @NamedQuery(name = "AlumAsig.findByFaltas", query = "SELECT a FROM AlumAsig a WHERE a.faltas = :faltas")})
public class AlumAsig implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlumAsigPK alumAsigPK;
    @Column(name = "FALTAS")
    private Integer faltas;
    @JoinColumn(name = "ALUMNO", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alumno alumno1;
    @JoinColumn(name = "ASIGNATURA", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Asignatura asignatura1;

    public AlumAsig() {
    }

    public AlumAsig(AlumAsigPK alumAsigPK) {
        this.alumAsigPK = alumAsigPK;
    }

    public AlumAsig(int asignatura, int alumno) {
        this.alumAsigPK = new AlumAsigPK(asignatura, alumno);
    }

    public AlumAsigPK getAlumAsigPK() {
        return alumAsigPK;
    }

    public void setAlumAsigPK(AlumAsigPK alumAsigPK) {
        this.alumAsigPK = alumAsigPK;
    }

    public Integer getFaltas() {
        return faltas;
    }

    public void setFaltas(Integer faltas) {
        this.faltas = faltas;
    }

    public Alumno getAlumno1() {
        return alumno1;
    }

    public void setAlumno1(Alumno alumno1) {
        this.alumno1 = alumno1;
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
        hash += (alumAsigPK != null ? alumAsigPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumAsig)) {
            return false;
        }
        AlumAsig other = (AlumAsig) object;
        if ((this.alumAsigPK == null && other.alumAsigPK != null) || (this.alumAsigPK != null && !this.alumAsigPK.equals(other.alumAsigPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iesvdc.acceso.entidades.AlumAsig[ alumAsigPK=" + alumAsigPK + " ]";
    }
    
}
