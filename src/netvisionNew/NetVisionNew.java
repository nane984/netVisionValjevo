/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netvisionNew;

import betonMesalica.BrSarzi;
import betonMesalica.TekuciRN;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import dbService.GradilisteService;
import dbService.KupacService;
import dbService.MarkaBetonaService;
import dbService.OtpremaService;
import dbService.PreletiService;
import dbService.RadniNalogService;
import dbService.RucniRadService;
import dbService.SarzaService;
import dbService.SifreService;
import dbService.StanjeZalihaService;
import dbService.VozacService;
import dbService.VoziloService;
import dbService.ZbirniParametriService;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import netvisionNew.form.MainForm;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import netvisionNew.form.DataForm;
import netvisionNew.win.AktivniRadniNaloziFrame;
import netvisionNew.win.GradilisteFrame;
import netvisionNew.win.KupacFrame;
import netvisionNew.win.MarkaBetonaFrame;
import netvisionNew.win.NovaOtpremaFrame;
import netvisionNew.win.NoviRadniNalogFrame;
import netvisionNew.win.PregledOtpremaZaRadniNalogFrame;
import netvisionNew.win.PregledRadnihNalogaFrame;
import netvisionNew.win.PregledSarziZaOtpremuFrame;
import netvisionNew.win.PreletnaMasaFrame;
import netvisionNew.win.SifreFrame;
import netvisionNew.win.StanjeZalihaFrame;
import netvisionNew.win.VozacFrame;
import netvisionNew.win.VoziloFrame;
import netvisionNew.win.ZbirniParametriFrame;
import pogon.Pogon;
import print.OtpremnicaStampa;
import report.PregledIzvestajaFrame;
import rucniRad.RucniRad;
import rucniRad.RucniRadOtprema;


/**
 *
 * @author branko.scekic
 */
public class NetVisionNew {

    private final Pogon pogon;
    private final OtpremnicaStampa otpremnicaStampa;
    
    private final TekuciRN tekuciRN;
    private final BrSarzi brSarzi;
    
    private final RucniRad rucniRad;
    private final RucniRadOtprema rucniRadOtprema;
    
    //Database
    private EntityManagerFactory emf;
    private final VozacService vozacDb;
    private final KupacService kupacDb;
    private final GradilisteService gradilisteDb;
    private final VoziloService voziloDb;
    private final MarkaBetonaService markaBetonaDb;
    private final RadniNalogService radniNalogDb;
    private final OtpremaService otpremaDb;
    private final SarzaService sarzaDb;
    private final SifreService sifreDb;
    private final StanjeZalihaService stanjeZalihaDb;
    private final RucniRadService rucniRadDb;
    private final ZbirniParametriService zbirniParametriDb;
    private final PreletiService preletiDb;
    
    
    //thread
    private final ExecutorService es;
    
    //Frame
    private final VozacFrame vozacFrame;
    private final KupacFrame kupacFrame;
    private final GradilisteFrame gradilisteFrame;
    private final VoziloFrame voziloFrame;
    private final MarkaBetonaFrame markaBetonaFrame;
    private final AktivniRadniNaloziFrame aktivniRadniNaloziFrame;
    private final NoviRadniNalogFrame noviRadniNalogFrame;
    private final PregledRadnihNalogaFrame pregledRadnihNalogaFrame;
    private final NovaOtpremaFrame novaOtpremaFrame;
    private final PregledOtpremaZaRadniNalogFrame pregledRadnogNalogaPoOtpremamaFrame;
    private final PregledSarziZaOtpremuFrame pregledSarziZaOtpremuFrame;
    private final SifreFrame sifreFrame;
    private final PregledIzvestajaFrame pregledIzvestajaFrame;
    private final ZbirniParametriFrame zbirniParametriFrame;
    private final PreletnaMasaFrame preletnaMasaFrame;
    private final StanjeZalihaFrame stanjeZalihaFrame;


    
    public NetVisionNew(){
        this.es = Executors.newFixedThreadPool(4);
        
        this.pogon = new Pogon();
        this.emf = emf = Persistence.createEntityManagerFactory("netVisionValjevoPU");
        this.brSarzi = new BrSarzi();
        this.otpremnicaStampa = new OtpremnicaStampa();
        this.tekuciRN = new TekuciRN();
        this.vozacDb = new VozacService(this.emf);
        this.kupacDb = new KupacService(this.emf);
        this.gradilisteDb = new GradilisteService(this.emf);
        this.voziloDb = new VoziloService(this.emf);
        this.markaBetonaDb = new MarkaBetonaService(this.emf);
        this.radniNalogDb = new RadniNalogService(this.emf, this.tekuciRN);
        this.otpremaDb = new OtpremaService(this.emf, tekuciRN);
        this.sarzaDb = new SarzaService(this.emf);
        this.sifreDb = new SifreService(this.emf);
        this.stanjeZalihaDb = new StanjeZalihaService(this.emf);
        this.rucniRadDb = new RucniRadService(this.emf);
        this.zbirniParametriDb = new ZbirniParametriService(this.emf, this.es);
        this.preletiDb = new PreletiService(this.emf, this.es);
        
        
        this.vozacFrame = new VozacFrame(vozacDb);
        this.kupacFrame = new KupacFrame(kupacDb);
        this.gradilisteFrame = new GradilisteFrame(gradilisteDb);
        this.voziloFrame = new VoziloFrame(voziloDb);
        this.markaBetonaFrame = new MarkaBetonaFrame(markaBetonaDb);
        this.novaOtpremaFrame = new NovaOtpremaFrame(otpremaDb, vozacDb, voziloDb, markaBetonaDb, radniNalogDb,
                                                    voziloFrame, vozacFrame, pogon, brSarzi, tekuciRN);
        this.pregledIzvestajaFrame = new PregledIzvestajaFrame(sarzaDb);
        this.pregledSarziZaOtpremuFrame = new PregledSarziZaOtpremuFrame(sarzaDb, radniNalogDb, otpremaDb, markaBetonaDb, otpremnicaStampa);
        this.pregledRadnogNalogaPoOtpremamaFrame = new PregledOtpremaZaRadniNalogFrame(otpremaDb, radniNalogDb, pregledSarziZaOtpremuFrame);
        this.aktivniRadniNaloziFrame = new AktivniRadniNaloziFrame(radniNalogDb, novaOtpremaFrame, tekuciRN, pregledRadnogNalogaPoOtpremamaFrame);
        this.noviRadniNalogFrame = new NoviRadniNalogFrame(radniNalogDb, kupacDb, 
                gradilisteDb, markaBetonaDb, kupacFrame, gradilisteFrame, novaOtpremaFrame, tekuciRN);
        this.pregledRadnihNalogaFrame = new PregledRadnihNalogaFrame(radniNalogDb, pregledRadnogNalogaPoOtpremamaFrame, pregledIzvestajaFrame);
        this.sifreFrame = new SifreFrame(sifreDb);
        this.zbirniParametriFrame = new ZbirniParametriFrame(zbirniParametriDb, this.pogon);
        this.preletnaMasaFrame = new PreletnaMasaFrame(this.preletiDb, this.pogon);
        this.stanjeZalihaFrame = new StanjeZalihaFrame(this.stanjeZalihaDb, this.pogon);
        
        this.rucniRad = new RucniRad();
        this.rucniRadOtprema = new RucniRadOtprema();
    }
    
   
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        try {
            //here you can put the selected theme class name in JTattoo
            Properties p = new Properties();
            p.put("windowTitleFont", "Ebrima PLAIN 15");
            p.put("logoString", "");
            p.put("windowDecoration", "off");
            AluminiumLookAndFeel.setCurrentTheme(p);
            ///UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
      
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                NetVisionNew nw = new NetVisionNew();
                
                
                MainForm mainJFrame = new MainForm(nw.pogon, nw.emf, 
                        nw.markaBetonaDb,
                        nw.radniNalogDb, nw.otpremaDb, nw.sarzaDb, nw.novaOtpremaFrame, nw.brSarzi, nw.tekuciRN,
                        nw.aktivniRadniNaloziFrame,
                        nw.zbirniParametriFrame,
                        nw.preletnaMasaFrame,
                        nw.stanjeZalihaFrame,
                        nw.otpremnicaStampa, nw.rucniRad, nw.sifreDb, nw.sifreFrame, nw.stanjeZalihaDb,
                        nw.rucniRadDb,
                        nw.zbirniParametriDb,
                        nw.preletiDb,
                        nw.rucniRadOtprema);
                MainForm.showOnScreen(1,mainJFrame);
                mainJFrame.setVisible(true);
                
                DataForm dataJFrame = new DataForm(nw.emf, nw.vozacFrame, nw.kupacFrame, 
                        nw.gradilisteFrame, nw.voziloFrame, nw.markaBetonaFrame, nw.aktivniRadniNaloziFrame, 
                        nw.noviRadniNalogFrame, nw.pregledRadnihNalogaFrame, nw.rucniRadDb);
                DataForm.showOnScreen(2,dataJFrame);
                dataJFrame.setVisible(true);
                
            }

            
        });
    }

}
