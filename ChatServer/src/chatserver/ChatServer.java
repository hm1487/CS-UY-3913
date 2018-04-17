/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;
import java.io.*;
import java.util.*;
import java.net.*;
/**
 *
 * @author htoomin
 */
public class ChatServer {

    
    /**
     * @param args the command line arguments
     */
    static int portNum = 5190;
    static ArrayList<UserThread> users = new ArrayList<UserThread>();
    
    public static class ServerThread implements Runnable{
        private Socket tempSocket;
        
        public ServerThread(Socket s){
            this.tempSocket = s;
        }
        
        @Override
        public void run(){}
    }
    
    public static class UserThread implements Runnable{
        private Socket socket;
        
        public UserThread(Socket s){
            this.socket = s;
        }
        @Override
        public void run(){}
    }
    
    public static void addUsers(ServerSocket x){ //making sure that we are people to the chatroom
        while (true){
            try{
                Socket tempSocket = x.accept();
                UserThread user = new UserThread(tempSocket);
                Thread thread = new Thread(user);
                thread.start();
                users.add(user);
            } catch (IOException ex){
                
            }
        }
    }
    public static void main(String[] args) {
        ServerSocket ss = null;
        try{
            ss = new ServerSocket(portNum);
            addUsers(ss);
            while(true){
                System.out.println("Waiting for a connection on port " + portNum);
                Socket client = ss.accept();
                Scanner sin = new Scanner(client.getInputStream());
            }
            
        } 
        catch (IOException ex){
            System.out.println("Could not get to the socket!");
        }
    }
    
}
