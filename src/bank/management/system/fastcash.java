
package bank.management.system;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.*;

public class fastcash extends JFrame implements ActionListener {//same as transaction class
        JButton deposit,withdrawl,ministate,pinchange,fastcash,balanceinquery,exit;
        String pinnumber;
        fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        //set the iamge of atm
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);//reduce the size of enlarge image
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
         JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
         text.setBounds(210,300,700,35);
         text.setForeground(Color.WHITE);
         text.setFont(new Font("Raleway",Font.BOLD,16));
         image.add(text);
         
        deposit =new JButton("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl =new JButton("Rs 500");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash =new JButton("Rs 1000");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministate =new JButton("Rs 2000");
        ministate.setBounds(355,450,150,30);
        ministate.addActionListener(this);
        image.add(ministate);
        
        pinchange =new JButton("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceinquery =new JButton("Rs 10000");
        balanceinquery.setBounds(355,485,150,30);
        balanceinquery.addActionListener(this);
        image.add(balanceinquery);
        
        exit =new JButton("BACK");
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
             setVisible(false);
             new Transactions_login(pinnumber).setVisible(true);
            }else {
               String amount =((JButton)ae.getSource()).getText().substring(3);
               
               //agar account m insufficient balance 
               Conn conn=new Conn();
              try{
               String query1 = "select * from bank where pin = '"+pinnumber+"'";
               ResultSet rs = conn.s.executeQuery(query1);
                
                int balance = 0;
                while(rs.next()){
                    String type = rs.getString("type");  // make it lowercase for consistency
                    int amt = Integer.parseInt(rs.getString("amount"));
                    
                    if(type.equals("Deposite")){
                        balance += amt;
                    } else if(type.equals("withdrawl")){  // match the same spelling as used in DB
                        balance -= amt;
                    }
                }
                if(ae.getSource()!=exit&& balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date=new Date();
                String query2 = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully");
                setVisible(false);
                new Transactions_login(pinnumber).setVisible(true);
                
              }catch(Exception e){
                  System.out.println(e);
              }
            }
        }
        public static void main(String[] args){
            new fastcash("");
        }
}

