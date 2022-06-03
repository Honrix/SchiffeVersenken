package dhbw.projects.user;

public enum UserState {

    ON_ACTION ("User is on Action"),
    ON_WAITING ("User has to wait for other User to make a turn");

    private final String description;

    UserState(String string) {
        this.description = string;
    }


}
