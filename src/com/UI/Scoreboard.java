package com.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Scoreboard extends JFrame implements ActionListener {

    private Container c;
    private JLabel title_Lb;
    private JLabel p1Score_Lb;
    private JLabel p2Score_Lb;
    private JLabel p3Score_Lb;
    private JLabel p4Score_Lb;
    private JLabel p5Score_Lb;

    public Scoreboard() {

        boolean b = false;

        setTitle("Scoreboard");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

        p1Score_Lb = new JLabel("Player1: X");
        p1Score_Lb.setFont(new Font("Arial", Font.PLAIN, 16));
        p1Score_Lb.setBounds(150, 200, 500, 50);
        p1Score_Lb.setOpaque(true);
        p1Score_Lb.setBackground(new Color(30, 70, 125));
        p1Score_Lb.setForeground(Color.white);
        p1Score_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(p1Score_Lb);

        p2Score_Lb = new JLabel("Player2: X");
        p2Score_Lb.setFont(new Font("Arial", Font.PLAIN, 16));
        p2Score_Lb.setBounds(150, 270, 500, 50);
        p2Score_Lb.setOpaque(true);
        p2Score_Lb.setBackground(new Color(30, 70, 125));
        p2Score_Lb.setForeground(Color.white);
        p2Score_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(p2Score_Lb);

        if(b) {

            p3Score_Lb = new JLabel("Player3: X");
            p3Score_Lb.setFont(new Font("Arial", Font.PLAIN, 16));
            p3Score_Lb.setBounds(150, 340, 500, 50);
            p3Score_Lb.setOpaque(true);
            p3Score_Lb.setBackground(new Color(30, 70, 125));
            p3Score_Lb.setForeground(Color.white);
            p3Score_Lb.setHorizontalAlignment(SwingConstants.CENTER);
            c.add(p3Score_Lb);

        }

        if(b) {

            p4Score_Lb = new JLabel("Player4: X");
            p4Score_Lb.setFont(new Font("Arial", Font.PLAIN, 16));
            p4Score_Lb.setBounds(150, 410, 500, 50);
            p4Score_Lb.setOpaque(true);
            p4Score_Lb.setBackground(new Color(30, 70, 125));
            p4Score_Lb.setForeground(Color.white);
            p4Score_Lb.setHorizontalAlignment(SwingConstants.CENTER);
            c.add(p4Score_Lb);

        }

        if(b) {

            p5Score_Lb = new JLabel("Player5: X");
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

    }
}
