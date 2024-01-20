/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netvisionNew.win;

import dbService.MarkaBetonaService;
import dbService.OtpremaService;
import dbService.RadniNalogService;
import dbService.SarzaService;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import print.OtpremnicaStampa;
import utils.Convert;

/**
 *
 * @author branko.scekic
 */
public class PregledSarziZaOtpremuFrame extends javax.swing.JFrame {

    /**
     * Creates new form pregledSarziZaOtpremuFrame
     * @param sarzaDb
     * @param radniNalogDb
     * @param otpremaDb
     * @param markaBetonaDb
     * @param otpremnicaStampa
     */
    public PregledSarziZaOtpremuFrame(SarzaService sarzaDb, RadniNalogService radniNalogDb, 
                    OtpremaService otpremaDb, MarkaBetonaService markaBetonaDb, OtpremnicaStampa otpremnicaStampa) {
        initComponents();
        
        URL iconURL = getClass().getResource("/img/logo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        
        this.sarzaDb = sarzaDb;
        this.otpremnicaStampa = otpremnicaStampa;
        this.radniNalogDb = radniNalogDb;
        this.otpremaDb = otpremaDb;
        this.markaBetonaDb = markaBetonaDb;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel26 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableSarza = new javax.swing.JTable();
        jLabel114 = new javax.swing.JLabel();
        brojRadnogNalogaSarza = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        brojOtpremaSarza = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        tabliceSarza = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        vozacSarza = new javax.swing.JLabel();
        zadato04 = new javax.swing.JLabel();
        zadato48 = new javax.swing.JLabel();
        zadato816 = new javax.swing.JLabel();
        zadato1632 = new javax.swing.JLabel();
        zadatoCement = new javax.swing.JLabel();
        zadatoFiler = new javax.swing.JLabel();
        zadatoAditiv1 = new javax.swing.JLabel();
        zadatoAditiv2 = new javax.swing.JLabel();
        zadatoVoda = new javax.swing.JLabel();
        jButtonPregledOtpreemePoSarzamaOdustani = new javax.swing.JButton();
        jButtonStampajOtpremu = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel113.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel113.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel113.setText("Pregled otpreme po šaržama");

        jTableSarza.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "br", "0_4 izd", "4_8 izd", "8_16 izd", "16_32 izd", "cem izd", "filer izd", "ad 1 izd", "ad 2 izd", "voda izd", "datum", "vreme"
            }
        ));
        jTableSarza.setToolTipText("");
        jTableSarza.setFocusable(false);
        jTableSarza.setShowVerticalLines(true);
        jTableSarza.setSurrendersFocusOnKeystroke(true);
        jTableSarza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSarzaMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTableSarza);

        jLabel114.setText("Broj radnog naloga: ");

        brojRadnogNalogaSarza.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        brojRadnogNalogaSarza.setText("rn");

        jLabel115.setText("broj otpreme");

        brojOtpremaSarza.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        brojOtpremaSarza.setText("bo");

        jLabel116.setText("Tablice");

        tabliceSarza.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        tabliceSarza.setText("t");

        jLabel117.setText("Vozac");

        vozacSarza.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        vozacSarza.setText("g");

        zadato04.setText("0");

        zadato48.setText("0");

        zadato816.setText("0");

        zadato1632.setText("0");

        zadatoCement.setText("0");

        zadatoFiler.setText("0");

        zadatoAditiv1.setText("0");

        zadatoAditiv2.setText("0");

        zadatoVoda.setText("0");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel113, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                                .addComponent(zadato04, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(zadato48, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel114)
                                .addGap(18, 18, 18)
                                .addComponent(brojRadnogNalogaSarza, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel115)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(brojOtpremaSarza, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zadato816, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(zadato1632, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(tabliceSarza, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(vozacSarza, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(zadatoCement, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(zadatoFiler, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(zadatoAditiv1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(zadatoAditiv2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(zadatoVoda, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel117)
                        .addComponent(vozacSarza))
                    .addComponent(tabliceSarza)
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel115)
                        .addComponent(brojOtpremaSarza)
                        .addComponent(jLabel116))
                    .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel114)
                        .addComponent(brojRadnogNalogaSarza)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zadato04)
                    .addComponent(zadato48)
                    .addComponent(zadato816)
                    .addComponent(zadato1632)
                    .addComponent(zadatoCement)
                    .addComponent(zadatoFiler)
                    .addComponent(zadatoAditiv1)
                    .addComponent(zadatoAditiv2)
                    .addComponent(zadatoVoda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButtonPregledOtpreemePoSarzamaOdustani.setText("Odustani");
        jButtonPregledOtpreemePoSarzamaOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPregledOtpreemePoSarzamaOdustaniActionPerformed(evt);
            }
        });

        jButtonStampajOtpremu.setText("Stampaj otpremu");
        jButtonStampajOtpremu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStampajOtpremuActionPerformed(evt);
            }
        });

        jMenu1.setText("Stampaj otpremu");

        jMenuItem1.setText("Stampaj otpremu");
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButtonStampajOtpremu, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPregledOtpreemePoSarzamaOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonPregledOtpreemePoSarzamaOdustani, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jButtonStampajOtpremu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableSarzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSarzaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableSarzaMouseClicked

    private void jButtonPregledOtpreemePoSarzamaOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPregledOtpreemePoSarzamaOdustaniActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonPregledOtpreemePoSarzamaOdustaniActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButtonStampajOtpremuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStampajOtpremuActionPerformed
        db.Radninalog rn = radniNalogDb.getRN(Long.parseLong(brojRadnogNalogaSarza.getText()));
        otpremnicaStampa.printOtprema(rn, otpremaDb.getOtpremaBrRNOtp(rn.getRn(), Long.parseLong(brojOtpremaSarza.getText())), markaBetonaDb.getRecept(rn.getMarkabetona()), jTableSarza);
    }//GEN-LAST:event_jButtonStampajOtpremuActionPerformed

    public void fillData(long brojRadnogNaloga, db.Otprema otprema, String tablice, String vozac){
        brojRadnogNalogaSarza.setText(Long.toString(brojRadnogNaloga));
        brojOtpremaSarza.setText(Long.toString(otprema.getBrotpreme()));
        tabliceSarza.setText(tablice);
        vozacSarza.setText(vozac);
        fillTableSarze(sarzaDb.getSarzeZaOtpremu(otprema.getId()));
        
    }
    
    private void fillTableSarze(List<db.Sarza> result) {
        int i = 0;
        Object[][] obj = new Object[result.size()][12];
        for (db.Sarza auto : result) {
            obj[i][0] = i + 1;
            obj[i][1] = auto.getAgregatizdato04();
            obj[i][2] = auto.getAgregaizdato48();
            obj[i][3] = auto.getAgregatizdato816();
            obj[i][4] = auto.getAgregatizdato1632();
            obj[i][5] = auto.getCementizdato();
            obj[i][6] = auto.getFilerizdato();
            obj[i][7] = auto.getAditiv1izdato();
            obj[i][8] = auto.getAditiv2izdato();
            obj[i][9] = auto.getVodaizdato();
            obj[i][10] = Convert.convertDateToStringDate(auto.getDate());
            obj[i][11] = Convert.convertDateToStringTime(auto.getDate());
            i++;
        }

        DefaultTableModel model = new DefaultTableModel(obj, new Object[]{"r.b", "0_4 izd", "4_8 izd", "8_16 izd", "16_32 izd", "cement", "filer ","aditiv 1", "aditiv 2", "voda", "datum" , "vreme"});
        jTableSarza.setModel(model);
        jTableSarza.setRowMargin(4);
        jTableSarza.setRowHeight(40);
        jTableSarza.setShowGrid(true);
        jTableSarza.getColumnModel().getColumn(0).setMaxWidth(45);
        jTableSarza.setDefaultEditor(Object.class, null);

    }
    
    
    
  
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel brojOtpremaSarza;
    private javax.swing.JLabel brojRadnogNalogaSarza;
    private javax.swing.JButton jButtonPregledOtpreemePoSarzamaOdustani;
    private javax.swing.JButton jButtonStampajOtpremu;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTableSarza;
    private javax.swing.JLabel tabliceSarza;
    private javax.swing.JLabel vozacSarza;
    private javax.swing.JLabel zadato04;
    private javax.swing.JLabel zadato1632;
    private javax.swing.JLabel zadato48;
    private javax.swing.JLabel zadato816;
    private javax.swing.JLabel zadatoAditiv1;
    private javax.swing.JLabel zadatoAditiv2;
    private javax.swing.JLabel zadatoCement;
    private javax.swing.JLabel zadatoFiler;
    private javax.swing.JLabel zadatoVoda;
    // End of variables declaration//GEN-END:variables
    private final SarzaService sarzaDb;
    private final OtpremnicaStampa otpremnicaStampa;
    private final RadniNalogService radniNalogDb;
    private final OtpremaService otpremaDb;
    private final MarkaBetonaService markaBetonaDb;
    
}