/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;
import static chatserver.ChatRoom.jTextArea2;
import static chatserver.ChatRoom.jTextField1;
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
 *///

//I couldn't figure out how to make a client where you could choose the ip addresses
//I just made it so that it senses the IP address of the computer that it's on.
//
public class ChatClient {
    
    static String username;
    static boolean haveUsername = false;
    static int portNum = 5190;
    static PrintStream ps = null;
    //static String desiredIP;
    //static boolean haveIP;
    static Vector<String> addressHolder = new Vector<String>();
    /**
     * @param args the command line arguments
     */
    
    public static class ClientDriver extends Thread{
        Scanner s;
        
        ClientDriver(Scanner news){
            s = news;
        }
        
        public void run(){
            while (true){
                if (s.hasNext()){
                    String temp = s.nextLine();
                    //System.out.println(temp);
                    ChatRoom.jTextArea2.append(temp + "\n");
                }
            }
        }
    }
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        ServerLogin sl = new ServerLogin();
        sl.setVisible(true);
        Socket socket = null;
        try{
            System.out.println("trying to get to socket");
            
          
            while(haveUsername == false){
                try{
                    Thread.sleep(100);
                } catch (InterruptedException ex){
                    Thread.currentThread().interrupt(); 
                }
            }
            
            InetAddress address = InetAddress.getLocalHost();
            addressHolder.add(address.getHostAddress().toString());
            String ipAddress = address.getHostAddress().toString();
            socket = new Socket(ipAddress,portNum); //Can change the IP address here!
            
           
            System.out.println("We got to the port!");
            ps = new PrintStream(socket.getOutputStream());
            ps.println(username);
            Scanner temp = new Scanner(socket.getInputStream());
        
            //ChatServer.UserThread temp = new ChatServer.UserThread(ChatServer.portNum);
            ChatRoom cr = new ChatRoom();
            cr.setVisible(true);
            cr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
            Scanner sin = new Scanner(socket.getInputStream());
            ClientDriver cd = new ClientDriver(sin);
            cd.run();
           
        }catch (IOException ex){
            System.out.println("You messed up");
        }  
    }  
}
    
