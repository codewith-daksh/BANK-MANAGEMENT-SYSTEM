
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener{
    JButton login,signup,clear;//define globaly jise m usnko constructor ke bahar bhi acces kr pau
    JTextField cardTextField;
    JPasswordField pinTextField;//hum iye alg isliye kiya kyopki password hide rahe
   LoginPage(){
       
        setTitle("AUTOMETED TELLER MACHINE");//write the tittle of frame
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//get the iamge with help of location
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);//reduce the size of enlarge image
        ImageIcon i3=new ImageIcon(i2);
        JLabel lable1=new JLabel(i3);//used insert the object in frame "iamge ko set krne ke liye
        lable1.setBounds(70,10,100,100);//set the image position but ise likne se nhi hpga hume layout null krna pdega pahle
        add(lable1);
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel Cardno=new JLabel("Card No:");
        Cardno.setFont(new Font("Raleway",Font.BOLD,28));
        Cardno.setBounds(120,150,150,30);
        add(Cardno);
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(cardTextField);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Osward",Font.BOLD,28));//set the font size 
        pin.setBounds(120,220,230,30);
        add(pin);
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        add(pinTextField);
        
        login=new JButton("SIGN IN");//ab hum JButton  ko yaha se nhta skte h kyoki jo global define ho chuke h
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);// button ke events ko catch krne ke liye
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);//background color set krme kie liye
      
        
        
        
        
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");//ise empty chhodne se text feild empty ho jata h or fill kroge to yahi likhke ayehga
            pinTextField.setText("");
        }else if(ae.getSource()==login){
            //iye sb jab krna h tb hum transaction page bna lenge 
            Conn conn=new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select *from login where cardNumber='"+cardnumber+"'and pinNumber='"+pinnumber+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){//agatr user successfully login hua h to login page to off krke transaction page kholenge
                    setVisible(false);
                    new Transactions_login(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==signup){
            setVisible(false);
           new  signup1().setVisible(true);
        }
        
    }
    public static void main(String[] args){
          new LoginPage();
    }
    
}
