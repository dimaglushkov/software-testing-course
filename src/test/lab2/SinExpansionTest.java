package test.lab2;

import main.lab2.SinExpansion;
import org.junit.jupiter.api.Test;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

public class SinExpansionTest {
    final double DELTA = 0.001;
    final double EPS = 0.0001;

    @Test
    void testMinusPI(){
        assertEquals(Math.sin(-Math.PI), SinExpansion.sin(-Math.PI, EPS), DELTA);
    }

    @Test
    void testMinusHalfPI(){
        assertEquals(Math.sin(-Math.PI / 2), SinExpansion.sin(-Math.PI / 2, EPS), DELTA);
    }

    @Test
    void testMinusOne(){
        assertEquals(Math.sin(-1), SinExpansion.sin(-1., EPS), DELTA);
    }

    @Test
    void testZero(){
        assertEquals(Math.sin(0), SinExpansion.sin(0., EPS), DELTA);
    }

    @Test
    void testOne(){
        assertEquals(Math.sin(1), SinExpansion.sin(1., EPS), DELTA);
    }

    @Test
    void testHalfPI(){
        assertEquals(Math.sin(Math.PI / 2), SinExpansion.sin(Math.PI / 2, EPS), DELTA);
    }

    @Test
    void testPI(){
        assertEquals(Math.sin(Math.PI), SinExpansion.sin(Math.PI, EPS), DELTA);
    }

    @Test
    void testPiBySix(){
        assertEquals(0.5, SinExpansion.sin(PI / 6, EPS), DELTA);
    }


}
