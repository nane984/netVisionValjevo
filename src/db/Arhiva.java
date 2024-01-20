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
@Table(name = "arhiva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arhiva.findAll", query = "SELECT a FROM Arhiva a")
    , @NamedQuery(name = "Arhiva.findById", query = "SELECT a FROM Arhiva a WHERE a.id = :id")
    , @NamedQuery(name = "Arhiva.findByOpis", query = "SELECT a FROM Arhiva a WHERE a.opis = :opis")
    , @NamedQuery(name = "Arhiva.findByVrednost", query = "SELECT a FROM Arhiva a WHERE a.vrednost = :vrednost")
    , @NamedQuery(name = "Arhiva.findByDatum", query = "SELECT a FROM Arhiva a WHERE a.datum = :datum")})
public class Arhiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "opis")
    private String opis;
    @Column(name = "vrednost")
    private String vrednost;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datum;

    public Arhiva() {
    }

    public Arhiva(Long id) {
        this.id = id;
    }

    public Arhiva(Long id, Date datum) {
        this.id = id;
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getVrednost() {
        return vrednost;
    }

    public void setVrednost(String vrednost) {
        this.vrednost = vrednost;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
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
        if (!(object instanceof Arhiva)) {
            return false;
        }
        Arhiva other = (Arhiva) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Arhiva[ id=" + id + " ]";
    }
    
}
