package dhbw.projects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameSessionTest {

    @Test
    void getStateOfSession() {
        GameSession gameSession = new GameSession();
        assertEquals(StateOfSession.WAITING, gameSession.getStateOfSession());

    }
}