package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonManager implements ActionListener {

    JPanel jPanel;
    JFrame jFrame;
    GUI gui;

    public ButtonManager(JPanel jPanel, JFrame jFrame, GUI gui){

        this.jFrame = jFrame;
        this.jPanel = jPanel;
        this.gui = gui;
    }


    public void actionPerformed(ActionEvent e)
    {

        for(int x = 0; x<3; x++){
            for (int y = 0; y<4; y++) {
                if (e.getSource() == gui.getButtons()[x][y]) {
                    if (gui.getButtons()[x + 1][y] != null)
                        if (gui.getButtons()[x + 1][y].getIcon() == new ImageIcon("src/com/bart0.jpg")) {
                        gui.getButtons()[x + 1][y].setIcon(gui.getButtons()[x][y].getIcon());
                        gui.getButtons()[x][y].setIcon(new ImageIcon("src/com/bart0.jpg"));
                    }
                    else if (gui.getButtons()[x - 1][y] != null)
                        if (gui.getButtons()[x - 1][y].getIcon() == new ImageIcon("src/com/bart0.jpg")) {
                        gui.getButtons()[x - 1][y].setIcon(gui.getButtons()[x][y].getIcon());
                        gui.getButtons()[x][y].setIcon(new ImageIcon("src/com/bart0.jpg"));
                    }
                    else if (gui.getButtons()[x][y + 1] != null)
                        if (gui.getButtons()[x][y + 1].getIcon() == new ImageIcon("src/com/bart0.jpg")) {
                        gui.getButtons()[x][y + 1].setIcon(gui.getButtons()[x][y].getIcon());
                        gui.getButtons()[x][y].setIcon(new ImageIcon("src/com/bart0.jpg"));
                    }
                    else if (gui.getButtons()[x][y - 1] != null)
                        if (gui.getButtons()[x][y - 1].getIcon() == new ImageIcon("src/com/bart0.jpg")) {
                        gui.getButtons()[x][y - 1].setIcon(gui.getButtons()[x][y].getIcon());
                        gui.getButtons()[x][y].setIcon(new ImageIcon("src/com/bart0.jpg"));
                    }
                }
            }
        }
    }

    public void createButtons(ArrayList<ImageIcon> icons, JButton[][] buttons)
    {
        icons = new ArrayList<ImageIcon>();
        buttons = new JButton[3][4];

        int i=0;
        for(int x = 0; x<3; x++){
                for (int y = 0; y<4; y++){
                    icons.add(new ImageIcon("src/com/bart"+i+".jpg"));
                    buttons[x][y]= new JButton(icons.get(i));
                    buttons[x][y].setName("bart"+i);
                    buttons[x][y].addActionListener(this);
                    jPanel.add(buttons[x][y]);


                    i++;
                }

        }
        jFrame.pack();

    }

}
