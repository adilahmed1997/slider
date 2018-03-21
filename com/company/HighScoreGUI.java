package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HighScoreGUI {
    GUI gui;
    ArrayList<String> highscores;
    JFrame jFrame;
    JPanel jPanel;

    public HighScoreGUI(GUI gui){
        this.gui = gui;

        jFrame = new JFrame(); // Create jFrame blank window
        jPanel = new JPanel();
        jFrame.setVisible(true);
        jFrame.setTitle("highscores");
        jFrame.setSize(250, 300);
        jFrame.setResizable(false);
        jPanel.setLayout(new GridLayout(5, 1));
        jFrame.add(jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        highscores = this.gui.getHighScores();

        for (String h:highscores){
        JLabel jLabel = new JLabel();
        jLabel.setText(h);
        jPanel.add(jLabel);
        }
        jFrame.pack();

    }
}
