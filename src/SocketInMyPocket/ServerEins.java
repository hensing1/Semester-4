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
public class ServerEins {
    public static void main(String[] args) {
        System.out.println("Willkommen zum serienreifen Server");
        new ServerEins().receiveMessage();
    }
    
    private void receiveMessage() {

        try (ServerSocket ss = new ServerSocket(4000)) {
            String received;
            Socket cs;
            InputStream in;
            BufferedReader read;
            System.out.println("Server steht bereit...");
            do {
                cs = ss.accept();
                System.out.println("Verbindungsanfrage erhalten");
                in = cs.getInputStream();
                read = new BufferedReader(new InputStreamReader(in));

                received = read.readLine();
                System.out.println(String.format("Empfangen: %s", received));
            } while (!received.toLowerCase().equals("exit"));

            System.out.println("Shutting down...");

            in.close();
            read.close();
            ss.close();
            cs.close();
        } catch (IOException ex) {
            Logger.getLogger(ServerEins.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
