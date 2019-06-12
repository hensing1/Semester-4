package SocketInMyPocket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens Henning Lehmann; 213172003
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("Willkommen zum coolen Client");
        Client c = new Client();
        c.sendToServer("Toller Teststring 1");
        c.sendToServer("Toller Teststring 2");
        c.sendToServer("Toller Teststring 3");
        c.sendToServer("exit");
    }
    
    private void sendToServer(String msg) {
        try {
            Socket cs = new Socket("localhost", 4000);
            PrintWriter out = new PrintWriter(cs.getOutputStream());
            out.println(msg);
            
            System.out.println(String.format("Gesendet: %s", msg));
            
            out.close();
            cs.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
