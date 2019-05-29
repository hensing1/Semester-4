/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketInMyPocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADL_LEHMANN26
 */
public class Server {
    public static void main(String[] args) {
        System.out.println("Willkommen zum serienreifen Server");
        Server s = new Server();
        while(true)
            s.receiveMessage();
    }
    
    private void receiveMessage() {
        try {
            ServerSocket ss = new ServerSocket(4000);
            Socket cs = ss.accept();
            InputStream in = cs.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            String received = read.readLine();
            
            System.out.println(String.format("Empfangen: %s", received));
            
            in.close();
            read.close();
            ss.close();
            cs.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
