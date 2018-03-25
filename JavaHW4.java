/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahw4;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author PwintMin
 */
public class JavaHW4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame("Java HW 2");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(800,400);

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(4,2)); //Change the layout of the buttons here
        ArrayList<JButton> al = new ArrayList<JButton>();
        for (int x = 1; x < 9; x++){ //change the number of buttons here
            al.add(new JButton(Integer.toString(x)));
        }
        for (JButton x : al){            
            int red = (int)(Math.random()*255);
            int green = (int)(Math.random()*255);
            int blue = (int)(Math.random()*255);
            x.setBackground(new Color(red,green,blue));
            x.addActionListener(new MyButtonAction());
            jp.add(x);        
        }
        jf.add(jp);
        jf.setVisible(true);
        new ColorChange(al).start();
    }       
}

class ColorChange extends Thread{
    ArrayList<JButton> temp = new ArrayList<JButton>();
    ColorChange(ArrayList<JButton> al){temp=al;}
    public void run(){
        
        for(;;) {
            for (JButton x : temp){
                int red = (int)(Math.random()*255);
                int green = (int)(Math.random()*255);
                int blue = (int)(Math.random()*255);
                x.setBackground(new Color(red,green,blue));
            }
            try {
            Thread.sleep(1000);
            } 
            catch (InterruptedException ex) {
               System.out.println("Blah");
            }
        }
        
    }
}
    
 class MyButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton jb = (JButton) e.getSource();
            JPanel jp = (JPanel) jb.getParent();
            Component[] components = jp.getComponents();
            for (Component x : components){
                if (x != jb){
                    int red = (int)(Math.random()*255);
                    int green = (int)(Math.random()*255);
                    int blue = (int)(Math.random()*255);
                    x.setBackground(new Color(red,green,blue));
                }
            }
        }
}
