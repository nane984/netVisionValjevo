/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author branko.scekic
 */
public class KupacService {

    private final EntityManagerFactory emf;

    public KupacService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<db.Kupac> getKupci() {
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT k FROM Kupac k ORDER BY k.kupac ASC");
            List<db.Kupac> result = q.getResultList();
            em.close();
            return result;
        } catch (Exception ex) {
            List<db.Kupac> result = new ArrayList<>();
            db.Kupac kupac = new db.Kupac();
            kupac.setId(1l);
            kupac.setKupac("");
            kupac.setAktivan(true);
            result.add(kupac);
            return result;
        }
    }
    
    public db.Kupac getKupac(int id){
         try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT k FROM Kupac k WHERE k.id = :id");
            q.setParameter("id", id);

            db.Kupac res = (db.Kupac) q.getSingleResult();
            em.close();

            return res;
        } catch (Exception ex) {
            db.Kupac kupac = new db.Kupac();
            kupac.setId(100l);
            kupac.setAktivan(false);
            kupac.setKupac("");

            return kupac;
        }
    }
    
    public void deleteKupac(long id){
         try {
            EntityManager em = emf.createEntityManager();
            db.Kupac p = em.find(db.Kupac.class, id);
            em.getTransaction().begin();

            p.setAktivan(false);
            em.persist(p);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addKupac(String newKupac) {

        try {
            db.Kupac kupac = new db.Kupac();

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            kupac.setKupac(newKupac);
            kupac.setAktivan(true);

            em.persist(kupac);
            em.getTransaction().commit();
            em.close();
            getKupci();

            JOptionPane.showMessageDialog(null, "Dodali ste kupca", "Obavestenje", 1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Doslo je do greske, pokusajte ponovo da dodate kupca", "Obavestenje", 0);
        }
    }
}