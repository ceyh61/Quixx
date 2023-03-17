package com.UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

import com.logics.Connector;
import com.logics.GameProcess;

public class DicePage extends JFrame implements ActionListener{

    private Container c;
    private JLabel title_Lb;
    private JLabel p1_Name_Lb;
    private JLabel p2_Name_Lb;
    private JLabel p3_Name_Lb;
    private JLabel p4_Name_Lb;
    private JLabel p5_Name_Lb;
    private JLabel penalty_Lb; 
    private JLabel whiteDice1_LB;
    private JLabel whiteDice2_LB;
    private JLabel redDice_LB;
    private JLabel yellowDice_LB;
    private JLabel greenDice_LB;
    private JLabel blueDice_LB;
    private JButton roll_Bt;
    private JButton exit_Bt;

    private JButton continue_Bt;
    private GameProcess process;

    public DicePage(GameProcess process) {

        this.process = process;

        setTitle("Dice Page");
        setBounds(300, 100, 700, 420);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);

        // creates the title for the welcome panel
        title_Lb = new JLabel("QUIXX", SwingConstants.CENTER);
        title_Lb.setFont(new Font("Arial", Font.BOLD, 20));
        title_Lb.setSize(80, 25);
        title_Lb.setLocation(300, 20);
        //title_Lb.setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.ORANGE));
        c.add(title_Lb);
        Connector cnn = new Connector();
        // creates a label for the number of penalties
        penalty_Lb = new JLabel(cnn.getPenaltyNumbers(process.getActivePlayer()) + " Penalties", SwingConstants.CENTER);
        penalty_Lb.setFont(new Font("Arial", Font.PLAIN, 18));
        penalty_Lb.setSize(120, 30);
        penalty_Lb.setLocation(550, 60);
        penalty_Lb.setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.ORANGE));
        c.add(penalty_Lb);

        // creates a label for the name of the first user
        p1_Name_Lb = new JLabel("Player 1", SwingConstants.CENTER);
        p1_Name_Lb.setFont(new Font("Arial", Font.PLAIN, 18));
        p1_Name_Lb.setSize(80, 30);
        p1_Name_Lb.setLocation(50, 60);
        p1_Name_Lb.setBorder(new BevelBorder(BevelBorder.RAISED, Color.black, Color.black));
        c.add(p1_Name_Lb);

        // creates a label for the name of the second user
        p2_Name_Lb = new JLabel("Player 2", SwingConstants.CENTER);
        p2_Name_Lb.setFont(new Font("Arial", Font.PLAIN, 18));
        p2_Name_Lb.setSize(80, 30);
        p2_Name_Lb.setLocation(140, 60);
        p2_Name_Lb.setBorder(new BevelBorder(BevelBorder.RAISED, Color.black, Color.black));
        c.add(p2_Name_Lb);

        // creates a label for the name of the third user
        p3_Name_Lb = new JLabel("Player 3", SwingConstants.CENTER);
        p3_Name_Lb.setFont(new Font("Arial", Font.PLAIN, 18));
        p3_Name_Lb.setSize(80, 30);
        p3_Name_Lb.setLocation(230, 60);
        p3_Name_Lb.setBorder(new BevelBorder(BevelBorder.RAISED, Color.black, Color.black));
        c.add(p3_Name_Lb);

        // creates a label for the name of the fourth user
        p4_Name_Lb = new JLabel("Player 4", SwingConstants.CENTER);
        p4_Name_Lb.setFont(new Font("Arial", Font.PLAIN, 18));
        p4_Name_Lb.setSize(80, 30);
        p4_Name_Lb.setLocation(320, 60);
        p4_Name_Lb.setBorder(new BevelBorder(BevelBorder.RAISED, Color.black, Color.black));
        c.add(p4_Name_Lb);

        // creates a label for the name of the fifth user
        p5_Name_Lb = new JLabel("Player 5", SwingConstants.CENTER);
        p5_Name_Lb.setFont(new Font("Arial", Font.PLAIN, 18));
        p5_Name_Lb.setSize(80, 30);
        p5_Name_Lb.setLocation(410, 60);
        p5_Name_Lb.setBorder(new BevelBorder(BevelBorder.RAISED, Color.black, Color.black));
        c.add(p5_Name_Lb);

        // creates a label for the name of the first white dice
        whiteDice1_LB = new JLabel("0", SwingConstants.CENTER);
        whiteDice1_LB.setFont(new Font("Arial", Font.PLAIN, 18));
        whiteDice1_LB.setSize(50, 50);
        whiteDice1_LB.setLocation(100, 150);
        whiteDice1_LB.setBorder(new BevelBorder(BevelBorder.RAISED, Color.black, Color.black));
        c.add(whiteDice1_LB);

        // creates a label for the name of the second white dice
        whiteDice2_LB = new JLabel("0", SwingConstants.CENTER);
        whiteDice2_LB.setFont(new Font("Arial", Font.PLAIN, 18));
        whiteDice2_LB.setSize(50, 50);
        whiteDice2_LB.setLocation(180, 150);
        whiteDice2_LB.setBorder(new BevelBorder(BevelBorder.RAISED, Color.black, Color.black));
        c.add(whiteDice2_LB);

        // creates a label for the name of the first white dice
        redDice_LB = new JLabel("0", SwingConstants.CENTER);
        redDice_LB.setFont(new Font("Arial", Font.PLAIN, 18));
        redDice_LB.setSize(50, 50);
        redDice_LB.setLocation(260, 150);
        redDice_LB.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, Color.RED));
        c.add(redDice_LB);

        // creates a label for the name of the first white dice
        yellowDice_LB = new JLabel("0", SwingConstants.CENTER);
        yellowDice_LB.setFont(new Font("Arial", Font.PLAIN, 18));
        yellowDice_LB.setSize(50, 50);
        yellowDice_LB.setLocation(340, 150);
        yellowDice_LB.setBorder(new BevelBorder(BevelBorder.RAISED, Color.yellow, Color.yellow));
        c.add(yellowDice_LB);

        // creates a label for the name of the first white dice
        greenDice_LB = new JLabel("0", SwingConstants.CENTER);
        greenDice_LB.setFont(new Font("Arial", Font.PLAIN, 18));
        greenDice_LB.setSize(50, 50);
        greenDice_LB.setLocation(420, 150);
        greenDice_LB.setBorder(new BevelBorder(BevelBorder.RAISED, Color.green, Color.green));
        c.add(greenDice_LB);

        // creates a label for the name of the first white dice
        blueDice_LB = new JLabel("0", SwingConstants.CENTER);
        blueDice_LB.setFont(new Font("Arial", Font.PLAIN, 18));
        blueDice_LB.setSize(50, 50);
        blueDice_LB.setLocation(500, 150);
        blueDice_LB.setBorder(new BevelBorder(BevelBorder.RAISED, Color.blue, Color.blue));
        c.add(blueDice_LB);
        
        // creates a button for starting and then initializing the addPlayer panel
        roll_Bt = new JButton("Roll the Dices");
        roll_Bt.setFont(new Font("Arial", Font.PLAIN, 18));
        roll_Bt.setSize(300, 40);
        roll_Bt.setLocation(200, 260);
        roll_Bt.setFocusable(false);
        roll_Bt.addActionListener(this);
        c.add(roll_Bt);

        // creates a button for closing the program 
        exit_Bt = new JButton("EXIT");
        exit_Bt.setFont(new Font("Arial", Font.PLAIN, 18));
        exit_Bt.setSize(120, 30);
        exit_Bt.setLocation(200, 320);
        exit_Bt.setFocusable(false);
        exit_Bt.addActionListener(this);
        c.add(exit_Bt);

        continue_Bt = new JButton("Continue");
        continue_Bt.setFont(new Font("Arial", Font.PLAIN, 18));
        continue_Bt.setSize(120, 30);
        continue_Bt.setLocation(380, 320);
        continue_Bt.setFocusable(false);
        continue_Bt.addActionListener(this);
        continue_Bt.setEnabled(false);
        c.add(continue_Bt);

        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == roll_Bt) {
            Connector cnn = new Connector();
            cnn.saveDiceData(cnn.getDiceRollingResult());
            String wuerfel = cnn.getLastDiceData();
            String[] result = wuerfel.split(",");
            whiteDice1_LB.setText(result[0]);
            whiteDice2_LB.setText(result[1]);
            redDice_LB.setText(result[2]);
            yellowDice_LB.setText(result[3]);
            greenDice_LB.setText(result[4]);
            blueDice_LB.setText(result[5]);
            roll_Bt.setEnabled(false);
            continue_Bt.setEnabled(true);
        } 


        if (e.getSource() == continue_Bt) {
            dispose();
            new ActivePlayer(process);
        }

        else if(e.getSource() == exit_Bt){
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
