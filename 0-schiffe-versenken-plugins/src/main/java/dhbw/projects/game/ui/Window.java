package dhbw.projects.game.ui;

import dhbw.projects.game.Game.UserActionHandler;
import javax.swing.*;
import java.awt.*;

public class Window {

    private final JButton findGameButton = new JButton("Find A Match");
    private final JFrame window;
    private final UserActionHandler userActionHandler;

    public Window(String userName, UserActionHandler userActionHandler) {
        this.userActionHandler = userActionHandler;
        window = new JFrame("Schiffe-Versenken: " + userName);
        window.setSize(1080, 720);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        Playfield playfield = new Playfield(this.userActionHandler);
        final JPanel west = new JPanel(new GridLayout(5, 1));
        window.setResizable(false);
        window.setVisible(true);
        window.add(playfield.getPanel(), BorderLayout.CENTER);

    }


}
