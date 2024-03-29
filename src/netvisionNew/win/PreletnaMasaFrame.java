/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netvisionNew.win;

import com.Buff;
import dbService.PreletiService;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import pogon.Pogon;
import utils.Convert;

/**
 *
 * @author branko.scekic
 */
public class PreletnaMasaFrame extends javax.swing.JFrame {

    /**
     * Creates new form PreletnaMasaFrame
     * @param preletiDb
     * @param pogon
     */
    public PreletnaMasaFrame(PreletiService preletiDb, Pogon pogon) {
        initComponents();
        
        URL iconURL = getClass().getResource("/img/logo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        
        this.preletiDb = preletiDb;
        this.pogon = pogon;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel16 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jButtonPreletiOdustani = new javax.swing.JButton();
        jButtonPreletiSacuvaj = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        AOPreletnaMasaFrakcija0_4 = new javax.swing.JSpinner();
        AOPreletnaMasaFrakcija4_8 = new javax.swing.JSpinner();
        AOPreletnaMasaFrakcija8_16 = new javax.swing.JSpinner();
        AOPreletnaMasaFrakcija16_32 = new javax.swing.JSpinner();
        AOPreletnaMasaCement = new javax.swing.JSpinner();
        AOPreletnaMasaFiler = new javax.swing.JSpinner();
        AOPreletnaMasaAditiv1 = new javax.swing.JSpinner();
        AOPreletnaMasaAditiv2 = new javax.swing.JSpinner();
        AOPreletnaMasaVoda = new javax.swing.JSpinner();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel76.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("Preletna masa");

        jButtonPreletiOdustani.setText("Odustani");
        jButtonPreletiOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreletiOdustaniActionPerformed(evt);
            }
        });

        jButtonPreletiSacuvaj.setText("Sacuvaj");
        jButtonPreletiSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreletiSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButtonPreletiSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPreletiOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPreletiSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPreletiOdustani, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel77.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel77.setText("1. Frakcija 0-4 mm  (kg)");

        jLabel78.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel78.setText("2. Frakcija 4-8 mm  (kg)");

        jLabel79.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel79.setText("3. Frakcija 8-16 mm (kg)");

        jLabel80.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel80.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel80.setText("4. Frakcija 16-32 mm (kg)");

        jLabel81.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel81.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel81.setText("5. Cement (kg)");

        jLabel82.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel82.setText("6. Filer (kg)");

        jLabel83.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel83.setText("7. Aditiv A1 (kg)");

        jLabel84.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel84.setText("8. Aditiv A2 (kg)");

        jLabel85.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel85.setText("9.  Voda (kg)");

        AOPreletnaMasaFrakcija0_4.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 200.0d, 1.0d));

        AOPreletnaMasaFrakcija4_8.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 200.0d, 1.0d));

        AOPreletnaMasaFrakcija8_16.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 200.0d, 1.0d));

        AOPreletnaMasaFrakcija16_32.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 200.0d, 1.0d));

        AOPreletnaMasaCement.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 20.0d, 1.0d));

        AOPreletnaMasaFiler.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 20.0d, 1.0d));

        AOPreletnaMasaAditiv1.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 2.0d, 0.009999999776482582d));

        AOPreletnaMasaAditiv2.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 2.0d, 0.009999999776482582d));

        AOPreletnaMasaVoda.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.0d, 20.0d, 1.0d));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel80, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AOPreletnaMasaFrakcija0_4)
                    .addComponent(AOPreletnaMasaFrakcija4_8)
                    .addComponent(AOPreletnaMasaFrakcija8_16)
                    .addComponent(AOPreletnaMasaFrakcija16_32)
                    .addComponent(AOPreletnaMasaCement)
                    .addComponent(AOPreletnaMasaFiler)
                    .addComponent(AOPreletnaMasaAditiv1)
                    .addComponent(AOPreletnaMasaAditiv2)
                    .addComponent(AOPreletnaMasaVoda, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AOPreletnaMasaFrakcija0_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AOPreletnaMasaFrakcija4_8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AOPreletnaMasaFrakcija8_16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AOPreletnaMasaFrakcija16_32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AOPreletnaMasaCement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AOPreletnaMasaFiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AOPreletnaMasaAditiv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AOPreletnaMasaAditiv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AOPreletnaMasaVoda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu6.setText("rezervna kopija");

        jMenuItem6.setText("Ucitaj iz baze");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);

        jMenuBar2.add(jMenu6);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPreletiOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreletiOdustaniActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonPreletiOdustaniActionPerformed

    private void jButtonPreletiSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreletiSacuvajActionPerformed
       if (JOptionPane.showConfirmDialog(null, "Da li želite da sačuvate?", "Upozorenje",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            setPreleti();
            preletiDb.setPreleti();
        }
    }//GEN-LAST:event_jButtonPreletiSacuvajActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        preletiDb.getPreleti();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner AOPreletnaMasaAditiv1;
    private javax.swing.JSpinner AOPreletnaMasaAditiv2;
    private javax.swing.JSpinner AOPreletnaMasaCement;
    private javax.swing.JSpinner AOPreletnaMasaFiler;
    private javax.swing.JSpinner AOPreletnaMasaFrakcija0_4;
    private javax.swing.JSpinner AOPreletnaMasaFrakcija16_32;
    private javax.swing.JSpinner AOPreletnaMasaFrakcija4_8;
    private javax.swing.JSpinner AOPreletnaMasaFrakcija8_16;
    private javax.swing.JSpinner AOPreletnaMasaVoda;
    private javax.swing.JButton jButtonPreletiOdustani;
    private javax.swing.JButton jButtonPreletiSacuvaj;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel19;
    // End of variables declaration//GEN-END:variables

    private final PreletiService preletiDb;
    private Buff mb;
    private final Pogon pogon;
    
    public void setMb(Buff mb){
        this.mb = mb;
    }
    
    
     private void setPreleti() {
        int[] podaci = {Convert.objectToInt(AOPreletnaMasaFrakcija0_4.getValue(), pogon.getPreleti().getFrakcijaBrDec()),
            Convert.objectToInt(AOPreletnaMasaFrakcija4_8.getValue(), pogon.getPreleti().getFrakcijaBrDec()),
            Convert.objectToInt(AOPreletnaMasaFrakcija8_16.getValue(), pogon.getPreleti().getFrakcijaBrDec()),
            Convert.objectToInt(AOPreletnaMasaFrakcija16_32.getValue(), pogon.getPreleti().getFrakcijaBrDec()),
            Convert.objectToInt(AOPreletnaMasaCement.getValue(), pogon.getPreleti().getCementBrDec()),
            Convert.objectToInt(AOPreletnaMasaFiler.getValue(), pogon.getPreleti().getFilerBrDec()),
            Convert.objectToInt(AOPreletnaMasaAditiv1.getValue(), pogon.getPreleti().getAditivBrDec()),
            Convert.objectToInt(AOPreletnaMasaAditiv2.getValue(), pogon.getPreleti().getAditivBrDec()),
            Convert.objectToInt(AOPreletnaMasaVoda.getValue(), pogon.getPreleti().getVodaBrDec())};

        mb.writeMWs(podaci, pogon.getPreleti().getFrakcija04Adresa());
    }
     
     public void getPreleti() {
        AOPreletnaMasaFrakcija0_4.setValue(Convert.shiftPointDouble(pogon.getPreleti().getFrakcija04(), pogon.getPreleti().getFrakcijaBrDec()));
        AOPreletnaMasaFrakcija4_8.setValue(Convert.shiftPointDouble(pogon.getPreleti().getFrakcija48(), pogon.getPreleti().getFrakcijaBrDec()));
        AOPreletnaMasaFrakcija8_16.setValue(Convert.shiftPointDouble(pogon.getPreleti().getFrakcija816(), pogon.getPreleti().getFrakcijaBrDec()));
        AOPreletnaMasaFrakcija16_32.setValue(Convert.shiftPointDouble(pogon.getPreleti().getFrakcija1632(), pogon.getPreleti().getFrakcijaBrDec()));
        AOPreletnaMasaCement.setValue(Convert.shiftPointDouble(pogon.getPreleti().getCement(), pogon.getPreleti().getCementBrDec()));
        AOPreletnaMasaFiler.setValue(Convert.shiftPointDouble(pogon.getPreleti().getFiler(), pogon.getPreleti().getFilerBrDec()));
        AOPreletnaMasaAditiv1.setValue(Convert.shiftPointDouble(pogon.getPreleti().getAditiv1(), pogon.getPreleti().getAditivBrDec()));
        AOPreletnaMasaAditiv2.setValue(Convert.shiftPointDouble(pogon.getPreleti().getAditiv2(), pogon.getPreleti().getAditivBrDec()));
        AOPreletnaMasaVoda.setValue(Convert.shiftPointDouble(pogon.getPreleti().getVoda(), pogon.getPreleti().getVodaBrDec()));
    }

    public JSpinner getAOPreletnaMasaAditiv1() {
        return AOPreletnaMasaAditiv1;
    }

    public JSpinner getAOPreletnaMasaAditiv2() {
        return AOPreletnaMasaAditiv2;
    }

    public JSpinner getAOPreletnaMasaCement() {
        return AOPreletnaMasaCement;
    }

    public JSpinner getAOPreletnaMasaFiler() {
        return AOPreletnaMasaFiler;
    }

    public JSpinner getAOPreletnaMasaFrakcija0_4() {
        return AOPreletnaMasaFrakcija0_4;
    }

    public JSpinner getAOPreletnaMasaFrakcija16_32() {
        return AOPreletnaMasaFrakcija16_32;
    }

    public JSpinner getAOPreletnaMasaFrakcija4_8() {
        return AOPreletnaMasaFrakcija4_8;
    }

    public JSpinner getAOPreletnaMasaFrakcija8_16() {
        return AOPreletnaMasaFrakcija8_16;
    }

    public JSpinner getAOPreletnaMasaVoda() {
        return AOPreletnaMasaVoda;
    }
     
     
}
