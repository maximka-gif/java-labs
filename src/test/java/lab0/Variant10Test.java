package lab0;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Variant10Test {

    @ParameterizedTest
    @CsvSource({
            "123, 1",
            "456, 4",
            "789, 7"
    })
    public void getHundredsDigitTest(int number, int expected) {
        assertEquals(expected, new Variant10().getHundredsDigit(number));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 3, true",
            "2, 3, false",
            "5, 6, false"
    })
    public void areBothOddTest(int a, int b, boolean expected) {
        assertEquals(expected, new Variant10().areBothOdd(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 3, 5",
            "2, 2, 2, 2",
            "7, 9, 7, 9"
    })
    public void swapAndOrderTest(double a, double b, double expectedA, double expectedB) {
        double[] result = new Variant10().swapAndOrder(a, b);
        assertEquals(expectedA, result[0]);
        assertEquals(expectedB, result[1]);
    }

    @ParameterizedTest
    @CsvSource({
            "28, 2, 1, 3",
            "30, 4, 1, 5",
            "31, 12, 1, 1" // Тест для переходу на новий рік
    })
    public void nextDateTest(int d, int m, int expectedD, int expectedM) {
        int[] result = new Variant10().nextDate(d, m);
        assertEquals(expectedD, result[0]);
        assertEquals(expectedM, result[1]);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 3, 14",
            "2, 4, 29",
            "3, 5, 50"
    })
    public void sumOfSquaresTest(int a, int b, int expected) {
        assertEquals(expected, new Variant10().sumOfSquares(a, b));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 2",
            "30, 3",
            "80, 4"
    })
    public int largestK(int n) {
        int k = 0;
        while (Math.pow(3, k) < n) {
            k++;
        }
        return k - 1; // Повертаємо найбільше k, де 3^k < N
    }

    @ParameterizedTest
    @MethodSource("separateEvenOddProvider")
    public void separateEvenOddTest(int[] array, int[] expected) {
        assertArrayEquals(expected, new Variant10().separateEvenOdd(array));
    }

    private static Stream<Arguments> separateEvenOddProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{2, 4, 3, 1}),
                Arguments.of(new int[]{5, 6, 7, 8}, new int[]{6, 8, 7, 5}),
                Arguments.of(new int[]{2, 4, 6}, new int[]{2, 4, 6}),
                Arguments.of(new int[]{1, 3, 5}, new int[]{5, 3, 1}),
                Arguments.of(new int[]{}, new int[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("createMatrixProvider")
    public void createMatrixTest(int m, int n, int d, int[] numbers, int[][] expected) {
        assertArrayEquals(expected, new Variant10().createMatrix(m, n, d, numbers));
    }

    private static Stream<Arguments> createMatrixProvider() {
        return Stream.of(
                Arguments.of(2, 3, 2, new int[]{1, 2}, new int[][]{{1, 3, 5}, {2, 4, 6}}),
                Arguments.of(3, 4, 1, new int[]{1, 2, 3}, new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}}),
                Arguments.of(1, 1, 1, new int[]{1}, new int[][]{{1}})
        );
    }
}