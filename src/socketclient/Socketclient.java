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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paul.koroski
 */
public class Socketclient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket testclient = new Socket(InetAddress.getLocalHost(), 1337);
            PrintWriter out = new PrintWriter(testclient.getOutputStream(), true);
            BufferedReader socketin = new BufferedReader(new InputStreamReader(testclient.getInputStream()));
            BufferedReader UserIn = new BufferedReader(new InputStreamReader(System.in));
            
            
            String input;
            String output;
            
            
            
            
            
            
        } catch (IOException ex) {
            System.out.println("Connection failed");
        }
    }
    
}
