package com.example.TDD;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ConversionTests {

    @Test
    void shouldThrowExceptionForNegativeUsd() {
        assertThatThrownBy(() -> converter.usdToEur(new BigDecimal("-10")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");
    }
    @Test
    void shouldReturn92WhenConvertingFromUsd() {
        assertThat(converter.usdToEur(new BigDecimal("100")))
                .isEqualTo(new BigDecimal("92.00"));
    }

    @Test
    void shouldThrowExceptionForNegativeEur() {
        assertThatThrownBy(()-> converter.eurToUsd(new BigDecimal("-10")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");
    }

    @Test
    void shouldReturn100WhenConvertingFromEur() {
        assertThat(converter.eurToUsd(new BigDecimal("92")))
        .isEqualTo( new BigDecimal("100.00"));
    }

    @Test
    void shouldThrowExceptionForNegativeUsdToSek() {
        assertThatThrownBy(()-> converter.usdToSek(new BigDecimal("-10")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");
    }

    @Test
    void shouldReturn938WhenConvertingFromUsdToSek() {
        assertThat(converter.usdToSek(new BigDecimal("100")))
                .isEqualTo( new BigDecimal("938.00"));
    }

    @Test
    void shouldThrowExceptionForNegativeSekToUsd() {
        assertThatThrownBy(()-> converter.sekToUsd(new BigDecimal("-10")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");
    }

    @Test
    void shouldReturn100WhenConvertingFromSekToUsd() {
        assertThat(converter.sekToUsd(new BigDecimal("938")))
                .isEqualTo( new BigDecimal("100.00"));
    }

    @Test
    void shouldThrowExceptionForNegativeEurToSek() {
        assertThatThrownBy(()-> converter.EurToSek(new BigDecimal("-10")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");
    }

    @Test
    void shouldReturn1092WhenConvertingFromEurToSek() {
        assertThat(converter.EurToSek(new BigDecimal("100")))
                .isEqualTo( new BigDecimal("1092.00"));
    }

    @Test
    void shouldThrowExceptionForNegativeSekToEur() {
        assertThatThrownBy(()-> converter.sekToEur(new BigDecimal("-10")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");
    }

    @Test
    void shouldReturn9WhenConvertingFromSekToEur() {
        assertThat(converter.sekToEur(new BigDecimal("100")))
                .isEqualTo( new BigDecimal("9.16"));
    }

    @Test
    void shouldReturn1004WhenConvertingFromUsdToEurToSek() {
        BigDecimal convertedEur = converter.usdToEur(new BigDecimal("100"));
        BigDecimal convertedSek = converter.EurToSek(convertedEur);
        assertThat(convertedSek).isEqualTo(new BigDecimal("1004.6400"));
    }

    @Test
    void shouldReturn100WhenGoingFromUsdToEurToUsd() {
        BigDecimal convertedEur = converter.usdToEur(new BigDecimal("100"));
        BigDecimal convertedUsd = converter.eurToUsd(convertedEur);
        assertThat(convertedUsd).isEqualTo(new BigDecimal("100.00"));
    }
}
