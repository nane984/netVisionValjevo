/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constatnt;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author branko.scekic
 */
public class Image {

    private final ImageIcon klapnuZatvori;
    private final ImageIcon klapnuOtvori;

    private final ImageIcon puznaPumpaOn;
    private final ImageIcon puznaPumpaOff;
    private final ImageIcon pumpaOn;
    private final ImageIcon pumpaOff;
    
    private final ImageIcon rucno;
    private final ImageIcon automatski;
    
    private final ImageIcon trakaOn;
    private final ImageIcon trakaOff;
    
    private final ImageIcon izdozirano;
    
    private final ImageIcon mesalicaOn;
    private final ImageIcon mesalicaOff;
    
    private final ImageIcon vibracijaOn;
    private final ImageIcon vibracijaOff;
    
    private final int klapne = 0;
    private final int puznePumpe = 1;
    private final int pumpe = 2;
    private final int rucnoAutomatski = 3;
    private final int trake = 4;
    private final int dozirano = 5;
    private final int mesalica = 6;
    private final int vibracija = 7;

    public Image() {
        klapnuZatvori = new ImageIcon(getClass().getResource(Link.klapnuZatvori));
        klapnuOtvori = new ImageIcon(getClass().getResource(Link.klapnuOtvori));

        puznaPumpaOn = new ImageIcon(getClass().getResource(Link.puznaPumpaOn));
        puznaPumpaOff = new ImageIcon(getClass().getResource(Link.puznaPumpaOff));
        pumpaOn = new ImageIcon(getClass().getResource(Link.pumpaOn));
        pumpaOff = new ImageIcon(getClass().getResource(Link.pumpaOff));
        
        rucno = new ImageIcon(getClass().getResource(Link.rucno));
        automatski = new ImageIcon(getClass().getResource(Link.automatski));
        
        trakaOn = new ImageIcon(getClass().getResource(Link.trakaOn));
        trakaOff = new ImageIcon(getClass().getResource(Link.trakaOff));
        
        izdozirano = new ImageIcon(getClass().getResource(Link.izdozirano));
        
        mesalicaOn = new ImageIcon(getClass().getResource(Link.mesalicaOn));
        mesalicaOff = new ImageIcon(getClass().getResource(Link.mesalicaOff));
        
        vibracijaOn = new ImageIcon(getClass().getResource(Link.vibroOn));
        vibracijaOff = new ImageIcon(getClass().getResource(Link.vibroOff));
    }

    public int getKlapne() {
        return klapne;
    }

    public int getPuznePumpe() {
        return puznePumpe;
    }

    public int getPumpe() {
        return pumpe;
    }

    public int getRucnoAutomatski() {
        return rucnoAutomatski;
    }

    public int getTrake() {
        return trake;
    }

    public int getDozirano() {
        return dozirano;
    }

    public int getMesalica() {
        return mesalica;
    }

    public int getVibracija() {
        return vibracija;
    }
    
    


    public void setImg(JLabel label, boolean vrednost, int tip) {

        switch (tip) {
            case 0:
                if (vrednost) {
                    label.setIcon(klapnuOtvori);
                } else {
                    label.setIcon(klapnuZatvori);
                }   break;
            case 1:
                if (vrednost) {
                    label.setIcon(puznaPumpaOn);
                } else {
                    label.setIcon(puznaPumpaOff);
                }   break;
            case 2:
                if (vrednost) {
                    label.setIcon(pumpaOn);
                } else {
                    label.setIcon(pumpaOff);
                }   break;
            case 3:
                if (vrednost) {
                    label.setIcon(rucno);
                } else {
                    label.setIcon(automatski);
                }   break;
            case 4:
                if (vrednost) {
                    label.setIcon(trakaOn);
                } else {
                    label.setIcon(trakaOff);
                }   break;
            case 5:
                if (vrednost) {
                    label.setIcon(izdozirano);
                } else {
                    label.setIcon(new ImageIcon());
                }   break;
            case 6:
                if (vrednost) {
                    label.setIcon(mesalicaOn);
                } else {
                    label.setIcon(mesalicaOff);
                }   break;
            case 7:
                if (vrednost) {
                    label.setIcon(vibracijaOn);
                } else {
                    label.setIcon(vibracijaOff);
                }   break;
            default:
                break;
        }
    }
    
    

}
