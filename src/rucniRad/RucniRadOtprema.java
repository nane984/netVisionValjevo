/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rucniRad;

import utils.Convert;

/**
 *
 * @author branko.scekic
 */
public class RucniRadOtprema {

    private final RucniRadOtpremaElement frakcija1;
    private final RucniRadOtpremaElement frakcija2;
    private final RucniRadOtpremaElement frakcija3;
    private final RucniRadOtpremaElement frakcija4;

    private final RucniRadOtpremaElement vagaFrakcije;

    private final RucniRadOtpremaElement silos1;
    private final RucniRadOtpremaElement silos2;
    private final RucniRadOtpremaElement vagaCement;

    private final RucniRadOtpremaElement aditiv1;
    private final RucniRadOtpremaElement aditiv2;
    private final RucniRadOtpremaElement vagaAditiv;

    private final RucniRadOtpremaElement voda;
    private final RucniRadOtpremaElement vodaKaAditivu;
    private final RucniRadOtpremaElement vodaVaga;

    private boolean upisiUDB;

    public RucniRadOtprema() {
        upisiUDB = false;

        silos1 = new RucniRadOtpremaElement("SILOS 1");
        silos1.setVrednost(0);
        silos2 = new RucniRadOtpremaElement("SILOS 2");
        silos2.setVrednost(0);
        vagaCement = new RucniRadOtpremaElement("VAGA CEMENTA");

        frakcija1 = new RucniRadOtpremaElement("FRAKCIJA 1");
        frakcija1.setVrednost(0);
        frakcija2 = new RucniRadOtpremaElement("FRAKCIJA 2");
        frakcija2.setVrednost(0);
        frakcija3 = new RucniRadOtpremaElement("FRAKCIJA 3");
        frakcija3.setVrednost(0);
        frakcija4 = new RucniRadOtpremaElement("FRAKCIJA 4");
        frakcija4.setVrednost(0);
       
        vagaFrakcije = new RucniRadOtpremaElement("VAGA FRAKCIJE");

        aditiv1 = new RucniRadOtpremaElement("ADITIV 1");
        aditiv1.setVrednost(0);
        aditiv2 = new RucniRadOtpremaElement("ADITIV 2");
        aditiv2.setVrednost(0);
        vagaAditiv = new RucniRadOtpremaElement("VAGA ADITIV");

        voda = new RucniRadOtpremaElement("VODA IZ SILOSA");
        voda.setVrednost(0);
        vodaVaga = new RucniRadOtpremaElement("VAGA VODE");

        vodaKaAditivu = new RucniRadOtpremaElement("VODA IZ SILOSA KA ADITIVU");
    }

    public RucniRadOtpremaElement getSilos1() {
        return silos1;
    }

    public RucniRadOtpremaElement getSilos2() {
        return silos2;
    }

    public RucniRadOtpremaElement getVagaCement() {
        return vagaCement;
    }

    public RucniRadOtpremaElement getFrakcija1() {
        return frakcija1;
    }

    public RucniRadOtpremaElement getFrakcija2() {
        return frakcija2;
    }

    public RucniRadOtpremaElement getFrakcija3() {
        return frakcija3;
    }

    public RucniRadOtpremaElement getFrakcija4() {
        return frakcija4;
    }
    
    public RucniRadOtpremaElement getVagaFrakcije() {
        return vagaFrakcije;
    }

    public RucniRadOtpremaElement getAditiv1() {
        return aditiv1;
    }

    public RucniRadOtpremaElement getAditiv2() {
        return aditiv2;
    }

    public RucniRadOtpremaElement getVagaAditiv() {
        return vagaAditiv;
    }

    public RucniRadOtpremaElement getVoda() {
        return voda;
    }

    public RucniRadOtpremaElement getVodaKaAditivu() {
        return vodaKaAditivu;
    }

    public RucniRadOtpremaElement getVodaVaga() {
        return vodaVaga;
    }

    public boolean isUpisiUDB() {
        return upisiUDB;
    }

    public void setUpisiUDB(boolean upisiUDB) {
        this.upisiUDB = upisiUDB;
    }
    
    

    public void writeData() {
        silos1.setVrednost(getPotrosenoSilos(silos1));
        silos2.setVrednost(getPotrosenoSilos(silos2));
        vagaCement.setVrednost(getPotrosenoVaga(vagaCement));
        frakcija1.setVrednost(getPotrosenoSilos(frakcija1));
        frakcija2.setVrednost(getPotrosenoSilos(frakcija2));
        frakcija3.setVrednost(getPotrosenoSilos(frakcija3));
        frakcija4.setVrednost(getPotrosenoSilos(frakcija4));
        vagaFrakcije.setVrednost(getPotrosenoVaga(vagaFrakcije));
        aditiv1.setVrednost(getPotrosenoSilos(aditiv1));
        aditiv2.setVrednost(getPotrosenoSilos(aditiv2));
        vagaAditiv.setVrednost(getPotrosenoSilos(vagaAditiv));
        voda.setVrednost(getPotrosenoSilos(voda));
        vodaVaga.setVrednost(getPotrosenoVaga(vodaVaga));
        setUpisiUDB(true);
    }

    private double getPotrosenoSilos(RucniRadOtpremaElement element) {
        if (element.isPromenaVrednosti()) {
            double result = element.getUkupnaVrednost();
            element.setUkupnaVrednost(0);
            element.setPromenaVrednosti(false);
            
            
            
            return result;
        } else {
            element.setPromenaVrednosti(false);
            return 0;
        }

    }

    private double getPotrosenoVaga(RucniRadOtpremaElement element) {
        if (element.isPromenaVrednosti()) {
            double result = element.getUkupnaVrednost();
            element.setUkupnaVrednost(0);
            element.setPromenaVrednosti(false);
            return result;
        } else {
            element.setPromenaVrednosti(false);
            return 0;
        }
    }

    public void setDataSilos(boolean komanda, RucniRadOtpremaElement element, int tezina, int brDec) {
        if (komanda && element.isUnesiPocetak()) {
            element.setPromenaVrednosti(true);
            element.setVrednosVagePocetak(Convert.shiftPointDouble(tezina, brDec));
            element.setUnesiPocetak(false);
            element.setUnesiKraj(true);
            
            System.out.println(element.getOpis() + " getVrednosVagePocetak "+ element.getVrednosVagePocetak());
        }
        if (!komanda && element.isUnesiKraj()) {
            element.setVrednosVageKraj(Convert.shiftPointDouble(tezina, brDec));
            element.setUnesiKraj(false);
            element.setUkupnaVrednost((element.getVrednosVageKraj() - element.getVrednosVagePocetak()) + element.getUkupnaVrednost());
            
            System.out.println(element.getOpis() + " GetVrednosVageKraj "+ element.getVrednosVageKraj());
        }
    }
    
    public void setDataVaga(boolean komanda, RucniRadOtpremaElement element, int tezina, int brDec) {
        if (komanda && element.isUnesiPocetak()) {
            element.setPromenaVrednosti(true);
            element.setVrednosVagePocetak(Convert.shiftPointDouble(tezina, brDec));
            element.setUnesiPocetak(false);
            element.setUnesiKraj(true);
            
            System.out.println(element.getOpis() + " getVrednosVagePocetak "+ element.getVrednosVagePocetak());
        }
        if (!komanda && element.isUnesiKraj()) {
            element.setVrednosVageKraj(Convert.shiftPointDouble(tezina, brDec));
            element.setUnesiKraj(false);
            element.setUkupnaVrednost((element.getVrednosVagePocetak() - element.getVrednosVageKraj()) + element.getUkupnaVrednost());
            
            System.out.println(element.getOpis() + " GetVrednosVageKraj "+ element.getVrednosVageKraj());
        }
    }
}
