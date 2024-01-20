/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pogon.Pogon;

/**
 *
 * @author branko.scekic
 */
public class Buff implements Runnable{

    private final Mxl mxl;
    private InetAddress ip;
    private final Pogon pogon;
    
    private boolean writeRegister;
    private boolean writeRegisters;
    private boolean writeDigital;
    private boolean writeRegistersPlusTwoParticularRegister;
    private int offsetDig;
    private int offsetReg;
    private boolean mxValue;
    private int mwValue;
    private int[] mwValues;
    
    private int value1;
    private int value1addres;
    private int value2;
    private int value2addres;
    
    private int [] resMerenja;
    private boolean[] resultDigitalInput;
    private boolean[] resultDigitalMemory;
    
    private int defaultOffsetMX;   
    private int defaultOffsetMW;
    
    
    public Buff (Pogon pogon){
        mxl = new Mxl();
        this.pogon = pogon;
    }
    
        
    public void setIpAdresa(String address, int mw, int mx){
        //defaultOffsetMW = 4000; //4000;
        //defaultOffsetMX = 3200; //3200;
        defaultOffsetMW = mw; //4000;
        defaultOffsetMX = mx; //3200;
        try {
            ip = InetAddress.getByName(address);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Buff.class.getName()).log(Level.SEVERE, null, ex);
        }
        mxl.setIp(ip);
        
    }
    
    public void openConnection() {
        mxl.openConnection();
    }

    public void closeConnection() {
        mxl.closeConnection();
    }

    public boolean ping() {
        return mxl.ping();
    }
    
    
    
    @Override
    public void run() {
        if(ping()){
            openConnection();
        }
        
        while(Mxl.conOk){
           getMerenja();
            getDigitalni();
            writeDigit();
            writeRegister();
            writeRegisters();
            writeRegistersPlusTwo();
        }
        
    }
    
    
    private synchronized void getMerenja(){
        resMerenja = mxl.readRegisters(defaultOffsetMW, 88);
    
        pogon.getAgregat0_4().setZadato(resMerenja[0]);
        pogon.getAgregat0_4().setIzdato(resMerenja[1]);
        pogon.getAgregat4_8().setZadato(resMerenja[2]);
        pogon.getAgregat4_8().setIzdato(resMerenja[3]);
        pogon.getAgregat8_16().setZadato(resMerenja[4]);
        pogon.getAgregat8_16().setIzdato(resMerenja[5]);
        pogon.getAgregat16_32().setZadato(resMerenja[6]);
        pogon.getAgregat16_32().setIzdato(resMerenja[7]);
        pogon.getCement().setZadato(resMerenja[8]);
        pogon.getCement().setIzdato(resMerenja[9]);
        pogon.getFiler().setZadato(resMerenja[10]);
        pogon.getFiler().setIzdato(resMerenja[11]);
        pogon.getAditiv1().setZadato(resMerenja[12]);
        pogon.getAditiv1().setIzdato(resMerenja[13]);
        pogon.getAditiv2().setZadato(resMerenja[14]);
        pogon.getAditiv2().setIzdato(resMerenja[15]);
        pogon.getVoda().setZadato(resMerenja[16]);
        pogon.getVoda().setIzdato(resMerenja[17]);
        
        pogon.getZadatoIzdoziranoBeton().setZadataKolicinaBetona(resMerenja[18]);
        pogon.getZadatoIzdoziranoBeton().setTrenutnaKolicinaBetona(resMerenja[19]);
        pogon.getZadatoIzdoziranoBeton().setZadatiBrojSarzi(resMerenja[20]);
        pogon.getZadatoIzdoziranoBeton().setTrenutniBrojSarzi(resMerenja[21]);
        
        pogon.getVagaCement().setTezina(resMerenja[24]);
        
        pogon.getVagaVoda().setTezina(resMerenja[26]);
        
        pogon.getVagaAditiv().setTezina(resMerenja[28]);
        
        pogon.getTraka().setTezina(resMerenja[30]);
        pogon.getCement().setProcenjenaKolicinaSilos1Nizi(resMerenja[31]);
        pogon.getCement().setProcenjenaKolicinaSilos1Visi(resMerenja[32]);
        pogon.getCement().setProcenjenaKolicinaSilos2Nizi(resMerenja[33]);
        pogon.getCement().setProcenjenaKolicinaSilos2Visi(resMerenja[34]);
        pogon.getAgregat0_4().setProcenjenaKolicinaSilosNizi(resMerenja[35]);
        pogon.getAgregat0_4().setProcenjenaKolicinaSilosVisi(resMerenja[36]);
        pogon.getAgregat4_8().setProcenjenaKolicinaSilosNizi(resMerenja[37]);
        pogon.getAgregat4_8().setProcenjenaKolicinaSilosVisi(resMerenja[38]);
        pogon.getAgregat8_16().setProcenjenaKolicinaSilosNizi(resMerenja[39]);
        pogon.getAgregat8_16().setProcenjenaKolicinaSilosVisi(resMerenja[40]);
        pogon.getAgregat16_32().setProcenjenaKolicinaSilosNizi(resMerenja[41]);
        pogon.getAgregat16_32().setProcenjenaKolicinaSilosVisi(resMerenja[42]);
        pogon.getAditiv1().setProcenjenaKolicinaSilosNizi(resMerenja[43]);
        pogon.getAditiv1().setProcenjenaKolicinaSilosVisi(resMerenja[44]);
        pogon.getAditiv2().setProcenjenaKolicinaSilosNizi(resMerenja[45]);
        pogon.getAditiv2().setProcenjenaKolicinaSilosVisi(resMerenja[46]);
        pogon.getMesalica().setVremeMesanja(resMerenja[47]);
        pogon.getMesalica().setVremePraznjenja(resMerenja[48]);
        
        pogon.getPreleti().setFrakcija04(resMerenja[49]);
        pogon.getPreleti().setFrakcija48(resMerenja[50]);
        pogon.getPreleti().setFrakcija816(resMerenja[51]);
        pogon.getPreleti().setFrakcija1632(resMerenja[52]);
        pogon.getPreleti().setCement(resMerenja[53]);
        pogon.getPreleti().setFiler(resMerenja[54]);
        pogon.getPreleti().setAditiv1(resMerenja[55]);
        pogon.getPreleti().setAditiv2(resMerenja[56]);
        pogon.getPreleti().setVoda(resMerenja[57]);
        
        pogon.getParametri().setVremeSmirivanjaVageFrakcije(resMerenja[58]);
        pogon.getParametri().setVremePraznjenjaVageFrakcije(resMerenja[59]);
        pogon.getParametri().setZadrskaNaStartKoseTrake(resMerenja[60]);
        pogon.getParametri().setVremePraznjenjaKoseTrake(resMerenja[61]);
        pogon.getParametri().setKontrolnoVremeKoseTrake(resMerenja[62]);
        pogon.getParametri().setZadrskaNaDoziranjeVode(resMerenja[63]);
        pogon.getParametri().setZadrskaNaDoziranjeCementa(resMerenja[64]);
        pogon.getParametri().setZadatoVremeMesanjaMaterijala(resMerenja[65]);
        pogon.getParametri().setPocetnoOtvaranjeMesalice(resMerenja[66]);
        pogon.getParametri().setVremePocetnogPraznjenjaMesalice(resMerenja[67]);
        pogon.getParametri().setVremePraznjenjaMesalice(resMerenja[68]);
        pogon.getParametri().setVremeIspiranjaVageAditiva(resMerenja[69]);
        pogon.getParametri().setVremeSmirivanjaVageAditiva(resMerenja[70]);
        pogon.getParametri().setVremeSmirivanjaVageCementa(resMerenja[71]);
        pogon.getParametri().setPauzaFluidizacije(resMerenja[72]);
        pogon.getParametri().setRadFluidizacije(resMerenja[73]);
        pogon.getParametri().setKapacitetMesalice(resMerenja[74]);
        pogon.getMesalica().setStrujaMesalice(resMerenja[75]);
        pogon.getOstalo().setVlaznostBetona(resMerenja[76]);
        
        
        //privremenooo
        pogon.setZbirnaFrakcija1(resMerenja[77]);
        pogon.setZbirnaFrakcija2(resMerenja[78]);
        pogon.setZbirnaFrakcija3(resMerenja[79]);
        pogon.setZbirnaFrakcija4(resMerenja[80]);
        pogon.setZbirniCement(resMerenja[81]);
        pogon.setZbirniFiler(resMerenja[82]);
        pogon.setZbirniAditiv1(resMerenja[83]);
        pogon.setZbirniAditiv2(resMerenja[84]);
        pogon.setZbirnaVoda(resMerenja[85]);
        
        pogon.getOstalo().setKorigovanoF1(resMerenja[86]);
        pogon.getOstalo().setKorigovanaVoda(resMerenja[87]);
        
    }
    
    private synchronized void getDigitalni(){
        resultDigitalMemory = mxl.readMX(defaultOffsetMX, 76);
        
        pogon.getOstalo().getRucnoAutomatski().setKomanda(resultDigitalMemory[0]);
        pogon.getCement().getKomanda().setKomanda(resultDigitalMemory[1]);
        pogon.getFiler().getKomanda().setKomanda(resultDigitalMemory[2]);
        pogon.getVagaCement().getKomanda().setKomanda(resultDigitalMemory[3]);
        pogon.getVagaCement().setIzdozirano(resultDigitalMemory[4]);
        pogon.getVagaCement().setZatvorenaVaga(resultDigitalMemory[5]);
        pogon.getVoda().getKomanda().setKomanda(resultDigitalMemory[6]);
        pogon.getVagaVoda().getKomanda().setKomanda(resultDigitalMemory[7]);
        pogon.getVagaVoda().setIzdozirano(resultDigitalMemory[8]);
        pogon.getVagaVoda().setZatvorenaVaga(resultDigitalMemory[9]);
        pogon.getAditiv1().getKomanda().setKomanda(resultDigitalMemory[10]);
        pogon.getAditiv2().getKomanda().setKomanda(resultDigitalMemory[11]);
        pogon.getVagaAditiv().getKomanda().setKomanda(resultDigitalMemory[12]);
        pogon.getVagaAditiv().setIzdozirano(resultDigitalMemory[13]);
        pogon.getVagaAditiv().setZatvorenaVaga(resultDigitalMemory[14]);
        pogon.getAgregat0_4().getKomanda().setKomanda(resultDigitalMemory[15]);
        pogon.getAgregat4_8().getKomanda().setKomanda(resultDigitalMemory[16]);
        pogon.getAgregat8_16().getKomanda().setKomanda(resultDigitalMemory[17]);
        pogon.getAgregat16_32().getKomanda().setKomanda(resultDigitalMemory[18]);
        pogon.getTraka().getRunTraka1().setKomanda(resultDigitalMemory[19]);
        pogon.getTraka().getRunTraka2().setKomanda(resultDigitalMemory[20]);
        pogon.getTraka().setIzdozirano(resultDigitalMemory[21]);
        pogon.getMesalica().setOtvorena(resultDigitalMemory[22]);
        pogon.getMesalica().setZatvorena(resultDigitalMemory[23]);
        pogon.getMesalica().getOtvori().setKomanda(resultDigitalMemory[24]);
        pogon.getMesalica().getZatvori().setKomanda(resultDigitalMemory[25]);
        pogon.getMesalica().setPuna(resultDigitalMemory[26]);
        pogon.getMesalica().setPrazna(resultDigitalMemory[27]);
        pogon.getOstalo().getKompresorUkljucen().setKomanda(resultDigitalMemory[28]);
        pogon.getOstalo().getHidropumpaUkljucena().setKomanda(resultDigitalMemory[29]);
        pogon.getMesalica().getUkljucena().setKomanda(resultDigitalMemory[30]);
        pogon.getAgregat0_4().getVibracija().setKomanda(resultDigitalMemory[68]);
        pogon.getVagaCement().getVibracija().setKomanda(resultDigitalMemory[32]);
        pogon.getTraka().getVibracija().setKomanda(resultDigitalMemory[31]);
        pogon.getCement().getFluidizacija().setKomanda(resultDigitalMemory[33]);
        pogon.getFiler().getFluidizacija().setKomanda(resultDigitalMemory[34]);
       
        pogon.getTraka().getTariranje().setKomanda(resultDigitalMemory[36]);
        pogon.getVagaCement().getTariranje().setKomanda(resultDigitalMemory[37]);
        pogon.getVagaAditiv().getTariranje().setKomanda(resultDigitalMemory[38]);
        pogon.getVagaVoda().getTariranje().setKomanda(resultDigitalMemory[39]);
        
        pogon.getVoda().getIspiranjeVageAditiva().setKomanda(resultDigitalMemory[62]);
        
        pogon.getOstalo().setSarzaZavrsena(resultDigitalMemory[66]);
        pogon.getOstalo().setOtpremaZavrsena(resultDigitalMemory[67]);
        
        
        pogon.getTraka().setKosaTrakaPrazna(resultDigitalMemory[70]);
        pogon.getVagaCement().setVagaPuna(resultDigitalMemory[71]);
        pogon.getVagaVoda().setVagaPuna(resultDigitalMemory[72]);
        pogon.getVagaAditiv().setVagaPuna(resultDigitalMemory[73]);
        pogon.getMesalica().getBlokadaOtvaranjaMesalice().setKomanda(resultDigitalMemory[74]);
        
        pogon.getOstalo().setAktivnaKorekcijapoVlagi(resultDigitalMemory[75]);
        
    }
    
    private synchronized void writeDigit() {
        if (writeDigital) {
            mxl.writeMX(offsetDig + defaultOffsetMX, mxValue);
            writeDigital = false;
        }
    }
    
    private synchronized void writeRegister() {
        if (writeRegister) {
            mxl.writeRegister(offsetReg + defaultOffsetMW, mwValue);
            writeRegister = false;
        }
    }
    
    private synchronized void writeRegisters() {
        if (writeRegisters) {
            mxl.writeRegisters(offsetReg + defaultOffsetMW, mwValues);
            writeRegisters = false;
        }
    }
    
    private synchronized void writeRegistersPlusTwo() {
        if (writeRegistersPlusTwoParticularRegister) {
            mxl.writeRegisters(offsetReg + defaultOffsetMW, mwValues);
            mxl.writeRegister(value1addres + defaultOffsetMW, value1);
            mxl.writeRegister(value2addres + defaultOffsetMW, value2);
            writeRegistersPlusTwoParticularRegister = false;
        }
    }
    
    public void writeMX(boolean mxValue, int offset){
        this.writeDigital = true;
        this.mxValue = mxValue;
        this.offsetDig = offset;
    }
    
    public void writeMW(int mwValue, int offset){
        this.writeRegister = true;
        this.mwValue = mwValue;
        this.offsetReg = offset;
    }
    
    public void writeMWs(int[] mwValues, int offset){
        this.writeRegisters = true;
        this.mwValues = mwValues;
        this.offsetReg = offset;
    }
    
    public void writeMWsPlusTwoRegisters(int[] mwValues, int offset, int mwValue1, int addres1, int mwValue2, int addres2){
        this.writeRegistersPlusTwoParticularRegister = true;
        this.mwValues = mwValues;
        this.offsetReg = offset;
        this.value1 = mwValue1;
        this.value1addres = addres1;
        this.value2 = mwValue2;
        this.value2addres = addres2;       
    }
}
