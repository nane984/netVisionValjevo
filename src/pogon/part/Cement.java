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
public class Cement {
    private int zadato = 0;
    private int izdato = 0;
    private final Komanda komanda;
    
    private final Komanda fluidizacija;
    
    private final int brDec = 0;
    
    private int zadatoAdresa = 0;
    private int izdatoAdresa = 0;
    
    private int procenjenaKolicinaSilos1Nizi = 0;
    private int procenjenaKolicinaSilos1Visi = 0;
    private int procenjenaKolicinaSilos2Nizi = 0;
    private int procenjenaKolicinaSilos2Visi = 0;
    
    private int kapacitetSilos1 = 20000;
    private int kapacitetSilos2 = 20000;
    
    
    public Cement(){
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

    public int getProcenjenaKolicinaSilos1Nizi() {
        return procenjenaKolicinaSilos1Nizi;
    }

    public void setProcenjenaKolicinaSilos1Nizi(int procenjenaKolicinaSilos1Nizi) {
        this.procenjenaKolicinaSilos1Nizi = procenjenaKolicinaSilos1Nizi;
    }

    public int getProcenjenaKolicinaSilos1Visi() {
        return procenjenaKolicinaSilos1Visi;
    }

    public void setProcenjenaKolicinaSilos1Visi(int procenjenaKolicinaSilos1Visi) {
        this.procenjenaKolicinaSilos1Visi = procenjenaKolicinaSilos1Visi;
    }

    public int getProcenjenaKolicinaSilos2Nizi() {
        return procenjenaKolicinaSilos2Nizi;
    }

    public void setProcenjenaKolicinaSilos2Nizi(int procenjenaKolicinaSilos2Nizi) {
        this.procenjenaKolicinaSilos2Nizi = procenjenaKolicinaSilos2Nizi;
    }

    public int getProcenjenaKolicinaSilos2Visi() {
        return procenjenaKolicinaSilos2Visi;
    }

    public void setProcenjenaKolicinaSilos2Visi(int procenjenaKolicinaSilos2Visi) {
        this.procenjenaKolicinaSilos2Visi = procenjenaKolicinaSilos2Visi;
    }

    public int getKapacitetSilos1() {
        return kapacitetSilos1;
    }

    public void setKapacitetSilos1(int kapacitetSilos1) {
        this.kapacitetSilos1 = kapacitetSilos1;
    }

    public int getKapacitetSilos2() {
        return kapacitetSilos2;
    }

    public void setKapacitetSilos2(int kapacitetSilos2) {
        this.kapacitetSilos2 = kapacitetSilos2;
    } 

    public Komanda getFluidizacija() {
        return fluidizacija;
    }
    
    
}
