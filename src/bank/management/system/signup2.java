
package bank.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class signup2 extends JFrame implements ActionListener{
     //global variable bante h kyoki hame use krna h outside the constructor
    long random;
    JTextField nameTextField,fnameTextField,emailTextField, panTextField, aadharTextField, stateTextField,pinTextField;
    JButton next;
    JRadioButton eyes,eno,other,syes,sno;
    JDateChooser dateChooser;
    JComboBox religion,category,income,occupation,education;
    String formno;
    
    signup2(String formno){
        this.formno=formno;
       setLayout(null); 
       setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
      
       JLabel additionalDetails=new JLabel("Page 2: Addional Details");
       additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
       additionalDetails.setBounds(290,80,400,30);
       add(additionalDetails);
       
       JLabel name=new JLabel("Religion:");
       name.setFont(new Font("Raleway",Font.BOLD,20));
       name.setBounds(100,140,100,30);
       add(name);
       String valreligion[]={"Hindu","Muslim","Sikh","Christain","Other"};
       religion=new JComboBox(valreligion);
       religion.setBounds(300,140,400,30);
       religion.setBackground(Color.WHITE);
       add(religion);
           
       
       JLabel fname=new JLabel("Catagory:");
       fname.setFont(new Font("Raleway",Font.BOLD,20));
       fname.setBounds(100,190,200,30);
       add(fname);
       String valcategory[]={"General","OBC","SC","ST","Other"};
       category=new JComboBox(valcategory);
       category.setBounds(300,190,400,30);
       category.setBackground(Color.WHITE);
       add(category);
       
       
       JLabel dob=new JLabel("Income:");
       dob.setFont(new Font("Raleway",Font.BOLD,20));
       dob.setBounds(100,240,200,30);
       add(dob);
       String incomecategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
       income=new JComboBox(incomecategory);
       income.setBounds(300,240,400,30);
       income.setBackground(Color.WHITE);
       add(income);
      
       
       JLabel gender=new JLabel("Educational:");
       gender.setFont(new Font("Raleway",Font.BOLD,20));
       gender.setBounds(100,290,200,30);
       add(gender);
       
       JLabel email=new JLabel("Qualifications:");
       email.setFont(new Font("Raleway",Font.BOLD,20));
       email.setBounds(100,315,200,30);
       add(email);
       String educationval[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
       education=new JComboBox(educationval);
       education.setBounds(300,315,400,30);
       education.setBackground(Color.WHITE);
       add(education);
       
       JLabel marital=new JLabel("Occupation:");
       marital.setFont(new Font("Raleway",Font.BOLD,20));
       marital.setBounds(100,390,200,30);
       add(marital);
       String occupationval[]={"Salaried","Self-Employed","Bussiness","Student","retired","Other"};
       occupation=new JComboBox(occupationval);
       occupation.setBounds(300,390,400,30);
       occupation.setBackground(Color.WHITE);
       add(occupation);
       
       
       JLabel address=new JLabel("PAN Number:");
       address.setFont(new Font("Raleway",Font.BOLD,20));
       address.setBounds(100,440,200,30);
       add(address);
       panTextField=new JTextField();
       panTextField.setFont(new Font("Raleway",Font.BOLD,14));
       panTextField.setBounds(300,440,400,30);
       add(panTextField);
       
       
       JLabel city=new JLabel("Aadhar Number:");
       city.setFont(new Font("Raleway",Font.BOLD,20));
       city.setBounds(100,490,200,30);
       add(city);
       aadharTextField=new JTextField();
       aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
       aadharTextField.setBounds(300,490,400,30);
       add(aadharTextField);
       
       JLabel state=new JLabel("Senior Citizen:");
       state.setFont(new Font("Raleway",Font.BOLD,20));
       state.setBounds(100,540,200,30);
       add(state);
        //radio buton
       syes=new JRadioButton ("Yes");
       syes.setBounds(300,540,100,30);
       syes.setBackground(Color.WHITE);
       add(syes);
       sno=new JRadioButton ("No");
       sno.setBounds(450,540,100,30);
       sno.setBackground(Color.WHITE);
       add(sno);
      //hme dono m se ak hi select krna h uske liye 
       ButtonGroup maritalgroup=new ButtonGroup();
       maritalgroup.add(syes);
       maritalgroup.add(sno);
       
       
       JLabel pin=new JLabel("Existing Account:");
       pin.setFont(new Font("Raleway",Font.BOLD,20));
       pin.setBounds(100,590,200,30);
       add(pin);
       eyes=new JRadioButton ("Yes");
       eyes.setBounds(300,590,100,30);
       eyes.setBackground(Color.WHITE);
       add(eyes);
       eno=new JRadioButton ("No");
       eno.setBounds(450,590,100,30);
       eno.setBackground(Color.WHITE);
       add(eno);
      //hme dono m se ak hi select krna h uske liye 
       ButtonGroup account=new ButtonGroup();
       account.add(eyes);
       account.add(eno);
       
       //set button to move on next page
       next=new JButton("Next");
       next.setBackground(Color.BLACK);
       next.setForeground(Color.WHITE);
       next.setFont(new Font("Raleway",Font.BOLD,14));
       next.setBounds(620,660,80,30);
       next.addActionListener(this);
       add(next);
       
       
       getContentPane().setBackground(Color.WHITE);
       //first frame banayenge
       setSize(850,800);
       setLocation(350,10);
       setVisible(true);
       
       
    }
    public void actionPerformed(ActionEvent ae){
       
        String formno=""+random;//long
        String sreligion=(String)religion.getSelectedItem();//iye ak object ko return krta h isliye typr caste kiya
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String senior=null;
        if(syes.isSelected()){
            senior="Yes";
        }else if(sno.isSelected()){
            senior="No";
        }
        
        String eaccount=null;
        if(eyes.isSelected()){
            eaccount="Yes";
        }else if(eno.isSelected()){
             eaccount="No";
        }
        String span=panTextField.getText();
        String saadhar=aadharTextField.getText();
       
        try{
           
            Conn c=new Conn();
            String querry="Insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+senior+"','"+eaccount+"')";
            c.s.executeUpdate(querry);
            //signup3 obj 
             setVisible(false);
             new signup3(formno).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
            
        }
    }
    public static void main(String[] args){
        new signup2("");
    }
    
}
