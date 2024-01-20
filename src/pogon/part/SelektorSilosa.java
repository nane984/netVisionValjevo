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
public class SelektorSilosa {
    private double kolicinaFilera;
    private boolean koristiSeFiler;
    private int selektovanSilos2;
    private int selektovanSilosAdresa;

    public void setKolicinaFilera(double kolicinaFilera) {
        this.kolicinaFilera = kolicinaFilera;
    }
    
    public boolean isUseFiler(){
        if(kolicinaFilera<1){
            koristiSeFiler = false;
        }else{
            koristiSeFiler = true;
            selektovanSilos2 = 0;
        }
        return koristiSeFiler;
    }
    
    public void setSelectedSilos(boolean sel){
        if(isUseFiler()){
            if(sel){
                selektovanSilos2 = 0;
            }else{
                selektovanSilos2 = 1;
            }
        }
    }
    
    public boolean getSelectedSilos(){
        return selektovanSilos2 == 1;
    }

    public int getSelektovanSilosAdresa() {
        return selektovanSilosAdresa;
    }

    public void setSelektovanSilosAdresa(int selektovanSilosAdresa) {
        this.selektovanSilosAdresa = selektovanSilosAdresa;
    }
    
    
}
