package atm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private ATM atm;

    @BeforeEach
    void setUp() {
        atm = new ATM();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testProcessWithException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            atm.process(126);
        });
    }

    @Test
    void testProcess() {
        atm.process(125);
        assertEquals("Please receive 1 of 5 UAH bills\n" +
                "Please receive 0 of 10 UAH bills\n" +
                "Please receive 6 of 20 UAH bills", outputStreamCaptor.toString()
                .trim());
    }
}