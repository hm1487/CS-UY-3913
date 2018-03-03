/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahw1;
import java.util.*;
/**
 *
 * @author Htoo Min 2/8/2018
 */
public class JavaHW1 {
    /**
     * @param args the command line arguments
     * 
     */
    public static void display(String[] multi){
        int counter = 1;
        for (int x = 0; x < multi.length; x++){
            if (counter % 3 == 0){
                System.out.println(multi[x]);
            }
            else{
                System.out.print(multi[x] + " ");
            }
            counter++;
        }
    }
    public static void displayTest(int[] multi){
        int counter = 1;
        for (int x = 0; x < multi.length; x++){
            if (counter % 3 == 0){
                System.out.println(multi[x]);
            }
            else{
                System.out.print(multi[x] + " ");
            }
            counter++;
        }
    }
    public static boolean logicCheck(String[] multi){
        if (multi[0].equals(multi[1]) && multi[0].equals(multi[2]) && !multi[0].equals("N")){
            return true;
        }
        else if (multi[3].equals(multi[4]) && multi[3].equals(multi[5]) && !multi[3].equals("N")){
            return true;
        }
        else if (multi[6].equals(multi[7]) && multi[6].equals(multi[8]) && !multi[6].equals("N")){
            return true;
        }
        else if (multi[0].equals(multi[3]) && multi[0].equals(multi[6]) && !multi[0].equals("N")){
            return true;
        }
        else if (multi[1].equals(multi[4]) && multi[1].equals(multi[7]) && !multi[1].equals("N")){
            return true;
        }
        else if (multi[2].equals(multi[5]) && multi[2].equals(multi[8]) && !multi[2].equals("N")){
            return true;
        }
        else if (multi[0].equals(multi[4]) && multi[0].equals(multi[8]) && !multi[0].equals("N")){
            return true;
        }
        else if (multi[2].equals(multi[4]) && multi[2].equals(multi[6]) && !multi[2].equals("N")){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Player one will be represented by X's and Player two will be represented by O's");
        System.out.println("Say the number of the place where you would like to place your icon");
        int[] multi = new int [9];
        String[] ex = new String [9];
        for (int i = 0; i < 9; i ++){
            multi[i] = i;
            ex[i] = "N";
        }
        displayTest(multi);
        Scanner sin = new Scanner(System.in);
        boolean checker = false;
        int input;
        int holder = 0;
        while (true){
            if (holder > 8)
                break;
            System.out.println("Player 1, where would you like to place your X?");
            input = sin.nextInt();
            if (ex[input].equals("N")){
                ex[input] = "X";
            }
            else if (!ex[input].equals("N")){
                System.out.println("There's already an item there! Lose Your Turn!");
            }
            display(ex);
            if (logicCheck(ex) == true){
                System.out.println("Player One WINS!");
                break;
            }

            holder++;
            if (holder > 8)
                break;
            System.out.println("Player 2, where would you like to place your O?");
            input = sin.nextInt();
            if (ex[input].equals("N")){
                ex[input] = "O";
            }
            else if (!ex[input].equals("N")){
                System.out.println("There's already an item there! Lose Your Turn!");
            }
            display(ex);
            if (logicCheck(ex) == true){
                System.out.println("Player Two WINS!");
                break;
            } 
            holder++;
        }
        System.out.println(holder);
        if (holder >= 9)
            System.out.println("DRAW");
    
    }
}
