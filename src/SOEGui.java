/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 201812358
 */

import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.GridLayout;

public class SOEGui extends JFrame {
    private int totalNumber = 0;
    private static List<JLabel> LabelUI = new ArrayList<>();
    
    SOEGui(){
        this.totalNumber = 50;
        InitializeFrame();
    }
    
    SOEGui(int n){
        this.totalNumber = n;
        InitializeFrame();
    }
    
    private void InitializeFrame(){
        super.setTitle("SOE GUI");
        super.setLayout(new GridLayout(totalNumber/25, ( totalNumber < 25 ? totalNumber : 25 )));
        for(int i = 1; i <= totalNumber; i++){
            if(i == 1){
                JLabel jLabel = new JLabel("-", JLabel.CENTER);
                jLabel.setEnabled(false);
                jLabel.setOpaque(true);
                LabelUI.add(jLabel);
            } else {
                JLabel jLabel = new JLabel(Integer.toString(i), JLabel.CENTER);
                jLabel.setOpaque(true);
                LabelUI.add(jLabel);
            }
        }
        for(JLabel i : LabelUI){
            super.add(i);
        }
        super.setSize(1280 , 720);
        super.setVisible(true);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.pack();
        Thread t1 = new Thread(new SieveOfEratosthenes());
        t1.start();
    }
    
    //Inner class
    private class SieveOfEratosthenes implements Runnable {
        //Delay Timer 
        private int timeOfSleep = 20;
        @Override
        public void run() {
            for(int p = 2; p*p <=totalNumber; p++){ 
                //To set RGB Color
                Random rand = new Random();
                int r = rand.nextInt(255);
                int g = rand.nextInt(255);
                int b = rand.nextInt(255);
                //Check whether the button is Enabled or not to do process
                if(LabelUI.get(p-1).isEnabled() == true) 
                { 
                    //Setting Color
                    LabelUI.get(p-1).setForeground(new Color(r, g, b));
                    LabelUI.get(p-1).setBorder(BorderFactory.createLineBorder(new Color(r, g, b)));
                    //Setting the prime number that is divisible set its color the same as the previous one
                    for(int i = p*p; i <= totalNumber; i += p){
                        LabelUI.get(i-1).setBackground(new Color(r, g, b));
                        LabelUI.get(i-1).setEnabled(false);
                        try{
                            //To do a animation effect
                            Thread.sleep(timeOfSleep);
                        }catch(Exception ex){
                            System.out.println(ex.getLocalizedMessage());
                        }
                    }
                }
                //Animation effect
                try{
                    Thread.sleep(timeOfSleep);
                }catch(Exception ex){
                    System.out.println(ex.getLocalizedMessage());
                }
            }
            
            JOptionPane.showMessageDialog(rootPane,
                        "Done!",
                        "Task",
                        JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
}
