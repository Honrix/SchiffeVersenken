package dhbw.projects.game.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final ServerSocket serverSocket;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() {
        loginNewUser();
    }

    private void loginNewUser(){
        try {
            Socket user = serverSocket.accept();
            UserHandler userHandler = new UserHandler(user);
            logOutput("New Player is connected");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void logOutput(String output){
        System.out.println("[Server] " + output);
    }

}
