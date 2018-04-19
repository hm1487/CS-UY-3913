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
//HELLO?
/**
 *
 * @author PwintMin
 */
public class ChatClient {
    
    static String username;
    static boolean haveUsername = false;
    static int portNum = 5190;
    static PrintStream ps = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        ServerLogin sl = new ServerLogin();
        sl.setVisible(true);
        Socket socket = null;
        try{
            System.out.println("trying to get to socket");           
            socket = new Socket("192.168.1.10",portNum);
            
            while(haveUsername == false){
                try{
                    Thread.sleep(100);
                } catch (InterruptedException ex){
                    Thread.currentThread().interrupt(); 
                }
            }
        
            System.out.println("We got to the port!");
            ps = new PrintStream(socket.getOutputStream());
            ps.println(username);
        
            //ChatServer.UserThread temp = new ChatServer.UserThread(ChatServer.portNum);
            ChatRoom cr = new ChatRoom();
            cr.setVisible(true);
            cr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
        }catch (IOException ex){
            System.out.println("You fucked up");
        }  
    }  
}
    
