package lab0;

public class Variant10 {

    /**
     * @param number трицифрове число
     * @return перша цифра числа (сотні)
     */
    public int getHundredsDigit(int number) {
        // Перевірка, чи є число тризначним
        if (number < 100 || number > 999) {
            throw new IllegalArgumentException("Число повинно бути тризначним");
        }
        return number / 100;
    }

    /**
     * @param a перше число
     * @param b друге число
     * @return true, якщо обидва числа непарні
     */
    public boolean areBothOdd(int a, int b) {
        return a % 2 != 0 && b % 2 != 0;
    }

    /**
     * @param a перше число
     * @param b друге число
     * @return нові значення a та b після перерозподілу
     */
    public double[] swapAndOrder(double a, double b) {
        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }
        return new double[]{a, b};
    }

    /**
     * @param d день
     * @param m місяць
     * @return наступна дата
     */
    public int[] nextDate(int d, int m) {
        switch (m) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if (d < 31) return new int[]{d + 1, m};
                return new int[]{1, (m % 12) + 1};
            case 4: case 6: case 9: case 11:
                if (d < 30) return new int[]{d + 1, m};
                return new int[]{1, m + 1};
            case 2:
                if (d < 28) return new int[]{d + 1, m};
                return new int[]{1, m + 1};
            default:
                return new int[]{d, m}; // Невірний місяць
        }
    }

    /**
     * @param a перше число
     * @param b друге число
     * @return сума квадратів чисел від a до b включно
     */
    public int sumOfSquares(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += i * i;
        }
        return sum;
    }

    /**
     * @param n число
     * @return найбільше k, таке що 3^k < n
     */
    public int largestK(int n) {
        int sum = 0;
        int k = 0;
        while (sum + k + 1 <= n) {
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
     * @param m кількість рядків
     * @param n кількість стовпців
     * @param d додаток
     * @param numbers масив чисел для першого стовпця
     * @return матриця mxn
     */
    public int[][] createMatrix(int m, int n, int d, int[] numbers) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i][0] = numbers[i];
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i][j - 1] + d;
            }
        }
        return matrix;
    }
}