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
public class VoziloService {

    private final EntityManagerFactory emf;


    public VoziloService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<db.Vozilo> getVozila() {
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT v FROM Vozilo v ORDER BY v.tablica ASC");
            List<db.Vozilo> result = q.getResultList();
            em.close();
            return result;
        } catch (Exception ex) {
            List<db.Vozilo> result = new ArrayList<>();
            db.Vozilo vozilo = new db.Vozilo();
            vozilo.setId(1l);
            vozilo.setVozilo("");
            vozilo.setAkivan(true);
            result.add(vozilo);
            return result;
        }
    }

    public void addVozilo(String newVozilo) {
        try {
            db.Vozilo vozilo = new db.Vozilo();

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            vozilo.setTablica(newVozilo);
            vozilo.setAkivan(true);

            em.persist(vozilo);
            em.getTransaction().commit();
            em.close();

            getVozila();
            JOptionPane.showMessageDialog(null, "Dodali ste vozilo", "Obavestenje", 1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Doslo je do greske, pokusajte ponovo da dodate vozilo", "Obavestenje", 0);
        }
    }
    
     public void deleteVozilo(long id){
         try {
            EntityManager em = emf.createEntityManager();
            db.Vozilo p = em.find(db.Vozilo.class, id);
            em.getTransaction().begin();
            p.setAkivan(false);
            em.persist(p);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
