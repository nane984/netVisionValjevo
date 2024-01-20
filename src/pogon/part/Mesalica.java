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
public class Mesalica {
    private int vremeMesanja = 0;
    private int vremePraznjenja = 0;
    
    private int vremeMesanjaSet = 0;
    private int vremePraznjenjaSet = 0;
    
    private Komanda otvori;
    private Komanda zatvori;
    
    private int strujaMesalice;
    private int strujaMesaliceBrDec;
    
    private final Komanda ukljucena;
    private final Komanda blokadaOtvaranjaMesalice;
    
    private boolean otvorena = false;
    private boolean zatvorena = false;
    private boolean puna = false;
    private boolean prazna = false;
    
    private int vremeMesanjaAdresa = 0;
    private int vremePraznjenjaAdresa = 0;

    private int punaAdresa = 0;
    private int praznaAdresa = 0;

    public Mesalica(){
        otvori = new Komanda();
        zatvori = new Komanda();
        ukljucena = new Komanda();
        
        otvori.setTipSlike(0);
        zatvori.setTipSlike(0);
        
        ukljucena.setTipSlike(6);
        
        strujaMesalice = 0;
        strujaMesaliceBrDec = 1;
        
        blokadaOtvaranjaMesalice = new Komanda();
        blokadaOtvaranjaMesalice.setKomandaAdresa(74);
    }

    public int getVremeMesanja() {
        return vremeMesanja;
    }

    public void setVremeMesanja(int vremeMesanja) {
        this.vremeMesanja = vremeMesanja;
    }

    public int getVremePraznjenja() {
        return vremePraznjenja;
    }

    public void setVremePraznjenja(int vremePraznjenja) {
        this.vremePraznjenja = vremePraznjenja;
    }

   
    public boolean getOtvorena() {
        return otvorena;
    }

    public void setOtvorena(boolean otvorena) {
        this.otvorena = otvorena;
    }

    public boolean getZatvorena() {
        return zatvorena;
    }

    public void setZatvorena(boolean zatvorena) {
        this.zatvorena = zatvorena;
    }

    public boolean getPuna() {
        return puna;
    }

    public void setPuna(boolean puna) {
        this.puna = puna;
    }

    public boolean getPrazna() {
        return prazna;
    }

    public void setPrazna(boolean prazna) {
        this.prazna = prazna;
    }

    public int getVremeMesanjaAdresa() {
        return vremeMesanjaAdresa;
    }

    public void setVremeMesanjaAdresa(int vremeMesanjaAdresa) {
        this.vremeMesanjaAdresa = vremeMesanjaAdresa;
    }

    public int getVremePraznjenjaAdresa() {
        return vremePraznjenjaAdresa;
    }

    public void setVremePraznjenjaAdresa(int vremePraznjenjaAdresa) {
        this.vremePraznjenjaAdresa = vremePraznjenjaAdresa;
    }


    public int getPunanaAdresa() {
        return punaAdresa;
    }

    public void setPunanaAdresa(int punanaAdresa) {
        this.punaAdresa = punanaAdresa;
    }

    public int getPraznaAdresa() {
        return praznaAdresa;
    }

    public void setPraznaAdresa(int praznaAdresa) {
        this.praznaAdresa = praznaAdresa;
    }

    public Komanda getOtvori() {
        return otvori;
    }

    public void setOtvori(Komanda otvori) {
        this.otvori = otvori;
    }

    public Komanda getZatvori() {
        return zatvori;
    }

    public void setZatvori(Komanda zatvori) {
        this.zatvori = zatvori;
    }

    public Komanda getUkljucena() {
        return ukljucena;
    }
    
     public int getStrujaMesalice() {
        return strujaMesalice;
    }

    public void setStrujaMesalice(int strujaMesalice) {
        this.strujaMesalice = strujaMesalice;
    }

    public int getStrujaMesaliceBrDec() {
        return strujaMesaliceBrDec;
    }

    public Komanda getBlokadaOtvaranjaMesalice() {
        return blokadaOtvaranjaMesalice;
    }

    public int getVremeMesanjaSet() {
        return vremeMesanjaSet;
    }

    public void setVremeMesanjaSet(int vremeMesanjaSet) {
        this.vremeMesanjaSet = vremeMesanjaSet;
    }

    public int getVremePraznjenjaSet() {
        return vremePraznjenjaSet;
    }

    public void setVremePraznjenjaSet(int vremePraznjenjaSet) {
        this.vremePraznjenjaSet = vremePraznjenjaSet;
    }
    
    
}
