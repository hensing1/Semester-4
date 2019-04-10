/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstraktUndCo;

import java.util.*;


/**
 *
 * @author lukasalbani
 */
public class Main {
    public static void main(String[] args) {
        UebungsaufgabenCollections();
        UebungsHashTables();
        
    }
    
    public static void UebungsaufgabenCollections() {
        Vector vWieVendetta = new Vector();
  
        vWieVendetta.add(new Auto(2017, false, 4, 130));
        vWieVendetta.add(new Auto(2019, false, 4, 120));
        vWieVendetta.add(new Auto(2018, true, 26, 4500));
        
        for (int i= 0; i < vWieVendetta.size(); i++) {
            System.out.println(vWieVendetta.get(i).toString());
        }
    }


    public static void UebungsHashTables() {
        String[] marken = {"bmw", "mercedes", "vw", "bentley", "porsche"};
        
        int[] baujahr = {1997, 2008, 2019, 2018, 1999};
        Hashtable ht = new Hashtable();
        
        
        for (int i = 0; i < marken.length; i++) {
           ht.put(marken[i], new Auto(baujahr[i],false, 4, 333));
            // autoboxing -- "4711" wird zu einem Objekt der Wrapper-Klasse Integer
        }
        
        System.out.println(ht.get("bmw"));
        System.out.println("Anzahl der Elemente: " +ht.size());
        Enumeration e = ht.elements();
        
        while (e.hasMoreElements()) {
            Auto mycar = (Auto) e.nextElement();
            System.out.println("Baujahr: " + mycar.getBaujahr());
            
        }
        
    }
}