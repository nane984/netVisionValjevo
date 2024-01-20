/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JSpinner;
import utils.Convert;

/**
 *
 * @author branko.scekic
 */
public class ZbirniParametriService implements Runnable {

    private final EntityManagerFactory emf;
    private List<db.Zbirniparametri> result;
    private final ExecutorService es;

    private boolean getParametri = false;
    private boolean setParametri = false;

    private JSpinner AOParametriVremeSmirivanjaVageFrakcije;
    private JSpinner AOParametriVremePraznjenjaVageFrakcije;
    private JSpinner AOParametriVremePraznjenjaKoseTrake;
    private JSpinner AOParametriKontrolnoVremeKoseTrake;
    private JSpinner AOParametriZadrskaNaDoziranjeVode;
    private JSpinner AOParametriZadrskaNaDoziranjeCementa;
    private JSpinner AOParametriVremeMesanjaMaterijala;
    private JSpinner AOParametriPocetnoOtvaranjeMesalice;
    private JSpinner AOParametriVremePocetnogPraznjenjaMesalice;
    private JSpinner AOParametriVremeKonacnogPraznjenjaMesalice;
    private JSpinner AOParametriVremeIspiranjaVageAditiva;
    private JSpinner AOParametriPauzaFluidizacije;
    private JSpinner AOParametriRadFluidizacije;
    private JSpinner AOParametriKapacitetMesalice;
    private JSpinner AOParametriZadrskaNaStartKoseTrake;
    private JSpinner AOParametriVremeSmirivanjaVageAditiva;
    private JSpinner AOParametriVremeSmirivanjaVageCementa;

     public ZbirniParametriService(EntityManagerFactory emf, ExecutorService es){
         this.es = es;
         this.emf = emf;
     }
    
    public void setParametersZbirniParametriService(JSpinner param1,
            JSpinner param2, JSpinner param3, JSpinner param4, JSpinner param5,
            JSpinner param6, JSpinner param7, JSpinner param8, JSpinner param9,
            JSpinner param10, JSpinner param11, JSpinner param12, JSpinner param13,
            JSpinner param14, JSpinner param15, JSpinner param16, JSpinner param17) {

        this.AOParametriVremeSmirivanjaVageFrakcije = param1;
        this.AOParametriVremePraznjenjaVageFrakcije = param2;
        this.AOParametriVremePraznjenjaKoseTrake = param3;
        this.AOParametriKontrolnoVremeKoseTrake = param4;
        this.AOParametriZadrskaNaDoziranjeVode = param5;
        this.AOParametriZadrskaNaDoziranjeCementa = param6;
        this.AOParametriVremeMesanjaMaterijala = param7;
        this.AOParametriPocetnoOtvaranjeMesalice = param8;
        this.AOParametriVremePocetnogPraznjenjaMesalice = param9;
        this.AOParametriVremeKonacnogPraznjenjaMesalice = param10;
        this.AOParametriVremeIspiranjaVageAditiva = param11;
        this.AOParametriPauzaFluidizacije = param12;
        this.AOParametriRadFluidizacije = param13;
        this.AOParametriKapacitetMesalice = param14;
        this.AOParametriZadrskaNaStartKoseTrake = param15;
        this.AOParametriVremeSmirivanjaVageAditiva = param16;
        this.AOParametriVremeSmirivanjaVageCementa = param17;

    }
    
    public void getZbirniParametri() {
        getParametri = true;
        es.submit(this);
    }

    private synchronized void getZbirniParametriRun() {
        EntityManager em = emf.createEntityManager();
        //Query q = em.createQuery("SELECT z FROM Zbirniparametri z");
        Query q = em.createNamedQuery("Zbirniparametri.findAll");
        result = q.getResultList();
        em.close();
        getParametri = false;
        updateResult();

    }

    private void updateResult() {
        AOParametriVremeSmirivanjaVageFrakcije.setValue(result.get(0).getVremesmirivanjavagefrakcije());
        AOParametriVremePraznjenjaVageFrakcije.setValue(result.get(0).getVremepraznjenjavagefrakcije());
        AOParametriVremePraznjenjaKoseTrake.setValue(result.get(0).getVremepraznjenjakosetrake());
        AOParametriKontrolnoVremeKoseTrake.setValue(result.get(0).getKontrolnovremekosetrake());
        AOParametriZadrskaNaDoziranjeVode.setValue(result.get(0).getZadrskanadoziranjevode());
        AOParametriZadrskaNaDoziranjeCementa.setValue(result.get(0).getZadrskanadoziranjecementa());
        AOParametriVremeMesanjaMaterijala.setValue(result.get(0).getVrememesanjamaterijala());
        AOParametriPocetnoOtvaranjeMesalice.setValue(result.get(0).getPocetnootvaranjemesalice());
        AOParametriVremePocetnogPraznjenjaMesalice.setValue(result.get(0).getVremepocetnogpraznjenjamesalice());
        AOParametriVremeKonacnogPraznjenjaMesalice.setValue(result.get(0).getVremekonacnogpraznjenjamesalice());
        AOParametriVremeIspiranjaVageAditiva.setValue(result.get(0).getVremeispiranjavageaditiva());
        AOParametriPauzaFluidizacije.setValue(result.get(0).getPauzafluidizacije());
        AOParametriRadFluidizacije.setValue(result.get(0).getRadfluidizacije());
        AOParametriKapacitetMesalice.setValue(result.get(0).getKapacitetmesalice());
        AOParametriZadrskaNaStartKoseTrake.setValue(result.get(0).getZadrskanastartkosetrake());
        AOParametriVremeSmirivanjaVageAditiva.setValue(result.get(0).getVremesmirivanjavageaditiva());
        AOParametriVremeSmirivanjaVageCementa.setValue(result.get(0).getVremesmirivanjavagecementa());
    }

    public void setZbirniParametri(){
        setParametri = true;
        es.submit(this);
        
    }
    
    public synchronized void setZbirniParametriRun(double VremeSmirivanjaVageFrakcije, double VremePraznjenjaVageFrakcije, double AOParametriVremePraznjenjaKoseTrake,
            double AOParametriKontrolnoVremeKoseTrake, double AOParametriZadrskaNaDoziranjeVode, double AOParametriZadrskaNaDoziranjeCementa,
            double AOParametriVremeMesanjaMaterijala, double AOParametriPocetnoOtvaranjeMesalice, double AOParametriVremePocetnogPraznjenjaMesalice,
            double AOParametriVremeKonacnogPraznjenjaMesalice, double AOParametriVremeIspiranjaVageAditiva, double AOParametriPauzaFluidizacije,
            double AOParametriRadFluidizacije, double AOParametriKapacitetMesalice, double AOParametriZadrskaNaStartKoseTrake,
            double AOParametriVremeSmirivanjaVageAditiva, double AOParametriVremeSmirivanjaVageCementa) {

        Long a = 1l;
        EntityManager em = emf.createEntityManager();
        db.Zbirniparametri zp = em.find(db.Zbirniparametri.class, a);
        em.getTransaction().begin();

        zp.setVremesmirivanjavagefrakcije(VremeSmirivanjaVageFrakcije);
        zp.setVremepraznjenjavagefrakcije(VremePraznjenjaVageFrakcije);
        zp.setVremepraznjenjakosetrake(AOParametriVremePraznjenjaKoseTrake);
        zp.setKontrolnovremekosetrake(AOParametriKontrolnoVremeKoseTrake);
        zp.setZadrskanadoziranjevode(AOParametriZadrskaNaDoziranjeVode);
        zp.setZadrskanadoziranjecementa(AOParametriZadrskaNaDoziranjeCementa);
        zp.setVrememesanjamaterijala(AOParametriVremeMesanjaMaterijala);
        zp.setPocetnootvaranjemesalice(AOParametriPocetnoOtvaranjeMesalice);
        zp.setVremepocetnogpraznjenjamesalice(AOParametriVremePocetnogPraznjenjaMesalice);
        zp.setVremekonacnogpraznjenjamesalice(AOParametriVremeKonacnogPraznjenjaMesalice);
        zp.setVremeispiranjavageaditiva(AOParametriVremeIspiranjaVageAditiva);
        zp.setPauzafluidizacije(AOParametriPauzaFluidizacije);
        zp.setRadfluidizacije(AOParametriRadFluidizacije);
        zp.setKapacitetmesalice(AOParametriKapacitetMesalice);
        zp.setZadrskanastartkosetrake(AOParametriZadrskaNaStartKoseTrake);
        zp.setVremesmirivanjavageaditiva(AOParametriVremeSmirivanjaVageAditiva);
        zp.setVremesmirivanjavagecementa(AOParametriVremeSmirivanjaVageCementa);

        em.persist(zp);
        em.getTransaction().commit();
        em.close();
        setParametri = false;

    }

    @Override
    public void run() {
        if (getParametri) {
            getZbirniParametriRun();
        }
        if (setParametri) {
            setZbirniParametriRun(Convert.stringToDouble(AOParametriVremeSmirivanjaVageFrakcije.getValue().toString()),
                    Convert.stringToDouble(AOParametriVremePraznjenjaVageFrakcije.getValue().toString()),
                    Convert.stringToDouble(AOParametriVremePraznjenjaKoseTrake.getValue().toString()),
                    Convert.stringToDouble(AOParametriKontrolnoVremeKoseTrake.getValue().toString()),
                    Convert.stringToDouble(AOParametriZadrskaNaDoziranjeVode.getValue().toString()),
                    Convert.stringToDouble(AOParametriZadrskaNaDoziranjeCementa.getValue().toString()),
                    Convert.stringToDouble(AOParametriVremeMesanjaMaterijala.getValue().toString()),
                    Convert.stringToDouble(AOParametriPocetnoOtvaranjeMesalice.getValue().toString()),
                    Convert.stringToDouble(AOParametriVremePocetnogPraznjenjaMesalice.getValue().toString()),
                    Convert.stringToDouble(AOParametriVremeKonacnogPraznjenjaMesalice.getValue().toString()),
                    Convert.stringToDouble(AOParametriVremeIspiranjaVageAditiva.getValue().toString()),
                    Convert.stringToDouble(AOParametriPauzaFluidizacije.getValue().toString()),
                    Convert.stringToDouble(AOParametriRadFluidizacije.getValue().toString()),
                    Convert.stringToDouble(AOParametriKapacitetMesalice.getValue().toString()),
                    Convert.stringToDouble(AOParametriZadrskaNaStartKoseTrake.getValue().toString()),
                    Convert.stringToDouble(AOParametriVremeSmirivanjaVageAditiva.getValue().toString()),
                    Convert.stringToDouble(AOParametriVremeSmirivanjaVageCementa.getValue().toString()));

            getZbirniParametriRun();
        }
    }

}
