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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Create a boolean array to coincide with the button array
/**
 *
 * @author htoomin
 */
public class JavaHW4 {
    
    static boolean[] checker = new boolean[8];
    static ArrayList<JButton> al = new ArrayList<JButton>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame("Java HW 2");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(800,400);
        
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(4,2)); //Change the layout of the buttons here
        for (int x = 1; x < 9; x++){ //change the number of buttons here
            al.add(new JButton(Integer.toString(x)));
        }
        for (JButton x : al){        
            x.setOpaque(true);
            x.setContentAreaFilled(true);
            x.setBorderPainted(false);
            int red = (int)(Math.random()*255);
            int green = (int)(Math.random()*255);
            int blue = (int)(Math.random()*255);
            x.setBackground(new Color(red,green,blue));
            x.addActionListener(new MyButtonAction());
            jp.add(x);        
        }
        for (boolean x: checker)
            System.out.println(x);
        jf.add(jp);
        jf.setVisible(true);
        new ColorChange(al).start();
    }       


static class ColorChange extends Thread{
    ArrayList<JButton> temp = new ArrayList<JButton>();
    ColorChange(ArrayList<JButton> al){temp=al;}
    public void run(){
        
        for(;;) {
            int counter = 0;
            for (JButton x : temp){
                if (checker[counter] == false){
                    int red = (int)(Math.random()*255);
                    int green = (int)(Math.random()*255);
                    int blue = (int)(Math.random()*255);
                    x.setBackground(new Color(red,green,blue));
                }
                counter++;
            }
            try {
            Thread.sleep(1000);
            } 
            catch (InterruptedException ex) {
               System.out.println("Whoopsies!");
            }
        }
        
    }
}
    
static class MyButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JButton jb = (JButton) e.getSource();
            JPanel jp = (JPanel) jb.getParent();
            int counter = 0;
            for (JButton x : al){
                if (x == jb){
                    if (checker[counter] == true)
                        checker[counter] = false;
                    else
                        checker[counter] = true;
                }
                counter++;
            }
        }
    }
}


