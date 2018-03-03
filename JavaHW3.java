/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahw3;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import javax.swing.JButton;

/**
 *
 * @author Htoo Min
 */

public class JavaHW3 {
    static int counter = 1; //I hate that I'm using a global, but I can't think of any other way to do this
    /**
     * @param args the command line arguments
     */
     static class X{ //No idea how else to do this
        String identifier = "X";
        void getX(){
            System.out.println(identifier + " wins!");
        }
     }
     
     static class O{
        String identifier = "O";
        void getO(){
            System.out.println(identifier + " wins!");
        }
     }
     public static boolean logicCheck(JButton[] multi){
        if (multi[0].getText().equals(multi[1].getText()) && multi[0].getText().equals(multi[2].getText()) && !multi[0].getText().equals("N")){
            return true;
        }
        else if (multi[3].getText().equals(multi[4].getText()) && multi[3].getText().equals(multi[5].getText()) && !multi[3].getText().equals("N")){
            return true;
        }
        else if (multi[6].getText().equals(multi[7].getText()) && multi[6].getText().equals(multi[8].getText()) && !multi[6].getText().equals("N")){
            return true;
        }
        else if (multi[0].getText().equals(multi[3].getText()) && multi[0].getText().equals(multi[6].getText()) && !multi[0].getText().equals("N")){
            return true;
        }
        else if (multi[1].getText().equals(multi[4].getText()) && multi[1].getText().equals(multi[7].getText()) && !multi[1].getText().equals("N")){
            return true;
        }
        else if (multi[2].getText().equals(multi[5].getText()) && multi[2].getText().equals(multi[8].getText()) && !multi[2].getText().equals("N")){
            return true;
        }
        else if (multi[0].getText().equals(multi[4].getText()) && multi[0].getText().equals(multi[8].getText()) && !multi[0].getText().equals("N")){
            return true;
        }
        else if (multi[2].getText().equals(multi[4].getText()) && multi[2].getText().equals(multi[6].getText()) && !multi[2].getText().equals("N")){
            return true;
        }
        return false;
    }
     
    public static void main(String[] args) {
        X x = new X();
        O o = new O();

        JButton [] holder = new JButton[9];
        JFrame jf = new JFrame("Java HW 3");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(800,800);

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(3,3));
        for (int i = 0; i < 9; i++){ //change the number of buttons here
           JButton jb = new JButton("N");
           holder[i] = jb;
           jp.add(jb);
        }
        jf.add(jp);
        jf.setVisible(true);
        for (JButton button : holder){
             button.addActionListener(new MyButtonAction());
        }
        while (true){
            if (logicCheck(holder) == true)
                 break;
            if (counter == 10)
                break;
        }
        if (counter % 2 == 1 && logicCheck(holder))
            o.getO();
        else if (counter % 2 == 0 && logicCheck(holder))
            x.getX();
        else
            System.out.println("DRAW");
        counter = 1;
        jf.dispose();
    }

    static class MyButtonAction implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //System.out.println(counter);
            JButton jb = (JButton) e.getSource();
            JPanel jp = (JPanel) jb.getParent();
            Component[] components = jp.getComponents();
            for (Component x: components){
                if (x == jb && (counter % 2 == 1) && jb.getText().equals("N")){
                    counter++;
                    jb.setText("X");
                }
                else if(x == jb && (counter % 2 == 0) && jb.getText().equals("N")){
                    counter++;
                    jb.setText("O");
                }
            }
        }
    }
}

    
