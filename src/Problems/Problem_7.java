package Problems;

import java.util.ArrayList;

public class Problem_7 {
    public static long solution_1(int numPrimeDigit) {
        ArrayList<Long> primeDigits = new ArrayList<Long>();
        primeDigits.add(primeDigits.size(), 2L);
        long i = 3, j;
        while (primeDigits.size() < numPrimeDigit) {
            j = (long)(0.5*i);
            if ( ((i % 2) == 0)) {
                i++;
                continue;
            }
            boolean cond = true;
            for (int k = 3; k <= j; k++) {
                if ((i % k) == 0) {
                    cond = false;
                    break;
                }
            }
            if (cond) {
                primeDigits.add(i);
            }
            i++;
        }
        System.out.println(primeDigits.get(primeDigits.size()-1));
        return (primeDigits.get(primeDigits.size()-1));
    }

    public static long solution_2(int numPrimeDigit) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        primes.add(primes.size(), 2);
        for (int i = 3; primes.size() < numPrimeDigit; i += 2) {
            if ((i > 10) && ((i % 10) == 5)) {
                continue;
            }
            int n = primes.size();
            boolean cond = false;
            for (int j = 0; j < n; j++) {
                int val = primes.get(j);
                if (((val*val - 1) > i) ) {
                    primes.add(primes.size(), i);
                    cond = true;
                    break;
                }
                if ((i % val) == 0) {
                    cond = true;
                    break;
                }
            }
            if (!cond) {
                primes.add(primes.size(), i);
            }
        }
        System.out.println(primes.get(primes.size()-1));
        return (primes.get(primes.size()-1));
    }

    public static long rightAnswer() {
        return 104743;
    }

    public static int inputValue() {
        return 10001;
    }
}