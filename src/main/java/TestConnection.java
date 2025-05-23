/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author paylo
 */
public class TestConnection {

    public static Connection conn(){
        try{
            String url = "jdbc:mysql://localhost:3306/member";
            String user = "root";
            String password = "";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch(SQLException|ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println("Ewan");
        Connection conn = TestConnection.conn();
        PreparedStatement pst;
        ResultSet rs;
        try{
        String query = "SELECT * FROM members";
        pst = conn.prepareStatement(query);
        
        rs = pst.executeQuery();
        if(rs.next()){
            
            String idNum = rs.getString(1);
            System.out.println(idNum);
            
            String name = rs.getString(2);
            System.out.println(name);
            
            String mobileNum = rs.getString(3);
            System.out.println(mobileNum);
            
            String emailAdd = rs.getString(4);
            System.out.println(emailAdd);
            
            String gender = rs.getString(5);
            System.out.println(gender);
            
            String time = rs.getString(6);
            System.out.println(time);
            
        }
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
