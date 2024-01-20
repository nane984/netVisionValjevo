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

/**
 *
 * @author branko.scekic
 */
public class MarkaBetonaService {

    private final EntityManagerFactory emf;

    public MarkaBetonaService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public List<db.Markabetona> getRecepti() {
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT m FROM Markabetona m ORDER BY m.id ASC");
            List<db.Markabetona> result = q.getResultList();
            em.close();
            return result;
        } catch (Exception ex) {
            List<db.Markabetona> result = new ArrayList<>();
            db.Markabetona markabetona = new db.Markabetona();
            markabetona.setId(100l);
            markabetona.setFrakcija04(0);
            markabetona.setFrakcija48(0);
            markabetona.setFrakcija816(0);
            markabetona.setFrakcija1632(0);
            markabetona.setCement(0);
            markabetona.setFiler(0);
            markabetona.setAditiv1(0);
            markabetona.setAditiv2(0);
            markabetona.setVoda(0);
            markabetona.setVrememesanja(0d);
            markabetona.setVremepraznjenja(0d);
           
            result.add(markabetona);
            return result;
        }
    }

    public db.Markabetona getRecept(long id) {
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT m FROM Markabetona m WHERE m.id = :id");
            q.setParameter("id", id);

            db.Markabetona res = (db.Markabetona) q.getSingleResult();
            em.close();

            return res;
        } catch (Exception ex) {
            db.Markabetona markabetona = new db.Markabetona();
            markabetona.setId(100l);
            markabetona.setFrakcija04(0);
            markabetona.setFrakcija48(0);
            markabetona.setFrakcija816(0);
            markabetona.setFrakcija1632(0);
            markabetona.setCement(0);
            markabetona.setFiler(0);
            markabetona.setAditiv1(0);
            markabetona.setAditiv2(0);
            markabetona.setVoda(0);
            

            return markabetona;
        }
    }

    public void setRecept(long id, String nazivIzabranogRecepta, double frakcija0_4, double frakcija4_8, double frakcija8_16,
            double frakcija16_32, double cement, double filer,
            double aditiv1, double aditiv2, double voda, double vremeMesanja, 
            double vremePraznjenja) {

        try {
            EntityManager em = emf.createEntityManager();
            db.Markabetona p = em.find(db.Markabetona.class, id);
            em.getTransaction().begin();

            p.setMarkabeton(nazivIzabranogRecepta);
            p.setFrakcija04(frakcija0_4);
            p.setFrakcija48(frakcija4_8);
            p.setFrakcija816(frakcija8_16);
            p.setFrakcija1632(frakcija16_32);
            p.setCement(cement);
            p.setFiler(filer);
            p.setAditiv1(aditiv1);
            p.setAditiv2(aditiv2);
            p.setVoda(voda);
            p.setVrememesanja(vremeMesanja);
            p.setVremepraznjenja(vremePraznjenja);
            

            em.persist(p);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            EntityManager em = emf.createEntityManager();
            db.Markabetona p = new db.Markabetona();
            em.getTransaction().begin();
            p.setId(id);
            p.setMarkabeton(nazivIzabranogRecepta);
            p.setFrakcija04(frakcija0_4);
            p.setFrakcija48(frakcija4_8);
            p.setFrakcija816(frakcija8_16);
            p.setFrakcija1632(frakcija16_32);
            p.setCement(cement);
            p.setFiler(filer);
            p.setAditiv1(aditiv1);
            p.setAditiv2(aditiv2);
            p.setVoda(voda);
            p.setVrememesanja(vremeMesanja);
            p.setVremepraznjenja(vremePraznjenja);
            em.persist(p);
            em.getTransaction().commit();
            em.close();
        }
    }

    public db.Markabetona getRecept(String recept) {
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT m FROM Markabetona m WHERE m.markabeton = :rcp");
            q.setParameter("rcp", recept);

            db.Markabetona selektovanaMarkaBetona = (db.Markabetona) q.getSingleResult();
            //db.Markabetona res = selektovanaMarkaBetona;
            em.close();

            
            
            return selektovanaMarkaBetona;
            
            
        } catch (Exception ex) {
            db.Markabetona markabetona = new db.Markabetona();
            markabetona.setId(100l);
            markabetona.setFrakcija04(0);
            markabetona.setFrakcija48(0);
            markabetona.setFrakcija816(0);
            markabetona.setFrakcija1632(0);
            markabetona.setCement(0);
            markabetona.setFiler(0);
            markabetona.setAditiv1(0);
            markabetona.setAditiv2(0);
            markabetona.setVoda(0);
           
            
            return markabetona;
        }
    }

    
    public void setVoda(long id, double voda) {

        try {
            EntityManager em = emf.createEntityManager();
            db.Markabetona p = em.find(db.Markabetona.class, id);
            em.getTransaction().begin();

            p.setVoda(voda);

            em.persist(p);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {

        }
    }

}
