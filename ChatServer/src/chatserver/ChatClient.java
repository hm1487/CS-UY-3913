/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author PwintMin
 */
public class ChatClient {
    
    static String username;
    static boolean haveUsername = false; 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        ServerLogin sl = new ServerLogin();
        sl.setVisible(true);
        while(haveUsername == false){
            try{
                Thread.sleep(100);
            } catch (InterruptedException ex){
                Thread.currentThread().interrupt(); 
            }
        }
        ChatRoom cr = new ChatRoom();
        cr.setVisible(true);
        cr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
    
}
