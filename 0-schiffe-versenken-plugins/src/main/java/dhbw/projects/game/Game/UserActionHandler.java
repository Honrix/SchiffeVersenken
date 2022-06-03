package dhbw.projects.game.Game;

import dhbw.projects.Battleship;
import dhbw.projects.user.UserState;
import dhbw.projects.game.Server.UserHandler;
import dhbw.projects.game.ui.Window;
import dhbw.projects.user.User;
import dhbw.projects.user.UserInputAdapter;

public class UserActionHandler {

    private final UserHandler userHandler;
    private final User user;
    private final UserInputAdapter userInputAdapter;

    public UserActionHandler(User user, UserHandler userHandler, Battleship battleship) {
        this.userHandler = userHandler;
        this.userInputAdapter = new UserInputAdapter(battleship);
        this.user = user;
        Window window = new Window(user.getUserName(), this);
    }

    public void switchUserState(){
        this.userInputAdapter.updateUserState();
    }

    public void log(String input) {
        System.out.println("[" + user.getUserName() + "] " + input);
    }

    public String onUserGuessedField(String input){
        if(user.getUserState() == UserState.ON_ACTION){
            return this.userInputAdapter.getCorrectField(user, input);
        } else {
            return "False";
        }
    }

}
