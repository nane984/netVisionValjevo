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
@Table(name = "preleti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preleti.findAll", query = "SELECT p FROM Preleti p")
    , @NamedQuery(name = "Preleti.findById", query = "SELECT p FROM Preleti p WHERE p.id = :id")
    , @NamedQuery(name = "Preleti.findByFrakcija04", query = "SELECT p FROM Preleti p WHERE p.frakcija04 = :frakcija04")
    , @NamedQuery(name = "Preleti.findByFrakcija48", query = "SELECT p FROM Preleti p WHERE p.frakcija48 = :frakcija48")
    , @NamedQuery(name = "Preleti.findByFrakcija816", query = "SELECT p FROM Preleti p WHERE p.frakcija816 = :frakcija816")
    , @NamedQuery(name = "Preleti.findByFrakcija1632", query = "SELECT p FROM Preleti p WHERE p.frakcija1632 = :frakcija1632")
    , @NamedQuery(name = "Preleti.findByCement", query = "SELECT p FROM Preleti p WHERE p.cement = :cement")
    , @NamedQuery(name = "Preleti.findByFiler", query = "SELECT p FROM Preleti p WHERE p.filer = :filer")
    , @NamedQuery(name = "Preleti.findByAditiv1", query = "SELECT p FROM Preleti p WHERE p.aditiv1 = :aditiv1")
    , @NamedQuery(name = "Preleti.findByAditiv2", query = "SELECT p FROM Preleti p WHERE p.aditiv2 = :aditiv2")
    , @NamedQuery(name = "Preleti.findByVoda", query = "SELECT p FROM Preleti p WHERE p.voda = :voda")})
public class Preleti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "frakcija04")
    private double frakcija04;
    @Basic(optional = false)
    @Column(name = "frakcija48")
    private double frakcija48;
    @Basic(optional = false)
    @Column(name = "frakcija816")
    private double frakcija816;
    @Basic(optional = false)
    @Column(name = "frakcija1632")
    private double frakcija1632;
    @Basic(optional = false)
    @Column(name = "cement")
    private double cement;
    @Basic(optional = false)
    @Column(name = "filer")
    private double filer;
    @Basic(optional = false)
    @Column(name = "aditiv1")
    private double aditiv1;
    @Basic(optional = false)
    @Column(name = "aditiv2")
    private double aditiv2;
    @Basic(optional = false)
    @Column(name = "voda")
    private double voda;

    public Preleti() {
    }

    public Preleti(Long id) {
        this.id = id;
    }

    public Preleti(Long id, double frakcija04, double frakcija48, double frakcija816, double frakcija1632, double cement, double filer, double aditiv1, double aditiv2, double voda) {
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

    public double getFrakcija04() {
        return frakcija04;
    }

    public void setFrakcija04(double frakcija04) {
        this.frakcija04 = frakcija04;
    }

    public double getFrakcija48() {
        return frakcija48;
    }

    public void setFrakcija48(double frakcija48) {
        this.frakcija48 = frakcija48;
    }

    public double getFrakcija816() {
        return frakcija816;
    }

    public void setFrakcija816(double frakcija816) {
        this.frakcija816 = frakcija816;
    }

    public double getFrakcija1632() {
        return frakcija1632;
    }

    public void setFrakcija1632(double frakcija1632) {
        this.frakcija1632 = frakcija1632;
    }

    public double getCement() {
        return cement;
    }

    public void setCement(double cement) {
        this.cement = cement;
    }

    public double getFiler() {
        return filer;
    }

    public void setFiler(double filer) {
        this.filer = filer;
    }

    public double getAditiv1() {
        return aditiv1;
    }

    public void setAditiv1(double aditiv1) {
        this.aditiv1 = aditiv1;
    }

    public double getAditiv2() {
        return aditiv2;
    }

    public void setAditiv2(double aditiv2) {
        this.aditiv2 = aditiv2;
    }

    public double getVoda() {
        return voda;
    }

    public void setVoda(double voda) {
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
        if (!(object instanceof Preleti)) {
            return false;
        }
        Preleti other = (Preleti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Preleti[ id=" + id + " ]";
    }
    
}
