package dhbw.projects.user;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserIdTest {

    @Test
    void testEquals() {
        UUID uuid = UUID.randomUUID();
        UserId userId1 = new UserId(uuid);
        UserId userId2 = new UserId(uuid);
        UserId userId3 = new UserId(UUID.randomUUID());

        assertTrue(userId1.equals(userId2));
        assertFalse(userId1.equals(userId3));
        assertFalse(userId1.equals("Hallo"));
    }

    @Test
    void testHashCode() {
        UUID uuid = UUID.randomUUID();
        UserId userId1 = new UserId(uuid);
        UserId userId2 = new UserId(uuid);
        UserId userId3 = new UserId(UUID.randomUUID());

        assertEquals(userId1.hashCode(), userId2.hashCode());
        assertNotEquals(userId1.hashCode(), userId3.hashCode());

    }
}