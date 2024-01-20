/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rucniRad;


import pogon.Pogon;
import utils.Convert;



/**
 *
 * @author branko.scekic
 */
public class RucniRad {
   
   private final RucniRadElement frakcija1;
   private final RucniRadElement frakcija2;
   private final RucniRadElement frakcija3;
   private final RucniRadElement frakcija4;
   private final RucniRadElement vagaFrakcije;
   
   private final RucniRadElement silos1;
   private final RucniRadElement silos2;
   private final RucniRadElement vagaCement;
   
   
   private final RucniRadElement aditiv1;
   private final RucniRadElement aditiv2;
   private final RucniRadElement vagaAditiv;
   
   private final RucniRadElement mesalicaOtvaranje;
   private final RucniRadElement mesalicaZatvaranje;
   
   private final RucniRadElement voda;
   private final RucniRadElement vodaKaAditivu;
   private final RucniRadElement vodaVaga;
   
   
   private boolean rucnoAutomatskiStara;
   private boolean rucnoAutomatskiNova;
           
    
    public RucniRad(){
        rucnoAutomatskiStara = true;
        rucnoAutomatskiNova = true;
        
        silos1 = new RucniRadElement("START RUČNOG DOZIRANJA IZ SILOSA 1", "ZAVRŠETAK RUČNOG DOZIRANJA IZ SILOSA 1");
        silos2 = new RucniRadElement("START RUČNOG DOZIRANJA IZ SILOSA 2", "ZAVRŠETAK RUČNOG DOZIRANJA IZ SILOSA 2");
        vagaCement = new RucniRadElement("START RUČNOG PRAŽNJENJA VAGE CEMENTA", "ZAVRŠETAK RUČNOG PRAŽNJENJA VAGE CEMENTA");
        
        frakcija1 = new RucniRadElement("START RUČNOG DOZIRANJA FRAKCIJE 1", "ZAVRŠETAK RUČNOG DOZIRANJA FRAKCIJE 1");
        frakcija2 = new RucniRadElement("START RUČNOG DOZIRANJA FRAKCIJE 2", "ZAVRŠETAK RUČNOG DOZIRANJA FRAKCIJE 2");
        frakcija3 = new RucniRadElement("START RUČNOG DOZIRANJA FRAKCIJE 3", "ZAVRŠETAK RUČNOG DOZIRANJA FRAKCIJE 3");
        frakcija4 = new RucniRadElement("START RUČNOG DOZIRANJA FRAKCIJE 4", "ZAVRŠETAK RUČNOG DOZIRANJA FRAKCIJE 4");
        vagaFrakcije = new RucniRadElement("START RUČNOG PRAŽNJENJA VAGE FRAKCIJE", "ZAVRŠETAK RUČNOG PRAŽNJENJA VAGE FRAKCIJE");
        
        aditiv1 = new RucniRadElement("START RUČNOG DOZIRANJA ADITIVA 1", "ZAVRŠETAK RUČNOG DOZIRANJA ADITIVA 1");
        aditiv2 = new RucniRadElement("START RUČNOG DOZIRANJA ADITIVA 2", "ZAVRŠETAK RUČNOG DOZIRANJA ADITIVA 2");
        vagaAditiv = new RucniRadElement("START RUČNOG PRAŽNJENJA VAGE ADITIVA", "ZAVRŠETAK RUČNOG PRAŽNJENJA VAGE ADITIVA");
        
        mesalicaOtvaranje = new RucniRadElement("START RUČNOG OTVARANJA MEŠALICE","ZAVRŠETAK RUČNOG OTVARANJA MEŠALICE");
        mesalicaZatvaranje = new RucniRadElement("START RUČNOG ZATVARANJA MEŠALICE", "ZAVRŠETAK RUČNOG ZATVARANJA MEŠALICE");
        
        voda = new RucniRadElement("START RUČNOG DOZIRANJA VODE IZ SILOSA ", "ZAVRSETAK RUČNOG DOZIRANJA VODE IZ SILOSA");
        vodaVaga = new RucniRadElement("START RUČNOG PRAZNJENJA VAGE VODE", "ZAVRSETAK RUČNOG PRAZNJENJA VAGE VODE ");
        
        vodaKaAditivu = new RucniRadElement("START RUČNOG DOZIRANJA VODE IZ SILOSA KA ADITIVU", "ZAVRSETAK RUČNOG DOZIRANJA VODE IZ SILOSA KA ADITIVU");
    }

    public RucniRadElement getSilos1() {
        return silos1;
    }

    public RucniRadElement getSilos2() {
        return silos2;
    }

    public RucniRadElement getVagaCement() {
        return vagaCement;
    }

    public RucniRadElement getFrakcija1() {
        return frakcija1;
    }

    public RucniRadElement getFrakcija2() {
        return frakcija2;
    }

    public RucniRadElement getFrakcija3() {
        return frakcija3;
    }

    public RucniRadElement getFrakcija4() {
        return frakcija4;
    }

    public RucniRadElement getVagaFrakcije() {
        return vagaFrakcije;
    }

    public RucniRadElement getAditiv1() {
        return aditiv1;
    }

    public RucniRadElement getAditiv2() {
        return aditiv2;
    }

    public RucniRadElement getVagaAditiv() {
        return vagaAditiv;
    }

    public RucniRadElement getMesalicaOtvaranje() {
        return mesalicaOtvaranje;
    }

    public RucniRadElement getMesalicaZatvaranje() {
        return mesalicaZatvaranje;
    }

    public RucniRadElement getVoda() {
        return voda;
    }

    public RucniRadElement getVodaKaAditivu() {
        return vodaKaAditivu;
    }
    
    public RucniRadElement getVodaVaga() {
        return vodaVaga;
    }

    public boolean isRucnoAutomatskiStara() {
        return rucnoAutomatskiStara;
    }

    public boolean isRucnoAutomatskiNova() {
        return rucnoAutomatskiNova;
    }
    
    
    
   public RucniRadElement isChangeState(RucniRadElement element){
        //rucno 0 i 1    -start dozitanja  upis
        if(!rucnoAutomatskiNova &&  element.getBitNovaVrednost() && (element.getBitNovaVrednost() != element.getBitStaraVrednost())){
            element.setBitStaraVrednost(element.getBitNovaVrednost());
            rucnoAutomatskiStara = rucnoAutomatskiNova;
            element.setTrebaUpisatiUBazu(true);
            element.setVrednostTrenutnaStara(element.getVrednostTrenutnaNova());
            element.setOpisZaBazu(element.getOpisZaStart());
            element.novoStanje=10;
            //System.out.println(element.getOpisZaStart()+ " " + element.getVrednostTrenutnaNova());
            //System.out.println("upisace start");
        }
        
        //rucno 1    -end dozitanja upis
        if((rucnoAutomatskiNova != rucnoAutomatskiStara) || 
          (!rucnoAutomatskiNova && !element.getBitNovaVrednost()&&(element.getBitNovaVrednost()!=element.getBitStaraVrednost()))){
         
            element.setBitStaraVrednost(element.getBitNovaVrednost());
            rucnoAutomatskiStara = rucnoAutomatskiNova;
            element.setVrednostTrenutnaStara(element.getVrednostTrenutnaNova());
            
      
            if(element.novoStanje == 10){
                element.setTrebaUpisatiUBazu(true);
                element.setOpisZaBazu(element.getOpisZaEnd());
                element.novoStanje =5;
                //System.out.println(element.getOpisZaEnd() + " " + element.getVrednostTrenutnaNova());
                //System.out.println("upisace end");
            }
            
            
        }
        
        return element;
    }
   
   public void setDataFromModbus(Pogon pogon){
              
       rucnoAutomatskiNova = pogon.getOstalo().getRucnoAutomatski().getKomanda();
       
       silos1.setBitNovaVrednost(pogon.getCement().getKomanda().getKomanda());
       silos1.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec()));
       
       silos2.setBitNovaVrednost(pogon.getFiler().getKomanda().getKomanda());
       silos2.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec()));
             
       vagaCement.setBitNovaVrednost(pogon.getVagaCement().getKomanda().getKomanda());
       vagaCement.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec()));
       
       frakcija1.setBitNovaVrednost(pogon.getAgregat0_4().getKomanda().getKomanda());
       frakcija1.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       frakcija2.setBitNovaVrednost(pogon.getAgregat4_8().getKomanda().getKomanda());
       frakcija2.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       frakcija3.setBitNovaVrednost(pogon.getAgregat8_16().getKomanda().getKomanda());
       frakcija3.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       frakcija4.setBitNovaVrednost(pogon.getAgregat16_32().getKomanda().getKomanda());
       frakcija4.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       vagaFrakcije.setBitNovaVrednost(pogon.getTraka().getRunTraka1().getKomanda());
       vagaFrakcije.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       
       aditiv1.setBitNovaVrednost(pogon.getAditiv1().getKomanda().getKomanda());
       aditiv1.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));
       
       aditiv2.setBitNovaVrednost(pogon.getAditiv2().getKomanda().getKomanda());
       aditiv2.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));
       
       
       vagaAditiv.setBitNovaVrednost(pogon.getVagaAditiv().getKomanda().getKomanda());
       vagaAditiv.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));
       
       mesalicaOtvaranje.setBitNovaVrednost(pogon.getMesalica().getOtvori().getKomanda());
       mesalicaOtvaranje.setVrednostTrenutnaNova(shiftPointDouble(0, 0));
       
       mesalicaZatvaranje.setBitNovaVrednost(pogon.getMesalica().getZatvori().getKomanda());
       mesalicaZatvaranje.setVrednostTrenutnaNova(shiftPointDouble(0, 0));
       
       voda.setBitNovaVrednost(pogon.getVoda().getKomanda().getKomanda());
       voda.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaVoda().getTezina(), pogon.getVagaVoda().getBrDec()));
       
       vodaVaga.setBitNovaVrednost(pogon.getVagaVoda().getKomanda().getKomanda());
       vodaVaga.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaVoda().getTezina(), pogon.getVagaVoda().getBrDec()));
       
       vodaKaAditivu.setBitNovaVrednost(pogon.getVoda().getIspiranjeVageAditiva().getKomanda());
       vodaKaAditivu.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));
   }
   
   public void setInicializacija(Pogon pogon){
       
       rucnoAutomatskiStara = pogon.getOstalo().getRucnoAutomatski().getKomanda();
       rucnoAutomatskiNova = pogon.getOstalo().getRucnoAutomatski().getKomanda();
       
       silos1.setBitStaraVrednost(pogon.getFiler().getKomanda().getKomanda());
       silos1.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec()));
       
       silos2.setBitStaraVrednost(pogon.getFiler().getKomanda().getKomanda());
       silos2.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec()));
       
       vagaCement.setBitStaraVrednost(pogon.getVagaCement().getKomanda().getKomanda());
       vagaCement.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec()));
       
       frakcija1.setBitStaraVrednost(pogon.getAgregat0_4().getKomanda().getKomanda());
       frakcija1.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       frakcija2.setBitStaraVrednost(pogon.getAgregat4_8().getKomanda().getKomanda());
       frakcija2.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       frakcija3.setBitStaraVrednost(pogon.getAgregat8_16().getKomanda().getKomanda());
       frakcija3.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       frakcija4.setBitStaraVrednost(pogon.getAgregat16_32().getKomanda().getKomanda());
       frakcija4.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       vagaFrakcije.setBitStaraVrednost(pogon.getTraka().getRunTraka1().getKomanda());
       vagaFrakcije.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       
       aditiv1.setBitStaraVrednost(pogon.getAditiv1().getKomanda().getKomanda());
       aditiv1.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));
       
       aditiv2.setBitStaraVrednost(pogon.getAditiv2().getKomanda().getKomanda());
       aditiv2.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));

       vagaAditiv.setBitStaraVrednost(pogon.getVagaAditiv().getKomanda().getKomanda());
       vagaAditiv.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));
       
       mesalicaOtvaranje.setBitStaraVrednost(pogon.getMesalica().getZatvori().getKomanda());
       mesalicaOtvaranje.setVrednostTrenutnaStara(shiftPointDouble(0, 0));
       
       mesalicaZatvaranje.setBitStaraVrednost(pogon.getMesalica().getZatvori().getKomanda());
       mesalicaZatvaranje.setVrednostTrenutnaStara(shiftPointDouble(0, 0));
       
       voda.setBitStaraVrednost(pogon.getVoda().getKomanda().getKomanda());
       silos1.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getVagaVoda().getTezina(), pogon.getVagaVoda().getBrDec()));
       
       vodaVaga.setBitStaraVrednost(pogon.getVagaVoda().getKomanda().getKomanda());
       vodaVaga.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getVagaVoda().getTezina(), pogon.getVagaVoda().getBrDec()));
       
       vodaKaAditivu.setBitStaraVrednost(pogon.getVoda().getIspiranjeVageAditiva().getKomanda());
       vodaKaAditivu.setVrednostTrenutnaStara(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));
       
       
       silos1.setBitNovaVrednost(pogon.getCement().getKomanda().getKomanda());
       silos1.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec()));
       
       silos2.setBitNovaVrednost(pogon.getFiler().getKomanda().getKomanda());
       silos2.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec()));
             
       vagaCement.setBitNovaVrednost(!pogon.getVagaCement().getKomanda().getKomanda());
       vagaCement.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaCement().getTezina(), pogon.getVagaCement().getBrDec()));
       
       frakcija1.setBitNovaVrednost(pogon.getAgregat0_4().getKomanda().getKomanda());
       frakcija1.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       frakcija2.setBitNovaVrednost(pogon.getAgregat4_8().getKomanda().getKomanda());
       frakcija2.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       frakcija3.setBitNovaVrednost(pogon.getAgregat8_16().getKomanda().getKomanda());
       frakcija3.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       frakcija4.setBitNovaVrednost(pogon.getAgregat16_32().getKomanda().getKomanda());
       frakcija4.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       vagaFrakcije.setBitNovaVrednost(pogon.getTraka().getRunTraka1().getKomanda());
       vagaFrakcije.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getTraka().getTezina(), pogon.getTraka().getBrDec()));
       
       
       aditiv1.setBitNovaVrednost(pogon.getAditiv1().getKomanda().getKomanda());
       aditiv1.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));
       
       aditiv2.setBitNovaVrednost(pogon.getAditiv2().getKomanda().getKomanda());
       aditiv2.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));
       
       
       vagaAditiv.setBitNovaVrednost(pogon.getVagaAditiv().getKomanda().getKomanda());
       vagaAditiv.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));
       
       mesalicaOtvaranje.setBitNovaVrednost(pogon.getMesalica().getOtvori().getKomanda());
       mesalicaOtvaranje.setVrednostTrenutnaNova(shiftPointDouble(0, 0));
       
       mesalicaZatvaranje.setBitNovaVrednost(pogon.getMesalica().getZatvori().getKomanda());
       mesalicaZatvaranje.setVrednostTrenutnaNova(shiftPointDouble(0, 0));
       
       voda.setBitNovaVrednost(pogon.getVoda().getKomanda().getKomanda());
       silos1.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaVoda().getTezina(), pogon.getVagaVoda().getBrDec()));
       
       vodaVaga.setBitNovaVrednost(pogon.getVagaVoda().getKomanda().getKomanda());
       vodaVaga.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaVoda().getTezina(), pogon.getVagaVoda().getBrDec()));
       
       vodaKaAditivu.setBitNovaVrednost(pogon.getVoda().getIspiranjeVageAditiva().getKomanda());
       vodaKaAditivu.setVrednostTrenutnaNova(Convert.shiftPointDouble(pogon.getVagaAditiv().getTezina(), pogon.getVagaAditiv().getBrDec()));
       
   }

    public int shiftPointDouble(int a, int br) {
        try {
            int x = a;
            if(x>32768){  // zbog unsigned
                x= x - 65536;
            } 
            return x;
        } catch (Exception ex) {
            return 0;
        }
    }
}
