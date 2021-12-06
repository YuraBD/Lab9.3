package builder;

import atm.ATM;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private ATM atm;
    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .firstName("Yura")
                .age(18)
                .occupation("UCU")
                .occupation("UCU")
                .lastName("Bodakovskyi")
                .gender("male")
                .build();
    }

    @Test
    void testToString() {
        assertEquals("User(firstName=Yura, " +
                "lastName=Bodakovskyi, occupations=[UCU, UCU]," +
                " gender=male, age=18, weight=0)", user.toString());
    }
}