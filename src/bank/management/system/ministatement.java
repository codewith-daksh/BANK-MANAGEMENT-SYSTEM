
package bank.management.system;

import javax.swing.*;
import java.sql.*;

public class ministatement extends JFrame {
    String pinnumber;
    ministatement(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        setTitle("Mini Statement");
        
        JLabel mini=new JLabel();
        mini.setBounds(20,130,400,200);
        add(mini);
        
        JLabel bank=new JLabel("Indian Bank");
        bank.setBounds(150,20,160,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select *from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardNumber").substring(0,4)+"XXXXXXXX" +rs.getString("cardNumber").substring(12));
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn=new Conn();
            int bal=0;
            ResultSet rs=conn.s.executeQuery("select *from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" +rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                   //for show current balance
                    if(rs.getString("type").equals("Deposite")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    } else if(rs.getString("type").equals("withdrawl")){  // match the same spelling as used in DB
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your current account balance is Rs "+bal);
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        
       
        setSize(400,600);
        setLocation(20,20);
        //setUndecorated(true);
        setVisible(true);
    }
    public static void main(String[] args){
        new ministatement("");
    }
}
