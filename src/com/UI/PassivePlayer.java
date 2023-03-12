package com.UI;

import javax.swing.*;

import com.logics.Connector;
import com.logics.GameProcess;

import java.awt.*;
import java.awt.event.*;

public class PassivePlayer extends JFrame implements ActionListener {
    private Container c;
    private JLabel pName_Lb;
    private JLabel wDice1_Lb;
    private JLabel wDice2_Lb;
    private JLabel rDice_Lb;
    private JLabel yDice_Lb;
    private JLabel gDice_Lb;
    private JLabel bDice_Lb;
    private JLabel wCross_Lb;
    private JLabel wNumber_Lb;
    private JLabel wSumNumber_Lb;
    private JLabel penalty_Lb;
    private JRadioButton wNothing_Rbt;
    private JRadioButton wRed_Rbt;
    private JRadioButton wYellow_Rbt;
    private JRadioButton wGreen_Rbt;
    private JRadioButton wBlue_Rbt;
    private ButtonGroup wRadio_Bg;
    private JTextArea warning_Ta;
    private JButton continue_Bt;
    private String passivePlayer;
    private GameProcess process;

    public PassivePlayer(String passivePlayer, GameProcess process) {
        this.passivePlayer = passivePlayer;
        this.process = process;
        setTitle("Passive Player");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.lightGray);

        this.addWindowListener(new WindowAdapter(){

            public void windowOpened(WindowEvent e){
                boolean redRow = new Connector().isRedRowComplete();
                boolean greenRow = new Connector().isYellowRowComplete();
                boolean yellowRow = new Connector().isGreenRowComplete();
                boolean blueRow = new Connector().isBlueRowComplete();
                if (redRow){
                    wRed_Rbt.setEnabled(false);
                }
                if (yellowRow){
                    wYellow_Rbt.setEnabled(false);
                }
                if (greenRow){
                    wGreen_Rbt.setEnabled(false);
                }
                if (blueRow){
                    wBlue_Rbt.setEnabled(false);
                }
            }

            public void windowClosed(WindowEvent e){
                process.addCountWindows();
                if (process.getCountWindows() == process.getPassivePlayer().size()){
                    process.resetCountWindows();
                    process.nextRound();
                    new DicePage(process);
                }
            }


        });

        // create the player name label
        pName_Lb = new JLabel("Player Name");
        pName_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        pName_Lb.setBounds(20, 20, 150, 50);
        pName_Lb.setOpaque(true);
        pName_Lb.setBackground(new Color(30, 70, 125));
        pName_Lb.setForeground(Color.white);
        pName_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(pName_Lb);

        // create the first white dice label
        wDice1_Lb = new JLabel("W1");
        wDice1_Lb.setOpaque(true);
        wDice1_Lb.setBackground(Color.white);
        wDice1_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        wDice1_Lb.setBounds(185, 20, 50, 50);
        wDice1_Lb.setForeground(Color.BLACK);
        wDice1_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(wDice1_Lb);

        wDice2_Lb = new JLabel("W2");
        wDice2_Lb.setOpaque(true);
        wDice2_Lb.setBackground(Color.white);
        wDice2_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        wDice2_Lb.setBounds(250, 20, 50, 50);
        wDice2_Lb.setForeground(Color.BLACK);
        wDice2_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(wDice2_Lb);

        rDice_Lb = new JLabel("R");
        rDice_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        rDice_Lb.setBounds(315, 20, 50, 50);
        rDice_Lb.setOpaque(true);
        rDice_Lb.setBackground(Color.RED);
        rDice_Lb.setForeground(Color.BLACK);
        rDice_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(rDice_Lb);

        yDice_Lb = new JLabel("Y");
        yDice_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        yDice_Lb.setBounds(380, 20, 50, 50);
        yDice_Lb.setOpaque(true);
        yDice_Lb.setBackground(Color.YELLOW);
        yDice_Lb.setForeground(Color.BLACK);
        yDice_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(yDice_Lb);

        gDice_Lb = new JLabel("G");
        gDice_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        gDice_Lb.setBounds(445, 20, 50, 50);
        gDice_Lb.setOpaque(true);
        gDice_Lb.setBackground(Color.green);
        gDice_Lb.setForeground(Color.black);
        gDice_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(gDice_Lb);

        bDice_Lb = new JLabel("B");
        bDice_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        bDice_Lb.setBounds(510, 20, 50, 50);
        bDice_Lb.setOpaque(true);
        bDice_Lb.setBackground(Color.BLUE);
        bDice_Lb.setForeground(Color.BLACK);
        bDice_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(bDice_Lb);

        Connector cnn = new Connector();
        penalty_Lb = new JLabel("Penalties: " + cnn.getPenaltyNumbers(passivePlayer));
        penalty_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        penalty_Lb.setBounds(575, 20, 150, 50);
        penalty_Lb.setOpaque(true);
        penalty_Lb.setBackground(Color.black);
        penalty_Lb.setForeground(Color.white);
        penalty_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(penalty_Lb);

        wCross_Lb = new JLabel("Cross with the help of the white dice:");
        wCross_Lb.setFont(new Font("Arial", Font.BOLD, 16));
        wCross_Lb.setBounds(450, 80, 315, 40);
        wCross_Lb.setOpaque(true);
        wCross_Lb.setBackground(new Color(30, 70, 125));
        wCross_Lb.setForeground(Color.WHITE);
        wCross_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(wCross_Lb);

        wNothing_Rbt = new JRadioButton("Nothing");
        wNothing_Rbt.setFont(new Font("Arial", Font.PLAIN, 14));
        wNothing_Rbt.setSelected(true);
        wNothing_Rbt.setBounds(450, 120, 75, 25);
        wNothing_Rbt.setBackground(Color.lightGray);
        c.add(wNothing_Rbt);

        wRed_Rbt = new JRadioButton("Red");
        wRed_Rbt.setFont(new Font("Arial", Font.PLAIN, 14));
        wRed_Rbt.setSelected(false);
        wRed_Rbt.setBounds(450, 145, 75, 25);
        wRed_Rbt.setBackground(Color.lightGray);
        c.add(wRed_Rbt);

        wYellow_Rbt = new JRadioButton("Yellow");
        wYellow_Rbt.setFont(new Font("Arial", Font.PLAIN, 14));
        wYellow_Rbt.setSelected(false);
        wYellow_Rbt.setBounds(450, 170, 75, 25);
        wYellow_Rbt.setBackground(Color.lightGray);
        c.add(wYellow_Rbt);

        wGreen_Rbt = new JRadioButton("Green");
        wGreen_Rbt.setFont(new Font("Arial", Font.PLAIN, 14));
        wGreen_Rbt.setSelected(false);
        wGreen_Rbt.setBounds(450, 195, 75, 25);
        wGreen_Rbt.setBackground(Color.lightGray);
        c.add(wGreen_Rbt);

        wBlue_Rbt = new JRadioButton("Blue");
        wBlue_Rbt.setFont(new Font("Arial", Font.PLAIN, 14));
        wBlue_Rbt.setSelected(false);
        wBlue_Rbt.setBounds(450, 220, 75, 25);
        wBlue_Rbt.setBackground(Color.lightGray);
        c.add(wBlue_Rbt);

        wRadio_Bg = new ButtonGroup();
        wRadio_Bg.add(wNothing_Rbt);
        wRadio_Bg.add(wRed_Rbt);
        wRadio_Bg.add(wYellow_Rbt);
        wRadio_Bg.add(wGreen_Rbt);
        wRadio_Bg.add(wBlue_Rbt);

        wNumber_Lb = new JLabel("Number:");
        wNumber_Lb.setFont(new Font("Arial", Font.PLAIN, 14));
        wNumber_Lb.setBounds(655, 220, 60, 25);
        wNumber_Lb.setForeground(Color.BLACK);
        c.add(wNumber_Lb);

        wSumNumber_Lb = new JLabel("9");
        wSumNumber_Lb.setFont(new Font("Arial", Font.BOLD, 14));
        wSumNumber_Lb.setBounds(715, 220, 50, 25);
        wSumNumber_Lb.setOpaque(true);
        wSumNumber_Lb.setBackground(new Color(30, 70, 125));
        wSumNumber_Lb.setForeground(Color.WHITE);
        wSumNumber_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(wSumNumber_Lb);

        warning_Ta = new JTextArea("Test Text");
        warning_Ta.setFont(new Font("Arial", Font.BOLD, 18));
        warning_Ta.setBounds(20, 450, 410, 100);
        warning_Ta.setLineWrap(true);
        warning_Ta.setEditable(false);
        c.add(warning_Ta);

        continue_Bt = new JButton("Continue");
        continue_Bt.setFont(new Font("Arial", Font.BOLD, 18));
        continue_Bt.setBounds(450, 450, 315, 100);
        continue_Bt.setOpaque(true);
        continue_Bt.setBackground(new Color(30, 70, 125));
        continue_Bt.setForeground(Color.white);
        continue_Bt.addActionListener(this);
        c.add(continue_Bt);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continue_Bt){
            dispose();
            }
        }
    }

