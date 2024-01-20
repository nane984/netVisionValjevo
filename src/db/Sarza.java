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
@Table(name = "sarza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sarza.findAll", query = "SELECT s FROM Sarza s")
    , @NamedQuery(name = "Sarza.findById", query = "SELECT s FROM Sarza s WHERE s.id = :id")
    , @NamedQuery(name = "Sarza.findByAgregatzadato04", query = "SELECT s FROM Sarza s WHERE s.agregatzadato04 = :agregatzadato04")
    , @NamedQuery(name = "Sarza.findByAgregatizdato04", query = "SELECT s FROM Sarza s WHERE s.agregatizdato04 = :agregatizdato04")
    , @NamedQuery(name = "Sarza.findByAgregatzadato48", query = "SELECT s FROM Sarza s WHERE s.agregatzadato48 = :agregatzadato48")
    , @NamedQuery(name = "Sarza.findByAgregaizdato48", query = "SELECT s FROM Sarza s WHERE s.agregaizdato48 = :agregaizdato48")
    , @NamedQuery(name = "Sarza.findByAgregatzadato816", query = "SELECT s FROM Sarza s WHERE s.agregatzadato816 = :agregatzadato816")
    , @NamedQuery(name = "Sarza.findByAgregatizdato816", query = "SELECT s FROM Sarza s WHERE s.agregatizdato816 = :agregatizdato816")
    , @NamedQuery(name = "Sarza.findByAgregatzadato1632", query = "SELECT s FROM Sarza s WHERE s.agregatzadato1632 = :agregatzadato1632")
    , @NamedQuery(name = "Sarza.findByAgregatizdato1632", query = "SELECT s FROM Sarza s WHERE s.agregatizdato1632 = :agregatizdato1632")
    , @NamedQuery(name = "Sarza.findByCementzadato", query = "SELECT s FROM Sarza s WHERE s.cementzadato = :cementzadato")
    , @NamedQuery(name = "Sarza.findByCementizdato", query = "SELECT s FROM Sarza s WHERE s.cementizdato = :cementizdato")
    , @NamedQuery(name = "Sarza.findByFilerzadato", query = "SELECT s FROM Sarza s WHERE s.filerzadato = :filerzadato")
    , @NamedQuery(name = "Sarza.findByFilerizdato", query = "SELECT s FROM Sarza s WHERE s.filerizdato = :filerizdato")
    , @NamedQuery(name = "Sarza.findByAditiv1zadato", query = "SELECT s FROM Sarza s WHERE s.aditiv1zadato = :aditiv1zadato")
    , @NamedQuery(name = "Sarza.findByAditiv1izdato", query = "SELECT s FROM Sarza s WHERE s.aditiv1izdato = :aditiv1izdato")
    , @NamedQuery(name = "Sarza.findByAditiv2zadato", query = "SELECT s FROM Sarza s WHERE s.aditiv2zadato = :aditiv2zadato")
    , @NamedQuery(name = "Sarza.findByAditiv2izdato", query = "SELECT s FROM Sarza s WHERE s.aditiv2izdato = :aditiv2izdato")
    , @NamedQuery(name = "Sarza.findByVodazadato", query = "SELECT s FROM Sarza s WHERE s.vodazadato = :vodazadato")
    , @NamedQuery(name = "Sarza.findByVodaizdato", query = "SELECT s FROM Sarza s WHERE s.vodaizdato = :vodaizdato")
    , @NamedQuery(name = "Sarza.findByDate", query = "SELECT s FROM Sarza s WHERE s.date = :date")})
public class Sarza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "agregatzadato0_4")
    private int agregatzadato04;
    @Basic(optional = false)
    @Column(name = "agregatizdato0_4")
    private int agregatizdato04;
    @Basic(optional = false)
    @Column(name = "agregatzadato4_8")
    private int agregatzadato48;
    @Basic(optional = false)
    @Column(name = "agregaizdato4_8")
    private int agregaizdato48;
    @Basic(optional = false)
    @Column(name = "agregatzadato8_16")
    private int agregatzadato816;
    @Basic(optional = false)
    @Column(name = "agregatizdato8_16")
    private int agregatizdato816;
    @Basic(optional = false)
    @Column(name = "agregatzadato16_32")
    private int agregatzadato1632;
    @Basic(optional = false)
    @Column(name = "agregatizdato16_32")
    private int agregatizdato1632;
    @Basic(optional = false)
    @Column(name = "cementzadato")
    private int cementzadato;
    @Basic(optional = false)
    @Column(name = "cementizdato")
    private int cementizdato;
    @Basic(optional = false)
    @Column(name = "filerzadato")
    private int filerzadato;
    @Basic(optional = false)
    @Column(name = "filerizdato")
    private int filerizdato;
    @Basic(optional = false)
    @Column(name = "aditiv1zadato")
    private float aditiv1zadato;
    @Basic(optional = false)
    @Column(name = "aditiv1izdato")
    private float aditiv1izdato;
    @Basic(optional = false)
    @Column(name = "aditiv2zadato")
    private float aditiv2zadato;
    @Basic(optional = false)
    @Column(name = "aditiv2izdato")
    private float aditiv2izdato;
    @Basic(optional = false)
    @Column(name = "vodazadato")
    private float vodazadato;
    @Basic(optional = false)
    @Column(name = "vodaizdato")
    private float vodaizdato;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "otprema", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Otprema otprema;
    @JoinColumn(name = "radninalog", referencedColumnName = "rn")
    @ManyToOne(optional = false)
    private Radninalog radninalog;

    public Sarza() {
    }

    public Sarza(Long id) {
        this.id = id;
    }

    public Sarza(Long id, int agregatzadato04, int agregatizdato04, int agregatzadato48, int agregaizdato48, int agregatzadato816, int agregatizdato816, int agregatzadato1632, int agregatizdato1632, int cementzadato, int cementizdato, int filerzadato, int filerizdato, float aditiv1zadato, float aditiv1izdato, float aditiv2zadato, float aditiv2izdato, float vodazadato, float vodaizdato, Date date) {
        this.id = id;
        this.agregatzadato04 = agregatzadato04;
        this.agregatizdato04 = agregatizdato04;
        this.agregatzadato48 = agregatzadato48;
        this.agregaizdato48 = agregaizdato48;
        this.agregatzadato816 = agregatzadato816;
        this.agregatizdato816 = agregatizdato816;
        this.agregatzadato1632 = agregatzadato1632;
        this.agregatizdato1632 = agregatizdato1632;
        this.cementzadato = cementzadato;
        this.cementizdato = cementizdato;
        this.filerzadato = filerzadato;
        this.filerizdato = filerizdato;
        this.aditiv1zadato = aditiv1zadato;
        this.aditiv1izdato = aditiv1izdato;
        this.aditiv2zadato = aditiv2zadato;
        this.aditiv2izdato = aditiv2izdato;
        this.vodazadato = vodazadato;
        this.vodaizdato = vodaizdato;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAgregatzadato04() {
        return agregatzadato04;
    }

    public void setAgregatzadato04(int agregatzadato04) {
        this.agregatzadato04 = agregatzadato04;
    }

    public int getAgregatizdato04() {
        return agregatizdato04;
    }

    public void setAgregatizdato04(int agregatizdato04) {
        this.agregatizdato04 = agregatizdato04;
    }

    public int getAgregatzadato48() {
        return agregatzadato48;
    }

    public void setAgregatzadato48(int agregatzadato48) {
        this.agregatzadato48 = agregatzadato48;
    }

    public int getAgregaizdato48() {
        return agregaizdato48;
    }

    public void setAgregaizdato48(int agregaizdato48) {
        this.agregaizdato48 = agregaizdato48;
    }

    public int getAgregatzadato816() {
        return agregatzadato816;
    }

    public void setAgregatzadato816(int agregatzadato816) {
        this.agregatzadato816 = agregatzadato816;
    }

    public int getAgregatizdato816() {
        return agregatizdato816;
    }

    public void setAgregatizdato816(int agregatizdato816) {
        this.agregatizdato816 = agregatizdato816;
    }

    public int getAgregatzadato1632() {
        return agregatzadato1632;
    }

    public void setAgregatzadato1632(int agregatzadato1632) {
        this.agregatzadato1632 = agregatzadato1632;
    }

    public int getAgregatizdato1632() {
        return agregatizdato1632;
    }

    public void setAgregatizdato1632(int agregatizdato1632) {
        this.agregatizdato1632 = agregatizdato1632;
    }

    public int getCementzadato() {
        return cementzadato;
    }

    public void setCementzadato(int cementzadato) {
        this.cementzadato = cementzadato;
    }

    public int getCementizdato() {
        return cementizdato;
    }

    public void setCementizdato(int cementizdato) {
        this.cementizdato = cementizdato;
    }

    public int getFilerzadato() {
        return filerzadato;
    }

    public void setFilerzadato(int filerzadato) {
        this.filerzadato = filerzadato;
    }

    public int getFilerizdato() {
        return filerizdato;
    }

    public void setFilerizdato(int filerizdato) {
        this.filerizdato = filerizdato;
    }

    public float getAditiv1zadato() {
        return aditiv1zadato;
    }

    public void setAditiv1zadato(float aditiv1zadato) {
        this.aditiv1zadato = aditiv1zadato;
    }

    public float getAditiv1izdato() {
        return aditiv1izdato;
    }

    public void setAditiv1izdato(float aditiv1izdato) {
        this.aditiv1izdato = aditiv1izdato;
    }

    public float getAditiv2zadato() {
        return aditiv2zadato;
    }

    public void setAditiv2zadato(float aditiv2zadato) {
        this.aditiv2zadato = aditiv2zadato;
    }

    public float getAditiv2izdato() {
        return aditiv2izdato;
    }

    public void setAditiv2izdato(float aditiv2izdato) {
        this.aditiv2izdato = aditiv2izdato;
    }

    public float getVodazadato() {
        return vodazadato;
    }

    public void setVodazadato(float vodazadato) {
        this.vodazadato = vodazadato;
    }

    public float getVodaizdato() {
        return vodaizdato;
    }

    public void setVodaizdato(float vodaizdato) {
        this.vodaizdato = vodaizdato;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Otprema getOtprema() {
        return otprema;
    }

    public void setOtprema(Otprema otprema) {
        this.otprema = otprema;
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
        if (!(object instanceof Sarza)) {
            return false;
        }
        Sarza other = (Sarza) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Sarza[ id=" + id + " ]";
    }
    
}
