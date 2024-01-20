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
@Table(name = "sifre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sifre.findAll", query = "SELECT s FROM Sifre s")
    , @NamedQuery(name = "Sifre.findById", query = "SELECT s FROM Sifre s WHERE s.id = :id")
    , @NamedQuery(name = "Sifre.findByFrakcija04", query = "SELECT s FROM Sifre s WHERE s.frakcija04 = :frakcija04")
    , @NamedQuery(name = "Sifre.findByFrakcija48", query = "SELECT s FROM Sifre s WHERE s.frakcija48 = :frakcija48")
    , @NamedQuery(name = "Sifre.findByFrakcija816", query = "SELECT s FROM Sifre s WHERE s.frakcija816 = :frakcija816")
    , @NamedQuery(name = "Sifre.findByFrakcija1632", query = "SELECT s FROM Sifre s WHERE s.frakcija1632 = :frakcija1632")
    , @NamedQuery(name = "Sifre.findByCement", query = "SELECT s FROM Sifre s WHERE s.cement = :cement")
    , @NamedQuery(name = "Sifre.findByFiler", query = "SELECT s FROM Sifre s WHERE s.filer = :filer")
    , @NamedQuery(name = "Sifre.findByAditiv1", query = "SELECT s FROM Sifre s WHERE s.aditiv1 = :aditiv1")
    , @NamedQuery(name = "Sifre.findByAditiv2", query = "SELECT s FROM Sifre s WHERE s.aditiv2 = :aditiv2")
    , @NamedQuery(name = "Sifre.findByVoda", query = "SELECT s FROM Sifre s WHERE s.voda = :voda")})
public class Sifre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "frakcija04")
    private String frakcija04;
    @Basic(optional = false)
    @Column(name = "frakcija48")
    private String frakcija48;
    @Basic(optional = false)
    @Column(name = "frakcija816")
    private String frakcija816;
    @Basic(optional = false)
    @Column(name = "frakcija1632")
    private String frakcija1632;
    @Basic(optional = false)
    @Column(name = "cement")
    private String cement;
    @Basic(optional = false)
    @Column(name = "filer")
    private String filer;
    @Basic(optional = false)
    @Column(name = "aditiv1")
    private String aditiv1;
    @Basic(optional = false)
    @Column(name = "aditiv2")
    private String aditiv2;
    @Basic(optional = false)
    @Column(name = "voda")
    private String voda;

    public Sifre() {
    }

    public Sifre(Long id) {
        this.id = id;
    }

    public Sifre(Long id, String frakcija04, String frakcija48, String frakcija816, String frakcija1632, String cement, String filer, String aditiv1, String aditiv2, String voda) {
        this.id = id;
        this.frakcija04 = frakcija04;
        this.frakcija48 = frakcija48;
        this.frakcija816 = frakcija816;
        this.frakcija1632 = frakcija1632;
        this.cement = cement;
        this.filer = filer;
        this.aditiv1 = aditiv1;
        this.aditiv2 = aditiv2;
        this.voda = voda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrakcija04() {
        return frakcija04;
    }

    public void setFrakcija04(String frakcija04) {
        this.frakcija04 = frakcija04;
    }

    public String getFrakcija48() {
        return frakcija48;
    }

    public void setFrakcija48(String frakcija48) {
        this.frakcija48 = frakcija48;
    }

    public String getFrakcija816() {
        return frakcija816;
    }

    public void setFrakcija816(String frakcija816) {
        this.frakcija816 = frakcija816;
    }

    public String getFrakcija1632() {
        return frakcija1632;
    }

    public void setFrakcija1632(String frakcija1632) {
        this.frakcija1632 = frakcija1632;
    }

    public String getCement() {
        return cement;
    }

    public void setCement(String cement) {
        this.cement = cement;
    }

    public String getFiler() {
        return filer;
    }

    public void setFiler(String filer) {
        this.filer = filer;
    }

    public String getAditiv1() {
        return aditiv1;
    }

    public void setAditiv1(String aditiv1) {
        this.aditiv1 = aditiv1;
    }

    public String getAditiv2() {
        return aditiv2;
    }

    public void setAditiv2(String aditiv2) {
        this.aditiv2 = aditiv2;
    }

    public String getVoda() {
        return voda;
    }

    public void setVoda(String voda) {
        this.voda = voda;
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
        if (!(object instanceof Sifre)) {
            return false;
        }
        Sifre other = (Sifre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Sifre[ id=" + id + " ]";
    }
    
}
