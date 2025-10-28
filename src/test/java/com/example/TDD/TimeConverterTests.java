package com.example.TDD;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class TimeConverterTests {

    @Test
    @DisplayName("Should convert 60 seconds to 1 minute")
    void shouldConvert60SecondsTo1Minute() {
        assertThat(timeConverter.secondsToMinutes(60)).isEqualTo(1.0);
    }
    @Test
    void shouldConvert120SecondsTo2Minutes() {
        assertThat(timeConverter.secondsToMinutes(120)).isEqualTo(2.0);
    }
    @Test
    void shouldConvert240SecondsTo4Minutes() {
        assertThat(timeConverter.secondsToMinutes(240)).isEqualTo(4.0);
    }

    @Test
    void shouldThrowExceptionForNegativeSeconds() {
        assertThatThrownBy(() -> timeConverter.secondsToMinutes(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");
    }

    @Test
    void shouldConvert5MinutesTo300Seconds() {
        assertThat(timeConverter.minutesToSeconds(5)).isEqualTo(300.0);
    }

    @Test
    void shouldConvert10MínutesTo600Seconds() {
        assertThat(timeConverter.minutesToSeconds(10)).isEqualTo(600.0);
    }

    @Test
    @DisplayName("Should convert 60 minutes to one hour")
    void shouldConvert60MinutesTo1Hour() {
        assertThat(timeConverter.minutesToHours(60)).isEqualTo(1.0);
    }

    @Test
    void shouldThrowExceptionForNegativeMinutes() {
        assertThatThrownBy(()-> timeConverter.minutesToHours(-10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("negative");
    }

    @Test
    @DisplayName("Should convert 10 hours into 600 minutes")
    void shouldConvert10MinutesTo60Hours() {
        assertThat(timeConverter.hoursToMinutes(10)).isEqualTo(600.0);
    }

    @Test
    @DisplayName("Should convert 72 hours into 3 days")
    void shouldConvert72HoursInto3Days() {
        assertThat(timeConverter.hoursToDays(72)).isEqualTo(3.0);
    }

    @Test
    @DisplayName("Should convert 5 days into 120 hours")
    void shouldConvert5DaysInto120Hours() {
        assertThat(timeConverter.daysToHours(5)).isEqualTo(120.0);
    }


}

