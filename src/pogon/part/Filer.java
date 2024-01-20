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
public class Filer {
    private int zadato = 0;
    private int izdato = 0;
    private final Komanda komanda;
    
     private final Komanda fluidizacija;
    
    private final int brDec = 0;
       
    private int zadatoAdresa = 0;
    private int izdatoAdresa = 0;
    
    public Filer(){
        komanda = new Komanda();
        komanda.setTipSlike(1);
        
        fluidizacija = new Komanda();
        fluidizacija.setKomandaAdresa(47);
        fluidizacija.setTipSlike(7);
    }

    public int getZadato() {
        return zadato;
    }

    public void setZadato(int zadato) {
        this.zadato = zadato;
    }

    public int getIzdato() {
        return izdato;
    }

    public void setIzdato(int izdato) {
        this.izdato = izdato;
    }

    public int getZadatoAdresa() {
        return zadatoAdresa;
    }

    public void setZadatoAdresa(int zadatoAdresa) {
        this.zadatoAdresa = zadatoAdresa;
    }

    public int getIzdatoAdresa() {
        return izdatoAdresa;
    }

    public void setIzdatoAdresa(int izdatoAdresa) {
        this.izdatoAdresa = izdatoAdresa;
    }

    public int getBrDec() {
        return brDec;
    }
  
    public Komanda getKomanda() {
        return komanda;
    }

    public Komanda getFluidizacija() {
        return fluidizacija;
    }
    
    
  
}
