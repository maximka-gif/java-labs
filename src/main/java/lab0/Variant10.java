package lab0;

public class Variant10 {

    /**
     * @param number трицифрове число
     * @return перша цифра числа (сотні)
     */
    public int getHundredsDigit(int number) {
        return number / 100;
    }

    /**
     * @param A перше число
     * @param B друге число
     * @return true, якщо обидва числа непарні
     */
    public boolean areBothOdd(int A, int B) {
        return A % 2 != 0 && B % 2 != 0;
    }

    /**
     * @param A перше число
     * @param B друге число
     * @return нові значення A та B після перерозподілу
     */
    public double[] swapAndOrder(double A, double B) {
        if (A > B) {
            double temp = A;
            A = B;
            B = temp;
        }
        return new double[]{A, B};
    }

    /**
     * @param D день
     * @param M місяць
     * @return наступна дата
     */
    public int[] nextDate(int D, int M) {
        switch (M) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if (D < 31) return new int[]{D + 1, M};
                return new int[]{1, (M % 12) + 1};
            case 4: case 6: case 9: case 11:
                if (D < 30) return new int[]{D + 1, M};
                return new int[]{1, M + 1};
            case 2:
                if (D < 28) return new int[]{D + 1, M};
                return new int[]{1, M + 1};
            default:
                return new int[]{D, M}; // Невірний місяць
        }
    }

    /**
     * @param A перше число
     * @param B друге число
     * @return сума квадратів чисел від A до B включно
     */
    public int sumOfSquares(int A, int B) {
        int sum = 0;
        for (int i = A; i <= B; i++) {
            sum += i * i;
        }
        return sum;
    }

    /**
     * @param N число
     * @return найбільше K, таке що 3^K < N
     */
    public int largestK(int N) {
        int sum = 0;
        int k = 0;
        while (sum + k + 1 <= N) {
            k++;
            sum += k;
        }
        return k;
    }

    /**
     * @param array масив цілих чисел
     * @return новий масив з парних чисел, потім непарних
     */
    public int[] separateEvenOdd(int[] array) {
        int[] evens = new int[array.length];
        int[] odds = new int[array.length];
        int eIndex = 0, oIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evens[eIndex++] = array[i];
            } else {
                odds[oIndex++] = array[i];
            }
        }
        int[] result = new int[eIndex + oIndex];
        System.arraycopy(evens, 0, result, 0, eIndex);
        for (int i = 0; i < oIndex; i++) {
            result[eIndex + i] = odds[oIndex - i - 1];
        }
        return result;
    }

    /**
     * @param M кількість рядків
     * @param N кількість стовпців
     * @param D додаток
     * @param numbers масив чисел для першого стовпця
     * @return матриця MxN
     */
    public int[][] createMatrix(int M, int N, int D, int[] numbers) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            matrix[i][0] = numbers[i];
            for (int j = 1; j < N; j++) {
                matrix[i][j] = matrix[i][j - 1] + D;
            }
        }
        return matrix;
    }

    public static void main(String... strings) {
        System.out.println("Start of lab0");
        System.out.println("Done!!!");
    }
}
