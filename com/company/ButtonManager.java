package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ButtonManager implements ActionListener {

    JPanel jPanel;
    JFrame jFrame;

    public ButtonManager(JPanel jPanel, JFrame jFrame){

        this.jFrame = jFrame;
        this.jPanel = jPanel;
    }


    public void actionPerformed(ActionEvent e)
    {
      //  if(e = ActionEvent.)

    }

    public void createButtons(ArrayList<ImageIcon> icons, ArrayList<JButton> buttons)
    {
        icons = new ArrayList<ImageIcon>();
        buttons = new ArrayList<JButton>();

        int i=0;
        for(int x = 0; x<3; x++){
            for (int y = 0; y<4; y++){
                icons.add(new ImageIcon("src/com/bart"+i+".jpg"));
                buttons.add(new JButton(icons.get(i)));


                jPanel.add(buttons.get(i));
                System.out.println(buttons.get(i).getText());

                i++;
            }

        }
        jFrame.pack();

    }

}
