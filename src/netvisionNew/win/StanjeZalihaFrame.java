/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netvisionNew.win;

import com.Buff;
import dbService.StanjeZalihaService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.Timer;
import pogon.Pogon;
import utils.Convert;

/**
 *
 * @author branko.scekic
 */
public class StanjeZalihaFrame extends javax.swing.JFrame {

    /**
     * Creates new form StanjeZalihaFrame
     * @param stanjeZalihaDb
     * @param pogon
     * @param mb
     */
    public StanjeZalihaFrame(StanjeZalihaService stanjeZalihaDb, Pogon pogon) {
        initComponents();
        
        URL iconURL = getClass().getResource("/img/logo.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        
        this.stanjeZalihaDb = stanjeZalihaDb;
        this.pogon = pogon;
        
        refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jButtonStanjeZalihaOdustani = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jButtonDodajStannjeZaliha = new javax.swing.JButton();
        StanjeZalihaFrakcija04 = new javax.swing.JLabel();
        StanjeZalihaFrakcija48 = new javax.swing.JLabel();
        StanjeZalihaFrakcija816 = new javax.swing.JLabel();
        StanjeZalihaFrakcija1632 = new javax.swing.JLabel();
        StanjeZalihaCement = new javax.swing.JLabel();
        StanjeZalihaFiler = new javax.swing.JLabel();
        StanjeZalihaAditiv1 = new javax.swing.JLabel();
        StanjeZalihaAditiv2 = new javax.swing.JLabel();
        DodajZaliheFrakcija04 = new javax.swing.JSpinner();
        DodajZaliheFrakcija48 = new javax.swing.JSpinner();
        DodajZaliheFrakcija816 = new javax.swing.JSpinner();
        DodajZaliheFrakcija1632 = new javax.swing.JSpinner();
        DodajZaliheCement = new javax.swing.JSpinner();
        DodajZaliheFiler = new javax.swing.JSpinner();
        DodajZaliheAditiv1 = new javax.swing.JSpinner();
        DodajZaliheAditiv2 = new javax.swing.JSpinner();

        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jLabel32.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Stanje zaliha");

        jButtonStanjeZalihaOdustani.setText("Odustani");
        jButtonStanjeZalihaOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStanjeZalihaOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jButtonStanjeZalihaOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonStanjeZalihaOdustani, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        jLabel35.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel35.setText("1. Frakcija 0-4 mm");

        jLabel39.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel39.setText("2. Frakcija 4-8 mm");

        jLabel40.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel40.setText("3. Frakcija 8-16 mm");

        jLabel41.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("4. Frakcija 16-32 mm");

        jLabel42.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel42.setText("5. Cement");

        jLabel43.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel43.setText("6. Filer");

        jLabel44.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText("7. Aditiv A1");

        jLabel45.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel45.setText("8. Aditiv A2");

        jButtonDodajStannjeZaliha.setText("Dodaj");
        jButtonDodajStannjeZaliha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajStannjeZalihaActionPerformed(evt);
            }
        });

        StanjeZalihaFrakcija04.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        StanjeZalihaFrakcija04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StanjeZalihaFrakcija04.setText("0");

        StanjeZalihaFrakcija48.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        StanjeZalihaFrakcija48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StanjeZalihaFrakcija48.setText("0");

        StanjeZalihaFrakcija816.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        StanjeZalihaFrakcija816.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StanjeZalihaFrakcija816.setText("0");

        StanjeZalihaFrakcija1632.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        StanjeZalihaFrakcija1632.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StanjeZalihaFrakcija1632.setText("0");

        StanjeZalihaCement.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        StanjeZalihaCement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StanjeZalihaCement.setText("0");

        StanjeZalihaFiler.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        StanjeZalihaFiler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StanjeZalihaFiler.setText("0");

        StanjeZalihaAditiv1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        StanjeZalihaAditiv1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StanjeZalihaAditiv1.setText("0");

        StanjeZalihaAditiv2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        StanjeZalihaAditiv2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StanjeZalihaAditiv2.setText("0");

        DodajZaliheFrakcija04.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(-10000.0f), Float.valueOf(900000.0f), Float.valueOf(1.0f)));

        DodajZaliheFrakcija48.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(-10000.0f), Float.valueOf(900000.0f), Float.valueOf(1.0f)));

        DodajZaliheFrakcija816.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(-10000.0f), Float.valueOf(900000.0f), Float.valueOf(1.0f)));

        DodajZaliheFrakcija1632.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(-10000.0f), Float.valueOf(900000.0f), Float.valueOf(1.0f)));

        DodajZaliheCement.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(-10000.0f), Float.valueOf(900000.0f), Float.valueOf(1.0f)));

        DodajZaliheFiler.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(-10000.0f), Float.valueOf(900000.0f), Float.valueOf(1.0f)));

        DodajZaliheAditiv1.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(-10000.0f), Float.valueOf(30000.0f), Float.valueOf(1.0f)));

        DodajZaliheAditiv2.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(-10000.0f), Float.valueOf(30000.0f), Float.valueOf(1.0f)));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jButtonDodajStannjeZaliha, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(StanjeZalihaFrakcija04, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(StanjeZalihaFrakcija48, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(StanjeZalihaFrakcija816, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(StanjeZalihaFrakcija1632, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(StanjeZalihaCement, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(StanjeZalihaFiler, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(StanjeZalihaAditiv1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(StanjeZalihaAditiv2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DodajZaliheFrakcija04, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DodajZaliheFrakcija48, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DodajZaliheFrakcija816, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DodajZaliheFrakcija1632, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DodajZaliheCement, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DodajZaliheFiler, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DodajZaliheAditiv1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DodajZaliheAditiv2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StanjeZalihaFrakcija04)
                    .addComponent(DodajZaliheFrakcija04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StanjeZalihaFrakcija48)
                    .addComponent(DodajZaliheFrakcija48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StanjeZalihaFrakcija816)
                    .addComponent(DodajZaliheFrakcija816, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StanjeZalihaFrakcija1632)
                    .addComponent(DodajZaliheFrakcija1632, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StanjeZalihaCement)
                    .addComponent(DodajZaliheCement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StanjeZalihaFiler)
                    .addComponent(DodajZaliheFiler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StanjeZalihaAditiv1)
                    .addComponent(DodajZaliheAditiv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StanjeZalihaAditiv2)
                    .addComponent(DodajZaliheAditiv2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonDodajStannjeZaliha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStanjeZalihaOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStanjeZalihaOdustaniActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonStanjeZalihaOdustaniActionPerformed

    private void jButtonDodajStannjeZalihaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajStannjeZalihaActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Da li želite da sačuvate?", "Upozorenje",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            //stanjeZalihaDb.setStanjeZaliha();
            setStanjeZaliha();
        }
    }//GEN-LAST:event_jButtonDodajStannjeZalihaActionPerformed

    public JSpinner getDodajZaliheAditiv1() {
        return DodajZaliheAditiv1;
    }

    public JSpinner getDodajZaliheAditiv2() {
        return DodajZaliheAditiv2;
    }

    public JSpinner getDodajZaliheCement() {
        return DodajZaliheCement;
    }

    public JSpinner getDodajZaliheFiler() {
        return DodajZaliheFiler;
    }

    public JSpinner getDodajZaliheFrakcija04() {
        return DodajZaliheFrakcija04;
    }

    public JSpinner getDodajZaliheFrakcija1632() {
        return DodajZaliheFrakcija1632;
    }

    public JSpinner getDodajZaliheFrakcija48() {
        return DodajZaliheFrakcija48;
    }

    public JSpinner getDodajZaliheFrakcija816() {
        return DodajZaliheFrakcija816;
    }

    public JLabel getStanjeZalihaAditiv1() {
        return StanjeZalihaAditiv1;
    }

    public JLabel getStanjeZalihaAditiv2() {
        return StanjeZalihaAditiv2;
    }

    public JLabel getStanjeZalihaCement() {
        return StanjeZalihaCement;
    }

    public JLabel getStanjeZalihaFiler() {
        return StanjeZalihaFiler;
    }

    public JLabel getStanjeZalihaFrakcija04() {
        return StanjeZalihaFrakcija04;
    }

    public JLabel getStanjeZalihaFrakcija1632() {
        return StanjeZalihaFrakcija1632;
    }

    public JLabel getStanjeZalihaFrakcija48() {
        return StanjeZalihaFrakcija48;
    }

    public JLabel getStanjeZalihaFrakcija816() {
        return StanjeZalihaFrakcija816;
    }
    
    
    public void getStanjeZaliha(){
        //List<db.Stanjezaliha> result = stanjeZalihaDb.getStanjeZaliha();
        
        //silos1Cement.setMaxValue(pogon.getCement().getKapacitetSilos1());
        StanjeZalihaCement.setText(Convert.doubleToString(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getCement().getProcenjenaKolicinaSilos1Visi(), pogon.getCement().getProcenjenaKolicinaSilos1Nizi(), pogon.getCement().getBrDec())));
        //silos2Cement.setMaxValue(pogon.getCement().getKapacitetSilos2());
        StanjeZalihaFiler.setText(Convert.doubleToString(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getCement().getProcenjenaKolicinaSilos2Visi(), pogon.getCement().getProcenjenaKolicinaSilos2Nizi(), pogon.getCement().getBrDec())));
        
        //silos1Aditiv.setMaxValue(pogon.getAditiv1().getKapacitetSilos());
        StanjeZalihaAditiv1.setText(Convert.doubleToString(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAditiv1().getProcenjenaKolicinaSilosVisi(), pogon.getAditiv1().getProcenjenaKolicinaSilosNizi(), pogon.getAditiv1().getBrDec())));
        //silos2Aditiv.setMaxValue(pogon.getAditiv2().getKapacitetSilos());
        StanjeZalihaAditiv2.setText(Convert.doubleToString(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAditiv2().getProcenjenaKolicinaSilosVisi(), pogon.getAditiv2().getProcenjenaKolicinaSilosNizi(), pogon.getAditiv2().getBrDec())));
        
        //silosAgregat04.setMaxValue(pogon.getAgregat0_4().getKapacitetSilos());
        StanjeZalihaFrakcija04.setText(Convert.doubleToString(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat0_4().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat0_4().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat0_4().getBrDec())));
        //silosAgregat48.setMaxValue(pogon.getAgregat4_8().getKapacitetSilos());
        StanjeZalihaFrakcija48.setText(Convert.doubleToString(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat4_8().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat4_8().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat4_8().getBrDec())));
        //silosAgregat816.setMaxValue(pogon.getAgregat8_16().getKapacitetSilos());
        StanjeZalihaFrakcija816.setText(Convert.doubleToString(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat8_16().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat8_16().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat8_16().getBrDec())));
        //silosAgregat1632.setMaxValue(pogon.getAgregat16_32().getKapacitetSilos());
        StanjeZalihaFrakcija1632.setText(Convert.doubleToString(Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat16_32().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat16_32().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat16_32().getBrDec())));
    }
    
    public void setMb(Buff mb){
        this.mb = mb;
    }
    
    public void setStanjeZaliha(){
        double cem = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getCement().getProcenjenaKolicinaSilos1Visi(), pogon.getCement().getProcenjenaKolicinaSilos1Nizi(), pogon.getCement().getBrDec());
        double fil = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getCement().getProcenjenaKolicinaSilos2Visi(), pogon.getCement().getProcenjenaKolicinaSilos2Nizi(), pogon.getCement().getBrDec());
        double agr04 = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat0_4().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat0_4().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat0_4().getBrDec());
        double agr48 = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat4_8().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat4_8().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat4_8().getBrDec());
        double agr816 = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat8_16().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat8_16().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat8_16().getBrDec());
        double agr1632 = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAgregat16_32().getProcenjenaKolicinaSilosVisi(), pogon.getAgregat16_32().getProcenjenaKolicinaSilosNizi(), pogon.getAgregat16_32().getBrDec());
        double ad1 = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAditiv1().getProcenjenaKolicinaSilosVisi(), pogon.getAditiv1().getProcenjenaKolicinaSilosNizi(), 0);
        double ad2 = Convert.getTwoRegisterIntShiftPointToDouble(pogon.getAditiv2().getProcenjenaKolicinaSilosVisi(), pogon.getAditiv2().getProcenjenaKolicinaSilosNizi(), 0);
        
        int[] cement = Convert.convertDoubleToTwoInt((long) ((long) cem + Convert.stringToDouble(DodajZaliheCement.getValue().toString(),0)));
        int[] filer = Convert.convertDoubleToTwoInt((long) ((long) fil + Convert.stringToDouble(DodajZaliheFiler.getValue().toString(),0)));
        int[] agregat04 = Convert.convertDoubleToTwoInt((long) ((long) agr04 + Convert.stringToDouble(DodajZaliheFrakcija04.getValue().toString(),0)));
        int[] agregat48 = Convert.convertDoubleToTwoInt((long) ((long) agr48 + Convert.stringToDouble(DodajZaliheFrakcija48.getValue().toString(),0)));
        int[] agregat816 = Convert.convertDoubleToTwoInt((long) ((long) agr816 + Convert.stringToDouble(DodajZaliheFrakcija816.getValue().toString(),0)));
        int[] agregat1632 = Convert.convertDoubleToTwoInt((long) ((long) agr1632 + Convert.stringToDouble(DodajZaliheFrakcija1632.getValue().toString(),0)));
        
        int[] aditiv1 = Convert.convertDoubleToTwoInt((long) ((long) ad1 + Convert.stringToDouble(DodajZaliheAditiv1.getValue().toString(),2)));
        int[] aditiv2 = Convert.convertDoubleToTwoInt((long) ((long) ad2 + Convert.stringToDouble(DodajZaliheAditiv2.getValue().toString(),2)));
        
        
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
        
        resetSpinner();
    }
    
    private void resetSpinner(){
        DodajZaliheCement.setValue(0);
        DodajZaliheFiler.setValue(0);
        DodajZaliheFrakcija04.setValue(0);
        DodajZaliheFrakcija48.setValue(0);
        DodajZaliheFrakcija816.setValue(0);
        DodajZaliheFrakcija1632.setValue(0);
        DodajZaliheAditiv1.setValue(0);
        DodajZaliheAditiv2.setValue(0);
    }
    
    private void refresh() {
        timer = new Timer(1000, new ActionListener() {  //1000 1 sec
            @Override
            public void actionPerformed(ActionEvent e) {
                getStanjeZaliha();
            }

        });
        timer.start();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner DodajZaliheAditiv1;
    private javax.swing.JSpinner DodajZaliheAditiv2;
    private javax.swing.JSpinner DodajZaliheCement;
    private javax.swing.JSpinner DodajZaliheFiler;
    private javax.swing.JSpinner DodajZaliheFrakcija04;
    private javax.swing.JSpinner DodajZaliheFrakcija1632;
    private javax.swing.JSpinner DodajZaliheFrakcija48;
    private javax.swing.JSpinner DodajZaliheFrakcija816;
    private javax.swing.JLabel StanjeZalihaAditiv1;
    private javax.swing.JLabel StanjeZalihaAditiv2;
    private javax.swing.JLabel StanjeZalihaCement;
    private javax.swing.JLabel StanjeZalihaFiler;
    private javax.swing.JLabel StanjeZalihaFrakcija04;
    private javax.swing.JLabel StanjeZalihaFrakcija1632;
    private javax.swing.JLabel StanjeZalihaFrakcija48;
    private javax.swing.JLabel StanjeZalihaFrakcija816;
    private javax.swing.JButton jButtonDodajStannjeZaliha;
    private javax.swing.JButton jButtonStanjeZalihaOdustani;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    // End of variables declaration//GEN-END:variables
    public final StanjeZalihaService stanjeZalihaDb;
    private Buff mb;
    private final Pogon pogon;
    private Timer timer;
}
