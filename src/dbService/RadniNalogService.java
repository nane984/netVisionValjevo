/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

import betonMesalica.TekuciRN;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import utils.StatusRN;

;

/**
 *
 * @author branko.scekic
 */
public class RadniNalogService {

    private final EntityManagerFactory emf;
    private final TekuciRN tekuciRN;

    public RadniNalogService(EntityManagerFactory emf, TekuciRN tekuciRN) {
        this.emf = emf;
        this.tekuciRN = tekuciRN;
    }

    public List<db.Radninalog> getAktivniRadniNalozi() {
        try {
            int aktivniRN = StatusRN.getAktivan();
            EntityManager em = emf.createEntityManager();
            Query q = em.createQuery("SELECT r FROM Radninalog r WHERE r.status = :status ORDER BY r.datum DESC");
            q.setParameter("status", aktivniRN);
            List<db.Radninalog> result = q.getResultList();
            em.close();
            return result;
        } catch (Exception e) {
            db.Radninalog a = new db.Radninalog();
            List<db.Radninalog> result = new ArrayList<>();
            result.add(a);
            return result;
        }

    }

    public void addRadniNalog(long brRn, String kupac, String gradiliste, String markaBetona, float zadataKolicina) {
        try {
            db.Radninalog radniNalog = new db.Radninalog();
            Date localDate = new Date();

            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            radniNalog.setRn(brRn);
            radniNalog.setKupac(kupac);
            radniNalog.setGradiliste(gradiliste);
            radniNalog.setMarkabetona(markaBetona);
            radniNalog.setStatus(StatusRN.getAktivan());
            radniNalog.setUgovorenom3(zadataKolicina);
            radniNalog.setIsporucenom3(0);
            radniNalog.setDatum(localDate);
            radniNalog.setBrojotpreme(0);

            em.persist(radniNalog);
            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nije upisan radni nalog");
        }
    }

    public List<db.Radninalog> getSviRadniNalozi() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT r FROM Radninalog r ORDER BY r.datum DESC");

        List<db.Radninalog> result = q.getResultList();
        em.close();

        return result;
    }

    public List<String> getMarkeBetona() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT DISTINCT r.markabetona FROM Radninalog r ORDER BY r.markabetona");
        //Query q = em.createNamedQuery("Markabetona.findAll");
        List<String> result = q.getResultList();
        em.close();

        return result;
    }

    public List<String> getSviKupci() {

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT DISTINCT r.kupac FROM Radninalog r ORDER BY r.kupac");
        //Query q = em.createNamedQuery("Markabetona.findAll");
        List<String> result = q.getResultList();
        em.close();

        return result;
    }

    public List<String> getGradilista() {

        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT DISTINCT r.gradiliste FROM Radninalog r ORDER BY r.gradiliste");
        //Query q = em.createNamedQuery("Markabetona.findAll");
        List<String> result = q.getResultList();
        em.close();

        return result;
    }

    public List<db.Radninalog> getFilteredData(String filterRadniNalog, int filterStatus,
            String filterKupac, String filterGradiliste, String filterMarkaBetona,
            String filterDatumOd, String filterDatumDo) {
        List<db.Radninalog> result;
        try {
            EntityManager em = emf.createEntityManager();
            Query q;

            DateFormat formatMyComp = new SimpleDateFormat("dd MMM yyyy", Locale.ROOT);
////////////////////VAZNOOO KADA SE SPUSTA U VALJEVU PROMENITI FORMAT ///////////////////////////////////////////////////////////////////////////////////////////////////////////            
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");//ovo funkcionise kod njih za format month/day/year
            //SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");//ovo je na mom pc
            
            
            Date dateOd;
            Date dateDo;

            if (!filterDatumOd.isEmpty()) {
                dateOd = sdf.parse(filterDatumOd);

            } else {
                dateOd = formatMyComp.parse("01 jan 2000  00:01:00");
            }

            if (!filterDatumDo.isEmpty()) {
                dateDo = sdf.parse(filterDatumDo);

            } else {
                dateDo = formatMyComp.parse("01 jan 2040  23:59:00");
            }

            if (!filterRadniNalog.isEmpty()) {
                q = em.createQuery("SELECT r FROM Radninalog r WHERE r.rn = :rn");
                q.setParameter("rn", Integer.parseInt(filterRadniNalog));

            } else {

                if (filterStatus == 0) {
                    q = em.createQuery("SELECT r FROM Radninalog r WHERE r.kupac LIKE :kupac AND r.gradiliste LIKE :gradiliste AND r.markabetona LIKE :markabetona "
                            + "AND r.datum >= :datumOd AND r.datum <= :datumDo ORDER BY r.datum DESC");
                    q.setParameter("kupac", "%" + filterKupac + "%");
                    q.setParameter("gradiliste", "%" + filterGradiliste + "%");
                    q.setParameter("markabetona", "%" + filterMarkaBetona + "%");
                    q.setParameter("datumOd", dateOd);
                    q.setParameter("datumDo", dateDo);
                } else {
                    q = em.createQuery("SELECT r FROM Radninalog r WHERE r.kupac LIKE :kupac AND r.gradiliste LIKE :gradiliste AND r.markabetona LIKE :markabetona "
                            + "AND r.datum >= :datumOd AND r.datum <= :datumDo AND r.status = :status ORDER BY r.datum DESC");
                    q.setParameter("kupac", "%" + filterKupac + "%");
                    q.setParameter("gradiliste", "%" + filterGradiliste + "%");
                    q.setParameter("markabetona", "%" + filterMarkaBetona + "%");
                    q.setParameter("status", filterStatus - 1);
                    q.setParameter("datumOd", dateOd);
                    q.setParameter("datumDo", dateDo);
                }

            }

            result = q.getResultList();
            em.close();

            return result;

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
            result = new ArrayList<>();
        }
        return result;

    }

    public db.Radninalog getRN(long rn) {
        try{
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT r FROM Radninalog r WHERE r.rn = :rn");
        q.setParameter("rn", rn);

        db.Radninalog tekuciRadniNalog = (db.Radninalog) q.getSingleResult();
        em.close();

        return tekuciRadniNalog;
        }catch(Exception ex){
            db.Radninalog tekuciRadniNalog = new db.Radninalog();
            return tekuciRadniNalog;
        }
    }

    public void setBrOtpreme(db.Radninalog trn) {
        try {
            EntityManager em = emf.createEntityManager();
            db.Radninalog rn = em.find(db.Radninalog.class, trn.getRn());
            em.getTransaction().begin();
            rn.setBrojotpreme(trn.getBrojotpreme() + 1);
            em.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void setIsporucenoBetona(db.Radninalog tekuciRN, float isporuceno) {
        try {
            //float newIzdato = tekuciRN.getIsporucenom3() + isporuceno;
            float newIzdato = isporuceno;
            
            EntityManager em = emf.createEntityManager();
            db.Radninalog rn = em.find(db.Radninalog.class, tekuciRN.getRn());
            em.getTransaction().begin();
            rn.setIsporucenom3(newIzdato);
            em.getTransaction().commit();

            this.tekuciRN.setTekuciRN(getRN(tekuciRN.getRn()));
            this.tekuciRN.setReadiTekuciRN(true);

            if ((this.tekuciRN.getTekuciRN().getUgovorenom3() - newIzdato) < 0.1) {
                setRnStatus(StatusRN.getZavrsen(), this.tekuciRN.getTekuciRN());
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void setRnStatus(int status, db.Radninalog rnStatus) {
        try {
            EntityManager em = emf.createEntityManager();
            db.Radninalog rn = em.find(db.Radninalog.class, rnStatus.getRn());
            em.getTransaction().begin();
            rn.setStatus(status);
            em.getTransaction().commit();
            getRN(status);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
