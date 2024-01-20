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
public class GradilisteService {

    private final EntityManagerFactory emf;

    public GradilisteService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<db.Gradiliste> getGradiliste() {
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT g FROM Gradiliste g ORDER BY g.gradiliste ASC");
            List<db.Gradiliste> result = q.getResultList();
            em.close();
            return result;
        } catch (Exception ex) {
            List<db.Gradiliste> result = new ArrayList<>();
            db.Gradiliste gradiliste = new db.Gradiliste();
            gradiliste.setId(1l);
            gradiliste.setGradiliste("");
            gradiliste.setAktivno(true);
            result.add(gradiliste);
            return result;
        }

    }

    public void addGradiliste(String gradiliste) {
        try {
            db.Gradiliste gradilisteDb = new db.Gradiliste();

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            gradilisteDb.setGradiliste(gradiliste);
            gradilisteDb.setAktivno(true);

            em.persist(gradilisteDb);
            em.getTransaction().commit();
            em.close();
            JOptionPane.showMessageDialog(null, "Dodali ste gradiliste", "Obavestenje", 1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Doslo je do greske, pokusajte ponovo da dodate gradiliste", "Obavestenje", 0);
        }
    }
    public void deleteGradiliste(long id){
         try {
            EntityManager em = emf.createEntityManager();
            db.Gradiliste p = em.find(db.Gradiliste.class, id);
            em.getTransaction().begin();

            p.setAktivno(false);
            em.persist(p);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}