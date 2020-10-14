package test.lab2;

import main.lab2.NaturalLogarithmExpansion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NaturalLogarithmExpansionTest {
    final double DELTA = 0.001;
    final double EPS = 0.0001;

    @Test
    void testZero(){
        assertThrows(IllegalArgumentException.class, () -> {
            NaturalLogarithmExpansion.ln(0., DELTA);
        });
    }

    @Test
    void testNearZero(){
        assertEquals(Math.log(0.08), NaturalLogarithmExpansion.ln(0.08, EPS), DELTA);
    }

    @Test
    void testHalf(){
        assertEquals(Math.log(0.5), NaturalLogarithmExpansion.ln(0.5, EPS), DELTA);
    }

    @Test
    void testOne(){
        assertEquals(Math.log(1), NaturalLogarithmExpansion.ln(1., EPS), DELTA);
    }

    @Test
    void testTen(){
        assertEquals(Math.log(10), NaturalLogarithmExpansion.ln(10., EPS), DELTA);
    }

}
