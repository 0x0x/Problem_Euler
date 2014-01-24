package test;

import Problems.Problem_28;
import junit.framework.Assert;
import org.junit.Test;

public class testProblem_28 {
    @Test
    public void testSolution_1() {
        long res = Problem_28.solution_1(Problem_28.inputValue());
        Assert.assertTrue(res == Problem_28.rightAnswer());
    }

    @Test
    public void testSolution_1_matrixSize5() {
        long res = Problem_28.solution_1(5);
        Assert.assertTrue(res == 101);
    }
}


/*

Тут немного магии. рассмотрим такую матрицу:
73 74 75 76 77 78 79 80 81
72 43 44 45 46 47 48 49 50
71 42 21 22 23 24 25 26 51
70 41 20  7  8  9 10 27 52
69 40 19  6  1  2 11 28 53
68 39 18  5  4  3 12 29 54
67 38 17 16 15 14 13 30 55
66 37 36 35 34 33 32 31 56
65 64 63 62 61 60 59 58 57

Для северо-западного направления:
Выписываем  элементы диагонали
1, 7, 21, 43
Разница между ними:
-: 6, 14, 22 30
Получаем формулу для расчета элементов:
предыдущий + 6 * 8(i-1).

Аналогично для оставшихся. Нужно только формулу найти
Для северо-восточного направления:
1, 9, 25, 49
-: 8, 16, 24
49 + 8*4 = 49 + 32 = 81
разница между 1-м и 2-м членом * 1, 2, 3 и т. д. + предыдущий член.

Для юго-западного направления:
1 5 17 37
-: 4 12 20
37 + 4*7 = 28+37 = 65
разница между 1-м и 2-м членом * 1, 3, 5, 7 и т.д. + предыдущий член.

Для юго-восточного направления:
1 3 13 31
-: 2 10 18
31 + 2*13 = 31+26 = 57
разница между 1-м и 2-м членом * 1, 5, 9, 13 и т.д. + предыдущий член.

*/