/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netvisionNew.win;

import betonMesalica.BrSarzi;
import betonMesalica.TekuciRN;
import dbService.MarkaBetonaService;
import dbService.OtpremaService;
import dbService.RadniNalogService;
import dbService.VozacService;
import dbService.VoziloService;
import java.net.URL;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import pogon.Pogon;
import utils.Convert;

/**
 *
 * @author branko.scekic
 */
public class NovaOtpremaFrame extends javax.swing.JFrame {

    /**
     * Creates new form NovaOtpremaFrame
     *
     * @param otpremaDb
     * @param vozacDb
     * @param voziloDb
     * @param markaBetonaDb
     * @param radniNalogDb
     * @param voziloFrame
     * @param vozacFrame
     * @param pogon
     * @param brSarzi
     * @param tekuciRN
     */
    public NovaOtpremaFrame(OtpremaService otpremaDb, VozacService vozacDb, VoziloService voziloDb, 
                MarkaBetonaService markaBetonaDb, RadniNalogService radniNalogDb, VoziloFrame voziloFrame, VozacFrame vozacFrame,  
                Pogon pogon, BrSarzi brSarzi, TekuciRN tekuciRN) {
        
        
        initComponents();
        
        URL iconURL = getClass().getResource("/img/logo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        
        this.otpremaDb = otpremaDb;
        this.vozacDb = vozacDb;
        this.voziloDb = voziloDb;
        this.markaBetonaDb = markaBetonaDb;
        this.radniNalogDb = radniNalogDb;
        this.voziloFrame = voziloFrame;
        this.vozacFrame = vozacFrame;
        this.pogon = pogon;
        this.brSarzi = brSarzi;
        this.tekuciRN = tekuciRN;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        brojRadnogNalogaOTPREMA = new javax.swing.JLabel();
        kupacOTPREMA = new javax.swing.JLabel();
        markaBetonaOTPREMA = new javax.swing.JLabel();
        gradilisteOTPREMA = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButtonNovaOtpremaPotvrdi = new javax.swing.JButton();
        jButtonNovaOtpremaOdustani = new javax.swing.JButton();
        spisakVozacOtpremnica = new javax.swing.JComboBox<>();
        spisakVoziloOtpremnica = new javax.swing.JComboBox<>();
        PregledVozaci = new javax.swing.JButton();
        pregledVozila = new javax.swing.JButton();
        zadataKolicinaOtprema = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        preostaloZaIsporuku = new javax.swing.JLabel();

        setResizable(false);

        jLabel18.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Kreiranje nove otpreme");

        jPanel5.setLayout(null);

        jLabel17.setText("Broj radnog naloga:");
        jLabel17.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jPanel5.add(jLabel17);
        jLabel17.setBounds(110, 0, 150, 40);

        brojRadnogNalogaOTPREMA.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        brojRadnogNalogaOTPREMA.setText("RN");
        jPanel5.add(brojRadnogNalogaOTPREMA);
        brojRadnogNalogaOTPREMA.setBounds(310, 0, 150, 40);

        kupacOTPREMA.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        kupacOTPREMA.setText("K");
        jPanel5.add(kupacOTPREMA);
        kupacOTPREMA.setBounds(110, 70, 150, 30);

        markaBetonaOTPREMA.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        markaBetonaOTPREMA.setText("MB");
        jPanel5.add(markaBetonaOTPREMA);
        markaBetonaOTPREMA.setBounds(270, 130, 150, 30);

        gradilisteOTPREMA.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        gradilisteOTPREMA.setText("G");
        jPanel5.add(gradilisteOTPREMA);
        gradilisteOTPREMA.setBounds(390, 70, 150, 30);

        jLabel19.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel19.setText("Gradilište:");
        jPanel5.add(jLabel19);
        jLabel19.setBounds(310, 70, 100, 30);

        jLabel20.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel20.setText("Marka betona: ");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(160, 130, 110, 30);

        jLabel22.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel22.setText("Kupac:");
        jPanel5.add(jLabel22);
        jLabel22.setBounds(50, 70, 100, 30);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Background.jpg"))); // NOI18N
        jPanel5.add(jLabel16);
        jLabel16.setBounds(30, 0, 520, 190);

        jLabel21.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("Vozač:");

        jLabel23.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Vozilo:");

        jLabel24.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Količina:");

        jButtonNovaOtpremaPotvrdi.setText("Potvrdi");
        jButtonNovaOtpremaPotvrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaOtpremaPotvrdiActionPerformed(evt);
            }
        });

        jButtonNovaOtpremaOdustani.setText("Odustani");
        jButtonNovaOtpremaOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaOtpremaOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNovaOtpremaPotvrdi, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonNovaOtpremaOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonNovaOtpremaPotvrdi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButtonNovaOtpremaOdustani, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        spisakVozacOtpremnica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        spisakVoziloOtpremnica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        PregledVozaci.setText("+");
        PregledVozaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PregledVozaciActionPerformed(evt);
            }
        });

        pregledVozila.setText("+");
        pregledVozila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pregledVozilaActionPerformed(evt);
            }
        });

        zadataKolicinaOtprema.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.1f));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Preostalo za isporuku:");

        preostaloZaIsporuku.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        preostaloZaIsporuku.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(spisakVoziloOtpremnica, 0, 201, Short.MAX_VALUE)
                                            .addComponent(spisakVozacOtpremnica, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(zadataKolicinaOtprema))
                                        .addGap(131, 131, 131))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(preostaloZaIsporuku, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(154, 154, 154)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PregledVozaci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(pregledVozila, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35))
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spisakVozacOtpremnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PregledVozaci))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spisakVoziloOtpremnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pregledVozila))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(preostaloZaIsporuku))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zadataKolicinaOtprema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void fillDataForRN(){
        brojRadnogNalogaOTPREMA.setText(Long.toString(tekuciRN.getTekuciRN().getRn()));
        kupacOTPREMA.setText(tekuciRN.getTekuciRN().getKupac());
        gradilisteOTPREMA.setText(tekuciRN.getTekuciRN().getGradiliste());
        markaBetonaOTPREMA.setText(tekuciRN.getTekuciRN().getMarkabetona());
        preostaloZaIsporuku.setText(Float.toString(tekuciRN.getTekuciRN().getUgovorenom3() - tekuciRN.getTekuciRN().getIsporucenom3()));
        
        getVozaciJComboBBox(vozacDb.getVozaci());
        getVoziloJComboBBox(voziloDb.getVozila());
    }
    
    private void jButtonNovaOtpremaPotvrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaOtpremaPotvrdiActionPerformed
        db.Markabetona markaBet = markaBetonaDb.getRecept(tekuciRN.getTekuciRN().getMarkabetona());
        
        if (JOptionPane.showConfirmDialog(null, "Da li želite da kreirate novu otpremu?", "Upozorenje",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            if (brSarzi.isCalculatedBrSarzi(Double.parseDouble(zadataKolicinaOtprema.getValue().toString()), 
                    Double.parseDouble(preostaloZaIsporuku.getText()),
                    Convert.shiftPointDouble(pogon.getParametri().getKapacitetMesalice(), pogon.getParametri().getBrDec()),
                    markaBet.getFrakcija04(),
                    markaBet.getFrakcija48(),
                    markaBet.getFrakcija816(),
                    markaBet.getFrakcija1632(),
                    markaBet.getCement(),
                    markaBet.getFiler(),
                    markaBet.getAditiv1(),
                    markaBet.getAditiv2(),
                    markaBet.getVoda())) {
                
                
    
                otpremaDb.addOprema(tekuciRN.getTekuciRN(), spisakVozacOtpremnica.getSelectedItem().toString(), 
                        spisakVoziloOtpremnica.getSelectedItem().toString(), brSarzi.getZadatoBetonaPoOtpremi());
                
                pogon.getMesalica().setVremeMesanjaSet(Convert.doubleToInt(markaBet.getVrememesanja(),0) * 10);
                pogon.getMesalica().setVremePraznjenjaSet(Convert.doubleToInt(markaBet.getVremepraznjenja(),0) * 10);
                
                
                
                setParametars(); 
                radniNalogDb.setBrOtpreme(tekuciRN.getTekuciRN());
                tekuciRN.setTekucaOtp(otpremaDb.getLastOtprema(tekuciRN.getTekuciRN()));
                tekuciRN.setReadiTekucaOtp(true);
               
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Pokusajte ponovo sa manjom kubikazom");
            }
        }
    }//GEN-LAST:event_jButtonNovaOtpremaPotvrdiActionPerformed

    private void jButtonNovaOtpremaOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaOtpremaOdustaniActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonNovaOtpremaOdustaniActionPerformed

    private void PregledVozaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PregledVozaciActionPerformed
        vozacFrame.setVisible(true);
        vozacFrame.getVozaci();
        //this.setVisible(false);
    }//GEN-LAST:event_PregledVozaciActionPerformed

    private void pregledVozilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pregledVozilaActionPerformed
        voziloFrame.setVisible(true);
        voziloFrame.getVozila();
        //this.setVisible(false);
    }//GEN-LAST:event_pregledVozilaActionPerformed

    public int[] setParametars() {
        int[] podaci = {brSarzi.getAgregat04(), 0, brSarzi.getAgregat48(), 0, brSarzi.getAgregat816(), 0, brSarzi.getAgregat1632(), 0,
            brSarzi.getCement(), 0, brSarzi.getFiler(), 0, brSarzi.getAditivA1(), 0, brSarzi.getAditivA2(), 0, brSarzi.getVoda(), 0,
            Convert.doubleToInt(brSarzi.getZadatoBetonaPoOtpremi(), 1), 0,
            brSarzi.getZadatiBrojSarzi(), 0};
        
        upisiPodatke = true;
        return podaci;
    }

    
    public void getVozaciJComboBBox(List<db.Vozac> result) {
        
        DefaultComboBoxModel model = (DefaultComboBoxModel) spisakVozacOtpremnica.getModel();

        // removing old data
        model.removeAllElements();

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getAktivan()) {
                model.addElement(result.get(i).getVozac());
            }
        }

        // setting model with new data
        spisakVozacOtpremnica.setModel(model);

    }
    
    public void getVoziloJComboBBox(List<db.Vozilo> result) {
        
        DefaultComboBoxModel model = (DefaultComboBoxModel) spisakVoziloOtpremnica.getModel();

        // removing old data
        model.removeAllElements();

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getAkivan()) {
                model.addElement(result.get(i).getTablica());
            }
        }

        // setting model with new data
        spisakVoziloOtpremnica.setModel(model);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PregledVozaci;
    private javax.swing.JLabel brojRadnogNalogaOTPREMA;
    private javax.swing.JLabel gradilisteOTPREMA;
    private javax.swing.JButton jButtonNovaOtpremaOdustani;
    private javax.swing.JButton jButtonNovaOtpremaPotvrdi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel kupacOTPREMA;
    private javax.swing.JLabel markaBetonaOTPREMA;
    private javax.swing.JButton pregledVozila;
    private javax.swing.JLabel preostaloZaIsporuku;
    private javax.swing.JComboBox<String> spisakVozacOtpremnica;
    private javax.swing.JComboBox<String> spisakVoziloOtpremnica;
    private javax.swing.JSpinner zadataKolicinaOtprema;
    // End of variables declaration//GEN-END:variables

    private final OtpremaService otpremaDb;
    private final VozacService vozacDb;
    private final VoziloService voziloDb;
    private final MarkaBetonaService markaBetonaDb;
    private final RadniNalogService radniNalogDb;
    
    private final VoziloFrame voziloFrame;
    private final VozacFrame vozacFrame;

    public final Pogon pogon;
    private final BrSarzi brSarzi;
    private final TekuciRN tekuciRN;
    public boolean upisiPodatke = false;

   

    
}
