
package bank.management.system;

import java.sql.*;
import java.sql.DriverManager;
public class Conn {
    Connection con;
    Statement s;
    public Conn(){
        try{
           //load driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagemensystem","root","root1234");
            s=con.createStatement();
            //Execute qyerry
        }catch(Exception e){
            System.out.println(e);
        }
                    
    }
}
