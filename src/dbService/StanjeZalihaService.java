/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbService;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import utils.Convert;

/**
 *
 * @author branko.scekic
 */
public class StanjeZalihaService{

    private final EntityManagerFactory emf;
    private List<db.Stanjezaliha> result;


    private JLabel frakcija0_4;
    private JLabel frakcija4_8;
    private JLabel frakcija8_16;
    private JLabel frakcija16_32;
    private JLabel cement;
    private JLabel filer;
    private JLabel aditiv1;
    private JLabel aditiv2;
    
    private JSpinner DodajZaliheFrakcija04;
    private JSpinner DodajZaliheFrakcija48;
    private JSpinner DodajZaliheFrakcija816;
    private JSpinner DodajZaliheFrakcija1632;
    private JSpinner DodajZaliheCement;
    private JSpinner DodajZaliheFiler;
    private JSpinner DodajZaliheAditiv1;
    private JSpinner DodajZaliheAditiv2;

    public StanjeZalihaService(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    
    
    public synchronized List<db.Stanjezaliha> getStanjeZaliha() {
        EntityManager em = emf.createEntityManager();
        //Query q = em.createQuery("SELECT z FROM Zbirniparametri z");
        Query q = em.createNamedQuery("Stanjezaliha.findAll");
        result = q.getResultList();
        em.close();
        return result;
    }

    private void updateResult() {
        frakcija0_4.setText(Convert.doubleToString(result.get(0).getFrakcija04()));
        frakcija4_8.setText(Convert.doubleToString(result.get(0).getFrakcija48()));
        frakcija8_16.setText(Convert.doubleToString(result.get(0).getFrakcija816()));
        frakcija16_32.setText(Convert.doubleToString(result.get(0).getFrakcija1632()));
        cement.setText(Convert.doubleToString(result.get(0).getCement()));
        filer.setText(Convert.doubleToString(result.get(0).getFiler()));
        aditiv1.setText(Convert.doubleToString(result.get(0).getAditiv1()));
        aditiv2.setText(Convert.doubleToString(result.get(0).getAditiv2()));

    }
    
    
    
    
    public synchronized void setStanjeZaliha(double AOPreletnaMasaFrakcija0_4, double AOPreletnaMasaFrakcija4_8, double AOPreletnaMasaFrakcija8_16,
             double AOPreletnaMasaFrakcija16_32, double AOPreletnaMasaCement, double AOPreletnaMasaFiler,
             double AOPreletnaMasaAditiv1, double AOPreletnaMasaAditiv2){
         
        Long a = 1l;
        EntityManager em = emf.createEntityManager();
        db.Stanjezaliha p = em.find(db.Stanjezaliha.class, a);
        em.getTransaction().begin();

        p.setFrakcija04(AOPreletnaMasaFrakcija0_4 + Convert.stringToDouble(frakcija0_4.getText()));
        p.setFrakcija48(AOPreletnaMasaFrakcija4_8 + Convert.stringToDouble(frakcija4_8.getText()));
        p.setFrakcija816(AOPreletnaMasaFrakcija8_16 + Convert.stringToDouble(frakcija8_16.getText()));
        p.setFrakcija1632(AOPreletnaMasaFrakcija16_32 + Convert.stringToDouble(frakcija16_32.getText()));
        p.setCement(AOPreletnaMasaCement + Convert.stringToDouble(cement.getText()));
        p.setFiler(AOPreletnaMasaFiler + Convert.stringToDouble(filer.getText()));
        p.setAditiv1(AOPreletnaMasaAditiv1 + Convert.stringToDouble(aditiv1.getText()));
        p.setAditiv2(AOPreletnaMasaAditiv2 + Convert.stringToDouble(aditiv2.getText()));
           
        em.persist(p);
        em.getTransaction().commit();
        em.close();
     }
    
    private void setToZero(){
        DodajZaliheFrakcija04.setValue(0);
        DodajZaliheFrakcija48.setValue(0);
        DodajZaliheFrakcija816.setValue(0);
        DodajZaliheFrakcija1632.setValue(0);
        DodajZaliheCement.setValue(0);
        DodajZaliheFiler.setValue(0);
        DodajZaliheAditiv1.setValue(0);
        DodajZaliheAditiv2.setValue(0);
    }
    
}
