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
public class Agregat {
    private int zadato = 0;
    private int izdato = 0;
    private final Komanda komanda;
    
    private final Komanda vibracija;
    
    private final int brDec = 0;
   
    private int zadatoAdresa = 0;
    private int izdatoAdresa = 0;
    
    private int procenjenaKolicinaSilosNizi = 0;
    private int procenjenaKolicinaSilosVisi = 0;

    private int kapacitetSilos = 200;
  

    public Agregat(){
        komanda = new Komanda();
        komanda.setTipSlike(0);
        vibracija = new Komanda();
        vibracija.setTipSlike(7);
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

    public int getProcenjenaKolicinaSilosNizi() {
        return procenjenaKolicinaSilosNizi;
    }

    public void setProcenjenaKolicinaSilosNizi(int procenjenaKolicinaSilosNizi) {
        this.procenjenaKolicinaSilosNizi = procenjenaKolicinaSilosNizi;
    }

    public int getProcenjenaKolicinaSilosVisi() {
        return procenjenaKolicinaSilosVisi;
    }

    public void setProcenjenaKolicinaSilosVisi(int procenjenaKolicinaSilosVisi) {
        this.procenjenaKolicinaSilosVisi = procenjenaKolicinaSilosVisi;
    }

    public int getKapacitetSilos() {
        return kapacitetSilos;
    }

    public void setKapacitetSilos(int kapacitetSilos) {
        this.kapacitetSilos = kapacitetSilos;
    }

    public Komanda getVibracija() {
        return vibracija;
    }

   
    
    
}
