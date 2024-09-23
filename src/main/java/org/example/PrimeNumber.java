package org.example;

public class PrimeNumber {

    public long isPrime(long number) {
        if (number <= 1) {
            return 0;
        }
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return 0;
            }
        }
        return number;
    }
}

