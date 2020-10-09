package test.lab1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.lab1.ArctgExpansion;


class Task1Test {
    private static final double DELTA = 1e-3;
    private static final double EPSILON = 1e-2;

    @Test
    void testOne() {
        assertEquals(Math.atan(1), ArctgExpansion.expanse(1), DELTA);
    }

    @Test
    void testMinusOne() {
        assertEquals(Math.atan(-1), ArctgExpansion.expanse(-1), DELTA);
    }

    @Test
    void testMinusOnePlusEps() {
        assertEquals(Math.atan(-1 + EPSILON), ArctgExpansion.expanse(-1 + EPSILON), DELTA);
    }

    @Test
    void testOneMinusEps() {
        assertEquals(Math.atan(1 - EPSILON), ArctgExpansion.expanse(1 - EPSILON), DELTA);
    }

    @Test
    void testZero() {
        assertEquals(Math.atan(0), ArctgExpansion.expanse(0), DELTA);
    }

    @Test
    void testZeroPlusEps() {
        assertEquals(Math.atan(0 + EPSILON), ArctgExpansion.expanse(0 + EPSILON), DELTA);
    }

    @Test
    void testZeroMinusEps() {
        assertEquals(Math.atan(0 - EPSILON), ArctgExpansion.expanse(0 - EPSILON), DELTA);
    }

    @Test
    void testOneHalf() {
        assertEquals(Math.atan(0.5), ArctgExpansion.expanse(0.5), DELTA);
    }

    @Test
    void testMinusOneHalf() {
        assertEquals(Math.atan(-0.5), ArctgExpansion.expanse(-0.5), DELTA);
    }

    @Test
    void testOnePlusEps() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ArctgExpansion.expanse(1 + EPSILON);
        });
        String expectedMessage = "abs(x) is greater than 1";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testMinusOneMinusEps() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ArctgExpansion.expanse(-1 - EPSILON);
        });
        String expectedMessage = "abs(x) is greater than 1";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}