package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {
    private JFrame jFrame;
    private ArrayList<ImageIcon> icons = new ArrayList<>();
    private JButton[][] buttons = new JButton[3][4];
    private JPanel jPanel;

    private ButtonManager buttonManager;

    public GUI() {
        create();

    }

    public ArrayList<ImageIcon> getIcons() {
        return icons;
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    private void create() {
        jFrame = new JFrame(); // Create jFrame blank window
        jPanel = new JPanel();
        jFrame.setVisible(true);
        jFrame.setTitle("Slider puzzle game");
        jFrame.setSize(320, 475);
        jPanel.setLayout(new GridLayout(3, 4));
        jFrame.add(jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonManager buttonManager = new ButtonManager(jPanel, jFrame, this);

        buttonManager.createButtons(icons, buttons);

    }


}
