/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

import betonMesalica.TekuciRN;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author branko.scekic
 */
public class OtpremaService{

    private final EntityManagerFactory emf;
    private final TekuciRN tekuciRN;


    public OtpremaService(EntityManagerFactory emf, TekuciRN tekuciRN) {
        this.emf = emf;
        this.tekuciRN = tekuciRN;
    }


    public void addOprema(db.Radninalog radniNalog, String vozac, String vozilo, double zadataKolicinaOtprema) {
        try {
            
            db.Otprema otprema = new db.Otprema();
            Date localDate = new Date();

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            otprema.setRadninalog(radniNalog);
            otprema.setStatus(0);
            otprema.setDatum(localDate);
            otprema.setVozac(vozac);
            otprema.setVozilo(vozilo);
            otprema.setZadatom3((float) zadataKolicinaOtprema);
            otprema.setIzdatom3(0);
            otprema.setBrotpreme(radniNalog.getBrojotpreme()+1);

            em.persist(otprema);
            em.getTransaction().commit();
            em.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Proverite broj radnog naloga", "Dialog", JOptionPane.ERROR_MESSAGE);
        }

    }

    public db.Otprema getLastOtprema(db.Radninalog rn) {
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT o FROM Otprema o WHERE o.radninalog.rn = :rn ORDER BY o.id DESC");
            q.setParameter("rn", rn.getRn());

           
            List<db.Otprema> result = q.getResultList();
            em.close();
            
            
            db.Otprema zadnjaOtprema = result.get(0);
            return zadnjaOtprema;

        } catch (Exception ex) {
            db.Otprema a = new db.Otprema();
            return a;
            
        }
    }

    public void isporuceno(float isporuceno) {
        try {
            EntityManager em = emf.createEntityManager();
            db.Otprema otprema = em.find(db.Otprema.class, tekuciRN.getTekucaOtp().getId());
            em.getTransaction().begin();
            otprema.setIzdatom3(isporuceno);
            em.getTransaction().commit();
            
            tekuciRN.setTekucaOtp(getOtprema(tekuciRN.getTekucaOtp().getId()));
            

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public float getIsporuceno() {
        try {
            EntityManager em = emf.createEntityManager();
            db.Otprema otprema = em.find(db.Otprema.class, tekuciRN.getTekucaOtp().getId());
            em.getTransaction().begin();
            float res = otprema.getIzdatom3();
            em.getTransaction().commit();
            
            return res;

        } catch (Exception ex) {
            System.out.println(ex);
            return 0;
        }
    }
    
    public List<db.Otprema> getOtpremeZaRN(long rn) {
      
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT o FROM Otprema o WHERE o.radninalog.rn = :rn ORDER BY o.datum DESC");
            q.setParameter("rn", rn);
            List<db.Otprema> result = q.getResultList();
            em.close();
            
            return result;
    }

      
    

    public db.Otprema getOtprema(long brOtp) {
        
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT o FROM Otprema o WHERE o.id = :brOtp");
            q.setParameter("brOtp", brOtp);
            db.Otprema result = (db.Otprema) q.getSingleResult();
            em.close();

            return result;
                
        } catch (Exception ex) {
            db.Otprema a = new db.Otprema();
            return a;
        }
    }
    
    public db.Otprema getOtpremaBrRNOtp(long brRn, long brOtp) {
        
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT o FROM Otprema o WHERE o.radninalog.rn = :brRn AND o.brotpreme = :brOtp");
            q.setParameter("brRn", brRn);
            q.setParameter("brOtp", brOtp);
            db.Otprema result = (db.Otprema) q.getSingleResult();
            em.close();

            return result;
                
        } catch (Exception ex) {
            db.Otprema a = new db.Otprema();
            return a;
        }
    } 


}
