package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.*;
import javax.swing.*;



public class withdrawl extends JFrame implements ActionListener {
    JButton withdraw,Back;
    String pinnumber;
    JTextField amount;
    withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);//reduce the size of enlarge image
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel text=new JLabel("Enter the amount ypu want to Withdraw");
        text.setBounds(170,300,700,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        amount=new JTextField();
        amount.setBounds(180,350,320,25);
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(amount);
        
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        Back=new JButton("Back");
        Back.setBounds(355,520,150,30);
        Back.addActionListener(this);
        image.add(Back);
         
         //make a frame 
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
         
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource() == withdraw){
        String number = amount.getText();
        Date date = new Date();
        
        if(number.equals("")){
            JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
        } else {
            try {
                Conn conn = new Conn();
                
                // Get all transactions for this pin
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

                int enteredAmount = Integer.parseInt(number);
                
                if(enteredAmount > balance){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // All good, now insert withdrawl
                String query2 = "insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully");
                setVisible(false);
                new Transactions_login(pinnumber).setVisible(true);

            } catch(Exception e){
                e.printStackTrace(); // show full error in console for debugging
            }
        }
    } else if(ae.getSource() == Back){
        setVisible(false);
        new Transactions_login(pinnumber).setVisible(true);
    }
}



    public static void main(String[] args){
        new withdrawl("");
    }
    
}

