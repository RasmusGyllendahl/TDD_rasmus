package com.example.TDD;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class ConversionTests {

    @Test
    void shouldThrowExceptionForNegativeUsd() {
        assertThatTHrownBy(() -> converter.usdToEur(new BigDecimal("-10")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");
    }

}
