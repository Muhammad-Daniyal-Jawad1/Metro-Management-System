/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author USMAN SOHAIL
 */
public class dbconnect {
    public static Connection Connect()
    {
        Connection sos = null;
        
        
        try{
       Class.forName("com.mysql.cj.jdbc.Driver");

        sos = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","");
                
        } catch (Exception e){
            
            {
                    JOptionPane.showMessageDialog(null, e);
            }
        }
        return sos;
    }
}