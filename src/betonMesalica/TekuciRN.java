/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betonMesalica;

import db.Otprema;
import db.Radninalog;

/**
 *
 * @author branko.scekic
 */
public class TekuciRN {
    private db.Radninalog tekuciRN;
    private boolean readiTekuciRN = false;
    
    private db.Otprema tekucaOtp;
    private boolean readiTekucaOtp = false;
    
    
    public Radninalog getTekuciRN() {
        return tekuciRN;
    }

    public void setTekuciRN(Radninalog tekuciRN) {
        this.tekuciRN = tekuciRN;
    }

    public boolean isReadiTekuciRN() {
        return readiTekuciRN;
    }

    public void setReadiTekuciRN(boolean readiTekuciRN) {
        this.readiTekuciRN = readiTekuciRN;
    }

    public Otprema getTekucaOtp() {
        return tekucaOtp;
    }

    public void setTekucaOtp(Otprema tekucaOtp) {
        this.tekucaOtp = tekucaOtp;
    }

    public boolean isReadiTekucaOtp() {
        return readiTekucaOtp;
    }

    public void setReadiTekucaOtp(boolean readiTekucaOtp) {
        this.readiTekucaOtp = readiTekucaOtp;
    }
    
    
}
