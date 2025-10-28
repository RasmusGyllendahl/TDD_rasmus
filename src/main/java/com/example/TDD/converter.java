package com.example.TDD;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class converter {

    private static final BigDecimal USD_TO_EUR = BigDecimal.valueOf(0.92);
    private static final BigDecimal EUR_TO_USD = BigDecimal.valueOf(1.17);
    private static final BigDecimal USD_TO_SEK = BigDecimal.valueOf(9.38);
    private static final BigDecimal SEK_TO_USD = BigDecimal.valueOf(0.11);
    private static final BigDecimal EUR_TO_SEK = BigDecimal.valueOf(10.92);
    private static final BigDecimal SEK_TO_EUR = BigDecimal.valueOf(0.092);

    public static BigDecimal usdToEur(BigDecimal usd) {
        validatePositiveAmount(usd);
        return usd.divide(USD_TO_EUR, 2, RoundingMode.HALF_UP);
    }

    private static void validatePositiveAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }

    public static BigDecimal eurToUsd(BigDecimal eur) {
        validatePositiveAmount(eur);
        return eur.multiply(EUR_TO_USD);
    }

    public static BigDecimal usdToSek(BigDecimal usd) {
        validatePositiveAmount(usd);
        return usd.multiply(USD_TO_SEK);
    }

    public static BigDecimal sekToUsd(BigDecimal sek) {
        validatePositiveAmount(sek);
        return sek.divide(SEK_TO_USD, 2, RoundingMode.HALF_UP);
    }

    public static BigDecimal EurToSek(BigDecimal eur) {
        validatePositiveAmount(eur);
        return eur.multiply(EUR_TO_SEK);
    }

    public static BigDecimal sekToEur(BigDecimal sek) {
        validatePositiveAmount(sek);
        return sek.multiply(SEK_TO_EUR);
    }

}
