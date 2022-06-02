package dhbw.projects.game;

import dhbw.projects.game.Server.Server;

import java.io.IOException;

public class Battleships {

    public static void main(String[] args) throws IOException {
        Server server = new Server(5000);
        server.start();

    }

}
