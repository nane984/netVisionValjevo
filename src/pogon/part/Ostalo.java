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
public class Ostalo {
    private final Komanda hidropumpaUkljucena;
    private final Komanda kompresorUkljucen;
    private final Komanda rucnoAutomatski;
    
    private int vlaznostBetona;
    private final int vlaznostBetonaBrDec;
    
    private boolean otpremaZavrsena;
    private boolean sarzaZavrsena;
    
    private final int otpremaZavrsenaAdresa;
    private final int sarzaZavrsenaAdresa;
    

    private final Komanda startCiklus;
    private final Komanda zavrsiCiklus;
    private final Komanda stopCiklus;
    
    private boolean SelectSilosCement = false;
    private boolean SelectFilerCement = false;
    
    private int korigovanoF1;
    private int korigovanaVoda;
    private boolean aktivnaKorekcijapoVlagi;
    
    private final int aktivnaKorekcijapoVlagiAdresa;

    public Ostalo(){
        hidropumpaUkljucena = new Komanda();
        kompresorUkljucen = new Komanda();
        rucnoAutomatski = new Komanda();
        rucnoAutomatski.setKomanda(false);
        startCiklus = new Komanda();
        zavrsiCiklus = new Komanda();
        stopCiklus = new Komanda();
        
        hidropumpaUkljucena.setTipSlike(4);
        kompresorUkljucen.setTipSlike(4);
        
        startCiklus.setKomandaAdresa(63);
        zavrsiCiklus.setKomandaAdresa(64);
        stopCiklus.setKomandaAdresa(65);
        
        vlaznostBetona = 0;
        vlaznostBetonaBrDec=1;
        
        sarzaZavrsenaAdresa = 66;
        otpremaZavrsenaAdresa = 67;
        
        korigovanoF1 = 0;
        korigovanaVoda = 0;
        
        aktivnaKorekcijapoVlagi = false;
        
        aktivnaKorekcijapoVlagiAdresa = 75;
    }

    public Komanda getStartCiklus() {
        return startCiklus;
    }

    public Komanda getZavrsiCiklus() {
        return zavrsiCiklus;
    }

    public Komanda getStopCiklus() {
        return stopCiklus;
    }
   
    public Komanda getHidropumpaUkljucena() {
        return hidropumpaUkljucena;
    }

    public Komanda getKompresorUkljucen() {
        return kompresorUkljucen;
    }

    public Komanda getRucnoAutomatski() {
        return rucnoAutomatski;
    }

    public boolean getSelectSilosCement() {
        return SelectSilosCement;
    }

    public void setSelectSilosCement(boolean SelectSilosCement) {
        this.SelectSilosCement = SelectSilosCement;
    }

    public boolean getSelectFilerCement() {
        return SelectFilerCement;
    }

    public void setSelectFilerCement(boolean SelectFilerCement) {
        this.SelectFilerCement = SelectFilerCement;
    }

    public int getVlaznostBetona() {
        return vlaznostBetona;
    }


    public void setVlaznostBetona(int vlaznostBetona) {
        this.vlaznostBetona = vlaznostBetona;
    }

    public int getVlaznostBetonaBrDec() {
        return vlaznostBetonaBrDec;
    }

   

    public boolean getOtpremaZavrsena() {
        return otpremaZavrsena;
    }

    public void setOtpremaZavrsena(boolean otpremaZavrsena) {
        this.otpremaZavrsena = otpremaZavrsena;
    }

    public boolean getSarzaZavrsena() {
        return sarzaZavrsena;
    }

    public void setSarzaZavrsena(boolean sarzaZavrsena) {
        this.sarzaZavrsena = sarzaZavrsena;
    }

    public int getOtpremaZavrsenaAdresa() {
        return otpremaZavrsenaAdresa;
    }

    public int getSarzaZavrsenaAdresa() {
        return sarzaZavrsenaAdresa;
    }

    public int getKorigovanoF1() {
        return korigovanoF1;
    }

    public void setKorigovanoF1(int korigovanoF1) {
        this.korigovanoF1 = korigovanoF1;
    }

    public int getKorigovanaVoda() {
        return korigovanaVoda;
    }

    public void setKorigovanaVoda(int korigovanaVoda) {
        this.korigovanaVoda = korigovanaVoda;
    }

    public boolean isAktivnaKorekcijapoVlagi() {
        return aktivnaKorekcijapoVlagi;
    }

    public void setAktivnaKorekcijapoVlagi(boolean aktivnaKorekcijapoVlagi) {
        this.aktivnaKorekcijapoVlagi = aktivnaKorekcijapoVlagi;
    }

    public int getAktivnaKorekcijapoVlagiAdresa() {
        return aktivnaKorekcijapoVlagiAdresa;
    }
}
