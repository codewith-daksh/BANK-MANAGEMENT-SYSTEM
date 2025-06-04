
package bank.management.system;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Transactions_login extends JFrame implements ActionListener {
        JButton deposit,withdrawl,ministate,pinchange,fastcash,balanceinquery,exit;
        String pinnumber;
        Transactions_login(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        //set the iamge of atm
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);//reduce the size of enlarge image
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
         JLabel text=new JLabel("Please select your Transaction");
         text.setBounds(210,300,700,35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("Raleway",Font.BOLD,16));
         image.add(text);
         
        deposit =new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl =new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash =new JButton("Fast cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministate =new JButton("MiniStatement");
        ministate.setBounds(355,450,150,30);
        ministate.addActionListener(this);
        image.add(ministate);
        
        pinchange =new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceinquery =new JButton("Balance Enquiry");
        balanceinquery.setBounds(355,485,150,30);
        balanceinquery.addActionListener(this);
        image.add(balanceinquery);
        
        exit =new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
       
        getContentPane().setBackground(Color.WHITE);//change frame bg 
        //make a frame 
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==exit){
              System.exit(0);
            }else if(ae.getSource()==deposit){
                setVisible(false);
                new deposit(pinnumber). setVisible(true);
           }else if(ae.getSource()==withdrawl){
               setVisible(false);
               new withdrawl(pinnumber).setVisible(true);
           }else if(ae.getSource()==fastcash){
               setVisible(false);
               new fastcash(pinnumber).setVisible(true);
           }else if(ae.getSource()==pinchange){
               setVisible(false);
               new pinchange(pinnumber).setVisible(true);
           }else if(ae.getSource()==balanceinquery){
               setVisible(false);
               new BalanceEnquery(pinnumber).setVisible(true);
           }else if(ae.getSource()==ministate){
               
               new ministatement(pinnumber).setVisible(true);
           }
        }
        public static void main(String[] args){
            new Transactions_login("");
        }
}
