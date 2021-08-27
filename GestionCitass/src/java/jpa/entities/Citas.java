/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
 * @author SENA
 */
@Entity
@Table(name = "citas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c")
    , @NamedQuery(name = "Citas.findByIdCita", query = "SELECT c FROM Citas c WHERE c.idCita = :idCita")
    , @NamedQuery(name = "Citas.findByCitFecha", query = "SELECT c FROM Citas c WHERE c.citFecha = :citFecha")
    , @NamedQuery(name = "Citas.findByCitHora", query = "SELECT c FROM Citas c WHERE c.citHora = :citHora")
    , @NamedQuery(name = "Citas.findByCitEstado", query = "SELECT c FROM Citas c WHERE c.citEstado = :citEstado")})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCita")
    private Integer idCita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "citFecha")
    @Temporal(TemporalType.DATE)
    private Date citFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "citHora")
    @Temporal(TemporalType.TIME)
    private Date citHora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "citEstado")
    private String citEstado;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "citObservaciones")
    private String citObservaciones;
    @JoinColumn(name = "citConsultorio", referencedColumnName = "idConsultorio")
    @ManyToOne(optional = false)
    private Consultorios citConsultorio;
    @JoinColumn(name = "citMedico", referencedColumnName = "idMedico")
    @ManyToOne(optional = false)
    private Medicos citMedico;
    @JoinColumn(name = "citPaciente", referencedColumnName = "idPaciente")
    @ManyToOne(optional = false)
    private Pacientes citPaciente;

    public Citas() {
    }

    public Citas(Integer idCita) {
        this.idCita = idCita;
    }

    public Citas(Integer idCita, Date citFecha, Date citHora, String citEstado, String citObservaciones) {
        this.idCita = idCita;
        this.citFecha = citFecha;
        this.citHora = citHora;
        this.citEstado = citEstado;
        this.citObservaciones = citObservaciones;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public Date getCitFecha() {
        return citFecha;
    }

    public void setCitFecha(Date citFecha) {
        this.citFecha = citFecha;
    }

    public Date getCitHora() {
        return citHora;
    }

    public void setCitHora(Date citHora) {
        this.citHora = citHora;
    }

    public String getCitEstado() {
        return citEstado;
    }

    public void setCitEstado(String citEstado) {
        this.citEstado = citEstado;
    }

    public String getCitObservaciones() {
        return citObservaciones;
    }

    public void setCitObservaciones(String citObservaciones) {
        this.citObservaciones = citObservaciones;
    }

    public Consultorios getCitConsultorio() {
        return citConsultorio;
    }

    public void setCitConsultorio(Consultorios citConsultorio) {
        this.citConsultorio = citConsultorio;
    }

    public Medicos getCitMedico() {
        return citMedico;
    }

    public void setCitMedico(Medicos citMedico) {
        this.citMedico = citMedico;
    }

    public Pacientes getCitPaciente() {
        return citPaciente;
    }

    public void setCitPaciente(Pacientes citPaciente) {
        this.citPaciente = citPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCita != null ? idCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.idCita == null && other.idCita != null) || (this.idCita != null && !this.idCita.equals(other.idCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Citas[ idCita=" + idCita + " ]";
    }
    
}
