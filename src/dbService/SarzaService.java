/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

import java.util.ArrayList;
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
public class SarzaService{

    private final EntityManagerFactory emf;


    public SarzaService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
     public void addSarza(db.Radninalog rn, db.Otprema otprema, String MWheaderZadato0_4,
            String MWheaderIzdato0_4, String MWheaderZadato4_8, String MWheaderIzdato4_8, String MWheaderZadato8_16,
            String MWheaderIzdato8_16, String MWheaderZadato16_32, String MWheaderIzdato16_32, String MWheaderZadatoCement,
            String MWheaderIzdatoCement, String MWheaderZadatoFiler, String MWheaderIzdatoFiler, String MWheaderZadatoAditiv1,
            String MWheaderIzdatoAditiv1, String MWheaderZadatoAditiv2, String MWheaderIzdatoAditiv2, String MWheaderZadatoVoda,
            String MWheaderIzdatoVoda) {
        try {
            db.Sarza sarza = new db.Sarza();
            Date localDate = new Date();

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            sarza.setRadninalog(rn);
            sarza.setOtprema(otprema);

            sarza.setAgregatzadato04(Integer.parseInt(MWheaderZadato0_4));
            sarza.setAgregatizdato04(Integer.parseInt(MWheaderIzdato0_4));
            sarza.setAgregatzadato48(Integer.parseInt(MWheaderZadato4_8));
            sarza.setAgregaizdato48(Integer.parseInt(MWheaderIzdato4_8));
            sarza.setAgregatzadato816(Integer.parseInt(MWheaderZadato8_16));
            sarza.setAgregatizdato816(Integer.parseInt(MWheaderIzdato8_16));
            sarza.setAgregatzadato1632(Integer.parseInt(MWheaderZadato16_32));
            sarza.setAgregatizdato1632(Integer.parseInt(MWheaderIzdato16_32));

            sarza.setCementzadato(Integer.parseInt(MWheaderZadatoCement));
            sarza.setCementizdato(Integer.parseInt(MWheaderIzdatoCement));

            sarza.setFilerzadato(Integer.parseInt(MWheaderZadatoFiler));
            sarza.setFilerizdato(Integer.parseInt(MWheaderIzdatoFiler));

            sarza.setAditiv1zadato(Float.parseFloat(MWheaderZadatoAditiv1));
            sarza.setAditiv1izdato(Float.parseFloat(MWheaderIzdatoAditiv1));
            sarza.setAditiv2zadato(Float.parseFloat(MWheaderZadatoAditiv2));
            sarza.setAditiv2izdato(Float.parseFloat(MWheaderIzdatoAditiv2));

            sarza.setVodazadato(Integer.parseInt(MWheaderZadatoVoda));
            sarza.setVodaizdato(Integer.parseInt(MWheaderIzdatoVoda));

            sarza.setDate(localDate);

            em.persist(sarza);
            em.getTransaction().commit();
            em.close();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Nije upisana sarza", "Dialog", JOptionPane.ERROR_MESSAGE);
        }

    }

    public List<db.Sarza> getSarzeZaOtpremu(long otprema) {
       try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT s FROM Sarza s WHERE s.otprema.id = :otprema");
            q.setParameter("otprema", otprema);
            List<db.Sarza> result = q.getResultList();
            em.close();
            return result;
        } catch (Exception ex) {
            db.Sarza a = new db.Sarza();
            List<db.Sarza> result = new ArrayList<>();
            result.add(a);
            return result;
        }
    }
    
    public List<db.Sarza> getSarzeZaRadniNalog(long radniNalog){
        try {
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT s FROM Sarza s WHERE s.radninalog.rn = :radniNalog");
            q.setParameter("radniNalog", radniNalog);
            List<db.Sarza> result = q.getResultList();
            em.close();
            return result;
        } catch (Exception ex) {
            db.Sarza a = new db.Sarza();
            List<db.Sarza> result = new ArrayList<>();
            result.add(a);
            return result;
        }
    }
}
