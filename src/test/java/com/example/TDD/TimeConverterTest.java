package com.example.TDD;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TimeConverterTest {
    @Test
    @DisplayName("Should convert 60 seconds to 1 minute")
    void shouldConvert60SecondsTo1Minute() {
        assertThat(timeConverter.secondsToMinutes(60)).isEqualTo(1.0);
    }

    @Test
    void shouldThrowExceptionForNegativeSeconds() {
        assertThatThrownBy(() -> timeConverter.secondsToMinutes(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");
    }
}