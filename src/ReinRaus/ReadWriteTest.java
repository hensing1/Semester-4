/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReinRaus;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 *
 * @author ADL_LEHMANN26
 */
public class ReadWriteTest {
    static String path = "C:\\Users\\adl_lehmann26\\Documents\\NetBeansProjects\\Semester 4\\GutenTag.txt";
    static String logpath = "C:\\Users\\adl_lehmann26\\Documents\\NetBeansProjects\\Semester 4\\log.txt";
    
    public static void writeMeARiver() {
        //oh guck mal, Generics!
        ArrayList<String> zeilen = new ArrayList();
        zeilen.add("Zeile 1");
        zeilen.add("Zeile 2");
        zeilen.add("Zeile 3");
        zeilen.add("");
        zeilen.add("");
        zeilen.add("MUUUUUUUUUUUUH");
        
        File f = new File(path);
        
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));

            for (String zeile : zeilen) {
                writer.write(zeile);
                writer.newLine();
            }
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            System.out.println("irgendwas ist kaputt");
            ioe.printStackTrace();
        }
    }
    
    public static void lesenBildet(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(logpath));

//            Stream<String> lines = reader.lines();
//
//            for (Object line : lines.toArray()) {
//                System.out.println((String) line);
//            }

            while(reader.ready()) {
                System.out.println(reader.readLine());
            }
            
            reader.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("Datei nicht da");
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("irgendwas ist falsch");
            ioe.printStackTrace();
        }
    }

    public static void lesenBildetDiesmalMitURL() {
        try {
            URL resource = new URL("file", "localhost", logpath);
            InputStream is = resource.openStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String in;
            while((in = br.readLine()) != null)
                System.out.println(in);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void logloglogloglog() {
        File f = new File(logpath);
        ArrayList<String> lines = new ArrayList();
        try {
            if (f.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                while (reader.ready())
                    lines.add(reader.readLine());
            }
            int lastEntry = 0;
            if (!lines.isEmpty())
                lastEntry = Integer.parseInt(lines.get(lines.size() - 1).split(" ")[1]);
            BufferedWriter writer = new BufferedWriter(new FileWriter(f, true)); //false if file is to be overwritten
            writer.write(String.format("Entry %d", lastEntry + 1));
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Datei nicht da");
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("irgendwas ist falsch");
            ioe.printStackTrace();
        }
    }
}
