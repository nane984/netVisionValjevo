/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author branko.scekic
 */
public class SifreService {
    
    private final EntityManagerFactory emf;

    public SifreService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    
    public db.Sifre getSifre(long id) {
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT s FROM Sifre s WHERE s.id = :id");
            q.setParameter("id", id);

            db.Sifre res = (db.Sifre) q.getSingleResult();
            em.close();

            return res;
        } catch (Exception ex) {
            db.Sifre markabetona = new db.Sifre();
            markabetona.setId(100l);
            markabetona.setFrakcija04("0");
            markabetona.setFrakcija48("0");
            markabetona.setFrakcija816("0");
            markabetona.setFrakcija1632("0");
            markabetona.setCement("0");
            markabetona.setFiler("0");
            markabetona.setAditiv1("0");
            markabetona.setAditiv2("0");
            markabetona.setVoda("0");
            

            return markabetona;
        }
    }

    
    
    public void setSifra(long id, String sifraFrakcija04, String sifraFrakcija48, 
            String sifraFrakcija816, String sifraFrakcija1632, String sifraCement, String sifraFiler, 
            String sifraAditiv1, String sifraAditiv2, String sifraVoda) {

        try {
            EntityManager em = emf.createEntityManager();
            db.Sifre p = em.find(db.Sifre.class, id);
            em.getTransaction().begin();

            
            p.setFrakcija04(sifraFrakcija04);
            p.setFrakcija48(sifraFrakcija48);
            p.setFrakcija816(sifraFrakcija816);
            p.setFrakcija1632(sifraFrakcija1632);
            p.setCement(sifraCement);
            p.setFiler(sifraFiler);
            p.setAditiv1(sifraAditiv1);
            p.setAditiv2(sifraAditiv2);
            p.setVoda(sifraVoda);

            em.persist(p);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {

        }
    }
}
