package SocketInMyPocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jens Henning Lehmann; 213172003
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("Willkommen zum coolen Client");
        new Client().connect();
    }

    private void connect() {
        try {
            Socket clientSocket = new Socket("localhost", 4000);

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream()); // OutputStream zum Senden an Server
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // InputStream zum Empfangen von Nachrichten vom Server

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String received;

            while ((received = in.readLine()) != null) {
                System.out.println(String.format("Server meldet: %s", received));
                if (received.equals("Tschö!"))
                    break;
                System.out.println("Nachricht an Server eingeben: ");
                String userMessage = userInput.readLine();
                //String userMessage = "Hallo, ich bin ein Client!";
                out.println(userMessage);
                out.flush();
                System.out.println(String.format("Gesendet: %s", userMessage));
            }

            in.close();
            out.close();
            clientSocket.close();
            userInput.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void sendObjectToServer(Object o) {

    }
}
