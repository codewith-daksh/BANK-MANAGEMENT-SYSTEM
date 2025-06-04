
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class pinchange extends JFrame implements ActionListener {
    JPasswordField pinTextField, repinTextField;
    JButton change,back;
    String pinnumber;
    pinchange(String pinnumber){
        this.pinnumber=pinnumber;
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);//reduce the size of enlarge image
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
       JLabel text=new JLabel("CHANGE YOUR PIN");
       text.setForeground(Color.WHITE);
       text.setFont(new Font("Raleway",Font.BOLD,16));
       text.setBounds(250,280,500,35);
       image.add(text);
       
       JLabel pintext=new JLabel("New PIN:");
       pintext.setForeground(Color.WHITE);
       pintext.setFont(new Font("Raleway",Font.BOLD,16));
       pintext.setBounds(165,320,180,25);
       image.add(pintext);
       pinTextField=new JPasswordField();
       pinTextField.setFont(new Font("Raleway",Font.BOLD,20));
       pinTextField.setBounds(330,320,180,25);
       image.add(pinTextField);
       
       JLabel repintext=new JLabel("Re-Enter PIN:");
       repintext.setForeground(Color.WHITE);
       repintext.setFont(new Font("Raleway",Font.BOLD,16));
       repintext.setBounds(165,360,180,25);
       image.add(repintext);
       repinTextField=new JPasswordField();
       repinTextField.setFont(new Font("Raleway",Font.BOLD,20));
       repinTextField.setBounds(330,360,180,25);
       image.add(repinTextField);
       
       change=new JButton("CHANGE");
       change.setBounds(355,459,150,30);
       change.addActionListener(this);
       image.add(change);
       
       back=new JButton("BACK");
       back.setBounds(355,492,150,30);
       back.addActionListener(this);
       image.add(back);
       
        
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
            String npin=pinTextField.getText();
            String rpin=repinTextField.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN does no0t match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter PIN");
                return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, "Please Re-enter PIN");
                return;
            }//ab hum jdbc connection banayenge
            Conn conn=new Conn();
            String q1="update bank set pin= '"+rpin+"' where pin='"+pinnumber+"'";
            String q2="update login set pinNumber= '"+rpin+"' where pinNumber='"+pinnumber+"'";
            String q3="update signup3 set pinNumber= '"+rpin+"' where pinNumber='"+pinnumber+"'";
            conn.s.executeUpdate(q1);
            conn.s.executeUpdate(q2);
            conn.s.executeUpdate(q3);
            
            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            setVisible(false);
            new Transactions_login(rpin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
        }else{
             setVisible(false);
             new Transactions_login(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args){
        new pinchange("").setVisible(true);
    }
    
}
