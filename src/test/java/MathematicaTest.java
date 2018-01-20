import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
class MathematicaTest {

    @ParameterizedTest
    @MethodSource("multiplyData")
    void multiply(double value1, double value2, double result) {
        assertEquals(result, Mathematica.multiply(value1,value2));
    }

    @ParameterizedTest
    @MethodSource("divisionData")
    void division(int value1, int value2, int result) {
        if (value2 != 0) assertEquals(result, Mathematica.division(value1, value2));
        assertThrows(java.lang.ArithmeticException.class, () -> Mathematica.division(4,0));
    }
    @ParameterizedTest
    @MethodSource("factorialData")
    void factorial(int number, int result) throws Exception {
        assertEquals(result, Mathematica.factorial(number));
    }


    @ParameterizedTest
    @ValueSource(ints = -5)
    void exceptionTest(int value){
        assertThrows(java.lang.ArithmeticException.class, () -> Mathematica.factorial(value));
    }

    @Test
    @Disabled
    void ignoreMe() throws Exception {
        assertEquals(666, Mathematica.factorial(25));
    }

    private static  Stream<Arguments> factorialData(){
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 6),
                Arguments.of(4, 24),
                Arguments.of(0, 1));

    }
    private static Stream<Arguments> divisionData() {
        return Stream.of(
                Arguments.of(4, 2, 2),
                Arguments.of(4, -4, -1),
                Arguments.of(-3, -3, 1),
                Arguments.of(0, 1, 0),
                Arguments.of(3, 2, 1));
    }

    private static Stream<Arguments> multiplyData() {
        return Stream.of(
                Arguments.of(1.0, 2.0, 2.0),
                Arguments.of(4.0, -4.0, -16.0),
                Arguments.of(-3.0, -3.0, 9.0),
                Arguments.of(1.2, 0.0, 0.0),
                Arguments.of(5.0, 0.0, 0.0),
                Arguments.of(1.2, 2.5, 3.0));
    }
    }