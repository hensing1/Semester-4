/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReinRaus;

import java.io.Serializable;

/**
 *
 * @author ADL_LEHMANN26
 */
public class NochEinAuto implements Serializable{
    private String bezeichnung;
    private int anzahlRaeder;
    
    public NochEinAuto(String bez, int anz) {
        this.bezeichnung = bez;
        this.anzahlRaeder = anz;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getAnzahlRaeder() {
        return anzahlRaeder;
    }

    public void setAnzahlRaeder(int anzahlRaeder) {
        this.anzahlRaeder = anzahlRaeder;
    }
}
