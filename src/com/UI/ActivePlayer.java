package com.UI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.logics.Connector;
import com.logics.GameProcess;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ActivePlayer extends JFrame implements ActionListener {
    private Container c;
    private JLabel pName_Lb;
    private JLabel wDice1_Lb;
    private JLabel wDice2_Lb;
    private JLabel rDice_Lb;
    private JLabel yDice_Lb;
    private JLabel gDice_Lb;
    private JLabel bDice_Lb;
    private JLabel wCross_Lb;
    private JLabel cCross_Lb;
    private JLabel wNumber_Lb;
    private JLabel wSumNumber_Lb;
    private JLabel cNumber_Lb;
    private JLabel penalty_Lb;
    private  JLabel playercard_Lb;
    private JRadioButton wNothing_Rbt;
    private JRadioButton wRed_Rbt;
    private JRadioButton wYellow_Rbt;
    private JRadioButton wGreen_Rbt;
    private JRadioButton wBlue_Rbt;
    private ButtonGroup wRadio_Bg;
    private JRadioButton cNothing_Rbt;
    private JRadioButton cRed_Rbt;
    private JRadioButton cYellow_Rbt;
    private JRadioButton cGreen_Rbt;
    private JRadioButton cBlue_Rbt;
    private ButtonGroup cRadio_Bg;
    private JTextField cNumber_Tf;
    private JTextArea warning_Ta;
    private JButton continue_Bt;
    private GameProcess process;
    private String activePlayer;
    private int addierteZahl;


    public ActivePlayer(GameProcess process) {
        Connector cnn = new Connector();
        this.process = process;
        this.activePlayer = process.getActivePlayer();
        setTitle("Active Player");
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

                cNumber_Tf.setEnabled(false);
                cNumber_Lb.setEnabled(false);

                if (redRow){
                    wRed_Rbt.setEnabled(false);
                    cRed_Rbt.setEnabled(false);
                }
                if (yellowRow){
                    wYellow_Rbt.setEnabled(false);
                    cYellow_Rbt.setEnabled(false);
                }
                if (greenRow){
                    wGreen_Rbt.setEnabled(false);
                    cGreen_Rbt.setEnabled(false);
                }
                if (blueRow){
                    wBlue_Rbt.setEnabled(false);
                    cBlue_Rbt.setEnabled(false);
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

        String wuerfel = cnn.getLastDiceData();
        String[] result = wuerfel.split(",");

        // create the first white dice label
        wDice1_Lb = new JLabel(result[0]);
        wDice1_Lb.setOpaque(true);
        wDice1_Lb.setBackground(Color.white);
        wDice1_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        wDice1_Lb.setBounds(185, 20, 50, 50);
        wDice1_Lb.setForeground(Color.BLACK);
        wDice1_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(wDice1_Lb);

        wDice2_Lb = new JLabel(result[1]);
        wDice2_Lb.setOpaque(true);
        wDice2_Lb.setBackground(Color.white);
        wDice2_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        wDice2_Lb.setBounds(250, 20, 50, 50);
        wDice2_Lb.setForeground(Color.BLACK);
        wDice2_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(wDice2_Lb);

        rDice_Lb = new JLabel(result[2]);
        rDice_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        rDice_Lb.setBounds(315, 20, 50, 50);
        rDice_Lb.setOpaque(true);
        rDice_Lb.setBackground(Color.RED);
        rDice_Lb.setForeground(Color.BLACK);
        rDice_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(rDice_Lb);

        yDice_Lb = new JLabel(result[3]);
        yDice_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        yDice_Lb.setBounds(380, 20, 50, 50);
        yDice_Lb.setOpaque(true);
        yDice_Lb.setBackground(Color.YELLOW);
        yDice_Lb.setForeground(Color.BLACK);
        yDice_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(yDice_Lb);

        gDice_Lb = new JLabel(result[4]);
        gDice_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        gDice_Lb.setBounds(445, 20, 50, 50);
        gDice_Lb.setOpaque(true);
        gDice_Lb.setBackground(new Color(0,128,0));
        gDice_Lb.setForeground(Color.black);
        gDice_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(gDice_Lb);

        bDice_Lb = new JLabel(result[5]);
        bDice_Lb.setFont(new Font("Arial", Font.BOLD, 18));
        bDice_Lb.setBounds(510, 20, 50, 50);
        bDice_Lb.setOpaque(true);
        bDice_Lb.setBackground(Color.BLUE);
        bDice_Lb.setForeground(Color.BLACK);
        bDice_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(bDice_Lb);


        penalty_Lb = new JLabel("Penalties: " + cnn.getPenaltyNumbers(activePlayer));
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

        int zahl1 = Integer.parseInt(result[0]);
        int zahl2 = Integer.parseInt(result[1]);
        addierteZahl = zahl1+zahl2;
        wSumNumber_Lb = new JLabel("" + addierteZahl);
        wSumNumber_Lb.setFont(new Font("Arial", Font.BOLD, 14));
        wSumNumber_Lb.setBounds(715, 220, 50, 25);
        wSumNumber_Lb.setOpaque(true);
        wSumNumber_Lb.setBackground(new Color(30, 70, 125));
        wSumNumber_Lb.setForeground(Color.WHITE);
        wSumNumber_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(wSumNumber_Lb);

        playercard_Lb = new JLabel(cnn.get_Player_Card_UI(activePlayer));
        playercard_Lb.setFont(new Font("Arial",Font.BOLD,18));
        playercard_Lb.setBounds(20,80,410,350);
        playercard_Lb.setOpaque(true);
        playercard_Lb.setBackground(new Color(211,211,211));
        playercard_Lb.setForeground(Color.BLACK);
        playercard_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(playercard_Lb);

        cCross_Lb = new JLabel("Cross with the help of the colored dice:");
        cCross_Lb.setFont(new Font("Arial", Font.BOLD, 16));
        cCross_Lb.setBounds(450, 250, 315, 40);
        cCross_Lb.setOpaque(true);
        cCross_Lb.setBackground(new Color(30, 70, 125));
        cCross_Lb.setForeground(Color.WHITE);
        cCross_Lb.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(cCross_Lb);

        cNothing_Rbt = new JRadioButton("Nothing");
        cNothing_Rbt.setFont(new Font("Arial", Font.PLAIN, 14));
        cNothing_Rbt.setSelected(true);
        cNothing_Rbt.setBounds(450, 290, 75, 25);
        cNothing_Rbt.setBackground(Color.lightGray);
        cNothing_Rbt.addActionListener(this);
        c.add(cNothing_Rbt);

        cRed_Rbt = new JRadioButton("Red");
        cRed_Rbt.setFont(new Font("Arial", Font.PLAIN, 14));
        cRed_Rbt.setSelected(false);
        cRed_Rbt.setBounds(450, 315, 75, 25);
        cRed_Rbt.setBackground(Color.lightGray);
        cRed_Rbt.addActionListener(this);
        c.add(cRed_Rbt);

        cYellow_Rbt = new JRadioButton("Yellow");
        cYellow_Rbt.setFont(new Font("Arial", Font.PLAIN, 14));
        cYellow_Rbt.setSelected(false);
        cYellow_Rbt.setBounds(450, 340, 75, 25);
        cYellow_Rbt.setBackground(Color.lightGray);
        cYellow_Rbt.addActionListener(this);
        c.add(cYellow_Rbt);

        cGreen_Rbt = new JRadioButton("Green");
        cGreen_Rbt.setFont(new Font("Arial", Font.PLAIN, 14));
        cGreen_Rbt.setSelected(false);
        cGreen_Rbt.setBounds(450, 365, 75, 25);
        cGreen_Rbt.setBackground(Color.lightGray);
        cGreen_Rbt.addActionListener(this);
        c.add(cGreen_Rbt);

        cBlue_Rbt = new JRadioButton("Blue");
        cBlue_Rbt.setFont(new Font("Arial", Font.PLAIN, 14));
        cBlue_Rbt.setSelected(false);
        cBlue_Rbt.setBounds(450, 390, 75, 25);
        cBlue_Rbt.setBackground(Color.lightGray);
        cBlue_Rbt.addActionListener(this);
        c.add(cBlue_Rbt);

        cRadio_Bg = new ButtonGroup();
        cRadio_Bg.add(cNothing_Rbt);
        cRadio_Bg.add(cRed_Rbt);
        cRadio_Bg.add(cYellow_Rbt);
        cRadio_Bg.add(cGreen_Rbt);
        cRadio_Bg.add(cBlue_Rbt);

        cNumber_Lb = new JLabel("Number:");
        cNumber_Lb.setFont(new Font("Arial", Font.PLAIN, 14));
        cNumber_Lb.setBounds(655, 390, 60, 25);
        cNumber_Lb.setForeground(Color.BLACK);
        cNumber_Lb.revalidate();
        c.add(cNumber_Lb);

        cNumber_Tf = new JTextField("");
        cNumber_Tf.setFont(new Font("Arial", Font.BOLD, 14));
        cNumber_Tf.setBounds(715, 390, 50, 25);
        cNumber_Tf.setForeground(new Color(30, 70, 125));
        cNumber_Tf.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(cNumber_Tf);

        warning_Ta = new JTextArea();
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
        continue_Bt.setFocusable(false);
        continue_Bt.addActionListener(this);
        c.add(continue_Bt);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if((e.getSource() == cNothing_Rbt)  ){
            cNumber_Tf.setEnabled(false);
            cNumber_Lb.setEnabled(false);
        } else {
            cNumber_Tf.setEnabled(true);
            cNumber_Lb.setEnabled(true);
        }


        if(e.getSource() == continue_Bt) {
            boolean end = true;
            Connector cnn = new Connector();
            if (wNothing_Rbt.isSelected() && cNothing_Rbt.isSelected()) {
                //Do Penalty for this Player
                cnn.addPenaltie(activePlayer);
            }
            if (wRed_Rbt.isSelected()) {
                if (cnn.checkNumberCross(activePlayer, "red", "" + addierteZahl)) {
                    cnn.crossANumber(activePlayer, "red", "" + addierteZahl);
                } else{
                    warning_Ta.setText("Zahl kann nicht gestrichen werden!");
                    end = false;
                }
            }
            if (wYellow_Rbt.isSelected()) {
                if (cnn.checkNumberCross(activePlayer, "yel", "" + addierteZahl)) {
                    cnn.crossANumber(activePlayer, "yel", "" + addierteZahl);
                } else {
                    warning_Ta.setText("Zahl kann nicht gestrichen werden!");
                    end = false;
                }
            }
            if (wGreen_Rbt.isSelected()) {
                if (cnn.checkNumberCross(activePlayer, "gre", "" + addierteZahl)){
                    cnn.crossANumber(activePlayer, "gre", "" + addierteZahl);
                } else {
                    warning_Ta.setText("Zahl kann nicht gestrichen werden!");
                    end = false;
                }
            }
            if (wBlue_Rbt.isSelected()) {
                if (cnn.checkNumberCross(activePlayer, "blu", "" + addierteZahl)){
                    cnn.crossANumber(activePlayer, "blu", "" + addierteZahl);
                } else {
                    warning_Ta.setText("Zahl kann nicht gestrichen werden!");
                    end = false;
                }
            }

            if (cRed_Rbt.isSelected()) {
                if (cnn.checkColoredNumberCross("red", cNumber_Tf.getText()) && cnn.checkNumberCross(activePlayer, "red", cNumber_Tf.getText())){
                    cnn.crossANumber(activePlayer, "red", "" + cNumber_Tf.getText());
                } else {
                    warning_Ta.setText("Eingegebene Zahl überprüfen!");
                    end = false;
                }
            }

            if (cYellow_Rbt.isSelected()) {
                if (cnn.checkColoredNumberCross("yel", cNumber_Tf.getText()) && cnn.checkNumberCross(activePlayer, "yel", cNumber_Tf.getText())){
                    cnn.crossANumber(activePlayer, "yel", "" + cNumber_Tf.getText());
                } else {
                    warning_Ta.setText("Eingegebene Zahl überprüfen!");
                    end = false;
                }
            }
            if (cGreen_Rbt.isSelected()) {
                if (cnn.checkColoredNumberCross("gre", cNumber_Tf.getText()) && cnn.checkNumberCross(activePlayer, "gre", cNumber_Tf.getText())){
                    cnn.crossANumber(activePlayer, "gre", "" + cNumber_Tf.getText());
                } else {
                    warning_Ta.setText("Eingegebene Zahl überprüfen!");
                    end = false;
                }
            }
            if (cBlue_Rbt.isSelected()) {
                if (cnn.checkColoredNumberCross("blu", cNumber_Tf.getText()) && cnn.checkNumberCross(activePlayer, "blu", cNumber_Tf.getText())){
                    cnn.crossANumber(activePlayer, "blu", "" + cNumber_Tf.getText());
                } else {
                    warning_Ta.setText("Eingegebene Zahl überprüfen!");
                    end = false;
                }
            }

            if (end == true){
                ArrayList<String> passivePlayer = process.getPassivePlayer();
                dispose();
                //Iterate through PassivePlayers
                PassivePlayer[] windows = new PassivePlayer[passivePlayer.size()];
                for (int i = 0; i < windows.length; i++) {
                    windows[i] = new PassivePlayer(passivePlayer.get(i), process);
                }
            }
        }
    }
}
