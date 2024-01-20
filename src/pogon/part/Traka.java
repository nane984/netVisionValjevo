/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pogon.part;

/**
 *
 * @author branko.scekic
 */
public class Traka {
    private final Komanda runTraka1;
    private final Komanda runTraka2;
    private boolean izdozirano = false;
    private boolean kosaTrakaPrazna = false;
    private int kosaTrakaPraznaAdresa;
    private int tezina = 0;
    
    private final int brDec = 0;
    
    private final Komanda vibracija;
    private final Komanda tariranje;

    private int izdoziranoAdresa = 0;
    private int tezinaAdresa = 0;

    public Traka(){
        runTraka1 = new Komanda();
        runTraka2 = new Komanda();
        
        runTraka1.setTipSlike(4);
        runTraka2.setTipSlike(4);
        
        tariranje = new Komanda();
        tariranje.setTipSlike(5);
        
        vibracija = new Komanda();
        vibracija.setTipSlike(7);
        
        kosaTrakaPraznaAdresa = 70;
    }
   
    public boolean isIzdozirano() {
        return izdozirano;
    }

    public void setIzdozirano(boolean izdozirano) {
        this.izdozirano = izdozirano;
    }

    public int getTezina() {
        return tezina;
    }

    public void setTezina(int tezina) {
        this.tezina = tezina;
    }

    public int getBrDec() {
        return brDec;
    }

    public int getIzdoziranoAdresa() {
        return izdoziranoAdresa;
    }

    public void setIzdoziranoAdresa(int izdoziranoAdresa) {
        this.izdoziranoAdresa = izdoziranoAdresa;
    }

    public int getTezinaAdresa() {
        return tezinaAdresa;
    }

    public void setTezinaAdresa(int tezinaAdresa) {
        this.tezinaAdresa = tezinaAdresa;
    }

    public Komanda getRunTraka1() {
        return runTraka1;
    }

    public Komanda getRunTraka2() {
        return runTraka2;
    }

    public Komanda getTariranje() {
        return tariranje;
    }

    public Komanda getVibracija() {
        return vibracija;
    }

    public boolean getKosaTrakaPrazna() {
        return kosaTrakaPrazna;
    }

    public void setKosaTrakaPrazna(boolean kosaTrakaPrazna) {
        this.kosaTrakaPrazna = kosaTrakaPrazna;
    }

    public int getKosaTrakaPraznaAdresa() {
        return kosaTrakaPraznaAdresa;
    }
    
    
    
}
