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
@Table(name = "zbirniparametri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zbirniparametri.findAll", query = "SELECT z FROM Zbirniparametri z")
    , @NamedQuery(name = "Zbirniparametri.findById", query = "SELECT z FROM Zbirniparametri z WHERE z.id = :id")
    , @NamedQuery(name = "Zbirniparametri.findByVremesmirivanjavagefrakcije", query = "SELECT z FROM Zbirniparametri z WHERE z.vremesmirivanjavagefrakcije = :vremesmirivanjavagefrakcije")
    , @NamedQuery(name = "Zbirniparametri.findByVremepraznjenjavagefrakcije", query = "SELECT z FROM Zbirniparametri z WHERE z.vremepraznjenjavagefrakcije = :vremepraznjenjavagefrakcije")
    , @NamedQuery(name = "Zbirniparametri.findByVremepraznjenjakosetrake", query = "SELECT z FROM Zbirniparametri z WHERE z.vremepraznjenjakosetrake = :vremepraznjenjakosetrake")
    , @NamedQuery(name = "Zbirniparametri.findByKontrolnovremekosetrake", query = "SELECT z FROM Zbirniparametri z WHERE z.kontrolnovremekosetrake = :kontrolnovremekosetrake")
    , @NamedQuery(name = "Zbirniparametri.findByZadrskanadoziranjevode", query = "SELECT z FROM Zbirniparametri z WHERE z.zadrskanadoziranjevode = :zadrskanadoziranjevode")
    , @NamedQuery(name = "Zbirniparametri.findByZadrskanadoziranjecementa", query = "SELECT z FROM Zbirniparametri z WHERE z.zadrskanadoziranjecementa = :zadrskanadoziranjecementa")
    , @NamedQuery(name = "Zbirniparametri.findByVrememesanjamaterijala", query = "SELECT z FROM Zbirniparametri z WHERE z.vrememesanjamaterijala = :vrememesanjamaterijala")
    , @NamedQuery(name = "Zbirniparametri.findByPocetnootvaranjemesalice", query = "SELECT z FROM Zbirniparametri z WHERE z.pocetnootvaranjemesalice = :pocetnootvaranjemesalice")
    , @NamedQuery(name = "Zbirniparametri.findByVremepocetnogpraznjenjamesalice", query = "SELECT z FROM Zbirniparametri z WHERE z.vremepocetnogpraznjenjamesalice = :vremepocetnogpraznjenjamesalice")
    , @NamedQuery(name = "Zbirniparametri.findByVremekonacnogpraznjenjamesalice", query = "SELECT z FROM Zbirniparametri z WHERE z.vremekonacnogpraznjenjamesalice = :vremekonacnogpraznjenjamesalice")
    , @NamedQuery(name = "Zbirniparametri.findByVremeispiranjavageaditiva", query = "SELECT z FROM Zbirniparametri z WHERE z.vremeispiranjavageaditiva = :vremeispiranjavageaditiva")
    , @NamedQuery(name = "Zbirniparametri.findByPauzafluidizacije", query = "SELECT z FROM Zbirniparametri z WHERE z.pauzafluidizacije = :pauzafluidizacije")
    , @NamedQuery(name = "Zbirniparametri.findByRadfluidizacije", query = "SELECT z FROM Zbirniparametri z WHERE z.radfluidizacije = :radfluidizacije")
    , @NamedQuery(name = "Zbirniparametri.findByKapacitetmesalice", query = "SELECT z FROM Zbirniparametri z WHERE z.kapacitetmesalice = :kapacitetmesalice")
    , @NamedQuery(name = "Zbirniparametri.findByZadrskanastartkosetrake", query = "SELECT z FROM Zbirniparametri z WHERE z.zadrskanastartkosetrake = :zadrskanastartkosetrake")
    , @NamedQuery(name = "Zbirniparametri.findByVremesmirivanjavageaditiva", query = "SELECT z FROM Zbirniparametri z WHERE z.vremesmirivanjavageaditiva = :vremesmirivanjavageaditiva")
    , @NamedQuery(name = "Zbirniparametri.findByVremesmirivanjavagecementa", query = "SELECT z FROM Zbirniparametri z WHERE z.vremesmirivanjavagecementa = :vremesmirivanjavagecementa")})
public class Zbirniparametri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "vremesmirivanjavagefrakcije")
    private double vremesmirivanjavagefrakcije;
    @Basic(optional = false)
    @Column(name = "vremepraznjenjavagefrakcije")
    private double vremepraznjenjavagefrakcije;
    @Basic(optional = false)
    @Column(name = "vremepraznjenjakosetrake")
    private double vremepraznjenjakosetrake;
    @Basic(optional = false)
    @Column(name = "kontrolnovremekosetrake")
    private double kontrolnovremekosetrake;
    @Basic(optional = false)
    @Column(name = "zadrskanadoziranjevode")
    private double zadrskanadoziranjevode;
    @Basic(optional = false)
    @Column(name = "zadrskanadoziranjecementa")
    private double zadrskanadoziranjecementa;
    @Basic(optional = false)
    @Column(name = "vrememesanjamaterijala")
    private double vrememesanjamaterijala;
    @Basic(optional = false)
    @Column(name = "pocetnootvaranjemesalice")
    private double pocetnootvaranjemesalice;
    @Basic(optional = false)
    @Column(name = "vremepocetnogpraznjenjamesalice")
    private double vremepocetnogpraznjenjamesalice;
    @Basic(optional = false)
    @Column(name = "vremekonacnogpraznjenjamesalice")
    private double vremekonacnogpraznjenjamesalice;
    @Basic(optional = false)
    @Column(name = "vremeispiranjavageaditiva")
    private double vremeispiranjavageaditiva;
    @Basic(optional = false)
    @Column(name = "pauzafluidizacije")
    private double pauzafluidizacije;
    @Basic(optional = false)
    @Column(name = "radfluidizacije")
    private double radfluidizacije;
    @Basic(optional = false)
    @Column(name = "kapacitetmesalice")
    private double kapacitetmesalice;
    @Basic(optional = false)
    @Column(name = "zadrskanastartkosetrake")
    private double zadrskanastartkosetrake;
    @Basic(optional = false)
    @Column(name = "vremesmirivanjavageaditiva")
    private double vremesmirivanjavageaditiva;
    @Basic(optional = false)
    @Column(name = "vremesmirivanjavagecementa")
    private double vremesmirivanjavagecementa;

    public Zbirniparametri() {
    }

    public Zbirniparametri(Long id) {
        this.id = id;
    }

    public Zbirniparametri(Long id, double vremesmirivanjavagefrakcije, double vremepraznjenjavagefrakcije, double vremepraznjenjakosetrake, double kontrolnovremekosetrake, double zadrskanadoziranjevode, double zadrskanadoziranjecementa, double vrememesanjamaterijala, double pocetnootvaranjemesalice, double vremepocetnogpraznjenjamesalice, double vremekonacnogpraznjenjamesalice, double vremeispiranjavageaditiva, double pauzafluidizacije, double radfluidizacije, double kapacitetmesalice, double zadrskanastartkosetrake, double vremesmirivanjavageaditiva, double vremesmirivanjavagecementa) {
        this.id = id;
        this.vremesmirivanjavagefrakcije = vremesmirivanjavagefrakcije;
        this.vremepraznjenjavagefrakcije = vremepraznjenjavagefrakcije;
        this.vremepraznjenjakosetrake = vremepraznjenjakosetrake;
        this.kontrolnovremekosetrake = kontrolnovremekosetrake;
        this.zadrskanadoziranjevode = zadrskanadoziranjevode;
        this.zadrskanadoziranjecementa = zadrskanadoziranjecementa;
        this.vrememesanjamaterijala = vrememesanjamaterijala;
        this.pocetnootvaranjemesalice = pocetnootvaranjemesalice;
        this.vremepocetnogpraznjenjamesalice = vremepocetnogpraznjenjamesalice;
        this.vremekonacnogpraznjenjamesalice = vremekonacnogpraznjenjamesalice;
        this.vremeispiranjavageaditiva = vremeispiranjavageaditiva;
        this.pauzafluidizacije = pauzafluidizacije;
        this.radfluidizacije = radfluidizacije;
        this.kapacitetmesalice = kapacitetmesalice;
        this.zadrskanastartkosetrake = zadrskanastartkosetrake;
        this.vremesmirivanjavageaditiva = vremesmirivanjavageaditiva;
        this.vremesmirivanjavagecementa = vremesmirivanjavagecementa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getVremesmirivanjavagefrakcije() {
        return vremesmirivanjavagefrakcije;
    }

    public void setVremesmirivanjavagefrakcije(double vremesmirivanjavagefrakcije) {
        this.vremesmirivanjavagefrakcije = vremesmirivanjavagefrakcije;
    }

    public double getVremepraznjenjavagefrakcije() {
        return vremepraznjenjavagefrakcije;
    }

    public void setVremepraznjenjavagefrakcije(double vremepraznjenjavagefrakcije) {
        this.vremepraznjenjavagefrakcije = vremepraznjenjavagefrakcije;
    }

    public double getVremepraznjenjakosetrake() {
        return vremepraznjenjakosetrake;
    }

    public void setVremepraznjenjakosetrake(double vremepraznjenjakosetrake) {
        this.vremepraznjenjakosetrake = vremepraznjenjakosetrake;
    }

    public double getKontrolnovremekosetrake() {
        return kontrolnovremekosetrake;
    }

    public void setKontrolnovremekosetrake(double kontrolnovremekosetrake) {
        this.kontrolnovremekosetrake = kontrolnovremekosetrake;
    }

    public double getZadrskanadoziranjevode() {
        return zadrskanadoziranjevode;
    }

    public void setZadrskanadoziranjevode(double zadrskanadoziranjevode) {
        this.zadrskanadoziranjevode = zadrskanadoziranjevode;
    }

    public double getZadrskanadoziranjecementa() {
        return zadrskanadoziranjecementa;
    }

    public void setZadrskanadoziranjecementa(double zadrskanadoziranjecementa) {
        this.zadrskanadoziranjecementa = zadrskanadoziranjecementa;
    }

    public double getVrememesanjamaterijala() {
        return vrememesanjamaterijala;
    }

    public void setVrememesanjamaterijala(double vrememesanjamaterijala) {
        this.vrememesanjamaterijala = vrememesanjamaterijala;
    }

    public double getPocetnootvaranjemesalice() {
        return pocetnootvaranjemesalice;
    }

    public void setPocetnootvaranjemesalice(double pocetnootvaranjemesalice) {
        this.pocetnootvaranjemesalice = pocetnootvaranjemesalice;
    }

    public double getVremepocetnogpraznjenjamesalice() {
        return vremepocetnogpraznjenjamesalice;
    }

    public void setVremepocetnogpraznjenjamesalice(double vremepocetnogpraznjenjamesalice) {
        this.vremepocetnogpraznjenjamesalice = vremepocetnogpraznjenjamesalice;
    }

    public double getVremekonacnogpraznjenjamesalice() {
        return vremekonacnogpraznjenjamesalice;
    }

    public void setVremekonacnogpraznjenjamesalice(double vremekonacnogpraznjenjamesalice) {
        this.vremekonacnogpraznjenjamesalice = vremekonacnogpraznjenjamesalice;
    }

    public double getVremeispiranjavageaditiva() {
        return vremeispiranjavageaditiva;
    }

    public void setVremeispiranjavageaditiva(double vremeispiranjavageaditiva) {
        this.vremeispiranjavageaditiva = vremeispiranjavageaditiva;
    }

    public double getPauzafluidizacije() {
        return pauzafluidizacije;
    }

    public void setPauzafluidizacije(double pauzafluidizacije) {
        this.pauzafluidizacije = pauzafluidizacije;
    }

    public double getRadfluidizacije() {
        return radfluidizacije;
    }

    public void setRadfluidizacije(double radfluidizacije) {
        this.radfluidizacije = radfluidizacije;
    }

    public double getKapacitetmesalice() {
        return kapacitetmesalice;
    }

    public void setKapacitetmesalice(double kapacitetmesalice) {
        this.kapacitetmesalice = kapacitetmesalice;
    }

    public double getZadrskanastartkosetrake() {
        return zadrskanastartkosetrake;
    }

    public void setZadrskanastartkosetrake(double zadrskanastartkosetrake) {
        this.zadrskanastartkosetrake = zadrskanastartkosetrake;
    }

    public double getVremesmirivanjavageaditiva() {
        return vremesmirivanjavageaditiva;
    }

    public void setVremesmirivanjavageaditiva(double vremesmirivanjavageaditiva) {
        this.vremesmirivanjavageaditiva = vremesmirivanjavageaditiva;
    }

    public double getVremesmirivanjavagecementa() {
        return vremesmirivanjavagecementa;
    }

    public void setVremesmirivanjavagecementa(double vremesmirivanjavagecementa) {
        this.vremesmirivanjavagecementa = vremesmirivanjavagecementa;
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
        if (!(object instanceof Zbirniparametri)) {
            return false;
        }
        Zbirniparametri other = (Zbirniparametri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Zbirniparametri[ id=" + id + " ]";
    }
    
}
