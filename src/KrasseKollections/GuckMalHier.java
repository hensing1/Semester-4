/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KrasseKollections;

import AbstraktUndCo.Auto;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 *
 * @author ADL_LEHMANN26
 */
public class GuckMalHier {
    
    public static void machmal() {
        Vector<Auto> nyooms = new Vector<Auto>();
        
        nyooms.add(new Auto("Kleines Brumm", 1999, true, 4, 80));
        nyooms.add(new Auto("Mittleres Brumm", 1999, false, 6, 140));
        nyooms.add(new Auto("Großes Brumm", 1999, false, 8, 300));
        
        Vector<Person> blokes = new Vector<Person>();
        
        blokes.add(new Person("Germund", "Fredenand"));
        blokes.add(new Person("Hildimar", "Hariwini"));
        blokes.add(new Person("Emmerich", "Gumarich"));
        
        Enumeration<Auto> ne = nyooms.elements();
        Enumeration<Person> pe = blokes.elements();
        
        Hashtable<Person, Auto> besitzerliste = new Hashtable<Person, Auto>();
        
        while(ne.hasMoreElements() && pe.hasMoreElements()) {
            besitzerliste.put(pe.nextElement(), ne.nextElement());
        }
    }
}
