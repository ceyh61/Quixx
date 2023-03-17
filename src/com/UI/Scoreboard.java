package com.UI;

import com.logics.Connector;
import com.logics.GameProcess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Scoreboard extends JFrame implements ActionListener {

    private GameProcess process;
    private Container c;
    private JLabel title_Lb;
    private JLabel p1Score_Lb;
    private JLabel p2Score_Lb;
    private JLabel p3Score_Lb;
    private JLabel p4Score_Lb;
    private JLabel p5Score_Lb;
    private JButton exit_Bt;
    private int playerNumber;

    public Scoreboard(GameProcess process) {
        this.process = process;
        Connector cnn = new Connector();
        playerNumber = process.getPlayerlist().size();

        setTitle("Scoreboard");
        setSize(800, 600);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.lightGray);

        title_Lb = new JLabel("<html><body><p style='text-align:center;'>Congratulations to you for finishing the game !</p><br>" +
                "<p style='text-align:center;font-weight:plain;'>Below is the scoreboard of the game:</p></body></html>");
        title_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        title_Lb.setBounds(150, 20, 500, 150);
        title_Lb.setOpaque(true);
        title_Lb.setBackground(new Color(30, 70, 125));
        title_Lb.setForeground(Color.white);
        title_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(title_Lb);

        exit_Bt = new JButton("Exit");
        exit_Bt.setFont(new Font("Arial", Font.BOLD, 18));
        exit_Bt.setBounds(685, 20, 80, 50);
        exit_Bt.setOpaque(true);
        exit_Bt.setBackground(new Color(209,26,42));
        exit_Bt.setForeground(Color.white);
        exit_Bt.setFocusable(false);
        exit_Bt.addActionListener(this);
        c.add(exit_Bt);

        p1Score_Lb = new JLabel(process.getPlayerNames().get(0)+":  "+ cnn.calculatePointsOfPlayer("p1") + " points");
        p1Score_Lb.setFont(new Font("Arial", Font.PLAIN, 16));
        p1Score_Lb.setBounds(150, 200, 500, 50);
        p1Score_Lb.setOpaque(true);
        p1Score_Lb.setBackground(new Color(30, 70, 125));
        p1Score_Lb.setForeground(Color.white);
        p1Score_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(p1Score_Lb);

        p2Score_Lb = new JLabel(process.getPlayerNames().get(1)+":  "+ cnn.calculatePointsOfPlayer("p2") + " points");
        p2Score_Lb.setFont(new Font("Arial", Font.PLAIN, 16));
        p2Score_Lb.setBounds(150, 270, 500, 50);
        p2Score_Lb.setOpaque(true);
        p2Score_Lb.setBackground(new Color(30, 70, 125));
        p2Score_Lb.setForeground(Color.white);
        p2Score_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(p2Score_Lb);

        if(playerNumber >= 3) {

            p3Score_Lb = new JLabel(process.getPlayerNames().get(2)+":  "+ cnn.calculatePointsOfPlayer("p3") + " points");
            p3Score_Lb.setFont(new Font("Arial", Font.PLAIN, 16));
            p3Score_Lb.setBounds(150, 340, 500, 50);
            p3Score_Lb.setOpaque(true);
            p3Score_Lb.setBackground(new Color(30, 70, 125));
            p3Score_Lb.setForeground(Color.white);
            p3Score_Lb.setHorizontalAlignment(SwingConstants.CENTER);
            c.add(p3Score_Lb);

        }

        if(playerNumber >= 4) {

            p4Score_Lb = new JLabel(process.getPlayerNames().get(3)+":  "+ cnn.calculatePointsOfPlayer("p4") + " points");
            p4Score_Lb.setFont(new Font("Arial", Font.PLAIN, 16));
            p4Score_Lb.setBounds(150, 410, 500, 50);
            p4Score_Lb.setOpaque(true);
            p4Score_Lb.setBackground(new Color(30, 70, 125));
            p4Score_Lb.setForeground(Color.white);
            p4Score_Lb.setHorizontalAlignment(SwingConstants.CENTER);
            c.add(p4Score_Lb);

        }

        if(playerNumber == 5) {

            p5Score_Lb = new JLabel( process.getPlayerNames().get(4)+":  "+ cnn.calculatePointsOfPlayer("p5") + " points");
            p5Score_Lb.setFont(new Font("Arial", Font.PLAIN, 16));
            p5Score_Lb.setBounds(150, 480, 500, 50);
            p5Score_Lb.setOpaque(true);
            p5Score_Lb.setBackground(new Color(30, 70, 125));
            p5Score_Lb.setForeground(Color.white);
            p5Score_Lb.setHorizontalAlignment(SwingConstants.CENTER);
            c.add(p5Score_Lb);

        }
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit_Bt){
            int choice = JOptionPane.showConfirmDialog
                    (null, "Do you want to Exit from the Game?\n\nWarning: All data will be DELETED !",
                            "Confirm", JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION) {
                // deletes evething before closing the program
                Connector cnn = new Connector();
                cnn.deleteEverything();
                // closes the program
                System.exit(0);
            } else if (choice == JOptionPane.YES_OPTION){
                // DO NOTHING!
            }
        }
    }
}
