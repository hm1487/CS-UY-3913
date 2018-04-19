/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;
import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.JFrame;
/**
 *
 * @author htoomin
 */
public class ChatServer {

    
    /**
     * @param args the command line arguments
     */
    static int portNum = 5190;
    static ArrayList<ProcessConnection> users = new ArrayList<ProcessConnection>();
    
    public static class ProcessConnection extends Thread{ //Each one needs a thread to make sure we can have more than one
    Socket client;
    String nickname;
    
    ProcessConnection(Socket news){
        client=news;
    }
    public void run(){
        try{
            Scanner sin = new Scanner(client.getInputStream());
            nickname = sin.nextLine();
            System.out.println(nickname);
            while (sin.hasNext()){
                System.out.println(sin.nextLine());
            }
            client.close();
        } catch (IOException ex){
            System.out.println(ex);
        }
        System.out.println(nickname);
    }
    }
    
    public static void main(String[] args) {
        ServerSocket ss = null;
        try{
            ss = new ServerSocket(portNum);
            System.out.println("Connection successful!");
            while (true){
                Socket s = ss.accept();
                ProcessConnection pc = new ProcessConnection(s);
                users.add(pc);
                pc.start();
            }
            
        } 
        catch (IOException ex){
            System.out.println("Could not get to the socket!");
        }
    }
    
}
