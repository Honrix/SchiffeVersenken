package dhbw.projects.user;

import java.util.Objects;

public class User {

    private final UserId userId;
    private final String userName;
    private int correctGuesses = 0;
    private UserState userState;
    private String[] correctFields = new String[15];

    public User(UserId userId, String userName, UserState userState, String[] ships){
        this.userId = userId;
        this.userName = userName;
        this.userState = userState;
        this.correctFields = ships;
    }

    public String[] getCorrectFields() {
        return correctFields;
    }

    public int getCorrectGuesses() {
        return correctGuesses;
    }

    public UserState getUserState() {
        return userState;
    }

    public void setCorrectGuesses(int correctGuesses) {
        this.correctGuesses = correctGuesses;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }
}
