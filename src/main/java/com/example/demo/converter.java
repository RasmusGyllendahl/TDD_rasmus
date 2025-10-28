package com.example.demo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class converter {
    public BigDecimal usdToEur(BigDecimal eur) {
        validatePositiveAmount(eur);
        return eur.divide(USD_TO_EUR, 2, RoundingMode.HALF_UP);
    }

    private void validatePositiveAmount(BigDecimal eur) {
        if (eur.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Negative amount not allowed");
        }
    }

    public BigDecimal eurToUsd(BigDecimal eur) {
        validatePositiveAmount(eur);
        return eur.divide(EUR_TO_USD, 2, RoundingMode.HALF_UP);
    }
    


}
