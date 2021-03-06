package dhbw.projects.user;

import dhbw.projects.Battleship;

public class UserInputAdapter {

    private final Battleship battleship;

    public UserInputAdapter(Battleship battleship) {
        this.battleship = battleship;
    }

    public String getCorrectField(User user, String input){
        boolean guess = enterUserGuess(user, input);
        if(guess){
            return "Right";
        } else {
            return "Wrong";
        }
    }

    private boolean enterUserGuess(User user, String input) {
        return this.battleship.checkGuessedField(user, input);
    }

    public void updateUserState() {
        this.battleship.updateUserState();
    }
}
