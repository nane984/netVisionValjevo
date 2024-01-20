/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netvisionNew.form;

import com.Buff;
import constatnt.Image;
import dbService.MarkaBetonaService;
import dbService.OtpremaService;
import dbService.PreletiService;
import dbService.RadniNalogService;
import dbService.SarzaService;
import dbService.StanjeZalihaService;
import dbService.ZbirniParametriService;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManagerFactory;
import javax.swing.JFrame;
import javax.swing.Timer;
import pogon.Pogon;
import pogon.part.Komanda;
import popup.KomandniProzor;
import popup.KomandniProzorTip2;
import betonMesalica.BrSarzi;
import betonMesalica.TekuciRN;
import com.Mxl;
import dbService.RucniRadService;
import dbService.SifreService;
import eu.hansolo.steelseries.tools.LcdColor;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import netvisionNew.win.AktivniRadniNaloziFrame;
import netvisionNew.win.NovaOtpremaFrame;
import netvisionNew.win.PreletnaMasaFrame;
import netvisionNew.win.SifreFrame;
import netvisionNew.win.StanjeZalihaFrame;
import netvisionNew.win.ZbirniParametriFrame;
import popup.KomandniProzorTip3;
import print.OtpremnicaStampa;
import rucniRad.RucniRad;
import rucniRad.RucniRadElement;
import rucniRad.RucniRadOtprema;
import utils.Convert;
import utils.MousePoint;

/**
 *
 * @author branko.scekic
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     *
     * @param pogon
     * @param emf
     * @param markaBetonaDb
     * @param radniNalogDb
     * @param otpremaDb
     * @param sarzaDb
     * @param novaOtpremaFrame
     * @param brSarzi
     * @param tekuciRN
     * @param aktivniRadniNaloziFrame
     * @param zbirniParametriFrame
     * @param preletnaMasaFrame
     * @param stanjeZalihaFrame
     * @param otpremnicaStampa
     * @param rucniRad
     * @param sifreDb
     * @param sifreFrame
     * @param stanjeZalihaDb
     * @param rucniRadDb
     * @param zbirniParametriDb
     * @param preletiDb
     * @param rucniRadOtprema
     */
    public MainForm(Pogon pogon, EntityManagerFactory emf,
            MarkaBetonaService markaBetonaDb,
            RadniNalogService radniNalogDb, OtpremaService otpremaDb, SarzaService sarzaDb, NovaOtpremaFrame novaOtpremaFrame, BrSarzi brSarzi,
            TekuciRN tekuciRN,
            AktivniRadniNaloziFrame aktivniRadniNaloziFrame,
            ZbirniParametriFrame zbirniParametriFrame,
            PreletnaMasaFrame preletnaMasaFrame,
            StanjeZalihaFrame stanjeZalihaFrame,
            OtpremnicaStampa otpremnicaStampa, RucniRad rucniRad,
            SifreService sifreDb, SifreFrame sifreFrame, StanjeZalihaService stanjeZalihaDb,
            RucniRadService rucniRadDb,
            ZbirniParametriService zbirniParametriDb,
            PreletiService preletiDb,
            RucniRadOtprema rucniRadOtprema) {
        initComponents();

        URL iconURL = getClass().getResource("/img/logo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.pogon = pogon;
        img = new Image();
        this.emf = emf;
        this.tekuciRN = tekuciRN;

        //db service
        this.markaBetonaDb = markaBetonaDb;
        this.radniNalogDb = radniNalogDb;
        this.otpremaDb = otpremaDb;
        this.sarzaDb = sarzaDb;
        this.sifreDb = sifreDb;
        this.stanjeZalihaDb = stanjeZalihaDb;
        this.rucniRadDb = rucniRadDb;
        this.rucniRadOtprema = rucniRadOtprema;

        this.preletiDb = preletiDb;
        this.zbirniParametriDb = zbirniParametriDb;

        //comm
        //this.ipAdresa = "DESKTOP-C24H7CE";  //kuca
        //this.mw = 0;
        //this.mx = 0;
        this.ipAdresa = "192.168.0.159"; //valjevo
        this.mw = 4000;
        this.mx = 3200;
        mb = new Buff(pogon);
        mb.setIpAdresa(this.ipAdresa, mw, mx);

        this.rucniRad = rucniRad;

        this.brSarzi = brSarzi;
        this.otpremnicaStampa = otpremnicaStampa;

        //frame
        this.novaOtpremaFrame = novaOtpremaFrame;
        this.aktivniRadniNaloziFrame = aktivniRadniNaloziFrame;
        this.sifreFrame = sifreFrame;

        this.stanjeZalihaFrame = stanjeZalihaFrame;
        this.preletnaMasaFrame = preletnaMasaFrame;
        this.zbirniParametriFrame = zbirniParametriFrame;

        

        this.preletiDb.setParameters(preletnaMasaFrame.getAOPreletnaMasaFrakcija0_4(),
                preletnaMasaFrame.getAOPreletnaMasaFrakcija4_8(), preletnaMasaFrame.getAOPreletnaMasaFrakcija8_16(),
                preletnaMasaFrame.getAOPreletnaMasaFrakcija16_32(), preletnaMasaFrame.getAOPreletnaMasaCement(),
                preletnaMasaFrame.getAOPreletnaMasaFiler(), preletnaMasaFrame.getAOPreletnaMasaAditiv1(),
                preletnaMasaFrame.getAOPreletnaMasaAditiv2(), preletnaMasaFrame.getAOPreletnaMasaVoda());

        this.zbirniParametriDb.setParametersZbirniParametriService(zbirniParametriFrame.getAOParametriVremeSmirivanjaVageFrakcije(),
                zbirniParametriFrame.getAOParametriVremePraznjenjaVageFrakcije(), zbirniParametriFrame.getAOParametriVremePraznjenjaKoseTrake(),
                zbirniParametriFrame.getAOParametriKontrolnoVremeKoseTrake(), zbirniParametriFrame.getAOParametriZadrskaNaDoziranjeVode(),
                zbirniParametriFrame.getAOParametriZadrskaNaDoziranjeCementa(), zbirniParametriFrame.getAOParametriVremeMesanjaMaterijala(),
                zbirniParametriFrame.getAOParametriPocetnoOtvaranjeMesalice(), zbirniParametriFrame.getAOParametriVremePocetnogPraznjenjaMesalice(),
                zbirniParametriFrame.getAOParametriVremeKonacnogPraznjenjaMesalice(), zbirniParametriFrame.getAOParametriVremeIspiranjaVageAditiva(),
                zbirniParametriFrame.getAOParametriPauzaFluidizacije(), zbirniParametriFrame.getAOParametriRadFluidizacije(),
                zbirniParametriFrame.getAOParametriKapacitetMesalice(), zbirniParametriFrame.getAOParametriZadrskaNaStartKoseTrake(),
                zbirniParametriFrame.getAOParametriVremeSmirivanjaVageAditiva(), zbirniParametriFrame.getAOParametriVremeSmirivanjaVageCementa());

        //inicijalizacija
        vodaPlusMinus.setText("");

        new Thread(mb).start();
        mb.writeMX(false, pogon.getOstalo().getSarzaZavrsenaAdresa());
        //this.novaOtpremaFrame.setMb(mb);

        rucniRad.setInicializacija(this.pogon);
        screenRefresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        DOAgregat0_4 = new javax.swing.JLabel();
        DOAgregat4_8 = new javax.swing.JLabel();
        DOAgregat8_16 = new javax.swing.JLabel();
        DOAgregat16_32 = new javax.swing.JLabel();
        DOCement1 = new javax.swing.JLabel();
        DOCement2 = new javax.swing.JLabel();
        DOVoda = new javax.swing.JLabel();
        DOAditiv1 = new javax.swing.JLabel();
        DOAditiv2 = new javax.swing.JLabel();
        DOTraka2 = new javax.swing.JLabel();
        DOTrakaHorizontalnoA = new javax.swing.JLabel();
        DOTrakaHorizontalnoB = new javax.swing.JLabel();
        DOTrakaKosoA = new javax.swing.JLabel();
        DOTrakaKosoB = new javax.swing.JLabel();
        DOCementVaga = new javax.swing.JLabel();
        DOVagaVoda = new javax.swing.JLabel();
        DOVagaAditiv = new javax.swing.JLabel();
        DORucnuAutomatski = new javax.swing.JLabel();
        DOMesalicaMixer = new javax.swing.JLabel();
        DOMesalicaOtvori = new javax.swing.JLabel();
        DOMesalicaZatvori = new javax.swing.JLabel();
        DOHidropumpaUkljuci = new eu.hansolo.steelseries.extras.Led();
        DOMesalicuUkljuci = new eu.hansolo.steelseries.extras.Led();
        opisAgregat0_4 = new javax.swing.JLabel();
        opisAgregat4_8 = new javax.swing.JLabel();
        opisAgregat8_16 = new javax.swing.JLabel();
        opisAgregat16_32 = new javax.swing.JLabel();
        opisCement1 = new javax.swing.JLabel();
        opisCement2 = new javax.swing.JLabel();
        opisVoda = new javax.swing.JLabel();
        opisAditiv1 = new javax.swing.JLabel();
        opisAditiv2 = new javax.swing.JLabel();
        opisZadato = new javax.swing.JLabel();
        opisIzdato = new javax.swing.JLabel();
        opisHeader0_4 = new javax.swing.JLabel();
        opisHeader4_8 = new javax.swing.JLabel();
        opisHeader8_16 = new javax.swing.JLabel();
        opisHeader16_32 = new javax.swing.JLabel();
        opisHeaderCement1 = new javax.swing.JLabel();
        opisHeaderFiler = new javax.swing.JLabel();
        opisHeaderAditiv1 = new javax.swing.JLabel();
        opisHeaderAditiv2 = new javax.swing.JLabel();
        opisHeaderVoda = new javax.swing.JLabel();
        opisVagaZatvorena = new javax.swing.JLabel();
        opisVagaOtvorena = new javax.swing.JLabel();
        MWheaderZadato0_4 = new javax.swing.JLabel();
        MWheaderZadato4_8 = new javax.swing.JLabel();
        MWheaderZadato8_16 = new javax.swing.JLabel();
        MWheaderZadato16_32 = new javax.swing.JLabel();
        MWheaderZadatoCement = new javax.swing.JLabel();
        MWheaderZadatoFiler = new javax.swing.JLabel();
        MWheaderZadatoAditiv1 = new javax.swing.JLabel();
        MWheaderZadatoAditiv2 = new javax.swing.JLabel();
        MWheaderZadatoVoda = new javax.swing.JLabel();
        MWheaderIzdato0_4 = new javax.swing.JLabel();
        MWheaderIzdato4_8 = new javax.swing.JLabel();
        MWheaderIzdato8_16 = new javax.swing.JLabel();
        MWheaderIzdato16_32 = new javax.swing.JLabel();
        MWheaderIzdatoCement = new javax.swing.JLabel();
        MWheaderIzdatoFiler = new javax.swing.JLabel();
        MWheaderIzdatoAditiv1 = new javax.swing.JLabel();
        MWheaderIzdatoAditiv2 = new javax.swing.JLabel();
        MWheaderIzdatoVoda = new javax.swing.JLabel();
        MWheaderZadatoBrSarzi = new javax.swing.JLabel();
        MWheaderIzdatoBrSarze = new javax.swing.JLabel();
        opisHeaderBrojSarzi = new javax.swing.JLabel();
        DOTraka1 = new javax.swing.JLabel();
        MWVlagaBetona = new eu.hansolo.steelseries.gauges.DisplayRectangular();
        MWStrujaMesalice = new eu.hansolo.steelseries.gauges.DisplayRectangular();
        MWTrakaAgregat = new eu.hansolo.steelseries.gauges.DisplayRectangular();
        MWCementVaga = new eu.hansolo.steelseries.gauges.DisplayRectangular();
        MWVodaVaga = new eu.hansolo.steelseries.gauges.DisplayRectangular();
        MWAditivVaga = new eu.hansolo.steelseries.gauges.DisplayRectangular();
        trafficLight21 = new eu.hansolo.steelseries.extras.TrafficLight2();
        OpisRucnoAutomatski = new javax.swing.JLabel();
        clock1 = new eu.hansolo.steelseries.extras.Clock();
        DIVagaMesalicaZatvorena = new eu.hansolo.steelseries.extras.Led();
        DIVagaMesalicaOtvorena = new eu.hansolo.steelseries.extras.Led();
        DIVagaCementZatvorena = new eu.hansolo.steelseries.extras.Led();
        DIVagaVodaZatvorena = new eu.hansolo.steelseries.extras.Led();
        DIVagaAditivZatvorena = new eu.hansolo.steelseries.extras.Led();
        DIVagaMesalicaPuna = new eu.hansolo.steelseries.extras.Led();
        DIVagaMesalicaPrazna = new eu.hansolo.steelseries.extras.Led();
        opisHidropumpa = new javax.swing.JLabel();
        lightBulbAlarm = new eu.hansolo.steelseries.extras.LightBulb();
        controlPanelOpisAlarm = new javax.swing.JLabel();
        opisMesalicaUkljucena = new javax.swing.JLabel();
        opisVagaCementZatvorena = new javax.swing.JLabel();
        opisVagaVodaZatvorena = new javax.swing.JLabel();
        opisVagaAditivZatvorena = new javax.swing.JLabel();
        MWVremeMesanja = new eu.hansolo.steelseries.gauges.DisplaySingle();
        MWVremePraznjenja = new eu.hansolo.steelseries.gauges.DisplaySingle();
        silos2Aditiv = new eu.hansolo.steelseries.gauges.Linear();
        silos1Aditiv = new eu.hansolo.steelseries.gauges.Linear();
        silos2Cement = new eu.hansolo.steelseries.gauges.Linear();
        fluidizacijaSilosa2 = new javax.swing.JLabel();
        silos1Cement = new eu.hansolo.steelseries.gauges.Linear();
        fluidizacijaSilosa1 = new javax.swing.JLabel();
        opisVagaOtvorena1 = new javax.swing.JLabel();
        opisVagaOtvorena2 = new javax.swing.JLabel();
        opisVagaMesalicaPuna = new javax.swing.JLabel();
        opisVagaMesalicaPrazna = new javax.swing.JLabel();
        IzdoziranoAgregati = new javax.swing.JLabel();
        IzdoziranoCement = new javax.swing.JLabel();
        IzdoziranoVoda = new javax.swing.JLabel();
        IzdoziranoAditiv = new javax.swing.JLabel();
        silosAgregat1632 = new eu.hansolo.steelseries.gauges.Linear();
        silosAgregat04 = new eu.hansolo.steelseries.gauges.Linear();
        silosAgregat816 = new eu.hansolo.steelseries.gauges.Linear();
        silosAgregat48 = new eu.hansolo.steelseries.gauges.Linear();
        mesalicuZatvori = new eu.hansolo.steelseries.extras.Led();
        mesalicuOtvori = new eu.hansolo.steelseries.extras.Led();
        vibratorVagaCementa = new javax.swing.JLabel();
        vibratorTrake = new javax.swing.JLabel();
        SelectedSilos1 = new javax.swing.JRadioButton();
        SelectedSilos2 = new javax.swing.JRadioButton();
        DOVodaIspiranjeVageAditiva = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        opisHidropumpa1 = new javax.swing.JLabel();
        opisVlaga = new javax.swing.JLabel();
        DOMesalicaZatvori1 = new javax.swing.JLabel();
        opisVlaga1 = new javax.swing.JLabel();
        otpremaZavrsena = new javax.swing.JLabel();
        vibratorFrakcija1 = new javax.swing.JLabel();
        kosaTrakaJePrazna = new javax.swing.JLabel();
        vodaPlus = new javax.swing.JButton();
        vodaMinus = new javax.swing.JButton();
        vodaPlusMinus = new javax.swing.JLabel();
        opisIzdato1 = new javax.swing.JLabel();
        MWheaderIzdato0_4Ukupno = new javax.swing.JLabel();
        MWheaderIzdato4_8Ukupno = new javax.swing.JLabel();
        MWheaderIzdato8_16Ukupno = new javax.swing.JLabel();
        MWheaderIzdato16_32Ukupno = new javax.swing.JLabel();
        MWheaderIzdatoCementUkupno = new javax.swing.JLabel();
        MWheaderIzdatoFilerUkupno = new javax.swing.JLabel();
        MWheaderIzdatoAditiv1Ukupno = new javax.swing.JLabel();
        MWheaderIzdatoAditiv2Ukupno = new javax.swing.JLabel();
        MWheaderIzdatoVodaUkupno = new javax.swing.JLabel();
        blokadaOtvaranjaMesalice = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        priremenoZadataKolicinaF1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        priremenoZadataKolicinaF1F2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        priremenoZadataKolicinaF1F2F3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        priremenoZadataKolicinaF1F2F3F4 = new javax.swing.JLabel();
        MWheaderIzdatoUkupno = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jCheckBoxAktivnaKorekcijaPoVlagi = new javax.swing.JCheckBox();
        korigovanoF1 = new eu.hansolo.steelseries.gauges.DisplayRectangular();
        korigovanoF2 = new eu.hansolo.steelseries.gauges.DisplayRectangular();
        korigovanaVoda = new eu.hansolo.steelseries.gauges.DisplayRectangular();
        korigovanoF4 = new eu.hansolo.steelseries.gauges.DisplayRectangular();
        jLabel21 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tekuciBrojRN = new javax.swing.JLabel();
        tekucaMarkaBetona = new javax.swing.JLabel();
        tekuciKupac = new javax.swing.JLabel();
        tekuceGradiliste = new javax.swing.JLabel();
        tekuceUgovoreno = new javax.swing.JLabel();
        tekuceIsporuceno = new javax.swing.JLabel();
        tekucePreostalo = new javax.swing.JLabel();
        shorcutAktivniRadniNaloti = new javax.swing.JButton();
        jButtonOtkaziRN = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        zadrziPodatke = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tekuceTablicaVozila = new javax.swing.JLabel();
        tekuceVozac = new javax.swing.JLabel();
        tekuceZadato = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        tekuceTrenutno = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jButtonOtkaziOtpremu = new javax.swing.JButton();
        jButtonNovaOtprema = new javax.swing.JButton();
        jButtonStartCiklus = new javax.swing.JButton();
        jButtonStopCiklusa = new javax.swing.JButton();
        controlPanel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemZbirniParametri = new javax.swing.JMenuItem();
        jMenuItemPreleti = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemStanjeZaliha = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemTestUpisFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NetVision");
        setResizable(false);

        jPanel1.setLayout(null);

        DOAgregat0_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOAgregat0_4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Forbidden.png"))); // NOI18N
        DOAgregat0_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOAgregat0_4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOAgregat0_4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOAgregat0_4MouseReleased(evt);
            }
        });
        jPanel1.add(DOAgregat0_4);
        DOAgregat0_4.setBounds(240, 530, 30, 40);

        DOAgregat4_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOAgregat4_8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Forbidden.png"))); // NOI18N
        DOAgregat4_8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOAgregat4_8MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOAgregat4_8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOAgregat4_8MouseReleased(evt);
            }
        });
        jPanel1.add(DOAgregat4_8);
        DOAgregat4_8.setBounds(320, 530, 40, 40);

        DOAgregat8_16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOAgregat8_16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Forbidden.png"))); // NOI18N
        DOAgregat8_16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOAgregat8_16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOAgregat8_16MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOAgregat8_16MouseReleased(evt);
            }
        });
        jPanel1.add(DOAgregat8_16);
        DOAgregat8_16.setBounds(150, 530, 40, 40);

        DOAgregat16_32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOAgregat16_32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Forbidden.png"))); // NOI18N
        DOAgregat16_32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOAgregat16_32MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOAgregat16_32MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOAgregat16_32MouseReleased(evt);
            }
        });
        jPanel1.add(DOAgregat16_32);
        DOAgregat16_32.setBounds(60, 530, 40, 40);

        DOCement1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOCement1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/puzniGif.gif"))); // NOI18N
        DOCement1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOCement1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOCement1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOCement1MouseReleased(evt);
            }
        });
        jPanel1.add(DOCement1);
        DOCement1.setBounds(660, 450, 60, 60);

        DOCement2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOCement2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/puzniOff.gif"))); // NOI18N
        DOCement2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOCement2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOCement2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOCement2MouseReleased(evt);
            }
        });
        jPanel1.add(DOCement2);
        DOCement2.setBounds(774, 450, 70, 60);

        DOVoda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOVoda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Forbidden.png"))); // NOI18N
        DOVoda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOVodaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOVodaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOVodaMouseReleased(evt);
            }
        });
        jPanel1.add(DOVoda);
        DOVoda.setBounds(940, 460, 50, 40);

        DOAditiv1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOAditiv1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/pumpaGif.gif"))); // NOI18N
        DOAditiv1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOAditiv1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOAditiv1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOAditiv1MouseReleased(evt);
            }
        });
        jPanel1.add(DOAditiv1);
        DOAditiv1.setBounds(1086, 450, 60, 60);

        DOAditiv2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOAditiv2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/pumpaOff.gif"))); // NOI18N
        DOAditiv2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DOAditiv2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOAditiv2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOAditiv2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOAditiv2MouseReleased(evt);
            }
        });
        jPanel1.add(DOAditiv2);
        DOAditiv2.setBounds(1210, 450, 60, 60);

        DOTraka2.setBackground(new java.awt.Color(204, 255, 255));
        DOTraka2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DOTraka2MouseClicked(evt);
            }
        });
        jPanel1.add(DOTraka2);
        DOTraka2.setBounds(320, 640, 260, 60);

        DOTrakaHorizontalnoA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOTrakaHorizontalnoA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/ZubcOn.gif"))); // NOI18N
        jPanel1.add(DOTrakaHorizontalnoA);
        DOTrakaHorizontalnoA.setBounds(50, 580, 30, 30);

        DOTrakaHorizontalnoB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOTrakaHorizontalnoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/ZubcOn.gif"))); // NOI18N
        jPanel1.add(DOTrakaHorizontalnoB);
        DOTrakaHorizontalnoB.setBounds(350, 574, 40, 40);

        DOTrakaKosoA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOTrakaKosoA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/ZubcOff.png"))); // NOI18N
        jPanel1.add(DOTrakaKosoA);
        DOTrakaKosoA.setBounds(260, 700, 30, 30);

        DOTrakaKosoB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOTrakaKosoB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/ZubcOff.png"))); // NOI18N
        jPanel1.add(DOTrakaKosoB);
        DOTrakaKosoB.setBounds(560, 620, 30, 30);

        DOCementVaga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOCementVaga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Forbidden.png"))); // NOI18N
        DOCementVaga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOCementVagaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOCementVagaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOCementVagaMouseReleased(evt);
            }
        });
        jPanel1.add(DOCementVaga);
        DOCementVaga.setBounds(730, 650, 40, 30);

        DOVagaVoda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOVagaVoda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Forbidden.png"))); // NOI18N
        DOVagaVoda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOVagaVodaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOVagaVodaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOVagaVodaMouseReleased(evt);
            }
        });
        jPanel1.add(DOVagaVoda);
        DOVagaVoda.setBounds(950, 650, 40, 30);

        DOVagaAditiv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOVagaAditiv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Forbidden.png"))); // NOI18N
        DOVagaAditiv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOVagaAditivMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOVagaAditivMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOVagaAditivMouseReleased(evt);
            }
        });
        jPanel1.add(DOVagaAditiv);
        DOVagaAditiv.setBounds(1160, 650, 40, 30);

        DORucnuAutomatski.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/SelektorAutomatski.png"))); // NOI18N
        DORucnuAutomatski.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DORucnuAutomatski.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DORucnuAutomatskiMouseClicked(evt);
            }
        });
        jPanel1.add(DORucnuAutomatski);
        DORucnuAutomatski.setBounds(1440, 40, 115, 90);

        DOMesalicaMixer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/fan-gif.gif"))); // NOI18N
        DOMesalicaMixer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DOMesalicaMixerMouseClicked(evt);
            }
        });
        jPanel1.add(DOMesalicaMixer);
        DOMesalicaMixer.setBounds(820, 690, 190, 60);

        DOMesalicaOtvori.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOMesalicaOtvori.setText("Otvori mesalicu ");
        DOMesalicaOtvori.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        DOMesalicaOtvori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DOMesalicaOtvoriMouseClicked(evt);
            }
        });
        jPanel1.add(DOMesalicaOtvori);
        DOMesalicaOtvori.setBounds(640, 770, 140, 20);

        DOMesalicaZatvori.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOMesalicaZatvori.setText("Zatvori mesalicu");
        DOMesalicaZatvori.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        DOMesalicaZatvori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DOMesalicaZatvoriMouseClicked(evt);
            }
        });
        jPanel1.add(DOMesalicaZatvori);
        DOMesalicaZatvori.setBounds(1040, 770, 130, 20);

        DOHidropumpaUkljuci.setLedColor(eu.hansolo.steelseries.tools.LedColor.GREEN_LED);
        DOHidropumpaUkljuci.setLedOn(true);
        DOHidropumpaUkljuci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DOHidropumpaUkljuciMouseClicked(evt);
            }
        });
        jPanel1.add(DOHidropumpaUkljuci);
        DOHidropumpaUkljuci.setBounds(220, 220, 60, 60);

        DOMesalicuUkljuci.setLedColor(eu.hansolo.steelseries.tools.LedColor.GREEN_LED);
        DOMesalicuUkljuci.setLedOn(true);
        DOMesalicuUkljuci.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DOMesalicuUkljuciMouseClicked(evt);
            }
        });
        jPanel1.add(DOMesalicuUkljuci);
        DOMesalicuUkljuci.setBounds(220, 280, 60, 60);

        opisAgregat0_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opisAgregat0_4.setText("0-4mm");
        jPanel1.add(opisAgregat0_4);
        opisAgregat0_4.setBounds(240, 390, 50, 14);

        opisAgregat4_8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opisAgregat4_8.setText("4-8mm");
        jPanel1.add(opisAgregat4_8);
        opisAgregat4_8.setBounds(320, 390, 60, 14);

        opisAgregat8_16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opisAgregat8_16.setText("8-16mm");
        jPanel1.add(opisAgregat8_16);
        opisAgregat8_16.setBounds(150, 390, 50, 14);

        opisAgregat16_32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opisAgregat16_32.setText("16-32mm");
        jPanel1.add(opisAgregat16_32);
        opisAgregat16_32.setBounds(50, 390, 70, 14);

        opisCement1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opisCement1.setText("Cement 1");
        jPanel1.add(opisCement1);
        opisCement1.setBounds(640, 200, 80, 20);

        opisCement2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opisCement2.setText("Cement 2");
        jPanel1.add(opisCement2);
        opisCement2.setBounds(760, 200, 80, 20);

        opisVoda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opisVoda.setText("Voda");
        jPanel1.add(opisVoda);
        opisVoda.setBounds(920, 200, 100, 20);

        opisAditiv1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opisAditiv1.setText("Aditiv 1");
        jPanel1.add(opisAditiv1);
        opisAditiv1.setBounds(1070, 200, 100, 20);

        opisAditiv2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        opisAditiv2.setText("Aditiv 2");
        jPanel1.add(opisAditiv2);
        opisAditiv2.setBounds(1190, 200, 100, 20);

        opisZadato.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisZadato.setForeground(new java.awt.Color(102, 102, 102));
        opisZadato.setText("Zadato");
        jPanel1.add(opisZadato);
        opisZadato.setBounds(50, 60, 60, 19);

        opisIzdato.setText("Izdato");
        opisIzdato.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisIzdato.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisIzdato);
        opisIzdato.setBounds(50, 90, 60, 19);

        opisHeader0_4.setText("0-4 mm");
        opisHeader0_4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisHeader0_4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisHeader0_4);
        opisHeader0_4.setBounds(140, 30, 60, 19);

        opisHeader4_8.setText("4-8 mm");
        opisHeader4_8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisHeader4_8.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisHeader4_8);
        opisHeader4_8.setBounds(220, 30, 60, 19);

        opisHeader8_16.setText("8-16 mm");
        opisHeader8_16.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisHeader8_16.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisHeader8_16);
        opisHeader8_16.setBounds(300, 30, 60, 19);

        opisHeader16_32.setText("16-32 mm");
        opisHeader16_32.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisHeader16_32.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisHeader16_32);
        opisHeader16_32.setBounds(380, 30, 70, 19);

        opisHeaderCement1.setText("Cement");
        opisHeaderCement1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisHeaderCement1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisHeaderCement1);
        opisHeaderCement1.setBounds(560, 30, 70, 19);

        opisHeaderFiler.setText("Filer");
        opisHeaderFiler.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisHeaderFiler.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisHeaderFiler);
        opisHeaderFiler.setBounds(720, 30, 70, 19);

        opisHeaderAditiv1.setText("A1");
        opisHeaderAditiv1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisHeaderAditiv1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisHeaderAditiv1);
        opisHeaderAditiv1.setBounds(900, 30, 70, 19);

        opisHeaderAditiv2.setText("A2");
        opisHeaderAditiv2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisHeaderAditiv2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisHeaderAditiv2);
        opisHeaderAditiv2.setBounds(970, 30, 70, 19);

        opisHeaderVoda.setText("Voda");
        opisHeaderVoda.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisHeaderVoda.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisHeaderVoda);
        opisHeaderVoda.setBounds(1080, 30, 70, 19);

        opisVagaZatvorena.setText("Zatvorena mešalica: ");
        opisVagaZatvorena.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisVagaZatvorena.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisVagaZatvorena);
        opisVagaZatvorena.setBounds(290, 760, 160, 19);

        opisVagaOtvorena.setText("Otvorena mešalica: ");
        opisVagaOtvorena.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisVagaOtvorena.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisVagaOtvorena);
        opisVagaOtvorena.setBounds(290, 800, 150, 19);

        MWheaderZadato0_4.setText("0");
        MWheaderZadato0_4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderZadato0_4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderZadato0_4);
        MWheaderZadato0_4.setBounds(140, 60, 60, 19);

        MWheaderZadato4_8.setText("0");
        MWheaderZadato4_8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderZadato4_8.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderZadato4_8);
        MWheaderZadato4_8.setBounds(220, 60, 60, 19);

        MWheaderZadato8_16.setText("0");
        MWheaderZadato8_16.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderZadato8_16.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderZadato8_16);
        MWheaderZadato8_16.setBounds(300, 60, 60, 19);

        MWheaderZadato16_32.setText("0");
        MWheaderZadato16_32.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderZadato16_32.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderZadato16_32);
        MWheaderZadato16_32.setBounds(380, 60, 60, 19);

        MWheaderZadatoCement.setText("0");
        MWheaderZadatoCement.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderZadatoCement.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderZadatoCement);
        MWheaderZadatoCement.setBounds(560, 60, 60, 19);

        MWheaderZadatoFiler.setText("0");
        MWheaderZadatoFiler.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderZadatoFiler.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderZadatoFiler);
        MWheaderZadatoFiler.setBounds(720, 60, 60, 19);

        MWheaderZadatoAditiv1.setText("0");
        MWheaderZadatoAditiv1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderZadatoAditiv1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderZadatoAditiv1);
        MWheaderZadatoAditiv1.setBounds(900, 60, 60, 19);

        MWheaderZadatoAditiv2.setText("0");
        MWheaderZadatoAditiv2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderZadatoAditiv2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderZadatoAditiv2);
        MWheaderZadatoAditiv2.setBounds(970, 60, 60, 19);

        MWheaderZadatoVoda.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderZadatoVoda.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderZadatoVoda.setText("0");
        jPanel1.add(MWheaderZadatoVoda);
        MWheaderZadatoVoda.setBounds(1090, 60, 60, 19);

        MWheaderIzdato0_4.setText("0");
        MWheaderIzdato0_4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdato0_4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderIzdato0_4);
        MWheaderIzdato0_4.setBounds(140, 90, 60, 19);

        MWheaderIzdato4_8.setText("0");
        MWheaderIzdato4_8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdato4_8.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderIzdato4_8);
        MWheaderIzdato4_8.setBounds(220, 90, 60, 19);

        MWheaderIzdato8_16.setText("0");
        MWheaderIzdato8_16.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdato8_16.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderIzdato8_16);
        MWheaderIzdato8_16.setBounds(300, 90, 60, 19);

        MWheaderIzdato16_32.setText("0");
        MWheaderIzdato16_32.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdato16_32.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderIzdato16_32);
        MWheaderIzdato16_32.setBounds(380, 90, 60, 19);

        MWheaderIzdatoCement.setText("0");
        MWheaderIzdatoCement.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdatoCement.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderIzdatoCement);
        MWheaderIzdatoCement.setBounds(560, 90, 60, 19);

        MWheaderIzdatoFiler.setText("0");
        MWheaderIzdatoFiler.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdatoFiler.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderIzdatoFiler);
        MWheaderIzdatoFiler.setBounds(720, 90, 60, 19);

        MWheaderIzdatoAditiv1.setText("0");
        MWheaderIzdatoAditiv1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdatoAditiv1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderIzdatoAditiv1);
        MWheaderIzdatoAditiv1.setBounds(900, 90, 60, 19);

        MWheaderIzdatoAditiv2.setText("0");
        MWheaderIzdatoAditiv2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdatoAditiv2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderIzdatoAditiv2);
        MWheaderIzdatoAditiv2.setBounds(970, 90, 60, 19);

        MWheaderIzdatoVoda.setText("0");
        MWheaderIzdatoVoda.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdatoVoda.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(MWheaderIzdatoVoda);
        MWheaderIzdatoVoda.setBounds(1090, 90, 60, 19);

        MWheaderZadatoBrSarzi.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderZadatoBrSarzi.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderZadatoBrSarzi.setText("0");
        jPanel1.add(MWheaderZadatoBrSarzi);
        MWheaderZadatoBrSarzi.setBounds(1230, 60, 60, 19);

        MWheaderIzdatoBrSarze.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdatoBrSarze.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderIzdatoBrSarze.setText("0");
        jPanel1.add(MWheaderIzdatoBrSarze);
        MWheaderIzdatoBrSarze.setBounds(1230, 90, 60, 19);

        opisHeaderBrojSarzi.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisHeaderBrojSarzi.setForeground(new java.awt.Color(102, 102, 102));
        opisHeaderBrojSarzi.setText("Br. šarži");
        jPanel1.add(opisHeaderBrojSarzi);
        opisHeaderBrojSarzi.setBounds(1220, 30, 70, 19);

        DOTraka1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DOTraka1MouseClicked(evt);
            }
        });
        jPanel1.add(DOTraka1);
        DOTraka1.setBounds(50, 570, 340, 40);

        MWVlagaBetona.setFrameVisible(false);
        MWVlagaBetona.setLcdDecimals(1);
        MWVlagaBetona.setTitle("");
        MWVlagaBetona.setUnitString("%");
        MWVlagaBetona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MWVlagaBetonaMouseClicked(evt);
            }
        });
        jPanel1.add(MWVlagaBetona);
        MWVlagaBetona.setBounds(300, 340, 70, 40);

        MWStrujaMesalice.setFrameVisible(false);
        MWStrujaMesalice.setLcdDecimals(1);
        MWStrujaMesalice.setUnitString("A");
        MWStrujaMesalice.setUserLedVisible(true);
        MWStrujaMesalice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MWStrujaMesaliceMouseClicked(evt);
            }
        });
        jPanel1.add(MWStrujaMesalice);
        MWStrujaMesalice.setBounds(880, 790, 120, 40);

        MWTrakaAgregat.setFrameVisible(false);
        MWTrakaAgregat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MWTrakaAgregatMouseClicked(evt);
            }
        });
        jPanel1.add(MWTrakaAgregat);
        MWTrakaAgregat.setBounds(140, 620, 120, 40);

        MWCementVaga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MWCementVagaMouseClicked(evt);
            }
        });
        jPanel1.add(MWCementVaga);
        MWCementVaga.setBounds(670, 580, 170, 70);

        MWVodaVaga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MWVodaVagaMouseClicked(evt);
            }
        });
        jPanel1.add(MWVodaVaga);
        MWVodaVaga.setBounds(900, 580, 130, 70);

        MWAditivVaga.setLcdDecimals(2);
        MWAditivVaga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MWAditivVagaMouseClicked(evt);
            }
        });
        jPanel1.add(MWAditivVaga);
        MWAditivVaga.setBounds(1090, 580, 180, 70);

        trafficLight21.setBlinking(true);
        trafficLight21.setYellowVisible(false);
        jPanel1.add(trafficLight21);
        trafficLight21.setBounds(1110, 860, 110, 150);

        OpisRucnoAutomatski.setText("Ručno         Automatski");
        jPanel1.add(OpisRucnoAutomatski);
        OpisRucnoAutomatski.setBounds(1440, 20, 130, 14);

        clock1.setAutomatic(true);
        clock1.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.BLUE);
        clock1.setForegroundType(eu.hansolo.steelseries.tools.ForegroundType.FG_TYPE5);
        clock1.setForegroundVisible(false);
        jPanel1.add(clock1);
        clock1.setBounds(1780, 10, 130, 130);

        DIVagaMesalicaZatvorena.setCustomLedColor(new java.awt.Color(0, 204, 0));
        DIVagaMesalicaZatvorena.setLedColor(eu.hansolo.steelseries.tools.LedColor.ORANGE_LED);
        DIVagaMesalicaZatvorena.setLedOn(true);
        jPanel1.add(DIVagaMesalicaZatvorena);
        DIVagaMesalicaZatvorena.setBounds(450, 750, 40, 40);

        DIVagaMesalicaOtvorena.setCustomLedColor(new java.awt.Color(0, 255, 102));
        DIVagaMesalicaOtvorena.setLedColor(eu.hansolo.steelseries.tools.LedColor.ORANGE_LED);
        jPanel1.add(DIVagaMesalicaOtvorena);
        DIVagaMesalicaOtvorena.setBounds(450, 790, 40, 40);

        DIVagaCementZatvorena.setCustomLedColor(new java.awt.Color(0, 204, 0));
        DIVagaCementZatvorena.setLedColor(eu.hansolo.steelseries.tools.LedColor.ORANGE_LED);
        DIVagaCementZatvorena.setLedOn(true);
        jPanel1.add(DIVagaCementZatvorena);
        DIVagaCementZatvorena.setBounds(830, 550, 40, 40);

        DIVagaVodaZatvorena.setCustomLedColor(new java.awt.Color(0, 204, 0));
        DIVagaVodaZatvorena.setLedColor(eu.hansolo.steelseries.tools.LedColor.ORANGE_LED);
        DIVagaVodaZatvorena.setLedOn(true);
        jPanel1.add(DIVagaVodaZatvorena);
        DIVagaVodaZatvorena.setBounds(1020, 550, 40, 40);

        DIVagaAditivZatvorena.setCustomLedColor(new java.awt.Color(0, 204, 0));
        DIVagaAditivZatvorena.setLedColor(eu.hansolo.steelseries.tools.LedColor.ORANGE_LED);
        DIVagaAditivZatvorena.setLedOn(true);
        jPanel1.add(DIVagaAditivZatvorena);
        DIVagaAditivZatvorena.setBounds(1260, 550, 40, 40);

        DIVagaMesalicaPuna.setCustomLedColor(new java.awt.Color(0, 204, 0));
        jPanel1.add(DIVagaMesalicaPuna);
        DIVagaMesalicaPuna.setBounds(450, 840, 40, 40);

        DIVagaMesalicaPrazna.setCustomLedColor(new java.awt.Color(0, 204, 0));
        DIVagaMesalicaPrazna.setLedOn(true);
        jPanel1.add(DIVagaMesalicaPrazna);
        DIVagaMesalicaPrazna.setBounds(450, 880, 40, 40);

        opisHidropumpa.setText("Hidropumpa uključena: ");
        opisHidropumpa.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisHidropumpa.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisHidropumpa);
        opisHidropumpa.setBounds(30, 240, 180, 19);

        lightBulbAlarm.setGlowColor(new java.awt.Color(255, 51, 51));
        jPanel1.add(lightBulbAlarm);
        lightBulbAlarm.setBounds(1610, 30, 100, 100);

        controlPanelOpisAlarm.setText("Alarm");
        jPanel1.add(controlPanelOpisAlarm);
        controlPanelOpisAlarm.setBounds(1638, 20, 50, 14);

        opisMesalicaUkljucena.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisMesalicaUkljucena.setForeground(new java.awt.Color(102, 102, 102));
        opisMesalicaUkljucena.setText("Mešalica uključena: ");
        jPanel1.add(opisMesalicaUkljucena);
        opisMesalicaUkljucena.setBounds(30, 300, 180, 19);

        opisVagaCementZatvorena.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisVagaCementZatvorena.setForeground(new java.awt.Color(102, 102, 102));
        opisVagaCementZatvorena.setText("Zatvorena vaga: ");
        jPanel1.add(opisVagaCementZatvorena);
        opisVagaCementZatvorena.setBounds(700, 560, 130, 19);

        opisVagaVodaZatvorena.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisVagaVodaZatvorena.setForeground(new java.awt.Color(102, 102, 102));
        opisVagaVodaZatvorena.setText("Zatvorena vaga: ");
        jPanel1.add(opisVagaVodaZatvorena);
        opisVagaVodaZatvorena.setBounds(900, 560, 130, 19);

        opisVagaAditivZatvorena.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisVagaAditivZatvorena.setForeground(new java.awt.Color(102, 102, 102));
        opisVagaAditivZatvorena.setText("Zatvorena vaga: ");
        jPanel1.add(opisVagaAditivZatvorena);
        opisVagaAditivZatvorena.setBounds(1130, 560, 130, 19);

        MWVremeMesanja.setLcdUnitString("sec");
        jPanel1.add(MWVremeMesanja);
        MWVremeMesanja.setBounds(510, 780, 100, 50);

        MWVremePraznjenja.setLcdUnitString("sec");
        jPanel1.add(MWVremePraznjenja);
        MWVremePraznjenja.setBounds(1190, 780, 100, 50);

        silos2Aditiv.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.TRANSPARENT);
        silos2Aditiv.setFrameDesign(eu.hansolo.steelseries.tools.FrameDesign.BLACK_METAL);
        silos2Aditiv.setFrameVisible(false);
        silos2Aditiv.setGlowing(true);
        silos2Aditiv.setLabelNumberFormat(eu.hansolo.steelseries.tools.NumberFormat.STANDARD);
        silos2Aditiv.setLcdUnitString("");
        silos2Aditiv.setLcdVisible(false);
        silos2Aditiv.setLedVisible(false);
        silos2Aditiv.setMinorTickmarkVisible(false);
        silos2Aditiv.setTitle("Silos br 1");
        silos2Aditiv.setTitleAndUnitFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        silos2Aditiv.setTitleVisible(false);
        silos2Aditiv.setUnitStringVisible(false);
        jPanel1.add(silos2Aditiv);
        silos2Aditiv.setBounds(1180, 230, 120, 200);

        silos1Aditiv.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.TRANSPARENT);
        silos1Aditiv.setFrameDesign(eu.hansolo.steelseries.tools.FrameDesign.BLACK_METAL);
        silos1Aditiv.setFrameVisible(false);
        silos1Aditiv.setGlowing(true);
        silos1Aditiv.setLabelNumberFormat(eu.hansolo.steelseries.tools.NumberFormat.STANDARD);
        silos1Aditiv.setLcdUnitString("");
        silos1Aditiv.setLcdVisible(false);
        silos1Aditiv.setLedVisible(false);
        silos1Aditiv.setMinorTickmarkVisible(false);
        silos1Aditiv.setTitle("Silos br 1");
        silos1Aditiv.setTitleAndUnitFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        silos1Aditiv.setTitleVisible(false);
        silos1Aditiv.setUnitStringVisible(false);
        jPanel1.add(silos1Aditiv);
        silos1Aditiv.setBounds(1060, 230, 120, 200);

        silos2Cement.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.TRANSPARENT);
        silos2Cement.setFrameDesign(eu.hansolo.steelseries.tools.FrameDesign.BLACK_METAL);
        silos2Cement.setFrameEffect(eu.hansolo.steelseries.tools.FrameEffect.EFFECT_BULGE);
        silos2Cement.setFrameVisible(false);
        silos2Cement.setLabelNumberFormat(eu.hansolo.steelseries.tools.NumberFormat.STANDARD);
        silos2Cement.setLcdColor(eu.hansolo.steelseries.tools.LcdColor.ORANGE_LCD);
        silos2Cement.setLcdUnitString("");
        silos2Cement.setLcdVisible(false);
        silos2Cement.setLedVisible(false);
        silos2Cement.setMinorTickmarkVisible(false);
        silos2Cement.setTitle("Silos br 2");
        silos2Cement.setTitleAndUnitFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        silos2Cement.setTitleVisible(false);
        silos2Cement.setUnitStringVisible(false);

        fluidizacijaSilosa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fluidizacijaSilosa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/vibrationOff.gif"))); // NOI18N
        fluidizacijaSilosa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fluidizacijaSilosa2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fluidizacijaSilosa2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fluidizacijaSilosa2MouseReleased(evt);
            }
        });
        silos2Cement.add(fluidizacijaSilosa2);
        fluidizacijaSilosa2.setBounds(80, 30, 30, 30);

        jPanel1.add(silos2Cement);
        silos2Cement.setBounds(750, 230, 120, 210);

        silos1Cement.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.TRANSPARENT);
        silos1Cement.setFrameDesign(eu.hansolo.steelseries.tools.FrameDesign.BLACK_METAL);
        silos1Cement.setFrameVisible(false);
        silos1Cement.setGlowing(true);
        silos1Cement.setLabelNumberFormat(eu.hansolo.steelseries.tools.NumberFormat.STANDARD);
        silos1Cement.setLcdBackgroundVisible(false);
        silos1Cement.setLcdColor(eu.hansolo.steelseries.tools.LcdColor.ORANGE_LCD);
        silos1Cement.setLcdUnitString("");
        silos1Cement.setLcdVisible(false);
        silos1Cement.setLedVisible(false);
        silos1Cement.setMinorTickmarkVisible(false);
        silos1Cement.setTitle("Silos br 1");
        silos1Cement.setTitleAndUnitFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        silos1Cement.setTitleVisible(false);
        silos1Cement.setUnitStringVisible(false);

        fluidizacijaSilosa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fluidizacijaSilosa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/vibrationOff.gif"))); // NOI18N
        fluidizacijaSilosa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                fluidizacijaSilosa1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fluidizacijaSilosa1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fluidizacijaSilosa1MouseReleased(evt);
            }
        });
        silos1Cement.add(fluidizacijaSilosa1);
        fluidizacijaSilosa1.setBounds(80, 30, 30, 30);

        jPanel1.add(silos1Cement);
        silos1Cement.setBounds(630, 230, 120, 210);

        opisVagaOtvorena1.setText("Vreme mesanja");
        opisVagaOtvorena1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisVagaOtvorena1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisVagaOtvorena1);
        opisVagaOtvorena1.setBounds(510, 760, 110, 19);

        opisVagaOtvorena2.setText("Vreme pražnjenja");
        opisVagaOtvorena2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisVagaOtvorena2.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisVagaOtvorena2);
        opisVagaOtvorena2.setBounds(1170, 760, 130, 19);

        opisVagaMesalicaPuna.setText("Mešalica puna:");
        opisVagaMesalicaPuna.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisVagaMesalicaPuna.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisVagaMesalicaPuna);
        opisVagaMesalicaPuna.setBounds(290, 850, 120, 19);

        opisVagaMesalicaPrazna.setText("Mešalica prazna:");
        opisVagaMesalicaPrazna.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisVagaMesalicaPrazna.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(opisVagaMesalicaPrazna);
        opisVagaMesalicaPrazna.setBounds(290, 890, 120, 19);

        IzdoziranoAgregati.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Yes.png"))); // NOI18N
        jPanel1.add(IzdoziranoAgregati);
        IzdoziranoAgregati.setBounds(570, 650, 30, 30);

        IzdoziranoCement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Yes.png"))); // NOI18N
        jPanel1.add(IzdoziranoCement);
        IzdoziranoCement.setBounds(700, 650, 30, 30);

        IzdoziranoVoda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Yes.png"))); // NOI18N
        jPanel1.add(IzdoziranoVoda);
        IzdoziranoVoda.setBounds(920, 650, 30, 30);

        IzdoziranoAditiv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Yes.png"))); // NOI18N
        jPanel1.add(IzdoziranoAditiv);
        IzdoziranoAditiv.setBounds(1130, 650, 30, 30);

        silosAgregat1632.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.TRANSPARENT);
        silosAgregat1632.setFrameVisible(false);
        silosAgregat1632.setLcdBackgroundVisible(false);
        silosAgregat1632.setLcdVisible(false);
        silosAgregat1632.setLedVisible(false);
        silosAgregat1632.setMinorTickmarkVisible(false);
        silosAgregat1632.setTitle("16-32 mm");
        silosAgregat1632.setUnitStringVisible(false);
        jPanel1.add(silosAgregat1632);
        silosAgregat1632.setBounds(40, 420, 80, 120);

        silosAgregat04.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.TRANSPARENT);
        silosAgregat04.setFrameVisible(false);
        silosAgregat04.setLcdVisible(false);
        silosAgregat04.setLedVisible(false);
        silosAgregat04.setMinorTickmarkVisible(false);
        silosAgregat04.setTitle("0-4 mm");
        silosAgregat04.setUnitStringVisible(false);
        jPanel1.add(silosAgregat04);
        silosAgregat04.setBounds(220, 420, 70, 120);

        silosAgregat816.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.TRANSPARENT);
        silosAgregat816.setFrameVisible(false);
        silosAgregat816.setLcdVisible(false);
        silosAgregat816.setLedVisible(false);
        silosAgregat816.setMinorTickmarkVisible(false);
        silosAgregat816.setTitle("8-16 mm");
        silosAgregat816.setUnitStringVisible(false);
        jPanel1.add(silosAgregat816);
        silosAgregat816.setBounds(130, 420, 80, 120);

        silosAgregat48.setBackgroundColor(eu.hansolo.steelseries.tools.BackgroundColor.TRANSPARENT);
        silosAgregat48.setFrameVisible(false);
        silosAgregat48.setLcdVisible(false);
        silosAgregat48.setLedVisible(false);
        silosAgregat48.setMinorTickmarkVisible(false);
        silosAgregat48.setTitle("4-8 mm");
        silosAgregat48.setUnitStringVisible(false);
        jPanel1.add(silosAgregat48);
        silosAgregat48.setBounds(300, 420, 80, 120);

        mesalicuZatvori.setLedColor(eu.hansolo.steelseries.tools.LedColor.RED);
        mesalicuZatvori.setLedType(eu.hansolo.steelseries.tools.LedType.RECT_HORIZONTAL);
        mesalicuZatvori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mesalicuZatvoriMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mesalicuZatvoriMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mesalicuZatvoriMouseReleased(evt);
            }
        });
        jPanel1.add(mesalicuZatvori);
        mesalicuZatvori.setBounds(1100, 780, 60, 60);

        mesalicuOtvori.setLedColor(eu.hansolo.steelseries.tools.LedColor.RED);
        mesalicuOtvori.setLedType(eu.hansolo.steelseries.tools.LedType.RECT_HORIZONTAL);
        mesalicuOtvori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mesalicuOtvoriMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mesalicuOtvoriMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mesalicuOtvoriMouseReleased(evt);
            }
        });
        jPanel1.add(mesalicuOtvori);
        mesalicuOtvori.setBounds(660, 780, 60, 60);

        vibratorVagaCementa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vibratorVagaCementa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/vibrationOff.gif"))); // NOI18N
        vibratorVagaCementa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vibratorVagaCementaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vibratorVagaCementaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vibratorVagaCementaMouseReleased(evt);
            }
        });
        jPanel1.add(vibratorVagaCementa);
        vibratorVagaCementa.setBounds(640, 580, 30, 30);

        vibratorTrake.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vibratorTrake.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/vibrationOff.gif"))); // NOI18N
        vibratorTrake.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vibratorTrakeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vibratorTrakeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vibratorTrakeMouseReleased(evt);
            }
        });
        jPanel1.add(vibratorTrake);
        vibratorTrake.setBounds(290, 620, 30, 30);

        buttonGroup1.add(SelectedSilos1);
        SelectedSilos1.setSelected(true);
        SelectedSilos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectedSilos1ActionPerformed(evt);
            }
        });
        jPanel1.add(SelectedSilos1);
        SelectedSilos1.setBounds(710, 200, 20, 20);

        buttonGroup1.add(SelectedSilos2);
        SelectedSilos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectedSilos2ActionPerformed(evt);
            }
        });
        jPanel1.add(SelectedSilos2);
        SelectedSilos2.setBounds(830, 200, 20, 20);

        DOVodaIspiranjeVageAditiva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOVodaIspiranjeVageAditiva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Forbidden.png"))); // NOI18N
        DOVodaIspiranjeVageAditiva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DOVodaIspiranjeVageAditivaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DOVodaIspiranjeVageAditivaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DOVodaIspiranjeVageAditivaMouseReleased(evt);
            }
        });
        jPanel1.add(DOVodaIspiranjeVageAditiva);
        DOVodaIspiranjeVageAditiva.setBounds(1020, 430, 40, 30);

        jLabel118.setBackground(new java.awt.Color(204, 204, 204));
        jLabel118.setOpaque(true);
        jPanel1.add(jLabel118);
        jLabel118.setBounds(1070, 440, 10, 100);

        jLabel119.setBackground(new java.awt.Color(204, 204, 204));
        jLabel119.setOpaque(true);
        jPanel1.add(jLabel119);
        jLabel119.setBounds(980, 440, 90, 10);

        opisHidropumpa1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisHidropumpa1.setForeground(new java.awt.Color(102, 102, 102));
        opisHidropumpa1.setText("Vlaga 0 - 4 mm: ");
        jPanel1.add(opisHidropumpa1);
        opisHidropumpa1.setBounds(190, 350, 110, 19);

        opisVlaga.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisVlaga.setText("A");
        jPanel1.add(opisVlaga);
        opisVlaga.setBounds(1010, 800, 20, 19);

        DOMesalicaZatvori1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        DOMesalicaZatvori1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DOMesalicaZatvori1.setText("Struja motora");
        DOMesalicaZatvori1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DOMesalicaZatvori1MouseClicked(evt);
            }
        });
        jPanel1.add(DOMesalicaZatvori1);
        DOMesalicaZatvori1.setBounds(870, 770, 130, 20);

        opisVlaga1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisVlaga1.setForeground(new java.awt.Color(102, 102, 102));
        opisVlaga1.setText("%");
        jPanel1.add(opisVlaga1);
        opisVlaga1.setBounds(380, 350, 20, 19);

        otpremaZavrsena.setText("Tekuća otprema je završena");
        otpremaZavrsena.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        otpremaZavrsena.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(otpremaZavrsena);
        otpremaZavrsena.setBounds(270, 190, 360, 40);

        vibratorFrakcija1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vibratorFrakcija1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/vibrationOff.gif"))); // NOI18N
        vibratorFrakcija1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vibratorFrakcija1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                vibratorFrakcija1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                vibratorFrakcija1MouseReleased(evt);
            }
        });
        jPanel1.add(vibratorFrakcija1);
        vibratorFrakcija1.setBounds(270, 510, 30, 30);

        kosaTrakaJePrazna.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        kosaTrakaJePrazna.setText("Kosa traka je puna");
        kosaTrakaJePrazna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kosaTrakaJePraznaMouseClicked(evt);
            }
        });
        jPanel1.add(kosaTrakaJePrazna);
        kosaTrakaJePrazna.setBounds(430, 576, 180, 30);

        vodaPlus.setText("Voda +");
        vodaPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vodaPlusActionPerformed(evt);
            }
        });
        jPanel1.add(vodaPlus);
        vodaPlus.setBounds(940, 250, 67, 23);

        vodaMinus.setText("Voda -");
        vodaMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vodaMinusActionPerformed(evt);
            }
        });
        jPanel1.add(vodaMinus);
        vodaMinus.setBounds(940, 360, 63, 23);

        vodaPlusMinus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vodaPlusMinus.setText("____");
        jPanel1.add(vodaPlusMinus);
        vodaPlusMinus.setBounds(930, 310, 80, 30);

        opisIzdato1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        opisIzdato1.setForeground(new java.awt.Color(102, 102, 102));
        opisIzdato1.setText("Ukupno");
        jPanel1.add(opisIzdato1);
        opisIzdato1.setBounds(50, 120, 60, 19);

        MWheaderIzdato0_4Ukupno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdato0_4Ukupno.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderIzdato0_4Ukupno.setText("0");
        jPanel1.add(MWheaderIzdato0_4Ukupno);
        MWheaderIzdato0_4Ukupno.setBounds(140, 120, 60, 19);

        MWheaderIzdato4_8Ukupno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdato4_8Ukupno.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderIzdato4_8Ukupno.setText("0");
        jPanel1.add(MWheaderIzdato4_8Ukupno);
        MWheaderIzdato4_8Ukupno.setBounds(220, 120, 60, 19);

        MWheaderIzdato8_16Ukupno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdato8_16Ukupno.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderIzdato8_16Ukupno.setText("0");
        jPanel1.add(MWheaderIzdato8_16Ukupno);
        MWheaderIzdato8_16Ukupno.setBounds(300, 120, 60, 19);

        MWheaderIzdato16_32Ukupno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdato16_32Ukupno.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderIzdato16_32Ukupno.setText("0");
        jPanel1.add(MWheaderIzdato16_32Ukupno);
        MWheaderIzdato16_32Ukupno.setBounds(380, 120, 60, 19);

        MWheaderIzdatoCementUkupno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdatoCementUkupno.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderIzdatoCementUkupno.setText("0");
        jPanel1.add(MWheaderIzdatoCementUkupno);
        MWheaderIzdatoCementUkupno.setBounds(560, 120, 60, 19);

        MWheaderIzdatoFilerUkupno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdatoFilerUkupno.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderIzdatoFilerUkupno.setText("0");
        jPanel1.add(MWheaderIzdatoFilerUkupno);
        MWheaderIzdatoFilerUkupno.setBounds(720, 120, 60, 19);

        MWheaderIzdatoAditiv1Ukupno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdatoAditiv1Ukupno.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderIzdatoAditiv1Ukupno.setText("0");
        jPanel1.add(MWheaderIzdatoAditiv1Ukupno);
        MWheaderIzdatoAditiv1Ukupno.setBounds(900, 120, 60, 19);

        MWheaderIzdatoAditiv2Ukupno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdatoAditiv2Ukupno.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderIzdatoAditiv2Ukupno.setText("0");
        jPanel1.add(MWheaderIzdatoAditiv2Ukupno);
        MWheaderIzdatoAditiv2Ukupno.setBounds(970, 120, 60, 19);

        MWheaderIzdatoVodaUkupno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdatoVodaUkupno.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderIzdatoVodaUkupno.setText("0");
        jPanel1.add(MWheaderIzdatoVodaUkupno);
        MWheaderIzdatoVodaUkupno.setBounds(1090, 120, 60, 19);

        blokadaOtvaranjaMesalice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blokadaOtvaranjaMesaliceMouseClicked(evt);
            }
        });
        blokadaOtvaranjaMesalice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blokadaOtvaranjaMesaliceActionPerformed(evt);
            }
        });
        jPanel1.add(blokadaOtvaranjaMesalice);
        blokadaOtvaranjaMesalice.setBounds(660, 860, 20, 21);

        jLabel1.setText("Zadata kol frakcija 1 ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 710, 120, 14);

        priremenoZadataKolicinaF1.setText("f1");
        jPanel1.add(priremenoZadataKolicinaF1);
        priremenoZadataKolicinaF1.setBounds(20, 730, 120, 14);

        jLabel3.setText("Zbir frakcija 1  frakcija 2");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 770, 150, 14);

        priremenoZadataKolicinaF1F2.setText("f1+f2");
        jPanel1.add(priremenoZadataKolicinaF1F2);
        priremenoZadataKolicinaF1F2.setBounds(20, 790, 120, 14);

        jLabel16.setText("Zbir frakcija 1, 2, 3");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(20, 830, 150, 14);

        priremenoZadataKolicinaF1F2F3.setText("f1+f2+f2");
        jPanel1.add(priremenoZadataKolicinaF1F2F3);
        priremenoZadataKolicinaF1F2F3.setBounds(20, 850, 120, 14);

        jLabel17.setText("Zbir frakcija 1, 2, 3, 4");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(20, 900, 150, 14);

        priremenoZadataKolicinaF1F2F3F4.setText("f1+f2+f2+f4");
        jPanel1.add(priremenoZadataKolicinaF1F2F3F4);
        priremenoZadataKolicinaF1F2F3F4.setBounds(20, 920, 120, 14);

        MWheaderIzdatoUkupno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        MWheaderIzdatoUkupno.setForeground(new java.awt.Color(102, 102, 102));
        MWheaderIzdatoUkupno.setText("0");
        jPanel1.add(MWheaderIzdatoUkupno);
        MWheaderIzdatoUkupno.setBounds(1230, 120, 60, 19);

        jPanel4.setOpaque(false);

        jLabel18.setText("Korekcija po vlagi: ");

        jLabel19.setText("Korigovana F1:");

        jLabel20.setText("Korigovana voda:");

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jCheckBoxAktivnaKorekcijaPoVlagi.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jCheckBoxAktivnaKorekcijaPoVlagi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAktivnaKorekcijaPoVlagiActionPerformed(evt);
            }
        });

        korigovanoF1.setFrameVisible(false);
        korigovanoF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                korigovanoF1MouseClicked(evt);
            }
        });

        korigovanoF2.setFrameVisible(false);
        korigovanoF2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                korigovanoF2MouseClicked(evt);
            }
        });
        korigovanoF1.add(korigovanoF2);
        korigovanoF2.setBounds(510, 490, 60, 30);

        korigovanaVoda.setFrameVisible(false);
        korigovanaVoda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                korigovanaVodaMouseClicked(evt);
            }
        });

        korigovanoF4.setFrameVisible(false);
        korigovanoF4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                korigovanoF4MouseClicked(evt);
            }
        });
        korigovanaVoda.add(korigovanoF4);
        korigovanoF4.setBounds(510, 490, 60, 30);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jCheckBoxAktivnaKorekcijaPoVlagi))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(korigovanoF1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(korigovanaVoda, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(113, 113, 113)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(95, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jCheckBoxAktivnaKorekcijaPoVlagi))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(korigovanoF1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(korigovanaVoda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(45, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(420, 320, 210, 130);

        jLabel21.setText("Blokada otvaranja mesalice");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(690, 860, 180, 14);

        background.setBackground(new java.awt.Color(255, 255, 153));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Main screen.jpg"))); // NOI18N
        background.setOpaque(true);
        jPanel1.add(background);
        background.setBounds(0, 0, 1420, 1050);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 153));
        jLabel2.setText("Tekući radni nalog");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Broj RN :");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Marka betona:");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Kupac:");

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Gradilište:");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Ugovoreno po RN :");

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Isporučeno po RN :");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Preostalo za isporuku po RN :");

        tekuciBrojRN.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tekuciBrojRN.setForeground(new java.awt.Color(255, 255, 255));
        tekuciBrojRN.setText("RN");

        tekucaMarkaBetona.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tekucaMarkaBetona.setForeground(new java.awt.Color(255, 255, 255));
        tekucaMarkaBetona.setText("MB");

        tekuciKupac.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tekuciKupac.setForeground(new java.awt.Color(255, 255, 255));
        tekuciKupac.setText("K");

        tekuceGradiliste.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tekuceGradiliste.setForeground(new java.awt.Color(255, 255, 255));
        tekuceGradiliste.setText("G");

        tekuceUgovoreno.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tekuceUgovoreno.setForeground(new java.awt.Color(255, 255, 255));
        tekuceUgovoreno.setText("M3");

        tekuceIsporuceno.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tekuceIsporuceno.setForeground(new java.awt.Color(255, 255, 255));
        tekuceIsporuceno.setText("M3");

        tekucePreostalo.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tekucePreostalo.setForeground(new java.awt.Color(255, 255, 255));
        tekucePreostalo.setText("M3");

        shorcutAktivniRadniNaloti.setText("Aktivni R.N.");
        shorcutAktivniRadniNaloti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shorcutAktivniRadniNalotiActionPerformed(evt);
            }
        });

        jButtonOtkaziRN.setText("Otkaži Radni nalog");
        jButtonOtkaziRN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtkaziRNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonOtkaziRN, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(shorcutAktivniRadniNaloti, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tekuciBrojRN, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tekucaMarkaBetona, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tekuciKupac, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tekuceGradiliste, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tekuceUgovoreno, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tekuceIsporuceno, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tekucePreostalo, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shorcutAktivniRadniNaloti, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jButtonOtkaziRN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tekuciBrojRN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tekucaMarkaBetona))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tekuciKupac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tekuceGradiliste))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tekuceUgovoreno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tekuceIsporuceno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tekucePreostalo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(1430, 160, 480, 320);

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        zadrziPodatke.setText("Zadrzi podatke");

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 153));
        jLabel11.setText("Tekuća otprema");

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Broj vozila:");

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Vozač:");

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Zadato:");

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Trenutno:");

        tekuceTablicaVozila.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tekuceTablicaVozila.setForeground(new java.awt.Color(255, 255, 255));
        tekuceTablicaVozila.setText("T");

        tekuceVozac.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tekuceVozac.setForeground(new java.awt.Color(255, 255, 255));
        tekuceVozac.setText("V");

        tekuceZadato.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tekuceZadato.setForeground(new java.awt.Color(255, 255, 255));
        tekuceZadato.setText("0");

        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setText("m3");

        tekuceTrenutno.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        tekuceTrenutno.setForeground(new java.awt.Color(255, 255, 255));
        tekuceTrenutno.setText("0");

        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setText("m3");

        jButtonOtkaziOtpremu.setText("Zavrsi zapoceto");
        jButtonOtkaziOtpremu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtkaziOtpremuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonOtkaziOtpremu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(zadrziPodatke, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tekuceZadato, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(tekuceTrenutno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(tekuceTablicaVozila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tekuceVozac, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 57, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(zadrziPodatke))
                    .addComponent(jButtonOtkaziOtpremu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tekuceTablicaVozila))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tekuceVozac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tekuceZadato)
                    .addComponent(jLabel120))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tekuceTrenutno)
                    .addComponent(jLabel121))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(1430, 490, 480, 200);

        jButtonNovaOtprema.setText("Nova otprema");
        jButtonNovaOtprema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaOtpremaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNovaOtprema);
        jButtonNovaOtprema.setBounds(1430, 720, 470, 90);

        jButtonStartCiklus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Play_48x48.png"))); // NOI18N
        jButtonStartCiklus.setText("Start ciklusa");
        jButtonStartCiklus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartCiklusActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonStartCiklus);
        jButtonStartCiklus.setBounds(1440, 950, 230, 90);

        jButtonStopCiklusa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/small/Stop_48x48.png"))); // NOI18N
        jButtonStopCiklusa.setText("Zaustavi ciklus");
        jButtonStopCiklusa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopCiklusaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonStopCiklusa);
        jButtonStopCiklusa.setBounds(1710, 950, 200, 90);

        controlPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Dodatak main screen.jpg"))); // NOI18N
        jPanel1.add(controlPanel);
        controlPanel.setBounds(1420, 0, 500, 1050);

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1905, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
        );

        jMenu4.setText("Podešavanja");

        jMenuItemZbirniParametri.setText("Zbirni parametri");
        jMenuItemZbirniParametri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemZbirniParametriActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemZbirniParametri);

        jMenuItemPreleti.setText("Preleti");
        jMenuItemPreleti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPreletiActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemPreleti);

        jMenuItem2.setText("Sifre");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu8.setText("Stampa");

        jMenuItem8.setText("Stampaj trenutnu otpremu");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem8);

        jMenuBar1.add(jMenu8);

        jMenu1.setText("File");

        jMenuItem1.setText("Izlaz");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Zalihe");

        jMenuItemStanjeZaliha.setText("Stanje zaliha");
        jMenuItemStanjeZaliha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemStanjeZalihaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemStanjeZaliha);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Test");

        jMenuItemTestUpisFile.setText("Upis File Test");
        jMenuItemTestUpisFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTestUpisFileActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemTestUpisFile);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovaOtpremaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaOtpremaActionPerformed
        getNewOtpremaFromRN();
    }//GEN-LAST:event_jButtonNovaOtpremaActionPerformed

    private void jButtonStartCiklusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartCiklusActionPerformed
        mb.writeMX(true, pogon.getOstalo().getStartCiklus().getKomandaAdresa());
    }//GEN-LAST:event_jButtonStartCiklusActionPerformed

    private void DORucnuAutomatskiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DORucnuAutomatskiMouseClicked
        mb.writeMX(!pogon.getOstalo().getRucnoAutomatski().getKomanda(), pogon.getOstalo().getRucnoAutomatski().getKomandaAdresa());
    }//GEN-LAST:event_DORucnuAutomatskiMouseClicked

    private void DOAditiv2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAditiv2MouseClicked

    }//GEN-LAST:event_DOAditiv2MouseClicked

    private void DOMesalicaOtvoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOMesalicaOtvoriMouseClicked

    }//GEN-LAST:event_DOMesalicaOtvoriMouseClicked

    private void DOMesalicaZatvoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOMesalicaZatvoriMouseClicked

    }//GEN-LAST:event_DOMesalicaZatvoriMouseClicked

    private void DOTraka1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOTraka1MouseClicked
        showScreen(screenTraka1, "Traka", "traka br. 1", pogon.getTraka().getRunTraka1());
    }//GEN-LAST:event_DOTraka1MouseClicked

    private void DOTraka2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOTraka2MouseClicked
        showScreen(screenTraka2, "Traka", "traka br. 2", pogon.getTraka().getRunTraka2());
    }//GEN-LAST:event_DOTraka2MouseClicked

    private void shorcutAktivniRadniNalotiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shorcutAktivniRadniNalotiActionPerformed
        aktivniRadniNaloziFrame.setVisible(true);
        aktivniRadniNaloziFrame.getAktivniRN();
    }//GEN-LAST:event_shorcutAktivniRadniNalotiActionPerformed

    private void DOHidropumpaUkljuciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOHidropumpaUkljuciMouseClicked
        showScreen(screenHidropumpa, "Hidropumpa", "hidropumpa", pogon.getOstalo().getHidropumpaUkljucena());
    }//GEN-LAST:event_DOHidropumpaUkljuciMouseClicked

    private void DOMesalicuUkljuciMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOMesalicuUkljuciMouseClicked
        showScreen(screenMesalica, "Mesalica", "mesalica", pogon.getMesalica().getUkljucena());
    }//GEN-LAST:event_DOMesalicuUkljuciMouseClicked

    private void DOAgregat0_4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAgregat0_4MousePressed
        komandaOn(pogon.getAgregat0_4().getKomanda().getKomandaAdresa());
        rucniRadOtprema.getFrakcija1().setUnesiPocetak(true);
    }//GEN-LAST:event_DOAgregat0_4MousePressed

    private void DOAgregat0_4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAgregat0_4MouseReleased
        komandaOff(pogon.getAgregat0_4().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOAgregat0_4MouseReleased

    private void DOAgregat4_8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAgregat4_8MousePressed
        komandaOn(pogon.getAgregat4_8().getKomanda().getKomandaAdresa());
        rucniRadOtprema.getFrakcija2().setUnesiPocetak(true);
    }//GEN-LAST:event_DOAgregat4_8MousePressed

    private void DOAgregat4_8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAgregat4_8MouseReleased
        komandaOff(pogon.getAgregat4_8().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOAgregat4_8MouseReleased

    private void DOAgregat8_16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAgregat8_16MousePressed
        komandaOn(pogon.getAgregat8_16().getKomanda().getKomandaAdresa());
        rucniRadOtprema.getFrakcija3().setUnesiPocetak(true);
    }//GEN-LAST:event_DOAgregat8_16MousePressed

    private void DOAgregat8_16MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAgregat8_16MouseReleased
        komandaOff(pogon.getAgregat8_16().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOAgregat8_16MouseReleased

    private void DOAgregat0_4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAgregat0_4MouseExited
        komandaOff(pogon.getAgregat0_4().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOAgregat0_4MouseExited

    private void DOAgregat4_8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAgregat4_8MouseExited
        komandaOff(pogon.getAgregat4_8().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOAgregat4_8MouseExited

    private void DOAgregat8_16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAgregat8_16MouseExited
        komandaOff(pogon.getAgregat8_16().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOAgregat8_16MouseExited

    private void DOAgregat16_32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAgregat16_32MousePressed
        komandaOn(pogon.getAgregat16_32().getKomanda().getKomandaAdresa());
        rucniRadOtprema.getFrakcija4().setUnesiPocetak(true);
    }//GEN-LAST:event_DOAgregat16_32MousePressed

    private void DOAgregat16_32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAgregat16_32MouseExited
        komandaOff(pogon.getAgregat16_32().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOAgregat16_32MouseExited

    private void DOAgregat16_32MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAgregat16_32MouseReleased
        komandaOff(pogon.getAgregat16_32().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOAgregat16_32MouseReleased

    private void DOCement1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOCement1MousePressed
        komandaOn(pogon.getCement().getKomanda().getKomandaAdresa());
        rucniRadOtprema.getSilos1().setUnesiPocetak(true);
    }//GEN-LAST:event_DOCement1MousePressed

    private void DOCement1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOCement1MouseReleased
        komandaOff(pogon.getCement().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOCement1MouseReleased

    private void DOCement1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOCement1MouseExited
        komandaOff(pogon.getCement().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOCement1MouseExited

    private void DOCement2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOCement2MousePressed
        komandaOn(pogon.getFiler().getKomanda().getKomandaAdresa());
        rucniRadOtprema.getSilos2().setUnesiPocetak(true);
    }//GEN-LAST:event_DOCement2MousePressed

    private void DOCement2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOCement2MouseReleased
        komandaOff(pogon.getFiler().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOCement2MouseReleased

    private void DOCement2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOCement2MouseExited
        komandaOff(pogon.getFiler().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOCement2MouseExited

    private void DOVodaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOVodaMousePressed
        komandaOn(pogon.getVoda().getKomanda().getKomandaAdresa());
        rucniRadOtprema.getVoda().setUnesiPocetak(true);
    }//GEN-LAST:event_DOVodaMousePressed

    private void DOVodaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOVodaMouseReleased
        komandaOff(pogon.getVoda().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOVodaMouseReleased

    private void DOVodaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOVodaMouseExited
        komandaOff(pogon.getVoda().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOVodaMouseExited

    private void DOAditiv1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAditiv1MousePressed
        komandaOn(pogon.getAditiv1().getKomanda().getKomandaAdresa());
        rucniRadOtprema.getAditiv1().setUnesiPocetak(true);
    }//GEN-LAST:event_DOAditiv1MousePressed

    private void DOAditiv1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAditiv1MouseReleased
        komandaOff(pogon.getAditiv1().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOAditiv1MouseReleased

    private void DOAditiv1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAditiv1MouseExited
        komandaOff(pogon.getAditiv1().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOAditiv1MouseExited

    private void DOAditiv2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAditiv2MousePressed
        komandaOn(pogon.getAditiv2().getKomanda().getKomandaAdresa());
        rucniRadOtprema.getAditiv2().setUnesiPocetak(true);
    }//GEN-LAST:event_DOAditiv2MousePressed

    private void DOAditiv2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAditiv2MouseReleased
        komandaOff(pogon.getAditiv2().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOAditiv2MouseReleased

    private void DOAditiv2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOAditiv2MouseExited
        komandaOff(pogon.getAditiv2().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOAditiv2MouseExited

    private void mesalicuOtvoriMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesalicuOtvoriMousePressed
        komandaOn(pogon.getMesalica().getOtvori().getKomandaAdresa());
        if(pogon.getMesalica().getOtvorena()){
            rucniRadOtprema.writeData();
        }
    }//GEN-LAST:event_mesalicuOtvoriMousePressed

    private void mesalicuOtvoriMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesalicuOtvoriMouseReleased
        komandaOff(pogon.getMesalica().getOtvori().getKomandaAdresa());
    }//GEN-LAST:event_mesalicuOtvoriMouseReleased

    private void mesalicuOtvoriMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesalicuOtvoriMouseExited
        komandaOff(pogon.getMesalica().getOtvori().getKomandaAdresa());
    }//GEN-LAST:event_mesalicuOtvoriMouseExited

    private void mesalicuZatvoriMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesalicuZatvoriMousePressed
        komandaOn(pogon.getMesalica().getZatvori().getKomandaAdresa());
    }//GEN-LAST:event_mesalicuZatvoriMousePressed

    private void mesalicuZatvoriMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesalicuZatvoriMouseReleased
        komandaOff(pogon.getMesalica().getZatvori().getKomandaAdresa());
    }//GEN-LAST:event_mesalicuZatvoriMouseReleased

    private void mesalicuZatvoriMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mesalicuZatvoriMouseExited
        komandaOff(pogon.getMesalica().getZatvori().getKomandaAdresa());
    }//GEN-LAST:event_mesalicuZatvoriMouseExited

    private void DOCementVagaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOCementVagaMousePressed
        komandaOn(pogon.getVagaCement().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOCementVagaMousePressed

    private void DOCementVagaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOCementVagaMouseReleased
        komandaOff(pogon.getVagaCement().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOCementVagaMouseReleased

    private void DOCementVagaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOCementVagaMouseExited
        komandaOff(pogon.getVagaCement().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOCementVagaMouseExited

    private void DOVagaVodaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOVagaVodaMousePressed
        komandaOn(pogon.getVagaVoda().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOVagaVodaMousePressed

    private void DOVagaVodaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOVagaVodaMouseReleased
        komandaOff(pogon.getVagaVoda().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOVagaVodaMouseReleased

    private void DOVagaVodaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOVagaVodaMouseExited
        komandaOff(pogon.getVagaVoda().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOVagaVodaMouseExited

    private void DOVagaAditivMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOVagaAditivMousePressed
        komandaOn(pogon.getVagaAditiv().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOVagaAditivMousePressed

    private void DOVagaAditivMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOVagaAditivMouseReleased
        komandaOff(pogon.getVagaAditiv().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOVagaAditivMouseReleased

    private void DOVagaAditivMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOVagaAditivMouseExited
        komandaOff(pogon.getVagaAditiv().getKomanda().getKomandaAdresa());
    }//GEN-LAST:event_DOVagaAditivMouseExited

    private void MWTrakaAgregatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MWTrakaAgregatMouseClicked
        showScreenTariranje(screenTariranjeVageFrakcije, "Tariranje", "Tariranje vage trake", pogon.getTraka().getTariranje(), "Tariraj");
    }//GEN-LAST:event_MWTrakaAgregatMouseClicked

    private void MWCementVagaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MWCementVagaMouseClicked
        showScreenTariranje(screenTariranjeVageCement, "Tariranje", "Tariranje vage cementa", pogon.getVagaCement().getTariranje(), "Tariraj");
    }//GEN-LAST:event_MWCementVagaMouseClicked

    private void MWAditivVagaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MWAditivVagaMouseClicked
        showScreenTariranje(screenTariranjeVageAditiv, "Tariranje", "Tariranje vage aditiva", pogon.getVagaAditiv().getTariranje(), "Tariraj");
    }//GEN-LAST:event_MWAditivVagaMouseClicked

    private void MWVodaVagaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MWVodaVagaMouseClicked
        showScreenTariranje(screenTariranjeVageVoda, "Tariranje", "Tariranje vage vode", pogon.getVagaVoda().getTariranje(), "Tariraj");
    }//GEN-LAST:event_MWVodaVagaMouseClicked

    private void vibratorTrakeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vibratorTrakeMousePressed
        komandaOn(pogon.getTraka().getVibracija().getKomandaAdresa());
    }//GEN-LAST:event_vibratorTrakeMousePressed

    private void vibratorTrakeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vibratorTrakeMouseReleased
        komandaOff(pogon.getTraka().getVibracija().getKomandaAdresa());
    }//GEN-LAST:event_vibratorTrakeMouseReleased

    private void vibratorTrakeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vibratorTrakeMouseExited
        komandaOff(pogon.getTraka().getVibracija().getKomandaAdresa());
    }//GEN-LAST:event_vibratorTrakeMouseExited

    private void fluidizacijaSilosa1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fluidizacijaSilosa1MousePressed
        komandaOn(pogon.getCement().getFluidizacija().getKomandaAdresa());
    }//GEN-LAST:event_fluidizacijaSilosa1MousePressed

    private void fluidizacijaSilosa1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fluidizacijaSilosa1MouseReleased
        komandaOff(pogon.getCement().getFluidizacija().getKomandaAdresa());
    }//GEN-LAST:event_fluidizacijaSilosa1MouseReleased

    private void fluidizacijaSilosa1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fluidizacijaSilosa1MouseExited
        komandaOff(pogon.getCement().getFluidizacija().getKomandaAdresa());
    }//GEN-LAST:event_fluidizacijaSilosa1MouseExited

    private void fluidizacijaSilosa2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fluidizacijaSilosa2MousePressed
        komandaOn(pogon.getFiler().getFluidizacija().getKomandaAdresa());
    }//GEN-LAST:event_fluidizacijaSilosa2MousePressed

    private void fluidizacijaSilosa2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fluidizacijaSilosa2MouseReleased
        komandaOff(pogon.getFiler().getFluidizacija().getKomandaAdresa());
    }//GEN-LAST:event_fluidizacijaSilosa2MouseReleased

    private void fluidizacijaSilosa2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fluidizacijaSilosa2MouseExited
        komandaOff(pogon.getFiler().getFluidizacija().getKomandaAdresa());
    }//GEN-LAST:event_fluidizacijaSilosa2MouseExited

    private void SelectedSilos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedSilos2ActionPerformed
        setSelectedSilos();
    }//GEN-LAST:event_SelectedSilos2ActionPerformed

    private void SelectedSilos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectedSilos1ActionPerformed
        setSelectedSilos();
    }//GEN-LAST:event_SelectedSilos1ActionPerformed

    private void DOVodaIspiranjeVageAditivaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOVodaIspiranjeVageAditivaMouseExited
        komandaOff(pogon.getVoda().getIspiranjeVageAditiva().getKomandaAdresa());
    }//GEN-LAST:event_DOVodaIspiranjeVageAditivaMouseExited

    private void DOVodaIspiranjeVageAditivaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOVodaIspiranjeVageAditivaMousePressed
        komandaOn(pogon.getVoda().getIspiranjeVageAditiva().getKomandaAdresa());
    }//GEN-LAST:event_DOVodaIspiranjeVageAditivaMousePressed

    private void DOVodaIspiranjeVageAditivaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOVodaIspiranjeVageAditivaMouseReleased
        komandaOff(pogon.getVoda().getIspiranjeVageAditiva().getKomandaAdresa());
    }//GEN-LAST:event_DOVodaIspiranjeVageAditivaMouseReleased

    private void jButtonOtkaziOtpremuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtkaziOtpremuActionPerformed
        mb.writeMX(true, pogon.getOstalo().getZavrsiCiklus().getKomandaAdresa());
    }//GEN-LAST:event_jButtonOtkaziOtpremuActionPerformed

    private void jButtonStopCiklusaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopCiklusaActionPerformed
        mb.writeMX(true, pogon.getOstalo().getStopCiklus().getKomandaAdresa());
    }//GEN-LAST:event_jButtonStopCiklusaActionPerformed

    private void MWVlagaBetonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MWVlagaBetonaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MWVlagaBetonaMouseClicked

    private void MWStrujaMesaliceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MWStrujaMesaliceMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MWStrujaMesaliceMouseClicked

    private void DOMesalicaZatvori1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOMesalicaZatvori1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DOMesalicaZatvori1MouseClicked

    private void vibratorFrakcija1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vibratorFrakcija1MouseExited
        //komandaOff(pogon.getAgregat0_4().getVibracija().getKomandaAdresa());
    }//GEN-LAST:event_vibratorFrakcija1MouseExited

    private void vibratorFrakcija1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vibratorFrakcija1MousePressed
        //komandaOn(pogon.getAgregat0_4().getVibracija().getKomandaAdresa());
        if (!pogon.getOstalo().getRucnoAutomatski().getKomanda()) {
            mb.writeMX(!pogon.getAgregat0_4().getVibracija().getKomanda(), pogon.getAgregat0_4().getVibracija().getKomandaAdresa());
        }

    }//GEN-LAST:event_vibratorFrakcija1MousePressed

    private void vibratorFrakcija1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vibratorFrakcija1MouseReleased
        //komandaOff(pogon.getAgregat0_4().getVibracija().getKomandaAdresa());
    }//GEN-LAST:event_vibratorFrakcija1MouseReleased

    private void kosaTrakaJePraznaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kosaTrakaJePraznaMouseClicked
        mb.writeMX(!pogon.getTraka().getKosaTrakaPrazna(), pogon.getTraka().getKosaTrakaPraznaAdresa());
    }//GEN-LAST:event_kosaTrakaJePraznaMouseClicked

    private void vibratorVagaCementaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vibratorVagaCementaMousePressed
        komandaOn(pogon.getVagaCement().getVibracija().getKomandaAdresa());
    }//GEN-LAST:event_vibratorVagaCementaMousePressed

    private void vibratorVagaCementaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vibratorVagaCementaMouseReleased
        komandaOff(pogon.getVagaCement().getVibracija().getKomandaAdresa());
    }//GEN-LAST:event_vibratorVagaCementaMouseReleased

    private void vibratorVagaCementaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vibratorVagaCementaMouseExited
        komandaOff(pogon.getVagaCement().getVibracija().getKomandaAdresa());
    }//GEN-LAST:event_vibratorVagaCementaMouseExited

    private void DOMesalicaMixerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DOMesalicaMixerMouseClicked
        showScreen(screenMesalica, "Mesalica", "mesalica", pogon.getMesalica().getUkljucena());
    }//GEN-LAST:event_DOMesalicaMixerMouseClicked

    private void vodaPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vodaPlusActionPerformed
        getVoda(1);
    }//GEN-LAST:event_vodaPlusActionPerformed

    private void vodaMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vodaMinusActionPerformed
        getVoda(-1);
    }//GEN-LAST:event_vodaMinusActionPerformed

    private void getVoda(int broj) {
        try {
            db.Markabetona receptura = markaBetonaDb.getRecept(tekucaMarkaBetona.getText());
            int a = Integer.parseInt(MWheaderZadatoVoda.getText());//(int) receptura.getVoda();
            a = a + broj;
            //markaBetonaDb.setVoda(receptura.getId(), a);
            //vodaPlusMinus.setText(Integer.toString(a));

            brSarzi.setVoda(a);
            mb.writeMW(a, 16);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void blokadaOtvaranjaMesaliceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blokadaOtvaranjaMesaliceMouseClicked

    }//GEN-LAST:event_blokadaOtvaranjaMesaliceMouseClicked

    private void blokadaOtvaranjaMesaliceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blokadaOtvaranjaMesaliceActionPerformed
        mb.writeMX(!pogon.getMesalica().getBlokadaOtvaranjaMesalice().getKomanda(), pogon.getMesalica().getBlokadaOtvaranjaMesalice().getKomandaAdresa());
    }//GEN-LAST:event_blokadaOtvaranjaMesaliceActionPerformed

    private void jButtonOtkaziRNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtkaziRNActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Da li želite da otkazete radni nalog?", "Upozorenje",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            radniNalogDb.setRnStatus(2, radniNalogDb.getRN(tekuciRN.getTekuciRN().getRn()));
        }
    }//GEN-LAST:event_jButtonOtkaziRNActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        print();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItemPreletiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPreletiActionPerformed
        preletnaMasaFrame.setVisible(true);
        preletnaMasaFrame.setMb(mb);
        preletnaMasaFrame.getPreleti();
    }//GEN-LAST:event_jMenuItemPreletiActionPerformed

    private void jMenuItemZbirniParametriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemZbirniParametriActionPerformed
        zbirniParametriFrame.setVisible(true);
        zbirniParametriFrame.setMb(mb);
        zbirniParametriFrame.getZbirniParametri();
    }//GEN-LAST:event_jMenuItemZbirniParametriActionPerformed

    private void jMenuItemStanjeZalihaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemStanjeZalihaActionPerformed
        stanjeZalihaFrame.setMb(mb);
        stanjeZalihaFrame.setVisible(true);
    }//GEN-LAST:event_jMenuItemStanjeZalihaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void korigovanoF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_korigovanoF1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_korigovanoF1MouseClicked

    private void korigovanoF2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_korigovanoF2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_korigovanoF2MouseClicked

    private void korigovanoF4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_korigovanoF4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_korigovanoF4MouseClicked

    private void korigovanaVodaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_korigovanaVodaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_korigovanaVodaMouseClicked

    private void jCheckBoxAktivnaKorekcijaPoVlagiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAktivnaKorekcijaPoVlagiActionPerformed
        if (pogon.getOstalo().isAktivnaKorekcijapoVlagi()) {
            mb.writeMX(false, pogon.getOstalo().getAktivnaKorekcijapoVlagiAdresa());
        } else {
            mb.writeMX(true, pogon.getOstalo().getAktivnaKorekcijapoVlagiAdresa());
        }
    }//GEN-LAST:event_jCheckBoxAktivnaKorekcijaPoVlagiActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        sifreFrame.setVisible(true);
        sifreFrame.loadData();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItemTestUpisFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTestUpisFileActionPerformed
       createTxt(100l, "1", "2",
                            "3", "4", "5",
                            "0", "6", "7",
                            "8");
    }//GEN-LAST:event_jMenuItemTestUpisFileActionPerformed

    private void getDataForManual() {
        rucniRad.setDataFromModbus(this.pogon);
    }

    private void writeManuelInBase() {
        getElements(rucniRad.getSilos1());
        getElements(rucniRad.getSilos2());
        getElements(rucniRad.getAditiv1());
        getElements(rucniRad.getAditiv2());
        getElements(rucniRad.getFrakcija1());
        getElements(rucniRad.getFrakcija2());
        getElements(rucniRad.getFrakcija3());
        getElements(rucniRad.getFrakcija4());
        getElements(rucniRad.getMesalicaOtvaranje());
        getElements(rucniRad.getMesalicaZatvaranje());
        getElements(rucniRad.getVagaAditiv());
        getElements(rucniRad.getVagaCement());
        getElements(rucniRad.getVagaFrakcije());
        getElements(rucniRad.getVoda());
        getElements(rucniRad.getVodaVaga());
        getElements(rucniRad.getVodaKaAditivu());
        getElements(rucniRad.getVagaAditiv());
    }

    private void getElements(RucniRadElement element) {
        rucniRad.isChangeState(element);
        if (element.getTrebaUpisatiUBazu()) {
            try {
                rucniRadDb.addRecord(element.getOpisZaBazu(), element.getVrednostTrenutnaStara());
                element.setTrebaUpisatiUBazu(false);
            } catch (Exception e) {

            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private eu.hansolo.steelseries.extras.Led DIVagaAditivZatvorena;
    private eu.hansolo.steelseries.extras.Led DIVagaCementZatvorena;
    private eu.hansolo.steelseries.extras.Led DIVagaMesalicaOtvorena;
    private eu.hansolo.steelseries.extras.Led DIVagaMesalicaPrazna;
    private eu.hansolo.steelseries.extras.Led DIVagaMesalicaPuna;
    private eu.hansolo.steelseries.extras.Led DIVagaMesalicaZatvorena;
    private eu.hansolo.steelseries.extras.Led DIVagaVodaZatvorena;
    private javax.swing.JLabel DOAditiv1;
    private javax.swing.JLabel DOAditiv2;
    private javax.swing.JLabel DOAgregat0_4;
    private javax.swing.JLabel DOAgregat16_32;
    private javax.swing.JLabel DOAgregat4_8;
    private javax.swing.JLabel DOAgregat8_16;
    private javax.swing.JLabel DOCement1;
    private javax.swing.JLabel DOCement2;
    private javax.swing.JLabel DOCementVaga;
    private eu.hansolo.steelseries.extras.Led DOHidropumpaUkljuci;
    private javax.swing.JLabel DOMesalicaMixer;
    private javax.swing.JLabel DOMesalicaOtvori;
    private javax.swing.JLabel DOMesalicaZatvori;
    private javax.swing.JLabel DOMesalicaZatvori1;
    private eu.hansolo.steelseries.extras.Led DOMesalicuUkljuci;
    private javax.swing.JLabel DORucnuAutomatski;
    private javax.swing.JLabel DOTraka1;
    private javax.swing.JLabel DOTraka2;
    private javax.swing.JLabel DOTrakaHorizontalnoA;
    private javax.swing.JLabel DOTrakaHorizontalnoB;
    private javax.swing.JLabel DOTrakaKosoA;
    private javax.swing.JLabel DOTrakaKosoB;
    private javax.swing.JLabel DOVagaAditiv;
    private javax.swing.JLabel DOVagaVoda;
    private javax.swing.JLabel DOVoda;
    private javax.swing.JLabel DOVodaIspiranjeVageAditiva;
    private javax.swing.JLabel IzdoziranoAditiv;
    private javax.swing.JLabel IzdoziranoAgregati;
    private javax.swing.JLabel IzdoziranoCement;
    private javax.swing.JLabel IzdoziranoVoda;
    private eu.hansolo.steelseries.gauges.DisplayRectangular MWAditivVaga;
    private eu.hansolo.steelseries.gauges.DisplayRectangular MWCementVaga;
    private eu.hansolo.steelseries.gauges.DisplayRectangular MWStrujaMesalice;
    private eu.hansolo.steelseries.gauges.DisplayRectangular MWTrakaAgregat;
    private eu.hansolo.steelseries.gauges.DisplayRectangular MWVlagaBetona;
    private eu.hansolo.steelseries.gauges.DisplayRectangular MWVodaVaga;
    private eu.hansolo.steelseries.gauges.DisplaySingle MWVremeMesanja;
    private eu.hansolo.steelseries.gauges.DisplaySingle MWVremePraznjenja;
    private javax.swing.JLabel MWheaderIzdato0_4;
    private javax.swing.JLabel MWheaderIzdato0_4Ukupno;
    private javax.swing.JLabel MWheaderIzdato16_32;
    private javax.swing.JLabel MWheaderIzdato16_32Ukupno;
    private javax.swing.JLabel MWheaderIzdato4_8;
    private javax.swing.JLabel MWheaderIzdato4_8Ukupno;
    private javax.swing.JLabel MWheaderIzdato8_16;
    private javax.swing.JLabel MWheaderIzdato8_16Ukupno;
    private javax.swing.JLabel MWheaderIzdatoAditiv1;
    private javax.swing.JLabel MWheaderIzdatoAditiv1Ukupno;
    private javax.swing.JLabel MWheaderIzdatoAditiv2;
    private javax.swing.JLabel MWheaderIzdatoAditiv2Ukupno;
    private javax.swing.JLabel MWheaderIzdatoBrSarze;
    private javax.swing.JLabel MWheaderIzdatoCement;
    private javax.swing.JLabel MWheaderIzdatoCementUkupno;
    private javax.swing.JLabel MWheaderIzdatoFiler;
    private javax.swing.JLabel MWheaderIzdatoFilerUkupno;
    private javax.swing.JLabel MWheaderIzdatoUkupno;
    private javax.swing.JLabel MWheaderIzdatoVoda;
    private javax.swing.JLabel MWheaderIzdatoVodaUkupno;
    private javax.swing.JLabel MWheaderZadato0_4;
    private javax.swing.JLabel MWheaderZadato16_32;
    private javax.swing.JLabel MWheaderZadato4_8;
    private javax.swing.JLabel MWheaderZadato8_16;
    private javax.swing.JLabel MWheaderZadatoAditiv1;
    private javax.swing.JLabel MWheaderZadatoAditiv2;
    private javax.swing.JLabel MWheaderZadatoBrSarzi;
    private javax.swing.JLabel MWheaderZadatoCement;
    private javax.swing.JLabel MWheaderZadatoFiler;
    private javax.swing.JLabel MWheaderZadatoVoda;
    private javax.swing.JLabel OpisRucnoAutomatski;
    private javax.swing.JRadioButton SelectedSilos1;
    private javax.swing.JRadioButton SelectedSilos2;
    private javax.swing.JLabel background;
    private javax.swing.JCheckBox blokadaOtvaranjaMesalice;
    private javax.swing.ButtonGroup buttonGroup1;
    private eu.hansolo.steelseries.extras.Clock clock1;
    private javax.swing.JLabel controlPanel;
    private javax.swing.JLabel controlPanelOpisAlarm;
    private javax.swing.JLabel fluidizacijaSilosa1;
    private javax.swing.JLabel fluidizacijaSilosa2;
    private javax.swing.JButton jButtonNovaOtprema;
    private javax.swing.JButton jButtonOtkaziOtpremu;
    private javax.swing.JButton jButtonOtkaziRN;
    private javax.swing.JButton jButtonStartCiklus;
    private javax.swing.JButton jButtonStopCiklusa;
    private javax.swing.JCheckBox jCheckBoxAktivnaKorekcijaPoVlagi;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItemPreleti;
    private javax.swing.JMenuItem jMenuItemStanjeZaliha;
    private javax.swing.JMenuItem jMenuItemTestUpisFile;
    private javax.swing.JMenuItem jMenuItemZbirniParametri;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private eu.hansolo.steelseries.gauges.DisplayRectangular korigovanaVoda;
    private eu.hansolo.steelseries.gauges.DisplayRectangular korigovanoF1;
    private eu.hansolo.steelseries.gauges.DisplayRectangular korigovanoF2;
    private eu.hansolo.steelseries.gauges.DisplayRectangular korigovanoF4;
    private javax.swing.JLabel kosaTrakaJePrazna;
    private eu.hansolo.steelseries.extras.LightBulb lightBulbAlarm;
    private eu.hansolo.steelseries.extras.Led mesalicuOtvori;
    private eu.hansolo.steelseries.extras.Led mesalicuZatvori;
    private javax.swing.JLabel opisAditiv1;
    private javax.swing.JLabel opisAditiv2;
    private javax.swing.JLabel opisAgregat0_4;
    private javax.swing.JLabel opisAgregat16_32;
    private javax.swing.JLabel opisAgregat4_8;
    private javax.swing.JLabel opisAgregat8_16;
    private javax.swing.JLabel opisCement1;
    private javax.swing.JLabel opisCement2;
    private javax.swing.JLabel opisHeader0_4;
    private javax.swing.JLabel opisHeader16_32;
    private javax.swing.JLabel opisHeader4_8;
    private javax.swing.JLabel opisHeader8_16;
    private javax.swing.JLabel opisHeaderAditiv1;
    private javax.swing.JLabel opisHeaderAditiv2;
    private javax.swing.JLabel opisHeaderBrojSarzi;
    private javax.swing.JLabel opisHeaderCement1;
    private javax.swing.JLabel opisHeaderFiler;
    private javax.swing.JLabel opisHeaderVoda;
    private javax.swing.JLabel opisHidropumpa;
    private javax.swing.JLabel opisHidropumpa1;
    private javax.swing.JLabel opisIzdato;
    private javax.swing.JLabel opisIzdato1;
    private javax.swing.JLabel opisMesalicaUkljucena;
    private javax.swing.JLabel opisVagaAditivZatvorena;
    private javax.swing.JLabel opisVagaCementZatvorena;
    private javax.swing.JLabel opisVagaMesalicaPrazna;
    private javax.swing.JLabel opisVagaMesalicaPuna;
    private javax.swing.JLabel opisVagaOtvorena;
    private javax.swing.JLabel opisVagaOtvorena1;
    private javax.swing.JLabel opisVagaOtvorena2;
    private javax.swing.JLabel opisVagaVodaZatvorena;
    private javax.swing.JLabel opisVagaZatvorena;
    private javax.swing.JLabel opisVlaga;
    private javax.swing.JLabel opisVlaga1;
    private javax.swing.JLabel opisVoda;
    private javax.swing.JLabel opisZadato;
    private javax.swing.JLabel otpremaZavrsena;
    private javax.swing.JLabel priremenoZadataKolicinaF1;
    private javax.swing.JLabel priremenoZadataKolicinaF1F2;
    private javax.swing.JLabel priremenoZadataKolicinaF1F2F3;
    private javax.swing.JLabel priremenoZadataKolicinaF1F2F3F4;
    private javax.swing.JButton shorcutAktivniRadniNaloti;
    private eu.hansolo.steelseries.gauges.Linear silos1Aditiv;
    private eu.hansolo.steelseries.gauges.Linear silos1Cement;
    private eu.hansolo.steelseries.gauges.Linear silos2Aditiv;
    private eu.hansolo.steelseries.gauges.Linear silos2Cement;
    private eu.hansolo.steelseries.gauges.Linear silosAgregat04;
    private eu.hansolo.steelseries.gauges.Linear silosAgregat1632;
    private eu.hansolo.steelseries.gauges.Linear silosAgregat48;
    private eu.hansolo.steelseries.gauges.Linear silosAgregat816;
    private javax.swing.JLabel tekucaMarkaBetona;
    private javax.swing.JLabel tekuceGradiliste;
    private javax.swing.JLabel tekuceIsporuceno;
    private javax.swing.JLabel tekucePreostalo;
    private javax.swing.JLabel tekuceTablicaVozila;
    private javax.swing.JLabel tekuceTrenutno;
    private javax.swing.JLabel tekuceUgovoreno;
    private javax.swing.JLabel tekuceVozac;
    private javax.swing.JLabel tekuceZadato;
    private javax.swing.JLabel tekuciBrojRN;
    private javax.swing.JLabel tekuciKupac;
    private eu.hansolo.steelseries.extras.TrafficLight2 trafficLight21;
    private javax.swing.JLabel vibratorFrakcija1;
    private javax.swing.JLabel vibratorTrake;
    private javax.swing.JLabel vibratorVagaCementa;
    private javax.swing.JButton vodaMinus;
    private javax.swing.JButton vodaPlus;
    private javax.swing.JLabel vodaPlusMinus;
    private javax.swing.JCheckBox zadrziPodatke;
    // End of variables declaration//GEN-END:variables

    private final Pogon pogon;
    private Timer timer;
    private Point p;
    private final Image img;
    private final EntityManagerFactory emf;
    private final BrSarzi brSarzi;
    private final TekuciRN tekuciRN;

    //frame
    private final SifreFrame sifreFrame;
    private final StanjeZalihaFrame stanjeZalihaFrame;
    private final PreletnaMasaFrame preletnaMasaFrame;
    private final NovaOtpremaFrame novaOtpremaFrame;
    private final AktivniRadniNaloziFrame aktivniRadniNaloziFrame;
    private final ZbirniParametriFrame zbirniParametriFrame;

    //print
    private final OtpremnicaStampa otpremnicaStampa;

    //comand screen
    private final KomandniProzor screenTraka1 = null;
    private final KomandniProzor screenTraka2 = null;
    private final KomandniProzor screenHidropumpa = null;
    private final KomandniProzor screenMesalica = null;
    private final KomandniProzorTip3 screenTariranjeVageFrakcije = null;
    private final KomandniProzorTip3 screenTariranjeVageCement = null;
    private final KomandniProzorTip3 screenTariranjeVageAditiv = null;
    private final KomandniProzorTip3 screenTariranjeVageVoda = null;


    //modbus
    private Buff mb;
    private final String ipAdresa;
    private final int mw;
    private final int mx;

    //dbService
    private final ZbirniParametriService zbirniParametriDb;
    private final PreletiService preletiDb;
    private final MarkaBetonaService markaBetonaDb;
    private final StanjeZalihaService stanjeZalihaDb;
    private final RadniNalogService radniNalogDb;
    private final OtpremaService otpremaDb;
    private final SarzaService sarzaDb;
    private final SifreService sifreDb;
    private final RucniRadService rucniRadDb;

    //baza
    private int writeSarzaInDb = 0;

    private float tekuceIzdatoOtpremaM3;

    //rucni rad
    private RucniRad rucniRad;
    private final RucniRadOtprema rucniRadOtprema;

    //buffer za podatke
    String buffZadato0_4;
    String buffIzdato0_4;
    String buffZadato4_8;
    String buffIzdato4_8;
    String buffZadato8_16;
    String buffIzdato8_16;
    String buffZadato16_32;
    String buffIzdato16_32;
    String buffZadatoCement;
    String buffIzdatoCement;
    String buffZadatoFiler;
    String buffIzdatoFiler;
    String buffZadatoAditiv1;
    String buffIzdatoAditiv1;
    String buffZadatoAditiv2;
    String buffIzdatoAditiv2;
    String buffZadatoVoda;
    String buffIzdatoVoda;

    String buffIzdato0_4Ukupno;
    String buffIzdato4_8Ukupno;
    String buffIzdato8_16Ukupno;
    String buffIzdato16_32Ukupno;
    String buffIzdatoCementUkupno;
    String buffIzdatoFilerUkupno;
    String buffIzdatoAditiv1Ukupno;
    String buffIzdatoAditiv2Ukupno;
    String buffIzdatoVodaUkupno;

    //private MainForm newJFrame;
    public void screenRefresh() {
        timer = new Timer(200, new ActionListener() {  //1000 1 sec
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTekuciRNOtprema();
                refreshAgregat();
                refreshCement();
                refreshFiler();
                refreshVoda();
                refreshAditiv();
                refreshOstalo();
                refreshVage();
                refreshTrake();
                refreshMesalica();
                refreshDisplay();
                refreshRucniRadOtprema();
                refreshAlarm();
                refreshCom();
                writeDataOnBuffer();
                writeInDb();
                getDataForManual();
                writeManuelInBase();
                writeInDbRucniRad();
            }
        });
        timer.start();
    }

    private void refreshTekuciRNOtprema() {
        if (tekuciRN.isReadiTekuciRN()) {
            try {
                tekuciBrojRN.setText(Long.toString(tekuciRN.getTekuciRN().getRn()));
                tekucaMarkaBetona.setText(tekuciRN.getTekuciRN().getMarkabetona());
                tekuciKupac.setText(tekuciRN.getTekuciRN().getKupac());
                tekuceGradiliste.setText(tekuciRN.getTekuciRN().getGradiliste());
                tekuceUgovoreno.setText(Float.toString(tekuciRN.getTekuciRN().getUgovorenom3()));
                tekuceIsporuceno.setText(Float.toString((float) Convert.round2Decimal(tekuciRN.getTekuciRN().getIsporucenom3())));
                tekucePreostalo.setText(Float.toString((float) Convert.round2Decimal(tekuciRN.getTekuciRN().getUgovorenom3() - tekuciRN.getTekuciRN().getIsporucenom3())));
                tekuciRN.setReadiTekuciRN(false);
            } catch (Exception ex) {

            }
        }
        if (tekuciRN.isReadiTekucaOtp()) {
            try {
                tekuceTablicaVozila.setText(tekuciRN.getTekucaOtp().getVozilo());
                tekuceVozac.setText(tekuciRN.getTekucaOtp().getVozac());
                tekuceZadato.setText(Float.toString(tekuciRN.getTekucaOtp().getZadatom3()));
                tekuceTrenutno.setText(Float.toString(tekuciRN.getTekucaOtp().getIzdatom3()));
                //vodaPlusMinus.setText(MWheaderZadatoVoda.getText());
                tekuciRN.setReadiTekucaOtp(false);

            } catch (Exception ex) {

            }
        }
        if (novaOtpremaFrame.upisiPodatke) {

            mb.writeMWsPlusTwoRegisters(novaOtpremaFrame.setParametars(), 0, pogon.getMesalica().getVremeMesanjaSet(), pogon.getMesalica().getVremeMesanjaAdresa(),
                    pogon.getMesalica().getVremePraznjenjaSet(), pogon.getMesalica().getVremePraznjenjaAdresa());
            novaOtpremaFrame.upisiPodatke = false;
        }
    }
    
    private void refreshRucniRadOtprema() {
        if (!pogon.getOstalo().getRucnoAutomatski().getKomanda()) {
            
            rucniRadOtprema.setDataSilos(pogon.getAgregat0_4().getKomanda().getKomanda(), rucniRadOtprema.getFrakcija1(), pogon.getTraka().getTezina(), pogon.getTraka().getBrDec());
            rucniRadOtprema.setDataSilos(pogon.getAgregat4_8().getKomanda().getKomanda(), rucniRadOtprema.getFrakcija2(), pogon.getTraka().getTezina(), pogon.getTraka().getBrDec());
            rucniRadOtprema.setDataSilos(pogon.getAgregat8_16().getKomanda().getKomanda(), rucniRadOtprema.getFrakcija3(), pogon.getTraka().getTezina(), pogon.getTraka().getBrDec());
            rucniRadOtprema.setDataSilos(pogon.getAgregat16_32().getKomanda().getKomanda(), rucniRadOtprema.getFrakcija4(), pogon.getTraka().getTezina(), pogon.getTraka().getBrDec());
            rucniRadOtprema.setDataVaga(pogon.getTraka().getRunTraka1().getKomanda(), rucniRadOtprema.getVagaFrakcije(), pogon.getTraka().getTezina(), pogon.getTraka().getBrDec());

            rucniRadOtprema.setDataSilos(pogon.getCement().getKomanda().getKomanda(), rucniRadOtprema.getSilos1(), pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec());
            rucniRadOtprema.setDataSilos(pogon.getFiler().getKomanda().getKomanda(), rucniRadOtprema.getSilos2(), pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec());
            rucniRadOtprema.setDataVaga(pogon.getVagaCement().getKomanda().getKomanda(), rucniRadOtprema.getVagaCement(), pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec());

            rucniRadOtprema.setDataSilos(pogon.getVoda().getKomanda().getKomanda(), rucniRadOtprema.getVoda(), pogon.getVagaVoda().getTezina(), pogon.getVagaVoda().getBrDec());
            rucniRadOtprema.setDataVaga(pogon.getVagaVoda().getKomanda().getKomanda(), rucniRadOtprema.getVodaVaga(), pogon.getVagaVoda().getTezina(), pogon.getVagaVoda().getBrDec());

            rucniRadOtprema.setDataSilos(pogon.getAditiv1().getKomanda().getKomanda(), rucniRadOtprema.getAditiv1(), pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec());
            rucniRadOtprema.setDataSilos(pogon.getAditiv2().getKomanda().getKomanda(), rucniRadOtprema.getAditiv2(), pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec());
            rucniRadOtprema.setDataVaga(pogon.getVagaAditiv().getKomanda().getKomanda(), rucniRadOtprema.getVagaAditiv(), pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec());
        }
    }

    private void refreshDisplay() {
        MWheaderIzdato0_4Ukupno.setText(Convert.shiftPoint(pogon.getZbirnaFrakcija1(), 0));
        MWheaderIzdato4_8Ukupno.setText(Convert.shiftPoint(pogon.getZbirnaFrakcija2(), 0));
        MWheaderIzdato8_16Ukupno.setText(Convert.shiftPoint(pogon.getZbirnaFrakcija3(), 0));
        MWheaderIzdato16_32Ukupno.setText(Convert.shiftPoint(pogon.getZbirnaFrakcija4(), 0));
        MWheaderIzdatoCementUkupno.setText(Convert.shiftPoint(pogon.getZbirniCement(), 0));
        MWheaderIzdatoFilerUkupno.setText(Convert.shiftPoint(pogon.getZbirniFiler(), 0));
        MWheaderIzdatoAditiv1Ukupno.setText(Convert.shiftPoint(pogon.getZbirniAditiv1(), 2));
        MWheaderIzdatoAditiv2Ukupno.setText(Convert.shiftPoint(pogon.getZbirniAditiv2(), 2));
        MWheaderIzdatoVodaUkupno.setText(Convert.shiftPoint(pogon.getZbirnaVoda(), 0));

        double ukupno = Convert.shiftPointDouble(pogon.getZbirnaFrakcija1(), 0) + Convert.shiftPointDouble(pogon.getZbirnaFrakcija2(), 0)
                + Convert.shiftPointDouble(pogon.getZbirnaFrakcija3(), 0) + Convert.shiftPointDouble(pogon.getZbirnaFrakcija4(), 0)
                + Convert.shiftPointDouble(pogon.getZbirniCement(), 0) + Convert.shiftPointDouble(pogon.getZbirniFiler(), 0)
                + Convert.shiftPointDouble(pogon.getZbirniAditiv1(), 2) + Convert.shiftPointDouble(pogon.getZbirniAditiv2(), 2)
                + Convert.shiftPointDouble(pogon.getZbirnaVoda(), 0);

        MWheaderIzdatoUkupno.setText(Convert.doubleToString(ukupno));

        int a = pogon.getAgregat0_4().getZadato();
        int b = a + pogon.getAgregat4_8().getZadato();
        int c = b + pogon.getAgregat8_16().getZadato();
        int d = c + pogon.getAgregat16_32().getZadato();

        priremenoZadataKolicinaF1.setText(Convert.shiftPoint(a, 0));
        priremenoZadataKolicinaF1F2.setText(Convert.shiftPoint(b, 0));
        priremenoZadataKolicinaF1F2F3.setText(Convert.shiftPoint(c, 0));
        priremenoZadataKolicinaF1F2F3F4.setText(Convert.shiftPoint(d, 0));
        tekuceTrenutno.setText(getTrenutnaKolicinaBeton());

        MWheaderZadatoBrSarzi.setText(Integer.toString(brSarzi.getZadatiBrojSarzi()));

        korigovanoF1.setValue(pogon.getOstalo().getKorigovanoF1());
        korigovanaVoda.setValue(pogon.getOstalo().getKorigovanaVoda());
        jCheckBoxAktivnaKorekcijaPoVlagi.setSelected(pogon.getOstalo().isAktivnaKorekcijapoVlagi());

    }

    private void writeInDb() {
        if (!pogon.getOstalo().getSarzaZavrsena()) {
            writeSarzaInDb = 0;
            
        }
 
        if (pogon.getOstalo().getSarzaZavrsena()) {
              mb.writeMX(false, pogon.getOstalo().getSarzaZavrsenaAdresa());
            
              if (writeSarzaInDb == 0) {
                writeSarzaInDb++;
                try {
                    
                    tekuceIzdatoOtpremaM3 = tekuciRN.getTekuciRN().getIsporucenom3();
                    
                    sarzaDb.addSarza(tekuciRN.getTekuciRN(), tekuciRN.getTekucaOtp(),
                            buffZadato0_4, buffIzdato0_4, buffZadato4_8, buffIzdato4_8, buffZadato8_16,
                            buffIzdato8_16, buffZadato16_32, buffIzdato16_32, buffZadatoCement,
                            buffIzdatoCement, buffZadatoFiler, buffIzdatoFiler, buffZadatoAditiv1,
                            buffIzdatoAditiv1, buffZadatoAditiv2, buffIzdatoAditiv2, buffZadatoVoda, buffIzdatoVoda);

                    otpremaDb.isporuceno((float) (Convert.shiftPointDouble(pogon.getParametri().getKapacitetMesalice(), 1) + otpremaDb.getIsporuceno()));
                    radniNalogDb.setIsporucenoBetona(tekuciRN.getTekuciRN(), (float) (Convert.shiftPointDouble(pogon.getParametri().getKapacitetMesalice(), 1) + tekuceIzdatoOtpremaM3));
                    
                    
                    if(SelectedSilos1.isSelected()){
                        setStanjeZaliha(MWheaderIzdatoCement.getText(), "0",
                            MWheaderIzdato0_4.getText(),MWheaderIzdato4_8.getText(), MWheaderIzdato8_16.getText(),
                            MWheaderIzdatoAditiv1.getText(), MWheaderIzdatoAditiv2.getText(), MWheaderIzdato16_32.getText());
                    }
                    
                    if(SelectedSilos2.isSelected()){
                        setStanjeZaliha("0", MWheaderIzdatoCement.getText(),
                            MWheaderIzdato0_4.getText(),MWheaderIzdato4_8.getText(), MWheaderIzdato8_16.getText(),
                            MWheaderIzdatoAditiv1.getText(), MWheaderIzdatoAditiv2.getText(), MWheaderIzdato16_32.getText());
                    }

                    if (Integer.parseInt(MWheaderIzdatoBrSarze.getText()) == Integer.parseInt(MWheaderZadatoBrSarzi.getText())) {
                        createTxt(tekuciRN.getTekuciRN().getRn(), buffIzdato0_4Ukupno, buffIzdato4_8Ukupno,
                            buffIzdato8_16Ukupno, buffIzdato16_32Ukupno, buffIzdatoCementUkupno,
                            buffIzdatoFilerUkupno, buffIzdatoAditiv1Ukupno, buffIzdatoAditiv2Ukupno,
                            buffIzdatoVodaUkupno);
                        print();
                    }
                } catch (Exception e) {
                    System.out.println("Nije upisao u bazu");
                }

            }
        } 
        if (pogon.getOstalo().getOtpremaZavrsena() && !pogon.getOstalo().getSarzaZavrsena()) {
            tekuceTrenutno.setText(Convert.shiftPoint(pogon.getZadatoIzdoziranoBeton().getTrenutnaKolicinaBetona(), pogon.getZadatoIzdoziranoBeton().getTrenutnaKolicinaBetonaBrDec()));
        }
    }
    
     private void writeInDbRucniRad() {
        if (rucniRadOtprema.isUpisiUDB()) {
            rucniRadOtprema.setUpisiUDB(false);
            try {

                JLabel izdato0_4 = new JLabel();
                izdato0_4.setText(Convert.getRoundDouble(rucniRadOtprema.getFrakcija1().getVrednost(), 0));
                JLabel izdato4_8 = new JLabel();
                izdato4_8.setText(Convert.getRoundDouble((rucniRadOtprema.getFrakcija2().getVrednost()), 0));
                JLabel izdato8_16 = new JLabel();
                izdato8_16.setText(Convert.getRoundDouble(rucniRadOtprema.getFrakcija3().getVrednost(), 0));
                JLabel izdato16_32 = new JLabel();
                izdato16_32.setText(Convert.getRoundDouble(rucniRadOtprema.getFrakcija4().getVrednost(), 0));
                JLabel izdatoCement = new JLabel();
                izdatoCement.setText(Convert.getRoundDouble((rucniRadOtprema.getSilos1().getVrednost() + rucniRadOtprema.getSilos2().getVrednost()), 0));
                JLabel izdatoA1 = new JLabel();
                izdatoA1.setText(Convert.getRoundDouble((rucniRadOtprema.getAditiv1().getVrednost()), 2));
                JLabel izdatoA2 = new JLabel();
                izdatoA2.setText(Convert.getRoundDouble((rucniRadOtprema.getAditiv2().getVrednost()), 2));
                JLabel izdatoVoda = new JLabel();
                izdatoVoda.setText(Convert.getRoundDouble((rucniRadOtprema.getVoda().getVrednost()), 0));

                tekuceIzdatoOtpremaM3 = tekuciRN.getTekuciRN().getIsporucenom3();
                
                sarzaDb.addSarza(tekuciRN.getTekuciRN(), tekuciRN.getTekucaOtp(),
                        izdato0_4.getText(), izdato0_4.getText(),
                        izdato4_8.getText(), izdato4_8.getText(),
                        izdato8_16.getText(), izdato8_16.getText(),
                        izdato16_32.getText(), izdato16_32.getText(),
                        izdatoCement.getText(), izdatoCement.getText(),
                        "0", "0",
                        izdatoA1.getText(), izdatoA1.getText(),
                        izdatoA2.getText(), izdatoA2.getText(),
                        izdatoVoda.getText(), izdatoVoda.getText());

                double isporuceno = (
                        rucniRadOtprema.getFrakcija1().getVrednost() +  rucniRadOtprema.getFrakcija2().getVrednost() +
                        rucniRadOtprema.getFrakcija3().getVrednost() +  rucniRadOtprema.getFrakcija4().getVrednost() +
                        rucniRadOtprema.getSilos1().getVrednost() + rucniRadOtprema.getSilos2().getVrednost() +
                        rucniRadOtprema.getAditiv1().getVrednost() + rucniRadOtprema.getAditiv2().getVrednost() + 
                        rucniRadOtprema.getVoda().getVrednost())*0.001;

                
                //otpremaDb
                otpremaDb.isporuceno((float) isporuceno + otpremaDb.getIsporuceno());
                radniNalogDb.setIsporucenoBetona(tekuciRN.getTekuciRN(), (float) (isporuceno) + tekuceIzdatoOtpremaM3);
               
                if (SelectedSilos1.isSelected()) {
                    setStanjeZaliha(izdatoCement.getText(), "0",
                            izdato0_4.getText(), izdato4_8.getText(), izdato8_16.getText(),
                            izdatoA1.getText(), izdatoA2.getText(), izdato16_32.getText());
                }

                if (SelectedSilos2.isSelected()) {
                    setStanjeZaliha("0", izdatoCement.getText(),
                            izdato0_4.getText(), izdato4_8.getText(), izdato8_16.getText(),
                            izdatoA1.getText(), izdatoA2.getText(), izdato16_32.getText());
                }
                
                 createTxt(tekuciRN.getTekuciRN().getRn(), izdato0_4.getText(), izdato4_8.getText(),
                            izdato8_16.getText(), izdato16_32.getText(), izdatoCement.getText(),
                            "0", izdatoA1.getText(), izdatoA2.getText(),
                            izdatoVoda.getText());
                 
                 print(izdato0_4.getText(), izdato4_8.getText(),
                            izdato8_16.getText(), izdato16_32.getText(), izdatoCement.getText(),
                            "0", izdatoA1.getText(), izdatoA2.getText(),
                            izdatoVoda.getText());

            } catch (Exception e) {
                System.out.println("Nije upisao u bazu");
            }

        }
    }

    private void createTxt(Long brRadnogNaloga, String MWheaderIzdato0_4, String MWheaderIzdato4_8,
            String MWheaderIzdato8_16, String MWheaderIzdato16_32, String MWheaderIzdatoCement, String MWheaderIzdatoFiler,
            String MWheaderIzdatoAditiv1, String MWheaderIzdatoAditiv2, String MWheaderIzdatoVoda) {

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat simpleformat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String imeFila = simpleformat.format(cal.getTime());
        
        

        try {
            db.Sifre s = sifreDb.getSifre(1l);

            FileWriter myWriter = new FileWriter("C:\\BetArhiva\\" + imeFila + "_" + tekucaMarkaBetona.getText() + "_" + tekuciBrojRN.getText() + ".tab");

            String upis = "";

            if (!MWheaderIzdatoCement.matches("0")) {
                upis = upis + s.getCement() + "\t" + MWheaderIzdatoCement + "\n";
            }

            if (!MWheaderIzdato0_4.matches("0")) {
                upis = upis + s.getFrakcija04() + "\t" + MWheaderIzdato0_4 + "\n";
            }

            if (!MWheaderIzdato4_8.matches("0")) {
                upis = upis + s.getFrakcija48() + "\t" + MWheaderIzdato4_8 + "\n";
            }

            if (!MWheaderIzdato8_16.matches("0")) {
                upis = upis + s.getFrakcija816() + "\t" + MWheaderIzdato8_16 + "\n";
            }

            if (!MWheaderIzdato16_32.matches("0")) {
                upis = upis + s.getFrakcija1632() + "\t" + MWheaderIzdato16_32 + "\n";
            }

            if (!MWheaderIzdatoFiler.matches("0")) {
                upis = upis + s.getFiler() + "\t" + MWheaderIzdatoFiler + "\n";
            }

            if (!MWheaderIzdatoAditiv1.matches("0")) {
                upis = upis + s.getAditiv1() + "\t" + MWheaderIzdatoAditiv1 + "\n";
            }

            if (!MWheaderIzdatoAditiv2.matches("0")) {
                upis = upis + s.getAditiv2() + "\t" + MWheaderIzdatoAditiv2 + "\n";
            }

            myWriter.write(upis);

            myWriter.close();
            //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e);
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void refreshAgregat() {
        MWheaderZadato0_4.setText(Convert.shiftPoint(pogon.getAgregat0_4().getZadato(), pogon.getAgregat0_4().getBrDec()));
        MWheaderZadato4_8.setText(Convert.shiftPoint(pogon.getAgregat4_8().getZadato(), pogon.getAgregat4_8().getBrDec()));
        MWheaderZadato8_16.setText(Convert.shiftPoint(pogon.getAgregat8_16().getZadato(), pogon.getAgregat8_16().getBrDec()));
        MWheaderZadato16_32.setText(Convert.shiftPoint(pogon.getAgregat16_32().getZadato(), pogon.getAgregat16_32().getBrDec()));

        MWheaderIzdato0_4.setText(Convert.shiftPoint(pogon.getAgregat0_4().getIzdato(), pogon.getAgregat0_4().getBrDec()));
        MWheaderIzdato4_8.setText(Convert.shiftPoint(pogon.getAgregat4_8().getIzdato(), pogon.getAgregat4_8().getBrDec()));
        MWheaderIzdato8_16.setText(Convert.shiftPoint(pogon.getAgregat8_16().getIzdato(), pogon.getAgregat8_16().getBrDec()));
        MWheaderIzdato16_32.setText(Convert.shiftPoint(pogon.getAgregat16_32().getIzdato(), pogon.getAgregat16_32().getBrDec()));

        img.setImg(DOAgregat0_4, pogon.getAgregat0_4().getKomanda().getKomanda(), img.getKlapne());
        img.setImg(DOAgregat4_8, pogon.getAgregat4_8().getKomanda().getKomanda(), img.getKlapne());
        img.setImg(DOAgregat8_16, pogon.getAgregat8_16().getKomanda().getKomanda(), img.getKlapne());
        img.setImg(DOAgregat16_32, pogon.getAgregat16_32().getKomanda().getKomanda(), img.getKlapne());

        img.setImg(vibratorFrakcija1, pogon.getAgregat0_4().getVibracija().getKomanda(), img.getVibracija());

        silosAgregat04.setMaxValue(pogon.getAgregat0_4().getKapacitetSilos());
        silosAgregat04.setValue(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat0_4().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat0_4().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat0_4().getBrDec()));

        silosAgregat48.setMaxValue(pogon.getAgregat4_8().getKapacitetSilos());
        silosAgregat48.setValue(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat4_8().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat4_8().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat4_8().getBrDec()));

        silosAgregat816.setMaxValue(pogon.getAgregat8_16().getKapacitetSilos());
        silosAgregat816.setValue(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat8_16().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat8_16().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat8_16().getBrDec()));

        silosAgregat1632.setMaxValue(pogon.getAgregat16_32().getKapacitetSilos());
        silosAgregat1632.setValue(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat16_32().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat16_32().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat16_32().getBrDec()));

        MWheaderIzdatoBrSarze.setText(Convert.shiftPoint(pogon.getZadatoIzdoziranoBeton().getTrenutniBrojSarzi(), 0));

        //tekuceTrenutno.setText(Convert.shiftPoint(pogon.getZadatoIzdoziranoBeton().getTrenutnaKolicinaBetona(), 0));
    }

    private void refreshCement() {
        MWheaderZadatoCement.setText(Convert.shiftPoint(pogon.getCement().getZadato(), pogon.getCement().getBrDec()));
        MWheaderIzdatoCement.setText(Convert.shiftPoint(pogon.getCement().getIzdato(), pogon.getCement().getBrDec()));

        img.setImg(DOCement1, pogon.getCement().getKomanda().getKomanda(), img.getPuznePumpe());
        img.setImg(DOCement2, pogon.getFiler().getKomanda().getKomanda(), img.getPuznePumpe());
        img.setImg(fluidizacijaSilosa1, pogon.getCement().getFluidizacija().getKomanda(), img.getVibracija());
        img.setImg(fluidizacijaSilosa2, pogon.getFiler().getFluidizacija().getKomanda(), img.getVibracija());

        silos1Cement.setMaxValue(pogon.getCement().getKapacitetSilos1());
        silos1Cement.setValue(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getCement().getProcenjenaKolicinaSilos1Visi(), pogon.getCement().getProcenjenaKolicinaSilos1Nizi(), pogon.getCement().getBrDec()));

        silos2Cement.setMaxValue(pogon.getCement().getKapacitetSilos2());
        silos2Cement.setValue(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getCement().getProcenjenaKolicinaSilos2Visi(), pogon.getCement().getProcenjenaKolicinaSilos2Nizi(), pogon.getCement().getBrDec()));

    }

    private void refreshFiler() {
        MWheaderZadatoFiler.setText(Convert.shiftPoint(pogon.getFiler().getZadato(), pogon.getFiler().getBrDec()));
        MWheaderIzdatoFiler.setText(Convert.shiftPoint(pogon.getFiler().getIzdato(), pogon.getFiler().getBrDec()));

        //pogon.getSelektorSilosa().setKolicinaFilera(Convert.stringToDouble(markaBetonaDb.getFiler().getText()));
        if (pogon.getSelektorSilosa().isUseFiler()) {
            SelectedSilos2.setVisible(false);
            SelectedSilos1.setVisible(false);
            opisCement1.setText("Filer");
            opisCement2.setText("Cement");

        } else {
            SelectedSilos2.setVisible(true);
            SelectedSilos1.setVisible(true);
            opisCement1.setText("Cement 1");
            opisCement2.setText("Cement 2");
        }
    }

    private void refreshVoda() {
        MWheaderZadatoVoda.setText(Convert.shiftPoint(pogon.getVoda().getZadato(), pogon.getVoda().getBrDec()));
        MWheaderIzdatoVoda.setText(Convert.shiftPoint(pogon.getVoda().getIzdato(), pogon.getVoda().getBrDec()));

        vodaPlusMinus.setText(MWheaderZadatoVoda.getText());

        img.setImg(DOVoda, pogon.getVoda().getKomanda().getKomanda(), img.getKlapne());
        img.setImg(DOVodaIspiranjeVageAditiva, pogon.getVoda().getIspiranjeVageAditiva().getKomanda(), img.getKlapne());

    }

    private void refreshAditiv() {
        MWheaderZadatoAditiv1.setText(Convert.shiftPoint(pogon.getAditiv1().getZadato(), pogon.getAditiv1().getBrDec()));
        MWheaderZadatoAditiv2.setText(Convert.shiftPoint(pogon.getAditiv2().getZadato(), pogon.getAditiv2().getBrDec()));

        MWheaderIzdatoAditiv1.setText(Convert.shiftPoint(pogon.getAditiv1().getIzdato(), pogon.getAditiv1().getBrDec()));
        MWheaderIzdatoAditiv2.setText(Convert.shiftPoint(pogon.getAditiv2().getIzdato(), pogon.getAditiv2().getBrDec()));

        img.setImg(DOAditiv1, pogon.getAditiv1().getKomanda().getKomanda(), img.getPumpe());
        img.setImg(DOAditiv2, pogon.getAditiv2().getKomanda().getKomanda(), img.getPumpe());

        silos1Aditiv.setMaxValue(pogon.getAditiv1().getKapacitetSilos());
        silos1Aditiv.setValue(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAditiv1().getProcenjenaKolicinaSilosVisi(), pogon.getAditiv1().getProcenjenaKolicinaSilosNizi(), pogon.getAditiv1().getBrDec()));

        silos2Aditiv.setMaxValue(pogon.getAditiv2().getKapacitetSilos());
        silos2Aditiv.setValue(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAditiv2().getProcenjenaKolicinaSilosVisi(), pogon.getAditiv2().getProcenjenaKolicinaSilosNizi(), pogon.getAditiv2().getBrDec()));
    }

    private void refreshOstalo() {
        img.setImg(DORucnuAutomatski, pogon.getOstalo().getRucnoAutomatski().getKomanda(), img.getRucnoAutomatski());
        DOHidropumpaUkljuci.setLedOn(pogon.getOstalo().getHidropumpaUkljucena().getKomanda());
        MWVlagaBetona.setValue(Convert.shiftPointDouble(pogon.getOstalo().getVlaznostBetona(), pogon.getOstalo().getVlaznostBetonaBrDec()));

        otpremaZavrsena.setVisible(pogon.getOstalo().getOtpremaZavrsena());
        if (pogon.getOstalo().getOtpremaZavrsena()) {
            trafficLight21.setGreenOn(true);
            trafficLight21.setRedOn(false);
        } else {
            trafficLight21.setRedOn(true);
            trafficLight21.setGreenOn(false);
        }

        if (pogon.getOstalo().getRucnoAutomatski().getKomanda()) {
            jButtonStartCiklus.setEnabled(true);
            jButtonStopCiklusa.setEnabled(true);
        } else {
            jButtonStartCiklus.setEnabled(false);
            jButtonStopCiklusa.setEnabled(false);
        }

        if (pogon.getOstalo().getRucnoAutomatski().getKomanda()) {
            //jToggleButtonRucnoMesanje.setEnabled(false);  branko scekic
            //jToggleButtonRucnoMesanje.setSelected(false); branko scekic
        } else {
            //jToggleButtonRucnoMesanje.setEnabled(true);   branko scekic
        }
    }

    private void refreshVage() {
        img.setImg(DOCementVaga, pogon.getVagaCement().getKomanda().getKomanda(), img.getKlapne());
        img.setImg(IzdoziranoCement, pogon.getVagaCement().getIzdozirano(), img.getDozirano());
        DIVagaCementZatvorena.setLedOn(pogon.getVagaCement().isZatvorenaVaga());
        img.setImg(vibratorVagaCementa, pogon.getVagaCement().getVibracija().getKomanda(), img.getVibracija());

        img.setImg(DOVagaAditiv, pogon.getVagaAditiv().getKomanda().getKomanda(), img.getKlapne());
        img.setImg(IzdoziranoAditiv, pogon.getVagaAditiv().getIzdozirano(), img.getDozirano());
        DIVagaAditivZatvorena.setLedOn(pogon.getVagaAditiv().isZatvorenaVaga());

        img.setImg(DOVagaVoda, pogon.getVagaVoda().getKomanda().getKomanda(), img.getKlapne());
        img.setImg(IzdoziranoVoda, pogon.getVagaVoda().getIzdozirano(), img.getDozirano());
        DIVagaVodaZatvorena.setLedOn(pogon.getVagaVoda().isZatvorenaVaga());

        MWCementVaga.setValue(Convert.shiftPointDouble(pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec()));
        MWVodaVaga.setValue(Convert.shiftPointDouble(pogon.getVagaVoda().getTezina(), pogon.getVagaVoda().getBrDec()));
        MWAditivVaga.setValue(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));

        if (pogon.getVagaCement().getVagaPuna()) {
            MWCementVaga.setLcdColor(LcdColor.GREEN_LCD);
        } else {
            MWCementVaga.setLcdColor(LcdColor.WHITE_LCD);
        }

        if (pogon.getVagaVoda().getVagaPuna()) {
            MWVodaVaga.setLcdColor(LcdColor.GREEN_LCD);
        } else {
            MWVodaVaga.setLcdColor(LcdColor.WHITE_LCD);
        }

        if (pogon.getVagaAditiv().getVagaPuna()) {
            MWAditivVaga.setLcdColor(LcdColor.GREEN_LCD);
        } else {
            MWAditivVaga.setLcdColor(LcdColor.WHITE_LCD);
        }

    }

    private void refreshTrake() {
        img.setImg(DOTrakaHorizontalnoA, pogon.getTraka().getRunTraka1().getKomanda(), img.getTrake());
        img.setImg(DOTrakaHorizontalnoB, pogon.getTraka().getRunTraka1().getKomanda(), img.getTrake());

        img.setImg(DOTrakaKosoA, pogon.getTraka().getRunTraka2().getKomanda(), img.getTrake());
        img.setImg(DOTrakaKosoB, pogon.getTraka().getRunTraka2().getKomanda(), img.getTrake());

        img.setImg(IzdoziranoAgregati, pogon.getTraka().isIzdozirano(), img.getDozirano());

        img.setImg(vibratorTrake, pogon.getTraka().getVibracija().getKomanda(), img.getVibracija());

        MWTrakaAgregat.setValue(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));

        if (!pogon.getTraka().getKosaTrakaPrazna()) {
            kosaTrakaJePrazna.setText("Traka nije prazna!!!");
        } else {
            kosaTrakaJePrazna.setText("Traka je prazna");
        }

    }

    private void refreshMesalica() {
        DIVagaMesalicaZatvorena.setLedOn(pogon.getMesalica().getZatvorena());
        DIVagaMesalicaOtvorena.setLedOn(pogon.getMesalica().getOtvorena());
        mesalicuOtvori.setLedOn(pogon.getMesalica().getOtvori().getKomanda());
        mesalicuZatvori.setLedOn(pogon.getMesalica().getZatvori().getKomanda());
        DIVagaMesalicaPuna.setLedOn(pogon.getMesalica().getPuna());
        DIVagaMesalicaPrazna.setLedOn(pogon.getMesalica().getPrazna());
        DOMesalicuUkljuci.setLedOn(pogon.getMesalica().getUkljucena().getKomanda());
        img.setImg(DOMesalicaMixer, pogon.getMesalica().getUkljucena().getKomanda(), img.getMesalica());
        MWVremeMesanja.setLcdValue(Convert.shiftPointDouble(pogon.getMesalica().getVremeMesanja(), 1));
        MWVremePraznjenja.setLcdValue(Convert.shiftPointDouble(pogon.getMesalica().getVremePraznjenja(), 1));
        MWStrujaMesalice.setValue(Convert.shiftPointDouble(pogon.getMesalica().getStrujaMesalice(), pogon.getMesalica().getStrujaMesaliceBrDec()));

        if (pogon.getMesalica().getBlokadaOtvaranjaMesalice().getKomanda()) {
            blokadaOtvaranjaMesalice.setSelected(true);
        } else {
            blokadaOtvaranjaMesalice.setSelected(false);
        }
    }

    private void refreshAlarm() {
        lightBulbAlarm.setOn(!Mxl.alarm);
    }

    private void refreshCom() {
        if (!Mxl.conOk) {
            mb = new Buff(pogon);
            mb.setIpAdresa(this.ipAdresa, mw, mx);
            new Thread(mb).start();
            //novaOtpremaFrame.setMb(mb);

        }
    }

    private void komandaOn(int adresa) {
        if (!pogon.getOstalo().getRucnoAutomatski().getKomanda()) {
            mb.writeMX(true, adresa);
        }

    }

    private void komandaOff(int adresa) {
        if (!pogon.getOstalo().getRucnoAutomatski().getKomanda()) {
            mb.writeMX(false, adresa);
        }
    }

    //Komandni prozor
    private KomandniProzor showScreen(KomandniProzor screen, String title, String opis, Komanda komanda) {
        p = MousePoint.getMousePoint();
        if (screen == null) {
            screen = new KomandniProzor(mb, p.x, p.y, title, opis, img, komanda, pogon.getOstalo().getRucnoAutomatski());
        } else {
            screen.dispose();
            screen.setVisible(false);
            screen = new KomandniProzor(mb, p.x, p.y, title, opis, img, komanda, pogon.getOstalo().getRucnoAutomatski());
        }
        screen.setVisible(true);

        return screen;
    }

    private KomandniProzorTip2 showScreen(KomandniProzorTip2 screen, String title, String opis, Komanda komanda, String dugme) {
        p = MousePoint.getMousePoint();
        if (screen == null) {
            screen = new KomandniProzorTip2(mb, p.x, p.y, title, opis, img, komanda, pogon.getOstalo().getRucnoAutomatski(), dugme);
        } else {
            screen.dispose();
            screen.setVisible(false);
            screen = new KomandniProzorTip2(mb, p.x, p.y, title, opis, img, komanda, pogon.getOstalo().getRucnoAutomatski(), dugme);
        }
        screen.setVisible(true);

        return screen;
    }

    private KomandniProzorTip3 showScreenTariranje(KomandniProzorTip3 screen, String title, String opis, Komanda komanda, String dugme) {
        p = MousePoint.getMousePoint();
        if (screen == null) {
            screen = new KomandniProzorTip3(mb, p.x, p.y, title, opis, img, komanda, pogon.getOstalo().getRucnoAutomatski(), dugme);
        } else {
            screen.dispose();
            screen.setVisible(false);
            screen = new KomandniProzorTip3(mb, p.x, p.y, title, opis, img, komanda, pogon.getOstalo().getRucnoAutomatski(), dugme);
        }
        screen.setVisible(true);

        return screen;
    }

    public static void showOnScreen(int screen, JFrame frame) {
        //za prikaz na displeju kod multidispleja
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gd = ge.getScreenDevices();
        if (screen > -1 && screen < gd.length) {
            frame.setLocation(gd[screen].getDefaultConfiguration().getBounds().x, frame.getY());
        } else if (gd.length > 0) {
            frame.setLocation(gd[0].getDefaultConfiguration().getBounds().x, frame.getY());
        } else {
            throw new RuntimeException("No Screens Found");
        }
    }

    private void getNewOtpremaFromRN() {
        novaOtpremaFrame.setVisible(true);
        tekuciRN.setTekuciRN(radniNalogDb.getRN(Long.parseLong(tekuciBrojRN.getText())));
        novaOtpremaFrame.fillDataForRN();
        tekuciRN.setReadiTekuciRN(true);
        if (zadrziPodatke.isSelected()) {
            //novaOtpremaFrame.getSpisakVozacOtpremnica().setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{tekuceVozac.getText()}));
            //novaOtpremaFrame.getSpisakVoziloOtpremnica().setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{tekuceTablicaVozila.getText()}));

        } else {
            //vozacDb.spisakVozacOtpremnica();
            //voziloDb.spisakVoziloOtpremnica();
        }
    }

    private void setSelectedSilos() {
        if (SelectedSilos1.isSelected()) {
            mb.writeMX(false, pogon.getSelektorSilosa().getSelektovanSilosAdresa());
        } else if (SelectedSilos2.isSelected()) {
            mb.writeMX(true, pogon.getSelektorSilosa().getSelektovanSilosAdresa());
        }
    }

    private void print() {
        otpremnicaStampa.print(tekuciRN.getTekuciRN(), tekuciRN.getTekucaOtp(), markaBetonaDb.getRecept(tekuciRN.getTekuciRN().getMarkabetona()),
                MWheaderIzdato0_4Ukupno.getText(), MWheaderIzdato4_8Ukupno.getText(),
                MWheaderIzdato8_16Ukupno.getText(), MWheaderIzdato16_32Ukupno.getText(),
                MWheaderIzdatoCementUkupno.getText(), MWheaderIzdatoFilerUkupno.getText(),
                MWheaderIzdatoAditiv1Ukupno.getText(), MWheaderIzdatoAditiv2Ukupno.getText(),
                MWheaderIzdatoVodaUkupno.getText());

    }
    
     private void print(String izdato0_4, String izdato4_8,
                            String izdato8_16, String izdato16_32, String izdatoCement,
                            String filer, String izdatoA1,  String izdatoA2,
                            String izdatoVoda) {
        otpremnicaStampa.print(tekuciRN.getTekuciRN(), tekuciRN.getTekucaOtp(), markaBetonaDb.getRecept(tekuciRN.getTekuciRN().getMarkabetona()),
                izdato0_4, izdato4_8, izdato8_16, izdato16_32, izdatoCement,
                            filer, izdatoA1, izdatoA2, izdatoVoda);

    }

    private String getTrenutnaKolicinaBeton() {
        Double res = Convert.round2Decimal(Double.parseDouble(tekuceZadato.getText()) * Double.parseDouble(MWheaderIzdatoBrSarze.getText())) / Double.parseDouble(MWheaderZadatoBrSarzi.getText());
        return Convert.format2decimals(res);
        //return "0";
    }

    private void writeDataOnBuffer() {
        buffZadato0_4 = MWheaderZadato0_4.getText();
        buffIzdato0_4 = MWheaderIzdato0_4.getText();
        buffZadato4_8 = MWheaderZadato4_8.getText();
        buffIzdato4_8 = MWheaderIzdato4_8.getText();
        buffZadato8_16 = MWheaderZadato8_16.getText();
        buffIzdato8_16 = MWheaderIzdato8_16.getText();
        buffZadato16_32 = MWheaderZadato16_32.getText();
        buffIzdato16_32 = MWheaderIzdato16_32.getText();
        buffZadatoCement = MWheaderZadatoCement.getText();
        buffIzdatoCement = MWheaderIzdatoCement.getText();
        buffZadatoFiler = MWheaderZadatoFiler.getText();
        buffIzdatoFiler = MWheaderIzdatoFiler.getText();
        buffZadatoAditiv1 = MWheaderZadatoAditiv1.getText();
        buffIzdatoAditiv1 = MWheaderIzdatoAditiv1.getText();
        buffZadatoAditiv2 = MWheaderZadatoAditiv2.getText();
        buffIzdatoAditiv2 = MWheaderIzdatoAditiv2.getText();
        buffZadatoVoda = MWheaderZadatoVoda.getText();
        buffIzdatoVoda = MWheaderIzdatoVoda.getText();

        buffIzdato0_4Ukupno = MWheaderIzdato0_4Ukupno.getText();
        buffIzdato4_8Ukupno = MWheaderIzdato4_8Ukupno.getText();
        buffIzdato8_16Ukupno = MWheaderIzdato8_16Ukupno.getText();
        buffIzdato16_32Ukupno = MWheaderIzdato16_32Ukupno.getText();
        buffIzdatoCementUkupno = MWheaderIzdatoCementUkupno.getText();
        buffIzdatoFilerUkupno = MWheaderIzdatoFilerUkupno.getText();
        buffIzdatoAditiv1Ukupno = MWheaderIzdatoAditiv1Ukupno.getText();
        buffIzdatoAditiv2Ukupno = MWheaderIzdatoAditiv2Ukupno.getText();
        buffIzdatoVodaUkupno = MWheaderIzdatoVodaUkupno.getText();
    }
    
    public void setStanjeZaliha(String zaliheCement, String zaliheFiler, String zaliheFrakcija04, 
            String zaliheFrakcija48, String zaliheFrakcija816, String zaliheAditiv1, String zaliheAditiv2, String zaliheAgregat1632){
        double cem = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getCement().getProcenjenaKolicinaSilos1Visi(), pogon.getCement().getProcenjenaKolicinaSilos1Nizi(), pogon.getCement().getBrDec());
        double fil = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getCement().getProcenjenaKolicinaSilos2Visi(), pogon.getCement().getProcenjenaKolicinaSilos2Nizi(), pogon.getCement().getBrDec());
        double agr04 = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat0_4().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat0_4().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat0_4().getBrDec());
        double agr48 = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat4_8().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat4_8().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat4_8().getBrDec());
        double agr816 = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat8_16().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat8_16().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat8_16().getBrDec());
        double ad1 = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAditiv1().getProcenjenaKolicinaSilosVisi(), pogon.getAditiv1().getProcenjenaKolicinaSilosNizi(), 0);
        double ad2 = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAditiv2().getProcenjenaKolicinaSilosVisi(), pogon.getAditiv2().getProcenjenaKolicinaSilosNizi(), 0);
        double agr1632= Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat16_32().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat16_32().getProcenjenaKolicinaSilosNizi(), 0);
        
        int[] cement = Convert.convertLongInTwoIntOnlyPositiv(cem,zaliheCement,0);
        int[] filer = Convert.convertLongInTwoIntOnlyPositiv(fil,zaliheFiler,0);
        int[] agregat04 = Convert.convertLongInTwoIntOnlyPositiv(agr04,zaliheFrakcija04,0);
        int[] agregat48 = Convert.convertLongInTwoIntOnlyPositiv(agr48,zaliheFrakcija48,0);
        int[] agregat816 = Convert.convertLongInTwoIntOnlyPositiv(agr816,zaliheFrakcija816,0);
      
        
        int[] aditiv1 = Convert.convertLongInTwoIntOnlyPositiv(ad1, zaliheAditiv1,2);
        int[] aditiv2 = Convert.convertLongInTwoIntOnlyPositiv(ad2, zaliheAditiv2,2);
        int[] agregat1632 = Convert.convertLongInTwoIntOnlyPositiv(agr1632, zaliheAgregat1632,0);
        
        
        int[] upis = new int[16];
        upis[0] = cement[0];
        upis[1] = cement[1];
        upis[2] = filer[0];
        upis[3] = filer[1];
        upis[4] = agregat04[0];
        upis[5] = agregat04[1];
        upis[6] = agregat48[0];
        upis[7] = agregat48[1];
        upis[8] = agregat816[0];
        upis[9] = agregat816[1];
        upis[10] = agregat1632[0];
        upis[11] = agregat1632[1];
        upis[12] = aditiv1[0];
        upis[13] = aditiv1[1];
        upis[14] = aditiv2[0];
        upis[15] = aditiv2[1];
        
        mb.writeMWs(upis, 31);
    }
}
