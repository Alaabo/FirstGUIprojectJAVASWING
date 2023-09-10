package UI;


import BACKEND.cridentials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import static BACKEND.hashing.doshing;
import static javax.swing.JOptionPane.showMessageDialog;

public class LOGIN extends JFrame {
    Font Poppins_big = new Font("poppins", Font.BOLD ,26);
    private JPanel panel= new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JLabel l1 = new JLabel("BBC");
    private JLabel l2 = new JLabel("username");
    private JLabel l3= new JLabel("password");
    private JLabel l4= new JLabel("Don't have account yet ??");
    private JButton login = new JButton("Login");
    private JButton exit = new JButton("Exit");

    public LOGIN(){
        setFont(Poppins_big);
        setTitle("login");
        l1.setFont(Poppins_big);
        l1.setFont(l1.getFont().deriveFont(70f));
        username.setColumns(20);
        password.setColumns(20);
        panel2.setLayout(new FlowLayout());
        panel1.setLayout(new FlowLayout());
        panel.setLayout(new BoxLayout(panel , BoxLayout.Y_AXIS));
        panel1.add(l1);

        panel2.add(l2);
        panel2.add(username);
        panel2.add(l3);
        panel2.add(password);

        panel3.add(login);
        panel3.add(exit);
        panel4.add(l4);
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        ///////////////////////
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = null;
                String user_db = new String() ,pass_db = new String(),hashedpass = new String(),user= new String();
                hashedpass = doshing(password.getText());
                user = username.getText();

                ///////////////////////////////
                try {
                    String query = "SELECT `password`, `user_name` FROM `users` WHERE user_name = \""+user+"\"";
                    con = DriverManager.getConnection("jdbc:mysql://localhost/banking system", "root", "110119720");
                    Statement stm = con.createStatement();
                    ResultSet rs = stm.executeQuery(query);
                    while (rs.next()){
                        pass_db = rs.getString("password");
                        user_db = rs.getString("user_name");
                    }



                    if(user_db.equals(user)&& pass_db.equals(hashedpass)){
                        new wallet();

                        setVisible(false);


                    }
                    else {
                        JOptionPane.showMessageDialog(null, "your username or password are wrong check them again");
                    }


                } catch (SQLException ex) {
                    showMessageDialog(null, ex);
                    ex.printStackTrace();

                }

            }
        });

        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("EXIT");
                if(JOptionPane.showConfirmDialog(frame,"Confirm if you want Exit", "EXIT",
                        JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
                {
                    System.exit(0);
                }
            }
        });
        l4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new reg();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }


        });

        /////////////////////////
        setSize(300 , 500);

        setResizable(false);
        setLocationRelativeTo(null);

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LOGIN();
    }
}
