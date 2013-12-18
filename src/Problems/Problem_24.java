package Problems;

import java.util.ArrayList;

public class Problem_24 {
    /* Хитрозадая реализация. Как она работает я понять понимаю, но объяснить не могу))
        Входной список pa должен быть остортирован по возрастанию. Тогда поиск
        элемента с номером findNum будет выполняться в лексикографическом порядке.
        Пусть есть ряд pa{0, 1, 2}, нужно найти 5-й лексикографический элемент.
        Предположительно считаем, что ставим на 1-е место 0. Тогда оставшихся расстановок будет
        (pa.length-1)! = 2. Сравниваем это число с нужным нам элементом. Оно меньше, значит на
        1-м месте не это число. В переменную sum добавляем количество "перебранных" перестановок:
        sum = 2. Берем следующий элемент массива pa и условно ставим его на 1-е место, считаем количество
        комбинаций для оставшихся чисел - это 2 расстановки. плюс предыдущие 2, итого 4.
        Сравниваем с необходимым искомым числом findNum: 4 < 5, значит 1 не на своем месте.
        Суммируем эти 2 перестановки к имеющимся (теперь sum = 4) и ставим на 1-е место 2, считаем
        перестановки для этого варианта. Их по прежнему возможно 2, поэтому аналогично проверка:
        6 > 5, а это уже говорит о том, что 2 будет стоять на 1-м месте и какая-то из перестановок
        с ней на 1-м месте правильная. Поэтому мы добавляем ее в строку ответа и удаляем из
        массива pa.
        Дальше все то же самое повторяем до полного освобождения массива pa.
        P.S. Сходимость я тут понимаю, что есть, но гарантировать не могу)) Поэтому единственное
        что мне пришло в голову как ограничение для сходимости - это если сразу запросили перестановку,
        которая по номеру больше, чем их вообще возможно - сразу шлем нахер.
     */
    public static long solution_1(ArrayList<Integer> pa, int findNum) {
        String ans = "";
        if (functions.factorial(pa.size()) < findNum) { // это если искомый номер больше, чем комбинаций
            return -1;
        }
        int i = 0;
        long sum = 0;
        while ((pa.size() > 0) && (i < pa.size())) {
            long fact = functions.factorial(pa.size()-1);
            if (sum + fact < findNum) {
                sum += fact;
                i++;
            } else {
                ans = ans.concat(pa.get(i).toString());
                pa.remove(i);
                i = 0;
            }
        }
        System.out.println(ans);
        return Long.valueOf(ans);
    }

    public static long rightAnswer() {
        return 2783915460L;
    }

    public static int[][] inputValue() {
        return new int[][] {new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[] {1000000}};
    }
}