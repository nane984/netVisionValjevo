/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rucniRad;

/**
 *
 * @author branko.scekic
 */
public class RucniRadElement {
    private final String opisZaStart;
    private final String opisZaEnd;
    //private final String adresaRegistra;
    
    private boolean bitStaraVrednost;
    private boolean bitNovaVrednost;
    
    private double vrednostTrenutnaStara;
    private double vrednostTrenutnaNova;
    
    
    
    private boolean trebaUpisatiUBazu;
    
    private String opisZaBazu;
    
    public int novoStanje;
    
    
    
    public RucniRadElement(String opisZaStart, String opisZaEnd){
        this.opisZaStart = opisZaStart;
        this.opisZaEnd = opisZaEnd;
    }

    public String getOpisZaStart() {
        return opisZaStart;
    }

    public String getOpisZaEnd() {
        return opisZaEnd;
    }
    

    public double getVrednostTrenutnaStara() {
        return vrednostTrenutnaStara;
    }

    public void setVrednostTrenutnaStara(double vrednostTrenutnaStara) {
        this.vrednostTrenutnaStara = vrednostTrenutnaStara;
    }

    public double getVrednostTrenutnaNova() {
        return vrednostTrenutnaNova;
    }

    public void setVrednostTrenutnaNova(double vrednostTrenutnaNova) {
        this.vrednostTrenutnaNova = vrednostTrenutnaNova;
    }


    public boolean getTrebaUpisatiUBazu() {
        return trebaUpisatiUBazu;
    }

    public void setTrebaUpisatiUBazu(boolean trebaUpisatiUBazu) {
        this.trebaUpisatiUBazu = trebaUpisatiUBazu;
    }

    public boolean getBitStaraVrednost() {
        return bitStaraVrednost;
    }

    public void setBitStaraVrednost(boolean bitStaraVrednost) {
        this.bitStaraVrednost = bitStaraVrednost;
    }

    public boolean getBitNovaVrednost() {
        return bitNovaVrednost;
    }

    public void setBitNovaVrednost(boolean bitNovaVrednost) {
        this.bitNovaVrednost = bitNovaVrednost;
    }

    public String getOpisZaBazu() {
        return opisZaBazu;
    }

    public void setOpisZaBazu(String opisZaBazu) {
        this.opisZaBazu = opisZaBazu;
    }

       
}
