package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumberTest {
    private PrimeNumber primeNumber;

    @BeforeEach
    void setUp() {
        primeNumber = new PrimeNumber();
    }

    @Test
    void testIsPrime_PrimeNumber() {
        long result = primeNumber.isPrime(7);
        assertEquals(7, result);
    }

    @Test
    void testIsPrime_NonPrimeNumber() {
        long result = primeNumber.isPrime(4);
        assertEquals(0, result);
    }

    @Test
    void testIsPrime_One() {
        long result = primeNumber.isPrime(1);
        assertEquals(0, result);
    }

    @Test
    void testIsPrime_Zero() {
        long result = primeNumber.isPrime(0);
        assertEquals(0, result);
    }

    @Test
    void testIsPrime_NegativeNumber() {
        long result = primeNumber.isPrime(-5);
        assertEquals(0, result);
    }

    @Test
    void testIsPrime_LargePrimeNumber() {
        long result = primeNumber.isPrime(31);
        assertEquals(31, result);
    }

    @Test
    void testIsPrime_LargeNonPrimeNumber() {
        long result = primeNumber.isPrime(100);
        assertEquals(0, result);
    }
}