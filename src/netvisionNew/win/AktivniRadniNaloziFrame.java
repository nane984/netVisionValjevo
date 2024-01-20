/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netvisionNew.win;

import betonMesalica.TekuciRN;
import dbService.RadniNalogService;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import utils.Convert;

/**
 *
 * @author branko.scekic
 */
public class AktivniRadniNaloziFrame extends javax.swing.JFrame {

    /**
     * Creates new form RadniNalogFrame
     * @param radniNalogDb
     * @param novaOtpremaFrame
     * @param tekuciRN
     * @param pregledRadnogNalogaPoOtpremamaFrame
     */
    
    public AktivniRadniNaloziFrame(RadniNalogService radniNalogDb, NovaOtpremaFrame novaOtpremaFrame, 
            TekuciRN tekuciRN, PregledOtpremaZaRadniNalogFrame pregledRadnogNalogaPoOtpremamaFrame) {
        initComponents();
        
        URL iconURL = getClass().getResource("/img/logo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        
        this.radniNalogDb = radniNalogDb;
        this.novaOtpremaFrame = novaOtpremaFrame;
        this.tekuciRN = tekuciRN;
        this.pregledRadnogNalogaPoOtpremamaFrame = pregledRadnogNalogaPoOtpremamaFrame;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAktivniNalozi = new javax.swing.JTable();
        jButtonPregledAktivnihRNOdustani = new javax.swing.JButton();
        pregledAktivnihRNDetalji = new javax.swing.JButton();
        shorcutNovaotprema = new javax.swing.JButton();

        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel30.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Pregled aktivnih radnih naloga");

        jTableAktivniNalozi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "br", "radni nalog", "marka betona", "kupac", "gradiliste", "ugovoreno", "isporuceno", "preostalo", "datum"
            }
        ));
        jTableAktivniNalozi.setFocusable(false);
        jTableAktivniNalozi.setShowVerticalLines(true);
        jTableAktivniNalozi.setSurrendersFocusOnKeystroke(true);
        jTableAktivniNalozi.setToolTipText("");
        jTableAktivniNalozi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAktivniNaloziMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAktivniNalozi);

        jButtonPregledAktivnihRNOdustani.setText("Odustani");
        jButtonPregledAktivnihRNOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPregledAktivnihRNOdustaniActionPerformed(evt);
            }
        });

        pregledAktivnihRNDetalji.setText("Detalji");
        pregledAktivnihRNDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pregledAktivnihRNDetaljiActionPerformed(evt);
            }
        });

        shorcutNovaotprema.setText("Nova otprema");
        shorcutNovaotprema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shorcutNovaotpremaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1153, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(pregledAktivnihRNDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(shorcutNovaotprema, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPregledAktivnihRNOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pregledAktivnihRNDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shorcutNovaotprema, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPregledAktivnihRNOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableAktivniNaloziMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAktivniNaloziMouseClicked

        jTableAktivniNalozi = (JTable) evt.getSource();
        if (evt.getClickCount() == 2 && jTableAktivniNalozi.getSelectedRow() != -1) {
            //this.setVisible(false);
            getNewOtpremaFromRN();
        }else{
            if(evt.getClickCount() == 2){
                JOptionPane.showMessageDialog(this, "Niste selektovali radni nalog", "Obavestenje",0);
            }
        }
    }//GEN-LAST:event_jTableAktivniNaloziMouseClicked

    private void jButtonPregledAktivnihRNOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPregledAktivnihRNOdustaniActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonPregledAktivnihRNOdustaniActionPerformed

    private void pregledAktivnihRNDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pregledAktivnihRNDetaljiActionPerformed
        if (jTableAktivniNalozi.getSelectedRow() != -1) {
            pregledRadnogNalogaPoOtpremamaFrame.setVisible(true);  
            //this.setVisible(false);
            pregledRadnogNalogaPoOtpremamaFrame.fillData(Long.parseLong(jTableAktivniNalozi.getValueAt(jTableAktivniNalozi.getSelectedRow(), 1).toString()), 
                    jTableAktivniNalozi.getValueAt(jTableAktivniNalozi.getSelectedRow(), 2).toString(), 
                    jTableAktivniNalozi.getValueAt(jTableAktivniNalozi.getSelectedRow(), 3).toString(), 
                    jTableAktivniNalozi.getValueAt(jTableAktivniNalozi.getSelectedRow(), 4).toString(), 
                    0);     
        }
    }//GEN-LAST:event_pregledAktivnihRNDetaljiActionPerformed

    private void shorcutNovaotpremaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shorcutNovaotpremaActionPerformed
        if (jTableAktivniNalozi.getSelectedRow() != -1) {
            //this.setVisible(false);
            getNewOtpremaFromRN();
        }else{
            JOptionPane.showMessageDialog(this, "Niste selektovali radni nalog", "Obavestenje",0);
        }
    }//GEN-LAST:event_shorcutNovaotpremaActionPerformed

    private void getNewOtpremaFromRN() {
        novaOtpremaFrame.setVisible(true);
        tekuciRN.setTekuciRN(radniNalogDb.getRN(Long.parseLong(jTableAktivniNalozi.getValueAt(jTableAktivniNalozi.getSelectedRow(), 1).toString())));
        novaOtpremaFrame.fillDataForRN();
        tekuciRN.setReadiTekuciRN(true);
       // novaOtpremaFrame.setPodaci(tekucaMarkaBetona, tekuciKupac, tekuceGradiliste, tekuciBrojRN, preostaloZaIsporuku);
       // if (zadrziPodatke.isSelected()) {
       //     novaOtpremaFrame.getSpisakVozacOtpremnica().setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{tekuceVozac.getText()}));
       //     novaOtpremaFrame.getSpisakVoziloOtpremnica().setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{tekuceTablicaVozila.getText()}));

       // } else {
          //  vozacDb.spisakVozacOtpremnica();
          //  voziloDb.spisakVoziloOtpremnica();
       // }
    }
    
    
    public void getAktivniRN(){
        fillTableAktivniRN(radniNalogDb.getAktivniRadniNalozi());
    }
    
    private void fillTableAktivniRN(List<db.Radninalog> result) {
        int i = 0;
        Object[][] obj = new Object[result.size()][10];
        for (db.Radninalog auto : result) {
            obj[i][0] = i + 1;
            obj[i][1] = auto.getRn();
            obj[i][2] = auto.getMarkabetona();
            obj[i][3] = auto.getKupac();
            obj[i][4] = auto.getGradiliste();
            obj[i][5] = auto.getUgovorenom3();
            obj[i][6] = auto.getIsporucenom3();
            obj[i][7] = auto.getUgovorenom3() - auto.getIsporucenom3();
            obj[i][8] = Convert.convertDateToStringDate(auto.getDatum());
            obj[i][9] = Convert.convertDateToStringTime(auto.getDatum());
            //obj[i][10] = Convert.convertDateToStringTime(auto.getDatumvreme());

            i++;
        }

        DefaultTableModel model = new DefaultTableModel(obj, new Object[]{"r.b.", "Radni nalog", "Marka betona", "Kupac", "Gradiliste", "Ugovoreno", "Isporuceno", "Preostalo", "Datum", "Vreme"});
        jTableAktivniNalozi.setModel(model);
        jTableAktivniNalozi.setRowMargin(4);
        jTableAktivniNalozi.setRowHeight(40);
        jTableAktivniNalozi.setShowGrid(true);
        jTableAktivniNalozi.getColumnModel().getColumn(0).setMaxWidth(45);
        jTableAktivniNalozi.setDefaultEditor(Object.class, null);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPregledAktivnihRNOdustani;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAktivniNalozi;
    private javax.swing.JButton pregledAktivnihRNDetalji;
    private javax.swing.JButton shorcutNovaotprema;
    // End of variables declaration//GEN-END:variables

    
    private final RadniNalogService radniNalogDb;
    private final TekuciRN tekuciRN;
    //private final OtpremaService otpremaDb;
    //private final VozacService vozacDb;
    //private final VoziloService voziloDb;
    
    private final NovaOtpremaFrame novaOtpremaFrame;
    private final PregledOtpremaZaRadniNalogFrame pregledRadnogNalogaPoOtpremamaFrame;
    
   // private final JLabel tekuceVozac;
    //private final JLabel tekuceTablicaVozila;
    //private final JCheckBox zadrziPodatke;

    
}