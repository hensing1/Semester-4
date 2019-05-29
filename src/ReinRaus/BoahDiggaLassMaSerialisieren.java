/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReinRaus;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

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
        
        OutputStream os = null;
        try {
            os = new FileOutputStream(String.format("%s\\Autos", getPath()));
            ObjectOutputStream oos = new ObjectOutputStream(os);
            
            for (Object o : brumms) {
                if (o instanceof Serializable)
                    oos.writeObject(o);
            }
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        catch (IOException ioe) {
            System.err.println("ACH DU SCHEISSE HOL DEN FLAMMENWERFER VERBRENNT DAS BEWEISMATERIAL SCHNELLLLL");
            ioe.printStackTrace();
        }
        finally {
            try {
                os.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
    
    public static void lesenBildet() {
        ArrayList<NochEinAuto> autos = new ArrayList();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(String.format("%s\\Autos", getPath()))));
            while (true) {
                try {
                    autos.add((NochEinAuto) ois.readObject());
                }
                catch (EOFException eofe) {
                    break; //boah ist das behindert
                }
            }
        }
        catch (IOException ioe) {
            System.out.println("TJA IST JETZT DOOF NE");
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("Klasse? Welche Klasse?");
        }
        
        for (NochEinAuto auto : autos) {
            System.out.println("Auto:");
            System.out.println(String.format("  %s: %s", "Bezeichnung", auto.getBezeichnung()));
            System.out.println(String.format("  %s: %s", "Anzahl Räder", auto.getAnzahlRaeder()));
        }
    }
    
    private static String getPath() {
        File f = new File(System.getProperty("java.class.path"));
        File dir = f.getAbsoluteFile().getParentFile();
        return dir.toString();
    }
}
