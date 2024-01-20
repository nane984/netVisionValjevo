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
public class RucniRadOtpremaElement {

    private final String opis;
    private double vrednosVagePocetak;
    private double vrednosVageKraj;
    private boolean unesiPocetak  = false;
    private boolean unesiKraj  = false;
    private boolean promenaVrednosti = false;
    private double vrednost = 0;
    private double ukupnaVrednost = 0;
 
    
    public RucniRadOtpremaElement(String opis){
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }

    public double getVrednosVagePocetak() {
        return vrednosVagePocetak;
    }

    public void setVrednosVagePocetak(double vrednosVagePocetak) {
        this.vrednosVagePocetak = vrednosVagePocetak;
    }

    public double getVrednosVageKraj() {
        return vrednosVageKraj;
    }

    public void setVrednosVageKraj(double vrednosVageKraj) {
        this.vrednosVageKraj = vrednosVageKraj;
    }

    public boolean isUnesiKraj() {
        return unesiKraj;
    }

    public void setUnesiKraj(boolean unesiKraj) {
        this.unesiKraj = unesiKraj;
    }

    public boolean isUnesiPocetak() {
        return unesiPocetak;
    }

    public void setUnesiPocetak(boolean unesiPocetak) {
        this.unesiPocetak = unesiPocetak;
    }

    public boolean isPromenaVrednosti() {
        return promenaVrednosti;
    }

    public void setPromenaVrednosti(boolean promenaVrednosti) {
        this.promenaVrednosti = promenaVrednosti;
    }

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
    }

    public double getUkupnaVrednost() {
        return ukupnaVrednost;
    }

    public void setUkupnaVrednost(double ukupnaVrednost) {
        this.ukupnaVrednost = ukupnaVrednost;
    }

    
}
