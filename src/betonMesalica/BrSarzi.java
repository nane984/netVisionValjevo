/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package betonMesalica;

import javax.swing.JOptionPane;
import utils.Convert;

/**
 *
 * @author branko.scekic
 */
public class BrSarzi {

    private double mesalicaKapacitet;
    private double zadatoBetonaPoOtpremi;

    private double zadataKolicinaBetonaPoSarzi;
    private int zadatiBrojSarzi;

    private double agregat04;
    private double agregat48;
    private double agregat816;
    private double agregat1632;

    private double cement;
    private double filer;

    private double aditivA1;
    private double aditivA2;

    private double voda;

    public boolean isCalculatedBrSarzi(double zadataKubikaza, double preostalaKubikaza, double kapacitet,
            double agregat04, double agregat48, double agregat816, double agregat1632,
            double cement, double filer, double aditiva1, double aditiva2, double voda) {

        boolean result = false;

        if (isZadatoVeceIsporuceno(zadataKubikaza, preostalaKubikaza)) {

            setParameters(agregat04, agregat48, agregat816, agregat1632,
                    cement, filer, aditiva1, aditiva2, voda);

            this.mesalicaKapacitet = kapacitet;
            

            double delj = this.zadatoBetonaPoOtpremi / mesalicaKapacitet;
            double ostatak = this.zadatoBetonaPoOtpremi % mesalicaKapacitet;
            double round = Convert.round2Decimal(delj);
            double round1 = Convert.round2Decimal(ostatak);

            if (round1 != 0) {
                double res = Convert.cutDecimal(round);
                zadatiBrojSarzi = (int) (res + 1);
                zadataKolicinaBetonaPoSarzi = Convert.round2Decimal(this.zadatoBetonaPoOtpremi / zadatiBrojSarzi);
            } else {
                double res = Convert.cutDecimal(round);
                zadatiBrojSarzi = (int) res;
                zadataKolicinaBetonaPoSarzi = Convert.round2Decimal(this.zadatoBetonaPoOtpremi / zadatiBrojSarzi);
            }
            result = true;
        }

        return result;
    }

    private boolean isZadatoVeceIsporuceno(double zadataKubikaza, double preostalaKubikaza) {
        boolean result;
        if ((preostalaKubikaza - zadataKubikaza) >= 0) {
            this.zadatoBetonaPoOtpremi = zadataKubikaza;
            result = true;
        } else {
            if (JOptionPane.showConfirmDialog(null, "Zadata šarza je veća od preostale količine! Da li želite da napravite preostalu kolicinu?", "Upozorenje",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                this.zadatoBetonaPoOtpremi = preostalaKubikaza;
                result = true;  
            } else {
                result = false;
            }

        }

        return result;
    }

    private void setParameters(double agregat04, double agregat48, double agregat816, double agregat1632,
            double cement, double filer, double aditiva1, double aditiva2, double voda) {

        this.agregat04 = agregat04;
        this.agregat48 = agregat48;
        this.agregat816 = agregat816;
        this.agregat1632 = agregat1632;

        this.cement = cement;
        this.filer = filer;

        this.aditivA1 = aditiva1;
        this.aditivA2 = aditiva2;

        this.voda = voda;
    }
    

    public int getAgregat04() {
        return Convert.doubleToInt(agregat04 * zadataKolicinaBetonaPoSarzi, 0);
    }

    public int getAgregat48() {
        return Convert.doubleToInt(agregat48 * zadataKolicinaBetonaPoSarzi, 0);
    }

    public int getAgregat816() {
        return Convert.doubleToInt(agregat816 * zadataKolicinaBetonaPoSarzi, 0);
    }

    public int getAgregat1632() {
        return Convert.doubleToInt(agregat1632 * zadataKolicinaBetonaPoSarzi, 0);
    }

    public int getCement() {
        return Convert.doubleToInt(cement * zadataKolicinaBetonaPoSarzi, 0);
    }

    public int getFiler() {
        return Convert.doubleToInt(filer * zadataKolicinaBetonaPoSarzi, 0);
    }

    public int getAditivA1() {
        return Convert.doubleToInt(aditivA1 * zadataKolicinaBetonaPoSarzi, 2);
    }

    public int getAditivA2() {
        return Convert.doubleToInt(aditivA2 * zadataKolicinaBetonaPoSarzi, 2);
    }

    public int getVoda() {
        return Convert.doubleToInt(voda * zadataKolicinaBetonaPoSarzi, 0);
    }

    public void setVoda(double voda) {
        this.voda = voda;
    }

    public int getZadatiBrojSarzi() {
        return zadatiBrojSarzi;
    }

    public double getZadatoBetonaPoOtpremi() {
        return zadatoBetonaPoOtpremi;
    }

    public double getZadataKolicinaBetonaPoSarzi() {
        return zadataKolicinaBetonaPoSarzi;
    }

}
