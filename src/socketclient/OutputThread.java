/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package socketclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paul.koroski
 */
public class OutputThread extends Thread{
    private final Socket connection;
    private BufferedReader SocketReader;
    
    public OutputThread(Socket server, BufferedReader socketin){
        connection = server;
        
        SocketReader = socketin;
    }
    
    @Override
    public void run(){
        String SocketString;
        System.out.println("Output Thread started");
        try{
            String output;
            while(true){
                output = SocketReader.readLine();
                System.out.println("Server: " + output);
            } 
        } catch (IOException ex){
            System.out.println("Failed to read from socket");
        }
        
    }
}
