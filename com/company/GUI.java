package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GUI {
    private JFrame jFrame;
    private ArrayList<ImageIcon> icons = new ArrayList<>();
    private JButton[][] buttons = new JButton[3][4];
    private JPanel jPanel;
    private Integer points;
    private ArrayList<String> highScores;
    private String name;
    private ButtonManager buttonManager;
    private NameRetriever nameRetriever;

    public GUI() throws IOException {
        create();

        String line = new String();

        highScores =  new ArrayList<String>();

        FileReader fileReader = new FileReader("src/com/scores.txt");


        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            highScores.add(line);
        }



        bufferedReader.close();

    }


    public JButton[][] getButtons() {
        return buttons;
    }


    public void incrementPoints(){
        points++;
    }

    private void create() {
        jFrame = new JFrame(); // Create jFrame blank window
        jPanel = new JPanel();
        jFrame.setVisible(true);
        jFrame.setTitle("Slider puzzle game");
        jFrame.setSize(250, 300);
        jFrame.setResizable(false);
        jPanel.setLayout(new GridLayout(3, 4));
        jFrame.add(jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        points=0;
        ButtonManager buttonManager = new ButtonManager(jPanel, jFrame, this);

        buttonManager.createButtons(icons, buttons);

    }

    public void getScoreName(){
        nameRetriever = new NameRetriever();
    }
    public void displayHighscore(){

    }


}
