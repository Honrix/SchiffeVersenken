package dhbw.projects.game.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class UserHandler implements Runnable{

    private final Socket user;
    private final String userName;
    private BufferedReader input;

    public UserHandler(Socket user, String userName) throws IOException {
        this.user = user;
        this.userName = userName;
        this.input = new BufferedReader((new InputStreamReader(user.getInputStream())));
    }

    @Override
    public void run() {
        try {
            while(true){
                String action = input.readLine();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
