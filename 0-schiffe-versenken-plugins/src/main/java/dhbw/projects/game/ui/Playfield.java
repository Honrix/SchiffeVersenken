package dhbw.projects.game.ui;

import dhbw.projects.game.Game.UserActionHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Playfield {

    private final JPanel panel = new JPanel();
    private final List<JButton> buttons = new ArrayList<>();
    private final UserActionHandler userActionHandler;

    private final Color correctColor = Color.GREEN;
    private final Color falseColor = Color.DARK_GRAY;

    public Playfield(UserActionHandler userActionHandler){
        this.userActionHandler = userActionHandler;
        panel.setLayout(new GridLayout(8, 1));
        panel.setSize(400, 400);
        for (int i = 0; i < 8; i++) {
            this.panel.add(getRow(i));
        }
    }

    private JPanel getRow(int rowNumber){
        JPanel row = new JPanel();
        row.setLayout(new GridLayout(1, 8));
        row.setSize(400, 50);
        for (int i = 0; i < 8; i++) {
            row.add(getCell(String.valueOf(rowNumber*8 + i + 1)));
        }
        return row;
    }

    private JButton getCell(String input){
        JButton jButton = new JButton();
        jButton.setSize(50, 50);
        jButton.setText(input);
        jButton.addActionListener(addActionListener(jButton, input));
        buttons.add(jButton);
        return jButton;

    }

    private ActionListener addActionListener(JButton jButton, String input){
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String output =  userActionHandler.onUserGuessedField(input);
                if(output == "False") {
                    System.out.println("Wait for the other Player to make a turn");
                } else {
                    if (jButton.getBackground() == correctColor || jButton.getBackground() == falseColor) {
                        System.out.println("Already entered that input");
                    } else {
                        if (output == "Wrong") {
                            jButton.setBackground(falseColor);
                        } else if (output == "Right") {
                            jButton.setBackground(correctColor);
                        }
                        userActionHandler.switchUserState();
                    }
                }
            }
        };
        return actionListener;
    }


    public JPanel getPanel() {
        return this.panel;
    }
}
