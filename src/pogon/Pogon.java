/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pogon;

import pogon.part.Aditiv;
import pogon.part.Agregat;
import pogon.part.Cement;
import pogon.part.Filer;
import pogon.part.Mesalica;
import pogon.part.Ostalo;
import pogon.part.PreletnaMasa;
import pogon.part.SelektorSilosa;
import pogon.part.Traka;
import pogon.part.Vaga;
import pogon.part.Voda;
import pogon.part.ZadatoIzdatoBeton;
import pogon.part.ZbirniParametri;

/**
 *
 * @author branko.scekic
 */
public class Pogon {
   
    private final Agregat agregat0_4;
    private final Agregat agregat4_8;
    private final Agregat agregat8_16;
    private final Agregat agregat16_32;
    
    private final Cement cement;
      
    private final Filer filer;
    
    private final Aditiv aditiv1;
    private final Aditiv aditiv2;
    
    private final Voda voda;
    
    private final Vaga vagaCement;
    private final Vaga vagaVoda;
    private final Vaga vagaAditiv;
    
    private final Traka traka;
    
    private final Mesalica mesalica;
    
    private final Ostalo ostalo;
    
    private final PreletnaMasa preleti;
    private final ZbirniParametri parametri;
    
    private final ZadatoIzdatoBeton zadatoIzdoziranoBeton;
    
    private final SelektorSilosa selektorSilosa;
    
    private int zbirnaFrakcija1;
    private int zbirnaFrakcija2;
    private int zbirnaFrakcija3;
    private int zbirnaFrakcija4;
    private int zbirniCement;
    private int zbirniFiler;
    private int zbirniAditiv1;
    private int zbirniAditiv2;
    private int zbirnaVoda;
    

    public Pogon(){
        agregat0_4 = new Agregat();
        agregat4_8 = new Agregat(); 
        agregat8_16 = new Agregat(); 
        agregat16_32 = new Agregat(); 
        cement = new Cement();               
        filer = new Filer();
        aditiv1 = new Aditiv();
        aditiv2 = new Aditiv();
        voda = new Voda();
        vagaCement = new Vaga();
        vagaVoda = new Vaga();
        vagaAditiv = new Vaga();
        vagaAditiv.setBrDec(2);
        traka = new Traka();
        
        mesalica = new Mesalica();
        
        ostalo = new Ostalo(); 
        
        preleti = new PreletnaMasa();
  
        parametri = new ZbirniParametri();
        
        zadatoIzdoziranoBeton = new ZadatoIzdatoBeton();
        
        selektorSilosa = new SelektorSilosa(); 
        
     
        agregat0_4.getKomanda().setKomandaAdresa(40);
        agregat0_4.getVibracija().setKomandaAdresa(68);
        agregat4_8.getKomanda().setKomandaAdresa(41);
        agregat8_16.getKomanda().setKomandaAdresa(42);
        agregat16_32.getKomanda().setKomandaAdresa(43);
        
        
        cement.getKomanda().setKomandaAdresa(44);
        //cement.getFluidizacija().setKomandaAdresa(20);
        filer.getKomanda().setKomandaAdresa(45);
        //filer.getFluidizacija().setKomandaAdresa(21);
        
        vagaCement.getKomanda().setKomandaAdresa(46);
        vagaCement.getVibracija().setKomandaAdresa(47);
        vagaCement.getTariranje().setKomandaAdresa(37);
        
        aditiv1.getKomanda().setKomandaAdresa(48);
        aditiv2.getKomanda().setKomandaAdresa(49);
        vagaAditiv.getKomanda().setKomandaAdresa(50);
        vagaAditiv.getTariranje().setKomandaAdresa(38);
     
        voda.getKomanda().setKomandaAdresa(52);
        vagaVoda.getKomanda().setKomandaAdresa(53);
        vagaVoda.getTariranje().setKomandaAdresa(39);
        voda.getIspiranjeVageAditiva().setKomandaAdresa(51);
        
        mesalica.getUkljucena().setKomandaAdresa(54);
        ostalo.getKompresorUkljucen().setKomandaAdresa(55);
        ostalo.getHidropumpaUkljucena().setKomandaAdresa(56);
        
        mesalica.setVremeMesanjaAdresa(58 + 7);
        mesalica.setVremePraznjenjaAdresa(58 + 10);
       
        traka.getRunTraka1().setKomandaAdresa(57);
        traka.getRunTraka2().setKomandaAdresa(59);
        traka.getTariranje().setKomandaAdresa(36);
        traka.getVibracija().setKomandaAdresa(58);
        mesalica.getOtvori().setKomandaAdresa(60);
        mesalica.getZatvori().setKomandaAdresa(61);
       
        selektorSilosa.setSelektovanSilosAdresa(35);
        
      
    }

    public Agregat getAgregat0_4() {
        return agregat0_4;
    }

    public Agregat getAgregat4_8() {
        return agregat4_8;
    }

    public Agregat getAgregat8_16() {
        return agregat8_16;
    }

    public Agregat getAgregat16_32() {
        return agregat16_32;
    }

    public Cement getCement() {
        return cement;
    }
    
    
    public Filer getFiler() {
        return filer;
    }

    public Aditiv getAditiv1() {
        return aditiv1;
    }

    public Aditiv getAditiv2() {
        return aditiv2;
    }

    public Voda getVoda() {
        return voda;
    }

    public Vaga getVagaCement() {
        return vagaCement;
    }

    public Vaga getVagaVoda() {
        return vagaVoda;
    }

    public Vaga getVagaAditiv() {
        return vagaAditiv;
    }

    public Traka getTraka() {
        return traka;
    }

    public Mesalica getMesalica() {
        return mesalica;
    }

    public Ostalo getOstalo() {
        return ostalo;
    }

    public PreletnaMasa getPreleti() {
        return preleti;
    }

    public ZbirniParametri getParametri() {
        return parametri;
    }

    public ZadatoIzdatoBeton getZadatoIzdoziranoBeton() {
        return zadatoIzdoziranoBeton;
    }

    public SelektorSilosa getSelektorSilosa() {
        return selektorSilosa;
    }

    
    
    //privremeno
    public int getZbirnaFrakcija1() {
        return zbirnaFrakcija1;
    }

    public void setZbirnaFrakcija1(int zbirnaFrakcija1) {
        this.zbirnaFrakcija1 = zbirnaFrakcija1;
    }

    public int getZbirnaFrakcija2() {
        return zbirnaFrakcija2;
    }

    public void setZbirnaFrakcija2(int zbirnaFrakcija2) {
        this.zbirnaFrakcija2 = zbirnaFrakcija2;
    }

    public int getZbirnaFrakcija3() {
        return zbirnaFrakcija3;
    }

    public void setZbirnaFrakcija3(int zbirnaFrakcija3) {
        this.zbirnaFrakcija3 = zbirnaFrakcija3;
    }

    public int getZbirnaFrakcija4() {
        return zbirnaFrakcija4;
    }

    public void setZbirnaFrakcija4(int zbirnaFrakcija4) {
        this.zbirnaFrakcija4 = zbirnaFrakcija4;
    }

    public int getZbirniCement() {
        return zbirniCement;
    }

    public void setZbirniCement(int zbirniCement) {
        this.zbirniCement = zbirniCement;
    }

    public int getZbirniFiler() {
        return zbirniFiler;
    }

    public void setZbirniFiler(int zbirniFiler) {
        this.zbirniFiler = zbirniFiler;
    }

    public int getZbirniAditiv1() {
        return zbirniAditiv1;
    }

    public void setZbirniAditiv1(int zbirniAditiv1) {
        this.zbirniAditiv1 = zbirniAditiv1;
    }

    public int getZbirniAditiv2() {
        return zbirniAditiv2;
    }

    public void setZbirniAditiv2(int zbirniAditiv2) {
        this.zbirniAditiv2 = zbirniAditiv2;
    }

    public int getZbirnaVoda() {
        return zbirnaVoda;
    }

    public void setZbirnaVoda(int zbirnaVoda) {
        this.zbirnaVoda = zbirnaVoda;
    }

    
    
}