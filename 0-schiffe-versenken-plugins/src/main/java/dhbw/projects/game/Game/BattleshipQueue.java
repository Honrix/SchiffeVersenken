package dhbw.projects.game.Game;

import dhbw.projects.Battleship;
import dhbw.projects.GameSession;
import dhbw.projects.user.UserState;
import dhbw.projects.game.Server.UserHandler;
import dhbw.projects.user.User;
import dhbw.projects.user.UserId;

import java.util.*;

public class BattleshipQueue {

    private final Queue<UserHandler> gameQueue = new LinkedList<>();
    private final Map<UserHandler, Battleship> userGameMap = new HashMap<>();

    public BattleshipQueue(){

    }

    public void userConnected(UserHandler userHandler){
        System.out.println("User joined the game!");
        gameQueue.add(userHandler);
        System.out.println("Waiting Players: " + gameQueue.size());
        if(gameQueue.size() >= GameSession.MAX_PLAYERS){
            System.out.println("Game started");
            startGame();
        }

    }

    private void startGame(){
        Map<UserHandler, User> users = new HashMap<>();
        Battleship battleship = new Battleship();

        String[] ships1 = {"1", "2", "15", "23", "31", "39", "52", "53", "54", "55", "56", "50", "33", "34", "35"};
        String[] ships2 = {"9", "10", "11", "12", "13", "18", "38", "39", "40", "8", "16", "24", "32", "34", "35"};

        registerUserToGame(battleship, users, "User" + 1, UserState.ON_ACTION, ships1);
        registerUserToGame(battleship, users, "User" + 2, UserState.ON_WAITING, ships2);

    }

    private void registerUserToGame(Battleship battleship, Map<UserHandler, User> users, String userName, UserState userState, String[] ships){
        UserHandler userHandler = gameQueue.remove();
        UserId userId = new UserId(UUID.randomUUID());
        User user = new User(userId, userName, userState, ships);
        battleship.enterUser(user);
        users.put(userHandler, user);
        UserActionHandler userActionHandler = new UserActionHandler(user, userHandler, battleship);
        System.out.println("Game was found and initialized");



    }

}
