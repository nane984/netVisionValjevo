/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

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

/**
 *
 * @author branko.scekic
 */
public class RucniRadService {

    private final EntityManagerFactory emf;

    public RucniRadService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void addRecord(String opis, double vrednost) {

        db.Rucnirad rucniRad = new db.Rucnirad();

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Date dNow = new Date();

        rucniRad.setOpis(opis);
        rucniRad.setDatum(dNow);
        rucniRad.setVrednost(vrednost);

        em.persist(rucniRad);
        em.getTransaction().commit();
        em.close();
    }

    public List<db.Rucnirad> getRucniRad() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT r FROM Rucnirad r ORDER BY r.id");

        List<db.Rucnirad> result = q.getResultList();
        em.close();

        return result;
    }

    public List<db.Rucnirad> getRucniRadWhere(String filterDatumOd, String filterDatumDo) {
        EntityManager em = emf.createEntityManager();

        DateFormat formatMyComp = new SimpleDateFormat("dd MMM yyyy", Locale.ROOT);
////////////////////VAZNOOO KADA SE SPUSTA U VALJEVU PROMENITI FORMAT ////////////////////////////////////////////////////////////////////////////////////////////////
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");//ovo funkcionise kod njih za format month/day/year
        //SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");//ovo je na mom pc

        List<db.Rucnirad> result;

        try {

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

            Query q = em.createQuery("SELECT r FROM Rucnirad r WHERE r.datum >= :datumOd AND r.datum <= :datumDo ORDER BY r.id");
            q.setParameter("datumOd", dateOd);
            q.setParameter("datumDo", dateDo);

            result = q.getResultList();
            em.close();

            return result;

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, ex);
            result = new ArrayList<>();
        }
        return result;
    }
}
