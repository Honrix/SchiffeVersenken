package dhbw.projects.game.Server;

import dhbw.projects.game.Game.BattleshipQueue;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final ServerSocket serverSocket;
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    List<BattleshipQueue> battleshipQueues = new ArrayList<>();

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() {
        // Maximalwert bestimmt die Anzahl an Spielern insgesamt
        int players = Integer.parseInt(JOptionPane.showInputDialog("Zur Vereinfachung: \nWie viele Spieler sollen hinzugefügt werden? (Als Zahl)"));
        for (int i = 0; i < players; i++) {
            loginNewUser("User " + (i+1));
        }
    }

    private void loginNewUser(String userName){
        try {
            Socket user = new Socket("127.0.0.1", 5000);
            user = serverSocket.accept();
            UserHandler userHandler = new UserHandler(user, userName);
            logOutput("New Player is connected");
            insertNewUser(userHandler);
            executorService.execute(userHandler);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void insertNewUser(UserHandler userHandler) {
        battleshipQueues.forEach(battleshipQueue -> battleshipQueue.userConnected(userHandler));
    }

    private void logOutput(String output){
        System.out.println("[Server] " + output);
    }

    public void addBattleshipQueue(BattleshipQueue battleshipQueue) {
        this.battleshipQueues.add(battleshipQueue);
    }
}
