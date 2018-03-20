package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {
    JFrame jFrame;
    ArrayList<ImageIcon> icons;
    ArrayList<JButton> buttons;
    JPanel jPanel;

    ButtonManager buttonManager;

    public GUI()
    {
    create();

    }

    private void create()
    {
        jFrame = new JFrame(); // Create jFrame blank window
        jPanel = new JPanel();
        jFrame.setVisible(true);
        jFrame.setTitle("Slider puzzle game");
        jFrame.setSize(320,475);
        jPanel.setLayout(new GridLayout(3,4));
        jFrame.add(jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ButtonManager buttonManager = new ButtonManager(jPanel, jFrame);

        buttonManager.createButtons(icons, buttons);

    }


}
