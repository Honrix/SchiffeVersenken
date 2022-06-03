package dhbw.projects.user;

import dhbw.projects.Battleship;

public class UserInputAdapter {

    private final Battleship battleship;

    public UserInputAdapter(Battleship battleship) {
        this.battleship = battleship;
    }

    public String getCorrectField(User user, String input){
        if(enterUserGuess(user, input)){
            return "Right";
        } else {
            System.out.println(enterUserGuess(user, input));
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
