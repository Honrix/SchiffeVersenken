package dhbw.projects.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserTest {

    @Test
    void validateGetters(){
        UserId userId = mock(UserId.class);
        UserState userState = UserState.ON_ACTION;
        String[] list = {"Test1", "Test2"};
        User user = new User(userId, "Test", userState, list);
        assertEquals("Test", user.getUserName());
        assertEquals(UserState.ON_ACTION, user.getUserState());
        assertEquals(user.getFieldsOfShips(), list);
        assertEquals(user.getCorrectGuesses(), 0);

        user.setCorrectGuesses(14);
        assertEquals(user.getCorrectGuesses(), 14);
        user.setUserState(UserState.ON_WAITING);
        assertEquals(UserState.ON_WAITING, user.getUserState());
    }

    @Test
    void testEquals() {
        UserId userId = mock(UserId.class);
        UserState userState = UserState.ON_ACTION;
        String[] list = {"Test1", "Test2"};
        User user1 = new User(userId, "Test", userState, list);
        User user2 = new User(userId, "Test", userState, list);
        User user3 = new User(userId, "Test2", userState, list);

        assertTrue(user1.equals(user2));
        assertFalse(user1.equals(user3));
        assertFalse(user1.equals("Hallo"));
    }

    @Test
    void testHashCode() {
        UserId userId = mock(UserId.class);
        UserState userState = UserState.ON_ACTION;
        String[] list = {"Test1", "Test2"};
        User user1 = new User(userId, "Test", userState, list);
        User user2 = new User(userId, "Test", userState, list);

        assertEquals(user1.hashCode(), user2.hashCode());
    }
}