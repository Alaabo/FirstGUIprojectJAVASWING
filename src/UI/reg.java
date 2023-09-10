package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import static BACKEND.hashing.doshing;

public class reg extends JFrame {
    Connection con = null;
    PreparedStatement pst =null;

    Font Poppins_big = new Font("poppins", Font.BOLD ,26);
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2= new JPanel();
        JPanel panel4= new JPanel();
        JPanel panel5= new JPanel();
        JPanel sex_panel = new JPanel();
        JPanel panel3 = new JPanel();
        JLabel l1 = new JLabel("BBS");
        JLabel l2 = new JLabel("full name");
        JLabel l3 = new JLabel("Email");
        JLabel l4 = new JLabel("address");
        JLabel l5 = new JLabel("username");
        JLabel l6 = new JLabel("sex");
        JLabel l7 = new JLabel("password");
        JLabel l8 = new JLabel("confirm your password");
        JLabel l9 = new JLabel("Already have an account ??");
        JRadioButton m = new JRadioButton("male");
        JRadioButton f = new JRadioButton("female");
        JCheckBox conditions = new JCheckBox("i agree to all conditions of use and rules");
        JTextField l2_t = new JTextField(20);
        JTextField l3_t = new JTextField(20);
        JTextField l4_t = new JTextField(20);
        JTextField l5_t = new JTextField(20);
        JPasswordField l7_p = new JPasswordField(20);
        JPasswordField l8_p = new JPasswordField(20);
        JButton register = new JButton("register");
        JButton cancel = new JButton("exit");
        public reg(){
            setTitle("REGISTRATION");
            setFont(Poppins_big);
            l1.setFont(Poppins_big);
            l1.setFont(l1.getFont().deriveFont(48f));
            panel1.add(l1);
////////////////////////////////////////
            panel.setLayout(new BorderLayout());
////////////////////////////////////////
            panel2.add(l2);
            panel2.add(l2_t);
            panel2.add(l3);
            panel2.add(l3_t);
            panel2.add(l4);
            panel2.add(l4_t);
            panel2.add(l5);
            panel2.add(l5_t);
            panel2.add(l7);
            panel2.add(l7_p);
            panel2.add(l8);
            panel2.add(l8_p);
//////////////////////////////////
            sex_panel.add(l6);
            sex_panel.add(f);
            sex_panel.add(m);
            panel2.add(sex_panel);
//////////////////////////////////

            panel3.add(conditions);
            panel2.add(panel3);
//////////////////////////////
            panel4.add(register);
            panel4.add(cancel);
//////////////////////////////////
            panel5.add(l9);
            panel1.add(panel5);
            //////////////////////////////////
            panel.add(panel1 , BorderLayout.NORTH);
            panel.add(panel2 , BorderLayout.CENTER);
            panel.add(panel4 , BorderLayout.SOUTH);


            ///////////////////////////////////////////////
            m.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (m.isSelected())
                    {
                        f.setSelected(false);
                        l6.setText("male");
                    }

                }
            });
            f.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (f.isSelected())
                    {
                        m.setSelected(false);
                        l6.setText("female");
                    }

                }
            });


            cancel.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   setVisible(false);
                    new LOGIN();
                }
            });
            register.addActionListener(new ActionListener(
            ) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String isempty;
                    isempty ="";
                    if(l2_t.getText().equals(isempty) && l4_t.getText().equals(isempty) && l3_t.getText().equals(isempty)  && l7_p.getText().equals(isempty) && l5_t.getText().equals(isempty))
                    {
                        JOptionPane.showMessageDialog(null,"you cant leave fields blank");
                    }
                    else
                    {
                        if(!l7_p.getText().equals(l8_p.getText())){
                            JOptionPane.showMessageDialog(null,"please confirm your password they are not matched");
                        }
                        else {


                            if (conditions.isSelected())
                            {
                                try {
                                    String query ="INSERT INTO `users`(`full_name`, `address`, `email`, `sex`, `password`, `user_name`) VALUES (?,?,?,?,?,?)";
                                    con = DriverManager.getConnection("jdbc:mysql://localhost/banking system","root","110119720");
                                    pst = con.prepareStatement(query);
                                    pst.setString(1, l2_t.getText());
                                    pst.setString(2, l4_t.getText());
                                    pst.setString(3, l3_t.getText());
                                    pst.setString(4, l6.getText());
                                    pst.setString(5, doshing(l7_p.getText()));
                                    pst.setString(6, l5_t.getText());
                                    pst.executeUpdate();
                                    JOptionPane.showMessageDialog(null,"you are registred now welcome hero");
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null,ex);
                                    ex.printStackTrace();
                                }
                                //////////////////////
                                try {
                                    String query ="INSERT INTO `wallet`(`user_name`, `wallet_address`, `wallet_ballance`) VALUES (?,?,?)";
                                    con = DriverManager.getConnection("jdbc:mysql://localhost/banking system","root","110119720");
                                    pst = con.prepareStatement(query);
                                    pst.setString(1, l5_t.getText());
                                    pst.setString(2, doshing(l5_t.getText()));
                                    pst.setString(3, "100");
                                    pst.executeUpdate();

                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null,ex);
                                    ex.printStackTrace();
                                }
                                //////////////////////////
                            }
                            else{
                                JOptionPane.showMessageDialog(null,"please agree to the terms and use conditions");
                            }
                        }
                    }

                }
            });
            ///////////////////////////////////////////////

            setSize(270 , 520);

            setResizable(false);
            setLocationRelativeTo(null);
            getContentPane().add(panel);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);

        }

    public static void main(String[] args) {
        new reg();
    }


}
