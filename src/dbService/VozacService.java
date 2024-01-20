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
public class VozacService {

    private final EntityManagerFactory emf;

    public VozacService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<db.Vozac> getVozaci() {
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT v FROM Vozac v ORDER BY v.vozac ASC");
            List<db.Vozac> result = q.getResultList();
            em.close();
            return result;
        } catch (Exception ex) {
            List<db.Vozac> result = new ArrayList<>();
            db.Vozac vozac = new db.Vozac();
            vozac.setId(1l);
            vozac.setVozac("");
            vozac.setAktivan(true);
            result.add(vozac);
            return result;
        }

    }

    public void addVozac(String vozacType) {
        try {
            db.Vozac vozac = new db.Vozac();

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            vozac.setVozac(vozacType);
            vozac.setAktivan(true);

            em.persist(vozac);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null, "Dodali ste vozaca", "Obavestenje",1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Doslo je do greske, pokusajte ponovo da dodate vozaca", "Obavestenje",0);
        }
    }
    
     public void deleteVozac(long id){
         try {
            EntityManager em = emf.createEntityManager();
            db.Vozac p = em.find(db.Vozac.class, id);
            em.getTransaction().begin();
            p.setAktivan(false);
            em.persist(p);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
