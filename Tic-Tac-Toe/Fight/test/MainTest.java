import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testXWins() {
        simpleTest("X wins", "2 2\n2 2\ntwo two\n1 4\n1 1\n3 3\n2 1\n3 1\n2 3\n3 2\n");
    }

    @Test
    public void testAllPossibleMoves() {
        simpleTest("Draw", "1 1\n1 2\n1 3\n2 1\n2 3\n2 2\n3 1\n3 3\n3 2\n");
    }

    @Test
    public void testFirstPlayerWins() {
        simpleTest("X wins", "1 1\n2 1\n1 2\n2 2\n1 3\n");
    }

    @Test
    public void testSecondPlayerWins() {
        simpleTest("O wins", "1 1\n2 1\n1 2\n2 2\n3 3\n2 3\n");
    }

    @Test
    public void testFullBoard() {
        simpleTest("Draw", "1 1\n1 2\n1 3\n2 1\n2 3\n3 3\n2 2\n3 1\n3 2\n");
    }

    private void simpleTest(String expected, String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        Task.main(new String[0]);

        String output = outputStreamCaptor.toString().trim();
        String actual = output.substring(output.lastIndexOf("\n")).trim();
        assertEquals(expected, actual);
    }
}