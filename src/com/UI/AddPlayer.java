package com.UI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

import com.logics.Connector;
import com.logics.GameProcess;

public class AddPlayer extends JFrame implements ActionListener{

    private Container c;
    private JLabel title_Lb;
    private JLabel instruction_Lb;
    private JLabel p1_Lb;
    private JLabel p2_Lb;
    private JLabel p3_Lb;
    private JLabel p4_Lb;
    private JLabel p5_Lb;
    private JTextField p1_Tf;
    private JTextField p2_Tf;
    private JTextField p3_Tf;
    private JTextField p4_Tf;
    private JTextField p5_Tf;
    private JButton continue_Bt;
    private JButton exit_Bt;
    private int numberPlayers;

    public AddPlayer(int numberPlayers) {
        this.numberPlayers = numberPlayers;
        setTitle("Welcome");
        setBounds(300, 100, 400, 400);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);

        // creates the title for the welcome panel
        title_Lb = new JLabel("Welcome to the Add-Player Panel");
        title_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        title_Lb.setSize(300, 25);
        title_Lb.setLocation(60, 20);
        c.add(title_Lb);

        // creates the instruction label for the welcome panel
        instruction_Lb = new JLabel("Please Enter each players name!");
        instruction_Lb.setFont(new Font("Arial", Font.PLAIN, 15));
        instruction_Lb.setSize(300, 25);
        instruction_Lb.setLocation(65, 80);
        c.add(instruction_Lb);

        // creates a label for the input box of first user
        p1_Lb = new JLabel("Player 1");
        p1_Lb.setFont(new Font("Arial", Font.PLAIN, 18));
        p1_Lb.setSize(120, 25);
        p1_Lb.setLocation(60, 120);

        // creates a label for the input box of first user
        p2_Lb = new JLabel("Player 2");
        p2_Lb.setFont(new Font("Arial", Font.PLAIN, 18));
        p2_Lb.setSize(120, 25);
        p2_Lb.setLocation(60, 150);

        // creates a label for the input box of first user
        p3_Lb = new JLabel("Player 3");
        p3_Lb.setFont(new Font("Arial", Font.PLAIN, 18));
        p3_Lb.setSize(120, 25);
        p3_Lb.setLocation(60, 180);

        // creates a label for the input box of first user
        p4_Lb = new JLabel("Player 4");
        p4_Lb.setFont(new Font("Arial", Font.PLAIN, 18));
        p4_Lb.setSize(120, 25);
        p4_Lb.setLocation(60, 210);

        // creates a label for the input box of first user
        p5_Lb = new JLabel("Player 5");
        p5_Lb.setFont(new Font("Arial", Font.PLAIN, 18));
        p5_Lb.setSize(120, 25);
        p5_Lb.setLocation(60, 240);

        // creates a field for first user to enter the name
        p1_Tf = new JTextField();
        p1_Tf.setFont(new Font("Arial", Font.PLAIN, 15));
        p1_Tf.setSize(190, 20);
        p1_Tf.setLocation(160, 120);

        // creates a field for first user to enter the name
        p2_Tf = new JTextField();
        p2_Tf.setFont(new Font("Arial", Font.PLAIN, 15));
        p2_Tf.setSize(190, 20);
        p2_Tf.setLocation(160, 150);

        // creates a field for first user to enter the name
        p3_Tf = new JTextField();
        p3_Tf.setFont(new Font("Arial", Font.PLAIN, 15));
        p3_Tf.setSize(190, 20);
        p3_Tf.setLocation(160, 180);

        // creates a field for first user to enter the name
        p4_Tf = new JTextField();
        p4_Tf.setFont(new Font("Arial", Font.PLAIN, 15));
        p4_Tf.setSize(190, 20);
        p4_Tf.setLocation(160, 210);

        // creates a field for first user to enter the name
        p5_Tf = new JTextField();
        p5_Tf.setFont(new Font("Arial", Font.PLAIN, 15));
        p5_Tf.setSize(190, 20);
        p5_Tf.setLocation(160, 240);
        
        // according to the number of players it displays the name input
        switch (numberPlayers) {
            // creates only 2 label and input boxes
            case (2):   c.add(p1_Lb);
                        c.add(p2_Lb);
                        c.add(p1_Tf);
                        c.add(p2_Tf);
                break;   
            // creates only 3 label and input boxes 
            case (3):   c.add(p1_Lb);
                        c.add(p2_Lb);
                        c.add(p3_Lb);
                        c.add(p1_Tf);
                        c.add(p2_Tf);
                        c.add(p3_Tf);
                break;
            // creates 4 label and input boxes    
            case (4):   c.add(p1_Lb);
                        c.add(p2_Lb);
                        c.add(p3_Lb);
                        c.add(p4_Lb);
                        c.add(p1_Tf);
                        c.add(p2_Tf);
                        c.add(p3_Tf);
                        c.add(p4_Tf);
                break;
            // creates label and input boxes for may amount of players    
            case (5):   c.add(p1_Lb);
                        c.add(p2_Lb);
                        c.add(p3_Lb);
                        c.add(p4_Lb);
                        c.add(p5_Lb);
                        c.add(p1_Tf);
                        c.add(p2_Tf);
                        c.add(p3_Tf);
                        c.add(p4_Tf);
                        c.add(p5_Tf);
                break;
            default:
                break;
        }

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

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == continue_Bt) {

            Connector cnn = new Connector();
            ArrayList<String> playerNames = new ArrayList<String>();
            String msg = "";

            // gets the input (player Names) as String/text
            String p1_Name = p1_Tf.getText();
            String p2_Name = p2_Tf.getText();
            String p3_Name = p3_Tf.getText();
            String p4_Name = p4_Tf.getText();
            String p5_Name = p5_Tf.getText();

            switch (numberPlayers) {
                // checks the input of the two players
                case (2):   msg += cnn.validateName(p1_Name);
                            msg += "\n"+cnn.validateName(p2_Name);
                            playerNames.add(p1_Name);
                            playerNames.add(p2_Name);
                    break;   
                // checks the input of the three players
                case (3):   msg += cnn.validateName(p1_Name);
                            msg += "\n"+cnn.validateName(p2_Name);
                            msg += "\n"+cnn.validateName(p3_Name);
                            playerNames.add(p1_Name);
                            playerNames.add(p2_Name);
                            playerNames.add(p3_Name);
                    break;
                // checks the input of the four players    
                case (4):   msg += cnn.validateName(p1_Name);
                            msg += "\n"+cnn.validateName(p2_Name);
                            msg += "\n"+cnn.validateName(p3_Name);
                            msg += "\n"+cnn.validateName(p4_Name);
                            playerNames.add(p1_Name);
                            playerNames.add(p2_Name);
                            playerNames.add(p3_Name);
                            playerNames.add(p4_Name);
                    break;
                // checks the input of the all players (max. 5 names)   
                case (5):   msg += cnn.validateName(p1_Name);
                            msg += "\n"+cnn.validateName(p2_Name);
                            msg += "\n"+cnn.validateName(p3_Name);
                            msg += "\n"+cnn.validateName(p4_Name);
                            msg += "\n"+cnn.validateName(p5_Name);
                            playerNames.add(p1_Name);
                            playerNames.add(p2_Name);
                            playerNames.add(p3_Name);
                            playerNames.add(p4_Name);
                            playerNames.add(p5_Name);
                    break;
                default:
                    break;
            }

            // if there is a mistake in the input boxes it shows a message
            if (!msg.isEmpty()) {
                // displays the message if there is any problem with the input
                if (msg.length() > 10) {
                    JOptionPane.showMessageDialog(null, msg);
                }
                // as the message can not be Empty due to line skipping "\n" then it checks of the length
                // of the line is less than 10 characters, which means the message is empty and there is no problem 
                if (msg.length() < 10) {
                    GameProcess game = new GameProcess(numberPlayers);
                    game.savePlayerNames(playerNames);
                    new DicePage(game);
                    dispose();
                }
            }

        } 

        else if(e.getSource() == exit_Bt){
            // deletes evething before closing the program
            Connector cnn = new Connector();
            cnn.deleteEverything();
            // closes the program
            System.exit(0);
        }
    }
}
