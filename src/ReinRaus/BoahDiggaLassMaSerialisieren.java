/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReinRaus;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 *
 * @author ADL_LEHMANN26
 */
public class BoahDiggaLassMaSerialisieren {
    public static void losJetzt() {
        NochEinAuto[] brumms = new NochEinAuto[] { 
            new NochEinAuto("Mercedesdings oder so", 4), 
            new NochEinAuto("VW vielleicht??? Ka stinkt jedenfalls", 4), 
            new NochEinAuto("Alte Boriskutsche, ein Rad ist abgefallen", 3)};
        
        for (int i = 0; i < brumms.length; i++) {
            if (brumms[i] instanceof Serializable) {
                OutputStream os = null;
                
                try {
                    os = new FileOutputStream(String.format("Auto%d", i + 1));
                    ObjectOutputStream oos = new ObjectOutputStream(os);
                    oos.writeObject(brumms[i]);
                }
                catch (IOException ioe) {
                    System.err.println("ACH DU SCHEISSE HOL DEN FLAMMENWERFER VERBRENNT DAS BEWEISMATERIAL SCHNELLLLL");
                    ioe.printStackTrace();
                }
            }
        }
    }
}
