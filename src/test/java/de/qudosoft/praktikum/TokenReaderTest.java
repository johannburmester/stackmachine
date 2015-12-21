package de.qudosoft.praktikum;

import de.qudosoft.praktikum.operators.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Created by jburmester on 14.12.2015.
 */
public class TokenReaderTest {

    @Test
    public void testTokenizeEmptyString() {
        TokenReader reader = new TokenReader();
        List<Object> tokens = reader.tokenize("");
        assertTrue(tokens.isEmpty());
    }
    @Test
    public void testTokenizeSingelSpaceString() {
        TokenReader reader = new TokenReader();
        List<Object> tokens = reader.tokenize(" ");
        assertTrue(tokens.isEmpty());
    }

    @Test
    public void testTokenizeSingleInteger() {
        TokenReader reader = new TokenReader();
        List<Object> tokens = reader.tokenize("23");
        assertEquals(tokens.size(), 1);
        assertEquals(tokens.get(0), 23);
    }

    @Test
    public void testTokenizeSingleIntegerWithLeadingSpaces() {
        TokenReader reader = new TokenReader();
        List<Object> tokens = reader.tokenize("  23");
        assertEquals(tokens.size(), 1);
        assertEquals(tokens.get(0), 23);
    }

    @Test
    public void testTokenizeSingleIntegerWithTrailingSpaces() {
        TokenReader reader = new TokenReader();
        List<Object> tokens = reader.tokenize("23  ");
        assertEquals(tokens.size(), 1);
        assertEquals(tokens.get(0), 23);
    }

    @Test
    public void testTokenizeMultipleIntegers() {
        TokenReader reader = new TokenReader();
        List<Object> tokens = reader.tokenize("23 42");
        assertEquals(tokens.size(), 2);
        assertEquals(tokens.get(0), 23);
        assertEquals(tokens.get(1), 42);
    }

    @Test(dataProvider = "operators")
    public void testTokenizeOperator(String s, Class<StackMachineOperator> clazz) {
        TokenReader reader = new TokenReader();
        List<Object> tokens = reader.tokenize(s);
        assertEquals(tokens.size(), 1);
        assertEquals(tokens.get(0).getClass(), clazz);
    }

    @DataProvider
    private Object[][] operators() {
        return new Object[][] {
                // Arithmetic
                {"+", AdditionOperator.class},
                {"-", SubtractionOperator.class},
                {"*", MultiplyOperator.class},
                {"/", DivOperator.class},
                // Stack manipulations
                {"DUP", DupOperator.class},
                {"DROP", DropOperator.class},
                {"OVER", OverOperator.class},
                {"SWAP", SwapOperator.class},
                // String operations
                // ...
        };
    }

    @Test
    public void testCreateTokenForNumber() {
        TokenReader reader = new TokenReader();
        String s = "23";
        int expected = 23;
        assertEquals(reader.createToken(s), expected);
    }

    @Test(dataProvider =  "operators")
    public void testCreateTokenForOperator(String s, Class<StackMachineOperator> clazz) {
        TokenReader reader = new TokenReader();
        Object token = reader.createToken(s);
        assertEquals(token.getClass(), clazz);
    }

    @Test
    public void testTokenizeString() {
        TokenReader reader = new TokenReader();
        List<Object> tokens = reader.tokenize("\"foo\"");
        assertEquals(tokens.get(0), "foo");
    }

    @Test
    public void testTokenizeEmbeddedOperator() {
        TokenReader reader = new TokenReader();
        List<Object> tokens = reader.tokenize("\"a+c\"");
        assertEquals(tokens.get(0), "a+c");
    }

    @Test(enabled = false)
    public void testInvalidInput() {
        TokenReader reader = new TokenReader();
        List<Object> tokens = reader.tokenize("abc");
    }

}