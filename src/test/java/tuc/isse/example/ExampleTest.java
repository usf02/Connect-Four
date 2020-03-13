package tuc.isse.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleTest {
    @Test
    public void testAddition() {
        assertEquals(7, Example.addition(4, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, Example.subtraction(4, 3));
    }
}