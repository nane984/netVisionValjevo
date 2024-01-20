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
@Table(name = "markabetona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Markabetona.findAll", query = "SELECT m FROM Markabetona m")
    , @NamedQuery(name = "Markabetona.findById", query = "SELECT m FROM Markabetona m WHERE m.id = :id")
    , @NamedQuery(name = "Markabetona.findByMarkabeton", query = "SELECT m FROM Markabetona m WHERE m.markabeton = :markabeton")
    , @NamedQuery(name = "Markabetona.findByCementfilerselect", query = "SELECT m FROM Markabetona m WHERE m.cementfilerselect = :cementfilerselect")
    , @NamedQuery(name = "Markabetona.findByFrakcija04", query = "SELECT m FROM Markabetona m WHERE m.frakcija04 = :frakcija04")
    , @NamedQuery(name = "Markabetona.findByFrakcija48", query = "SELECT m FROM Markabetona m WHERE m.frakcija48 = :frakcija48")
    , @NamedQuery(name = "Markabetona.findByFrakcija816", query = "SELECT m FROM Markabetona m WHERE m.frakcija816 = :frakcija816")
    , @NamedQuery(name = "Markabetona.findByFrakcija1632", query = "SELECT m FROM Markabetona m WHERE m.frakcija1632 = :frakcija1632")
    , @NamedQuery(name = "Markabetona.findByCement", query = "SELECT m FROM Markabetona m WHERE m.cement = :cement")
    , @NamedQuery(name = "Markabetona.findByFiler", query = "SELECT m FROM Markabetona m WHERE m.filer = :filer")
    , @NamedQuery(name = "Markabetona.findByAditiv1", query = "SELECT m FROM Markabetona m WHERE m.aditiv1 = :aditiv1")
    , @NamedQuery(name = "Markabetona.findByAditiv2", query = "SELECT m FROM Markabetona m WHERE m.aditiv2 = :aditiv2")
    , @NamedQuery(name = "Markabetona.findByVoda", query = "SELECT m FROM Markabetona m WHERE m.voda = :voda")
    , @NamedQuery(name = "Markabetona.findByVrememesanja", query = "SELECT m FROM Markabetona m WHERE m.vrememesanja = :vrememesanja")
    , @NamedQuery(name = "Markabetona.findByVremepraznjenja", query = "SELECT m FROM Markabetona m WHERE m.vremepraznjenja = :vremepraznjenja")})
public class Markabetona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "markabeton")
    private String markabeton;
    @Basic(optional = false)
    @Column(name = "cementfilerselect")
    private boolean cementfilerselect;
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vrememesanja")
    private Double vrememesanja;
    @Column(name = "vremepraznjenja")
    private Double vremepraznjenja;

    public Markabetona() {
    }

    public Markabetona(Long id) {
        this.id = id;
    }

    public Markabetona(Long id, String markabeton, boolean cementfilerselect, double frakcija04, double frakcija48, double frakcija816, double frakcija1632, double cement, double filer, double aditiv1, double aditiv2, double voda) {
        this.id = id;
        this.markabeton = markabeton;
        this.cementfilerselect = cementfilerselect;
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

    public String getMarkabeton() {
        return markabeton;
    }

    public void setMarkabeton(String markabeton) {
        this.markabeton = markabeton;
    }

    public boolean getCementfilerselect() {
        return cementfilerselect;
    }

    public void setCementfilerselect(boolean cementfilerselect) {
        this.cementfilerselect = cementfilerselect;
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

    public Double getVrememesanja() {
        return vrememesanja;
    }

    public void setVrememesanja(Double vrememesanja) {
        this.vrememesanja = vrememesanja;
    }

    public Double getVremepraznjenja() {
        return vremepraznjenja;
    }

    public void setVremepraznjenja(Double vremepraznjenja) {
        this.vremepraznjenja = vremepraznjenja;
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
        if (!(object instanceof Markabetona)) {
            return false;
        }
        Markabetona other = (Markabetona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Markabetona[ id=" + id + " ]";
    }
    
}
