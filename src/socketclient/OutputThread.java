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
    private BufferedReader output;
    
    public OutputThread(Socket server, BufferedReader OutputStream){
        connection = server;
        
        try {
            output = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            while (true){
                String Outputstring = output.readLine();
                
                System.out.println(Outputstring);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(OutputThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
