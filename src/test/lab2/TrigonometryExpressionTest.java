package test.lab2;

import main.lab2.SinExpansion;
import main.lab2.TrigonometryExpression;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.*;
import static org.mockito.Mockito.*;

public class TrigonometryExpressionTest {
    static final double EPS = 0.0001;
    static final double DELTA = 0.001;

    @BeforeAll
    static void setup() {
        MockedStatic<SinExpansion> mocked = mockStatic(SinExpansion.class);
        mocked.when(() -> SinExpansion.sin(0., EPS)).thenReturn(0.);
        mocked.when(() -> SinExpansion.sin(PI / 6, EPS)).thenReturn(0.5);
        mocked.when(() -> SinExpansion.sin(PI / 4, EPS)).thenReturn(sqrt(2) / 2);
        mocked.when(() -> SinExpansion.sin(PI / 3, EPS)).thenReturn(sqrt(3) / 2);
        mocked.when(() -> SinExpansion.sin(PI / 2, EPS)).thenReturn(1.);
        mocked.when(() -> SinExpansion.sin(PI, EPS)).thenReturn(0.);
        mocked.when(() -> SinExpansion.sin(PI * 5 / 4, EPS)).thenReturn(-sqrt(2) / 2);
        mocked.when(() -> SinExpansion.sin(PI * 3 / 2, EPS)).thenReturn(-1.);
        mocked.when(() -> SinExpansion.sin(PI * 7 / 4, EPS)).thenReturn(-sqrt(2) / 2);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, PI/2, PI, PI*5/4, PI*3/2})
    void testCosNormalValues(double x) {
        assertEquals(Math.cos(x), TrigonometryExpression.cos(x, EPS), EPS);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, PI, PI*5/4})
    void testSecNormalValues(double x) {
        assertEquals(1 / Math.cos(x), TrigonometryExpression.sec(x, EPS), EPS);
    }

    @ParameterizedTest
    @ValueSource(doubles = {PI/6, PI/4, PI/3, PI/2})
    void testSecInvalidValues(double x) {
        assertEquals(Double.NaN, TrigonometryExpression.sec(x, EPS), EPS);
    }

    @ParameterizedTest
    @ValueSource(doubles = {PI/6, PI/4, PI/3, PI/2, PI*5/4, PI*3/2, PI*7/4})
    void testCscNormalValues(double x) {
        assertEquals(1 / Math.sin(x), TrigonometryExpression.csc(x, EPS), EPS);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, PI})
    void testCscInvalidValues(double x) {
        assertEquals(Double.NaN, TrigonometryExpression.csc(x, EPS), EPS);
    }

    @ParameterizedTest
    @ValueSource(doubles = {PI/2, PI*5/4, PI*3/2})
    void testCotNormalValues(double x) {
        assertEquals(Math.cos(x) / Math.sin(x), TrigonometryExpression.cot(x, EPS), EPS);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, PI})
    void testCotInvalidValues(double x) {
        assertEquals(Double.NaN, TrigonometryExpression.cot(x, EPS), EPS);
    }


}
