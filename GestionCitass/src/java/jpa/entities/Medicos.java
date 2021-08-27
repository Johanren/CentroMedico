/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

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
 * @author SENA
 */
@Entity
@Table(name = "medicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medicos.findAll", query = "SELECT m FROM Medicos m")
    , @NamedQuery(name = "Medicos.findByIdMedico", query = "SELECT m FROM Medicos m WHERE m.idMedico = :idMedico")
    , @NamedQuery(name = "Medicos.findByMedIdentificacion", query = "SELECT m FROM Medicos m WHERE m.medIdentificacion = :medIdentificacion")
    , @NamedQuery(name = "Medicos.findByMedNombres", query = "SELECT m FROM Medicos m WHERE m.medNombres = :medNombres")
    , @NamedQuery(name = "Medicos.findByMedApellidos", query = "SELECT m FROM Medicos m WHERE m.medApellidos = :medApellidos")
    , @NamedQuery(name = "Medicos.findByMedEspecialidad", query = "SELECT m FROM Medicos m WHERE m.medEspecialidad = :medEspecialidad")
    , @NamedQuery(name = "Medicos.findByMedTelefono", query = "SELECT m FROM Medicos m WHERE m.medTelefono = :medTelefono")
    , @NamedQuery(name = "Medicos.findByMedCorreo", query = "SELECT m FROM Medicos m WHERE m.medCorreo = :medCorreo")})
public class Medicos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMedico")
    private Integer idMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "medIdentificacion")
    private String medIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "medNombres")
    private String medNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "medApellidos")
    private String medApellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "medEspecialidad")
    private String medEspecialidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "medTelefono")
    private String medTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "medCorreo")
    private String medCorreo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citMedico")
    private Collection<Citas> citasCollection;

    public Medicos() {
    }

    public Medicos(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Medicos(Integer idMedico, String medIdentificacion, String medNombres, String medApellidos, String medEspecialidad, String medTelefono, String medCorreo) {
        this.idMedico = idMedico;
        this.medIdentificacion = medIdentificacion;
        this.medNombres = medNombres;
        this.medApellidos = medApellidos;
        this.medEspecialidad = medEspecialidad;
        this.medTelefono = medTelefono;
        this.medCorreo = medCorreo;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public String getMedIdentificacion() {
        return medIdentificacion;
    }

    public void setMedIdentificacion(String medIdentificacion) {
        this.medIdentificacion = medIdentificacion;
    }

    public String getMedNombres() {
        return medNombres;
    }

    public void setMedNombres(String medNombres) {
        this.medNombres = medNombres;
    }

    public String getMedApellidos() {
        return medApellidos;
    }

    public void setMedApellidos(String medApellidos) {
        this.medApellidos = medApellidos;
    }

    public String getMedEspecialidad() {
        return medEspecialidad;
    }

    public void setMedEspecialidad(String medEspecialidad) {
        this.medEspecialidad = medEspecialidad;
    }

    public String getMedTelefono() {
        return medTelefono;
    }

    public void setMedTelefono(String medTelefono) {
        this.medTelefono = medTelefono;
    }

    public String getMedCorreo() {
        return medCorreo;
    }

    public void setMedCorreo(String medCorreo) {
        this.medCorreo = medCorreo;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedico != null ? idMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicos)) {
            return false;
        }
        Medicos other = (Medicos) object;
        if ((this.idMedico == null && other.idMedico != null) || (this.idMedico != null && !this.idMedico.equals(other.idMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return medIdentificacion + " " + medNombres + " " + medApellidos;
    }
    
}
