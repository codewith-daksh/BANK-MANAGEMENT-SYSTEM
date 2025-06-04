
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class deposit extends JFrame implements ActionListener {
    JButton deposite,Back;
    String pinnumber;
    JTextField amount;
    deposit(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);//reduce the size of enlarge image
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel text=new JLabel("Enter the amount ypu want to deposit");
        text.setBounds(170,300,700,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        image.add(text);
        
        amount=new JTextField();
        amount.setBounds(180,350,320,25);
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        image.add(amount);
        
        deposite=new JButton("Deposite");
        deposite.setBounds(355,485,150,30);
        deposite.addActionListener(this);
        image.add(deposite);
        
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
         if(ae.getSource()==deposite){
             String number=amount.getText();
             Date date=new Date();
             if(number.equals("")){
                 JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposite");
             }else{
                 try{
                    Conn conn=new Conn();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','Deposite','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Deposite Successfully");
                    setVisible(false);
                    new Transactions_login(pinnumber).setVisible(true);
                    
                 }catch(Exception e){
                     System.out.println(e);
                 }
             }
           
         }else if(ae.getSource()==Back){
             setVisible(false);
             new Transactions_login(pinnumber).setVisible(true);
         }
     }
    public static void main(String[] args){
        new deposit("");
    }
    
}
