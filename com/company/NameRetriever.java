package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameRetriever implements ActionListener {
    JFrame getNameFrame;
    JPanel nameJpanel;
    JButton submitButton;
    GUI gui;
    JTextField jTextField;

    public NameRetriever(GUI gui) {
        getNameFrame = new JFrame();

        this.gui = gui;
        getNameFrame.setTitle("Enter your name: ");
        jTextField = new JTextField(2);
        getNameFrame.setVisible(true);
        submitButton = new JButton("submit");

        nameJpanel = new JPanel();
        nameJpanel.setLayout(new GridLayout(2, 1));

        getNameFrame.setSize(250, 300);
        getNameFrame.setResizable(false);

        getNameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameJpanel.add(jTextField);
        nameJpanel.add(submitButton);
        getNameFrame.add(nameJpanel);
        getNameFrame.pack();

        submitButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            System.out.println("button bein pressed");
            gui.setScoreName(jTextField.getText());
            gui.setHighscore();
            this.getNameFrame.setVisible(false);
            this.getNameFrame.dispose();

        }
    }
}
