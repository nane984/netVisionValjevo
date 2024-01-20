/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package print;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.Convert;
import utils.PrintReport;

/**
 *
 * @author branko.scekic
 */
public class OtpremnicaStampa extends javax.swing.JFrame {

    /**
     * Creates new form Print1
     *
     * @param otp
     *
     */
    public OtpremnicaStampa() {

        initComponents();

        URL iconURL = getClass().getResource("/img/logo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        //jScrollPane6.getViewport().setBackground(Color.WHITE);

    }

    public void print(db.Radninalog radniNalog, db.Otprema otprema, db.Markabetona markaBetona,
            String MWheaderIzdato0_4Ukupno, String MWheaderIzdato4_8Ukupno, String MWheaderIzdato8_16Ukupno,
            String MWheaderIzdato16_32Ukupno, String MWheaderIzdatoCementUkupno, String MWheaderIzdatoFilerUkupno,
            String MWheaderIzdatoA1Ukupno, String MWheaderIzdatoA2Ukupno, String MWheaderIzdatoVodaUkupno) {

        try {
            this.brRN.setText(Long.toString(radniNalog.getRn()));
            this.brOtpreme.setText(Integer.toString(radniNalog.getBrojotpreme()));
            this.markaBetona.setText(radniNalog.getMarkabetona());
            this.kupac.setText(radniNalog.getKupac());
            this.gradiliste.setText(radniNalog.getGradiliste());
            this.datum.setText(Convert.convertDateToStringDate(otprema.getDatum()));
            this.vremePunjenja.setText(Convert.convertDateToStringTime(otprema.getDatum()));
            this.vozac.setText(otprema.getVozac());
            this.brVozila.setText(otprema.getVozilo());
            this.kolicinaBetonaIsporuceno.setText(Float.toString(otprema.getIzdatom3()));
            this.kolicinaBetonaNaruceno.setText(Double.toString(otprema.getZadatom3()));
            this.kolicinaBetonaOstalo.setText(Float.toString((float) (otprema.getZadatom3() - otprema.getIzdatom3())));

            this.MWheaderIzdato0_4Ukupno = MWheaderIzdato0_4Ukupno;
            this.MWheaderIzdato4_8Ukupno = MWheaderIzdato4_8Ukupno;
            this.MWheaderIzdato8_16Ukupno = MWheaderIzdato8_16Ukupno;
            this.MWheaderIzdato16_32Ukupno = MWheaderIzdato16_32Ukupno;
            this.MWheaderIzdatoCementUkupno = MWheaderIzdatoCementUkupno;
            this.MWheaderIzdatoFilerUkupno = MWheaderIzdatoFilerUkupno;
            this.MWheaderIzdatoAditiv1Ukupno = MWheaderIzdatoA1Ukupno;
            this.MWheaderIzdatoAditiv2Ukupno = MWheaderIzdatoA2Ukupno;
            this.MWheaderIzdatoVodaUkupno = MWheaderIzdatoVodaUkupno;

            fillTable1m3(markaBetona);
            fillTableUkupno();

            this.setVisible(true);
        } catch (java.lang.NullPointerException ex) {
            System.out.println("Ne moze da stampa");
            System.out.println(ex);
        }

        //jLabelSpecBet.setText(otpremnica.getSpecbetona());
        //jLabelKonzistencija.setText(otpremnica.getKonzbetona());
        //jLabelVrstaCementa.setText(otpremnica.getVrstacementa());
        //jLabelAditiv1.setText(otpremnica.getAditiva1());
        //jLabelAditiv2.setText(otpremnica.getAditiva2());
        //jLabelStandBet.setText(otpremnica.getStandbetona());
        //jTextArea1.setText(otpremnica.getNapomena());
    }

    private void fillTable1m3(db.Markabetona markaBetona) {

        Object[][] obj = new Object[1][9];

        obj[0][0] = markaBetona.getFrakcija04();
        obj[0][1] = markaBetona.getFrakcija48();
        obj[0][2] = markaBetona.getFrakcija816();
        obj[0][3] = markaBetona.getFrakcija1632();
        obj[0][4] = markaBetona.getCement();
        obj[0][5] = markaBetona.getFiler();
        obj[0][6] = markaBetona.getAditiv1();
        obj[0][7] = markaBetona.getAditiv2();
        obj[0][8] = markaBetona.getVoda();

        String[] zaglavlje = {"Ag 0_4", "Ag 4_8", "Ag 8_16", "Ag 16_32", "cement", "filer", "Aditiv1", "Aditiv2", "Voda"};

        DefaultTableModel model = new DefaultTableModel(obj, zaglavlje);
        jTable1m3.setModel(model);
        jTable1m3.setRowMargin(2);
        jTable1m3.setRowHeight(31);
        jTable1m3.setShowGrid(true);
        jTable1m3.getColumnModel().getColumn(0).setMinWidth(175);
        jTable1m3.getColumnModel().getColumn(0).setMaxWidth(195);

    }

    private void fillTableUkupno() {
        Object[][] obj = new Object[1][9];

        obj[0][0] = MWheaderIzdato0_4Ukupno;
        obj[0][1] = MWheaderIzdato4_8Ukupno;
        obj[0][2] = MWheaderIzdato8_16Ukupno;
        obj[0][3] = MWheaderIzdato16_32Ukupno;
        obj[0][4] = MWheaderIzdatoCementUkupno;
        obj[0][5] = MWheaderIzdatoFilerUkupno;
        obj[0][6] = MWheaderIzdatoAditiv1Ukupno;
        obj[0][7] = MWheaderIzdatoAditiv2Ukupno;
        obj[0][8] = MWheaderIzdatoVodaUkupno;

        String[] zaglavlje = {"Ag 0_4", "Ag 4_8", "Ag 8_16", "Ag 16_32", "cement", "filer", "Aditiv1", "Aditiv2", "Voda"};

        DefaultTableModel model = new DefaultTableModel(obj, zaglavlje);
        jTableUkupno.setModel(model);
        jTableUkupno.setRowMargin(2);
        jTableUkupno.setRowHeight(31);
        jTableUkupno.setShowGrid(true);
        jTableUkupno.getColumnModel().getColumn(0).setMinWidth(175);
        jTableUkupno.getColumnModel().getColumn(0).setMaxWidth(195);
    }

    
    
    
    
    
    
    public void printOtprema(db.Radninalog radniNalog, db.Otprema otprema, db.Markabetona markaBetona, JTable result) {

        try {
            
            this.brRN.setText(Long.toString(radniNalog.getRn()));
            this.brOtpreme.setText(Integer.toString(radniNalog.getBrojotpreme()));
            this.markaBetona.setText(radniNalog.getMarkabetona());
            this.kupac.setText(radniNalog.getKupac());
            this.gradiliste.setText(radniNalog.getGradiliste());
            this.datum.setText(Convert.convertDateToStringDate(otprema.getDatum()));
            this.vremePunjenja.setText(Convert.convertDateToStringTime(otprema.getDatum()));
            this.vozac.setText(otprema.getVozac());
            this.brVozila.setText(otprema.getVozilo());
            this.kolicinaBetonaIsporuceno.setText(Float.toString(otprema.getIzdatom3()));
            this.kolicinaBetonaNaruceno.setText(Double.toString(otprema.getZadatom3()));
            this.kolicinaBetonaOstalo.setText(Float.toString((float) (otprema.getZadatom3() - otprema.getIzdatom3())));

            fillTable1m3(markaBetona);
            fillTableUkupno(result);
            
            
            
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    private void fillTableUkupno(JTable result) {
        
            int ukupnoAg0_4 = 0;
            int ukupnoAg4_8 = 0;
            int ukupnoAg8_16 = 0;
            int ukupnoAg16_32 = 0;
            int ukupnoCement = 0;
            int ukupnoFiler = 0;
            float ukupnoAd1 = 0;
            float ukupnoAd2 = 0;
            float ukupnoVoda = 0;

            Object[][] obj1 = new Object[1][9];

            
            for (int i = 0; i < result.getRowCount(); i++) {
                int Amount = (int)result.getValueAt(i, 1);
                ukupnoAg0_4 = Amount + ukupnoAg0_4;
                obj1[0][0] = ukupnoAg0_4;
            }
            
            
            for (int i = 0; i < result.getRowCount(); i++) {
                int Amount = (int) result.getValueAt(i, 2);
                ukupnoAg4_8 = Amount + ukupnoAg4_8;
                obj1[0][1] = ukupnoAg4_8;
            }

            for (int i = 0; i < result.getRowCount(); i++) {
                int Amount = (int) result.getValueAt(i, 3);
                ukupnoAg8_16 = Amount + ukupnoAg8_16;
                obj1[0][2] = ukupnoAg8_16;
            }

            for (int i = 0; i < result.getRowCount(); i++) {
                int Amount = (int) result.getValueAt(i, 4);
                ukupnoAg16_32 = Amount + ukupnoAg16_32;
                obj1[0][3] = ukupnoAg16_32;
            }

            for (int i = 0; i < result.getRowCount(); i++) {
                int Amount = (int) result.getValueAt(i, 5);
                ukupnoCement = Amount + ukupnoCement;
                obj1[0][4] = ukupnoCement;
            }

            for (int i = 0; i < result.getRowCount(); i++) {
                int Amount = (int) result.getValueAt(i, 6);
                ukupnoFiler = Amount + ukupnoFiler;
                obj1[0][5] = ukupnoFiler;
            }

            
            for (int i = 0; i < result.getRowCount(); i++) {
                float Amount = (float) result.getValueAt(i, 7);
                ukupnoAd1 = Amount + ukupnoAd1;
                obj1[0][6] = ukupnoAd1;
            }
            

            for (int i = 0; i < result.getRowCount(); i++) {
                float Amount = (float) result.getValueAt(i, 8);
                ukupnoAd2 = Amount + ukupnoAd2;
                obj1[0][7] = ukupnoAd2;
            }

            for (int i = 0; i < result.getRowCount(); i++) {
                float Amount = (float) result.getValueAt(i, 9);
                ukupnoVoda = Amount + ukupnoVoda;
                obj1[0][8] = ukupnoVoda;
            }

            
            String[] zaglavlje = {"Ag 0_4", "Ag 4_8", "Ag 8_16", "Ag 16_32", "cement", "filer", "Aditiv1", "Aditiv2", "Voda"};

            DefaultTableModel model = new DefaultTableModel(obj1, zaglavlje);
            jTableUkupno.setModel(model);
            jTableUkupno.setRowMargin(2);
            jTableUkupno.setRowHeight(31);
            jTableUkupno.setShowGrid(true);
            jTableUkupno.getColumnModel().getColumn(0).setMinWidth(175);
            jTableUkupno.getColumnModel().getColumn(0).setMaxWidth(195);
            
            this.setVisible(true);
        
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kupac = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        gradiliste = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelStandBet = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        datum = new javax.swing.JLabel();
        jLabelBrOtpr = new javax.swing.JLabel();
        brOtpreme = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        markaBetona = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        kolicinaBetonaIsporuceno = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        brVozila = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel34 = new javax.swing.JLabel();
        jSeparator22 = new javax.swing.JSeparator();
        jLabel35 = new javax.swing.JLabel();
        vremePunjenja = new javax.swing.JLabel();
        jSeparator23 = new javax.swing.JSeparator();
        jSeparator24 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        vozac = new javax.swing.JLabel();
        jLabelAditiv1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabelSpecBet = new javax.swing.JLabel();
        jLabelGranulacija = new javax.swing.JLabel();
        jLabelVrstaCementa = new javax.swing.JLabel();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel29 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jSeparator27 = new javax.swing.JSeparator();
        jLabel40 = new javax.swing.JLabel();
        jSeparator28 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator25 = new javax.swing.JSeparator();
        jSeparator26 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1m3 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelBrOtpr1 = new javax.swing.JLabel();
        brRN = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        kolicinaBetonaNaruceno = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        kolicinaBetonaOstalo = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jSeparator20 = new javax.swing.JSeparator();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableUkupno = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setPreferredSize(new java.awt.Dimension(1260, 900));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Otprema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tempus Sans ITC", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(1254, 891));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(1200, 850));
        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kompresoring-logo.png"))); // NOI18N
        jPanel4.add(jLabel1);
        jLabel1.setBounds(10, 10, 510, 80);

        jLabel7.setText("Kupac:  ");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(10, 120, 44, 16);

        kupac.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        kupac.setText("-");
        jPanel4.add(kupac);
        kupac.setBounds(10, 140, 260, 40);

        jLabel8.setText("Gradilište:  ");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(300, 120, 62, 16);

        gradiliste.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        gradiliste.setText("-");
        jPanel4.add(gradiliste);
        gradiliste.setBounds(290, 140, 280, 40);

        jLabel13.setText("Uslov kvaliteta / standardi:");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(580, 120, 160, 16);

        jLabelStandBet.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelStandBet.setText("-");
        jPanel4.add(jLabelStandBet);
        jLabelStandBet.setBounds(580, 140, 140, 19);

        jLabel3.setText("Datum: ");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(950, 120, 43, 16);

        datum.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        datum.setText("-");
        jPanel4.add(datum);
        datum.setBounds(1040, 120, 110, 16);

        jLabelBrOtpr.setText("Broj otpreme: ");
        jPanel4.add(jLabelBrOtpr);
        jLabelBrOtpr.setBounds(950, 160, 77, 16);

        brOtpreme.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        brOtpreme.setText("-");
        jPanel4.add(brOtpreme);
        brOtpreme.setBounds(1040, 160, 30, 16);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(null);
        jSeparator2.setOpaque(true);
        jPanel4.add(jSeparator2);
        jSeparator2.setBounds(0, 110, 1200, 2);

        markaBetona.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        markaBetona.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        markaBetona.setText("-");
        jPanel4.add(markaBetona);
        markaBetona.setBounds(10, 230, 140, 19);

        jLabel17.setText("Specifičnost betona:");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(160, 200, 120, 16);

        jLabel18.setText("Granulacija");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(290, 200, 80, 16);

        jSeparator10.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator10.setOpaque(true);
        jPanel4.add(jSeparator10);
        jSeparator10.setBounds(730, 110, 2, 220);

        kolicinaBetonaIsporuceno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        kolicinaBetonaIsporuceno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kolicinaBetonaIsporuceno.setText("0");
        jPanel4.add(kolicinaBetonaIsporuceno);
        kolicinaBetonaIsporuceno.setBounds(740, 230, 130, 20);

        jSeparator14.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator14.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator14.setOpaque(true);
        jPanel4.add(jSeparator14);
        jSeparator14.setBounds(0, 190, 1200, 2);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Naručeno m3:  ");
        jPanel4.add(jLabel24);
        jLabel24.setBounds(950, 200, 90, 16);

        jSeparator16.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator16.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator16.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator16.setOpaque(true);
        jPanel4.add(jSeparator16);
        jSeparator16.setBounds(944, 10, 2, 320);

        jLabel28.setText("Vreme povratka: ");
        jPanel4.add(jLabel28);
        jLabel28.setBounds(1080, 260, 110, 30);

        jSeparator19.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator19.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator19.setOpaque(true);
        jPanel4.add(jSeparator19);
        jSeparator19.setBounds(0, 258, 1200, 2);

        jLabel30.setText("Klasa gustoće");
        jPanel4.add(jLabel30);
        jLabel30.setBounds(590, 200, 130, 16);

        jLabel31.setText("Kamion:");
        jPanel4.add(jLabel31);
        jLabel31.setBounds(740, 160, 50, 20);

        brVozila.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        brVozila.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        brVozila.setText("-");
        jPanel4.add(brVozila);
        brVozila.setBounds(800, 160, 130, 20);

        jTextArea1.setColumns(8);
        jTextArea1.setRows(1);
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(jTextArea1);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(20, 580, 1160, 40);

        jLabel34.setText("Potpis vozača:");
        jPanel4.add(jLabel34);
        jLabel34.setBounds(40, 630, 200, 16);

        jSeparator22.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator22.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jPanel4.add(jSeparator22);
        jSeparator22.setBounds(30, 780, 1150, 10);

        jLabel35.setText("Izmerene kolicine");
        jPanel4.add(jLabel35);
        jLabel35.setBounds(20, 450, 170, 16);

        vremePunjenja.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        vremePunjenja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        vremePunjenja.setText("-");
        jPanel4.add(vremePunjenja);
        vremePunjenja.setBounds(290, 290, 100, 30);

        jSeparator23.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator23.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator23.setOpaque(true);
        jPanel4.add(jSeparator23);
        jSeparator23.setBounds(0, 328, 1220, 2);

        jSeparator24.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator24.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator24.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jSeparator24.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator24.setOpaque(true);
        jPanel4.add(jSeparator24);
        jSeparator24.setBounds(278, 110, 2, 220);

        jLabel37.setText("Vreme punjenja:");
        jPanel4.add(jLabel37);
        jLabel37.setBounds(290, 260, 110, 30);

        jLabel10.setText("Vozač:  ");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(740, 120, 41, 20);

        vozac.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        vozac.setText("-");
        jPanel4.add(vozac);
        vozac.setBounds(780, 120, 160, 20);

        jLabelAditiv1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelAditiv1.setText("-");
        jPanel4.add(jLabelAditiv1);
        jLabelAditiv1.setBounds(160, 289, 110, 30);

        jLabel19.setText("Napomena:");
        jPanel4.add(jLabel19);
        jLabel19.setBounds(20, 560, 65, 16);

        jLabelSpecBet.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelSpecBet.setText("-");
        jPanel4.add(jLabelSpecBet);
        jLabelSpecBet.setBounds(160, 230, 110, 19);

        jLabelGranulacija.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelGranulacija.setText("-");
        jPanel4.add(jLabelGranulacija);
        jLabelGranulacija.setBounds(290, 230, 130, 19);

        jLabelVrstaCementa.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabelVrstaCementa.setText("-");
        jPanel4.add(jLabelVrstaCementa);
        jLabelVrstaCementa.setBounds(10, 290, 110, 30);

        jSeparator15.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator15.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator15.setOpaque(true);
        jPanel4.add(jSeparator15);
        jSeparator15.setBounds(576, 110, 2, 220);

        jLabel29.setText("Vreme dolaska na grad.: ");
        jPanel4.add(jLabel29);
        jLabel29.setBounds(440, 260, 140, 30);

        jLabel39.setText("Potpis ovlašćenog lica proizvođača:");
        jPanel4.add(jLabel39);
        jLabel39.setBounds(480, 630, 210, 16);

        jSeparator27.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator27.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator27.setOpaque(true);
        jPanel4.add(jSeparator27);
        jSeparator27.setBounds(480, 680, 220, 2);

        jLabel40.setText("Potpis ovlašćene osobe na gradilištu :");
        jPanel4.add(jLabel40);
        jLabel40.setBounds(880, 630, 230, 16);

        jSeparator28.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator28.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator28.setOpaque(true);
        jPanel4.add(jSeparator28);
        jSeparator28.setBounds(880, 680, 220, 2);

        jLabel5.setText("može upotrebiti za fakturisanje.");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(880, 760, 310, 20);

        jLabel6.setText("betona oslobađaju proizvođača odgovornosti.");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(30, 740, 320, 20);

        jLabel11.setText("Naknadno dodata voda____ lit. Saglasnost ovlašćene osobe na gradilištu __________________________________________________");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(30, 790, 790, 20);

        jLabel14.setText("ovlašćen naknadno ubacivati vodu. Sve naknadne izmene");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(30, 720, 320, 20);

        jLabel15.setText("UPUTSTVO: Svež beton je bazičan, zbog toga treba kožu i oči");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(450, 700, 340, 20);

        jLabel16.setText("zaštititi. U slučaju kontakta sa betonom treba deo tela dobro ");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(450, 720, 340, 20);

        jLabel20.setText("oprati vodom. Neophodno je nositi zaštitne rukavice.");
        jPanel4.add(jLabel20);
        jLabel20.setBounds(450, 740, 310, 20);

        jLabel9.setText("Ispunjavanje otprenice sledi na osnovu naših uslova");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(880, 700, 310, 20);

        jLabel21.setText("poslovanja. Vreme dolaska i odlaska na gradilište");
        jPanel4.add(jLabel21);
        jLabel21.setBounds(880, 720, 310, 20);

        jLabel22.setText("su tačno navedeni tako da se vreme čekanja ");
        jPanel4.add(jLabel22);
        jLabel22.setBounds(880, 740, 310, 20);

        jSeparator25.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator25.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator25.setOpaque(true);
        jPanel4.add(jSeparator25);
        jSeparator25.setBounds(40, 680, 220, 2);

        jSeparator26.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator26.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jPanel4.add(jSeparator26);
        jSeparator26.setBounds(30, 690, 1150, 10);

        jLabel23.setText("Količina vode je utvđena recepturom tako da kupac nije");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(30, 700, 310, 20);

        jLabel41.setText("Aditivi:");
        jPanel4.add(jLabel41);
        jLabel41.setBounds(170, 266, 40, 20);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(null);
        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setViewportBorder(null);
        jScrollPane3.setOpaque(true);

        jTable1m3.setBorder(null);
        jTable1m3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ag 0_4", "ag 4_8", "ag 8_16", "ag 16_32"
            }
        ));
        jTable1m3.setEnabled(false);
        jTable1m3.setFocusable(false);
        jTable1m3.setGridColor(new java.awt.Color(102, 102, 102));
        jTable1m3.setOpaque(false);
        jTable1m3.setRowHeight(18);
        jTable1m3.setRowSelectionAllowed(false);
        jTable1m3.setShowHorizontalLines(true);
        jTable1m3.setShowVerticalLines(true);
        jTable1m3.getTableHeader().setResizingAllowed(false);
        jTable1m3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable1m3);

        jPanel4.add(jScrollPane3);
        jScrollPane3.setBounds(20, 370, 1160, 60);

        jLabel25.setText("Marka betona:  ");
        jPanel4.add(jLabel25);
        jLabel25.setBounds(10, 200, 83, 16);

        jSeparator17.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator17.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator17.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator17.setOpaque(true);
        jPanel4.add(jSeparator17);
        jSeparator17.setBounds(428, 190, 2, 140);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setText("Tip: BSA LS");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(950, 60, 160, 20);

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Fabrika etona: SIMI");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(950, 30, 160, 20);

        jLabelBrOtpr1.setText("/");
        jPanel4.add(jLabelBrOtpr1);
        jLabelBrOtpr1.setBounds(1080, 160, 10, 16);

        brRN.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        brRN.setText("-");
        jPanel4.add(brRN);
        brRN.setBounds(1110, 160, 80, 16);

        jLabel32.setText("Period očvršćavanja");
        jPanel4.add(jLabel32);
        jLabel32.setBounds(440, 200, 130, 16);

        jSeparator18.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator18.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator18.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator18.setOpaque(true);
        jPanel4.add(jSeparator18);
        jSeparator18.setBounds(150, 190, 2, 140);

        jLabel33.setText("Vreme početka istovara: ");
        jPanel4.add(jLabel33);
        jLabel33.setBounds(590, 260, 140, 30);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Količina m3:  ");
        jPanel4.add(jLabel26);
        jLabel26.setBounds(740, 200, 100, 16);

        kolicinaBetonaNaruceno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        kolicinaBetonaNaruceno.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kolicinaBetonaNaruceno.setText("0");
        jPanel4.add(kolicinaBetonaNaruceno);
        kolicinaBetonaNaruceno.setBounds(950, 230, 90, 20);

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel36.setText("Ostalo m3:  ");
        jPanel4.add(jLabel36);
        jLabel36.setBounds(1110, 200, 66, 16);

        kolicinaBetonaOstalo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        kolicinaBetonaOstalo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kolicinaBetonaOstalo.setText("0");
        jPanel4.add(kolicinaBetonaOstalo);
        kolicinaBetonaOstalo.setBounds(1110, 230, 70, 20);

        jLabel38.setText("Vreme završetka istovara: ");
        jPanel4.add(jLabel38);
        jLabel38.setBounds(740, 260, 150, 30);

        jLabel42.setText("Vreme čekanja: ");
        jPanel4.add(jLabel42);
        jLabel42.setBounds(950, 260, 90, 30);

        jSeparator20.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator20.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator20.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jSeparator20.setOpaque(true);
        jPanel4.add(jSeparator20);
        jSeparator20.setBounds(1056, 260, 2, 70);

        jLabel43.setText("Cement:");
        jPanel4.add(jLabel43);
        jLabel43.setBounds(10, 270, 100, 16);

        jLabel44.setText("Količine po receptu za 1m3");
        jPanel4.add(jLabel44);
        jLabel44.setBounds(20, 350, 170, 16);

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(null);
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setViewportBorder(null);
        jScrollPane4.setOpaque(true);

        jTableUkupno.setBorder(null);
        jTableUkupno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ag 0_4", "ag 4_8", "ag 8_16", "ag 16_32"
            }
        ));
        jTableUkupno.setEnabled(false);
        jTableUkupno.setFocusable(false);
        jTableUkupno.setGridColor(new java.awt.Color(102, 102, 102));
        jTableUkupno.setOpaque(false);
        jTableUkupno.setRowHeight(18);
        jTableUkupno.setRowSelectionAllowed(false);
        jTableUkupno.setShowHorizontalLines(true);
        jTableUkupno.setShowVerticalLines(true);
        jTableUkupno.getTableHeader().setResizingAllowed(false);
        jTableUkupno.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableUkupno);

        jPanel4.add(jScrollPane4);
        jScrollPane4.setBounds(20, 470, 1160, 60);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        jMenu1.setText("Stampa");

        jMenuItem1.setText("Stampaj");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public BufferedImage createImage(JPanel panel) {

        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.paint(g);
        g.dispose();

        return bi;
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (jTextArea1.getText().isEmpty()) {
            jTextArea1.setText("");
        }

        PrinterJob pjob = PrinterJob.getPrinterJob();
        PageFormat preformat = pjob.defaultPage();
        preformat.setOrientation(PageFormat.LANDSCAPE);

        Paper pPaper = preformat.getPaper();

        pPaper.setImageableArea(5.0, 5.0, pPaper.getWidth() - 10, pPaper.getHeight() - 10);
        preformat.setPaper(pPaper);

        //Set print component
        pjob.setPrintable(new PrintReport(jPanel4), preformat);
        if (pjob.printDialog()) {
            try {
                pjob.setJobName(brOtpreme.getText() + "_" + kupac.getText());
                pjob.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }

        this.setVisible(false);
        //otpService.updateNapomena(otprem.getBrotpremnice(), jTextArea1.getText());
        //printReport();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void printReport() {
        //try {
        /* 
            DefaultTableModel de = (DefaultTableModel) jTable1.getModel();
            JasperReport jr = JasperCompileManager.compileReport("src\\reports\\ReportDetaljniIzvestaj.jrxml");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jr, podaci, new JRTableModelDataSource(de));
            JasperViewer.viewReport(jasperPrint,false);
         */

        //} catch (JRException ex) {
        //   Logger.getLogger(DetaljniIzvestaj.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brOtpreme;
    private javax.swing.JLabel brRN;
    private javax.swing.JLabel brVozila;
    private javax.swing.JLabel datum;
    private javax.swing.JLabel gradiliste;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAditiv1;
    private javax.swing.JLabel jLabelBrOtpr;
    private javax.swing.JLabel jLabelBrOtpr1;
    private javax.swing.JLabel jLabelGranulacija;
    private javax.swing.JLabel jLabelSpecBet;
    private javax.swing.JLabel jLabelStandBet;
    private javax.swing.JLabel jLabelVrstaCementa;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JSeparator jSeparator23;
    private javax.swing.JSeparator jSeparator24;
    private javax.swing.JSeparator jSeparator25;
    private javax.swing.JSeparator jSeparator26;
    private javax.swing.JSeparator jSeparator27;
    private javax.swing.JSeparator jSeparator28;
    private javax.swing.JTable jTable1m3;
    private javax.swing.JTable jTableUkupno;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel kolicinaBetonaIsporuceno;
    private javax.swing.JLabel kolicinaBetonaNaruceno;
    private javax.swing.JLabel kolicinaBetonaOstalo;
    private javax.swing.JLabel kupac;
    private javax.swing.JLabel markaBetona;
    private javax.swing.JLabel vozac;
    private javax.swing.JLabel vremePunjenja;
    // End of variables declaration//GEN-END:variables
   

    private String MWheaderIzdato0_4Ukupno;
    private String MWheaderIzdato4_8Ukupno;
    private String MWheaderIzdato8_16Ukupno;
    private String MWheaderIzdato16_32Ukupno;
    private String MWheaderIzdatoCementUkupno;
    private String MWheaderIzdatoFilerUkupno;
    private String MWheaderIzdatoAditiv1Ukupno;
    private String MWheaderIzdatoAditiv2Ukupno;
    private String MWheaderIzdatoVodaUkupno;
}
