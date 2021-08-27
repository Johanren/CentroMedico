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
@Table(name = "consultorios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultorios.findAll", query = "SELECT c FROM Consultorios c")
    , @NamedQuery(name = "Consultorios.findByIdConsultorio", query = "SELECT c FROM Consultorios c WHERE c.idConsultorio = :idConsultorio")
    , @NamedQuery(name = "Consultorios.findByConNombre", query = "SELECT c FROM Consultorios c WHERE c.conNombre = :conNombre")})
public class Consultorios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConsultorio")
    private Integer idConsultorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "conNombre")
    private String conNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citConsultorio")
    private Collection<Citas> citasCollection;

    public Consultorios() {
    }

    public Consultorios(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public Consultorios(Integer idConsultorio, String conNombre) {
        this.idConsultorio = idConsultorio;
        this.conNombre = conNombre;
    }

    public Integer getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(Integer idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    public String getConNombre() {
        return conNombre;
    }

    public void setConNombre(String conNombre) {
        this.conNombre = conNombre;
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
        hash += (idConsultorio != null ? idConsultorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultorios)) {
            return false;
        }
        Consultorios other = (Consultorios) object;
        if ((this.idConsultorio == null && other.idConsultorio != null) || (this.idConsultorio != null && !this.idConsultorio.equals(other.idConsultorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return conNombre;
    }
    
}
