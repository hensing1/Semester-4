/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketInMyPocket;

import java.io.*;
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
            s.startSingleThreadedServer();
    }

    private void startSingleThreadedServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(4000); // Endpunkt für Kommunikation auf Port 4000

            Socket clientSocket = serverSocket.accept();
            System.out.println("Neue Connection!!!");

            OutputStream out = clientSocket.getOutputStream(); // OutputStream -> schreiben
            PrintWriter writer = new PrintWriter(out, true);

            InputStream in = clientSocket.getInputStream(); // InputStream -> lesen
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            writer.println("Hi, ich bin ein Server!");

            String received = "Simmelbimmel";
            //while ((received = reader.readLine()) != null) {
            while (received != null) {
                if (received.toLowerCase().equals("exit")) {
                    writer.println("Tschö!");
                    break;
                } else {
                    System.out.println(String.format("Empfangenn: %s", received));
                    writer.println(String.format("Ich habe folgendes empfangen: %s", received));
                }
                received = reader.readLine();
                System.out.println("I'm reached!");
            }

            in.close();
            reader.close();
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(4000); // Endpunkt für Kommunikation auf Port 4000

            boolean rumbawumba = false;

            while(true) {
                Socket clientSocket = serverSocket.accept(); // accept() wird aufgerufen, wenn Verbindungsanfrage erhalten wurde
                Thread t = new ClientConnection(clientSocket);
                t.start();

                if (rumbawumba) // fick dich Javacompiler und dein unreachable statement
                    break;
            }

            serverSocket.close();

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class ClientConnection extends Thread {
        Socket clientSocket;

        public ClientConnection(Socket cs) {
            this.clientSocket = cs;
        }

        @Override
        public void run() {
            System.out.println("Neue Connection!!!!!");
            try {
                OutputStream out = clientSocket.getOutputStream(); // OutputStream -> schreiben
                PrintWriter writer = new PrintWriter(out, true);

                InputStream in = clientSocket.getInputStream(); // InputStream -> lesen
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                writer.println("Hi, ich bin ein Server!");

                String received;
                while ((received = reader.readLine()) != null) {
                    if (received.toLowerCase().equals("exit")) {
                        writer.println("Tschö!");
                        break;
                    } else {
                        System.out.println(String.format("Empfangen: %s"));
                        writer.println(String.format("Ich habe folgendes empfangen: %s", received));
                    }
                }

                in.close();
                reader.close();
                clientSocket.close();
            } catch (IOException ioe) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ioe);
            }
            System.out.println("Connection wurde geschlossen.");
        }
    }
}
