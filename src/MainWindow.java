/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 201812358
 */
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class MainWindow extends JFrame implements ActionListener{
    private static final JButton BUTTON_ENTER = new JButton("ENTER");
    private static final JLabel LABEL_ENTER = new JLabel("<html>Following are the prime numbers<br/>smaller than or equal to:</html>", JLabel.CENTER);
    private static final JTextField TXT_FIELD_ENTER = new JTextField();
    
    MainWindow(){
        super.setTitle("SOE GUI");
        super.setLayout(new GridLayout(0, 3));
        super.add(LABEL_ENTER); super.add(TXT_FIELD_ENTER); super.add(BUTTON_ENTER);
        super.setSize(600, 80);
        super.setVisible(true);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BUTTON_ENTER.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == BUTTON_ENTER){
            int n = 0;
            try{
                n = Integer.parseInt(TXT_FIELD_ENTER.getText());
                if(2 >= n){
                    throw new InvalidInputException();
                }
            }catch(Exception ex){
                System.out.println(ex);
                return;
            }
            new SOEGui(n);
            this.dispose();
            
        }
    }    
    
    private class InvalidInputException extends Exception{
        public String toString(){
            return "Invalid Input Number, must be greater than two";
        }
    }
    
    public static void main(String[] args) {
        new MainWindow();
    }
}
