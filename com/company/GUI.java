package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {
    JFrame jFrame;
    ArrayList<ImageIcon> icons;
    ArrayList<JButton> buttons;
    JPanel jPanel;

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

        createButtons();
    }

    private void createButtons()
    {
        ArrayList<ImageIcon> icons = new ArrayList<ImageIcon>();
        ArrayList<JButton> buttons = new ArrayList<JButton>();

        int i=0;
        for(int x = 0; x<3; x++){
            for (int y = 0; y<4; y++){
                icons.add(new ImageIcon("bart"+i+".jpg"));
                buttons.add(new JButton(icons.get(i)));


                jPanel.add(buttons.get(i));
                System.out.println(buttons.get(i).getText());

                i++;
            }

        }
        jFrame.pack();

    }
}
