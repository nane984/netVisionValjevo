/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author branko.scekic
 */
public class StatusRN {
    public static String getStatus(int i){
        switch(i){
            case 0:
                return "aktivan";
            case 1:
                return "zavrsen";
            case 2:
                return "prekinut";
            default:
                return "nedefinisan";
        }
    }
    
    private static final int Aktivan = 0;
    private static final int Zavrsen = 1;
    private static final int Prekinut = 2;
    private static final int Nedefinisan = 3;

    public static int getAktivan() {
        return Aktivan;
    }

    public static int getZavrsen() {
        return Zavrsen;
    }

    public static int getPrekinut() {
        return Prekinut;
    }

    public static int getNedefinisan() {
        return Nedefinisan;
    }
    
    
}
