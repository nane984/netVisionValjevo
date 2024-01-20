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
public class Vaga {
    private int tezina = 0;
    private final Komanda komanda;
    private boolean izdozirano;
    private boolean zatvorenaVaga;
    private boolean vagaPuna;
    
    private final Komanda vibracija;
    
    private final Komanda tariranje;
    
    private int brDec = 0;
        
    private int tezinaAdresa = 0;

    public Vaga(){
        komanda = new Komanda();
        komanda.setTipSlike(0);
        vibracija = new Komanda();
        vibracija.setTipSlike(7);
        tariranje = new Komanda();
        tariranje.setTipSlike(5);
    }

    public int getTezina() {
        return tezina;
    }

    public void setTezina(int tezina) {
        this.tezina = tezina;
    }

    public int getTezinaAdresa() {
        return tezinaAdresa;
    }

    public void setTezinaAdresa(int tezinaAdresa) {
        this.tezinaAdresa = tezinaAdresa;
    }

    public int getBrDec() {
        return brDec;
    }

    public void setBrDec(int brDec) {
        this.brDec = brDec;
    }

    public Komanda getKomanda() {
        return komanda;
    }

    public boolean getIzdozirano() {
        return izdozirano;
    }
    
    public void setIzdozirano(boolean izdozirano) {
        this.izdozirano = izdozirano;
    }

    public boolean isZatvorenaVaga() {
        return zatvorenaVaga;
    }

    public void setZatvorenaVaga(boolean zatvorenaVaga) {
        this.zatvorenaVaga = zatvorenaVaga;
    }

    public Komanda getVibracija() {
        return vibracija;
    }

    public Komanda getTariranje() {
        return tariranje;
    }

    public boolean getVagaPuna() {
        return vagaPuna;
    }

    public void setVagaPuna(boolean vagaPuna) {
        this.vagaPuna = vagaPuna;
    }

   
}
