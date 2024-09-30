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
    public void areBothOddTest(int A, int B, boolean expected) {
        assertEquals(expected, new Variant10().areBothOdd(A, B));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 3, 5",
            "2, 2, 2, 2",
            "7, 9, 7, 9"
    })
    public void swapAndOrderTest(double A, double B, double expectedA, double expectedB) {
        double[] result = new Variant10().swapAndOrder(A, B);
        assertEquals(expectedA, result[0]);
        assertEquals(expectedB, result[1]);
    }

    @ParameterizedTest
    @CsvSource({
            "28, 2, 1, 3",
            "30, 4, 1, 5",
            "31, 12, 1, 1" // Тест для переходу на новий рік
    })
    public void nextDateTest(int D, int M, int expectedD, int expectedM) {
        int[] result = new Variant10().nextDate(D, M);
        assertEquals(expectedD, result[0]);
        assertEquals(expectedM, result[1]);
    }


    @ParameterizedTest
    @CsvSource({
            "1, 3, 14",
            "2, 4, 29",
            "3, 5, 50"
    })
    public void sumOfSquaresTest(int A, int B, int expected) {
        assertEquals(expected, new Variant10().sumOfSquares(A, B));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 4",
            "30, 7",
            "80, 12"
    })
    public void largestKTest(int N, int expected) {
        assertEquals(expected, new Variant10().largestK(N));
    }

    @ParameterizedTest
    @MethodSource("separateEvenOddProvider")
    public void separateEvenOddTest(int[] array, int[] expected) {
        assertArrayEquals(expected, new Variant10().separateEvenOdd(array));
    }

    private static Stream<Arguments> separateEvenOddProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{2, 4, 3, 1}),
                Arguments.of(new int[]{5, 6, 7, 8}, new int[]{6, 8, 7, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("createMatrixProvider")
    public void createMatrixTest(int M, int N, int D, int[] numbers, int[][] expected) {
        assertArrayEquals(expected, new Variant10().createMatrix(M, N, D, numbers));
    }

    private static Stream<Arguments> createMatrixProvider() {
        return Stream.of(
                Arguments.of(2, 3, 2, new int[]{1, 2}, new int[][]{{1, 3, 5}, {2, 4, 6}}),
                Arguments.of(3, 4, 1, new int[]{1, 2, 3}, new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}})
        );
    }
}
