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
@Table(name = "vozac")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vozac.findAll", query = "SELECT v FROM Vozac v")
    , @NamedQuery(name = "Vozac.findById", query = "SELECT v FROM Vozac v WHERE v.id = :id")
    , @NamedQuery(name = "Vozac.findByVozac", query = "SELECT v FROM Vozac v WHERE v.vozac = :vozac")
    , @NamedQuery(name = "Vozac.findByAktivan", query = "SELECT v FROM Vozac v WHERE v.aktivan = :aktivan")})
public class Vozac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "vozac")
    private String vozac;
    @Basic(optional = false)
    @Column(name = "aktivan")
    private boolean aktivan;

    public Vozac() {
    }

    public Vozac(Long id) {
        this.id = id;
    }

    public Vozac(Long id, String vozac, boolean aktivan) {
        this.id = id;
        this.vozac = vozac;
        this.aktivan = aktivan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVozac() {
        return vozac;
    }

    public void setVozac(String vozac) {
        this.vozac = vozac;
    }

    public boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
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
        if (!(object instanceof Vozac)) {
            return false;
        }
        Vozac other = (Vozac) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Vozac[ id=" + id + " ]";
    }
    
}
