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
@Table(name = "vozilo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vozilo.findAll", query = "SELECT v FROM Vozilo v")
    , @NamedQuery(name = "Vozilo.findById", query = "SELECT v FROM Vozilo v WHERE v.id = :id")
    , @NamedQuery(name = "Vozilo.findByTablica", query = "SELECT v FROM Vozilo v WHERE v.tablica = :tablica")
    , @NamedQuery(name = "Vozilo.findByVozilo", query = "SELECT v FROM Vozilo v WHERE v.vozilo = :vozilo")
    , @NamedQuery(name = "Vozilo.findByAkivan", query = "SELECT v FROM Vozilo v WHERE v.akivan = :akivan")})
public class Vozilo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "tablica")
    private String tablica;
    @Column(name = "vozilo")
    private String vozilo;
    @Basic(optional = false)
    @Column(name = "akivan")
    private boolean akivan;

    public Vozilo() {
    }

    public Vozilo(Long id) {
        this.id = id;
    }

    public Vozilo(Long id, String tablica, boolean akivan) {
        this.id = id;
        this.tablica = tablica;
        this.akivan = akivan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTablica() {
        return tablica;
    }

    public void setTablica(String tablica) {
        this.tablica = tablica;
    }

    public String getVozilo() {
        return vozilo;
    }

    public void setVozilo(String vozilo) {
        this.vozilo = vozilo;
    }

    public boolean getAkivan() {
        return akivan;
    }

    public void setAkivan(boolean akivan) {
        this.akivan = akivan;
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
        if (!(object instanceof Vozilo)) {
            return false;
        }
        Vozilo other = (Vozilo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Vozilo[ id=" + id + " ]";
    }
    
}
