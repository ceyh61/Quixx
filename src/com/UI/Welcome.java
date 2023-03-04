package com.UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Welcome extends JFrame implements ActionListener{

    private Container c;
    private JLabel title_Lb;
    private JLabel instruction_Lb;
    private JRadioButton p2_RBt;
    private JRadioButton p3_RBt;
    private JRadioButton p4_RBt;
    private JRadioButton p5_RBt;
    private ButtonGroup playerNumber_BG;
    private JButton continue_Bt;
    private JButton exit_Bt;

    public Welcome() {

        setTitle("Welcome");
        setBounds(300, 100, 400, 400);
        //setSize(400, 400);
        //setLayout(new FlowLayout());
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        c = getContentPane();
        c.setLayout(null);

        // creates the title for the welcome panel
        title_Lb = new JLabel("Welcome to The QUIXX Game");
        title_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        title_Lb.setSize(300, 25);
        title_Lb.setLocation(60, 20);
        c.add(title_Lb);

        // creates the instruction label for the welcome panel
        instruction_Lb = new JLabel("Please choose the number of the Players!");
        instruction_Lb.setFont(new Font("Arial", Font.PLAIN, 15));
        instruction_Lb.setSize(300, 25);
        instruction_Lb.setLocation(65, 80);
        c.add(instruction_Lb);

        p2_RBt = new JRadioButton("2 Players");
        p2_RBt.setFont(new Font("Arial", Font.PLAIN, 15));
        p2_RBt.setSelected(false);
        p2_RBt.setSize(120, 25);
        p2_RBt.setLocation(70, 120);
        c.add(p2_RBt);

        p3_RBt = new JRadioButton("3 Players");
        p3_RBt.setFont(new Font("Arial", Font.PLAIN, 15));
        p3_RBt.setSelected(false);
        p3_RBt.setSize(120, 25);
        p3_RBt.setLocation(70, 150);
        c.add(p3_RBt);

        p4_RBt = new JRadioButton("4 Players");
        p4_RBt.setFont(new Font("Arial", Font.PLAIN, 15));
        p4_RBt.setSelected(false);
        p4_RBt.setSize(120, 25);
        p4_RBt.setLocation(70, 180);
        c.add(p4_RBt);

        p5_RBt = new JRadioButton("5 Players");
        p5_RBt.setFont(new Font("Arial", Font.PLAIN, 15));
        p5_RBt.setSelected(false);
        p5_RBt.setSize(120, 25);
        p5_RBt.setLocation(70, 210);
        c.add(p5_RBt);

        // creates group for the (number of player) radio buttons
        playerNumber_BG = new ButtonGroup();
        playerNumber_BG.add(p2_RBt);
        playerNumber_BG.add(p3_RBt);
        playerNumber_BG.add(p4_RBt);
        playerNumber_BG.add(p5_RBt);

        // creates a button for starting and then initializing the addPlayer panel
        continue_Bt = new JButton("Continue");
        continue_Bt.setFont(new Font("Arial", Font.PLAIN, 18));
        continue_Bt.setSize(120, 30);
        continue_Bt.setLocation(200, 280);
        continue_Bt.setFocusable(false);
        continue_Bt.addActionListener(this);
        c.add(continue_Bt);

        // creates a button for closing the program 
        exit_Bt = new JButton("EXIT");
        exit_Bt.setFont(new Font("Arial", Font.PLAIN, 18));
        exit_Bt.setSize(120, 30);
        exit_Bt.setLocation(50, 280);
        exit_Bt.setFocusable(false);
        exit_Bt.addActionListener(this);
        c.add(exit_Bt);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == continue_Bt) {
            if (p2_RBt.isSelected()) {

            }
            if (p3_RBt.isSelected()) {

            }
            if (p4_RBt.isSelected()) {

            }
            if (p5_RBt.isSelected()) {

            }
            new AddPlayer();
            dispose();
        } 

        else if(e.getSource() == exit_Bt){
            // closes the program
            System.exit(0);
        }
    }
}
