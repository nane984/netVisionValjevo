/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author branko.scekic
 */
@Entity
@Table(name = "radninalog")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Radninalog.findAll", query = "SELECT r FROM Radninalog r")
    , @NamedQuery(name = "Radninalog.findByUgovorenom3", query = "SELECT r FROM Radninalog r WHERE r.ugovorenom3 = :ugovorenom3")
    , @NamedQuery(name = "Radninalog.findByIsporucenom3", query = "SELECT r FROM Radninalog r WHERE r.isporucenom3 = :isporucenom3")
    , @NamedQuery(name = "Radninalog.findByStatus", query = "SELECT r FROM Radninalog r WHERE r.status = :status")
    , @NamedQuery(name = "Radninalog.findByKupac", query = "SELECT r FROM Radninalog r WHERE r.kupac = :kupac")
    , @NamedQuery(name = "Radninalog.findByGradiliste", query = "SELECT r FROM Radninalog r WHERE r.gradiliste = :gradiliste")
    , @NamedQuery(name = "Radninalog.findByMarkabetona", query = "SELECT r FROM Radninalog r WHERE r.markabetona = :markabetona")
    , @NamedQuery(name = "Radninalog.findByRn", query = "SELECT r FROM Radninalog r WHERE r.rn = :rn")
    , @NamedQuery(name = "Radninalog.findByDatum", query = "SELECT r FROM Radninalog r WHERE r.datum = :datum")
    , @NamedQuery(name = "Radninalog.findByBrojotpreme", query = "SELECT r FROM Radninalog r WHERE r.brojotpreme = :brojotpreme")})
public class Radninalog implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "radninalog")
    private Collection<Otprema> otpremaCollection;

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ugovorenom3")
    private float ugovorenom3;
    @Basic(optional = false)
    @Column(name = "isporucenom3")
    private float isporucenom3;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "kupac")
    private String kupac;
    @Basic(optional = false)
    @Column(name = "gradiliste")
    private String gradiliste;
    @Basic(optional = false)
    @Column(name = "markabetona")
    private String markabetona;
    @Id
    @Basic(optional = false)
    @Column(name = "rn")
    private Long rn;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "brojotpreme")
    private int brojotpreme;

    public Radninalog() {
    }

    public Radninalog(Long rn) {
        this.rn = rn;
    }

    public Radninalog(Long rn, float ugovorenom3, float isporucenom3, int status, String kupac, String gradiliste, String markabetona, Date datum, int brojotpreme) {
        this.rn = rn;
        this.ugovorenom3 = ugovorenom3;
        this.isporucenom3 = isporucenom3;
        this.status = status;
        this.kupac = kupac;
        this.gradiliste = gradiliste;
        this.markabetona = markabetona;
        this.datum = datum;
        this.brojotpreme = brojotpreme;
    }

    public float getUgovorenom3() {
        return ugovorenom3;
    }

    public void setUgovorenom3(float ugovorenom3) {
        this.ugovorenom3 = ugovorenom3;
    }

    public float getIsporucenom3() {
        return isporucenom3;
    }

    public void setIsporucenom3(float isporucenom3) {
        this.isporucenom3 = isporucenom3;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getKupac() {
        return kupac;
    }

    public void setKupac(String kupac) {
        this.kupac = kupac;
    }

    public String getGradiliste() {
        return gradiliste;
    }

    public void setGradiliste(String gradiliste) {
        this.gradiliste = gradiliste;
    }

    public String getMarkabetona() {
        return markabetona;
    }

    public void setMarkabetona(String markabetona) {
        this.markabetona = markabetona;
    }

    public Long getRn() {
        return rn;
    }

    public void setRn(Long rn) {
        this.rn = rn;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getBrojotpreme() {
        return brojotpreme;
    }

    public void setBrojotpreme(int brojotpreme) {
        this.brojotpreme = brojotpreme;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rn != null ? rn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Radninalog)) {
            return false;
        }
        Radninalog other = (Radninalog) object;
        if ((this.rn == null && other.rn != null) || (this.rn != null && !this.rn.equals(other.rn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Radninalog[ rn=" + rn + " ]";
    }

    @XmlTransient
    public Collection<Otprema> getOtpremaCollection() {
        return otpremaCollection;
    }

    public void setOtpremaCollection(Collection<Otprema> otpremaCollection) {
        this.otpremaCollection = otpremaCollection;
    }
    
}
