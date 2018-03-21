package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;
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

        highScores = new ArrayList<String>();

        FileReader fileReader = new FileReader("src/com/scores.txt");


        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            highScores.add(line);
        }


        bufferedReader.close();

    }

    public JFrame getJframe() {
        return jFrame;
    }


    public NameRetriever getNameRetriever() {
        return nameRetriever;
    }

    public void setNameRetriever() {
        nameRetriever = new NameRetriever(this);
    }

    public JButton[][] getButtons() {
        return buttons;
    }


    public void incrementPoints() {
        points++;
    }

    public int getPoints(){
        return points;
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

        points = 0;
        ButtonManager buttonManager = new ButtonManager(jPanel, jFrame, this);

        buttonManager.createButtons(icons, buttons);

    }

    public ArrayList<String> getHighScores() {
        return highScores;
    }

    public void setScoreName(String name) {
        this.name = name;
        try {
            evaluateHighscore();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayHighscore() {

    }

    public void setHighscore(){
        HighScoreGUI highScoreGUI = new HighScoreGUI(this);
    }
    public void evaluateHighscore() throws IOException {
        System.out.println("evaluating highscore");
        File myFile = new File("src/com/scores.txt");
        FileWriter fileWriter = new FileWriter(myFile, false); // true to append

        if (shouldOverWrite()) {

        }
        for (String s : highScores) {
            String score = s.split(" ")[1];

            System.out.println(name + points);
            if (points > Integer.parseInt(score)) {
                highScores.remove(s);
                s = name + " " + points;
                highScores.add(s);
                System.out.println("writigng: " + s);
                break;

            }
        }

        for (String x : highScores) {
            System.out.println(x);
            fileWriter.write(x + System.lineSeparator());


        }

        fileWriter.close();
    }

    public void setPoints(int i){
        points = i;
    }
    private boolean shouldOverWrite() {
        for (String s : highScores) {
            String score = s.split(" ")[1];

            System.out.println(name + points);
            if (points > Integer.parseInt(score)) {
                return true;
            }
        }
        return false;
    }


}
