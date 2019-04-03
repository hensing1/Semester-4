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
}
