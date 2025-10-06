package com.java.katas;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: Rename this class to something more appropriate and write some tests here
public class PensionContributionCalculatorTest {

    @Test
    void shouldThrowIllegalArgumentExceptionWhenSalaryIsZero() {
        assertThrows(IllegalArgumentException.class,
                () -> PensionContributionCalculator.calculatePensionContribution(BigDecimal.ZERO, 5, new MidLevel(), FakePercentages.getStandardValues()));
    }
}