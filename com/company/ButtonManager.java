package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ButtonManager implements ActionListener {

    JPanel jPanel;
    JFrame jFrame;
    GUI gui;
    String currentGrid[][];
    String completeGrid[][];

    public ButtonManager(JPanel jPanel, JFrame jFrame, GUI gui) {

        this.jFrame = jFrame;
        this.jPanel = jPanel;
        this.gui = gui;
        currentGrid = new String[3][4];
        completeGrid = new String[3][4];

    }


    public void actionPerformed(ActionEvent e) {

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                if (e.getSource() != null) {
                    if (e.getSource() == gui.getButtons()[x][y]) {
                        if (x != 2 && gui.getButtons()[x + 1][y].getName().equals("bart0")) {
                            moveTile(x, y, x + 1, y, true);
                        } else if (x != 0 && gui.getButtons()[x - 1][y].getName().equals("bart0")) {
                            moveTile(x, y, x - 1, y, true);
                        } else if (y != 3 && gui.getButtons()[x][y + 1].getName().equals("bart0")) {
                            moveTile(x, y, x, y + 1, true);
                        } else if (y != 0 && gui.getButtons()[x][y - 1].getName().equals("bart0")) {
                            moveTile(x, y, x, y - 1, true);
                        }
                    }
                }
            }
        }

    }


    private void moveTile(int x, int y, int newX, int newY, boolean bool) {
        System.out.println("moving " + x + ", " + y + "to " + newX + ", " + newY);
        JButton currentButton = gui.getButtons()[x][y];

        if ((x != 2 && newX == x + 1) || (x != 0 && newX == x - 1) || (y != 3 && newY == y + 1) || (y != 0 && newY == y - 1)) {
            if (currentButton != null) {
                JButton newButton = gui.getButtons()[newX][newY];
                if (newButton != null) {
                    if (bool == true) {
                        if (newButton.getName().equals("bart0")) {
                            newButton.setIcon(currentButton.getIcon());
                            String temp = new String(currentGrid[x][y]);
                            currentGrid[x][y] = currentGrid[newX][newY];
                            currentGrid[newX][newY] = temp;
                            newButton.setName(currentGrid[newX][newY]);
                            currentButton.setIcon(new ImageIcon("src/com/bart0.jpg"));
                            currentButton.setName(currentGrid[x][y]);
                        }
                    } else {
                        Icon tempIcon = newButton.getIcon();
                        newButton.setIcon(currentButton.getIcon());

                        String temp = new String(currentGrid[x][y]);
                        currentGrid[x][y] = currentGrid[newX][newY];
                        currentGrid[newX][newY] = temp;
                        newButton.setName(currentGrid[newX][newY]);
                        currentButton.setIcon(tempIcon);
                        currentButton.setName(currentGrid[x][y]);
                    }
                }
            }
        }
        int i = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 4; k++) {
                if (currentGrid[j][k].equals(completeGrid[j][k])) {
                    i++;
                }

            }

        }
        System.out.println(i);
        if(i==12) {
            System.out.println("finished");
        }
    }

    public void createButtons(ArrayList<ImageIcon> icons, JButton[][] buttons) {

        int i = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                icons.add(new ImageIcon("src/com/bart" + i + ".jpg"));
                buttons[x][y] = new JButton(icons.get(i));
                buttons[x][y].setName("bart" + i);
                currentGrid[x][y] = "bart" + i;
                completeGrid[x][y] = currentGrid[x][y];
                buttons[x][y].addActionListener(this);
                jPanel.add(buttons[x][y]);


                i++;
            }

        }
        randomize(buttons);
        jFrame.pack();
    }

    public void randomize(JButton[][] buttons){
        System.out.println("randomizing");
        Random rand = new Random();
        for (int i=0; i<15;i++) {
            int n = rand.nextInt(4) + 1;
            switch(n) {
                case 1:
                    swapGrey(1,0);
                    break;
                case 2:
                    swapGrey(-1,0);
                    break;
                case 3:
                    swapGrey(0,1);
                    break;
                case 4:
                    swapGrey(0,-1);
                    break;
            }
        }

    }

    private void swapGrey(int xDir, int yDir){
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 4; y++) {
                if(gui.getButtons()[x][y].getName().equals("bart0")){
                    System.out.println("swapp");
                    moveTile(x,y,x+xDir,y+yDir, false);

                }

            }
        }

    }
}
