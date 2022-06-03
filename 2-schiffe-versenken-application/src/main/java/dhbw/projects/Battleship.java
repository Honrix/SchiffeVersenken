package dhbw.projects;

import dhbw.projects.user.User;
import dhbw.projects.user.UserState;

import java.util.ArrayList;
import java.util.List;

public class Battleship {

    private final List<User> users = new ArrayList<>();
    private StateOfSession stateOfSession;

    public Battleship(){
        this.stateOfSession = StateOfSession.WAITING;
    }

    public void enterUser(User user){
        if(stateOfSession != StateOfSession.WAITING){

        } else {
            this.users.add(user);
        }
    }

    public boolean checkGuessedField(User user, String input) {
        for (String field: user.getCorrectFields()) {
            if(field.equals(input)){
                return true;
            }
        }
        return false;
    }

    public void updateUserState() {
        for (User user: users) {
            if(user.getUserState() == UserState.ON_ACTION){
                user.setUserState(UserState.ON_WAITING);
            } else {
                user.setUserState(UserState.ON_ACTION);
            }
        }
    }
}
