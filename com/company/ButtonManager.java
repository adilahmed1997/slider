package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonManager implements ActionListener {

    JPanel jPanel;
    JFrame jFrame;
    GUI gui;

    public ButtonManager(JPanel jPanel, JFrame jFrame, GUI gui) {

        this.jFrame = jFrame;
        this.jPanel = jPanel;
        this.gui = gui;
    }


    public void actionPerformed(ActionEvent e) {

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                if (e.getSource() != null) {
                    if (e.getSource() == gui.getButtons()[x][y]) {
                        if (x != 2 && gui.getButtons()[x + 1][y].getName().equals("bart0")) {
                            moveTile(x, y, x + 1, y);
                        } else if (x != 0 && gui.getButtons()[x - 1][y].getName().equals("bart0")) {
                            moveTile(x, y, x - 1, y);
                        } else if (y != 3 && gui.getButtons()[x][y + 1].getName().equals("bart0")) {
                            moveTile(x, y, x, y + 1);
                        } else if (y != 0 && gui.getButtons()[x][y - 1].getName().equals("bart0")) {
                            moveTile(x, y, x, y - 1);
                        }
                    }
                }
            }
        }
    }


    private void moveTile(int x, int y, int newX, int newY) {
        System.out.println("x: " + x + " y: " + y);
        JButton currentButton = gui.getButtons()[x][y];

        if (currentButton != null) {
            JButton newButton = gui.getButtons()[newX][newY];
            if (newButton != null) {
                if (newButton.getName().equals("bart0")) {
                    newButton.setIcon(currentButton.getIcon());
                    newButton.setName("bartname");
                    currentButton.setIcon(new ImageIcon("src/com/bart0.jpg"));
                    currentButton.setName("bart0");
                }
            }
        }
    }

    public void createButtons(ArrayList<ImageIcon> icons, JButton[][] buttons) {

        int i = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                icons.add(new ImageIcon("src/com/bart" + i + ".jpg"));
                buttons[x][y] = new JButton(icons.get(i));
                buttons[x][y].setName("bart" + i);
                buttons[x][y].addActionListener(this);
                jPanel.add(buttons[x][y]);


                i++;
            }

        }
        jFrame.pack();
    }
}
