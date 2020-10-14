package test.lab2;

import main.lab2.LogarithmExpression;
import main.lab2.NaturalLogarithmExpansion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LogarithmExpressionTest {
    static final double EPS = 0.0001;
    static final double DELTA = 0.001;

    @BeforeAll
    static void setup() {
        MockedStatic<NaturalLogarithmExpansion> mocked = mockStatic(NaturalLogarithmExpansion.class);
        mocked.when(() -> NaturalLogarithmExpansion.ln(0., EPS)).thenReturn(Double.NaN);
        mocked.when(() -> NaturalLogarithmExpansion.ln(0.4, EPS)).thenReturn(Math.log(0.4));
        mocked.when(() -> NaturalLogarithmExpansion.ln(1., EPS)).thenReturn(Math.log(1));
        mocked.when(() -> NaturalLogarithmExpansion.ln(2., EPS)).thenReturn(Math.log(2));
        mocked.when(() -> NaturalLogarithmExpansion.ln(4., EPS)).thenReturn(Math.log(4));
        mocked.when(() -> NaturalLogarithmExpansion.ln(10., EPS)).thenReturn(Math.log(10));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.4, 1., 2., 10.})
    void testLogTen(double x){
        assertEquals(Math.log10(x), LogarithmExpression.log(x, EPS, 10), DELTA);
    }

    @Test
    void testLogTwo(){
        assertEquals(0, LogarithmExpression.log(1., EPS, 2), DELTA);
        assertEquals(1, LogarithmExpression.log(2., EPS, 2), DELTA);
        assertEquals(2, LogarithmExpression.log(4., EPS, 2), DELTA);
    }

    @Test
    void testLogInvalidValues(){
        assertEquals(Double.NaN, LogarithmExpression.log(2., EPS, 1), DELTA);
    }

}
