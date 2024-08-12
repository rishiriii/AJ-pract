/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myBean;

import javax.ejb.Stateful;
import java.sql.*;

/**
 *
 * @author Admin
 */
@Stateful
public class RRBean {
    public RRBean(){}
    public String roombooking(String cn, String cm,String rt){
        String message = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            String query ="SELECT *FROM roombook_63 WHERE statusroom ='Not Booked' AND roomtype = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,rt);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                String rno = rs.getString(1);
                PreparedStatement pst1 = conn.prepareStatement("UPDATE roombook_63 SET cust = ?,mob= ?,statusroom='Booked' WHERE roomid = ?");
                pst1.setString(1,cn);
                pst1.setString(3, rno);
                pst1.setString(2,cm);
                pst1.executeUpdate();
                
              
                
                message = " room "+rt+" booked and charges ="+rs.getString(3);
            }
            else{
              message = "room"+rt+"currently not available";
            }
        }
        catch(Exception e){
           message = ""+e;
        }
    return message;
    }
}

    
