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
public class ZadatoIzdatoBeton {
    private int zadataKolicinaBetona;
    private int zadataKoličinaBetonaBrDec = 1;
    
    private int trenutnaKolicinaBetona;
    private int trenutnaKolicinaBetonaBrDec = 2;
    
    private int zadatiBrojSarzi;
    private int trenutniBrojSarzi;

    public int getZadataKolicinaBetona() {
        return zadataKolicinaBetona;
    }

    public void setZadataKolicinaBetona(int zadataKolicinaBetona) {
        this.zadataKolicinaBetona = zadataKolicinaBetona;
    }

    public int getTrenutnaKolicinaBetona() {
        return trenutnaKolicinaBetona;
    }

    public void setTrenutnaKolicinaBetona(int trenutnaKolicinaBetona) {
        this.trenutnaKolicinaBetona = trenutnaKolicinaBetona;
    }

    public int getZadatiBrojSarzi() {
        return zadatiBrojSarzi;
    }

    public void setZadatiBrojSarzi(int zadatiBrojSarzi) {
        this.zadatiBrojSarzi = zadatiBrojSarzi;
    }

    public int getTrenutniBrojSarzi() {
        return trenutniBrojSarzi;
    }

    public void setTrenutniBrojSarzi(int trenutniBrojSarzi) {
        this.trenutniBrojSarzi = trenutniBrojSarzi;
    }

    public int getZadataKoličinaBetonaBrDec() {
        return zadataKoličinaBetonaBrDec;
    }

    public int getTrenutnaKolicinaBetonaBrDec() {
        return trenutnaKolicinaBetonaBrDec;
    }
    
    
    
}
