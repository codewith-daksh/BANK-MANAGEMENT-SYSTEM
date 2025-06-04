
package bank.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanceEnquery extends JFrame implements ActionListener{
    JButton back;
    String pinnumber;
     BalanceEnquery(String pinnumber){
         this.pinnumber=pinnumber;
         setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);//reduce the size of enlarge image
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image); 
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
         Conn conn=new Conn();
         int balance = 0;
        try{
            String query1 = "select * from bank where pin = '"+pinnumber+"'";
            ResultSet rs = conn.s.executeQuery(query1);
            while(rs.next()){
                String type = rs.getString("type");  // make it lowercase for consistency
                int amt = Integer.parseInt(rs.getString("amount"));
                if(type.equals("Deposite")){
                    balance += amt;
                } else if(type.equals("withdrawl")){  // match the same spelling as used in DB
                    balance -= amt;
                }
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel text=new JLabel("Your Current Account balance is Rs "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,30);
        image.add(text);
      
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
     }
     public void actionPerformed(ActionEvent ae){
          setVisible(false);
          new Transactions_login(pinnumber).setVisible(true);
     }
    public static void main(String[] args){
        new BalanceEnquery("");
    }
}
