package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameRetriever implements ActionListener {
    JFrame getNameFrame;

    public NameRetriever(){
        getNameFrame = new JFrame();

        getNameFrame.setTitle("Enter your name: ");
        JTextField jTextField = new JTextField(2);


        getNameFrame.setSize(250, 300);
        getNameFrame.setResizable(false);

        getNameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getNameFrame.add(jTextField);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
