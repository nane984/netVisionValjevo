/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author branko.scekic
 */
@Entity
@Table(name = "gradiliste")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gradiliste.findAll", query = "SELECT g FROM Gradiliste g")
    , @NamedQuery(name = "Gradiliste.findById", query = "SELECT g FROM Gradiliste g WHERE g.id = :id")
    , @NamedQuery(name = "Gradiliste.findByGradiliste", query = "SELECT g FROM Gradiliste g WHERE g.gradiliste = :gradiliste")
    , @NamedQuery(name = "Gradiliste.findByAktivno", query = "SELECT g FROM Gradiliste g WHERE g.aktivno = :aktivno")})
public class Gradiliste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "gradiliste")
    private String gradiliste;
    @Basic(optional = false)
    @Column(name = "aktivno")
    private boolean aktivno;

    public Gradiliste() {
    }

    public Gradiliste(Long id) {
        this.id = id;
    }

    public Gradiliste(Long id, String gradiliste, boolean aktivno) {
        this.id = id;
        this.gradiliste = gradiliste;
        this.aktivno = aktivno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGradiliste() {
        return gradiliste;
    }

    public void setGradiliste(String gradiliste) {
        this.gradiliste = gradiliste;
    }

    public boolean getAktivno() {
        return aktivno;
    }

    public void setAktivno(boolean aktivno) {
        this.aktivno = aktivno;
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
        if (!(object instanceof Gradiliste)) {
            return false;
        }
        Gradiliste other = (Gradiliste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Gradiliste[ id=" + id + " ]";
    }
    
}
