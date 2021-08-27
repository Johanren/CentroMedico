/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author SENA
 */
@Entity
@Table(name = "pacientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p")
    , @NamedQuery(name = "Pacientes.findByIdPaciente", query = "SELECT p FROM Pacientes p WHERE p.idPaciente = :idPaciente")
    , @NamedQuery(name = "Pacientes.findByPacIdentificacion", query = "SELECT p FROM Pacientes p WHERE p.pacIdentificacion = :pacIdentificacion")
    , @NamedQuery(name = "Pacientes.findByPacNombres", query = "SELECT p FROM Pacientes p WHERE p.pacNombres = :pacNombres")
    , @NamedQuery(name = "Pacientes.findByPacApellidos", query = "SELECT p FROM Pacientes p WHERE p.pacApellidos = :pacApellidos")
    , @NamedQuery(name = "Pacientes.findByPacFechaNacimiento", query = "SELECT p FROM Pacientes p WHERE p.pacFechaNacimiento = :pacFechaNacimiento")
    , @NamedQuery(name = "Pacientes.findByPacSexo", query = "SELECT p FROM Pacientes p WHERE p.pacSexo = :pacSexo")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPaciente")
    private Integer idPaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "pacIdentificacion")
    private String pacIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pacNombres")
    private String pacNombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pacApellidos")
    private String pacApellidos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pacFechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date pacFechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "pacSexo")
    private String pacSexo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "citPaciente")
    private Collection<Citas> citasCollection;

    public Pacientes() {
    }

    public Pacientes(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Pacientes(Integer idPaciente, String pacIdentificacion, String pacNombres, String pacApellidos, Date pacFechaNacimiento, String pacSexo) {
        this.idPaciente = idPaciente;
        this.pacIdentificacion = pacIdentificacion;
        this.pacNombres = pacNombres;
        this.pacApellidos = pacApellidos;
        this.pacFechaNacimiento = pacFechaNacimiento;
        this.pacSexo = pacSexo;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getPacIdentificacion() {
        return pacIdentificacion;
    }

    public void setPacIdentificacion(String pacIdentificacion) {
        this.pacIdentificacion = pacIdentificacion;
    }

    public String getPacNombres() {
        return pacNombres;
    }

    public void setPacNombres(String pacNombres) {
        this.pacNombres = pacNombres;
    }

    public String getPacApellidos() {
        return pacApellidos;
    }

    public void setPacApellidos(String pacApellidos) {
        this.pacApellidos = pacApellidos;
    }

    public Date getPacFechaNacimiento() {
        return pacFechaNacimiento;
    }

    public void setPacFechaNacimiento(Date pacFechaNacimiento) {
        this.pacFechaNacimiento = pacFechaNacimiento;
    }

    public String getPacSexo() {
        return pacSexo;
    }

    public void setPacSexo(String pacSexo) {
        this.pacSexo = pacSexo;
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
        hash += (idPaciente != null ? idPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.idPaciente == null && other.idPaciente != null) || (this.idPaciente != null && !this.idPaciente.equals(other.idPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pacIdentificacion + " " + pacNombres + " " + pacApellidos;
    }
    
}
