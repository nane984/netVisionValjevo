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
public class PreletiService implements Runnable {

    private final EntityManagerFactory emf;
    private List<db.Preleti> result;
    private final ExecutorService es;

    private boolean getParametri = false;
    private boolean setParametri = false;

    private JSpinner AOPreletnaMasaFrakcija0_4;
    private JSpinner AOPreletnaMasaFrakcija4_8;
    private JSpinner AOPreletnaMasaFrakcija8_16;
    private JSpinner AOPreletnaMasaFrakcija16_32;
    private JSpinner AOPreletnaMasaCement;
    private JSpinner AOPreletnaMasaFiler;
    private JSpinner AOPreletnaMasaAditiv1;
    private JSpinner AOPreletnaMasaAditiv2;
    private JSpinner AOPreletnaMasaVoda;

    public PreletiService(EntityManagerFactory emf, ExecutorService es) {
        this.es = es;
        this.emf = emf;
    }
    
    public void setParameters(JSpinner param1,
            JSpinner param2, JSpinner param3, JSpinner param4, JSpinner param5,
            JSpinner param6, JSpinner param7, JSpinner param8, JSpinner param9){
        
        this.AOPreletnaMasaFrakcija0_4 = param1;
        this.AOPreletnaMasaFrakcija4_8 = param2;
        this.AOPreletnaMasaFrakcija8_16 = param3;
        this.AOPreletnaMasaFrakcija16_32 = param4;
        this.AOPreletnaMasaCement = param5;
        this.AOPreletnaMasaFiler = param6;
        this.AOPreletnaMasaAditiv1 = param7;
        this.AOPreletnaMasaAditiv2 = param8;
        this.AOPreletnaMasaVoda = param9;
        
    }

    public void getPreleti() {
        getParametri = true;
        es.submit(this);
    }

    private synchronized void getPreletiRun() {
        getParametri = false;
        try {
            EntityManager em = emf.createEntityManager();
            //Query q = em.createQuery("SELECT z FROM Zbirniparametri z");
            Query q = em.createNamedQuery("Preleti.findAll");
            result = q.getResultList();
            em.close();

            updateResult();
        } catch (Exception ex) {

        }

    }

    private void updateResult() {
        AOPreletnaMasaFrakcija0_4.setValue(result.get(0).getFrakcija04());
        AOPreletnaMasaFrakcija4_8.setValue(result.get(0).getFrakcija48());
        AOPreletnaMasaFrakcija8_16.setValue(result.get(0).getFrakcija816());
        AOPreletnaMasaFrakcija16_32.setValue(result.get(0).getFrakcija1632());
        AOPreletnaMasaCement.setValue(result.get(0).getCement());
        AOPreletnaMasaFiler.setValue(result.get(0).getFiler());
        AOPreletnaMasaAditiv1.setValue(result.get(0).getAditiv1());
        AOPreletnaMasaAditiv2.setValue(result.get(0).getAditiv2());
        AOPreletnaMasaVoda.setValue(result.get(0).getVoda());

    }

    public void setPreleti() {
        setParametri = true;
        es.submit(this);
    }

    private synchronized void setPreletiRun(double AOPreletnaMasaFrakcija0_4, double AOPreletnaMasaFrakcija4_8, double AOPreletnaMasaFrakcija8_16,
            double AOPreletnaMasaFrakcija16_32, double AOPreletnaMasaCement, double AOPreletnaMasaFiler,
            double AOPreletnaMasaAditiv1, double AOPreletnaMasaAditiv2, double AOPreletnaMasaVoda) {

        Long a = 1l;
        EntityManager em = emf.createEntityManager();
        db.Preleti p = em.find(db.Preleti.class, a);
        em.getTransaction().begin();

        p.setFrakcija04(AOPreletnaMasaFrakcija0_4);
        p.setFrakcija48(AOPreletnaMasaFrakcija4_8);
        p.setFrakcija816(AOPreletnaMasaFrakcija8_16);
        p.setFrakcija1632(AOPreletnaMasaFrakcija16_32);
        p.setCement(AOPreletnaMasaCement);
        p.setFiler(AOPreletnaMasaFiler);
        p.setAditiv1(AOPreletnaMasaAditiv1);
        p.setAditiv2(AOPreletnaMasaAditiv2);
        p.setVoda(AOPreletnaMasaVoda);

        em.persist(p);
        em.getTransaction().commit();
        em.close();
        setParametri = false;

    }

    @Override
    public void run() {
        if (getParametri) {
            getPreletiRun();
        }
        if (setParametri) {
            setPreletiRun(Convert.stringToDouble(AOPreletnaMasaFrakcija0_4.getValue().toString()),
                    Convert.stringToDouble(AOPreletnaMasaFrakcija4_8.getValue().toString()),
                    Convert.stringToDouble(AOPreletnaMasaFrakcija8_16.getValue().toString()),
                    Convert.stringToDouble(AOPreletnaMasaFrakcija16_32.getValue().toString()),
                    Convert.stringToDouble(AOPreletnaMasaCement.getValue().toString()),
                    Convert.stringToDouble(AOPreletnaMasaFiler.getValue().toString()),
                    Convert.stringToDouble(AOPreletnaMasaAditiv1.getValue().toString()),
                    Convert.stringToDouble(AOPreletnaMasaAditiv2.getValue().toString()),
                    Convert.stringToDouble(AOPreletnaMasaVoda.getValue().toString()));
            getPreletiRun();
            updateResult();
        }
    }

}
