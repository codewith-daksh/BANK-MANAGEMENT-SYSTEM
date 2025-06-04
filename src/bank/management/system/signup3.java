
package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class signup3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    signup3(String formno){
        this.formno=formno;
        setLayout(null);
        
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        //make 4 radio buttons
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,200,20);
        add(r1);
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,230,20);
        add(r2);
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,200,20);
        add(r3);
        r4=new JRadioButton("Reccuring Deposite Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);
        //koi ak hi slect ho isliye 
        ButtonGroup groupaccount=new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card=new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        JLabel num=new JLabel("XXXX-XXXX-XXXX-4185");
        num.setFont(new Font("Raleway",Font.BOLD,22));
        num.setBounds(330,300,300,30);
        add(num);
        //user ko batane ke liye kio kitne digit ka number enter krna h
        JLabel carddetail=new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(100,330,300,20);
        add(carddetail);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        JLabel pnum=new JLabel("XXXX");
        pnum.setFont(new Font("Raleway",Font.BOLD,22));
        pnum.setBounds(330,370,300,30);
        add(pnum);
        JLabel pindetail=new JLabel("Your 4 Digit Pin Number");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(100,400,300,20);
        add(pindetail);
        
        JLabel service=new JLabel("Services Required:");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,450,400,30);
        add(service);
        
        c1=new JCheckBox("Atm Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        c4=new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        c7=new JCheckBox("I Hereby declares that the above entered details are correct");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,680,600,30);
        add(c7);
        
        submit =new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(100,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel =new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        getContentPane().setBackground(Color.WHITE);//change frame bg 
        //make a frame 
        setSize(850, 820);
        setLocation(350,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accounttype =null;
            if(r1.isSelected()){
                accounttype="Saving Account";
            }else if(r2.isSelected()){
                 accounttype="Fixed Deposite Account";
            }else if(r3.isSelected()){
                 accounttype="Current Account";
            }else if(r2.isSelected()){
                 accounttype="Reccuring Deposite Account";
            }
            Random random=new Random();
            String  cardnumber=""+(Math.abs(random.nextLong()%90000000L)+504093600000000L);
            String  pinnumber=""+(Math.abs(random.nextLong()%9000L)+1000L);
            String facility="";
            if(c1.isSelected()){
                facility=facility+" ATM Card";
            }else if(c2.isSelected()){
                 facility=facility+" InternetBanking";
            }else if(c3.isSelected()){
                 facility=facility+" Mobile Banking";
            }else if(c4.isSelected()){
                 facility=facility+" Email & SMS Alerts";
            }else if(c5.isSelected()){
                 facility=facility+" Cheque Book";
            }else if(c6.isSelected()){
                 facility=facility+" E-Statement";
            }
            
            try{
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else{
                    Conn conn=new Conn();
                    String querry1="Insert into signup3 values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String querry2="Insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(querry1);
                    conn.s.executeUpdate(querry2);
                    
                    
                    JOptionPane.showMessageDialog(null,"Card Number: "+ cardnumber+"\n Pin: "+pinnumber);
                    setVisible(false);
                    new deposit(pinnumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new LoginPage().setVisible(true);
        }
    }
    public static void main(String[] args){
        new signup3("");
    }
}
