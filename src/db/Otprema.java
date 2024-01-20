/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author branko.scekic
 */
@Entity
@Table(name = "otprema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Otprema.findAll", query = "SELECT o FROM Otprema o")
    , @NamedQuery(name = "Otprema.findById", query = "SELECT o FROM Otprema o WHERE o.id = :id")
    , @NamedQuery(name = "Otprema.findByDatum", query = "SELECT o FROM Otprema o WHERE o.datum = :datum")
    , @NamedQuery(name = "Otprema.findByZadatom3", query = "SELECT o FROM Otprema o WHERE o.zadatom3 = :zadatom3")
    , @NamedQuery(name = "Otprema.findByIzdatom3", query = "SELECT o FROM Otprema o WHERE o.izdatom3 = :izdatom3")
    , @NamedQuery(name = "Otprema.findByStatus", query = "SELECT o FROM Otprema o WHERE o.status = :status")
    , @NamedQuery(name = "Otprema.findByVozac", query = "SELECT o FROM Otprema o WHERE o.vozac = :vozac")
    , @NamedQuery(name = "Otprema.findByVozilo", query = "SELECT o FROM Otprema o WHERE o.vozilo = :vozilo")
    , @NamedQuery(name = "Otprema.findByBrotpreme", query = "SELECT o FROM Otprema o WHERE o.brotpreme = :brotpreme")})
public class Otprema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "zadatom3")
    private float zadatom3;
    @Basic(optional = false)
    @Column(name = "izdatom3")
    private float izdatom3;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "vozac")
    private String vozac;
    @Basic(optional = false)
    @Column(name = "vozilo")
    private String vozilo;
    @Basic(optional = false)
    @Column(name = "brotpreme")
    private long brotpreme;
    @JoinColumn(name = "radninalog", referencedColumnName = "rn")
    @ManyToOne(optional = false)
    private Radninalog radninalog;

    public Otprema() {
    }

    public Otprema(Long id) {
        this.id = id;
    }

    public Otprema(Long id, Date datum, float zadatom3, float izdatom3, int status, String vozac, String vozilo, long brotpreme) {
        this.id = id;
        this.datum = datum;
        this.zadatom3 = zadatom3;
        this.izdatom3 = izdatom3;
        this.status = status;
        this.vozac = vozac;
        this.vozilo = vozilo;
        this.brotpreme = brotpreme;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public float getZadatom3() {
        return zadatom3;
    }

    public void setZadatom3(float zadatom3) {
        this.zadatom3 = zadatom3;
    }

    public float getIzdatom3() {
        return izdatom3;
    }

    public void setIzdatom3(float izdatom3) {
        this.izdatom3 = izdatom3;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getVozac() {
        return vozac;
    }

    public void setVozac(String vozac) {
        this.vozac = vozac;
    }

    public String getVozilo() {
        return vozilo;
    }

    public void setVozilo(String vozilo) {
        this.vozilo = vozilo;
    }

    public long getBrotpreme() {
        return brotpreme;
    }

    public void setBrotpreme(long brotpreme) {
        this.brotpreme = brotpreme;
    }

    public Radninalog getRadninalog() {
        return radninalog;
    }

    public void setRadninalog(Radninalog radninalog) {
        this.radninalog = radninalog;
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
        if (!(object instanceof Otprema)) {
            return false;
        }
        Otprema other = (Otprema) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Otprema[ id=" + id + " ]";
    }
    
}
