package de.qudosoft.praktikum;

import de.qudosoft.praktikum.operators.AdditionOperator;
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

    @Test
    public void testTokenizeOperator() {
        TokenReader reader = new TokenReader();
        List<Object> tokens = reader.tokenize("*");
        assertEquals(tokens.size(), 1);
        assertEquals(tokens.get(0), new AdditionOperator());
    }

}