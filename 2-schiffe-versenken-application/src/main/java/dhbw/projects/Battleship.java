package dhbw.projects;

import dhbw.projects.user.User;
import dhbw.projects.user.UserState;

import javax.swing.*;
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
        User otherUser = null;
        for (User user2: users) {
            if(!user2.equals(user)){
                otherUser = user2;   
            }
        }
        for (String field: otherUser.getFieldsOfShips()) {
            if(field.equals(input)){
                if(user.getCorrectGuesses() >= 14){
                    JOptionPane.showMessageDialog(null,
                            user.getUserName() + " hat gewonnen! Das Spiel kann trotzdem fortgesetzt werden");
                }
                user.setCorrectGuesses(user.getCorrectGuesses()+1);
                System.out.println(user.getUserName() + " hat bereits " + user.getCorrectGuesses() + " Treffer");
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
