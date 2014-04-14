/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package socketclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paul.koroski
 */
public class Socketclient {

    private Socket client;
    private PrintWriter OutputWriter;
    private BufferedReader reader;
    private OutputThread SocketReader;
    private BufferedReader InputReader;
    
    public Socketclient(){
        try {
            client = new Socket(InetAddress.getLocalHost(), 1337);
            OutputWriter = new PrintWriter(client.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            InputReader = new BufferedReader(new InputStreamReader(System.in));
            SocketReader = new OutputThread(client, reader);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Socketclient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Could not connect to server");
        }
    }
    
    public void StartReading(){
        SocketReader.start();
    }
    
    public void StartSending(){
        String userinput;
        try {
            while ((userinput = InputReader.readLine()) != null){
                OutputWriter.println(userinput);
            }
        } catch (IOException ex) {
            Logger.getLogger(Socketclient.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("could not send output");
        }
    } 
}
