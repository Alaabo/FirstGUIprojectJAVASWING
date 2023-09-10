package BACKEND;

import javax.swing.*;
import java.sql.*;

import static BACKEND.hashing.doshing;

public class  balance {

    public static String balance(String username) {
        Connection con = null;

        ///////////////////////////////
        try {
            String query = "SELECT `wallet_ballance` FROM `wallet` WHERE user_name = \""+username+"\"";
            con = DriverManager.getConnection("jdbc:mysql://localhost/banking system", "root", "110119720");
            Statement pst = con.createStatement();
            ResultSet rs = pst.executeQuery(query);
            rs.next();
            String balance = rs.getString("wallet_ballance");

            //pst.close();
           // con.close();
            return balance;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
            return "xx.xx";
        }

    }



}

