package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static BACKEND.balance.balance;

public class wallet extends JFrame {
    private String adrr;

    public wallet () {
        Font Poppins_big = new Font("poppins", Font.BOLD ,26);
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JLabel label = new JLabel("BBC");
        JLabel l1 = new JLabel("your balance is:");
        JLabel l2 = new JLabel("");
        JLabel l3 = new JLabel("send balance");
        JLabel l4 = new JLabel("receive balance");
        JLabel l5 = new JLabel("wallet");
        JLabel l6 = new JLabel("");
        JButton logout = new JButton("logout");
        JButton EXIT = new JButton("EXIT");
        //////////////////////////////////////
        panel.setLayout(new BorderLayout());
        //////////////////////////////////////
        setTitle("REGISTRATION");
        setFont(Poppins_big);
        l1.setFont(Poppins_big);
        l1.setFont(l1.getFont().deriveFont(48f));
        panel1.add(l1);
        l2.setFont(Poppins_big);
        l2.setFont(l1.getFont().deriveFont(48f));
        panel1.add(l2);
        l2.setText(balance(adrr));

        /////////////////////////////////////
        l5.setFont(Poppins_big);
        l5.setFont(l1.getFont().deriveFont(24f));
        l4.setFont(Poppins_big);
        l4.setFont(l1.getFont().deriveFont(24f));
        l3.setFont(Poppins_big);
        l3.setFont(l1.getFont().deriveFont(24f));
        l6.setFont(Poppins_big);
        l6.setFont(l1.getFont().deriveFont(48f));
        label.setFont(Poppins_big);
        label.setFont(l1.getFont().deriveFont(100f));
        panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
        panel2.add(label);
        panel2.add(l5);
        panel2.add(l4);
        panel2.add(l3);
        ////////////////////////////////////
        panel3.setLayout(new FlowLayout());
        logout.setBorderPainted(false);
        EXIT.setBorderPainted(false);
        panel3.add(logout);
        panel3.add(EXIT);
        //////////////////////////////////////
        panel.add(panel1 , BorderLayout.CENTER);
        panel.add(panel2 , BorderLayout.WEST);
        panel.add(panel3 , BorderLayout.SOUTH);
        ///////////////////////////////////////
        setSize(800 , 900);

        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //////////////////////////////////////
        //ACTIONLINK'S
        ////////////////////////////////////
        logout.addActionListener(e -> {
            new LOGIN();
            setVisible(false);
        });
        //////////////////////////////////////
        EXIT.addActionListener(new ActionListener() {
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
        /////////////////////////////////////


    }



}
