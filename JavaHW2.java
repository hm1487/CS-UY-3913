/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahw2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.util.ArrayList;
/**
 *
 * @author Htoo Min
 */
public class JavaHW2 {

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
        for (int x = 1; x < 20; x++){ //change the number of buttons here
            al.add(new JButton(""+x));
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